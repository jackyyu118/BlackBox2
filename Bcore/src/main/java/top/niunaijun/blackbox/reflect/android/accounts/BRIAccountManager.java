package top.niunaijun.blackbox.reflect.android.accounts;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIAccountManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.accounts.IAccountManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
