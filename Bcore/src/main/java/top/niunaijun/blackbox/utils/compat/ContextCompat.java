package top.niunaijun.blackbox.utils.compat;

import android.content.Context;
import android.content.ContextWrapper;

import top.niunaijun.blackbox.reflect.android.app.BRContextImpl;
import top.niunaijun.blackbox.reflect.android.app.BRContextImplKitkat;
import top.niunaijun.blackbox.reflect.android.content.BRAttributionSource;
import top.niunaijun.blackbox.reflect.android.content.BRAttributionSourceState;
import top.niunaijun.blackbox.reflect.android.content.BRContentResolver;
import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;

/**
 * Created by Milk on 3/31/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class ContextCompat {
    public static final String TAG = "ContextCompat";

    public static void fixAttributionSourceState(Object obj, int uid) {
        Object mAttributionSourceState;
        if (obj != null && BRAttributionSource.mAttributionSourceState != null) {
            mAttributionSourceState = BRAttributionSource.mAttributionSourceState.get(obj);

            BRAttributionSourceState.packageName.set(mAttributionSourceState, BlackBoxCore.getHostPkg());
            BRAttributionSourceState.uid.set(mAttributionSourceState, uid);
            fixAttributionSourceState(BRAttributionSource.getNext.call(obj), uid);
        }
    }

    public static void fix(Context context) {
        try {
            int deep = 0;
            while (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
                deep++;
                if (deep >= 10) {
                    return;
                }
            }

            BRContextImpl.mPackageManager.set(context, null);
            try {
                context.getPackageManager();
            } catch (Throwable e) {
                e.printStackTrace();
            }

            BRContextImpl.mBasePackageName.set(context, BlackBoxCore.getHostPkg());
            BRContextImplKitkat.mOpPackageName.set(context, BlackBoxCore.getHostPkg());
            BRContentResolver.mPackageName.set(context.getContentResolver(), BlackBoxCore.getHostPkg());

            if (BuildCompat.isS()) {
                fixAttributionSourceState(BRContextImpl.getAttributionSource.call(context), BActivityThread.getBUid());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
