package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbgv implements zzbgs {
    private zzaui zzdrp;

    public zzbgv(zzaui zzaui) {
        this.zzdrp = zzaui;
    }

    public final void zzk(Map<String, String> map) {
        this.zzdrp.zzah(Boolean.parseBoolean((String) map.get("content_url_opted_out")));
    }
}
