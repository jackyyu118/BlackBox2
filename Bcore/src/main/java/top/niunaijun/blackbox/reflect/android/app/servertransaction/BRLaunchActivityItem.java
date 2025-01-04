package top.niunaijun.blackbox.reflect.android.app.servertransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRLaunchActivityItem {
    public static final Reflector REF = Reflector.on("android.app.servertransaction.LaunchActivityItem");

    public static Reflector.FieldWrapper<ActivityInfo> mInfo = REF.field("mInfo");
    public static Reflector.FieldWrapper<Intent> mIntent = REF.field("mIntent");
}
