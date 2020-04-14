package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzccx {
    private final zzddl zzfoa;
    private final zzddl zzftr;
    private final zzcea zzfts;
    private final zzdvv<zzcen> zzftt;

    public zzccx(zzddl zzddl, zzddl zzddl2, zzcea zzcea, zzdvv<zzcen> zzdvv) {
        this.zzftr = zzddl;
        this.zzfoa = zzddl2;
        this.zzfts = zzcea;
        this.zzftt = zzdvv;
    }

    public final zzddi<InputStream> zzc(zzape zzape) {
        zzddi zzddi;
        String str = zzape.packageName;
        zzq.zzkj();
        if (zzaul.zzeh(str)) {
            zzddi = zzdcy.zzi(new zzcel(0));
        } else {
            if (((Boolean) zzuv.zzon().zzd(zzza.zzcrr)).booleanValue()) {
                zzddi = zzdcy.zzb(this.zzftr.zzd(new zzccw(this, zzape)), ExecutionException.class, zzccz.zzbkv, this.zzfoa);
            } else {
                zzddi = this.zzfts.zzf(zzape);
            }
        }
        zzddi<InputStream> zzb = zzdcy.zzb(zzddi, zzcel.class, new zzccy(this, zzape), this.zzfoa);
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcrr)).booleanValue()) {
            zzb.addListener(new zzcdb(zzddi), zzaxn.zzdwn);
        }
        return zzb;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(zzape zzape, zzcel zzcel) throws Exception {
        return ((zzcen) this.zzftt.get()).zzh(zzape);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ InputStream zzd(zzape zzape) throws Exception {
        return (InputStream) this.zzfts.zzf(zzape).get((long) ((Integer) zzuv.zzon().zzd(zzza.zzcrq)).intValue(), TimeUnit.SECONDS);
    }
}
