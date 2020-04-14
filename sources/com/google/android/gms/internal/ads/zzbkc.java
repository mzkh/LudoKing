package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbkc implements zzdwb<zzbkd> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfan;
    private final zzdwo<zzbbw> zzfdu;
    private final zzdwo<zzcvr> zzfes;

    public zzbkc(zzdwo<Context> zzdwo, zzdwo<zzbbw> zzdwo2, zzdwo<zzcvr> zzdwo3, zzdwo<zzaxl> zzdwo4) {
        this.zzejy = zzdwo;
        this.zzfdu = zzdwo2;
        this.zzfes = zzdwo3;
        this.zzfan = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzbkd((Context) this.zzejy.get(), (zzbbw) this.zzfdu.get(), (zzcvr) this.zzfes.get(), (zzaxl) this.zzfan.get());
    }
}
