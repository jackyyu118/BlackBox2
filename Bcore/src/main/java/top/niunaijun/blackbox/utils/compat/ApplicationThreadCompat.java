package top.niunaijun.blackbox.utils.compat;

import android.os.IBinder;
import android.os.IInterface;

import top.niunaijun.blackbox.reflect.android.app.BRApplicationThreadNative;
import top.niunaijun.blackbox.reflect.android.app.BRIApplicationThread;

public class ApplicationThreadCompat {
    public static IInterface asInterface(IBinder binder) {
        if (BuildCompat.isOreo()) {
            return BRIApplicationThread.Stub.asInterface.call(binder);
        }
        return BRApplicationThreadNative.asInterface.call(binder);
    }
}
