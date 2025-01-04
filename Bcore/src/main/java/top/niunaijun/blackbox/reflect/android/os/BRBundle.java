package top.niunaijun.blackbox.reflect.android.os;

import android.os.IBinder;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRBundle {
    public static final Reflector REF = Reflector.on("android.os.Bundle");

    public static Reflector.MethodWrapper<IBinder> getIBinder = REF.method("getIBinder", String.class);
    public static Reflector.MethodWrapper<Void> putIBinder = REF.method("putIBinder", String.class, IBinder.class);
}
