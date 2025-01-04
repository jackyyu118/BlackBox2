package top.niunaijun.blackbox.reflect.android.os.storage;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIStorageManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.os.storage.IStorageManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
