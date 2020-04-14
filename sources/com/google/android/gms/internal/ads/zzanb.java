package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzanb {
    private final zzbbw zzczi;
    private final boolean zzdgc;
    private final String zzdgd;

    public zzanb(zzbbw zzbbw, Map<String, String> map) {
        this.zzczi = zzbbw;
        this.zzdgd = (String) map.get("forceOrientation");
        String str = "allowOrientationChange";
        if (map.containsKey(str)) {
            this.zzdgc = Boolean.parseBoolean((String) map.get(str));
        } else {
            this.zzdgc = true;
        }
    }

    public final void execute() {
        int i;
        if (this.zzczi == null) {
            zzaug.zzeu("AdWebView is null");
            return;
        }
        if (String.PORTRAIT.equalsIgnoreCase(this.zzdgd)) {
            zzq.zzkl();
            i = 7;
        } else {
            if (String.LANDSCAPE.equalsIgnoreCase(this.zzdgd)) {
                zzq.zzkl();
                i = 6;
            } else if (this.zzdgc) {
                i = -1;
            } else {
                i = zzq.zzkl().zzvq();
            }
        }
        this.zzczi.setRequestedOrientation(i);
    }
}
