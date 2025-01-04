package top.niunaijun.blackbox.reflect.android.app;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIApplicationThread {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.app.IApplicationThread$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
