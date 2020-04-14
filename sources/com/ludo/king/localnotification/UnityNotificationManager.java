package com.ludo.king.localnotification;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.TaskStackBuilder;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.share.Constants;
import com.google.firebase.MessagingUnityPlayerActivity;
import com.tapjoy.TJAdUnitConstants.String;
import com.unity3d.player.UnityPlayer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UnityNotificationManager extends BroadcastReceiver {
    private static Set<String> channels = new HashSet();

    public static void CreateChannel(String str, String str2, String str3, int i, String str4, int i2, int i3, int i4, long[] jArr, String str5) {
        if (VERSION.SDK_INT >= 26) {
            channels.add(str);
            NotificationManager notificationManager = (NotificationManager) ((MessagingUnityPlayerActivity) UnityPlayer.currentActivity).getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, i);
            notificationChannel.setDescription(str3);
            if (str4 != null) {
                Resources resources = ((MessagingUnityPlayerActivity) UnityPlayer.currentActivity).getResources();
                StringBuilder sb = new StringBuilder();
                sb.append("raw/");
                sb.append(str4);
                int identifier = resources.getIdentifier(sb.toString(), null, ((MessagingUnityPlayerActivity) UnityPlayer.currentActivity).getPackageName());
                AudioAttributes build = new Builder().setUsage(5).setContentType(4).build();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("android.resource://");
                sb2.append(str5);
                sb2.append(Constants.URL_PATH_DELIMITER);
                sb2.append(identifier);
                notificationChannel.setSound(Uri.parse(sb2.toString()), build);
            }
            boolean z = false;
            notificationChannel.enableLights(i2 == 1);
            notificationChannel.setLightColor(i3);
            if (i4 == 1) {
                z = true;
            }
            notificationChannel.enableVibration(z);
            if (jArr == null) {
                jArr = new long[]{1000, 1000};
            }
            notificationChannel.setVibrationPattern(jArr);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    @TargetApi(24)
    private static void createChannelIfNeeded(String str, String str2, String str3, boolean z, boolean z2, String str4) {
        if (!channels.contains(str)) {
            channels.add(str);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" notifications");
            String str5 = str4;
            CreateChannel(str, str2, sb.toString(), 3, str3, z ? 1 : 0, -16711936, z2 ? 1 : 0, null, str5);
        }
    }

    public static void SetNotification(int i, long j, String str, String str2, String str3, int i2, String str4, int i3, int i4, String str5, String str6, int i5, String str7, String str8, ArrayList<NotificationAction> arrayList) {
        String str9;
        int i6 = i;
        int i7 = i3;
        int i8 = i4;
        Log.d("pratik", "inside SetNotification");
        boolean z = true;
        if (VERSION.SDK_INT >= 26) {
            str9 = str8 == null ? "default" : str8;
            createChannelIfNeeded(str9, str, str4, i8 == 1, i7 == 1, str7);
        } else {
            str9 = str8;
        }
        MessagingUnityPlayerActivity messagingUnityPlayerActivity = (MessagingUnityPlayerActivity) UnityPlayer.currentActivity;
        AlarmManager alarmManager = (AlarmManager) messagingUnityPlayerActivity.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(messagingUnityPlayerActivity, UnityNotificationManager.class);
        intent.putExtra("ticker", str3);
        String str10 = str;
        intent.putExtra("title", str);
        intent.putExtra("message", str2);
        intent.putExtra("id", i);
        intent.putExtra("color", i5);
        intent.putExtra("sound", i2 == 1);
        intent.putExtra("soundName", str4);
        intent.putExtra("vibrate", i7 == 1);
        if (i8 != 1) {
            z = false;
        }
        intent.putExtra("lights", z);
        intent.putExtra("l_icon", str5);
        intent.putExtra("s_icon", str6);
        intent.putExtra(String.BUNDLE, str7);
        intent.putExtra(AppsFlyerProperties.CHANNEL, str9);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("actions", arrayList);
        intent.putExtra("actionsBundle", bundle);
        if (VERSION.SDK_INT >= 23) {
            alarmManager.setExact(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(messagingUnityPlayerActivity, i, intent, 134217728));
        } else {
            alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(messagingUnityPlayerActivity, i, intent, 134217728));
        }
    }

    public static void SetRepeatingNotification(int i, long j, String str, String str2, String str3, long j2, int i2, String str4, int i3, int i4, String str5, String str6, int i5, String str7, String str8, ArrayList<NotificationAction> arrayList) {
        String str9;
        int i6 = i;
        int i7 = i3;
        int i8 = i4;
        boolean z = false;
        if (VERSION.SDK_INT >= 26) {
            str9 = str8 == null ? "default" : str8;
            createChannelIfNeeded(str9, str, str4, i8 == 1, i7 == 1, str7);
        } else {
            str9 = str8;
        }
        MessagingUnityPlayerActivity messagingUnityPlayerActivity = (MessagingUnityPlayerActivity) UnityPlayer.currentActivity;
        AlarmManager alarmManager = (AlarmManager) messagingUnityPlayerActivity.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(messagingUnityPlayerActivity, UnityNotificationManager.class);
        intent.putExtra("ticker", str3);
        String str10 = str;
        intent.putExtra("title", str);
        intent.putExtra("message", str2);
        intent.putExtra("id", i);
        intent.putExtra("color", i5);
        intent.putExtra("sound", i2 == 1);
        intent.putExtra("soundName", str4);
        intent.putExtra("vibrate", i7 == 1);
        if (i8 == 1) {
            z = true;
        }
        intent.putExtra("lights", z);
        intent.putExtra("l_icon", str5);
        intent.putExtra("s_icon", str6);
        intent.putExtra(String.BUNDLE, str7);
        intent.putExtra(AppsFlyerProperties.CHANNEL, str9);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("actions", arrayList);
        intent.putExtra("actionsBundle", bundle);
        alarmManager.setRepeating(0, System.currentTimeMillis() + j, j2, PendingIntent.getBroadcast(messagingUnityPlayerActivity, i, intent, 134217728));
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        Boolean bool;
        Intent intent2;
        PendingIntent pendingIntent;
        Context context2 = context;
        Intent intent3 = intent;
        Log.d("pratik", "received alarm creating notification and handler");
        NotificationManager notificationManager = (NotificationManager) context2.getSystemService("notification");
        String stringExtra = intent3.getStringExtra("ticker");
        String stringExtra2 = intent3.getStringExtra("title");
        String stringExtra3 = intent3.getStringExtra("message");
        String stringExtra4 = intent3.getStringExtra("s_icon");
        String stringExtra5 = intent3.getStringExtra("l_icon");
        int intExtra = intent3.getIntExtra("color", 0);
        String stringExtra6 = intent3.getStringExtra(String.BUNDLE);
        Boolean valueOf = Boolean.valueOf(intent3.getBooleanExtra("sound", false));
        String stringExtra7 = intent3.getStringExtra("soundName");
        Boolean valueOf2 = Boolean.valueOf(intent3.getBooleanExtra("vibrate", false));
        Boolean valueOf3 = Boolean.valueOf(intent3.getBooleanExtra("lights", false));
        String str3 = "id";
        NotificationManager notificationManager2 = notificationManager;
        int intExtra2 = intent3.getIntExtra(str3, 0);
        String stringExtra8 = intent3.getStringExtra(AppsFlyerProperties.CHANNEL);
        Boolean bool2 = valueOf3;
        ArrayList parcelableArrayList = intent3.getBundleExtra("actionsBundle").getParcelableArrayList("actions");
        Resources resources = context.getResources();
        if (((MessagingUnityPlayerActivity) UnityPlayer.currentActivity) == null) {
            bool = valueOf2;
            str2 = stringExtra6;
            intent2 = new Intent(context2, UnityNotificationActionHandler.class);
            str = stringExtra7;
        } else {
            str2 = stringExtra6;
            bool = valueOf2;
            str = stringExtra7;
            intent2 = new Intent((MessagingUnityPlayerActivity) UnityPlayer.currentActivity, UnityNotificationActionHandler.class);
        }
        if (parcelableArrayList != null && parcelableArrayList.size() == 1) {
            NotificationAction notificationAction = (NotificationAction) parcelableArrayList.get(0);
            intent2.putExtra(str3, intExtra2);
            intent2.putExtra("gameObject", notificationAction.getGameObject());
            intent2.putExtra("handlerMethod", notificationAction.getHandlerMethod());
            intent2.putExtra("actionId", notificationAction.getIdentifier());
        }
        TaskStackBuilder.create(context).addNextIntent(intent2);
        if (((MessagingUnityPlayerActivity) UnityPlayer.currentActivity) == null) {
            pendingIntent = PendingIntent.getBroadcast(context2, intExtra2, intent2, 134217728);
        } else {
            pendingIntent = PendingIntent.getBroadcast((MessagingUnityPlayerActivity) UnityPlayer.currentActivity, intExtra2, intent2, 134217728);
        }
        if (stringExtra8 == null) {
            stringExtra8 = "default";
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, stringExtra8);
        builder.setContentIntent(pendingIntent).setAutoCancel(true).setContentTitle(stringExtra2).setContentText(stringExtra3).setStyle(new BigTextStyle().bigText(stringExtra2)).setStyle(new BigTextStyle().bigText(stringExtra3));
        if (VERSION.SDK_INT >= 21) {
            builder.setColor(intExtra);
        }
        if (stringExtra != null && stringExtra.length() > 0) {
            builder.setTicker(stringExtra);
        }
        String str4 = "drawable";
        if (stringExtra4 != null && stringExtra4.length() > 0) {
            builder.setSmallIcon(resources.getIdentifier(stringExtra4, str4, context.getPackageName()));
        }
        if (stringExtra5 != null && stringExtra5.length() > 0) {
            builder.setLargeIcon(BitmapFactory.decodeResource(resources, resources.getIdentifier(stringExtra5, str4, context.getPackageName())));
        }
        if (valueOf.booleanValue()) {
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("raw/");
                sb.append(str);
                int identifier = resources.getIdentifier(sb.toString(), null, context.getPackageName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("android.resource://");
                sb2.append(str2);
                sb2.append(Constants.URL_PATH_DELIMITER);
                sb2.append(identifier);
                builder.setSound(Uri.parse(sb2.toString()));
            } else {
                builder.setSound(RingtoneManager.getDefaultUri(2));
            }
        }
        if (bool.booleanValue()) {
            builder.setVibrate(new long[]{1000, 1000});
        }
        if (bool2.booleanValue()) {
            builder.setLights(-16711936, 3000, 3000);
        }
        notificationManager2.notify(intExtra2, builder.build());
    }

    public static void CancelPendingNotification(int i) {
        MessagingUnityPlayerActivity messagingUnityPlayerActivity = (MessagingUnityPlayerActivity) UnityPlayer.currentActivity;
        ((AlarmManager) messagingUnityPlayerActivity.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(messagingUnityPlayerActivity, i, new Intent(messagingUnityPlayerActivity, UnityNotificationManager.class), 134217728));
    }

    public static void ClearShowingNotifications() {
        ((NotificationManager) ((MessagingUnityPlayerActivity) UnityPlayer.currentActivity).getSystemService("notification")).cancelAll();
    }
}
