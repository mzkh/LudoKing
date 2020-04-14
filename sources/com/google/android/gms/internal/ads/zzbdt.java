package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbdt implements zzaer<zzbbw> {
    private final /* synthetic */ zzbdr zzeie;

    zzbdt(zzbdr zzbdr) {
        this.zzeie = zzbdr;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzeie) {
                        if (this.zzeie.zzeha != parseInt) {
                            this.zzeie.zzeha = parseInt;
                            this.zzeie.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzaug.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
