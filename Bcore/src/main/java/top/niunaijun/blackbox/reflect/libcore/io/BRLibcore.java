package top.niunaijun.blackbox.reflect.libcore.io;

import top.niunaijun.blackbox.reflect.Reflector;

public class BRLibcore {
    public static final Reflector REF = Reflector.on("libcore.io.Libcore");

    public static Reflector.FieldWrapper<Object> os = REF.field("os");
}
