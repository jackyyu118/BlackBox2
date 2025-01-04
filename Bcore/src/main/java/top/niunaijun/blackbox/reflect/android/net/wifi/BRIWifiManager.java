package top.niunaijun.blackbox.reflect.android.net.wifi;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIWifiManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.net.wifi.IWifiManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
