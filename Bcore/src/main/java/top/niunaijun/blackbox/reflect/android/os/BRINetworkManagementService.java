package top.niunaijun.blackbox.reflect.android.os;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRINetworkManagementService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.os.INetworkManagementService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
