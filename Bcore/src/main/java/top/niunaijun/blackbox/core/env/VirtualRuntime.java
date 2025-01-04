package top.niunaijun.blackbox.core.env;

import android.content.pm.ApplicationInfo;

import top.niunaijun.blackbox.reflect.android.ddm.BRDdmHandleAppName;
import top.niunaijun.blackbox.reflect.android.os.BRProcess;

public class VirtualRuntime {

    private static String sInitialPackageName;
    private static String sProcessName;

    public static String getProcessName() {
        return sProcessName;
    }

    public static String getInitialPackageName() {
        return sInitialPackageName;
    }

    public static void setupRuntime(String processName, ApplicationInfo appInfo) {
        if (sProcessName != null) {
            return;
        }
        sInitialPackageName = appInfo.packageName;
        sProcessName = processName;
        BRProcess.setArgV0.call(processName);
        BRDdmHandleAppName.setAppName.call(processName, 0);
    }
}
