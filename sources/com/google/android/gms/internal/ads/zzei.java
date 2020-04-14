package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzei extends BroadcastReceiver {
    private final /* synthetic */ zzeg zzzq;

    zzei(zzeg zzeg) {
        this.zzzq = zzeg;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzzq.zzct();
    }
}
