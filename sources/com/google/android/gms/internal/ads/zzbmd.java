package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmd implements zzbpc {
    private final zzaxl zzblh;
    private final zzaui zzdrp;
    private final zzccj zzfak;
    private final zzcwe zzfga;
    private final Context zzzc;

    public zzbmd(Context context, zzcwe zzcwe, zzaxl zzaxl, zzaui zzaui, zzccj zzccj) {
        this.zzzc = context;
        this.zzfga = zzcwe;
        this.zzblh = zzaxl;
        this.zzdrp = zzaui;
        this.zzfak = zzccj;
    }

    public final void zza(zzcvz zzcvz) {
    }

    public final void zzb(zzape zzape) {
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcow)).booleanValue()) {
            zzq.zzkr().zza(this.zzzc, this.zzblh, this.zzfga.zzgkh, this.zzdrp.zzve());
        }
        this.zzfak.zzaka();
    }
}
