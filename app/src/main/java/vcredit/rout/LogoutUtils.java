package vcredit.rout;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

import vcredit.supportlibrary.Constants;
import vcredit.supportlibrary.RoutInterface;
import vcredit.supportlibrary.SupportLogoutInterface;

/**
 * 由于耦合的问题所以这个地方抽象一个借口出来然后把当前的这个类实例化到 application 里面所以这个地方需要处理回调请到 application基类里面查找
 * <p>
 * Created by zew on 17/4/14.
 */
public class LogoutUtils implements SupportLogoutInterface {

    /**
     * 无携带参数跳转
     *
     * @param context
     * @param routInterface
     */
    @Override
    public void startActivity(Activity context, RoutInterface routInterface) {
        startActivity(context, routInterface, null);
    }


    @Override
    public void logout() {

    }

    @Override
    public void logout(boolean popups) {

    }

    /**
     * 携带String类型参数跳转
     *
     * @param context
     * @param routInterface
     * @param extre
     */
    @Override
    public void startActivity(Activity context, RoutInterface routInterface, String extre) {
        if (RoutInfo.map.containsKey(routInterface.getClazzType())) {
            Intent intent = new Intent(context, RoutInfo.map.get(routInterface.getClazzType()));
            if (extre != null) {
                intent.putExtra(Constants.DATA_STRING, extre);
            }
            context.startActivity(intent);
        }

    }

    /**
     * 携带int类型参数跳转
     *
     * @param context
     * @param routInterface
     */
    @Override
    public void startActivity(Activity context, RoutInterface routInterface, int paramint) {
        if (RoutInfo.map.containsKey(routInterface.getClazzType())) {
            Intent intent = new Intent(context, RoutInfo.map.get(routInterface.getClazzType()));
            intent.putExtra(Constants.DATA_INT, paramint);
            context.startActivity(intent);
        }
    }

    /**
     * 携带String类型与int类型参数跳转
     *
     * @param context
     * @param routInterface
     * @param extre
     */
    @Override
    public void startActivity(Activity context, RoutInterface routInterface, String extre, int type) {
        if (RoutInfo.map.containsKey(routInterface.getClazzType())) {
            Intent intent = new Intent(context, RoutInfo.map.get(routInterface.getClazzType()));
            if (extre != null) {
                intent.putExtra(Constants.DATA_STRING, extre);
            }
            intent.putExtra(Constants.DATA_INT, type);
            context.startActivity(intent);
        }

    }


    /**
     * 携带bean参数跳转
     *
     * @param context
     * @param routInterface
     * @param obj
     */
    @Override
    public void startActivity(Activity context, RoutInterface routInterface, Serializable obj) {
        if (RoutInfo.map.containsKey(routInterface.getClazzType())) {
            Intent intent = new Intent(context, RoutInfo.map.get(routInterface.getClazzType()));
            if (obj != null) {
                intent.putExtra(Constants.DATA_BEAN, obj);
            }
            context.startActivity(intent);
        }

    }

    /**
     * 携带bean参数有回调跳转
     *
     * @param context
     * @param routInterface
     * @param requestcode
     * @param object
     */
    @Override
    public void startActivityForResult(Activity context, RoutInterface routInterface, int requestcode, Serializable object) {
        if (RoutInfo.map.containsKey(routInterface.getClazzType())) {
            Intent intent = new Intent(context, RoutInfo.map.get(routInterface.getClazzType()));
            if (object != null) {
                intent.putExtra(Constants.DATA_BEAN, object);
            }
            context.startActivityForResult(intent, requestcode);
        }
    }
    /**
     * 携带String类型参数有回调跳转
     *
     * @param context
     * @param routInterface
     * @param requestcode
     * @param extre
     */
    @Override
    public void startActivityForResult(Activity context, RoutInterface routInterface, int requestcode, String extre) {
        if (RoutInfo.map.containsKey(routInterface.getClazzType())) {
            Intent intent = new Intent(context, RoutInfo.map.get(routInterface.getClazzType()));
            if (extre != null) {
                intent.putExtra(Constants.DATA_STRING, extre);
            }
            context.startActivityForResult(intent, requestcode);
        }
    }

    /**
     * 携带int类型参数有回调跳转
     *
     * @param activity
     * @param routInterface
     * @param requestcode
     * @param extre
     */
    @Override
    public void startActivityForResult(Activity activity, RoutInterface routInterface, int requestcode, int extre) {
        if (RoutInfo.map.containsKey(routInterface.getClazzType())) {
            Intent intent = new Intent(activity, RoutInfo.map.get(routInterface.getClazzType()));
            intent.putExtra(Constants.DATA_INT, extre);
            activity.startActivityForResult(intent, requestcode);
        }
    }

    @Override
    public void creditAuthJump(Activity activity, String frontId, int isFinish, int jumpType) {

    }

    /**
     * 有回调参数跳转
     *
     * @param context
     * @param routInterface
     * @param requestcode
     */
    @Override
    public void startActivityForResult(Activity context, RoutInterface routInterface, int requestcode) {
        startActivityForResult(context, routInterface, requestcode, null);
    }

    /**
     * 启动退出线程
     */
    private void startLogout() {
    }

}
