package vcredit.builddemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lzh.compiler.parceler.annotation.Arg;
import com.vcredit.android.vrouter.start.ViewBinder;
import com.vcredit.androud.vrouter.BindView;
import com.vcredit.androud.vrouter.annotation.Route;

import vcredit.module1.OneModueActivity;
@Route("main")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Arg
    Uri uri;

    @BindView(R.id.btn1)
    public Button btn1;

    @BindView(R.id.tv_xinyongmao)
    public TextView xinyongmao;

    @BindView(R.id.tv_xinyonghua)
    public TextView xinyonghua;

    @BindView(R.id.btn2)
    public Button btn2;

    @BindView(R.id.btn3)
    public Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewBinder.bind(this);
//        VRouter.getInstance().inject(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn1){
            AppDirector appDirector = new AppDirector();
            Product p = appDirector.construct(new CreditCatBuilder());
            xinyongmao.setText(p.getXuqiu()+"==="+p.getUi()+"==="+p.getLuoji());

            Product p2 = appDirector.construct(new CreditHuaBuilder());
            xinyonghua.setText(p2.getXuqiu()+"==="+p2.getUi()+"==="+p2.getLuoji());
        }else if (v.getId()==R.id.btn2){
            Intent intent = new Intent(this, OneModueActivity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.btn3){

//            VRouter.create("vcredit://otheractivity?url=haoge%3A%2F%2Faction%2Fsupport%3Fusername%3Dhaoge&amp;address=shanghai").open(this);
            Intent intent = new Intent(this,OneModueActivity.class);
            startActivity(intent);
//            VRouter.create("vcredit://module3ctivity?url=haoge%3A%2F%2Faction%2Fsupport%3Fusername%3Dhaoge&amp;address=shanghai").open(this);

        }
    }
}
