package top.niunaijun.blackbox.reflect.com.android.internal.net;

import java.util.List;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRVpnConfig {
    public static final Reflector REF = Reflector.on("com.android.internal.net.VpnConfig");

    public static Reflector.FieldWrapper<String> user = REF.field("user");
    public static Reflector.FieldWrapper<List<String>> disallowedApplications = REF.field("disallowedApplications");
    public static Reflector.FieldWrapper<List<String>> allowedApplications = REF.field("allowedApplications");
}
