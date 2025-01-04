package top.niunaijun.blackbox.reflect.android.app;

import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRApplicationPackageManager {
    public static final Reflector REF = Reflector.on("android.app.ApplicationPackageManager");

    public static Reflector.FieldWrapper<IInterface> mPM = REF.field("mPM");
    public static Reflector.FieldWrapper<Object> mPermissionManager = REF.field("mPermissionManager");
}
