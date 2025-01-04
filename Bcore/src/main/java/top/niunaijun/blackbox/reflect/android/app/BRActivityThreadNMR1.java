package top.niunaijun.blackbox.reflect.android.app;

import android.os.IBinder;

import java.util.List;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRActivityThreadNMR1 {
    public static final Reflector REF = Reflector.on("android.app.ActivityThread");

    public static Reflector.MethodWrapper<Void> performNewIntents = REF.method("performNewIntents", IBinder.class, List.class, boolean.class);
}
