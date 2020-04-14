package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants.String;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzadz implements zzaer<Object> {
    private final zzady zzcxd;

    public zzadz(zzady zzady) {
        this.zzcxd = zzady;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzaug.zzeu("App event with no name parameter.");
        } else {
            this.zzcxd.onAppEvent(str, (String) map.get(String.VIDEO_INFO));
        }
    }
}
