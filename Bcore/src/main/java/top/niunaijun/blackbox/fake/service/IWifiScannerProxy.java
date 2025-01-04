package top.niunaijun.blackbox.fake.service;

import android.content.Context;
import android.os.IBinder;

import top.niunaijun.blackbox.reflect.android.net.wifi.BRIWifiManager;
import top.niunaijun.blackbox.reflect.android.os.BRServiceManager;
import top.niunaijun.blackbox.fake.hook.BinderInvocationStub;

/**
 * @author Findger
 * @function
 * @date :2022/4/3 13:05
 **/
public class IWifiScannerProxy extends BinderInvocationStub {

    public IWifiScannerProxy() {
        super(BRServiceManager.getService.call("wifiscanner"));
    }

    @Override
    protected Object getWho() {
        return BRIWifiManager.Stub.asInterface.call(BRServiceManager.getService.call("wifiscanner"));
    }

    @Override
    protected void inject(Object baseInvocation, Object proxyInvocation) {
        replaceSystemService("wifiscanner");
    }

    @Override
    public boolean isBadEnv() {
        return false;
    }
}
