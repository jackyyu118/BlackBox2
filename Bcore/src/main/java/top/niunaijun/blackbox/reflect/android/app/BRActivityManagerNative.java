package top.niunaijun.blackbox.reflect.android.app;

import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRActivityManagerNative {
    public static final Reflector REF = Reflector.on("android.app.ActivityManagerNative");

    public static Reflector.FieldWrapper<Object> gDefault = REF.field("gDefault");

    public static Reflector.StaticMethodWrapper<IInterface> getDefault = REF.staticMethod("getDefault");
}
