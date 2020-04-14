package com.google.firebase.messaging.cpp;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class ListenerService extends FirebaseMessagingService {
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    private static final String TAG = "FIREBASE_LISTENER";
    private final MessageWriter messageWriter;

    public ListenerService() {
        this(MessageWriter.defaultInstance());
    }

    public ListenerService(MessageWriter messageWriter2) {
        this.messageWriter = messageWriter2;
    }

    public void onDeletedMessages() {
        DebugLogging.log(TAG, "onDeletedMessages");
        this.messageWriter.writeMessageEventToInternalStorage(this, null, MESSAGE_TYPE_DELETED, null);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        this.messageWriter.writeMessage(this, remoteMessage, false, null);
    }

    public void onMessageSent(String str) {
        DebugLogging.log(TAG, String.format("onMessageSent messageId=%s", new Object[]{str}));
        this.messageWriter.writeMessageEventToInternalStorage(this, str, MESSAGE_TYPE_SEND_EVENT, null);
    }

    public void onSendError(String str, Exception exc) {
        DebugLogging.log(TAG, String.format("onSendError messageId=%s exception=%s", new Object[]{str, exc.toString()}));
        this.messageWriter.writeMessageEventToInternalStorage(this, str, MESSAGE_TYPE_SEND_ERROR, exc.toString());
    }

    public void onNewToken(String str) {
        DebugLogging.log(TAG, String.format("onNewToken token=%s", new Object[]{str}));
        RegistrationIntentService.writeTokenToInternalStorage(this, str);
    }
}
