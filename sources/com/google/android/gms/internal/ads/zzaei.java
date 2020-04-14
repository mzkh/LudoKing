package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaei implements zzaer<Object> {
    zzaei() {
    }

    public final void zza(Object obj, Map<String, String> map) {
        String valueOf = String.valueOf((String) map.get("string"));
        String str = "Received log message: ";
        zzaug.zzet(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
