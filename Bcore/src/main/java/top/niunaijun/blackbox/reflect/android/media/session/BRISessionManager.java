package top.niunaijun.blackbox.reflect.android.media.session;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRISessionManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.media.session.ISessionManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
