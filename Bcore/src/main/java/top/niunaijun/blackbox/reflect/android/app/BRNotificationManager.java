package top.niunaijun.blackbox.reflect.android.app;

import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRNotificationManager {
    public static final Reflector REF = Reflector.on("android.app.NotificationManager");

    public static Reflector.FieldWrapper<IInterface> sService = REF.field("sService");
    public static Reflector.StaticMethodWrapper<IInterface> getService = REF.staticMethod("getService");
}
