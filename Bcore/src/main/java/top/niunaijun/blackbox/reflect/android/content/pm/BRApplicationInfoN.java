package top.niunaijun.blackbox.reflect.android.content.pm;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRApplicationInfoN {
    public static final Reflector REF = Reflector.on("android.content.pm.ApplicationInfo");

    public static Reflector.FieldWrapper<String> credentialEncryptedDataDir = REF.field("credentialEncryptedDataDir");
    public static Reflector.FieldWrapper<String> credentialProtectedDataDir = REF.field("credentialProtectedDataDir");
    public static Reflector.FieldWrapper<String> deviceProtectedDataDir = REF.field("deviceProtectedDataDir");
}
