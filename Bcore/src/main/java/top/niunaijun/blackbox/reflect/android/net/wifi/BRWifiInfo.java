package top.niunaijun.blackbox.reflect.android.net.wifi;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRWifiInfo {
    public static final Reflector REF = Reflector.on("android.net.wifi.WifiInfo");

    public static Reflector.FieldWrapper<String> mBSSID = REF.field("mBSSID");
    public static Reflector.FieldWrapper<String> mMacAddress = REF.field("mMacAddress");
    public static Reflector.FieldWrapper<Object> mWifiSsid = REF.field("mWifiSsid");
}
