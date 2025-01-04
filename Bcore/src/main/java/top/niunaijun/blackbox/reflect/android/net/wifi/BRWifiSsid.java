package top.niunaijun.blackbox.reflect.android.net.wifi;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRWifiSsid {
    public static final Reflector REF = Reflector.on("android.net.wifi.WifiSsid");

    public static Reflector.StaticMethodWrapper<Object> createFromAsciiEncoded = REF.staticMethod("createFromAsciiEncoded", String.class);
}
