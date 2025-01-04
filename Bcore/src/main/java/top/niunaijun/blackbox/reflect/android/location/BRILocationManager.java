package top.niunaijun.blackbox.reflect.android.location;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRILocationManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.location.ILocationManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
