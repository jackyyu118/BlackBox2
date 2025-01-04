package top.niunaijun.blackbox.reflect.android.view;

import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRWindowManagerGlobal {
    public static final Reflector REF = Reflector.on("android.view.WindowManagerGlobal");
    
    public static Reflector.FieldWrapper<IInterface> sWindowManagerService = REF.field("sWindowManagerService");
}
