package com.google.android.gms.internal.ads;

import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcii implements zzdcj {
    private final zzcvr zzfea;
    private final zzcvz zzfom;
    private final zzcig zzfyv;

    zzcii(zzcig zzcig, zzcvz zzcvz, zzcvr zzcvr) {
        this.zzfyv = zzcig;
        this.zzfom = zzcvz;
        this.zzfea = zzcvr;
    }

    public final zzddi zzf(Object obj) {
        return this.zzfyv.zza(this.zzfom, this.zzfea, (JSONArray) obj);
    }
}
