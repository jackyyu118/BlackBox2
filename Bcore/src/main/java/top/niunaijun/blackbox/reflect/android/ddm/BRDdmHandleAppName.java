package top.niunaijun.blackbox.reflect.android.ddm;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRDdmHandleAppName {
    public static final Reflector REF = Reflector.on("android.ddm.DdmHandleAppName");

    public static Reflector.StaticMethodWrapper<Void> setAppName = REF.staticMethod("setAppName", String.class, int.class);
}
