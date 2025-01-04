package top.niunaijun.blackbox.reflect.android.app;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRApplicationThreadNative {
    public static final Reflector REF = Reflector.on("android.app.ApplicationThreadNative");

    public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
}
