package top.niunaijun.blackbox.reflect.oem.flyme;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

/**
 * @author Findger
 * @function
 * @date :2023/10/9 12:33
 **/
public class BRIFlymePermissionService {
    public static final Reflector TYPE = Reflector.on("meizu.security.IFlymePermissionService");

    public static class Stub {
        public static final Reflector TYPE = Reflector.on("meizu.security.IFlymePermissionService$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = TYPE.staticMethod("asInterface", IBinder.class);
    }
}
