package vcredit.supportlibrary;

import java.util.Properties;

import vcredit.supportlibrary.router.JMRouteManager;

/**
 * SupportApplication类
 * Created by zew on 17/3/25.
 */
public class SupportApplication extends BaseApplication {
    private static final String TAG = SupportApplication.class.getSimpleName();
    private static SupportApplication application;
    protected volatile SupportLogoutInterface logoutInterface;
    protected Properties propertie;
    public static String channel = "dev";

    @Override
    public void onCreate() {
        application = this;
        super.onCreate();

    }

    /**
     * 当前方法会在 MainActivity.onCreate 方法中启动所以这里需要注意启动顺序
     */
    public void init() {
    }

    /**
     * 返回注销的实现类
     *
     * @return
     */
    public SupportLogoutInterface getLogoutInterface() {
        return logoutInterface;
    }

    public SupportLogoutInterface routerHelper(){
       return getLogoutInterface();
    }

    /**
     * 返回注销的实现类
     *
     * @return
     */
    public void setLogoutInterface(SupportLogoutInterface logoutInterface) {
        this.logoutInterface = logoutInterface;
    }


    public static SupportApplication get() {
        return application;
    }

    @Override
    public int getLevel() {
        return LEVEL_BASE_LIB;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[0];
    }

    @Override
    public void onCreateDelegate() {
        JMRouteManager.get().init();
    }
}
