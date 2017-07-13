package vcredit.supportlibrary;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import vcredit.supportlibrary.delegate.ApplicationDelegate;
import vcredit.supportlibrary.delegate.ApplicationDispatcher;

/**
 * Created by zew on 17/7/11.
 */
public abstract class BaseApplication extends Application implements ApplicationDelegate {
    @Override
    public  void onCreate() {
        super.onCreate();
        ApplicationDispatcher.get().performCreate();
    }

    @Override
    protected final void attachBaseContext(Context base) {
        ApplicationDispatcher.get().init(this);
        ApplicationDispatcher.get().link(this);
        ApplicationDispatcher.get().performAttachBaseContext(base);
        super.attachBaseContext(base);
    }

    @Override
    public final void onTerminate() {
        ApplicationDispatcher.get().performTerminal();
        super.onTerminate();
    }

    @Override
    public final void onConfigurationChanged(Configuration newConfig) {
        ApplicationDispatcher.get().performConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public final void onLowMemory() {
        ApplicationDispatcher.get().performLowMemory();
        super.onLowMemory();
    }

    @Override
    public final void onTrimMemory(int level) {
        ApplicationDispatcher.get().performTrimMemory(level);
        super.onTrimMemory(level);
    }

    @Override
    public Context getApplicationContext() {
        return ApplicationDispatcher.get().getApplicationContext();
    }

    @Override
    public void attachBaseContextDelegate(Context base) {
        Log.d(getClass().getCanonicalName(),"attachBaseContextDelegate invoked!");
    }

    @Override
    public void onTerminateDelegate() {
        Log.d(getClass().getCanonicalName(),"onTerminateDelegate invoked!");
    }

    @Override
    public void onConfigurationChangedDelegate(Configuration newConfig) {
        Log.d(getClass().getCanonicalName(),"onConfigurationChangedDelegate invoked!");
    }

    @Override
    public void onLowMemoryDelegate() {
        Log.d(getClass().getCanonicalName(),"onLowMemoryDelegate invoked!");
    }

    @Override
    public void onTrimMemoryDelegate(int level) {
        Log.d(getClass().getCanonicalName(),"onTrimMemoryDelegate invoked!");
    }

}
