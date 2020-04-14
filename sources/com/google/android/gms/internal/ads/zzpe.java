package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzpe {
    private final String zzblw;
    private final JSONObject zzblx;
    private final String zzbly;
    private final String zzblz;
    private final boolean zzbma = false;
    private final boolean zzbmb;

    public zzpe(String str, zzaxl zzaxl, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzblz = zzaxl.zzblz;
        this.zzblx = jSONObject;
        this.zzbly = str;
        this.zzblw = str2;
        this.zzbmb = z2;
    }

    public final String zzkc() {
        return this.zzblw;
    }

    public final String zzkd() {
        return this.zzblz;
    }

    public final JSONObject zzke() {
        return this.zzblx;
    }

    public final String zzkf() {
        return this.zzbly;
    }

    public final boolean zzkg() {
        return this.zzbmb;
    }
}
