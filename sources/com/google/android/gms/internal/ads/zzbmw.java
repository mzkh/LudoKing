package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmw implements zzdwb<zzasi> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcvr> zzfcp;
    private final zzbmt zzfgw;
    private final zzdwo<zzaxl> zzfgx;
    private final zzdwo<zzask> zzfgy;

    private zzbmw(zzbmt zzbmt, zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzcvr> zzdwo3, zzdwo<zzask> zzdwo4) {
        this.zzfgw = zzbmt;
        this.zzejy = zzdwo;
        this.zzfgx = zzdwo2;
        this.zzfcp = zzdwo3;
        this.zzfgy = zzdwo4;
    }

    public static zzbmw zza(zzbmt zzbmt, zzdwo<Context> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<zzcvr> zzdwo3, zzdwo<zzask> zzdwo4) {
        zzbmw zzbmw = new zzbmw(zzbmt, zzdwo, zzdwo2, zzdwo3, zzdwo4);
        return zzbmw;
    }

    @Nullable
    public final /* synthetic */ Object get() {
        Context context = (Context) this.zzejy.get();
        zzaxl zzaxl = (zzaxl) this.zzfgx.get();
        zzcvr zzcvr = (zzcvr) this.zzfcp.get();
        zzask zzask = (zzask) this.zzfgy.get();
        if (zzcvr.zzgji == null) {
            return null;
        }
        zzarv zzarv = new zzarv(context, zzaxl, zzcvr.zzgji, zzcvr.zzgje.zzdhz, zzask);
        return zzarv;
    }
}
