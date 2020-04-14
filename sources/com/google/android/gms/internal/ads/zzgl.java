package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzgl implements Callback, zzlr, zzlt, zzmx {
    private final Handler handler;
    private int repeatMode = 0;
    private int state;
    private final zzgx[] zzacp;
    private final zzmy zzacq;
    private final Handler zzacs;
    private final zzhd zzacv;
    private final zzha zzacw;
    private boolean zzacy;
    private boolean zzadc;
    private zzgy zzadd;
    private zzgu zzadh;
    private zzgn zzadi;
    private final zzgw[] zzady;
    private final zzgs zzadz;
    private zzlu zzaea;
    private final zzod zzaec;
    private final HandlerThread zzaed;
    private final zzgc zzaee;
    private zzgx zzaef;
    private zznv zzaeg;
    private zzgx[] zzaeh;
    private boolean zzaei;
    private boolean zzaej;
    private int zzaek;
    private int zzael;
    private long zzaem;
    private int zzaen;
    private zzgm zzaeo;
    private long zzaep;
    private zzgk zzaeq;
    private zzgk zzaer;
    private zzgk zzaes;

    public zzgl(zzgx[] zzgxArr, zzmy zzmy, zzgs zzgs, boolean z, int i, Handler handler2, zzgn zzgn, zzgc zzgc) {
        this.zzacp = zzgxArr;
        this.zzacq = zzmy;
        this.zzadz = zzgs;
        this.zzacy = z;
        this.zzacs = handler2;
        this.state = 1;
        this.zzadi = zzgn;
        this.zzaee = zzgc;
        this.zzady = new zzgw[zzgxArr.length];
        for (int i2 = 0; i2 < zzgxArr.length; i2++) {
            zzgxArr[i2].setIndex(i2);
            this.zzady[i2] = zzgxArr[i2].zzdj();
        }
        this.zzaec = new zzod();
        this.zzaeh = new zzgx[0];
        this.zzacv = new zzhd();
        this.zzacw = new zzha();
        zzmy.zza(this);
        this.zzadh = zzgu.zzafz;
        this.zzaed = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzaed.start();
        this.handler = new Handler(this.zzaed.getLooper(), this);
    }

    public final void zza(zzlu zzlu, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzlu).sendToTarget();
    }

    public final void zze(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzgy zzgy, int i, long j) {
        this.handler.obtainMessage(3, new zzgm(zzgy, i, j)).sendToTarget();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzgh... zzghArr) {
        if (this.zzaei) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzaek++;
        this.handler.obtainMessage(11, zzghArr).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(com.google.android.gms.internal.ads.zzgh... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzaei     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.zzaek     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.zzaek = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.handler     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.zzael     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgl.zzb(com.google.android.gms.internal.ads.zzgh[]):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void release() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzaei     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.handler     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzaei     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzaed     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgl.release():void");
    }

    public final void zzb(zzgy zzgy, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzgy, obj)).sendToTarget();
    }

    public final void zza(zzls zzls) {
        this.handler.obtainMessage(8, zzls).sendToTarget();
    }

    public final void zzec() {
        this.handler.sendEmptyMessage(10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:504:0x08b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x08ba, code lost:
        r1 = r0;
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r1);
        r8.zzacs.obtainMessage(8, com.google.android.gms.internal.ads.zzgd.zza(r1)).sendToTarget();
        zzeg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:506:0x08d4, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x08d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x08d6, code lost:
        r3 = 8;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x08f1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:512:0x08f2, code lost:
        r3 = 8;
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x028f A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0292 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0296 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0358 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x036c A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0538 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x053f A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0559 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x055c A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x0597 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x05ab A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x05c7 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }, LOOP:8: B:331:0x05c7->B:335:0x05d9, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x0729 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x07e2 A[Catch:{ all -> 0x0454, all -> 0x038c, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x08b9 A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            r34 = this;
            r8 = r34
            r1 = r35
            r10 = 1
            int r2 = r1.what     // Catch:{ zzgd -> 0x08f1, IOException -> 0x08d5, RuntimeException -> 0x08b9 }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x0878;
                case 1: goto L_0x084b;
                case 2: goto L_0x046e;
                case 3: goto L_0x03b5;
                case 4: goto L_0x0394;
                case 5: goto L_0x0390;
                case 6: goto L_0x0379;
                case 7: goto L_0x021b;
                case 8: goto L_0x01e5;
                case 9: goto L_0x01d2;
                case 10: goto L_0x00dd;
                case 11: goto L_0x009f;
                case 12: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            return r9
        L_0x0019:
            int r1 = r1.arg1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.repeatMode = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0026:
            if (r2 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.zzgk r4 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != r4) goto L_0x0037
            r4 = r3
            r3 = r2
            r2 = 1
            goto L_0x003a
        L_0x0037:
            r4 = r3
            r3 = r2
            r2 = 0
        L_0x003a:
            com.google.android.gms.internal.ads.zzgy r11 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r12 = r3.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r13 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzhd r14 = r8.zzacv     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r11 = r11.zza(r12, r13, r14, r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r12 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r12 == 0) goto L_0x0065
            if (r11 == r5) goto L_0x0065
            com.google.android.gms.internal.ads.zzgk r12 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r12 = r12.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r12 != r11) goto L_0x0065
            com.google.android.gms.internal.ads.zzgk r3 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r11 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 != r11) goto L_0x005a
            r11 = 1
            goto L_0x005b
        L_0x005a:
            r11 = 0
        L_0x005b:
            r4 = r4 | r11
            com.google.android.gms.internal.ads.zzgk r11 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 != r11) goto L_0x0062
            r11 = 1
            goto L_0x0063
        L_0x0062:
            r11 = 0
        L_0x0063:
            r2 = r2 | r11
            goto L_0x003a
        L_0x0065:
            com.google.android.gms.internal.ads.zzgk r5 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r5 == 0) goto L_0x0070
            com.google.android.gms.internal.ads.zzgk r5 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            zza(r5)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.zzadw = r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0070:
            int r5 = r3.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r5 = r8.zzn(r5)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.zzadt = r5     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x007c
            r8.zzaeq = r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x007c:
            if (r4 != 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r3 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r3.zzaev     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r8.zza(r2, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r5 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r5.<init>(r2, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r5     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0095:
            int r2 = r8.state     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != r15) goto L_0x009e
            if (r1 == 0) goto L_0x009e
            r8.setState(r7)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x009e:
            return r10
        L_0x009f:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgh[] r1 = (com.google.android.gms.internal.ads.zzgh[]) r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r1.length     // Catch:{ all -> 0x00cc }
        L_0x00a4:
            if (r9 >= r2) goto L_0x00b4
            r3 = r1[r9]     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzge r4 = r3.zzacl     // Catch:{ all -> 0x00cc }
            int r5 = r3.zzacm     // Catch:{ all -> 0x00cc }
            java.lang.Object r3 = r3.zzacn     // Catch:{ all -> 0x00cc }
            r4.zza(r5, r3)     // Catch:{ all -> 0x00cc }
            int r9 = r9 + 1
            goto L_0x00a4
        L_0x00b4:
            com.google.android.gms.internal.ads.zzlu r1 = r8.zzaea     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00bd
            android.os.Handler r1 = r8.handler     // Catch:{ all -> 0x00cc }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00cc }
        L_0x00bd:
            monitor-enter(r34)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r1 = r8.zzael     // Catch:{ all -> 0x00c8 }
            int r1 = r1 + r10
            r8.zzael = r1     // Catch:{ all -> 0x00c8 }
            r34.notifyAll()     // Catch:{ all -> 0x00c8 }
            monitor-exit(r34)     // Catch:{ all -> 0x00c8 }
            return r10
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00c8 }
            throw r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x00cc:
            r0 = move-exception
            r1 = r0
            monitor-enter(r34)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r8.zzael     // Catch:{ all -> 0x00d9 }
            int r2 = r2 + r10
            r8.zzael = r2     // Catch:{ all -> 0x00d9 }
            r34.notifyAll()     // Catch:{ all -> 0x00d9 }
            monitor-exit(r34)     // Catch:{ all -> 0x00d9 }
            throw r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x00d9:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00d9 }
            throw r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x00dd:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x01d1
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2 = 1
        L_0x00e4:
            if (r1 == 0) goto L_0x01d1
            boolean r3 = r1.zzadu     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 != 0) goto L_0x00ec
            goto L_0x01d1
        L_0x00ec:
            boolean r3 = r1.zzeb()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 != 0) goto L_0x00fa
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != r3) goto L_0x00f7
            r2 = 0
        L_0x00f7:
            com.google.android.gms.internal.ads.zzgk r1 = r1.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x00e4
        L_0x00fa:
            if (r2 == 0) goto L_0x0198
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == r3) goto L_0x0104
            r2 = 1
            goto L_0x0105
        L_0x0104:
            r2 = 0
        L_0x0105:
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            zza(r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.zzadw = r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaeq = r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaer = r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgx[] r3 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r3 = r3.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean[] r3 = new boolean[r3]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r4 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r5 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r11 = r5.zzaev     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r4 = r4.zza(r11, r2, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r2 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r11 = r2.zzaev     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0136
            com.google.android.gms.internal.ads.zzgn r2 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.zzaev = r4     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzdk(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0136:
            com.google.android.gms.internal.ads.zzgx[] r2 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean[] r2 = new boolean[r2]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r4 = 0
            r5 = 0
        L_0x013d:
            com.google.android.gms.internal.ads.zzgx[] r11 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r11 = r11.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r4 >= r11) goto L_0x0189
            com.google.android.gms.internal.ads.zzgx[] r11 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r11 = r11[r4]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r12 = r11.getState()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r12 == 0) goto L_0x014e
            r12 = 1
            goto L_0x014f
        L_0x014e:
            r12 = 0
        L_0x014f:
            r2[r4] = r12     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r12 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmd[] r12 = r12.zzado     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r12 = r12[r4]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r12 == 0) goto L_0x015b
            int r5 = r5 + 1
        L_0x015b:
            boolean r13 = r2[r4]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r13 == 0) goto L_0x0186
            com.google.android.gms.internal.ads.zzmd r13 = r11.zzdl()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r12 == r13) goto L_0x017d
            com.google.android.gms.internal.ads.zzgx r13 = r8.zzaef     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r11 != r13) goto L_0x0176
            if (r12 != 0) goto L_0x0172
            com.google.android.gms.internal.ads.zzod r12 = r8.zzaec     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zznv r13 = r8.zzaeg     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r12.zza(r13)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0172:
            r8.zzaeg = r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaef = r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0176:
            zza(r11)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r11.disable()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0186
        L_0x017d:
            boolean r12 = r3[r4]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r12 == 0) goto L_0x0186
            long r12 = r8.zzaep     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r11.zzdi(r12)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0186:
            int r4 = r4 + 1
            goto L_0x013d
        L_0x0189:
            android.os.Handler r3 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzna r1 = r1.zzadx     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zza(r2, r5)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x01c6
        L_0x0198:
            r8.zzaeq = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r1.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x019e:
            if (r1 == 0) goto L_0x01a6
            r1.release()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r1.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x019e
        L_0x01a6:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzadw = r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r1 = r1.zzadu     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x01c6
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r1 = r1.zzads     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r4 = r8.zzaep     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r11 = r3.zzdz()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r1, r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.zzb(r1, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x01c6:
            r34.zzei()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r34.zzef()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r1 = r8.handler     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendEmptyMessage(r7)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x01d1:
            return r10
        L_0x01d2:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzls r1 = (com.google.android.gms.internal.ads.zzls) r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x01e4
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzls r2 = r2.zzadm     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == r1) goto L_0x01e1
            goto L_0x01e4
        L_0x01e1:
            r34.zzei()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x01e4:
            return r10
        L_0x01e5:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzls r1 = (com.google.android.gms.internal.ads.zzls) r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x021a
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzls r2 = r2.zzadm     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == r1) goto L_0x01f4
            goto L_0x021a
        L_0x01f4:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzadu = r10     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzeb()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r2 = r1.zzads     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r2 = r1.zzb(r2, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzads = r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != 0) goto L_0x0217
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaer = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r1 = r1.zzads     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzdk(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzb(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0217:
            r34.zzei()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x021a:
            return r10
        L_0x021b:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r3 = r1.first     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r3 = (com.google.android.gms.internal.ads.zzgy) r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadd = r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r1 = r1.second     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x028a
            int r3 = r8.zzaen     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 <= 0) goto L_0x025a
            com.google.android.gms.internal.ads.zzgm r3 = r8.zzaeo     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.util.Pair r3 = r8.zza(r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r4 = r8.zzaen     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaen = r9     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaeo = r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 != 0) goto L_0x0242
            r8.zza(r1, r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0378
        L_0x0242:
            com.google.android.gms.internal.ads.zzgn r7 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r11 = r3.first     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r11 = r11.intValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r3 = r3.second     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r14 = r3.longValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r7.<init>(r11, r14)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r7     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x028b
        L_0x025a:
            com.google.android.gms.internal.ads.zzgn r3 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r3.zzads     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x028a
            com.google.android.gms.internal.ads.zzgy r3 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r3 = r3.isEmpty()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 == 0) goto L_0x026f
            r8.zza(r1, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0378
        L_0x026f:
            android.util.Pair r3 = r8.zzb(r9, r12)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r4 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r7 = r3.first     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r7 = r7.intValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r3 = r3.second     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r14 = r3.longValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r4.<init>(r7, r14)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r4     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x028a:
            r4 = 0
        L_0x028b:
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 == 0) goto L_0x0292
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0294
        L_0x0292:
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0294:
            if (r3 == 0) goto L_0x0375
            com.google.android.gms.internal.ads.zzgy r7 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r11 = r3.zzadn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r7 = r7.zzc(r11)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r7 != r5) goto L_0x02f8
            int r6 = r3.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r7 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r8.zza(r6, r2, r7)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != r5) goto L_0x02af
            r8.zza(r1, r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0378
        L_0x02af:
            com.google.android.gms.internal.ads.zzgy r6 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r7 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r6.zza(r2, r7, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.util.Pair r2 = r8.zzb(r9, r12)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r6 = r2.first     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r6 = r6.intValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r2 = r2.second     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r11 = r2.longValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r7 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.zza(r6, r7, r10)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r2 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r2 = r2.zzadn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.zzadr = r5     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x02d7:
            com.google.android.gms.internal.ads.zzgk r7 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r7 == 0) goto L_0x02eb
            com.google.android.gms.internal.ads.zzgk r3 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r7 = r3.zzadn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r7 = r7.equals(r2)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r7 == 0) goto L_0x02e7
            r7 = r6
            goto L_0x02e8
        L_0x02e7:
            r7 = -1
        L_0x02e8:
            r3.zzadr = r7     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x02d7
        L_0x02eb:
            long r2 = r8.zza(r6, r11)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r5 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r5.<init>(r6, r2)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r5     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0375
        L_0x02f8:
            boolean r2 = r8.zzn(r7)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.zzc(r7, r2)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 != r2) goto L_0x0305
            r2 = 1
            goto L_0x0306
        L_0x0305:
            r2 = 0
        L_0x0306:
            com.google.android.gms.internal.ads.zzgn r11 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r11 = r11.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r7 == r11) goto L_0x031f
            com.google.android.gms.internal.ads.zzgn r11 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r12 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r13 = r11.zzads     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r12.<init>(r7, r13)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r13 = r11.zzaev     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r12.zzaev = r13     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r13 = r11.zzaew     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r12.zzaew = r13     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r12     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x031f:
            com.google.android.gms.internal.ads.zzgk r11 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r11 == 0) goto L_0x0375
            com.google.android.gms.internal.ads.zzgk r11 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r12 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r13 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzhd r14 = r8.zzacv     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r15 = r8.repeatMode     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r7 = r12.zza(r7, r13, r14, r15)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r7 == r5) goto L_0x0356
            java.lang.Object r12 = r11.zzadn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r13 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r14 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r13 = r13.zza(r7, r14, r10)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r13 = r13.zzadn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r12 = r12.equals(r13)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r12 == 0) goto L_0x0356
            boolean r3 = r8.zzn(r7)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r11.zzc(r7, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r11 != r3) goto L_0x0352
            r3 = 1
            goto L_0x0353
        L_0x0352:
            r3 = 0
        L_0x0353:
            r2 = r2 | r3
            r3 = r11
            goto L_0x031f
        L_0x0356:
            if (r2 != 0) goto L_0x036c
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r3 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r5 = r3.zzaev     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r5 = r8.zza(r2, r5)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r3 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.<init>(r2, r5)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0375
        L_0x036c:
            r8.zzaeq = r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.zzadw = r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            zza(r11)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0375:
            r8.zzb(r1, r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0378:
            return r10
        L_0x0379:
            r8.zzh(r10)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgs r1 = r8.zzadz     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzem()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.setState(r10)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            monitor-enter(r34)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaei = r10     // Catch:{ all -> 0x038c }
            r34.notifyAll()     // Catch:{ all -> 0x038c }
            monitor-exit(r34)     // Catch:{ all -> 0x038c }
            return r10
        L_0x038c:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x038c }
            throw r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0390:
            r34.zzeg()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            return r10
        L_0x0394:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgu r1 = (com.google.android.gms.internal.ads.zzgu) r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zznv r2 = r8.zzaeg     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x03a3
            com.google.android.gms.internal.ads.zznv r2 = r8.zzaeg     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgu r1 = r2.zzb(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x03a9
        L_0x03a3:
            com.google.android.gms.internal.ads.zzod r2 = r8.zzaec     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgu r1 = r2.zzb(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x03a9:
            r8.zzadh = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r2 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            return r10
        L_0x03b5:
            java.lang.Object r1 = r1.obj     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgm r1 = (com.google.android.gms.internal.ads.zzgm) r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x03c6
            int r2 = r8.zzaen     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2 + r10
            r8.zzaen = r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaeo = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0453
        L_0x03c6:
            android.util.Pair r2 = r8.zza(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x03ec
            com.google.android.gms.internal.ads.zzgn r1 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.<init>(r9, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r1 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r2 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Message r1 = r1.obtainMessage(r15, r10, r9, r2)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r1 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.<init>(r9, r12)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.setState(r15)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzh(r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0453
        L_0x03ec:
            long r3 = r1.zzaeu     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03f4
            r1 = 1
            goto L_0x03f5
        L_0x03f4:
            r1 = 0
        L_0x03f5:
            java.lang.Object r3 = r2.first     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r3 = r3.intValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r2 = r2.second     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r4 = r2.longValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r2 = r8.zzadi     // Catch:{ all -> 0x0454 }
            int r2 = r2.zzadr     // Catch:{ all -> 0x0454 }
            if (r3 != r2) goto L_0x0430
            r6 = 1000(0x3e8, double:4.94E-321)
            long r11 = r4 / r6
            com.google.android.gms.internal.ads.zzgn r2 = r8.zzadi     // Catch:{ all -> 0x0454 }
            long r13 = r2.zzaev     // Catch:{ all -> 0x0454 }
            long r13 = r13 / r6
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x0430
            com.google.android.gms.internal.ads.zzgn r2 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.<init>(r3, r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r2 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x0425
            r1 = 1
            goto L_0x0426
        L_0x0425:
            r1 = 0
        L_0x0426:
            com.google.android.gms.internal.ads.zzgn r3 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0453
        L_0x0430:
            long r6 = r8.zza(r3, r4)     // Catch:{ all -> 0x0454 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x043a
            r2 = 1
            goto L_0x043b
        L_0x043a:
            r2 = 0
        L_0x043b:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzgn r2 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.<init>(r3, r6)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r2 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x0449
            r1 = 1
            goto L_0x044a
        L_0x0449:
            r1 = 0
        L_0x044a:
            com.google.android.gms.internal.ads.zzgn r3 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0453:
            return r10
        L_0x0454:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzgn r6 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r6.<init>(r3, r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r6     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r3 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x0463
            r1 = 1
            goto L_0x0464
        L_0x0463:
            r1 = 0
        L_0x0464:
            com.google.android.gms.internal.ads.zzgn r4 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            throw r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x046e:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r1 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != 0) goto L_0x047e
            com.google.android.gms.internal.ads.zzlu r1 = r8.zzaea     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzhl()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r14 = r5
            goto L_0x06da
        L_0x047e:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != 0) goto L_0x0487
            com.google.android.gms.internal.ads.zzgn r1 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r1 = r1.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x04c5
        L_0x0487:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r1 = r1.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r2 = r2.zzadt     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x04d2
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r2 = r2.zzea()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x04d2
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r7 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r2 = r2.zza(r1, r7, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r14 = r2.zzagh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x04a8
            goto L_0x04d2
        L_0x04a8:
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x04b9
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.index     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r7 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r7 = r7.index     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2 - r7
            r7 = 100
            if (r2 == r7) goto L_0x04d2
        L_0x04b9:
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r7 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzhd r14 = r8.zzacv     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r15 = r8.repeatMode     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r1 = r2.zza(r1, r7, r14, r15)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x04c5:
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.zzeq()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 < r2) goto L_0x04d5
            com.google.android.gms.internal.ads.zzlu r1 = r8.zzaea     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzhl()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x04d2:
            r14 = r5
            goto L_0x05a7
        L_0x04d5:
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x04df
            com.google.android.gms.internal.ads.zzgn r2 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r2.zzaev     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x04dd:
            r14 = r5
            goto L_0x0534
        L_0x04df:
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r7 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.zza(r1, r7, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzhd r7 = r8.zzacv     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.zza(r9, r7, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x04f0
            goto L_0x04dd
        L_0x04f0:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r1 = r1.zzdz()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r7 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r14 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r14 = r14.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r15 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r7 = r7.zza(r14, r15, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r14 = r7.zzagh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r1 = r1 + r14
            long r14 = r8.zzaep     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r1 = r1 - r14
            com.google.android.gms.internal.ads.zzgy r7 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r14 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r18 = java.lang.Math.max(r3, r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1 = r34
            r2 = r7
            r3 = r14
            r14 = r5
            r4 = r16
            r6 = r18
            android.util.Pair r1 = r1.zza(r2, r3, r4, r6)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x05a7
            java.lang.Object r2 = r1.first     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.intValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r1 = r1.second     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r1.longValue()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1 = r2
        L_0x0534:
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x053f
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x053c:
            r23 = r5
            goto L_0x0555
        L_0x053f:
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r5 = r2.zzdz()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r7 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r7 = r7.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r11 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r2 = r2.zza(r7, r11, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r12 = r2.zzagh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r5 = r5 + r12
            goto L_0x053c
        L_0x0555:
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x055c
            r29 = 0
            goto L_0x0563
        L_0x055c:
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.index     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2 + r10
            r29 = r2
        L_0x0563:
            boolean r31 = r8.zzn(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r5 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.zza(r1, r5, r10)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = new com.google.android.gms.internal.ads.zzgk     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgx[] r5 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgw[] r6 = r8.zzady     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmy r7 = r8.zzacq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgs r11 = r8.zzadz     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzlu r12 = r8.zzaea     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r13 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            java.lang.Object r13 = r13.zzadn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r20 = r2
            r21 = r5
            r22 = r6
            r25 = r7
            r26 = r11
            r27 = r12
            r28 = r13
            r30 = r1
            r32 = r3
            r20.<init>(r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x059b
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzadw = r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x059b:
            r8.zzaeq = r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzls r1 = r1.zzadm     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zza(r8, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzg(r10)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x05a7:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x05c0
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r1 = r1.zzea()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x05b4
            goto L_0x05c0
        L_0x05b4:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x05c3
            boolean r1 = r8.zzadc     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != 0) goto L_0x05c3
            r34.zzei()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x05c3
        L_0x05c0:
            r8.zzg(r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x05c3:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x06da
        L_0x05c7:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == r2) goto L_0x0604
            long r1 = r8.zzaep     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r3.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r3.zzadq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0604
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.release()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r1.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzb(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r1 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r3.zzads     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.<init>(r2, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r34.zzef()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r1 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2 = 5
            com.google.android.gms.internal.ads.zzgn r3 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x05c7
        L_0x0604:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r1 = r1.zzadt     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x062e
            r1 = 0
        L_0x060b:
            com.google.android.gms.internal.ads.zzgx[] r2 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 >= r2) goto L_0x06da
            com.google.android.gms.internal.ads.zzgx[] r2 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2 = r2[r1]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmd[] r3 = r3.zzado     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3 = r3[r1]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 == 0) goto L_0x062b
            com.google.android.gms.internal.ads.zzmd r4 = r2.zzdl()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r4 != r3) goto L_0x062b
            boolean r3 = r2.zzdm()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 == 0) goto L_0x062b
            r2.zzdn()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x062b:
            int r1 = r1 + 1
            goto L_0x060b
        L_0x062e:
            r1 = 0
        L_0x062f:
            com.google.android.gms.internal.ads.zzgx[] r2 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 >= r2) goto L_0x0651
            com.google.android.gms.internal.ads.zzgx[] r2 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2 = r2[r1]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmd[] r3 = r3.zzado     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3 = r3[r1]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmd r4 = r2.zzdl()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r4 != r3) goto L_0x06da
            if (r3 == 0) goto L_0x064e
            boolean r2 = r2.zzdm()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x064e
            goto L_0x06da
        L_0x064e:
            int r1 = r1 + 1
            goto L_0x062f
        L_0x0651:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r1.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x06da
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r1.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r1 = r1.zzadu     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x06da
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzna r1 = r1.zzadx     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r2.zzadw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaer = r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzna r2 = r2.zzadx     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzls r3 = r3.zzadm     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r3.zzhc()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0680
            r3 = 1
            goto L_0x0681
        L_0x0680:
            r3 = 0
        L_0x0681:
            r4 = 0
        L_0x0682:
            com.google.android.gms.internal.ads.zzgx[] r5 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r5 = r5.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r4 >= r5) goto L_0x06da
            com.google.android.gms.internal.ads.zzgx[] r5 = r8.zzacp     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r5 = r5[r4]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmv r6 = r1.zzbef     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmt r6 = r6.zzax(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r6 == 0) goto L_0x06d7
            if (r3 != 0) goto L_0x06d4
            boolean r6 = r5.zzdo()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r6 != 0) goto L_0x06d7
            com.google.android.gms.internal.ads.zzmv r6 = r2.zzbef     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmt r6 = r6.zzax(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgz[] r7 = r1.zzbeh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r7 = r7[r4]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgz[] r11 = r2.zzbeh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r11 = r11[r4]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r6 == 0) goto L_0x06d4
            boolean r7 = r11.equals(r7)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r7 == 0) goto L_0x06d4
            int r7 = r6.length()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgo[] r7 = new com.google.android.gms.internal.ads.zzgo[r7]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r11 = 0
        L_0x06b8:
            int r12 = r7.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r11 >= r12) goto L_0x06c4
            com.google.android.gms.internal.ads.zzgo r12 = r6.zzau(r11)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r7[r11] = r12     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r11 = r11 + 1
            goto L_0x06b8
        L_0x06c4:
            com.google.android.gms.internal.ads.zzgk r6 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzmd[] r6 = r6.zzado     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r6 = r6[r4]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r11 = r8.zzaer     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r11 = r11.zzdz()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r5.zza(r7, r6, r11)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x06d7
        L_0x06d4:
            r5.zzdn()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x06d7:
            int r4 = r4 + 1
            goto L_0x0682
        L_0x06da:
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2 = 10
            if (r1 != 0) goto L_0x06e8
            r34.zzeh()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zza(r14, r2)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x084a
        L_0x06e8:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzog.beginSection(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r34.zzef()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r1 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzls r1 = r1.zzadm     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgn r4 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r4 = r4.zzaev     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.zzdz(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgx[] r1 = r8.zzaeh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r4 = r1.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x0701:
            if (r5 >= r4) goto L_0x0738
            r11 = r1[r5]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r12 = r8.zzaep     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r2 = r8.zzaem     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r11.zzb(r12, r2)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r7 == 0) goto L_0x0716
            boolean r2 = r11.zzeo()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x0716
            r7 = 1
            goto L_0x0717
        L_0x0716:
            r7 = 0
        L_0x0717:
            boolean r2 = r11.isReady()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x0726
            boolean r2 = r11.zzeo()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x0724
            goto L_0x0726
        L_0x0724:
            r2 = 0
            goto L_0x0727
        L_0x0726:
            r2 = 1
        L_0x0727:
            if (r2 != 0) goto L_0x072c
            r11.zzdp()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x072c:
            if (r6 == 0) goto L_0x0732
            if (r2 == 0) goto L_0x0732
            r6 = 1
            goto L_0x0733
        L_0x0732:
            r6 = 0
        L_0x0733:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x0701
        L_0x0738:
            if (r6 != 0) goto L_0x073d
            r34.zzeh()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x073d:
            com.google.android.gms.internal.ads.zznv r1 = r8.zzaeg     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x0762
            com.google.android.gms.internal.ads.zznv r1 = r8.zzaeg     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgu r1 = r1.zzfc()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgu r2 = r8.zzadh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r2 = r1.equals(r2)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x0762
            r8.zzadh = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzod r2 = r8.zzaec     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zznv r3 = r8.zzaeg     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.zza(r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r2 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0762:
            com.google.android.gms.internal.ads.zzgy r1 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r2.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r3 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r1 = r1.zza(r2, r3, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r1 = r1.zzagh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r7 == 0) goto L_0x0793
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0783
            com.google.android.gms.internal.ads.zzgn r3 = r8.zzadi     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r3 = r3.zzaev     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0793
        L_0x0783:
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaes     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r3 = r3.zzadt     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 == 0) goto L_0x0793
            r3 = 4
            r8.setState(r3)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r34.zzee()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r4 = 2
            goto L_0x0813
        L_0x0793:
            int r3 = r8.state     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r4 = 2
            if (r3 != r4) goto L_0x07f8
            com.google.android.gms.internal.ads.zzgx[] r3 = r8.zzaeh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r3 = r3.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 <= 0) goto L_0x07e6
            if (r6 == 0) goto L_0x07e4
            boolean r1 = r8.zzaej     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r2 = r2.zzadu     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 != 0) goto L_0x07ac
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r2 = r2.zzads     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x07b4
        L_0x07ac:
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzls r2 = r2.zzadm     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r2 = r2.zzhd()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x07b4:
            r5 = -9223372036854775808
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x07d0
            com.google.android.gms.internal.ads.zzgk r2 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r2 = r2.zzadt     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r2 == 0) goto L_0x07c2
            r1 = 1
            goto L_0x07e0
        L_0x07c2:
            com.google.android.gms.internal.ads.zzgy r2 = r8.zzadd     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r3 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r3 = r3.zzadr     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r5 = r8.zzacw     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzha r2 = r2.zza(r3, r5, r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r2 = r2.zzagh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x07d0:
            com.google.android.gms.internal.ads.zzgs r5 = r8.zzadz     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgk r6 = r8.zzaeq     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r11 = r8.zzaep     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r6 = r6.zzdz()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            long r11 = r11 - r6
            long r2 = r2 - r11
            boolean r1 = r5.zzc(r2, r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x07e0:
            if (r1 == 0) goto L_0x07e4
            r1 = 1
            goto L_0x07ea
        L_0x07e4:
            r1 = 0
            goto L_0x07ea
        L_0x07e6:
            boolean r1 = r8.zzdl(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x07ea:
            if (r1 == 0) goto L_0x0813
            r1 = 3
            r8.setState(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            boolean r1 = r8.zzacy     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x0813
            r34.zzed()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0813
        L_0x07f8:
            int r3 = r8.state     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r5 = 3
            if (r3 != r5) goto L_0x0813
            com.google.android.gms.internal.ads.zzgx[] r3 = r8.zzaeh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r3 = r3.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r3 <= 0) goto L_0x0803
            goto L_0x0807
        L_0x0803:
            boolean r6 = r8.zzdl(r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0807:
            if (r6 != 0) goto L_0x0813
            boolean r1 = r8.zzacy     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzaej = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.setState(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r34.zzee()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0813:
            int r1 = r8.state     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != r4) goto L_0x0824
            com.google.android.gms.internal.ads.zzgx[] r1 = r8.zzaeh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r2 = r1.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x081a:
            if (r9 >= r2) goto L_0x0824
            r3 = r1[r9]     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.zzdp()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r9 = r9 + 1
            goto L_0x081a
        L_0x0824:
            boolean r1 = r8.zzacy     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x082d
            int r1 = r8.state     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2 = 3
            if (r1 == r2) goto L_0x0831
        L_0x082d:
            int r1 = r8.state     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != r4) goto L_0x0837
        L_0x0831:
            r1 = 10
            r8.zza(r14, r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0847
        L_0x0837:
            com.google.android.gms.internal.ads.zzgx[] r1 = r8.zzaeh     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r1 = r1.length     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x0842
            r1 = 1000(0x3e8, double:4.94E-321)
            r8.zza(r14, r1)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0847
        L_0x0842:
            android.os.Handler r1 = r8.handler     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.removeMessages(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0847:
            com.google.android.gms.internal.ads.zzog.endSection()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x084a:
            return r10
        L_0x084b:
            r4 = 2
            int r1 = r1.arg1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x0852
            r1 = 1
            goto L_0x0853
        L_0x0852:
            r1 = 0
        L_0x0853:
            r8.zzaej = r9     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzacy = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != 0) goto L_0x0860
            r34.zzee()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r34.zzef()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0877
        L_0x0860:
            int r1 = r8.state     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2 = 3
            if (r1 != r2) goto L_0x086e
            r34.zzed()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r1 = r8.handler     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            goto L_0x0877
        L_0x086e:
            int r1 = r8.state     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 != r4) goto L_0x0877
            android.os.Handler r1 = r8.handler     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x0877:
            return r10
        L_0x0878:
            r4 = 2
            java.lang.Object r2 = r1.obj     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzlu r2 = (com.google.android.gms.internal.ads.zzlu) r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            int r1 = r1.arg1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x0883
            r1 = 1
            goto L_0x0884
        L_0x0883:
            r1 = 0
        L_0x0884:
            android.os.Handler r3 = r8.zzacs     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.sendEmptyMessage(r9)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzh(r10)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgs r3 = r8.zzadz     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r3.zzel()     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            if (r1 == 0) goto L_0x089f
            com.google.android.gms.internal.ads.zzgn r1 = new com.google.android.gms.internal.ads.zzgn     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r9, r5)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.zzadi = r1     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
        L_0x089f:
            r8.zzaea = r2     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            com.google.android.gms.internal.ads.zzgc r1 = r8.zzaee     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r2.zza(r1, r10, r8)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r8.setState(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            android.os.Handler r1 = r8.handler     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            r1.sendEmptyMessage(r4)     // Catch:{ zzgd -> 0x08b4, IOException -> 0x08af, RuntimeException -> 0x08b9 }
            return r10
        L_0x08af:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08d9
        L_0x08b4:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08f5
        L_0x08b9:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.zzacs
            com.google.android.gms.internal.ads.zzgd r1 = com.google.android.gms.internal.ads.zzgd.zza(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzeg()
            return r10
        L_0x08d5:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08d9:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Source error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.zzacs
            com.google.android.gms.internal.ads.zzgd r1 = com.google.android.gms.internal.ads.zzgd.zza(r1)
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzeg()
            return r10
        L_0x08f1:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08f5:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Renderer error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.zzacs
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzeg()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgl.handleMessage(android.os.Message):boolean");
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzacs.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zzg(boolean z) {
        if (this.zzadc != z) {
            this.zzadc = z;
            this.zzacs.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzed() throws zzgd {
        this.zzaej = false;
        this.zzaec.start();
        for (zzgx start : this.zzaeh) {
            start.start();
        }
    }

    private final void zzee() throws zzgd {
        this.zzaec.stop();
        for (zzgx zza : this.zzaeh) {
            zza(zza);
        }
    }

    private final void zzef() throws zzgd {
        long j;
        zzgk zzgk = this.zzaes;
        if (zzgk != null) {
            long zzhc = zzgk.zzadm.zzhc();
            if (zzhc != -9223372036854775807L) {
                zzdk(zzhc);
            } else {
                zzgx zzgx = this.zzaef;
                if (zzgx == null || zzgx.zzeo()) {
                    this.zzaep = this.zzaec.zzfj();
                } else {
                    this.zzaep = this.zzaeg.zzfj();
                    this.zzaec.zzef(this.zzaep);
                }
                zzhc = this.zzaep - this.zzaes.zzdz();
            }
            this.zzadi.zzaev = zzhc;
            this.zzaem = SystemClock.elapsedRealtime() * 1000;
            if (this.zzaeh.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzaes.zzadm.zzhd();
            }
            zzgn zzgn = this.zzadi;
            if (j == Long.MIN_VALUE) {
                j = this.zzadd.zza(this.zzaes.zzadr, this.zzacw, false).zzagh;
            }
            zzgn.zzaew = j;
        }
    }

    private final void zza(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long zza(int i, long j) throws zzgd {
        zzgk zzgk;
        zzee();
        this.zzaej = false;
        setState(2);
        zzgk zzgk2 = this.zzaes;
        if (zzgk2 == null) {
            zzgk zzgk3 = this.zzaeq;
            if (zzgk3 != null) {
                zzgk3.release();
            }
            zzgk = null;
        } else {
            zzgk = null;
            while (zzgk2 != null) {
                if (zzgk2.zzadr != i || !zzgk2.zzadu) {
                    zzgk2.release();
                } else {
                    zzgk = zzgk2;
                }
                zzgk2 = zzgk2.zzadw;
            }
        }
        zzgk zzgk4 = this.zzaes;
        if (!(zzgk4 == zzgk && zzgk4 == this.zzaer)) {
            for (zzgx disable : this.zzaeh) {
                disable.disable();
            }
            this.zzaeh = new zzgx[0];
            this.zzaeg = null;
            this.zzaef = null;
            this.zzaes = null;
        }
        if (zzgk != null) {
            zzgk.zzadw = null;
            this.zzaeq = zzgk;
            this.zzaer = zzgk;
            zzb(zzgk);
            if (this.zzaes.zzadv) {
                j = this.zzaes.zzadm.zzea(j);
            }
            zzdk(j);
            zzei();
        } else {
            this.zzaeq = null;
            this.zzaer = null;
            this.zzaes = null;
            zzdk(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final void zzdk(long j) throws zzgd {
        long j2;
        zzgk zzgk = this.zzaes;
        if (zzgk == null) {
            j2 = 60000000;
        } else {
            j2 = zzgk.zzdz();
        }
        this.zzaep = j + j2;
        this.zzaec.zzef(this.zzaep);
        for (zzgx zzdi : this.zzaeh) {
            zzdi.zzdi(this.zzaep);
        }
    }

    private final void zzeg() {
        zzh(true);
        this.zzadz.onStopped();
        setState(1);
    }

    private final void zzh(boolean z) {
        zzgx[] zzgxArr;
        this.handler.removeMessages(2);
        this.zzaej = false;
        this.zzaec.stop();
        this.zzaeg = null;
        this.zzaef = null;
        this.zzaep = 60000000;
        for (zzgx zzgx : this.zzaeh) {
            try {
                zza(zzgx);
                zzgx.disable();
            } catch (zzgd | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzaeh = new zzgx[0];
        zzgk zzgk = this.zzaes;
        if (zzgk == null) {
            zzgk = this.zzaeq;
        }
        zza(zzgk);
        this.zzaeq = null;
        this.zzaer = null;
        this.zzaes = null;
        zzg(false);
        if (z) {
            zzlu zzlu = this.zzaea;
            if (zzlu != null) {
                zzlu.zzhm();
                this.zzaea = null;
            }
            this.zzadd = null;
        }
    }

    private static void zza(zzgx zzgx) throws zzgd {
        if (zzgx.getState() == 2) {
            zzgx.stop();
        }
    }

    private final boolean zzdl(long j) {
        return j == -9223372036854775807L || this.zzadi.zzaev < j || (this.zzaes.zzadw != null && this.zzaes.zzadw.zzadu);
    }

    private final void zzeh() throws IOException {
        zzgk zzgk = this.zzaeq;
        if (zzgk != null && !zzgk.zzadu) {
            zzgk zzgk2 = this.zzaer;
            if (zzgk2 == null || zzgk2.zzadw == this.zzaeq) {
                zzgx[] zzgxArr = this.zzaeh;
                int length = zzgxArr.length;
                int i = 0;
                while (i < length) {
                    if (zzgxArr[i].zzdm()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzaeq.zzadm.zzha();
            }
        }
    }

    private final void zza(Object obj, int i) {
        this.zzadi = new zzgn(0, 0);
        zzb(obj, i);
        this.zzadi = new zzgn(0, -9223372036854775807L);
        setState(4);
        zzh(false);
    }

    private final void zzb(Object obj, int i) {
        this.zzacs.obtainMessage(6, new zzgp(this.zzadd, obj, this.zzadi, i)).sendToTarget();
    }

    private final int zza(int i, zzgy zzgy, zzgy zzgy2) {
        int zzeq = zzgy.zzeq();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < zzeq && i3 == -1; i4++) {
            i2 = zzgy.zza(i2, this.zzacw, this.zzacv, this.repeatMode);
            i3 = zzgy2.zzc(zzgy.zza(i2, this.zzacw, true).zzadn);
        }
        return i3;
    }

    private final boolean zzn(int i) {
        this.zzadd.zza(i, this.zzacw, false);
        if (this.zzadd.zza(0, this.zzacv, false).zzagt || this.zzadd.zza(i, this.zzacw, this.zzacv, this.repeatMode) != -1) {
            return false;
        }
        return true;
    }

    private final Pair<Integer, Long> zza(zzgm zzgm) {
        zzgy zzgy = zzgm.zzadd;
        if (zzgy.isEmpty()) {
            zzgy = this.zzadd;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzgy, zzgm.zzaet, zzgm.zzaeu);
            zzgy zzgy2 = this.zzadd;
            if (zzgy2 == zzgy) {
                return zzb;
            }
            int zzc = zzgy2.zzc(zzgy.zza(((Integer) zzb.first).intValue(), this.zzacw, true).zzadn);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzgy, this.zzadd);
            if (zza == -1) {
                return null;
            }
            this.zzadd.zza(zza, this.zzacw, false);
            return zzb(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgt(this.zzadd, zzgm.zzaet, zzgm.zzaeu);
        }
    }

    private final Pair<Integer, Long> zzb(int i, long j) {
        return zzb(this.zzadd, i, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzb(zzgy zzgy, int i, long j) {
        return zza(zzgy, i, j, 0);
    }

    private final Pair<Integer, Long> zza(zzgy zzgy, int i, long j, long j2) {
        zznr.zzc(i, 0, zzgy.zzep());
        zzgy.zza(i, this.zzacv, false, j2);
        if (j == -9223372036854775807L) {
            j = this.zzacv.zzagw;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.zzacv.zzagx + j;
        long j4 = zzgy.zza(0, this.zzacw, false).zzagh;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(Integer.valueOf(0), Long.valueOf(j3));
    }

    private final void zzei() {
        long j;
        if (!this.zzaeq.zzadu) {
            j = 0;
        } else {
            j = this.zzaeq.zzadm.zzgz();
        }
        if (j == Long.MIN_VALUE) {
            zzg(false);
            return;
        }
        long zzdz = this.zzaep - this.zzaeq.zzdz();
        boolean zzdn = this.zzadz.zzdn(j - zzdz);
        zzg(zzdn);
        if (zzdn) {
            this.zzaeq.zzadm.zzdy(zzdz);
        }
    }

    private static void zza(zzgk zzgk) {
        while (zzgk != null) {
            zzgk.release();
            zzgk = zzgk.zzadw;
        }
    }

    private final void zzb(zzgk zzgk) throws zzgd {
        if (this.zzaes != zzgk) {
            boolean[] zArr = new boolean[this.zzacp.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzgx[] zzgxArr = this.zzacp;
                if (i < zzgxArr.length) {
                    zzgx zzgx = zzgxArr[i];
                    zArr[i] = zzgx.getState() != 0;
                    zzmt zzax = zzgk.zzadx.zzbef.zzax(i);
                    if (zzax != null) {
                        i2++;
                    }
                    if (zArr[i] && (zzax == null || (zzgx.zzdo() && zzgx.zzdl() == this.zzaes.zzado[i]))) {
                        if (zzgx == this.zzaef) {
                            this.zzaec.zza(this.zzaeg);
                            this.zzaeg = null;
                            this.zzaef = null;
                        }
                        zza(zzgx);
                        zzgx.disable();
                    }
                    i++;
                } else {
                    this.zzaes = zzgk;
                    this.zzacs.obtainMessage(3, zzgk.zzadx).sendToTarget();
                    zza(zArr, i2);
                    return;
                }
            }
        }
    }

    private final void zza(boolean[] zArr, int i) throws zzgd {
        this.zzaeh = new zzgx[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzgx[] zzgxArr = this.zzacp;
            if (i2 < zzgxArr.length) {
                zzgx zzgx = zzgxArr[i2];
                zzmt zzax = this.zzaes.zzadx.zzbef.zzax(i2);
                if (zzax != null) {
                    int i4 = i3 + 1;
                    this.zzaeh[i3] = zzgx;
                    if (zzgx.getState() == 0) {
                        zzgz zzgz = this.zzaes.zzadx.zzbeh[i2];
                        boolean z = this.zzacy && this.state == 3;
                        boolean z2 = !zArr[i2] && z;
                        zzgo[] zzgoArr = new zzgo[zzax.length()];
                        for (int i5 = 0; i5 < zzgoArr.length; i5++) {
                            zzgoArr[i5] = zzax.zzau(i5);
                        }
                        zzgx.zza(zzgz, zzgoArr, this.zzaes.zzado[i2], this.zzaep, z2, this.zzaes.zzdz());
                        zznv zzdk = zzgx.zzdk();
                        if (zzdk != null) {
                            if (this.zzaeg == null) {
                                this.zzaeg = zzdk;
                                this.zzaef = zzgx;
                                this.zzaeg.zzb(this.zzadh);
                            } else {
                                throw zzgd.zza((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzgx.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public final /* synthetic */ void zza(zzmg zzmg) {
        this.handler.obtainMessage(9, (zzls) zzmg).sendToTarget();
    }
}
