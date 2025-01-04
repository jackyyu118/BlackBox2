package top.niunaijun.blackbox.reflect.android.view;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIAutoFillManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.view.autofill.IAutoFillManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
