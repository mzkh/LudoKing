package com.ludo.king.localnotification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.MessagingUnityPlayerActivity;
import com.unity3d.player.UnityPlayer;

public class UnityNotificationActionHandler extends BroadcastReceiver {
    static String sActionId = "";
    static String sGameObject = "";
    static String sHandlerMethod = "";

    public void onReceive(Context context, Intent intent) {
        String str = "pratik";
        Log.d(str, "inside UnityNotificationActionHandler receive call back ");
        int intExtra = intent.getIntExtra("id", 0);
        String stringExtra = intent.getStringExtra("gameObject");
        String stringExtra2 = intent.getStringExtra("handlerMethod");
        String stringExtra3 = intent.getStringExtra("actionId");
        ((NotificationManager) context.getSystemService("notification")).cancel(intExtra);
        Intent intent2 = new Intent(context, MessagingUnityPlayerActivity.class);
        intent2.setPackage(null);
        intent2.addFlags(DriveFile.MODE_READ_WRITE);
        context.startActivity(intent2);
        if (((MessagingUnityPlayerActivity) UnityPlayer.currentActivity) == null) {
            Log.d(str, "inside onReceive action and activity is null, storing data");
            sGameObject = stringExtra;
            sHandlerMethod = stringExtra2;
            sActionId = stringExtra3;
        } else if (stringExtra != null && stringExtra2 != null && stringExtra3 != null && !stringExtra.isEmpty() && !stringExtra2.isEmpty() && !stringExtra3.isEmpty()) {
            UnityPlayer.UnitySendMessage(stringExtra, stringExtra2, stringExtra3);
        }
    }

    public static void TriggerLastReceivedNotificationAction() {
        String str = sGameObject;
        if (str != null && !str.isEmpty() && !sHandlerMethod.isEmpty() && !sActionId.isEmpty()) {
            UnityPlayer.UnitySendMessage(sGameObject, sHandlerMethod, sActionId);
            String str2 = "";
            sGameObject = str2;
            sHandlerMethod = str2;
            sActionId = str2;
        }
    }
}
