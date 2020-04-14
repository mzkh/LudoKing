package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzchu implements zzbsu {
    private final zzaxl zzblh;
    private final zzcvr zzflx;
    private final zzddi<zzbru> zzfyq;
    private final zzbbw zzfyr;
    private final Context zzlk;

    private zzchu(Context context, zzaxl zzaxl, zzddi<zzbru> zzddi, zzcvr zzcvr, zzbbw zzbbw) {
        this.zzlk = context;
        this.zzblh = zzaxl;
        this.zzfyq = zzddi;
        this.zzflx = zzcvr;
        this.zzfyr = zzbbw;
    }

    public final void zza(boolean z, Context context) {
        zzbru zzbru = (zzbru) zzdcy.zzc(this.zzfyq);
        this.zzfyr.zzas(true);
        zzq.zzkj();
        zzg zzg = new zzg(false, zzaul.zzbb(this.zzlk), false, 0.0f, -1, z, this.zzflx.zzgjl, false);
        zzq.zzki();
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel((zztp) null, (zzo) zzbru.zzadj(), (zzt) null, this.zzfyr, this.zzflx.zzgjm, this.zzblh, this.zzflx.zzdkv, zzg, this.zzflx.zzgje.zzdhz, this.zzflx.zzgje.zzdib);
        zzn.zza(context, adOverlayInfoParcel, true);
    }
}
