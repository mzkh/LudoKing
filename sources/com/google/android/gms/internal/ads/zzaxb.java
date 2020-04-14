package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzaxb implements zzaxf {
    private final String zzcyz;
    private final Map zzcze;
    private final String zzczh;
    private final byte[] zzdvx;

    zzaxb(String str, String str2, Map map, byte[] bArr) {
        this.zzczh = str;
        this.zzcyz = str2;
        this.zzcze = map;
        this.zzdvx = bArr;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzaxc.zza(this.zzczh, this.zzcyz, this.zzcze, this.zzdvx, jsonWriter);
    }
}
