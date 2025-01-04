package top.niunaijun.blackbox.reflect.android.os;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRProcess {
    public static final Reflector REF = Reflector.on("android.os.Process");

    public static Reflector.StaticMethodWrapper<Void> setArgV0 = REF.staticMethod("setArgV0", String.class);
}
