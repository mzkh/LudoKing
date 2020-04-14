package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbgy implements zzbgs {
    private final zzaui zzdrp;

    public zzbgy(zzaui zzaui) {
        this.zzdrp = zzaui;
    }

    public final void zzk(Map<String, String> map) {
        String str = (String) map.get("key");
        String str2 = (String) map.get("value");
        if ("auto_collect_location".equals(str)) {
            this.zzdrp.zzaj(Boolean.parseBoolean(str2));
        }
    }
}
