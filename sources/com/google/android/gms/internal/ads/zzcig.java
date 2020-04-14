package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcig implements zzcih<zzbuj> {
    private final zzddl zzfoa;
    private final zzbtl zzfyt;
    private final zzbwm zzfyu;

    public zzcig(zzbtl zzbtl, zzddl zzddl, zzbwm zzbwm) {
        this.zzfyt = zzbtl;
        this.zzfoa = zzddl;
        this.zzfyu = zzbwm;
    }

    public final boolean zza(zzcvz zzcvz, zzcvr zzcvr) {
        return (zzcvr.zzgje == null || zzcvr.zzgje.zzfjj == null) ? false : true;
    }

    public final zzddi<List<zzddi<zzbuj>>> zzb(zzcvz zzcvz, zzcvr zzcvr) {
        zzddi zzanf = this.zzfyt.zzacc().zzanf();
        this.zzfyt.zzacc().zza(zzanf);
        return zzdcy.zzb(zzdcy.zzb(zzanf, (zzdcj<? super I, ? extends O>) new zzcij<Object,Object>(this, zzcvr), (Executor) this.zzfoa), (zzdcj<? super I, ? extends O>) new zzcii<Object,Object>(this, zzcvz, zzcvr), (Executor) this.zzfoa);
    }

    private final zzddi<zzbuj> zzb(zzcvz zzcvz, zzcvr zzcvr, JSONObject jSONObject) {
        zzddi zzanf = this.zzfyt.zzacc().zzanf();
        zzddi zza = this.zzfyu.zza(zzcvz, zzcvr, jSONObject);
        zzddd zza2 = zzdcy.zza(zzanf, zza);
        zzcin zzcin = new zzcin(this, zza, zzanf, zzcvz, zzcvr, jSONObject);
        return zza2.zza(zzcin, this.zzfoa);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzbuj zza(zzddi zzddi, zzddi zzddi2, zzcvz zzcvz, zzcvr zzcvr, JSONObject jSONObject) throws Exception {
        zzbur zzbur = (zzbur) zzddi.get();
        zzbyh zzbyh = (zzbyh) zzddi2.get();
        zzbut zza = this.zzfyt.zza(new zzbla(zzcvz, zzcvr, null), new zzbvd(zzbur), new zzbtx(jSONObject, zzbyh));
        zza.zzacm().zzajf();
        zza.zzacn().zzb(zzbyh);
        zza.zzaco().zzl(zzbur.zzahu());
        return zza.zzacl();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(zzcvz zzcvz, zzcvr zzcvr, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzdcy.zzi(new zzccu(3));
        }
        if (zzcvz.zzgka.zzfga.zzgdf <= 1) {
            return zzdcy.zzb(zzb(zzcvz, zzcvr, jSONArray.getJSONObject(0)), zzcik.zzdos, (Executor) this.zzfoa);
        }
        int length = jSONArray.length();
        this.zzfyt.zzacc().zzdj(Math.min(length, zzcvz.zzgka.zzfga.zzgdf));
        ArrayList arrayList = new ArrayList(zzcvz.zzgka.zzfga.zzgdf);
        for (int i = 0; i < zzcvz.zzgka.zzfga.zzgdf; i++) {
            if (i < length) {
                arrayList.add(zzb(zzcvz, zzcvr, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzdcy.zzi(new zzccu(3)));
            }
        }
        return zzdcy.zzah(arrayList);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ zzddi zza(zzcvr zzcvr, zzbyh zzbyh) throws Exception {
        JSONObject zza = zzawg.zza("isNonagon", (Object) Boolean.valueOf(true));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzcvr.zzgje.zzfjj);
        jSONObject.put("sdk_params", zza);
        return zzdcy.zzb(zzbyh.zzc("google.afma.nativeAds.preProcessJson", jSONObject), zzcil.zzbkv, (Executor) this.zzfoa);
    }
}
