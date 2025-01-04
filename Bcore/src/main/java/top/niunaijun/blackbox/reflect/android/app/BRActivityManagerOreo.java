package top.niunaijun.blackbox.reflect.android.app;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRActivityManagerOreo {
    public static final Reflector REF = Reflector.on("android.app.ActivityManager");

    public static Reflector.FieldWrapper<Object> IActivityManagerSingleton = REF.field("IActivityManagerSingleton");
}
