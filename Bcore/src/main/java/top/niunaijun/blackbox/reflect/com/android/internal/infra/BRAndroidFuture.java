package top.niunaijun.blackbox.reflect.com.android.internal.infra;

import android.content.Context;

import top.niunaijun.blackbox.reflect.Reflector;

/**
 * @author Findger
 * @function
 * @date :2023/10/13 18:56
 **/
public class BRAndroidFuture {
    public static final Reflector REF = Reflector.on("com.android.internal.infra.AndroidFuture");
    public static Reflector.MethodWrapper<Boolean> complete = REF.method("complete", Object.class);
    public static Reflector.ConstructorWrapper<Object> ctor = REF.constructor();
}
