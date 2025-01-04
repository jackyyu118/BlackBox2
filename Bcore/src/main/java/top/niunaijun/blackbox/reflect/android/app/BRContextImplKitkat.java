package top.niunaijun.blackbox.reflect.android.app;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRContextImplKitkat {
    public static final Reflector REF = Reflector.on("android.app.ContextImpl");

    public static Reflector.FieldWrapper<String> mOpPackageName = REF.field("mOpPackageName");
}
