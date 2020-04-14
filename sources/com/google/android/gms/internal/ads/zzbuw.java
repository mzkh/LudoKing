package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbuw implements zzdwb<zzbuu> {
    private final zzdwo<JSONObject> zzetu;
    private final zzdwo<zzcvr> zzfcp;

    public zzbuw(zzdwo<zzcvr> zzdwo, zzdwo<JSONObject> zzdwo2) {
        this.zzfcp = zzdwo;
        this.zzetu = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return new zzbuu((zzcvr) this.zzfcp.get(), (JSONObject) this.zzetu.get());
    }
}
