package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants.String;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzaem implements zzaer<zzbbw> {
    zzaem() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbbw zzbbw = (zzbbw) obj;
        if (map.keySet().contains(String.VIDEO_START)) {
            zzbbw.zzzp().zzzc();
        } else if (map.keySet().contains("stop")) {
            zzbbw.zzzp().zzzd();
        } else {
            if (map.keySet().contains("cancel")) {
                zzbbw.zzzp().zzze();
            }
        }
    }
}
