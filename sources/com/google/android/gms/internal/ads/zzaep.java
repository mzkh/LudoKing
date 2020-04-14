package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants.String;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaep implements zzaer<zzbbw> {
    zzaep() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbbw zzbbw = (zzbbw) obj;
        if (map.keySet().contains(String.VIDEO_START)) {
            zzbbw.zzau(true);
        }
        if (map.keySet().contains("stop")) {
            zzbbw.zzau(false);
        }
    }
}
