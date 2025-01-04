package top.niunaijun.blackbox.reflect.com.android.internal.os;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIVibratorService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.os.IVibratorService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
