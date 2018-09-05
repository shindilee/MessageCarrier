package app.android.tools.shindi.messagecarrier;

import android.os.Bundle;

public interface ReceiveListener {
    void onReceive(Message message);

    class Message {
        public String msgStr;
        public int msgInt;
        public boolean msgBool;
        public Bundle msgBundle;
    }
}
