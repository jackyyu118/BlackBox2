package top.niunaijun.blackbox.reflect.com.android.internal.app;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIAppOpsService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("com.android.internal.app.IAppOpsService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
