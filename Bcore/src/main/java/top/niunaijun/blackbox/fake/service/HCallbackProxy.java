package top.niunaijun.blackbox.fake.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import androidx.annotation.NonNull;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import top.niunaijun.blackbox.reflect.android.app.BRActivityClient;
import top.niunaijun.blackbox.reflect.android.app.BRActivityManagerNative;
import top.niunaijun.blackbox.reflect.android.app.BRActivityThread;
import top.niunaijun.blackbox.reflect.android.app.BRIActivityManager;
import top.niunaijun.blackbox.reflect.android.app.servertransaction.BRClientTransaction;
import top.niunaijun.blackbox.reflect.android.app.servertransaction.BRLaunchActivityItem;
import top.niunaijun.blackbox.reflect.android.os.BRHandler;
import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.fake.hook.IInjectHook;
import top.niunaijun.blackbox.proxy.ProxyManifest;
import top.niunaijun.blackbox.proxy.record.ProxyActivityRecord;
import top.niunaijun.blackbox.utils.Slog;
import top.niunaijun.blackbox.utils.compat.BuildCompat;


/**
 * Created by Milk on 3/31/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class HCallbackProxy implements IInjectHook, Handler.Callback {
    public static final String TAG = "HCallbackStub";
    private Handler.Callback mOtherCallback;
    private AtomicBoolean mBeing = new AtomicBoolean(false);

    private Handler.Callback getHCallback() {
        return BRHandler.mCallback.get(getH());
    }

    private Handler getH() {
        Object currentActivityThread = BlackBoxCore.mainThread();
        return BRActivityThread.mH.get(currentActivityThread);
    }

    @Override
    public void injectHook() {
        mOtherCallback = getHCallback();
        if (mOtherCallback != null && (mOtherCallback == this || mOtherCallback.getClass().getName().equals(this.getClass().getName()))) {
            mOtherCallback = null;
        }
        BRHandler.mCallback.set(getH(),this);
    }

    @Override
    public boolean isBadEnv() {
        Handler.Callback hCallback = getHCallback();
        return hCallback != null && hCallback != this;
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        if (!mBeing.getAndSet(true)) {
            try {
                if (BuildCompat.isPie()) {
                    if (msg.what == BRActivityThread.H.EXECUTE_TRANSACTION.get()) {
                        if (handleLaunchActivity(msg.obj)) {
                            getH().sendMessageAtFrontOfQueue(Message.obtain(msg));
                            return true;
                        }
                    }
                } else {
                    if (msg.what == BRActivityThread.H.LAUNCH_ACTIVITY.get()) {
                        if (handleLaunchActivity(msg.obj)) {
                            getH().sendMessageAtFrontOfQueue(Message.obtain(msg));
                            return true;
                        }
                    }
                }

                if (msg.what == BRActivityThread.H.CREATE_SERVICE.get()) {
                    return handleCreateService(msg.obj);
                }

                if (mOtherCallback != null) {
                    return mOtherCallback.handleMessage(msg);
                }
                return false;
            } finally {
                mBeing.set(false);
            }
        }
        return false;
    }

    private Object getLaunchActivityItem(Object clientTransaction) {
        List<Object> mActivityCallbacks = BRClientTransaction.mActivityCallbacks.get(clientTransaction);

        for (Object obj : mActivityCallbacks) {
            if (BRLaunchActivityItem.REF.getClazz().getName().equals(obj.getClass().getCanonicalName())) {
                return obj;
            }
        }
        return null;
    }

    private boolean handleLaunchActivity(Object client) {
        Object r;
        if (BuildCompat.isPie()) {
            // ClientTransaction
            r = getLaunchActivityItem(client);
        } else {
            // ActivityClientRecord
            r = client;
        }
        if (r == null)
            return false;

        Intent intent;
        IBinder token;
        if (BuildCompat.isPie()) {
            intent = BRLaunchActivityItem.mIntent.get(r);
            token = BRClientTransaction.mActivityToken.get(client);
        } else {
            intent = BRActivityThread.ActivityClientRecord.intent.get(r);
            token = BRActivityThread.ActivityClientRecord.token.get(r);
        }

        if (intent == null)
            return false;

        ProxyActivityRecord stubRecord = ProxyActivityRecord.create(intent);
        ActivityInfo activityInfo = stubRecord.mActivityInfo;
        if (activityInfo != null) {
            if (BActivityThread.getAppConfig() == null) {
                BlackBoxCore.getBActivityManager().restartProcess(activityInfo.packageName, activityInfo.processName, stubRecord.mUserId);

                Intent launchIntentForPackage = BlackBoxCore.getBPackageManager().getLaunchIntentForPackage(activityInfo.packageName, stubRecord.mUserId);
                intent.setExtrasClassLoader(this.getClass().getClassLoader());
                ProxyActivityRecord.saveStub(intent, launchIntentForPackage, stubRecord.mActivityInfo, stubRecord.mActivityRecord, stubRecord.mUserId);
                if (BuildCompat.isPie()) {
                    BRLaunchActivityItem.mIntent.set(r, intent);
                    BRLaunchActivityItem.mInfo.set(r, activityInfo);
                } else {
                    BRActivityThread.ActivityClientRecord.intent.set(r, intent);
                    BRActivityThread.ActivityClientRecord.activityInfo.set(r, activityInfo);
                }
                return true;
            }
            // bind
            if (!BActivityThread.currentActivityThread().isInit()) {
                BActivityThread.currentActivityThread().bindApplication(activityInfo.packageName,
                        activityInfo.processName);
                return true;
            }

            int taskId = BRIActivityManager.getTaskForActivity.call(BRActivityManagerNative.getDefault.call(),token, false);
            BlackBoxCore.getBActivityManager().onActivityCreated(taskId, token, stubRecord.mActivityRecord);

            if (BuildCompat.isS()) {
                Object record = BRActivityThread.getLaunchingActivity.call(BlackBoxCore.mainThread(), token);
                BRActivityThread.ActivityClientRecord.intent.set(record, stubRecord.mTarget);
                BRActivityThread.ActivityClientRecord.activityInfo.set(record, activityInfo);
                BRActivityThread.ActivityClientRecord.packageInfo.set(record, BActivityThread.currentActivityThread().getPackageInfo());
                checkActivityClient();
            } else if (BuildCompat.isPie()) {
                BRLaunchActivityItem.mIntent.set(r, stubRecord.mTarget);
                BRLaunchActivityItem.mInfo.set(r, activityInfo);
            } else {
                BRActivityThread.ActivityClientRecord.intent.set(r, stubRecord.mTarget);
                BRActivityThread.ActivityClientRecord.activityInfo.set(r, activityInfo);
            }
        }
        return false;
    }

    private boolean handleCreateService(Object data) {
        if (BActivityThread.getAppConfig() != null) {
            String appPackageName = BActivityThread.getAppPackageName();
            assert appPackageName != null;

            ServiceInfo serviceInfo = BRActivityThread.CreateServiceData.info.get(data);
            if (!serviceInfo.name.equals(ProxyManifest.getProxyService(BActivityThread.getAppPid()))
                    && !serviceInfo.name.equals(ProxyManifest.getProxyJobService(BActivityThread.getAppPid()))) {
                Slog.d(TAG, "handleCreateService: " + data);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(appPackageName, serviceInfo.name));
                BlackBoxCore.getBActivityManager().startService(intent, null, false, BActivityThread.getUserId());
                return true;
            }
        }
        return false;
    }

    private void checkActivityClient() {
        try {
            Object activityClientController = BRActivityClient.getActivityClientController.call();
            if (!(activityClientController instanceof Proxy)) {
                IActivityClientProxy iActivityClientProxy = new IActivityClientProxy(activityClientController);
                iActivityClientProxy.onlyProxy(true);
                iActivityClientProxy.injectHook();

                Object instance = BRActivityClient.getInstance.call();
                Object o = BRActivityClient.INTERFACE_SINGLETON.get(instance);
                BRActivityClient.ActivityClientControllerSingleton.mKnownInstance.set(o, iActivityClientProxy.getProxyInvocation());
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
