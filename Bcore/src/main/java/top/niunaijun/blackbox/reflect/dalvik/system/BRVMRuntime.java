package top.niunaijun.blackbox.reflect.dalvik.system;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRVMRuntime {
    public static final Reflector REF = Reflector.on("dalvik.system.VMRuntime");

    public static Reflector.StaticMethodWrapper<Object> getRuntime = REF.staticMethod("getRuntime");
    public static Reflector.MethodWrapper<Void> setTargetSdkVersion = REF.method("setTargetSdkVersion", int.class);
}
