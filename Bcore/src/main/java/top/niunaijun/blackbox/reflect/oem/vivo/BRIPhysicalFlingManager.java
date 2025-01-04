package top.niunaijun.blackbox.reflect.oem.vivo;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.Reflector;

/**
 * @author Findger
 * @function
 * @date :2023/10/8 20:12
 **/
public class BRIPhysicalFlingManager {
    public static final Reflector TYPE = Reflector.on("vivo.app.physicalfling.IPhysicalFlingManager");

    public static class Stub {
        public static final Reflector TYPE = Reflector.on("vivo.app.physicalfling.IPhysicalFlingManager$Stub");
        public static Reflector.StaticMethodWrapper<IInterface> asInterface = TYPE.staticMethod("asInterface", IBinder.class);
    }
}
