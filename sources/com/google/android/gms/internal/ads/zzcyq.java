package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcyq implements zzdwb<zzaix> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfgx;
    private final zzcyn zzgmy;

    public zzcyq(zzcyn zzcyn, zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2) {
        this.zzgmy = zzcyn;
        this.zzejy = zzdwo;
        this.zzfgx = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return (zzaix) zzdwh.zza(new zzaio().zzb((Context) this.zzejy.get(), (zzaxl) this.zzfgx.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
