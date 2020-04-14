package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbbj extends zzbax implements zzns<zzne> {
    private String url;
    private ByteBuffer zzakm;
    private final zzazk zzebk;
    private boolean zzedu;
    private final zzbbk zzedv = new zzbbk();
    private final zzbap zzedw = new zzbap();
    private boolean zzedx;
    private final Object zzedy = new Object();
    private boolean zzedz;

    public zzbbj(zzazj zzazj, zzazk zzazk) {
        super(zzazj);
        this.zzebk = zzazk;
    }

    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zzys() {
        return this.zzedz;
    }

    /* access modifiers changed from: protected */
    public final String zzfe(String str) {
        String valueOf = String.valueOf(super.zzfe(str));
        String str2 = "cache:";
        return valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
    }

    private final void zzxd() {
        int zzyt = (int) this.zzedv.zzyt();
        int zzl = (int) this.zzedw.zzl(this.zzakm);
        int position = this.zzakm.position();
        int round = Math.round(((float) zzl) * (((float) position) / ((float) zzyt)));
        boolean z = round > 0;
        int zzyp = zzbag.zzyp();
        int zzyq = zzbag.zzyq();
        String str = this.url;
        zza(str, zzfe(str), position, zzyt, (long) round, (long) zzl, z, zzyp, zzyq);
    }

    /* JADX WARNING: type inference failed for: r1v30, types: [com.google.android.gms.internal.ads.zzbab] */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r9.zzedz = true;
        zzb(r10, r11, (long) ((int) r9.zzedw.zzl(r9.zzakm)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c2, code lost:
        if (r9.zzakm.remaining() > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c4, code lost:
        zzxd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cb, code lost:
        if (r9.zzedu != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cd, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d5, code lost:
        if ((r12 - r16) < r4) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d7, code lost:
        zzxd();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e3, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00eb, code lost:
        r12 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010a, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010b, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r1 = r9.zzakm.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0130, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0136, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0137, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfd(java.lang.String r22) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            r9.url = r10
            java.lang.String r11 = r21.zzfe(r22)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zznh r0 = new com.google.android.gms.internal.ads.zznh     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = r9.zzdvd     // Catch:{ Exception -> 0x013c }
            r3 = 0
            com.google.android.gms.internal.ads.zzazk r1 = r9.zzebk     // Catch:{ Exception -> 0x013c }
            int r5 = r1.zzeal     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzazk r1 = r9.zzebk     // Catch:{ Exception -> 0x013c }
            int r6 = r1.zzean     // Catch:{ Exception -> 0x013c }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzazk r1 = r9.zzebk     // Catch:{ Exception -> 0x013c }
            boolean r1 = r1.zzear     // Catch:{ Exception -> 0x013c }
            if (r1 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzbab r1 = new com.google.android.gms.internal.ads.zzbab     // Catch:{ Exception -> 0x0032 }
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0032 }
            r3 = 0
            r1.<init>(r2, r0, r3, r3)     // Catch:{ Exception -> 0x0032 }
            r0 = r1
            goto L_0x0035
        L_0x0032:
            r0 = move-exception
            goto L_0x013f
        L_0x0035:
            android.net.Uri r1 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zznf r2 = new com.google.android.gms.internal.ads.zznf     // Catch:{ Exception -> 0x013c }
            r2.<init>(r1)     // Catch:{ Exception -> 0x013c }
            r0.zza(r2)     // Catch:{ Exception -> 0x013c }
            java.lang.ref.WeakReference r1 = r9.zzedf     // Catch:{ Exception -> 0x013c }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzazj r1 = (com.google.android.gms.internal.ads.zzazj) r1     // Catch:{ Exception -> 0x013c }
            if (r1 == 0) goto L_0x004e
            r1.zza(r11, r9)     // Catch:{ Exception -> 0x0032 }
        L_0x004e:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzkq()     // Catch:{ Exception -> 0x013c }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzyp<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzza.zzchk     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzyw r5 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ Exception -> 0x013c }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ Exception -> 0x013c }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x013c }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzyp<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzza.zzchj     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzyw r7 = com.google.android.gms.internal.ads.zzuv.zzon()     // Catch:{ Exception -> 0x013c }
            java.lang.Object r6 = r7.zzd(r6)     // Catch:{ Exception -> 0x013c }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x013c }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzazk r8 = r9.zzebk     // Catch:{ Exception -> 0x013c }
            int r8 = r8.zzeak     // Catch:{ Exception -> 0x013c }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x013c }
            r9.zzakm = r8     // Catch:{ Exception -> 0x013c }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x013c }
            r16 = r2
        L_0x0086:
            java.nio.ByteBuffer r14 = r9.zzakm     // Catch:{ Exception -> 0x013c }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x013c }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x013c }
            int r14 = r0.read(r15, r13, r14)     // Catch:{ Exception -> 0x013c }
            r8 = -1
            if (r14 != r8) goto L_0x00a9
            r8 = 1
            r9.zzedz = r8     // Catch:{ Exception -> 0x0032 }
            com.google.android.gms.internal.ads.zzbap r0 = r9.zzedw     // Catch:{ Exception -> 0x0032 }
            java.nio.ByteBuffer r1 = r9.zzakm     // Catch:{ Exception -> 0x0032 }
            long r0 = r0.zzl(r1)     // Catch:{ Exception -> 0x0032 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0032 }
            long r0 = (long) r1     // Catch:{ Exception -> 0x0032 }
            r9.zzb(r10, r11, r0)     // Catch:{ Exception -> 0x0032 }
        L_0x00a7:
            r1 = 1
            goto L_0x00c8
        L_0x00a9:
            java.lang.Object r8 = r9.zzedy     // Catch:{ Exception -> 0x013c }
            monitor-enter(r8)     // Catch:{ Exception -> 0x013c }
            boolean r13 = r9.zzedu     // Catch:{ all -> 0x0131 }
            if (r13 != 0) goto L_0x00b9
            java.nio.ByteBuffer r13 = r9.zzakm     // Catch:{ all -> 0x0131 }
            r18 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x013a }
            goto L_0x00bb
        L_0x00b9:
            r18 = r12
        L_0x00bb:
            monitor-exit(r8)     // Catch:{ all -> 0x013a }
            java.nio.ByteBuffer r8 = r9.zzakm     // Catch:{ Exception -> 0x0136 }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x0136 }
            if (r8 > 0) goto L_0x00c9
            r21.zzxd()     // Catch:{ Exception -> 0x0136 }
            goto L_0x00a7
        L_0x00c8:
            return r1
        L_0x00c9:
            boolean r8 = r9.zzedu     // Catch:{ Exception -> 0x0136 }
            if (r8 != 0) goto L_0x010b
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0136 }
            long r19 = r12 - r16
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00dc
            r21.zzxd()     // Catch:{ Exception -> 0x0136 }
            r16 = r12
        L_0x00dc:
            long r12 = r12 - r2
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r6
            int r8 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r8 > 0) goto L_0x00eb
            r12 = r18
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x0086
        L_0x00eb:
            java.lang.String r12 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0032 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r1.append(r0)     // Catch:{ Exception -> 0x0032 }
            r1.append(r6)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0032 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0032 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0032 }
            throw r1     // Catch:{ Exception -> 0x0032 }
        L_0x010b:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0032 }
            java.nio.ByteBuffer r1 = r9.zzakm     // Catch:{ Exception -> 0x0032 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0032 }
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0032 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = "Precache abort at "
            r3.append(r2)     // Catch:{ Exception -> 0x0032 }
            r3.append(r1)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = " bytes"
            r3.append(r1)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0032 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0032 }
            throw r0     // Catch:{ Exception -> 0x0032 }
        L_0x0131:
            r0 = move-exception
            r18 = r12
        L_0x0134:
            monitor-exit(r8)     // Catch:{ all -> 0x013a }
            throw r0     // Catch:{ Exception -> 0x0136 }
        L_0x0136:
            r0 = move-exception
            r12 = r18
            goto L_0x013f
        L_0x013a:
            r0 = move-exception
            goto L_0x0134
        L_0x013c:
            r0 = move-exception
            r18 = r12
        L_0x013f:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = java.lang.String.valueOf(r22)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzaug.zzeu(r1)
            r9.zza(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbj.zzfd(java.lang.String):boolean");
    }

    public final void abort() {
        this.zzedu = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzedy) {
            if (this.zzakm != null && !this.zzedx) {
                this.zzakm.flip();
                this.zzedx = true;
            }
            this.zzedu = true;
        }
        return this.zzakm;
    }

    public final /* synthetic */ void zza(Object obj, zznf zznf) {
        zzne zzne = (zzne) obj;
        if (zzne instanceof zznh) {
            this.zzedv.zza((zznh) zzne);
        }
    }
}
