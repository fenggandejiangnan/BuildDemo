package vcredit.rout;


import java.util.HashMap;
import java.util.Map;

import vcredit.builddemo.MainActivity;
import vcredit.module1.OneModueActivity;
import vcredit.supportlibrary.RountConstants;

/**
 * Created by zew on 17/5/8.
 */
public class RoutInfo  {
    /**
     * 静态的map表
     */
    public static Map<String, Class> map = new HashMap();
    static {
        map.put(RountConstants.OneModueActivity, OneModueActivity.class);//
        map.put(RountConstants.mainModuleActivity, MainActivity.class);//
    }
}
