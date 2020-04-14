package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbtv implements zzaer<Object> {
    private WeakReference<zzbtq> zzfke;

    private zzbtv(zzbtq zzbtq) {
        this.zzfke = new WeakReference<>(zzbtq);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzbtq zzbtq = (zzbtq) this.zzfke.get();
        if (zzbtq != null) {
            zzbtq.zzfjm.onAdImpression();
        }
    }
}
