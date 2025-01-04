package top.niunaijun.blackbox.reflect.android.location.provider;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRProviderProperties {
    public static final Reflector REF = Reflector.on("android.location.provider.ProviderProperties");

    public static Reflector.FieldWrapper<Boolean> mHasNetworkRequirement = REF.field("mHasNetworkRequirement");
    public static Reflector.FieldWrapper<Boolean> mHasCellRequirement = REF.field("mHasCellRequirement");
}
