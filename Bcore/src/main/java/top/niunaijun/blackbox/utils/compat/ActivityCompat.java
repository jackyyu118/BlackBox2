package top.niunaijun.blackbox.utils.compat;


import android.app.Activity;
import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.WindowManager;

import top.niunaijun.blackbox.reflect.android.app.BRActivity;
import top.niunaijun.blackbox.reflect.com.android.internal.BRR;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.utils.ArrayUtils;
import top.niunaijun.blackbox.utils.DrawableUtils;

/**
 * Created by Milk on 3/31/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class ActivityCompat {

    public static void fix(Activity activity) {
        Context baseContext = activity.getBaseContext();
        try {
            TypedArray typedArray = activity.obtainStyledAttributes(ArrayUtils.toInt(BRR.styleable.Window.get()));
            if (typedArray != null) {
                boolean isShowWallpaper = typedArray.getBoolean(BRR.styleable.Window_windowShowWallpaper.get(), false);
                if (isShowWallpaper) {
                    activity.getWindow().setBackgroundDrawable(WallpaperManager.getInstance(activity).getDrawable());
                }

                boolean isFullscreen = typedArray.getBoolean(BRR.styleable.Window_windowFullscreen.get(), false);
                if (isFullscreen) {
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                }
                typedArray.recycle();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = activity.getIntent();
            ApplicationInfo applicationInfo = baseContext.getApplicationInfo();
            PackageManager pm = activity.getPackageManager();
            if (intent != null && activity.isTaskRoot()) {
                try {
                    String label = TaskDescriptionCompat.getTaskDescriptionLabel(
                            BActivityThread.getUserId(), applicationInfo.loadLabel(pm));

                    Bitmap icon = null;
                    Drawable drawable = getActivityIcon(activity);
                    if (drawable != null) {
                        ActivityManager am = (ActivityManager) baseContext.getSystemService(Context.ACTIVITY_SERVICE);
                        int iconSize = am.getLauncherLargeIconSize();
                        icon = DrawableUtils.drawableToBitmap(drawable, iconSize, iconSize);
                    }

                    activity.setTaskDescription(new ActivityManager.TaskDescription(label, icon));
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Drawable getActivityIcon(Activity activity) {
        PackageManager pm = activity.getPackageManager();
        try {
            Drawable icon = pm.getActivityIcon(activity.getComponentName());
            if (icon != null)
                return icon;
        } catch (PackageManager.NameNotFoundException ignore) {
        }

        ApplicationInfo applicationInfo = activity.getApplicationInfo();
        return applicationInfo.loadIcon(pm);
    }
}