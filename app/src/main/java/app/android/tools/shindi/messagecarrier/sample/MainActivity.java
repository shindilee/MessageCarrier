package app.android.tools.shindi.messagecarrier.sample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import app.android.tools.shindi.messagecarrier.MsgReceiver;
import app.android.tools.shindi.messagecarrier.MsgSender;
import app.android.tools.shindi.messagecarrier.ReceiveListener;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION = "SEND_MY_MESSAGE";
    private String TAG = "MyBroadcast";
    private MsgReceiver mr = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mr = new MsgReceiver(getApplicationContext(), ACTION);
        mr.setOnReceiverListener(new ReceiveListener() {
            @Override
            public void onReceive(Message message) {
                Log.i(TAG, "Thread: " + Thread.currentThread().toString());
                Log.i(TAG, message.msgStr);
                Toast.makeText(MainActivity.this, message.msgStr, Toast.LENGTH_LONG).show();
            }
        });
        mr.register();
    }

    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setClass(this, ActionActivity.class);
        startActivity(i);
    }

    @Override
    public void onDestroy(){
        if (mr != null) mr.release();
        super.onDestroy();
    }
}
