package top.niunaijun.blackbox.reflect.android.content;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIContentService {
    public static class Stub {
        public static final Reflector REF = Reflector.on("android.content.IContentService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
    }
}
