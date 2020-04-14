package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcie implements zzcge<zzcwm, zzchk> {
    private final zzchm zzfsy;

    public zzcie(zzchm zzchm) {
        this.zzfsy = zzchm;
    }

    public final zzcgf<zzcwm, zzchk> zzd(String str, JSONObject jSONObject) throws zzcwh {
        zzcwm zze = this.zzfsy.zze(str, jSONObject);
        if (zze == null) {
            return null;
        }
        return new zzcgf<>(zze, new zzchk(), str);
    }
}
