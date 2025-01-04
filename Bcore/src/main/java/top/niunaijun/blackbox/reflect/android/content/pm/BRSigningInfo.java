package top.niunaijun.blackbox.reflect.android.content.pm;

import android.content.pm.PackageParser.SigningDetails;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRSigningInfo {
    public static final Reflector REF = Reflector.on("android.content.pm.SigningInfo");

    public static Reflector.ConstructorWrapper<android.content.pm.SigningInfo> _new = REF.constructor(SigningDetails.class);
}
