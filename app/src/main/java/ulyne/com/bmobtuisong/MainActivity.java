package ulyne.com.bmobtuisong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobPushManager;

public class MainActivity extends AppCompatActivity {
    BmobPushManager bmobPushManager;
    TextView textView;
    MyPushMessageReceiver pmr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        textView = (TextView) findViewById(R.id.tv);
        // 初始化BmobSDK
        Bmob.initialize(this, "9092e3d81d046adf52c6aa8f815c1ad0");
        // 使用推送服务时的初始化操作
        BmobInstallation.getCurrentInstallation().save();
        // 启动推送服务
        BmobPush.startWork(this);
        bmobPushManager = new BmobPushManager();
        bmobPushManager.pushMessageAll("这是给所有设备推送的一条消息。");

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSetTv(Mes mes)
    {
        textView.setText(mes.getMes());
    }

}
