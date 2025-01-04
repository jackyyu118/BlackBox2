package top.niunaijun.blackbox.reflect.android.content;

import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRContentProviderClient {
    public static final Reflector REF = Reflector.on("android.content.ContentProviderClient");

    public static Reflector.FieldWrapper<IInterface> mContentProvider = REF.field("mContentProvider");
}
