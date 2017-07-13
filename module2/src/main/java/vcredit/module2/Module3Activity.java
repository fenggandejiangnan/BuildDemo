package vcredit.module2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.lzh.compiler.parceler.FastJsonConverter;
import com.lzh.compiler.parceler.Parceler;
import com.lzh.compiler.parceler.annotation.Arg;
import com.vcredit.androud.vrouter.annotation.Route;

import vcredit.supportlibrary.entity.LoginBean;

/**
 * Created by zew on 17/7/10.
 */
@Route({"vcredit://module3ctivity"})
public class Module3Activity extends Activity {
    private static String TAG="Module3Activity";
    @Arg
    String username;
    @Arg
    String password;

//    @Converter(FastJsonConverter.class)
    @Arg
    LoginBean loginBean;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3);
        Intent intent = getIntent();
//        Log.e(TAG,intent.getExtras().getString("RouterRuleCreator"));
        Bundle extras = getIntent().getExtras();


        Parceler.setDefaultConverter(FastJsonConverter.class);
        Parceler.toEntity(this,getIntent());

        tv = (TextView) findViewById(R.id.tv_module2);
        tv.setText("用户名："+username+",密码："+password);
        Toast.makeText(this, loginBean.getCode(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Parceler.toBundle(this,outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Parceler.toEntity(this,savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        setResult(2, new Intent());
        super.onBackPressed();
    }
}
