package top.niunaijun.blackbox.reflect.android.app.servertransaction;

import android.os.IBinder;

import java.util.List;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRClientTransaction {
    public static final Reflector REF = Reflector.on("android.app.servertransaction.ClientTransaction");

    public static Reflector.FieldWrapper<List<Object>> mActivityCallbacks = REF.field("mActivityCallbacks");
    public static Reflector.FieldWrapper<IBinder> mActivityToken = REF.field("mActivityToken");
}
