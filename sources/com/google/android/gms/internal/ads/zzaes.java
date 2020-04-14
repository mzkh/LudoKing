package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaes implements zzaer<zzbbw> {
    private static final Map<String, Integer> zzcya = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7)});
    private final zzc zzcxx;
    private final zzamz zzcxy;
    private final zzani zzcxz;

    public zzaes(zzc zzc, zzamz zzamz, zzani zzani) {
        this.zzcxx = zzc;
        this.zzcxy = zzamz;
        this.zzcxz = zzani;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbbw zzbbw = (zzbbw) obj;
        int intValue = ((Integer) zzcya.get((String) map.get("a"))).intValue();
        if (!(intValue == 5 || intValue == 7)) {
            zzc zzc = this.zzcxx;
            if (zzc != null && !zzc.zzjk()) {
                this.zzcxx.zzbl(null);
                return;
            }
        }
        if (intValue == 1) {
            this.zzcxy.zzg(map);
        } else if (intValue == 3) {
            new zzana(zzbbw, map).execute();
        } else if (intValue == 4) {
            new zzamu(zzbbw, map).execute();
        } else if (intValue == 5) {
            new zzanb(zzbbw, map).execute();
        } else if (intValue == 6) {
            this.zzcxy.zzv(true);
        } else if (intValue != 7) {
            zzaug.zzet("Unknown MRAID command called.");
        } else {
            this.zzcxz.zzsm();
        }
    }
}
