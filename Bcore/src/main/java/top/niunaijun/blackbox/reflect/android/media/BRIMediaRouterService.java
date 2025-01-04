package top.niunaijun.blackbox.reflect.android.media;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIMediaRouterService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.media.IMediaRouterService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
