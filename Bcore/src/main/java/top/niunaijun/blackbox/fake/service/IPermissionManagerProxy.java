package top.niunaijun.blackbox.fake.service;

import android.content.pm.PackageManager;

import top.niunaijun.blackbox.reflect.android.app.BRActivityThread;
import top.niunaijun.blackbox.reflect.android.app.BRApplicationPackageManager;
import top.niunaijun.blackbox.reflect.android.app.BRContextImpl;
import top.niunaijun.blackbox.reflect.android.os.BRServiceManager;
import top.niunaijun.blackbox.reflect.android.permission.BRIPermissionManager;
import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.fake.hook.BinderInvocationStub;
import top.niunaijun.blackbox.fake.service.base.PkgMethodProxy;
import top.niunaijun.blackbox.fake.service.base.ValueMethodProxy;
import top.niunaijun.blackbox.utils.compat.BuildCompat;

/**
 * Created by BlackBox on 2022/3/2.
 */
public class IPermissionManagerProxy extends BinderInvocationStub {
    public static final String TAG = "IPermissionManagerProxy";

    private static final String P = "permissionmgr";

    public IPermissionManagerProxy() {
        super(BRServiceManager.getService.call(P));
    }

    @Override
    protected Object getWho() {
        return BRIPermissionManager.Stub.asInterface.call(BRServiceManager.getService.call(P));
    }

    @Override
    protected void inject(Object baseInvocation, Object proxyInvocation) {
        replaceSystemService("permissionmgr");
        BRActivityThread.sPermissionManager.set(proxyInvocation);

        Object systemContext = BRActivityThread.getSystemContext.call(BlackBoxCore.mainThread());
        PackageManager packageManager = BRContextImpl.mPackageManager.get(systemContext);
        if (packageManager != null) {
            try {
                BRApplicationPackageManager.mPermissionManager.set(packageManager, proxyInvocation);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void onBindMethod() {
        super.onBindMethod();
        addMethodHook(new ValueMethodProxy("addPermissionAsync", true));
        addMethodHook(new ValueMethodProxy("addPermission", true));
        addMethodHook(new ValueMethodProxy("performDexOpt", true));
        addMethodHook(new ValueMethodProxy("performDexOptIfNeeded", false));
        addMethodHook(new ValueMethodProxy("performDexOptSecondary", true));
        addMethodHook(new ValueMethodProxy("addOnPermissionsChangeListener", 0));
        addMethodHook(new ValueMethodProxy("removeOnPermissionsChangeListener", 0));
        addMethodHook(new ValueMethodProxy("checkDeviceIdentifierAccess", false));
        addMethodHook(new PkgMethodProxy("shouldShowRequestPermissionRationale"));
        if (BuildCompat.isOreo()) {
            addMethodHook(new ValueMethodProxy("notifyDexLoad", 0));
            addMethodHook(new ValueMethodProxy("notifyPackageUse", 0));
            addMethodHook(new ValueMethodProxy("setInstantAppCookie", false));
            addMethodHook(new ValueMethodProxy("isInstantApp", false));
        }
    }

    @Override
    public boolean isBadEnv() {
        return false;
    }

}
