package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzatw {
    private final Object lock;
    private volatile int zzdrh;
    private volatile long zzdri;

    private zzatw() {
        this.lock = new Object();
        this.zzdrh = zzatv.zzdrd;
        this.zzdri = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzud() {
        /*
            r7 = this;
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzkq()
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r7.lock
            monitor-enter(r2)
            int r3 = r7.zzdrh     // Catch:{ all -> 0x004f }
            int r4 = com.google.android.gms.internal.ads.zzatv.zzdrf     // Catch:{ all -> 0x004f }
            if (r3 != r4) goto L_0x002c
            long r3 = r7.zzdri     // Catch:{ all -> 0x004f }
            com.google.android.gms.internal.ads.zzyp<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzza.zzcsl     // Catch:{ all -> 0x004f }
            com.google.android.gms.internal.ads.zzyw r6 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ all -> 0x004f }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ all -> 0x004f }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x004f }
            long r5 = r5.longValue()     // Catch:{ all -> 0x004f }
            long r3 = r3 + r5
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 > 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.ads.zzatv.zzdrd     // Catch:{ all -> 0x004f }
            r7.zzdrh = r0     // Catch:{ all -> 0x004f }
        L_0x002c:
            monitor-exit(r2)     // Catch:{ all -> 0x004f }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzkq()
            long r0 = r0.currentTimeMillis()
            java.lang.Object r3 = r7.lock
            monitor-enter(r3)
            int r2 = r7.zzdrh     // Catch:{ all -> 0x004c }
            r4 = 2
            if (r2 == r4) goto L_0x003f
            monitor-exit(r3)     // Catch:{ all -> 0x004c }
            return
        L_0x003f:
            r2 = 3
            r7.zzdrh = r2     // Catch:{ all -> 0x004c }
            int r2 = r7.zzdrh     // Catch:{ all -> 0x004c }
            int r4 = com.google.android.gms.internal.ads.zzatv.zzdrf     // Catch:{ all -> 0x004c }
            if (r2 != r4) goto L_0x004a
            r7.zzdri = r0     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r3)     // Catch:{ all -> 0x004c }
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x004c }
            throw r0
        L_0x004f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatw.zzud():void");
    }

    /* synthetic */ zzatw(zzatt zzatt) {
        this();
    }
}
