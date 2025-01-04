package top.niunaijun.blackbox.reflect.android.app.job;

import android.content.ComponentName;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRJobInfo {
    public static final Reflector REF = Reflector.on("android.app.job.JobInfo");

    public static Reflector.FieldWrapper<ComponentName> service = REF.field("service");
}
