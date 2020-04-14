package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclm implements zzdwb<zzcli> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzbso> zzfxj;

    public zzclm(zzdwo<Context> zzdwo, zzdwo<zzbso> zzdwo2) {
        this.zzejy = zzdwo;
        this.zzfxj = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return new zzcli((Context) this.zzejy.get(), (zzbso) this.zzfxj.get());
    }
}
