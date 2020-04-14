package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzawt extends BroadcastReceiver {
    private final /* synthetic */ zzawu zzdvf;

    zzawt(zzawu zzawu) {
        this.zzdvf = zzawu;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzdvf.zzc(context, intent);
    }
}
