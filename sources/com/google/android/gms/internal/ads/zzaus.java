package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaus extends BroadcastReceiver {
    private final /* synthetic */ zzaul zzdta;

    private zzaus(zzaul zzaul) {
        this.zzdta = zzaul;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zzdta.zzyf = true;
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zzdta.zzyf = false;
        }
    }

    /* synthetic */ zzaus(zzaul zzaul, zzauo zzauo) {
        this(zzaul);
    }
}
