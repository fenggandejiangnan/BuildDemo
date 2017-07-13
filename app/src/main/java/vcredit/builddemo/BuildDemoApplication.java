package vcredit.builddemo;

import android.content.Context;
import android.content.res.Configuration;

import com.vcredit.androud.vrouter.annotation.RouteConfig;

import vcredit.module1.application.ModuleApplication;
import vcredit.module2.aplication.Module2Application;
import vcredit.rout.LogoutUtils;
import vcredit.supportlibrary.SupportApplication;

/**
 * Created by zew on 17/7/9.
 */
@RouteConfig(schema = "vcredit",pack = "com.vredit.creditcat")
public class BuildDemoApplication extends SupportApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        super.logoutInterface = new LogoutUtils();

        // 添加route规则创建器

//        VRouter.addRouteCreator(new RouteInit());
//        VRouter.addRouteCreator(new RouterRuleCreator());
//        VRouter.setGlobalRouteInterceptor(new RouteInterceptor() {
//
//            @Override
//            public boolean intercept(Uri uri, RouteBundleExtras extras, Context context) {
//                return !DataManager.INSTANCE.isLogin();
//            }
//
//            @Override
//            public void onIntercepted(Uri uri, RouteBundleExtras extras, Context context) {
//               Toast.makeText(BuildDemoApplication.this,"未登录.请先登录",Toast.LENGTH_LONG).show();
//                Intent loginIntent = new Intent(context,OtherActivity.class);
//                loginIntent.putExtra("uri",uri);
//                loginIntent.putExtra("extras",extras);
//                context.startActivity(loginIntent);
//            }
//        });

        // 对Router设置Activity Route Callback,作辅助功能
//        VRouter.setGlobalRouteCallback(new RouteCallback() {
//
//            @Override
//            public void notFound(Uri uri, NotFoundException e) {
//                Toast.makeText(BuildDemoApplication.this,e.getNotFoundName() + " not find",Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onOpenSuccess(Uri uri, RouteRule rule) {
//                // 可在此进行route追踪
//                Toast.makeText(BuildDemoApplication.this, String.format("Launch routing task %s success", rule.getRuleClz()), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onOpenFailed(Uri uri, Throwable e) {
//                Toast.makeText(BuildDemoApplication.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    class RouteInit implements RouteCreator {
//
//        @Override
//        public Map<String, ActivityRouteRule> createActivityRouteRules() {
//            Map<String,ActivityRouteRule> routes = new HashMap<>();
//            routes.put("jumei://main",
//                    new ActivityRouteRule(MainActivity.class)
//                            .addParam("price", RouteRule.FLOAT)
//                            .addParam("bookName", RouteRule.STRING)
//                            .addParam("books", RouteRule.STRING_LIST)
//                            .addParam("prices", RouteRule.INT_LIST)
//            );
//            return routes;
//        }
//
//        @Override
//        public Map<String, ActionRouteRule> createActionRouteRules() {
//            Map<String, ActionRouteRule> routes = new HashMap<>();
////            routes.put("haoge://action/support", new ActionRouteRule(SayHelloAction.class));
//            return routes;
//        }
    }

    @Override
    public int getLevel() {
        return LEVEL_APP;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[]{ModuleApplication.class, Module2Application.class};
    }

    @Override
    public void onCreateDelegate() {

    }

    @Override
    public void attachBaseContextDelegate(Context base) {}

    @Override
    public void onTerminateDelegate() {}

    @Override
    public void onConfigurationChangedDelegate(Configuration newConfig) {}

    @Override
    public void onLowMemoryDelegate() {}

    @Override
    public void onTrimMemoryDelegate(int level) {}
}
