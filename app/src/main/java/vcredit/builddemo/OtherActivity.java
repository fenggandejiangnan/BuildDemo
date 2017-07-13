package vcredit.builddemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Size;
import android.widget.TextView;

import com.vcredit.androud.vrouter.annotation.Route;

import java.util.ArrayList;

/**
 * Created by zew on 17/7/10.
 */
@Route({"vcredit://otheractivity","http://haoge.cn/parceler"})
public class OtherActivity extends Activity {

    String username;
    String address;
    Size size;
    ArrayList<String> strList;
    ArrayList<Integer> intList;
    String url;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        tv = (TextView) findViewById(R.id.tv_other);
        tv.setText("username:" + username + ",\r\naddress :" + address + ",\r\nstrList" + strList + ",\r\nurl :" + url);

    }
}
