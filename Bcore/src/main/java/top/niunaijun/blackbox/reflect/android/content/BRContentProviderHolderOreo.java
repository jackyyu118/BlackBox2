package top.niunaijun.blackbox.reflect.android.content;

import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRContentProviderHolderOreo {
    public static final Reflector REF = Reflector.on("android.app.ContentProviderHolder");

    public static Reflector.FieldWrapper<IInterface> provider = REF.field("provider");
}
