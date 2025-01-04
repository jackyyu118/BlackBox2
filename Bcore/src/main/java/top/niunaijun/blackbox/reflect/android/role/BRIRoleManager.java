package top.niunaijun.blackbox.reflect.android.role;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

/**
 * @author Findger
 * @function
 * @date :2023/10/8 19:48
 **/
public class BRIRoleManager {
    public static final Reflector TYPE = Reflector.on("android.app.role.IRoleManager");

    public static class Stub {
        public static final Reflector TYPE = Reflector.on("android.app.role.IRoleManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = TYPE.staticMethod("asInterface", IBinder.class);
    }
}
