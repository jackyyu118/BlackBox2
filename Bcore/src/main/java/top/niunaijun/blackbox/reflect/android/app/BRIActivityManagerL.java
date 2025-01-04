package top.niunaijun.blackbox.reflect.android.app;

import android.content.Intent;
import android.os.IBinder;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIActivityManagerL {
    public static final Reflector REF = Reflector.on("android.app.IActivityManager");

    public static Reflector.MethodWrapper<Boolean> finishActivity = REF.method("finishActivity", IBinder.class, int.class, Intent.class, boolean.class);
}
