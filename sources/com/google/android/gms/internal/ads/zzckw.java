package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzckw implements zze {
    private final zzbqw zzfdp;
    private final zzbni zzfjm;
    private final zzbmv zzfjn;
    private final zzbhk zzfjo;
    private final zzbqv zzfjq;
    private AtomicBoolean zzgar = new AtomicBoolean(false);

    zzckw(zzbmv zzbmv, zzbni zzbni, zzbqw zzbqw, zzbqv zzbqv, zzbhk zzbhk) {
        this.zzfjn = zzbmv;
        this.zzfjm = zzbni;
        this.zzfdp = zzbqw;
        this.zzfjq = zzbqv;
        this.zzfjo = zzbhk;
    }

    public final synchronized void zzg(View view) {
        if (this.zzgar.compareAndSet(false, true)) {
            this.zzfjo.onAdImpression();
            this.zzfjq.zzq(view);
        }
    }

    public final void zzjl() {
        if (this.zzgar.get()) {
            this.zzfjn.onAdClicked();
        }
    }

    public final void zzjm() {
        if (this.zzgar.get()) {
            this.zzfjm.onAdImpression();
            this.zzfdp.zzagq();
        }
    }
}
