package top.niunaijun.blackbox.reflect.android.permission;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIPermissionManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.permission.IPermissionManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
