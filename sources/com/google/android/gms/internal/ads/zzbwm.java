package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbwm {
    private final zzddl zzfoa;
    private final zzbwq zzfob;
    private final zzbxb zzfoc;

    public zzbwm(zzddl zzddl, zzbwq zzbwq, zzbxb zzbxb) {
        this.zzfoa = zzddl;
        this.zzfob = zzbwq;
        this.zzfoc = zzbxb;
    }

    public final zzddi<zzbur> zza(zzcvz zzcvz, zzcvr zzcvr, JSONObject jSONObject) {
        zzddi zzb;
        JSONObject jSONObject2 = jSONObject;
        zzcvz zzcvz2 = zzcvz;
        zzddi zzd = this.zzfoa.zzd(new zzbwp(this, zzcvz, zzcvr, jSONObject2));
        zzddi zzd2 = this.zzfob.zzd(jSONObject2, "images");
        zzddi zzc = this.zzfob.zzc(jSONObject2, "secondary_image");
        zzddi zzc2 = this.zzfob.zzc(jSONObject2, "app_icon");
        zzddi zze = this.zzfob.zze(jSONObject2, "attribution");
        zzddi zzl = this.zzfob.zzl(jSONObject2);
        zzbwq zzbwq = this.zzfob;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzb = zzdcy.zzah(null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzb = zzdcy.zzah(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzb = zzdcy.zzah(null);
                } else {
                    zzb = zzdcy.zzb(zzdcy.zzah(null), (zzdcj<? super I, ? extends O>) new zzbwu<Object,Object>(zzbwq, optString), (Executor) zzaxn.zzdwm);
                }
            }
        }
        zzddi zzddi = zzb;
        zzddi zzg = this.zzfoc.zzg(jSONObject2, "custom_assets");
        zzddd zza = zzdcy.zza(zzd, zzd2, zzc, zzc2, zze, zzl, zzddi, zzg);
        zzbwo zzbwo = new zzbwo(this, zzd, zzd2, zzc2, zzc, zze, jSONObject, zzl, zzddi, zzg);
        return zza.zza(zzbwo, this.zzfoa);
    }
}
