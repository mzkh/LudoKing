package com.google.firebase.messaging;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.messaging.cpp.DebugLogging;
import com.google.firebase.messaging.cpp.MessageWriter;

public class MessageForwardingService extends IntentService {
    public static final String ACTION_REMOTE_INTENT = "com.google.android.c2dm.intent.RECEIVE";
    private static final String TAG = "FIREBASE_MSG_FWDR";

    public MessageForwardingService() {
        super(TAG);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        handleIntent(this, intent, MessageWriter.defaultInstance());
    }

    static void handleIntent(Context context, Intent intent, MessageWriter messageWriter) {
        String str = "(null)";
        String str2 = intent == null ? "null intent" : intent.getAction() == null ? str : intent.getAction();
        String valueOf = String.valueOf(str2);
        String str3 = "onHandleIntent ";
        String concat = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
        String str4 = TAG;
        DebugLogging.log(str4, concat);
        if (intent != null && intent.getAction() != null && intent.getAction().equals(ACTION_REMOTE_INTENT)) {
            Bundle extras = intent.getExtras();
            String str5 = "extras: ";
            if (extras != null) {
                str = extras.toString();
            }
            String valueOf2 = String.valueOf(str);
            DebugLogging.log(str4, valueOf2.length() != 0 ? str5.concat(valueOf2) : new String(str5));
            if (extras != null) {
                RemoteMessage remoteMessage = new RemoteMessage(extras);
                String str6 = "message: ";
                String valueOf3 = String.valueOf(remoteMessage.toString());
                DebugLogging.log(str4, valueOf3.length() != 0 ? str6.concat(valueOf3) : new String(str6));
                if (remoteMessage.getFrom() != null && remoteMessage.getMessageId() != null) {
                    messageWriter.writeMessage(context, remoteMessage, true, intent.getData());
                }
            }
        }
    }
}
