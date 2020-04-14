package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhy implements zzdwb<JSONObject> {
    private final zzdwo<zzcvr> zzfcp;

    private zzbhy(zzdwo<zzcvr> zzdwo) {
        this.zzfcp = zzdwo;
    }

    public static zzbhy zzc(zzdwo<zzcvr> zzdwo) {
        return new zzbhy(zzdwo);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return zzbhz.zza((zzcvr) this.zzfcp.get());
    }
}
