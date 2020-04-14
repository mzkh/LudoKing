package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbcd implements Callable {
    private final String zzdbt;
    private final Context zzdpy;
    private final zzbdj zzefg;
    private final boolean zzefh;
    private final boolean zzefi;
    private final zzdf zzefj;
    private final zzaxl zzefk;
    private final zzaab zzefl = null;
    private final zzi zzefm;
    private final zza zzefn;
    private final zzsd zzefo;
    private final zzrf zzefp;
    private final boolean zzefq;

    zzbcd(Context context, zzbdj zzbdj, String str, boolean z, boolean z2, zzdf zzdf, zzaxl zzaxl, zzaab zzaab, zzi zzi, zza zza, zzsd zzsd, zzrf zzrf, boolean z3) {
        this.zzdpy = context;
        this.zzefg = zzbdj;
        this.zzdbt = str;
        this.zzefh = z;
        this.zzefi = z2;
        this.zzefj = zzdf;
        this.zzefk = zzaxl;
        this.zzefm = zzi;
        this.zzefn = zza;
        this.zzefo = zzsd;
        this.zzefp = zzrf;
        this.zzefq = z3;
    }

    public final Object call() {
        Context context = this.zzdpy;
        zzbdj zzbdj = this.zzefg;
        String str = this.zzdbt;
        boolean z = this.zzefh;
        boolean z2 = this.zzefi;
        zzdf zzdf = this.zzefj;
        zzaxl zzaxl = this.zzefk;
        zzaab zzaab = this.zzefl;
        zzi zzi = this.zzefm;
        zza zza = this.zzefn;
        zzsd zzsd = this.zzefo;
        zzbci zzbci = new zzbci(zzbck.zzb(context, zzbdj, str, z, z2, zzdf, zzaxl, zzaab, zzi, zza, zzsd, this.zzefp, this.zzefq));
        zzbci.setWebViewClient(zzq.zzkl().zza(zzbci, zzsd, z2));
        zzbci.setWebChromeClient(new zzbbo(zzbci));
        return zzbci;
    }
}
