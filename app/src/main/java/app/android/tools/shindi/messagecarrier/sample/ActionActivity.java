package app.android.tools.shindi.messagecarrier.sample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import app.android.tools.shindi.messagecarrier.MsgSender;

public class ActionActivity extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        txt = findViewById(R.id.text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MsgSender ms = new MsgSender(getApplicationContext(), MainActivity.ACTION);
                ms.send("Hello Carrier~");

                txt.setText(getResources().getString(R.string.broadcast_sent));
            }
        }, 3000);
    }
}
