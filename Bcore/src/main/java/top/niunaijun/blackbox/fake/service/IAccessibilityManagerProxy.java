package top.niunaijun.blackbox.fake.service;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import java.lang.reflect.Method;

import top.niunaijun.blackbox.reflect.android.os.BRServiceManager;
import top.niunaijun.blackbox.reflect.android.view.accessibility.BRIAccessibilityManager;
import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.core.system.user.BUserHandle;
import top.niunaijun.blackbox.fake.hook.BinderInvocationStub;
import top.niunaijun.blackbox.fake.hook.MethodHook;
import top.niunaijun.blackbox.fake.hook.ProxyMethods;

/**
 * Created by Milk on 4/25/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class IAccessibilityManagerProxy extends BinderInvocationStub {

    public IAccessibilityManagerProxy() {
        super(BRServiceManager.getService.call(Context.ACCESSIBILITY_SERVICE));
    }

    @Override
    protected Object getWho() {
        return BRIAccessibilityManager.Stub.asInterface.call(BRServiceManager.getService.call(Context.ACCESSIBILITY_SERVICE));
    }

    @Override
    protected void inject(Object baseInvocation, Object proxyInvocation) {
        replaceSystemService(Context.ACCESSIBILITY_SERVICE);
    }

    @Override
    public boolean isBadEnv() {
        return false;
    }

    @ProxyMethods({"interrupt", "sendAccessibilityEvent", "addClient",
            "getInstalledAccessibilityServiceList", "getEnabledAccessibilityServiceList",
            "addAccessibilityInteractionConnection", "getWindowToken"})
    public static class ReplaceUserId extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            if (args != null) {
                int index = args.length - 1;
                Object arg = args[index];
                if (arg instanceof Integer) {
                    ApplicationInfo applicationInfo = BlackBoxCore.getContext().getApplicationInfo();
                    args[index] = BUserHandle.getUserId(applicationInfo.uid);
                }
            }
            return method.invoke(who, args);
        }
    }
}
