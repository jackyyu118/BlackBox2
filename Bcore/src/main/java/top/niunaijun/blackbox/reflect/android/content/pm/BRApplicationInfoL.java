package top.niunaijun.blackbox.reflect.android.content.pm;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRApplicationInfoL {
    public static final Reflector REF = Reflector.on("android.content.pm.ApplicationInfo");

    public static Reflector.FieldWrapper<String> primaryCpuAbi = REF.field("primaryCpuAbi");
    public static Reflector.FieldWrapper<String> scanPublicSourceDir = REF.field("scanPublicSourceDir");
    public static Reflector.FieldWrapper<String> scanSourceDir = REF.field("scanSourceDir");
}
