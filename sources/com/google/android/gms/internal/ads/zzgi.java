package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzgi extends Handler {
    private final /* synthetic */ zzgj zzaco;

    zzgi(zzgj zzgj, Looper looper) {
        this.zzaco = zzgj;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.zzaco.zza(message);
    }
}
