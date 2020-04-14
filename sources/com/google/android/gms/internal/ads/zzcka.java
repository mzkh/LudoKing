package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcka implements zzbsu {
    private final zzaxl zzblh;
    private final zzcvr zzfet;
    private final zzcwe zzfga;
    private final zzbzl zzfnm;
    private final zzddi<zzbzb> zzfyq;
    private final zzbbw zzfzt;
    private final Context zzlk;

    private zzcka(Context context, zzbzl zzbzl, zzcwe zzcwe, zzaxl zzaxl, zzcvr zzcvr, zzddi<zzbzb> zzddi, zzbbw zzbbw) {
        this.zzlk = context;
        this.zzfnm = zzbzl;
        this.zzfga = zzcwe;
        this.zzblh = zzaxl;
        this.zzfet = zzcvr;
        this.zzfyq = zzddi;
        this.zzfzt = zzbbw;
    }

    public final void zza(boolean z, Context context) {
        zzbbw zzbbw;
        zzbbw zzbbw2;
        zzbzb zzbzb = (zzbzb) zzdcy.zzc(this.zzfyq);
        try {
            zzcvr zzcvr = this.zzfet;
            if (!this.zzfzt.zzaae()) {
                zzbbw2 = this.zzfzt;
            } else {
                if (!((Boolean) zzuv.zzon().zzd(zzza.zzckf)).booleanValue()) {
                    zzbbw2 = this.zzfzt;
                } else {
                    zzbbw zzc = this.zzfnm.zzc(this.zzfga.zzbll);
                    zzaey.zza(zzc, (zzafb) zzbzb.zzadq());
                    zzcab zzcab = new zzcab();
                    zzcab.zza(this.zzlk, zzc.getView());
                    zzbzb.zzacw().zzb(zzc, true);
                    zzc.zzzp().zza((zzbdf) new zzckd(zzcab, zzc));
                    zzbdg zzzp = zzc.zzzp();
                    zzc.getClass();
                    zzzp.zza(zzckc.zzq(zzc));
                    zzc.zzb(zzcvr.zzgje.zzdhz, zzcvr.zzgje.zzdib, null);
                    zzbbw = zzc;
                    zzbbw.zzas(true);
                    zzq.zzkj();
                    zzg zzg = new zzg(false, zzaul.zzbb(this.zzlk), false, 0.0f, -1, z, this.zzfet.zzgjl, this.zzfet.zzble);
                    zzq.zzki();
                    AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel((zztp) null, (zzo) zzbzb.zzadj(), (zzt) null, zzbbw, this.zzfet.zzgjm, this.zzblh, this.zzfet.zzdkv, zzg, this.zzfet.zzgje.zzdhz, this.zzfet.zzgje.zzdib);
                    zzn.zza(context, adOverlayInfoParcel, true);
                }
            }
            zzbbw = zzbbw2;
            zzbbw.zzas(true);
            zzq.zzkj();
            zzg zzg2 = new zzg(false, zzaul.zzbb(this.zzlk), false, 0.0f, -1, z, this.zzfet.zzgjl, this.zzfet.zzble);
            zzq.zzki();
            AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zztp) null, (zzo) zzbzb.zzadj(), (zzt) null, zzbbw, this.zzfet.zzgjm, this.zzblh, this.zzfet.zzdkv, zzg2, this.zzfet.zzgje.zzdhz, this.zzfet.zzgje.zzdib);
            zzn.zza(context, adOverlayInfoParcel2, true);
        } catch (zzbcf e) {
            zzaxi.zzc("", e);
        }
    }
}
