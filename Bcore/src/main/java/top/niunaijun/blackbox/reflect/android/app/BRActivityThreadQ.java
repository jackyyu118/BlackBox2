package top.niunaijun.blackbox.reflect.android.app;

import android.os.IBinder;

import java.util.List;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRActivityThreadQ {
    public static final Reflector REF = Reflector.on("android.app.ActivityThread");

    public static Reflector.MethodWrapper<Void> handleNewIntent = REF.method("handleNewIntent", IBinder.class, List.class);
}
