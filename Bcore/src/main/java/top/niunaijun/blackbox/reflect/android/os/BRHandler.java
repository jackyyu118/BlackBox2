package top.niunaijun.blackbox.reflect.android.os;

import android.os.Handler.Callback;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRHandler {
    public static final Reflector REF = Reflector.on("android.os.Handler");

    public static Reflector.FieldWrapper<Callback> mCallback = REF.field("mCallback");
}
