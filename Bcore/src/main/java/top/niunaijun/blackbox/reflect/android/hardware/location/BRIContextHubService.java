package top.niunaijun.blackbox.reflect.android.hardware.location;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIContextHubService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.hardware.location.IContextHubService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
