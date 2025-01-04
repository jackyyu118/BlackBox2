package top.niunaijun.blackbox.reflect.com.android.internal.appwidget;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIAppWidgetService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("com.android.internal.appwidget.IAppWidgetService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
