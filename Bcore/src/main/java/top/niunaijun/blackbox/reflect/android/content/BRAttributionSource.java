package top.niunaijun.blackbox.reflect.android.content;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRAttributionSource {
    public static final Reflector REF = Reflector.on("android.content.AttributionSource");

    public static Reflector.FieldWrapper<Object> mAttributionSourceState = REF.field("mAttributionSourceState");

    public static Reflector.MethodWrapper<Object> getNext = REF.method("getNext");
}
