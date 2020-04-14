package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwx implements zzdwb<zzcww> {
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<Context> zzfgo;
    private final zzdwo<zzatr> zzgeg;

    public zzcwx(zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzatr> zzdwo3) {
        this.zzfgo = zzdwo;
        this.zzfcq = zzdwo2;
        this.zzgeg = zzdwo3;
    }

    public final /* synthetic */ Object get() {
        return new zzcww((Context) this.zzfgo.get(), (zzaxl) this.zzfcq.get(), (zzatr) this.zzgeg.get());
    }
}
