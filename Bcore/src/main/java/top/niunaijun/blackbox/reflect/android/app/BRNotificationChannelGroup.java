package top.niunaijun.blackbox.reflect.android.app;

import java.util.List;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRNotificationChannelGroup {
    public static final Reflector REF = Reflector.on("android.app.NotificationChannelGroup");

    public static Reflector.FieldWrapper<List<android.app.NotificationChannel>> mChannels = REF.field("mChannels");
    public static Reflector.FieldWrapper<String> mId = REF.field("mId");
}
