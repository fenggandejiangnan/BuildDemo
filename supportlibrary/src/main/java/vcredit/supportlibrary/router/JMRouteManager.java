package vcredit.supportlibrary.router;

import android.net.Uri;
import android.util.Log;

import com.vcredit.android.vrouter.VRouter;
import com.vcredit.android.vrouter.exception.NotFoundException;
import com.vcredit.android.vrouter.module.RouteCreator;
import com.vcredit.android.vrouter.module.RouteRule;
import com.vcredit.android.vrouter.rout.RouteCallback;

import vcredit.supportlibrary.Constants;


/**
 * 对Router框架做二次封装。利于在组件化环境下方便使用：
 * @see <a href="Router">https://github.com/yjfnypeu/Router</a>
 */
public class JMRouteManager {
    private static final String TAG = JMRouteManager.class.getSimpleName();
    private static JMRouteManager manager = new JMRouteManager();
    public static JMRouteManager get() {
        return manager;
    }

    private boolean inited = false;

    public void init () {
        if (inited) {
            return;
        }
        inited = true;

        loadRouteRulesIfExist();

        initRouteBaseConfig();
    }


    private void initRouteBaseConfig() {
        VRouter.setGlobalRouteCallback(new RouteCallback() {
            @Override
            public void notFound(Uri uri, NotFoundException e) {
                Log.e(TAG,"open url with " + uri + "failed.not found");
                e.printStackTrace();
            }

            @Override
            public void onOpenSuccess(Uri uri, RouteRule rule) {
                Log.d(TAG,"open url with " + uri + "successful, claName=" + rule.getRuleClz());
            }

            @Override
            public void onOpenFailed(Uri uri, Throwable e) {
                Log.d(TAG,"open url with " + uri + "failed," + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    /**
     * 通过反射加载通过Router框架生成的路由映射表。此处会加载各个组件中通过运行时注解生成的路由表
     */
    private void loadRouteRulesIfExist() {
        String[] packs = Constants.PACK.Packages;
        String clzNameRouteRules = ".RouterRuleCreator";
        for (String pack : packs) {
            try {
                Class<?> creator = Class.forName(pack + clzNameRouteRules);
                RouteCreator instance = (RouteCreator) creator.newInstance();
                VRouter.addRouteCreator(instance);
            } catch (Exception ignore) {
            }
        }
    }
}
