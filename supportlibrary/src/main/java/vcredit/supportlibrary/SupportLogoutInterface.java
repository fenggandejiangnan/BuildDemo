package vcredit.supportlibrary;

import android.app.Activity;

import java.io.Serializable;

/**
 * Created by zew on 17/4/14.
 */
public interface SupportLogoutInterface {
    public void logout();
    public void logout(boolean popups);
    public void startActivity(Activity context, RoutInterface routInterface, String extre);//携带String类型参数跳转
    public void startActivity(Activity context, RoutInterface routInterface, int paramint);//携带int类型参数跳转
    public void startActivity(Activity context, RoutInterface routInterface, String extre, int type);//携带String类型和int类型参数跳转
    public void startActivity(Activity context, RoutInterface routInterface);//无携带参数跳转

    public void startActivityForResult(Activity context, RoutInterface routInterface, int requestcode, String extre);//携带String类型参数有回调跳转
    public void startActivityForResult(Activity context, RoutInterface routInterface, int requestcode);//有回调参数跳转

    public void startActivity(Activity context, RoutInterface routInterface, Serializable object);//携带bean参数跳转
    public void startActivityForResult(Activity context, RoutInterface routInterface, int requestcode, Serializable object);//携带bean参数有回调跳转
    public void startActivityForResult(Activity context, RoutInterface routInterface, int requestcode, int extre);//携带int类型参数有回调跳转
    //信用库跳转
    public void creditAuthJump(Activity activity, String frontId, int isFinish, final int jumpType);
}
