package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzatp {
    private long zzdqb = -1;
    private long zzdqc = -1;
    private final /* synthetic */ zzatq zzdqd;

    public zzatp(zzatq zzatq) {
        this.zzdqd = zzatq;
    }

    public final long zztu() {
        return this.zzdqc;
    }

    public final void zztv() {
        this.zzdqc = this.zzdqd.zzbmp.elapsedRealtime();
    }

    public final void zztw() {
        this.zzdqb = this.zzdqd.zzbmp.elapsedRealtime();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzdqb);
        bundle.putLong("tclose", this.zzdqc);
        return bundle;
    }
}
