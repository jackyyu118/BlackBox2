package top.niunaijun.blackbox.fake.service;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.util.Log;

import java.lang.reflect.Method;

import top.niunaijun.blackbox.reflect.android.net.wifi.BRIWifiManager;
import top.niunaijun.blackbox.reflect.android.net.wifi.BRWifiInfo;
import top.niunaijun.blackbox.reflect.android.net.wifi.BRWifiSsid;
import top.niunaijun.blackbox.reflect.android.os.BRServiceManager;
import top.niunaijun.blackbox.fake.hook.BinderInvocationStub;
import top.niunaijun.blackbox.fake.hook.MethodHook;
import top.niunaijun.blackbox.fake.hook.ProxyMethod;

/**
 * Created by Milk on 4/12/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class IWifiManagerProxy extends BinderInvocationStub {
    public static final String TAG = "IWifiManagerProxy";

    public IWifiManagerProxy() {
        super(BRServiceManager.getService.call(Context.WIFI_SERVICE));
    }

    @Override
    protected Object getWho() {
        return BRIWifiManager.Stub.asInterface.call(BRServiceManager.getService.call(Context.WIFI_SERVICE));
    }

    @Override
    protected void inject(Object baseInvocation, Object proxyInvocation) {
        replaceSystemService(Context.WIFI_SERVICE);
    }

    @Override
    public boolean isBadEnv() {
        return false;
    }

    @ProxyMethod("getConnectionInfo")
    public static class GetConnectionInfo extends MethodHook {
        /*
        * It doesn't have public method to set BSSID and SSID fields in WifiInfo class,
        * So the reflection framework invocation appeared.
        * commented by BlackBoxing at 2022/03/08
        * */
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            WifiInfo wifiInfo = (WifiInfo) method.invoke(who, args);
            BRWifiInfo.mBSSID.set(wifiInfo,"ac:62:5a:82:65:c4");
            BRWifiInfo.mMacAddress.set(wifiInfo,"ac:62:5a:82:65:c4");
            BRWifiInfo.mWifiSsid.set(wifiInfo,BRWifiSsid.createFromAsciiEncoded.call("BlackBox_Wifi"));
            return wifiInfo;
        }

        public static String intIP2StringIP(int ip) {
            return (ip & 0xFF) + "." +
                    ((ip >> 8) & 0xFF) + "." +
                    ((ip >> 16) & 0xFF) + "." +
                    (ip >> 24 & 0xFF);
        }

        public static int ip2Int(String ipString) {
            // 取 ip 的各段
            String[] ipSlices = ipString.split("\\.");
            int rs = 0;
            for (int i = 0; i < ipSlices.length; i++) {
                // 将 ip 的每一段解析为 int，并根据位置左移 8 位
                int intSlice = Integer.parseInt(ipSlices[i]) << 8 * i;
                // 或运算
                rs = rs | intSlice;
            }
            return rs;
        }
    }
}
