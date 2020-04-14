package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzckk implements zzcge<zzamd, zzchk> {
    private final zzclp zzgae;

    public zzckk(zzclp zzclp) {
        this.zzgae = zzclp;
    }

    public final zzcgf<zzamd, zzchk> zzd(String str, JSONObject jSONObject) throws zzcwh {
        zzamd zzgc = this.zzgae.zzgc(str);
        if (zzgc == null) {
            return null;
        }
        return new zzcgf<>(zzgc, new zzchk(), str);
    }
}
