package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbrw implements zzbog {
    private final Context zzdpy;
    private final zzaxl zzfdz;
    private final zzcvr zzfea;
    private final zzcwe zzfeb;

    zzbrw(Context context, zzaxl zzaxl, zzcvr zzcvr, zzcwe zzcwe) {
        this.zzdpy = context;
        this.zzfdz = zzaxl;
        this.zzfea = zzcvr;
        this.zzfeb = zzcwe;
    }

    public final void onAdLoaded() {
        zzq.zzkt().zzb(this.zzdpy, this.zzfdz.zzblz, this.zzfea.zzgjj.toString(), this.zzfeb.zzgkh);
    }
}
