package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzma {
    private int length;
    private int[] zzamu;
    private long[] zzamv;
    private long[] zzamx;
    private int[] zzavk;
    private int zzbbv = 1000;
    private int[] zzbbw;
    private zzjg[] zzbbx;
    private zzgo[] zzbby;
    private int zzbbz;
    private int zzbca;
    private int zzbcb;
    private long zzbcc;
    private long zzbcd;
    private boolean zzbce;
    private boolean zzbcf;
    private zzgo zzbcg;

    public zzma() {
        int i = this.zzbbv;
        this.zzbbw = new int[i];
        this.zzamv = new long[i];
        this.zzamx = new long[i];
        this.zzavk = new int[i];
        this.zzamu = new int[i];
        this.zzbbx = new zzjg[i];
        this.zzbby = new zzgo[i];
        this.zzbcc = Long.MIN_VALUE;
        this.zzbcd = Long.MIN_VALUE;
        this.zzbcf = true;
        this.zzbce = true;
    }

    public final void zzhn() {
        this.zzbbz = 0;
        this.zzbca = 0;
        this.zzbcb = 0;
        this.length = 0;
        this.zzbce = true;
    }

    public final void zzho() {
        this.zzbcc = Long.MIN_VALUE;
        this.zzbcd = Long.MIN_VALUE;
    }

    public final int zzhp() {
        return this.zzbbz + this.length;
    }

    public final synchronized boolean zzhq() {
        return this.length != 0;
    }

    public final synchronized zzgo zzhr() {
        if (this.zzbcf) {
            return null;
        }
        return this.zzbcg;
    }

    public final synchronized long zzhh() {
        return Math.max(this.zzbcc, this.zzbcd);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zza(com.google.android.gms.internal.ads.zzgq r5, com.google.android.gms.internal.ads.zzik r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzgo r9, com.google.android.gms.internal.ads.zzlz r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzhq()     // Catch:{ all -> 0x00a6 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0024
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzgo r6 = r4.zzbcg     // Catch:{ all -> 0x00a6 }
            if (r6 == 0) goto L_0x0022
            if (r7 != 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzgo r6 = r4.zzbcg     // Catch:{ all -> 0x00a6 }
            if (r6 == r9) goto L_0x0022
        L_0x001c:
            com.google.android.gms.internal.ads.zzgo r6 = r4.zzbcg     // Catch:{ all -> 0x00a6 }
            r5.zzafx = r6     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r1
        L_0x0022:
            monitor-exit(r4)
            return r2
        L_0x0024:
            if (r7 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzgo[] r7 = r4.zzbby     // Catch:{ all -> 0x00a6 }
            int r8 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            r7 = r7[r8]     // Catch:{ all -> 0x00a6 }
            if (r7 == r9) goto L_0x002f
            goto L_0x009c
        L_0x002f:
            java.nio.ByteBuffer r5 = r6.zzcq     // Catch:{ all -> 0x00a6 }
            r7 = 0
            r8 = 1
            if (r5 != 0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            monitor-exit(r4)
            return r2
        L_0x003c:
            long[] r5 = r4.zzamx     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r6.zzamb = r0     // Catch:{ all -> 0x00a6 }
            int[] r5 = r4.zzavk     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r6.setFlags(r5)     // Catch:{ all -> 0x00a6 }
            int[] r5 = r4.zzamu     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.size = r5     // Catch:{ all -> 0x00a6 }
            long[] r5 = r4.zzamv     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.zzauv = r0     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzjg[] r5 = r4.zzbbx     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.zzapp = r5     // Catch:{ all -> 0x00a6 }
            long r0 = r4.zzbcc     // Catch:{ all -> 0x00a6 }
            long r5 = r6.zzamb     // Catch:{ all -> 0x00a6 }
            long r5 = java.lang.Math.max(r0, r5)     // Catch:{ all -> 0x00a6 }
            r4.zzbcc = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.length     // Catch:{ all -> 0x00a6 }
            int r5 = r5 - r8
            r4.length = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            int r5 = r5 + r8
            r4.zzbca = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbbz     // Catch:{ all -> 0x00a6 }
            int r5 = r5 + r8
            r4.zzbbz = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            int r6 = r4.zzbbv     // Catch:{ all -> 0x00a6 }
            if (r5 != r6) goto L_0x0086
            r4.zzbca = r7     // Catch:{ all -> 0x00a6 }
        L_0x0086:
            int r5 = r4.length     // Catch:{ all -> 0x00a6 }
            if (r5 <= 0) goto L_0x0092
            long[] r5 = r4.zzamv     // Catch:{ all -> 0x00a6 }
            int r6 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            r6 = r5[r6]     // Catch:{ all -> 0x00a6 }
            r5 = r6
            goto L_0x0098
        L_0x0092:
            long r5 = r10.zzauv     // Catch:{ all -> 0x00a6 }
            int r7 = r10.size     // Catch:{ all -> 0x00a6 }
            long r7 = (long) r7     // Catch:{ all -> 0x00a6 }
            long r5 = r5 + r7
        L_0x0098:
            r10.zzbbu = r5     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r3
        L_0x009c:
            com.google.android.gms.internal.ads.zzgo[] r6 = r4.zzbby     // Catch:{ all -> 0x00a6 }
            int r7 = r4.zzbca     // Catch:{ all -> 0x00a6 }
            r6 = r6[r7]     // Catch:{ all -> 0x00a6 }
            r5.zzafx = r6     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r1
        L_0x00a6:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzma.zza(com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzik, boolean, boolean, com.google.android.gms.internal.ads.zzgo, com.google.android.gms.internal.ads.zzlz):int");
    }

    public final synchronized long zzhs() {
        if (!zzhq()) {
            return -1;
        }
        int i = ((this.zzbca + this.length) - 1) % this.zzbbv;
        this.zzbca = (this.zzbca + this.length) % this.zzbbv;
        this.zzbbz += this.length;
        this.length = 0;
        return this.zzamv[i] + ((long) this.zzamu[i]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzd(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzhq()     // Catch:{ all -> 0x0061 }
            r1 = -1
            if (r0 == 0) goto L_0x005f
            long[] r0 = r8.zzamx     // Catch:{ all -> 0x0061 }
            int r3 = r8.zzbca     // Catch:{ all -> 0x0061 }
            r3 = r0[r3]     // Catch:{ all -> 0x0061 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005f
        L_0x0014:
            long r3 = r8.zzbcd     // Catch:{ all -> 0x0061 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            if (r11 != 0) goto L_0x001e
            monitor-exit(r8)
            return r1
        L_0x001e:
            r11 = 0
            int r0 = r8.zzbca     // Catch:{ all -> 0x0061 }
            r3 = -1
            r11 = -1
            r4 = 0
        L_0x0024:
            int r5 = r8.zzbcb     // Catch:{ all -> 0x0061 }
            if (r0 == r5) goto L_0x0041
            long[] r5 = r8.zzamx     // Catch:{ all -> 0x0061 }
            r6 = r5[r0]     // Catch:{ all -> 0x0061 }
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0041
            int[] r5 = r8.zzavk     // Catch:{ all -> 0x0061 }
            r5 = r5[r0]     // Catch:{ all -> 0x0061 }
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0039
            r11 = r4
        L_0x0039:
            int r0 = r0 + 1
            int r5 = r8.zzbbv     // Catch:{ all -> 0x0061 }
            int r0 = r0 % r5
            int r4 = r4 + 1
            goto L_0x0024
        L_0x0041:
            if (r11 != r3) goto L_0x0045
            monitor-exit(r8)
            return r1
        L_0x0045:
            int r9 = r8.zzbca     // Catch:{ all -> 0x0061 }
            int r9 = r9 + r11
            int r10 = r8.zzbbv     // Catch:{ all -> 0x0061 }
            int r9 = r9 % r10
            r8.zzbca = r9     // Catch:{ all -> 0x0061 }
            int r9 = r8.zzbbz     // Catch:{ all -> 0x0061 }
            int r9 = r9 + r11
            r8.zzbbz = r9     // Catch:{ all -> 0x0061 }
            int r9 = r8.length     // Catch:{ all -> 0x0061 }
            int r9 = r9 - r11
            r8.length = r9     // Catch:{ all -> 0x0061 }
            long[] r9 = r8.zzamv     // Catch:{ all -> 0x0061 }
            int r10 = r8.zzbca     // Catch:{ all -> 0x0061 }
            r10 = r9[r10]     // Catch:{ all -> 0x0061 }
            monitor-exit(r8)
            return r10
        L_0x005f:
            monitor-exit(r8)
            return r1
        L_0x0061:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzma.zzd(long, boolean):long");
    }

    public final synchronized boolean zzg(zzgo zzgo) {
        if (zzgo == null) {
            this.zzbcf = true;
            return false;
        }
        this.zzbcf = false;
        if (zzof.zza(zzgo, this.zzbcg)) {
            return false;
        }
        this.zzbcg = zzgo;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ea, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(long r6, int r8, long r9, int r11, com.google.android.gms.internal.ads.zzjg r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzbce     // Catch:{ all -> 0x00eb }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.zzbce = r1     // Catch:{ all -> 0x00eb }
        L_0x000e:
            boolean r0 = r5.zzbcf     // Catch:{ all -> 0x00eb }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.internal.ads.zznr.checkState(r0)     // Catch:{ all -> 0x00eb }
            r5.zzec(r6)     // Catch:{ all -> 0x00eb }
            long[] r0 = r5.zzamx     // Catch:{ all -> 0x00eb }
            int r3 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            r0[r3] = r6     // Catch:{ all -> 0x00eb }
            long[] r6 = r5.zzamv     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            r6[r7] = r9     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.zzamu     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            r6[r7] = r11     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.zzavk     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            r6[r7] = r8     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzjg[] r6 = r5.zzbbx     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            r6[r7] = r12     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzgo[] r6 = r5.zzbby     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzgo r8 = r5.zzbcg     // Catch:{ all -> 0x00eb }
            r6[r7] = r8     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.zzbbw     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            r6[r7] = r1     // Catch:{ all -> 0x00eb }
            int r6 = r5.length     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r2
            r5.length = r6     // Catch:{ all -> 0x00eb }
            int r6 = r5.length     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbbv     // Catch:{ all -> 0x00eb }
            if (r6 != r7) goto L_0x00dc
            int r6 = r5.zzbbv     // Catch:{ all -> 0x00eb }
            int r6 = r6 + 1000
            int[] r7 = new int[r6]     // Catch:{ all -> 0x00eb }
            long[] r8 = new long[r6]     // Catch:{ all -> 0x00eb }
            long[] r9 = new long[r6]     // Catch:{ all -> 0x00eb }
            int[] r10 = new int[r6]     // Catch:{ all -> 0x00eb }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzjg[] r12 = new com.google.android.gms.internal.ads.zzjg[r6]     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzgo[] r0 = new com.google.android.gms.internal.ads.zzgo[r6]     // Catch:{ all -> 0x00eb }
            int r2 = r5.zzbbv     // Catch:{ all -> 0x00eb }
            int r3 = r5.zzbca     // Catch:{ all -> 0x00eb }
            int r2 = r2 - r3
            long[] r3 = r5.zzamv     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbca     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00eb }
            long[] r3 = r5.zzamx     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbca     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.zzavk     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbca     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.zzamu     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbca     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzjg[] r3 = r5.zzbbx     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbca     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzgo[] r3 = r5.zzbby     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbca     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.zzbbw     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbca     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00eb }
            int r3 = r5.zzbca     // Catch:{ all -> 0x00eb }
            long[] r4 = r5.zzamv     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00eb }
            long[] r4 = r5.zzamx     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.zzavk     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.zzamu     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzjg[] r4 = r5.zzbbx     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzgo[] r4 = r5.zzbby     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.zzbbw     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00eb }
            r5.zzamv = r8     // Catch:{ all -> 0x00eb }
            r5.zzamx = r9     // Catch:{ all -> 0x00eb }
            r5.zzavk = r10     // Catch:{ all -> 0x00eb }
            r5.zzamu = r11     // Catch:{ all -> 0x00eb }
            r5.zzbbx = r12     // Catch:{ all -> 0x00eb }
            r5.zzbby = r0     // Catch:{ all -> 0x00eb }
            r5.zzbbw = r7     // Catch:{ all -> 0x00eb }
            r5.zzbca = r1     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbbv     // Catch:{ all -> 0x00eb }
            r5.zzbcb = r7     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbbv     // Catch:{ all -> 0x00eb }
            r5.length = r7     // Catch:{ all -> 0x00eb }
            r5.zzbbv = r6     // Catch:{ all -> 0x00eb }
            monitor-exit(r5)
            return
        L_0x00dc:
            int r6 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r2
            r5.zzbcb = r6     // Catch:{ all -> 0x00eb }
            int r6 = r5.zzbcb     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbbv     // Catch:{ all -> 0x00eb }
            if (r6 != r7) goto L_0x00e9
            r5.zzbcb = r1     // Catch:{ all -> 0x00eb }
        L_0x00e9:
            monitor-exit(r5)
            return
        L_0x00eb:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzma.zza(long, int, long, int, com.google.android.gms.internal.ads.zzjg):void");
    }

    public final synchronized void zzec(long j) {
        this.zzbcd = Math.max(this.zzbcd, j);
    }
}
