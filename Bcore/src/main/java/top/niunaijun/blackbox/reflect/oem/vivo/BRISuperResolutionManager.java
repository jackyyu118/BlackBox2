package top.niunaijun.blackbox.reflect.oem.vivo;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

/**
 * @author Findger
 * @function
 * @date :2023/10/8 20:27
 **/
public class BRISuperResolutionManager {
    public static final Reflector TYPE = Reflector.on("vivo.app.superresolution.ISuperResolutionManager");

    public static class Stub {
        public static final Reflector TYPE = Reflector.on("vivo.app.superresolution.ISuperResolutionManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = TYPE.staticMethod("asInterface", IBinder.class);
    }
}
