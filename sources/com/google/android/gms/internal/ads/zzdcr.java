package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzdcr extends zza {
    private final /* synthetic */ zzdcm zzgrg;
    private zzdco zzgrk;

    zzdcr(zzdcm zzdcm, zzday<? extends zzddi<?>> zzday, boolean z, zzdco zzdco) {
        this.zzgrg = zzdcm;
        super(zzday, z, false);
        this.zzgrk = zzdco;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(boolean z, int i, @NullableDecl Object obj) {
    }

    /* access modifiers changed from: 0000 */
    public final void zzapc() {
        zzdco zzdco = this.zzgrk;
        if (zzdco != null) {
            zzdco.execute();
        } else {
            zzdaq.checkState(this.zzgrg.isDone());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzapb() {
        super.zzapb();
        this.zzgrk = null;
    }

    /* access modifiers changed from: 0000 */
    public final void interruptTask() {
        zzdco zzdco = this.zzgrk;
        if (zzdco != null) {
            zzdco.interruptTask();
        }
    }
}
