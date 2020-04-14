package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhq implements zzdwb<zzpe> {
    private final zzdwo<JSONObject> zzetw;
    private final zzdwo<zzcvr> zzfcp;
    private final zzdwo<zzaxl> zzfcq;
    private final zzdwo<String> zzfcr;

    private zzbhq(zzdwo<zzcvr> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<JSONObject> zzdwo3, zzdwo<String> zzdwo4) {
        this.zzfcp = zzdwo;
        this.zzfcq = zzdwo2;
        this.zzetw = zzdwo3;
        this.zzfcr = zzdwo4;
    }

    public static zzbhq zza(zzdwo<zzcvr> zzdwo, zzdwo<zzaxl> zzdwo2, zzdwo<JSONObject> zzdwo3, zzdwo<String> zzdwo4) {
        return new zzbhq(zzdwo, zzdwo2, zzdwo3, zzdwo4);
    }

    public final /* synthetic */ Object get() {
        this.zzfcp.get();
        zzaxl zzaxl = (zzaxl) this.zzfcq.get();
        JSONObject jSONObject = (JSONObject) this.zzetw.get();
        String str = (String) this.zzfcr.get();
        boolean equals = "native".equals(str);
        zzq.zzkj();
        zzpe zzpe = new zzpe(zzaul.zzvm(), zzaxl, str, jSONObject, false, equals);
        return (zzpe) zzdwh.zza(zzpe, "Cannot return null from a non-@Nullable @Provides method");
    }
}
