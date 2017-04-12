package ulyne.com.bmobtuisong;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import cn.bmob.push.PushConstants;

/**
 * Created by fanwei on 2017/4/12.
 */

public class MyPushMessageReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        if(intent.getAction().equals(PushConstants.ACTION_MESSAGE)){
            Log.d("bmob", "客户端收到推送内容："+intent.getStringExtra("msg"));
            Toast.makeText(context, "hello", Toast.LENGTH_LONG).show();
            Mes mes = new Mes();
            mes.setMes(intent.getStringExtra("msg"));
            EventBus.getDefault().post(mes);
        }
    }

}
