package top.niunaijun.blackbox.reflect.android.content.res;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRAssetManager {
    public static final Reflector REF = Reflector.on("android.content.res.AssetManager");

    public static Reflector.ConstructorWrapper<android.content.res.AssetManager> _new = REF.constructor();

    public static Reflector.MethodWrapper<Integer> addAssetPath = REF.method("addAssetPath", String.class);
}
