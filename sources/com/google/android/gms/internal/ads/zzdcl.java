package com.google.android.gms.internal.ads;

import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
abstract class zzdcl extends zza {
    private List<zzdar<V>> zzgrc;
    private final /* synthetic */ zzdci zzgrd;

    zzdcl(zzdci zzdci, zzday<? extends zzddi<? extends V>> zzday, boolean z) {
        List<zzdar<V>> list;
        this.zzgrd = zzdci;
        super(zzday, z, true);
        if (zzday.isEmpty()) {
            list = zzdbd.zzaop();
        } else {
            list = zzdbl.zzdt(zzday.size());
        }
        this.zzgrc = list;
        for (int i = 0; i < zzday.size(); i++) {
            this.zzgrc.add(null);
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract C zzj(List<zzdar<V>> list);

    /* access modifiers changed from: 0000 */
    public final void zza(boolean z, int i, @NullableDecl V v) {
        List<zzdar<V>> list = this.zzgrc;
        if (list != null) {
            list.set(i, zzdar.zzz(v));
        } else {
            zzdaq.checkState(z || this.zzgrd.isCancelled(), "Future was done before all dependencies completed");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzapc() {
        List<zzdar<V>> list = this.zzgrc;
        if (list != null) {
            this.zzgrd.set(zzj(list));
        } else {
            zzdaq.checkState(this.zzgrd.isDone());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzapb() {
        super.zzapb();
        this.zzgrc = null;
    }
}
