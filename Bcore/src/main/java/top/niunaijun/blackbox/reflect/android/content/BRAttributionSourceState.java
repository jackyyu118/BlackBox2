package top.niunaijun.blackbox.reflect.android.content;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRAttributionSourceState {
    public static final Reflector REF = Reflector.on("android.content.AttributionSourceState");

    public static Reflector.FieldWrapper<String> packageName = REF.field("packageName");
    public static Reflector.FieldWrapper<Integer> uid = REF.field("uid");
}
