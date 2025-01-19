package top.niunaijun.blackbox.closecode;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.configuration.AppLifecycleCallback;

//closecode目录是为了方便整合不开源的java代码，方便大家开发自己私人需求功能,.gitignore已经忽略本目录
public class Entry {
    private static Application sApplication;
    private static Context sAppContext;
    private static Activity sMainActivity;
    private static String TAG = Entry.class.getSimpleName();
    public static void attach(){
        BlackBoxCore.get().addAppLifecycleCallback(new AppLifecycleCallback(){
            @Override
            public void beforeMainApplicationAttach(Application app, Context context) {
                sApplication = app;
                sAppContext = context;
            }

            @Override
            public void afterMainActivityOnCreate(Activity activity) {
                sMainActivity = activity;
            }

            @Override
            public void beforeMainLaunchApk(String packageName, int userid) {
            }
        });
    }

    public static Application getMainApplication(){
        return sApplication;
    }

    public static Context getMainContext(){
        return sAppContext;
    }

    public static Activity getMainActivity(){return sMainActivity;}
}
