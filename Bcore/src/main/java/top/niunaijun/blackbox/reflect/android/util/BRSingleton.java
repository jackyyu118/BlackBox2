package top.niunaijun.blackbox.reflect.android.util;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRSingleton {
    public static final Reflector REF = Reflector.on("android.util.Singleton");

    public static Reflector.FieldWrapper<Object> mInstance = REF.field("mInstance");

    public static Reflector.MethodWrapper<Object> get = REF.method("get");
}
