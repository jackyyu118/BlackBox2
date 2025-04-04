package top.niunaijun.blackbox.core;


import android.os.Process;
import android.util.Log;

import androidx.annotation.Keep;

import java.io.File;
import java.util.List;

import dalvik.system.DexFile;
import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.utils.compat.DexFileCompat;

import static top.niunaijun.blackbox.core.env.BEnvironment.EMPTY_JAR;

/**
 * Created by Milk on 4/9/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class NativeCore {
    public static final String TAG = "NativeCore";

    static {
        new File("");
        System.loadLibrary("blackbox");
    }

    public static native void init(int apiLevel);

    public static native void enableIO();

    public static native void addIORule(String targetPath, String relocatePath);

    public static native void hideXposed();

    public static native boolean disableHiddenApi();

    public static void dumpDex(ClassLoader classLoader, String packageName) {
        List<Long> cookies = DexFileCompat.getCookies(classLoader);
        for (Long cookie : cookies) {
            if (cookie == 0)
                continue;
//            File file = new File(BlackBoxCore.get().getDexDumpDir(), packageName);
//            FileUtils.mkdirs(file);
//            dumpDex(cookie, file.getAbsolutePath());
        }
    }

    //这个函数有bug，BActivityThread.getCallingBUid();返回的是启动这个app时候的启动者uid
    //但是getCallingUid是hook处理Binder.getCallingUid()，App里面的Binder不完全是启动者调用且做检查的时候就可能出问题
    //所以有些需要做特殊处理
    @Keep
    public static int getCallingUid(int origCallingUid) {
        // 系统uid
        if (origCallingUid > 0 && origCallingUid < Process.FIRST_APPLICATION_UID)
            return origCallingUid;
        // 非用户应用
        if (origCallingUid > Process.LAST_APPLICATION_UID)
            return origCallingUid;

        if (origCallingUid == BlackBoxCore.getHostUid()) {
//            Log.d(TAG, "origCallingUid: " + origCallingUid + " => " + BActivityThread.getCallingBUid());
            //microG
            if(BActivityThread.getAppPackageName().equals("com.google.android.gms")){
                return Process.ROOT_UID;
            }
            //webview WV.qE Process.myUid()函数没有做hook所以只能特殊处理
            //if (Binder.getCallingUid() == Process.myUid()) {
            //throw new SecurityException("recordMetrics() may only be called by non-embedded WebView processes");
            if(BActivityThread.getAppPackageName().equals("com.google.android.webview")){
                return Process.myUid();
            }
            return BActivityThread.getCallingBUid();
//            return BActivityThread.getBUid();
        }
        return origCallingUid;
    }

    @Keep
    public static String redirectPath(String path) {
        return IOCore.get().redirectPath(path);
    }

    @Keep
    public static File redirectPath(File path) {
        return IOCore.get().redirectPath(path);
    }

    @Keep
    public static long[] loadEmptyDex() {
        try {
            DexFile dexFile = new DexFile(EMPTY_JAR);
            List<Long> cookies = DexFileCompat.getCookies(dexFile);
            long[] longs = new long[cookies.size()];
            for (int i = 0; i < cookies.size(); i++) {
                longs[i] = cookies.get(i);
            }
            return longs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new long[]{};
    }
}
