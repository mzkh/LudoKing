package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbcm implements zzaer<zzbbw> {
    private final /* synthetic */ zzbck zzehj;

    zzbcm(zzbck zzbck) {
        this.zzehj = zzbck;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzehj) {
                        if (this.zzehj.zzeha != parseInt) {
                            this.zzehj.zzeha = parseInt;
                            this.zzehj.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzaug.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
