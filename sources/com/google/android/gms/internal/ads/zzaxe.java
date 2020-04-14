package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final /* synthetic */ class zzaxe implements zzaxf {
    private final int zzdwc;
    private final Map zzdwd;

    zzaxe(int i, Map map) {
        this.zzdwc = i;
        this.zzdwd = map;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzaxc.zza(this.zzdwc, this.zzdwd, jsonWriter);
    }
}
