package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcen extends zzaou {
    private final Executor zzfbx;
    private final zzapr zzfvf;
    private final zzaps zzfvg;
    private final zzbgq zzfvh;
    private final Context zzlk;

    public zzcen(Context context, Executor executor, zzapr zzapr, zzbgq zzbgq, zzaps zzaps) {
        zzza.initialize(context);
        this.zzlk = context;
        this.zzfbx = executor;
        this.zzfvf = zzapr;
        this.zzfvg = zzaps;
        this.zzfvh = zzbgq;
    }

    public final zzaon zza(zzaol zzaol) throws RemoteException {
        return null;
    }

    public final void zza(zzaol zzaol, zzaow zzaow) throws RemoteException {
    }

    public final zzddi<InputStream> zzh(zzape zzape) {
        zzaix zza = zzq.zzkw().zza(this.zzlk, zzaxl.zzwo());
        zzcsm zza2 = this.zzfvh.zza(zzape);
        zzcem zzcem = new zzcem(zza2);
        zzcxn zzcxn = zzcep.zzftu;
        zzaip zza3 = zza.zza("AFMA_getAdDictionary", zzais.zzday, zzceo.zzdba);
        zzaip zza4 = zza.zza("google.afma.response.normalize", zzcew.zzfvn, zzais.zzdaz);
        zzcfb zzcfb = new zzcfb(this.zzlk, zzape.zzdio.zzblz, this.zzfvf, zzape.zzdjp);
        zzcyg zzacu = zza2.zzacu();
        zzcxp zzant = zzacu.zza(zzcyd.GMS_SIGNALS, zzdcy.zzah(zzape.zzdma)).zza(zzcem).zzb(zzcxn).zzant();
        if (((Boolean) zzuv.zzon().zzd(zzza.zzcrs)).booleanValue()) {
            return zzacu.zza(zzcyd.AD_REQUEST, (zzddi<I>) zzant).zza(zza.zza("google.afma.request.getAdResponse", zzais.zzday, zzais.zzday)).zzb(zzcer.zzftu).zzant();
        }
        zzcxp zzant2 = zzacu.zza(zzcyd.BUILD_URL, (zzddi<I>) zzant).zza(zza3).zzant();
        zzcxp zzant3 = zzacu.zza(zzcyd.HTTP, (zzddi<?>[]) new zzddi[]{zzant2, zzant}).zzb(new zzceq(zzant, zzant2)).zzb((zzcxn<O, O2>) zzcfb).zzant();
        return zzacu.zza(zzcyd.PRE_PROCESS, (zzddi<?>[]) new zzddi[]{zzant, zzant2, zzant3}).zzb(new zzcet(zzant3, zzant, zzant2)).zza(zza4).zzant();
    }

    public final void zza(zzape zzape, zzaoy zzaoy) {
        zzddi zzh = zzh(zzape);
        zza(zzh, zzaoy);
        zzh.addListener(new zzces(this), this.zzfbx);
    }

    public final void zzb(zzape zzape, zzaoy zzaoy) {
        zzddi zzddi;
        zzaix zza = zzq.zzkw().zza(this.zzlk, zzaxl.zzwo());
        if (!((Boolean) zzuv.zzon().zzd(zzza.zzcsk)).booleanValue()) {
            zzddi = zzdcy.zzi(new Exception("Signal collection disabled."));
        } else {
            zzcsm zza2 = this.zzfvh.zza(zzape);
            zzcrt zzact = this.zzfvh.zza(zzape).zzact();
            zzddi = zza2.zzacu().zza(zzcyd.GET_SIGNALS, zzdcy.zzah(zzape.zzdma)).zza(new zzcev(zzact)).zzw(zzcyd.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzais.zzday, zzais.zzdaz)).zzant();
        }
        zza(zzddi, zzaoy);
    }

    private final void zza(zzddi<InputStream> zzddi, zzaoy zzaoy) {
        zzdcy.zza(zzdcy.zzb(zzddi, (zzdcj<? super I, ? extends O>) new zzceu<Object,Object>(this), (Executor) zzaxn.zzdwi), new zzcex(this, zzaoy), zzaxn.zzdwn);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzakk() {
        zzaxr.zza(this.zzfvg.zztj(), "persistFlags");
    }
}
