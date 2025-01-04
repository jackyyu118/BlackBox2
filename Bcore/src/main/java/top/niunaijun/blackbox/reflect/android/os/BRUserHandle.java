package top.niunaijun.blackbox.reflect.android.os;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRUserHandle {
    public static final Reflector REF = Reflector.on("android.os.UserHandle");

    public static Reflector.StaticMethodWrapper<Integer> myUserId = REF.staticMethod("myUserId");
}
