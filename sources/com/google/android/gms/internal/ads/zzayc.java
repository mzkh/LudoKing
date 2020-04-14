package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public class zzayc<T> {
    private final zzaxv<T> zzdwv = new zzaxv<>();
    /* access modifiers changed from: private */
    public final AtomicInteger zzdww = new AtomicInteger(0);

    public zzayc() {
        zzdcy.zza(this.zzdwv, new zzayb(this), zzaxn.zzdwn);
    }

    @Deprecated
    public final void zza(zzaxz<T> zzaxz, zzaxx zzaxx) {
        zzdcy.zza(this.zzdwv, new zzaye(this, zzaxz, zzaxx), zzaxn.zzdwn);
    }

    @Deprecated
    public final void zzm(T t) {
        this.zzdwv.set(t);
    }

    @Deprecated
    public final void reject() {
        this.zzdwv.setException(new Exception());
    }

    @Deprecated
    public final int getStatus() {
        return this.zzdww.get();
    }
}
