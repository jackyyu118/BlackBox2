package top.niunaijun.blackbox.fake.service;

import java.lang.reflect.Method;
import java.util.List;

import top.niunaijun.blackbox.reflect.com.android.internal.net.BRVpnConfig;
import top.niunaijun.blackbox.reflect.com.android.internal.net.BRVpnConfig;
import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.fake.hook.MethodHook;
import top.niunaijun.blackbox.fake.hook.ProxyMethod;
import top.niunaijun.blackbox.proxy.ProxyVpnService;
import top.niunaijun.blackbox.utils.MethodParameterUtils;

/**
 * Created by BlackBox on 2022/2/26.
 */
public class VpnCommonProxy {
    @ProxyMethod("setVpnPackageAuthorization")
    public static class setVpnPackageAuthorization extends MethodHook {

        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            MethodParameterUtils.replaceFirstAppPkg(args);
            return method.invoke(who, args);
        }
    }

    @ProxyMethod("prepareVpn")
    public static class PrepareVpn extends MethodHook {

        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            MethodParameterUtils.replaceFirstAppPkg(args);
            return method.invoke(who, args);
        }
    }

    @ProxyMethod("establishVpn")
    public static class establishVpn extends MethodHook {

        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            BRVpnConfig.user.set(args[0], ProxyVpnService.class.getName());

            handlePackage(BRVpnConfig.allowedApplications.get());
            handlePackage(BRVpnConfig.disallowedApplications.get());
            return method.invoke(who, args);
        }

        private void handlePackage(List<String> applications) {
            if (applications == null)
                return;
            if (applications.contains(BActivityThread.getAppPackageName())) {
                applications.add(BlackBoxCore.getHostPkg());
            }
        }
    }

}
