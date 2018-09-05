package app.android.tools.shindi.messagecarrier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MsgReceiver {
    private static final String TAG = MsgReceiver.class.getSimpleName();
    protected final static String SYMBOL_ALL = "data";
    protected final static String SYMBOL_STR = "msg_str";
    protected final static String SYMBOL_INT = "msg_int";
    protected final static String SYMBOL_BOOL = "msg_bool";
    private ReceiveListener listener = null;
    private String action;
    private Context ctx;

    public MsgReceiver(Context ctx, String action) {
        this.ctx = ctx;
        this.action = action;
    }

    public void register() {
        LocalBroadcastManager.getInstance(ctx).registerReceiver(br, new IntentFilter(action));
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle b = intent.getBundleExtra(SYMBOL_ALL);
            ReceiveListener.Message message = new ReceiveListener.Message();

            if (b == null || listener == null) {
                if (listener != null) {
                    Log.i(TAG, "send intent");
                    listener.onReceive(message);
                }
                return;
            }

            if (b.containsKey(SYMBOL_STR)) {
                message.msgStr = b.getString(SYMBOL_STR, "");
            }

            if (b.containsKey(SYMBOL_INT)) {
                message.msgInt = b.getInt(SYMBOL_INT, -999999999);
            }

            if (b.containsKey(SYMBOL_BOOL)) {
                message.msgBool = b.getBoolean(SYMBOL_BOOL, false);
            }

            message.msgBundle = b;

            listener.onReceive(message);
        }
    };

    public void setOnReceiverListener(ReceiveListener listener) {
        this.listener = listener;
    }

    public void release() {
        LocalBroadcastManager.getInstance(ctx).unregisterReceiver(br);
    }
}
