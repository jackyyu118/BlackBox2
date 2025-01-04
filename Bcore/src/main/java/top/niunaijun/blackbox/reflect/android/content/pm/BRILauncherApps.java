package top.niunaijun.blackbox.reflect.android.content.pm;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRILauncherApps {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.content.pm.ILauncherApps$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
