package top.niunaijun.blackbox.reflect.android.app;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRNotificationChannel {
    public static final Reflector REF = Reflector.on("android.app.NotificationChannel");

    public static Reflector.FieldWrapper<String> mId = REF.field("mId");
}
