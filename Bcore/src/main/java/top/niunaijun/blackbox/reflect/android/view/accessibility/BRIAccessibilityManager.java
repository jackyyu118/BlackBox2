package top.niunaijun.blackbox.reflect.android.view.accessibility;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIAccessibilityManager {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.view.accessibility.IAccessibilityManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
