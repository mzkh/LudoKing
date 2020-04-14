package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.internal.C1833hb;

public class GCMReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean a = C1833hb.m3584b(context).mo18211a(intent);
        if (isOrderedBroadcast()) {
            setResult(-1, null, null);
            if (a) {
                abortBroadcast();
            }
        }
    }
}
