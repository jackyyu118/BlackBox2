package top.niunaijun.blackbox.reflect.android.content;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRContentResolver {
    public static final Reflector REF = Reflector.on("android.content.ContentResolver");

    public static Reflector.FieldWrapper<String> mPackageName = REF.field("mPackageName");
}
