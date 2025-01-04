package top.niunaijun.blackbox.reflect.android.app;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRActivityTaskManager {
    public static final Reflector REF = Reflector.on("android.app.ActivityTaskManager");

    public static Reflector.FieldWrapper<Object> IActivityTaskManagerSingleton = REF.field("IActivityTaskManagerSingleton");
}
