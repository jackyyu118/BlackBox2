package top.niunaijun.blackbox.reflect.android.content;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRContentProviderNative {
    public static final Reflector REF = Reflector.on("android.content.ContentProviderNative");

    public static Reflector.StaticMethodWrapper<IInterface> asInterface = REF.staticMethod("asInterface", IBinder.class);
}
