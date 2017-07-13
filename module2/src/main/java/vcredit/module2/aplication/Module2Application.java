package vcredit.module2.aplication;

import com.vcredit.androud.vrouter.annotation.RouteConfig;

import vcredit.supportlibrary.BaseApplication;
import vcredit.supportlibrary.Constants;
import vcredit.supportlibrary.SupportApplication;

/**
 * Created by zew on 17/7/10.
 */
// 指定social组件基本的路由映射表生成的文件包名。
@RouteConfig(pack = Constants.PACK.SOCIAL)
public class Module2Application extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int getLevel() {
        return LEVEL_BIZ;
    }

    @Override
    public Class[] subDelegates() {
        return new Class[] {SupportApplication.class};
    }


    @Override
    public void onCreateDelegate() {

    }
}
