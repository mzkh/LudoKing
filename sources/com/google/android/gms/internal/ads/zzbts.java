package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbts implements zzaer<Object> {
    private WeakReference<zzbtq> zzfke;

    private zzbts(zzbtq zzbtq) {
        this.zzfke = new WeakReference<>(zzbtq);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzbtq zzbtq = (zzbtq) this.zzfke.get();
        if (zzbtq != null) {
            if ("_ac".equals((String) map.get("eventName"))) {
                zzbtq.zzfjn.onAdClicked();
            }
        }
    }
}
