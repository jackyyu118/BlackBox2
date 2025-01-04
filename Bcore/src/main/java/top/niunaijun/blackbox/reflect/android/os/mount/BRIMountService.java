package top.niunaijun.blackbox.reflect.android.os.mount;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIMountService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.os.storage.IMountService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
