package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbzl {
    private final zzaxl zzblk;
    private final zzbcb zzbmi;
    private final zzsd zzeen;
    private final zzdf zzegb;
    private final zza zzegd;
    private final zzrf zzegf;
    private final zzcwe zzfga;
    /* access modifiers changed from: private */
    public final zzbou zzfqn;
    private final Context zzlk;

    public zzbzl(zzbcb zzbcb, Context context, zzcwe zzcwe, zzdf zzdf, zzaxl zzaxl, zza zza, zzsd zzsd, zzbou zzbou, zzbrq zzbrq) {
        this.zzbmi = zzbcb;
        this.zzlk = context;
        this.zzfga = zzcwe;
        this.zzegb = zzdf;
        this.zzblk = zzaxl;
        this.zzegd = zza;
        this.zzeen = zzsd;
        this.zzfqn = zzbou;
        this.zzegf = zzbrq;
    }

    public final zzbbw zzc(zzua zzua) throws zzbcf {
        return zza(zzua, false);
    }

    public final zzbbw zza(zzua zzua, boolean z) throws zzbcf {
        return zzbcb.zza(this.zzlk, zzbdj.zzb(zzua), zzua.zzabd, false, false, this.zzegb, this.zzblk, null, new zzbzk(this), this.zzegd, this.zzeen, this.zzegf, z);
    }
}
