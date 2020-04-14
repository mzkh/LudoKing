package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzkd implements zziw, zzjb {
    private static final zzix zzank = new zzkg();
    private static final int zzavl = zzof.zzbi("qt  ");
    private long zzagh;
    private final zzoc zzanr = new zzoc(zznx.zzbfz);
    private final zzoc zzans = new zzoc(4);
    private int zzapg;
    private int zzaph;
    private zziy zzapk;
    private final zzoc zzavm = new zzoc(16);
    private final Stack<zzjr> zzavn = new Stack<>();
    private int zzavo;
    private int zzavp;
    private long zzavq;
    private int zzavr;
    private zzoc zzavs;
    private zzkf[] zzavt;
    private boolean zzavu;

    public final void release() {
    }

    public final boolean zzgc() {
        return true;
    }

    public final boolean zza(zziv zziv) throws IOException, InterruptedException {
        return zzki.zzd(zziv);
    }

    public final void zza(zziy zziy) {
        this.zzapk = zziy;
    }

    public final void zzc(long j, long j2) {
        this.zzavn.clear();
        this.zzavr = 0;
        this.zzaph = 0;
        this.zzapg = 0;
        if (j == 0) {
            zzgn();
            return;
        }
        zzkf[] zzkfArr = this.zzavt;
        if (zzkfArr != null) {
            for (zzkf zzkf : zzkfArr) {
                zzkj zzkj = zzkf.zzaxa;
                int zzdw = zzkj.zzdw(j2);
                if (zzdw == -1) {
                    zzdw = zzkj.zzdx(j2);
                }
                zzkf.zzavg = zzdw;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x019a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02af A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0006 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zziv r25, com.google.android.gms.internal.ads.zzjc r26) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
        L_0x0006:
            int r3 = r0.zzavo
            r4 = -1
            r5 = 8
            r6 = 1
            if (r3 == 0) goto L_0x019c
            r8 = 262144(0x40000, double:1.295163E-318)
            r10 = 2
            if (r3 == r6) goto L_0x0115
            if (r3 != r10) goto L_0x010f
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r5 = -1
        L_0x001d:
            com.google.android.gms.internal.ads.zzkf[] r14 = r0.zzavt
            int r15 = r14.length
            if (r3 >= r15) goto L_0x003b
            r14 = r14[r3]
            int r15 = r14.zzavg
            com.google.android.gms.internal.ads.zzkj r11 = r14.zzaxa
            int r11 = r11.zzavc
            if (r15 == r11) goto L_0x0038
            com.google.android.gms.internal.ads.zzkj r11 = r14.zzaxa
            long[] r11 = r11.zzamv
            r14 = r11[r15]
            int r11 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0038
            r5 = r3
            r12 = r14
        L_0x0038:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x003b:
            if (r5 != r4) goto L_0x003e
            return r4
        L_0x003e:
            r3 = r14[r5]
            com.google.android.gms.internal.ads.zzjd r4 = r3.zzaxb
            int r5 = r3.zzavg
            com.google.android.gms.internal.ads.zzkj r11 = r3.zzaxa
            long[] r11 = r11.zzamv
            r12 = r11[r5]
            com.google.android.gms.internal.ads.zzkj r11 = r3.zzaxa
            int[] r11 = r11.zzamu
            r11 = r11[r5]
            com.google.android.gms.internal.ads.zzkh r14 = r3.zzawz
            int r14 = r14.zzaxd
            if (r14 != r6) goto L_0x005b
            r14 = 8
            long r12 = r12 + r14
            int r11 = r11 + -8
        L_0x005b:
            long r14 = r25.getPosition()
            long r14 = r12 - r14
            int r10 = r0.zzaph
            long r6 = (long) r10
            long r14 = r14 + r6
            r6 = 0
            int r10 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r10 < 0) goto L_0x010b
            int r6 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0071
            goto L_0x010b
        L_0x0071:
            int r2 = (int) r14
            r1.zzab(r2)
            com.google.android.gms.internal.ads.zzkh r2 = r3.zzawz
            int r2 = r2.zzaqq
            if (r2 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzoc r2 = r0.zzans
            byte[] r2 = r2.data
            r6 = 0
            r2[r6] = r6
            r7 = 1
            r2[r7] = r6
            r7 = 2
            r2[r7] = r6
            com.google.android.gms.internal.ads.zzkh r2 = r3.zzawz
            int r2 = r2.zzaqq
            com.google.android.gms.internal.ads.zzkh r6 = r3.zzawz
            int r6 = r6.zzaqq
            r7 = 4
            int r6 = 4 - r6
        L_0x0093:
            int r7 = r0.zzaph
            if (r7 >= r11) goto L_0x00e8
            int r7 = r0.zzapg
            if (r7 != 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzoc r7 = r0.zzans
            byte[] r7 = r7.data
            r1.readFully(r7, r6, r2)
            com.google.android.gms.internal.ads.zzoc r7 = r0.zzans
            r8 = 0
            r7.zzbg(r8)
            com.google.android.gms.internal.ads.zzoc r7 = r0.zzans
            int r7 = r7.zzir()
            r0.zzapg = r7
            com.google.android.gms.internal.ads.zzoc r7 = r0.zzanr
            r7.zzbg(r8)
            com.google.android.gms.internal.ads.zzoc r7 = r0.zzanr
            r9 = 4
            r4.zza(r7, r9)
            int r7 = r0.zzaph
            int r7 = r7 + r9
            r0.zzaph = r7
            int r11 = r11 + r6
            goto L_0x0093
        L_0x00c2:
            r8 = 0
            int r7 = r4.zza(r1, r7, r8)
            int r8 = r0.zzaph
            int r8 = r8 + r7
            r0.zzaph = r8
            int r8 = r0.zzapg
            int r8 = r8 - r7
            r0.zzapg = r8
            goto L_0x0093
        L_0x00d2:
            int r2 = r0.zzaph
            if (r2 >= r11) goto L_0x00e8
            int r2 = r11 - r2
            r6 = 0
            int r2 = r4.zza(r1, r2, r6)
            int r6 = r0.zzaph
            int r6 = r6 + r2
            r0.zzaph = r6
            int r6 = r0.zzapg
            int r6 = r6 - r2
            r0.zzapg = r6
            goto L_0x00d2
        L_0x00e8:
            r20 = r11
            com.google.android.gms.internal.ads.zzkj r1 = r3.zzaxa
            long[] r1 = r1.zzaxi
            r17 = r1[r5]
            com.google.android.gms.internal.ads.zzkj r1 = r3.zzaxa
            int[] r1 = r1.zzavk
            r19 = r1[r5]
            r21 = 0
            r22 = 0
            r16 = r4
            r16.zza(r17, r19, r20, r21, r22)
            int r1 = r3.zzavg
            r4 = 1
            int r1 = r1 + r4
            r3.zzavg = r1
            r1 = 0
            r0.zzaph = r1
            r0.zzapg = r1
            return r1
        L_0x010b:
            r4 = 1
            r2.zzamq = r12
            return r4
        L_0x010f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0115:
            long r3 = r0.zzavq
            int r6 = r0.zzavr
            long r6 = (long) r6
            long r3 = r3 - r6
            long r6 = r25.getPosition()
            long r6 = r6 + r3
            com.google.android.gms.internal.ads.zzoc r10 = r0.zzavs
            if (r10 == 0) goto L_0x0177
            byte[] r8 = r10.data
            int r9 = r0.zzavr
            int r4 = (int) r3
            r1.readFully(r8, r9, r4)
            int r3 = r0.zzavp
            int r4 = com.google.android.gms.internal.ads.zzjs.zzaqx
            if (r3 != r4) goto L_0x0158
            com.google.android.gms.internal.ads.zzoc r3 = r0.zzavs
            r3.zzbg(r5)
            int r4 = r3.readInt()
            int r5 = zzavl
            if (r4 != r5) goto L_0x0141
        L_0x013f:
            r3 = 1
            goto L_0x0155
        L_0x0141:
            r4 = 4
            r3.zzbh(r4)
        L_0x0145:
            int r4 = r3.zzim()
            if (r4 <= 0) goto L_0x0154
            int r4 = r3.readInt()
            int r5 = zzavl
            if (r4 != r5) goto L_0x0145
            goto L_0x013f
        L_0x0154:
            r3 = 0
        L_0x0155:
            r0.zzavu = r3
            goto L_0x017f
        L_0x0158:
            java.util.Stack<com.google.android.gms.internal.ads.zzjr> r3 = r0.zzavn
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x017f
            java.util.Stack<com.google.android.gms.internal.ads.zzjr> r3 = r0.zzavn
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzjr r3 = (com.google.android.gms.internal.ads.zzjr) r3
            com.google.android.gms.internal.ads.zzju r4 = new com.google.android.gms.internal.ads.zzju
            int r5 = r0.zzavp
            com.google.android.gms.internal.ads.zzoc r8 = r0.zzavs
            r4.<init>(r5, r8)
            java.util.List<com.google.android.gms.internal.ads.zzju> r3 = r3.zzaqv
            r3.add(r4)
            goto L_0x017f
        L_0x0177:
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x0181
            int r4 = (int) r3
            r1.zzab(r4)
        L_0x017f:
            r3 = 0
            goto L_0x0189
        L_0x0181:
            long r8 = r25.getPosition()
            long r8 = r8 + r3
            r2.zzamq = r8
            r3 = 1
        L_0x0189:
            r0.zzdv(r6)
            if (r3 == 0) goto L_0x0196
            int r3 = r0.zzavo
            r4 = 2
            if (r3 == r4) goto L_0x0196
            r23 = 1
            goto L_0x0198
        L_0x0196:
            r23 = 0
        L_0x0198:
            if (r23 == 0) goto L_0x0006
            r3 = 1
            return r3
        L_0x019c:
            r3 = 1
            int r6 = r0.zzavr
            if (r6 != 0) goto L_0x01c6
            com.google.android.gms.internal.ads.zzoc r6 = r0.zzavm
            byte[] r6 = r6.data
            r7 = 0
            boolean r6 = r1.zza(r6, r7, r5, r3)
            if (r6 != 0) goto L_0x01af
            r3 = 0
            goto L_0x02ad
        L_0x01af:
            r0.zzavr = r5
            com.google.android.gms.internal.ads.zzoc r3 = r0.zzavm
            r3.zzbg(r7)
            com.google.android.gms.internal.ads.zzoc r3 = r0.zzavm
            long r6 = r3.zzio()
            r0.zzavq = r6
            com.google.android.gms.internal.ads.zzoc r3 = r0.zzavm
            int r3 = r3.readInt()
            r0.zzavp = r3
        L_0x01c6:
            long r6 = r0.zzavq
            r8 = 1
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzoc r3 = r0.zzavm
            byte[] r3 = r3.data
            r1.readFully(r3, r5, r5)
            int r3 = r0.zzavr
            int r3 = r3 + r5
            r0.zzavr = r3
            com.google.android.gms.internal.ads.zzoc r3 = r0.zzavm
            long r6 = r3.zzis()
            r0.zzavq = r6
        L_0x01e2:
            int r3 = r0.zzavp
            int r6 = com.google.android.gms.internal.ads.zzjs.zzary
            if (r3 == r6) goto L_0x01ff
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasa
            if (r3 == r6) goto L_0x01ff
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasb
            if (r3 == r6) goto L_0x01ff
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasc
            if (r3 == r6) goto L_0x01ff
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasd
            if (r3 == r6) goto L_0x01ff
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasm
            if (r3 != r6) goto L_0x01fd
            goto L_0x01ff
        L_0x01fd:
            r3 = 0
            goto L_0x0200
        L_0x01ff:
            r3 = 1
        L_0x0200:
            if (r3 == 0) goto L_0x022c
            long r5 = r25.getPosition()
            long r7 = r0.zzavq
            long r5 = r5 + r7
            int r3 = r0.zzavr
            long r7 = (long) r3
            long r5 = r5 - r7
            java.util.Stack<com.google.android.gms.internal.ads.zzjr> r3 = r0.zzavn
            com.google.android.gms.internal.ads.zzjr r7 = new com.google.android.gms.internal.ads.zzjr
            int r8 = r0.zzavp
            r7.<init>(r8, r5)
            r3.add(r7)
            long r7 = r0.zzavq
            int r3 = r0.zzavr
            long r9 = (long) r3
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0226
            r0.zzdv(r5)
            goto L_0x0229
        L_0x0226:
            r24.zzgn()
        L_0x0229:
            r3 = 1
            goto L_0x02ad
        L_0x022c:
            int r3 = r0.zzavp
            int r6 = com.google.android.gms.internal.ads.zzjs.zzaso
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzarz
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasp
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasq
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatj
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatk
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatl
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasn
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatm
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatn
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzato
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatp
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatq
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzasl
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzaqx
            if (r3 == r6) goto L_0x0271
            int r6 = com.google.android.gms.internal.ads.zzjs.zzatx
            if (r3 != r6) goto L_0x026f
            goto L_0x0271
        L_0x026f:
            r3 = 0
            goto L_0x0272
        L_0x0271:
            r3 = 1
        L_0x0272:
            if (r3 == 0) goto L_0x02a7
            int r3 = r0.zzavr
            if (r3 != r5) goto L_0x027a
            r3 = 1
            goto L_0x027b
        L_0x027a:
            r3 = 0
        L_0x027b:
            com.google.android.gms.internal.ads.zznr.checkState(r3)
            long r6 = r0.zzavq
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x0289
            r3 = 1
            goto L_0x028a
        L_0x0289:
            r3 = 0
        L_0x028a:
            com.google.android.gms.internal.ads.zznr.checkState(r3)
            com.google.android.gms.internal.ads.zzoc r3 = new com.google.android.gms.internal.ads.zzoc
            long r6 = r0.zzavq
            int r7 = (int) r6
            r3.<init>(r7)
            r0.zzavs = r3
            com.google.android.gms.internal.ads.zzoc r3 = r0.zzavm
            byte[] r3 = r3.data
            com.google.android.gms.internal.ads.zzoc r6 = r0.zzavs
            byte[] r6 = r6.data
            r7 = 0
            java.lang.System.arraycopy(r3, r7, r6, r7, r5)
            r3 = 1
            r0.zzavo = r3
            goto L_0x02ad
        L_0x02a7:
            r3 = 1
            r5 = 0
            r0.zzavs = r5
            r0.zzavo = r3
        L_0x02ad:
            if (r3 != 0) goto L_0x0006
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkd.zza(com.google.android.gms.internal.ads.zziv, com.google.android.gms.internal.ads.zzjc):int");
    }

    public final long getDurationUs() {
        return this.zzagh;
    }

    public final long zzdt(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzkf zzkf : this.zzavt) {
            zzkj zzkj = zzkf.zzaxa;
            int zzdw = zzkj.zzdw(j);
            if (zzdw == -1) {
                zzdw = zzkj.zzdx(j);
            }
            long j3 = zzkj.zzamv[zzdw];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void zzgn() {
        this.zzavo = 0;
        this.zzavr = 0;
    }

    private final void zzdv(long j) throws zzgv {
        zzkx zzkx;
        zzja zzja;
        while (!this.zzavn.isEmpty() && ((zzjr) this.zzavn.peek()).zzaqu == j) {
            zzjr zzjr = (zzjr) this.zzavn.pop();
            if (zzjr.type == zzjs.zzary) {
                ArrayList arrayList = new ArrayList();
                zzkx zzkx2 = null;
                zzja zzja2 = new zzja();
                zzju zzak = zzjr.zzak(zzjs.zzatx);
                if (zzak != null) {
                    zzkx2 = zzjt.zza(zzak, this.zzavu);
                    if (zzkx2 != null) {
                        zzja2.zzb(zzkx2);
                    }
                }
                long j2 = Long.MAX_VALUE;
                long j3 = -9223372036854775807L;
                int i = 0;
                while (i < zzjr.zzaqw.size()) {
                    zzjr zzjr2 = (zzjr) zzjr.zzaqw.get(i);
                    if (zzjr2.type == zzjs.zzasa) {
                        zzkh zza = zzjt.zza(zzjr2, zzjr.zzak(zzjs.zzarz), -9223372036854775807L, (zzin) null, this.zzavu);
                        if (zza != null) {
                            zzkj zza2 = zzjt.zza(zza, zzjr2.zzal(zzjs.zzasb).zzal(zzjs.zzasc).zzal(zzjs.zzasd), zzja2);
                            if (zza2.zzavc != 0) {
                                zzkf zzkf = new zzkf(zza, zza2, this.zzapk.zzb(i, zza.type));
                                zzgo zzo = zza.zzafx.zzo(zza2.zzavi + 30);
                                if (zza.type == 1) {
                                    if (zzja2.zzgf()) {
                                        zzo = zzo.zza(zzja2.zzafp, zzja2.zzafq);
                                    }
                                    if (zzkx2 != null) {
                                        zzo = zzo.zza(zzkx2);
                                    }
                                }
                                zzkf.zzaxb.zze(zzo);
                                zzkx = zzkx2;
                                zzja = zzja2;
                                j3 = Math.max(j3, zza.zzagh);
                                arrayList.add(zzkf);
                                long j4 = zza2.zzamv[0];
                                if (j4 < j2) {
                                    j2 = j4;
                                }
                                i++;
                                zzja2 = zzja;
                                zzkx2 = zzkx;
                            }
                        }
                    }
                    zzkx = zzkx2;
                    zzja = zzja2;
                    i++;
                    zzja2 = zzja;
                    zzkx2 = zzkx;
                }
                this.zzagh = j3;
                this.zzavt = (zzkf[]) arrayList.toArray(new zzkf[arrayList.size()]);
                this.zzapk.zzge();
                this.zzapk.zza(this);
                this.zzavn.clear();
                this.zzavo = 2;
            } else if (!this.zzavn.isEmpty()) {
                ((zzjr) this.zzavn.peek()).zzaqw.add(zzjr);
            }
        }
        if (this.zzavo != 2) {
            zzgn();
        }
    }
}
