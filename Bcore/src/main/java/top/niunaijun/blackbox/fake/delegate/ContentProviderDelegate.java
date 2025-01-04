package top.niunaijun.blackbox.fake.delegate;

import android.net.Uri;
import android.os.Build;
import android.os.IInterface;
import android.util.ArrayMap;

import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

import top.niunaijun.blackbox.reflect.android.app.BRActivityThread;
import top.niunaijun.blackbox.reflect.android.app.BRIActivityManager;
import top.niunaijun.blackbox.reflect.android.content.BRContentProviderHolderOreo;
import top.niunaijun.blackbox.reflect.android.providers.BRSettings;
import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.fake.service.context.providers.ContentProviderStub;
import top.niunaijun.blackbox.fake.service.context.providers.SystemProviderStub;
import top.niunaijun.blackbox.utils.compat.BuildCompat;

/**
 * Created by Milk on 3/31/21.
 * * ∧＿∧
 * (`･ω･∥
 * 丶　つ０
 * しーＪ
 * 此处无Bug
 */
public class ContentProviderDelegate {
    public static final String TAG = "ContentProviderDelegate";
    private static final Set<String> sInjected = new HashSet<>();

    public static void update(Object holder, String auth) {
        IInterface iInterface;
        if (BuildCompat.isOreo()) {
            iInterface = BRContentProviderHolderOreo.provider.get(holder);
        } else {
            iInterface = BRIActivityManager.ContentProviderHolder.provider.get(holder);
        }

        if (iInterface instanceof Proxy) {
            return;
        }

        IInterface bContentProvider;
        switch (auth) {
            case "media":
            case "telephony":
            case "settings":
                bContentProvider = new SystemProviderStub().wrapper(iInterface, BlackBoxCore.getHostPkg());
                break;
            default:
                bContentProvider = new ContentProviderStub().wrapper(iInterface, BlackBoxCore.getHostPkg());
                break;
        }

        if (BuildCompat.isOreo()) {
            BRContentProviderHolderOreo.provider.set(holder, bContentProvider);
        } else {
            BRIActivityManager.ContentProviderHolder.provider.set(holder, bContentProvider);
        }
    }

    public static void init() {
        clearSettingProvider();

        BlackBoxCore.getContext().getContentResolver().call(Uri.parse("content://settings"), "", null, null);
        Object activityThread = BlackBoxCore.mainThread();
        ArrayMap<Object, Object> map = (ArrayMap<Object, Object>) BRActivityThread.mProviderMap.get(activityThread);

        for (Object value : map.values()) {
            String[] mNames = BRActivityThread.ProviderClientRecordP.mNames.get(value);
            if (mNames == null || mNames.length <= 0) {
                continue;
            }

            String providerName = mNames[0];
            if (!sInjected.contains(providerName)) {
                sInjected.add(providerName);
                IInterface iInterface = BRActivityThread.ProviderClientRecordP.mProvider.get(value);
                BRActivityThread.ProviderClientRecordP.mProvider.set(value, new ContentProviderStub().wrapper(iInterface, BlackBoxCore.getHostPkg()));
                BRActivityThread.ProviderClientRecordP.mNames.set(value, new String[]{providerName});
            }
        }
    }

    public static void clearSettingProvider() {
        Object cache;
        cache = BRSettings.System.sNameValueCache.get();
        if (cache != null) {
            clearContentProvider(cache);
        }

        cache = BRSettings.Secure.sNameValueCache.get();
        if (cache != null) {
            clearContentProvider(cache);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            cache = BRSettings.Global.sNameValueCache.get();
            if (cache != null) {
                clearContentProvider(cache);
            }
        }
    }

    private static void clearContentProvider(Object cache) {
        if (BuildCompat.isOreo()) {
            Object holder = BRSettings.NameValueCacheOreo.mProviderHolder.get(cache);
            if (holder != null) {
                BRSettings.ContentProviderHolder.mContentProvider.set(holder, null);
            }
        } else {
            BRSettings.NameValueCache.mContentProvider.set(cache, null);
        }
    }
}
