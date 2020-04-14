package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbsw implements zzdwb<zzbsx> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfan;
    private final zzdwo<Integer> zzfcr;
    private final zzdwo<zzbbw> zzfdu;
    private final zzdwo<zzcvr> zzfes;

    private zzbsw(zzdwo<Context> zzdwo, zzdwo<zzbbw> zzdwo2, zzdwo<zzcvr> zzdwo3, zzdwo<zzaxl> zzdwo4, zzdwo<Integer> zzdwo5) {
        this.zzejy = zzdwo;
        this.zzfdu = zzdwo2;
        this.zzfes = zzdwo3;
        this.zzfan = zzdwo4;
        this.zzfcr = zzdwo5;
    }

    public static zzbsw zzd(zzdwo<Context> zzdwo, zzdwo<zzbbw> zzdwo2, zzdwo<zzcvr> zzdwo3, zzdwo<zzaxl> zzdwo4, zzdwo<Integer> zzdwo5) {
        zzbsw zzbsw = new zzbsw(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5);
        return zzbsw;
    }

    public final /* synthetic */ Object get() {
        zzbsx zzbsx = new zzbsx((Context) this.zzejy.get(), (zzbbw) this.zzfdu.get(), (zzcvr) this.zzfes.get(), (zzaxl) this.zzfan.get(), ((Integer) this.zzfcr.get()).intValue());
        return zzbsx;
    }
}
