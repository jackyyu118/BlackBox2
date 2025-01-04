package top.niunaijun.blackbox.reflect.android.content.pm;

import android.content.pm.PackageParser;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRPackageParserNougat {
    public static final Reflector REF = Reflector.on("android.content.pm.PackageParser");

    public static Reflector.StaticMethodWrapper<Void> collectCertificates = REF.staticMethod("collectCertificates", PackageParser.Package.class, int.class);
}
