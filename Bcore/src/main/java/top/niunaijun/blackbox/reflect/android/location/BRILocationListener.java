package top.niunaijun.blackbox.reflect.android.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRILocationListener {
    public static final Reflector REF = Reflector.on("android.location.ILocationListener");

    public static Reflector.MethodWrapper<Void> onLocationChanged = REF.method("onLocationChanged", Location.class);

    public static class Stub {
        public static final Reflector REF = Reflector.on("android.location.ILocationListener$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
