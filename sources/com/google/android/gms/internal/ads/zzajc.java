package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzajc {
    private zzahn zzdbk;
    private zzddi<zzail> zzdbl;

    zzajc(zzahn zzahn) {
        this.zzdbk = zzahn;
    }

    private final void zzrm() {
        if (this.zzdbl == null) {
            zzaxv zzaxv = new zzaxv();
            this.zzdbl = zzaxv;
            this.zzdbk.zzb((zzdf) null).zza(new zzajf(zzaxv), new zzaje(zzaxv));
        }
    }

    public final <I, O> zzajj<I, O> zzb(String str, zzaiq<I> zzaiq, zzair<O> zzair) {
        zzrm();
        return new zzajj<>(this.zzdbl, str, zzaiq, zzair);
    }

    public final void zzc(String str, zzaer<? super zzail> zzaer) {
        zzrm();
        this.zzdbl = zzdcy.zzb(this.zzdbl, (zzdcj<? super I, ? extends O>) new zzajh<Object,Object>(str, zzaer), (Executor) zzaxn.zzdwn);
    }

    public final void zzd(String str, zzaer<? super zzail> zzaer) {
        this.zzdbl = zzdcy.zzb(this.zzdbl, (zzdal<? super I, ? extends O>) new zzajg<Object,Object>(str, zzaer), (Executor) zzaxn.zzdwn);
    }
}
