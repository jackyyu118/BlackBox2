package top.niunaijun.blackbox.utils.compat;

import top.niunaijun.blackbox.reflect.android.os.BRStrictMode;

public class StrictModeCompat {
    public static int DETECT_VM_FILE_URI_EXPOSURE = BRStrictMode.DETECT_VM_FILE_URI_EXPOSURE.get() == null ?
            (0x20 << 8) : BRStrictMode.DETECT_VM_FILE_URI_EXPOSURE.get();

    public static int PENALTY_DEATH_ON_FILE_URI_EXPOSURE = BRStrictMode.PENALTY_DEATH_ON_FILE_URI_EXPOSURE.get() == null ?
            (0x04 << 24) : BRStrictMode.PENALTY_DEATH_ON_FILE_URI_EXPOSURE.get();

    public static boolean disableDeathOnFileUriExposure(){
        try {
            BRStrictMode.disableDeathOnFileUriExposure.call();
            return true;
        } catch (Throwable e) {
            try {
                int sVmPolicyMask = BRStrictMode.sVmPolicyMask.get();
                sVmPolicyMask &= ~(DETECT_VM_FILE_URI_EXPOSURE | PENALTY_DEATH_ON_FILE_URI_EXPOSURE);
                BRStrictMode.sVmPolicyMask.set(sVmPolicyMask);
                return true;
            } catch (Throwable e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
