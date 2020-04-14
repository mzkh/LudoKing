package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbkf implements zzbog, zzpj {
    private final zzcvr zzfbi;
    private final zzbni zzfey;
    private final zzbok zzfez;
    private final AtomicBoolean zzffa = new AtomicBoolean();
    private final AtomicBoolean zzffb = new AtomicBoolean();

    public zzbkf(zzcvr zzcvr, zzbni zzbni, zzbok zzbok) {
        this.zzfbi = zzcvr;
        this.zzfey = zzbni;
        this.zzfez = zzbok;
    }

    public final synchronized void onAdLoaded() {
        if (this.zzfbi.zzgiz != 1) {
            zzafk();
        }
    }

    public final void zza(zzpk zzpk) {
        if (this.zzfbi.zzgiz == 1 && zzpk.zzbnp) {
            zzafk();
        }
        if (zzpk.zzbnp && this.zzffb.compareAndSet(false, true)) {
            this.zzfez.zzafz();
        }
    }

    private final void zzafk() {
        if (this.zzffa.compareAndSet(false, true)) {
            this.zzfey.onAdImpression();
        }
    }
}
