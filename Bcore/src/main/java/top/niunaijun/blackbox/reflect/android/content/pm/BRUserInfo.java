package top.niunaijun.blackbox.reflect.android.content.pm;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRUserInfo {
    public static final Reflector REF = Reflector.on("android.content.pm.UserInfo");

    public static Reflector.ConstructorWrapper<Object> _new = REF.constructor(int.class, String.class, int.class);

    public static Reflector.FieldWrapper<Integer> FLAG_PRIMARY = REF.field("FLAG_PRIMARY");
}
