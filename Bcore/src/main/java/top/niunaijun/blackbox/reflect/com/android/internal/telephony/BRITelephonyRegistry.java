package top.niunaijun.blackbox.reflect.com.android.internal.telephony;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRITelephonyRegistry {
    public static class Stub {
        public static final Reflector REF = Reflector.on("com.android.internal.telephony.ITelephonyRegistry$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
