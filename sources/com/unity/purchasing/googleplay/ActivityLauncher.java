package com.unity.purchasing.googleplay;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;

public class ActivityLauncher implements IActivityLauncher {
    public void startIntentSenderForResult(Activity activity, PendingIntent pendingIntent, int i, Intent intent, String str) throws SendIntentException {
        IntentSender intentSender = pendingIntent.getIntentSender();
        Intent intent2 = new Intent();
        Integer valueOf = Integer.valueOf(0);
        activity.startIntentSenderForResult(intentSender, i, intent2, valueOf.intValue(), valueOf.intValue(), valueOf.intValue());
    }

    public void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }
}
