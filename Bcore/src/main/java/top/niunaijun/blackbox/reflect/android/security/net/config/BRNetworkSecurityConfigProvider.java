package top.niunaijun.blackbox.reflect.android.security.net.config;

import android.content.Context;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRNetworkSecurityConfigProvider {
    public static final Reflector REF = Reflector.on("android.security.net.config.NetworkSecurityConfigProvider");

    public static Reflector.StaticMethodWrapper<Void> install = REF.staticMethod("install", Context.class);
}
