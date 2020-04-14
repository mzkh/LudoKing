package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzccr implements Runnable {
    private final zzccj zzfsr;
    private final zzaxv zzftb;

    zzccr(zzccj zzccj, zzaxv zzaxv) {
        this.zzfsr = zzccj;
        this.zzftb = zzaxv;
    }

    public final void run() {
        zzaxv zzaxv = this.zzftb;
        String zzun = zzq.zzkn().zzuh().zzve().zzun();
        if (!TextUtils.isEmpty(zzun)) {
            zzaxv.set(zzun);
        } else {
            zzaxv.setException(new Exception());
        }
    }
}
