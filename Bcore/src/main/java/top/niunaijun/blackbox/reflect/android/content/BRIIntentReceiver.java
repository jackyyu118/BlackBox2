package top.niunaijun.blackbox.reflect.android.content;

import android.content.Intent;
import android.os.Bundle;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRIIntentReceiver {
    public static final Reflector REF = Reflector.on("android.content.IIntentReceiver");

    public static Reflector.MethodWrapper<Void> performReceive = REF.method("performReceive", Intent.class, int.class, String.class, Bundle.class, boolean.class, boolean.class, int.class);
}
