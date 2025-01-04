package top.niunaijun.blackbox.reflect.android.app;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

/**
 * @author Findger
 * @function
 * @date :2023/10/8 19:57
 **/
public class BRISearchManager {
    public static final Reflector REF = Reflector.on("android.app.ISearchManager");

    public static class Stub {
        public static final Reflector REF = Reflector.on("android.app.ISearchManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
