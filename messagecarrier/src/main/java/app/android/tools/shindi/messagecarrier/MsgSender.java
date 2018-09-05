package app.android.tools.shindi.messagecarrier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

public class MsgSender {

    private String broadcastAction;
    private Context ctx;

    public MsgSender(Context ctx, String broadcastAction) {
        this.ctx = ctx;
        this.broadcastAction = broadcastAction;
    }

    public void send(String msg) {
        Intent i = new Intent(broadcastAction);
        Bundle b = new Bundle();
        b.putString(MsgReceiver.SYMBOL_STR, msg);
        i.putExtra(MsgReceiver.SYMBOL_ALL, b);
        LocalBroadcastManager.getInstance(ctx).sendBroadcast(i);
    }

    public void send(int msg) {
        Intent i = new Intent(broadcastAction);
        Bundle b = new Bundle();
        b.putInt(MsgReceiver.SYMBOL_INT, msg);
        i.putExtra(MsgReceiver.SYMBOL_ALL, b);
        LocalBroadcastManager.getInstance(ctx).sendBroadcast(i);
    }

    public void send(boolean msg) {
        Intent i = new Intent(broadcastAction);
        Bundle b = new Bundle();
        b.putBoolean(MsgReceiver.SYMBOL_BOOL, msg);
        i.putExtra(MsgReceiver.SYMBOL_ALL, b);
        LocalBroadcastManager.getInstance(ctx).sendBroadcast(i);
    }

    public void send(Bundle msg) {
        Intent i = new Intent(broadcastAction);
        i.putExtra(MsgReceiver.SYMBOL_ALL, msg);
        LocalBroadcastManager.getInstance(ctx).sendBroadcast(i);
    }
}
