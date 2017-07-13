package vcredit.module1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lzh.compiler.parceler.FastJsonConverter;
import com.lzh.compiler.parceler.Parceler;
import com.vcredit.android.vrouter.VRouter;
import com.vcredit.androud.vrouter.annotation.Route;

import vcredit.supportlibrary.entity.LoginBean;

@Route({"vcredit://onemoduleactivity"})
public class OneModueActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        btnModule = (Button) findViewById(R.id.btn_module1);
        btnModule.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_module1){

            LoginBean loginBean = new LoginBean();
            loginBean.setCode("张三");
            Bundle bundle = Parceler.createFactory(new Bundle())
                    .put("loginBean", loginBean, FastJsonConverter.class)
                    .getBundle();
            VRouter.create("vcredit://module3ctivity?username=777&password=345").getActivityRoute()
                    .requestCode(100)
                    .addExtras(bundle)
                    .open(OneModueActivity.this);

//            VRouter.create("vcredit://module3ctivity?url=haoge%3A%2F%2Faction%2Fsupport%3Fusername%3Dhaoge&amp;address=shanghai").open(this);
        }
//        SupportApplication.get().routerHelper().startActivity(this, Rout.mainModule);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==2){
            Toast.makeText(this, "dasd", Toast.LENGTH_SHORT).show();
        }
    }
}
