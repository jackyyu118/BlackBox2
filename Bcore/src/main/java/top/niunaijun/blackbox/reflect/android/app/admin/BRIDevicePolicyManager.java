package top.niunaijun.blackbox.reflect.android.app.admin;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIDevicePolicyManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.app.admin.IDevicePolicyManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
