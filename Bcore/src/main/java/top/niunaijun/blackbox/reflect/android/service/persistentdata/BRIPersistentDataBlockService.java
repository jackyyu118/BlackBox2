package top.niunaijun.blackbox.reflect.android.service.persistentdata;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIPersistentDataBlockService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.service.persistentdata.IPersistentDataBlockService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
