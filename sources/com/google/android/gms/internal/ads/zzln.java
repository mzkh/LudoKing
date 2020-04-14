package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzln implements zzmd {
    /* access modifiers changed from: private */
    public final int track;
    private final /* synthetic */ zzli zzazs;

    public zzln(zzli zzli, int i) {
        this.zzazs = zzli;
        this.track = i;
    }

    public final boolean isReady() {
        return this.zzazs.zzas(this.track);
    }

    public final void zzhe() throws IOException {
        this.zzazs.zzhe();
    }

    public final int zzb(zzgq zzgq, zzik zzik, boolean z) {
        return this.zzazs.zza(this.track, zzgq, zzik, z);
    }

    public final void zzeb(long j) {
        this.zzazs.zzd(this.track, j);
    }
}
