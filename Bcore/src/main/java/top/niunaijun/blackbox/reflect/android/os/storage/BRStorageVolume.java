package top.niunaijun.blackbox.reflect.android.os.storage;

import java.io.File;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRStorageVolume {
    public static final Reflector REF = Reflector.on("android.os.storage.StorageVolume");

    public static Reflector.FieldWrapper<File> mInternalPath = REF.field("mInternalPath");
    public static Reflector.FieldWrapper<File> mPath = REF.field("mPath");
}
