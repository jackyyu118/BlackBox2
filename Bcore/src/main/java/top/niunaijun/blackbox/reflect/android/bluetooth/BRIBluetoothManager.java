package top.niunaijun.blackbox.reflect.android.bluetooth;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIBluetoothManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.bluetooth.IBluetoothManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
