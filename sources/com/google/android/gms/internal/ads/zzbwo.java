package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbwo implements Callable {
    private final zzddi zzffr;
    private final zzbwm zzfod;
    private final zzddi zzfoe;
    private final zzddi zzfof;
    private final zzddi zzfog;
    private final zzddi zzfoh;
    private final JSONObject zzfoi;
    private final zzddi zzfoj;
    private final zzddi zzfok;
    private final zzddi zzfol;

    zzbwo(zzbwm zzbwm, zzddi zzddi, zzddi zzddi2, zzddi zzddi3, zzddi zzddi4, zzddi zzddi5, JSONObject jSONObject, zzddi zzddi6, zzddi zzddi7, zzddi zzddi8) {
        this.zzfod = zzbwm;
        this.zzfoe = zzddi;
        this.zzffr = zzddi2;
        this.zzfof = zzddi3;
        this.zzfog = zzddi4;
        this.zzfoh = zzddi5;
        this.zzfoi = jSONObject;
        this.zzfoj = zzddi6;
        this.zzfok = zzddi7;
        this.zzfol = zzddi8;
    }

    public final Object call() {
        zzbwm zzbwm = this.zzfod;
        zzddi zzddi = this.zzfoe;
        zzddi zzddi2 = this.zzffr;
        zzddi zzddi3 = this.zzfof;
        zzddi zzddi4 = this.zzfog;
        zzddi zzddi5 = this.zzfoh;
        JSONObject jSONObject = this.zzfoi;
        zzddi zzddi6 = this.zzfoj;
        zzddi zzddi7 = this.zzfok;
        zzddi zzddi8 = this.zzfol;
        zzbur zzbur = (zzbur) zzddi.get();
        zzbur.setImages((List) zzddi2.get());
        zzbur.zza((zzabi) zzddi3.get());
        zzbur.zzb((zzabi) zzddi4.get());
        zzbur.zza((zzaba) zzddi5.get());
        zzbur.zzf(zzbwq.zzi(jSONObject));
        zzbur.zza(zzbwq.zzj(jSONObject));
        zzbbw zzbbw = (zzbbw) zzddi6.get();
        if (zzbbw != null) {
            zzbur.zzi(zzbbw);
            zzbur.zzaa(zzbbw.getView());
            zzbur.zzb((zzwr) zzbbw.zzxl());
        }
        zzbbw zzbbw2 = (zzbbw) zzddi7.get();
        if (zzbbw2 != null) {
            zzbur.zzj(zzbbw2);
        }
        for (zzbxc zzbxc : (List) zzddi8.get()) {
            int i = zzbxc.type;
            if (i == 1) {
                zzbur.zzo(zzbxc.zzce, zzbxc.zzfpa);
            } else if (i == 2) {
                zzbur.zza(zzbxc.zzce, zzbxc.zzfpb);
            }
        }
        return zzbur;
    }
}
