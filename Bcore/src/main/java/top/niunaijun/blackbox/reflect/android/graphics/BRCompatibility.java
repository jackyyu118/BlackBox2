package top.niunaijun.blackbox.reflect.android.graphics;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRCompatibility {
    public static final Reflector REF = Reflector.on("android.graphics.Compatibility");

    public static Reflector.StaticMethodWrapper<Void> setTargetSdkVersion = REF.staticMethod("setTargetSdkVersion", int.class);
}
