package top.niunaijun.blackboxa.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import top.niunaijun.blackbox.BlackBoxCore

/**
 *
 * @Description:
 * @Author: wukaicheng
 * @CreateDate: 2021/4/29 21:21
 */
class App : Application() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private lateinit var mContext: Context

        @JvmStatic
        fun getContext(): Context {
            return mContext
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        BlackBoxCore.get().closeCodeInit();

        BlackBoxCore.get().onBeforeMainApplicationAttach(this,base);

        mContext = base!!
        AppManager.doAttachBaseContext(base)

        BlackBoxCore.get().onAfterMainApplicationAttach(this,base);
    }

    override fun onCreate() {
        super.onCreate()
        AppManager.doOnCreate(mContext)
    }
}