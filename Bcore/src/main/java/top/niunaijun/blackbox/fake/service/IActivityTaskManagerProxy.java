package top.niunaijun.blackbox.fake.service;

import android.app.ActivityManager;

import java.lang.reflect.Method;

import top.niunaijun.blackbox.reflect.android.app.BRActivityTaskManager;
import top.niunaijun.blackbox.reflect.android.app.BRIActivityTaskManager;
import top.niunaijun.blackbox.reflect.android.os.BRServiceManager;
import top.niunaijun.blackbox.reflect.android.util.BRSingleton;
import top.niunaijun.blackbox.fake.hook.BinderInvocationStub;
import top.niunaijun.blackbox.fake.hook.MethodHook;
import top.niunaijun.blackbox.fake.hook.ProxyMethod;
import top.niunaijun.blackbox.fake.hook.ScanClass;
import top.niunaijun.blackbox.utils.compat.TaskDescriptionCompat;

/**
 * Created by Milk on 3/31/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
@ScanClass(ActivityManagerCommonProxy.class)
public class IActivityTaskManagerProxy extends BinderInvocationStub {
    public static final String TAG = "ActivityTaskManager";

    public IActivityTaskManagerProxy() {
        super(BRServiceManager.getService.call("activity_task"));
    }

    @Override
    protected Object getWho() {
        return BRIActivityTaskManager.Stub.asInterface.call(BRServiceManager.getService.call("activity_task"));
    }

    @Override
    protected void inject(Object baseInvocation, Object proxyInvocation) {
        replaceSystemService("activity_task");

        Object o = BRActivityTaskManager.IActivityTaskManagerSingleton.get();
        BRSingleton.mInstance.set(o, BRIActivityTaskManager.Stub.asInterface.call(this));
    }

    @Override
    public boolean isBadEnv() {
        return false;
    }

    // for >= Android 10 && < Android 12
    @ProxyMethod("setTaskDescription")
    public static class SetTaskDescription extends MethodHook {
        @Override
        protected Object hook(Object who, Method method, Object[] args) throws Throwable {
            ActivityManager.TaskDescription td = (ActivityManager.TaskDescription) args[1];
            args[1] = TaskDescriptionCompat.fix(td);
            return method.invoke(who, args);
        }
    }
}
