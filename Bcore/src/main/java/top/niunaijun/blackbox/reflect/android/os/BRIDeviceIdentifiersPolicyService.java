package top.niunaijun.blackbox.reflect.android.os;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIDeviceIdentifiersPolicyService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.os.IDeviceIdentifiersPolicyService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
