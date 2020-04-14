package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcjv implements zzcge<zzcwm, zzchn> {
    private final zzchm zzfsy;
    @GuardedBy("this")
    private final Map<String, zzcgf<zzcwm, zzchn>> zzfzq = new HashMap();

    public zzcjv(zzchm zzchm) {
        this.zzfsy = zzchm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzcgf<com.google.android.gms.internal.ads.zzcwm, com.google.android.gms.internal.ads.zzchn> zzd(java.lang.String r3, org.json.JSONObject r4) throws com.google.android.gms.internal.ads.zzcwh {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.zzcgf<com.google.android.gms.internal.ads.zzcwm, com.google.android.gms.internal.ads.zzchn>> r0 = r2.zzfzq     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzcgf r0 = (com.google.android.gms.internal.ads.zzcgf) r0     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzchm r0 = r2.zzfsy     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzcwm r4 = r0.zze(r3, r4)     // Catch:{ all -> 0x0027 }
            if (r4 != 0) goto L_0x0016
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return r3
        L_0x0016:
            com.google.android.gms.internal.ads.zzcgf r0 = new com.google.android.gms.internal.ads.zzcgf     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzchn r1 = new com.google.android.gms.internal.ads.zzchn     // Catch:{ all -> 0x0027 }
            r1.<init>()     // Catch:{ all -> 0x0027 }
            r0.<init>(r4, r1, r3)     // Catch:{ all -> 0x0027 }
            java.util.Map<java.lang.String, com.google.android.gms.internal.ads.zzcgf<com.google.android.gms.internal.ads.zzcwm, com.google.android.gms.internal.ads.zzchn>> r4 = r2.zzfzq     // Catch:{ all -> 0x0027 }
            r4.put(r3, r0)     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            return r0
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0027 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjv.zzd(java.lang.String, org.json.JSONObject):com.google.android.gms.internal.ads.zzcgf");
    }
}
