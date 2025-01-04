package top.niunaijun.blackbox.reflect.android.os.storage;

import android.os.storage.StorageVolume;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRStorageManager {
    public static final Reflector REF = Reflector.on("android.os.storage.StorageManager");

    public static Reflector.StaticMethodWrapper<StorageVolume[]> getVolumeList = REF.staticMethod("getVolumeList", int.class, int.class);
}
