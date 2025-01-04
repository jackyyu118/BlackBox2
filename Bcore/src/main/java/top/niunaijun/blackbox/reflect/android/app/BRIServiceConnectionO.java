package top.niunaijun.blackbox.reflect.android.app;

import android.content.ComponentName;
import android.os.IBinder;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIServiceConnectionO {
    public static final Reflector REF = Reflector.on("android.app.IServiceConnection");

    public static Reflector.MethodWrapper<Void> connected = REF.method("connected", ComponentName.class, IBinder.class, boolean.class);
}
