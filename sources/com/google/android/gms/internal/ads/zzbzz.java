package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbzz implements zzdwb<zzbzl> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzaxl> zzfan;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<zzbou> zzfeg;
    private final zzdwo<zzdf> zzfkh;
    private final zzdwo<zzsd> zzfoy;
    private final zzdwo<zzbcb> zzfqe;
    private final zzdwo<zza> zzfqv;
    private final zzdwo<zzbrq> zzfqw;

    private zzbzz(zzdwo<zzbcb> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzcwe> zzdwo3, zzdwo<zzdf> zzdwo4, zzdwo<zzaxl> zzdwo5, zzdwo<zza> zzdwo6, zzdwo<zzsd> zzdwo7, zzdwo<zzbou> zzdwo8, zzdwo<zzbrq> zzdwo9) {
        this.zzfqe = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfef = zzdwo3;
        this.zzfkh = zzdwo4;
        this.zzfan = zzdwo5;
        this.zzfqv = zzdwo6;
        this.zzfoy = zzdwo7;
        this.zzfeg = zzdwo8;
        this.zzfqw = zzdwo9;
    }

    public static zzbzz zzb(zzdwo<zzbcb> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzcwe> zzdwo3, zzdwo<zzdf> zzdwo4, zzdwo<zzaxl> zzdwo5, zzdwo<zza> zzdwo6, zzdwo<zzsd> zzdwo7, zzdwo<zzbou> zzdwo8, zzdwo<zzbrq> zzdwo9) {
        zzbzz zzbzz = new zzbzz(zzdwo, zzdwo2, zzdwo3, zzdwo4, zzdwo5, zzdwo6, zzdwo7, zzdwo8, zzdwo9);
        return zzbzz;
    }

    public final /* synthetic */ Object get() {
        zzbzl zzbzl = new zzbzl((zzbcb) this.zzfqe.get(), (Context) this.zzejy.get(), (zzcwe) this.zzfef.get(), (zzdf) this.zzfkh.get(), (zzaxl) this.zzfan.get(), (zza) this.zzfqv.get(), (zzsd) this.zzfoy.get(), (zzbou) this.zzfeg.get(), (zzbrq) this.zzfqw.get());
        return zzbzl;
    }
}
