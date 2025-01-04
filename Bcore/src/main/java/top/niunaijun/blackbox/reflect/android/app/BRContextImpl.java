package top.niunaijun.blackbox.reflect.android.app;

import android.content.Context;
import android.content.pm.PackageManager;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRContextImpl {
    public static final Reflector REF = Reflector.on("android.app.ContextImpl");

    public static Reflector.FieldWrapper<String> mBasePackageName = REF.field("mBasePackageName");
    public static Reflector.FieldWrapper<Object> mPackageInfo = REF.field("mPackageInfo");
    public static Reflector.FieldWrapper<PackageManager> mPackageManager = REF.field("mPackageManager");

    public static Reflector.MethodWrapper<Void> setOuterContext = REF.method("setOuterContext", Context.class);
    public static Reflector.MethodWrapper<Object> getAttributionSource = REF.method("getAttributionSource");
}
