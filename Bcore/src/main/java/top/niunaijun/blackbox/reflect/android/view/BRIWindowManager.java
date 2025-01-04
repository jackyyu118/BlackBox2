package top.niunaijun.blackbox.reflect.android.view;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIWindowManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.view.IWindowManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
