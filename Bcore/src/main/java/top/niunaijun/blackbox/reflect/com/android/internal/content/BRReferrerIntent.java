package top.niunaijun.blackbox.reflect.com.android.internal.content;

import android.content.Intent;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRReferrerIntent {
    public static final Reflector REF = Reflector.on("com.android.internal.content.ReferrerIntent");

    public static Reflector.ConstructorWrapper<Intent> _new = REF.constructor(Intent.class, String.class);
}
