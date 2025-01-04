package top.niunaijun.blackbox.fake.service;


import top.niunaijun.blackbox.reflect.android.os.BRServiceManager;
import top.niunaijun.blackbox.reflect.android.view.BRIAutoFillManager;
import top.niunaijun.blackbox.fake.hook.BinderInvocationStub;

/**
 * @author Findger
 * @function
 * @date :2022/4/2 21:59
 **/
public class ISystemUpdateProxy extends BinderInvocationStub {
    public ISystemUpdateProxy() {
        super(BRServiceManager.getService.call("system_update"));
    }

    @Override
    protected Object getWho() {
        return BRIAutoFillManager.Stub.asInterface.call(BRServiceManager.getService.call("system_update"));
    }

    @Override
    protected void inject(Object baseInvocation, Object proxyInvocation) {
        replaceSystemService("system_update");
    }

    @Override
    public boolean isBadEnv() {
        return false;
    }
}
