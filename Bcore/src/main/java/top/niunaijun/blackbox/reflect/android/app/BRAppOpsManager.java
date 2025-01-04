package top.niunaijun.blackbox.reflect.android.app;

import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRAppOpsManager {
    public static final Reflector REF = Reflector.on("android.app.AppOpsManager");

    public static Reflector.FieldWrapper<IInterface> mService = REF.field("mService");
}
