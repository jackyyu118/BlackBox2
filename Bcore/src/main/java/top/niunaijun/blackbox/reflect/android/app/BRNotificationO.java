package top.niunaijun.blackbox.reflect.android.app;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRNotificationO {
    public static final Reflector REF = Reflector.on("android.app.Notification");

    public static Reflector.FieldWrapper<String> mChannelId = REF.field("mChannelId");
    public static Reflector.FieldWrapper<String> mGroupKey = REF.field("mGroupKey");
}
