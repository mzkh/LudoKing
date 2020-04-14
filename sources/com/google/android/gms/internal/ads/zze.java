package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zze implements zzs {
    private final Map<String, List<zzq<?>>> zzn = new HashMap();
    private final zzc zzo;

    zze(zzc zzc) {
        this.zzo = zzc;
    }

    public final void zza(zzq<?> zzq, zzz<?> zzz) {
        List<zzq> list;
        if (zzz.zzbh == null || zzz.zzbh.isExpired()) {
            zza(zzq);
            return;
        }
        String zzd = zzq.zzd();
        synchronized (this) {
            list = (List) this.zzn.remove(zzd);
        }
        if (list != null) {
            if (zzag.DEBUG) {
                zzag.m3713v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), zzd);
            }
            for (zzq zzb : list) {
                this.zzo.zzd.zzb(zzb, zzz);
            }
        }
    }

    public final synchronized void zza(zzq<?> zzq) {
        String zzd = zzq.zzd();
        List list = (List) this.zzn.remove(zzd);
        if (list != null && !list.isEmpty()) {
            if (zzag.DEBUG) {
                zzag.m3713v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), zzd);
            }
            zzq zzq2 = (zzq) list.remove(0);
            this.zzn.put(zzd, list);
            zzq2.zza((zzs) this);
            try {
                this.zzo.zzb.put(zzq2);
            } catch (InterruptedException e) {
                zzag.m3712e("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzo.quit();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzb(com.google.android.gms.internal.ads.zzq<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = r6.zzd()     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzq<?>>> r1 = r5.zzn     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003a
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzq<?>>> r1 = r5.zzn     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.zzb(r4)     // Catch:{ all -> 0x0052 }
            r1.add(r6)     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzq<?>>> r6 = r5.zzn     // Catch:{ all -> 0x0052 }
            r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzag.DEBUG     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038
            java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzag.m3711d(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzq<?>>> r1 = r5.zzn     // Catch:{ all -> 0x0052 }
            r4 = 0
            r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
            r6.zza(r5)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzag.DEBUG     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "new request, sending to network %s"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r1[r3] = r0     // Catch:{ all -> 0x0052 }
            com.google.android.gms.internal.ads.zzag.m3711d(r6, r1)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return r3
        L_0x0052:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zze.zzb(com.google.android.gms.internal.ads.zzq):boolean");
    }
}
