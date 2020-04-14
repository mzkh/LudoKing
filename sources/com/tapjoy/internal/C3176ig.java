package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.nio.ByteBuffer;

/* renamed from: com.tapjoy.internal.ig */
public final class C3176ig extends ImageView implements Runnable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1847ic f7558a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Bitmap f7559b;

    /* renamed from: c */
    private final Handler f7560c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private boolean f7561d;

    /* renamed from: e */
    private boolean f7562e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f7563f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Thread f7564g;

    /* renamed from: h */
    private C3180b f7565h = null;

    /* renamed from: i */
    private long f7566i = -1;

    /* renamed from: j */
    private C3179a f7567j = null;

    /* renamed from: k */
    private final Runnable f7568k = new Runnable() {
        public final void run() {
            if (C3176ig.this.f7559b != null && !C3176ig.this.f7559b.isRecycled()) {
                C3176ig igVar = C3176ig.this;
                igVar.setImageBitmap(igVar.f7559b);
            }
        }
    };

    /* renamed from: l */
    private final Runnable f7569l = new Runnable() {
        public final void run() {
            C3176ig.this.f7559b = null;
            C3176ig.this.f7558a = null;
            C3176ig.this.f7564g = null;
            C3176ig.this.f7563f = false;
        }
    };

    /* renamed from: com.tapjoy.internal.ig$a */
    public interface C3179a {
    }

    /* renamed from: com.tapjoy.internal.ig$b */
    public interface C3180b {
        /* renamed from: a */
        Bitmap mo30254a();
    }

    public C3176ig(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void mo30238a(C3174ie ieVar, byte[] bArr) {
        try {
            this.f7558a = new C1847ic(new C1849ih(), ieVar, ByteBuffer.wrap(bArr));
            if (this.f7561d) {
                m7337e();
            } else {
                m7336d();
            }
        } catch (Exception e) {
            this.f7558a = null;
            new Object[1][0] = e;
        }
    }

    public final void setBytes(byte[] bArr) {
        this.f7558a = new C1847ic();
        try {
            this.f7558a.mo18190a(bArr);
            if (this.f7561d) {
                m7337e();
            } else {
                m7336d();
            }
        } catch (Exception e) {
            this.f7558a = null;
            new Object[1][0] = e;
        }
    }

    public final long getFramesDisplayDuration() {
        return this.f7566i;
    }

    public final void setFramesDisplayDuration(long j) {
        this.f7566i = j;
    }

    /* renamed from: a */
    public final void mo30237a() {
        this.f7561d = true;
        m7337e();
    }

    /* renamed from: b */
    public final void mo30239b() {
        this.f7561d = false;
        Thread thread = this.f7564g;
        if (thread != null) {
            thread.interrupt();
            this.f7564g = null;
        }
    }

    /* renamed from: d */
    private void m7336d() {
        boolean z;
        if (this.f7558a.f3880a != 0) {
            C1847ic icVar = this.f7558a;
            if (-1 >= icVar.f3882c.f7543c) {
                z = false;
            } else {
                icVar.f3880a = -1;
                z = true;
            }
            if (z && !this.f7561d) {
                this.f7562e = true;
                m7337e();
            }
        }
    }

    /* renamed from: c */
    public final void mo30240c() {
        this.f7561d = false;
        this.f7562e = false;
        this.f7563f = true;
        mo30239b();
        this.f7560c.post(this.f7569l);
    }

    public final int getGifWidth() {
        return this.f7558a.f3882c.f7546f;
    }

    public final int getGifHeight() {
        return this.f7558a.f3882c.f7547g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c0 A[ADDED_TO_REGION, EDGE_INSN: B:65:0x00c0->B:56:0x00c0 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
        L_0x0000:
            boolean r0 = r11.f7561d
            if (r0 != 0) goto L_0x0008
            boolean r0 = r11.f7562e
            if (r0 == 0) goto L_0x00c2
        L_0x0008:
            com.tapjoy.internal.ic r0 = r11.f7558a
            com.tapjoy.internal.ie r1 = r0.f3882c
            int r1 = r1.f7543c
            r2 = -1
            r3 = 1
            r4 = 0
            if (r1 > 0) goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x003d
        L_0x0015:
            int r1 = r0.f3880a
            com.tapjoy.internal.ie r5 = r0.f3882c
            int r5 = r5.f7543c
            int r5 = r5 - r3
            if (r1 != r5) goto L_0x0023
            int r1 = r0.f3881b
            int r1 = r1 + r3
            r0.f3881b = r1
        L_0x0023:
            com.tapjoy.internal.ie r1 = r0.f3882c
            int r1 = r1.f7553m
            if (r1 == r2) goto L_0x0032
            int r1 = r0.f3881b
            com.tapjoy.internal.ie r5 = r0.f3882c
            int r5 = r5.f7553m
            if (r1 <= r5) goto L_0x0032
            goto L_0x0013
        L_0x0032:
            int r1 = r0.f3880a
            int r1 = r1 + r3
            com.tapjoy.internal.ie r5 = r0.f3882c
            int r5 = r5.f7543c
            int r1 = r1 % r5
            r0.f3880a = r1
            r0 = 1
        L_0x003d:
            r5 = 0
            long r7 = java.lang.System.nanoTime()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
            com.tapjoy.internal.ic r1 = r11.f7558a     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
            android.graphics.Bitmap r1 = r1.mo18191a()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
            r11.f7559b = r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
            com.tapjoy.internal.ig$b r1 = r11.f7565h     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
            if (r1 == 0) goto L_0x0057
            com.tapjoy.internal.ig$b r1 = r11.f7565h     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
            android.graphics.Bitmap r1 = r1.mo30254a()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
            r11.f7559b = r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
        L_0x0057:
            long r9 = java.lang.System.nanoTime()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0074, IllegalArgumentException -> 0x006d }
            long r9 = r9 - r7
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r9 / r7
            android.os.Handler r1 = r11.f7560c     // Catch:{ ArrayIndexOutOfBoundsException -> 0x006b, IllegalArgumentException -> 0x0069 }
            java.lang.Runnable r9 = r11.f7568k     // Catch:{ ArrayIndexOutOfBoundsException -> 0x006b, IllegalArgumentException -> 0x0069 }
            r1.post(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x006b, IllegalArgumentException -> 0x0069 }
            goto L_0x007a
        L_0x0069:
            r1 = move-exception
            goto L_0x006f
        L_0x006b:
            r1 = move-exception
            goto L_0x0076
        L_0x006d:
            r1 = move-exception
            r7 = r5
        L_0x006f:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r1
            goto L_0x007a
        L_0x0074:
            r1 = move-exception
            r7 = r5
        L_0x0076:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r1
        L_0x007a:
            r11.f7562e = r4
            boolean r1 = r11.f7561d
            if (r1 == 0) goto L_0x00c0
            if (r0 != 0) goto L_0x0083
            goto L_0x00c0
        L_0x0083:
            com.tapjoy.internal.ic r0 = r11.f7558a     // Catch:{ InterruptedException -> 0x00bb }
            com.tapjoy.internal.ie r1 = r0.f3882c     // Catch:{ InterruptedException -> 0x00bb }
            int r1 = r1.f7543c     // Catch:{ InterruptedException -> 0x00bb }
            if (r1 <= 0) goto L_0x00a9
            int r1 = r0.f3880a     // Catch:{ InterruptedException -> 0x00bb }
            if (r1 >= 0) goto L_0x0090
            goto L_0x00a9
        L_0x0090:
            int r1 = r0.f3880a     // Catch:{ InterruptedException -> 0x00bb }
            if (r1 < 0) goto L_0x00a8
            com.tapjoy.internal.ie r3 = r0.f3882c     // Catch:{ InterruptedException -> 0x00bb }
            int r3 = r3.f7543c     // Catch:{ InterruptedException -> 0x00bb }
            if (r1 >= r3) goto L_0x00a8
            com.tapjoy.internal.ie r0 = r0.f3882c     // Catch:{ InterruptedException -> 0x00bb }
            java.util.List r0 = r0.f7545e     // Catch:{ InterruptedException -> 0x00bb }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InterruptedException -> 0x00bb }
            com.tapjoy.internal.id r0 = (com.tapjoy.internal.C3173id) r0     // Catch:{ InterruptedException -> 0x00bb }
            int r2 = r0.f7538i     // Catch:{ InterruptedException -> 0x00bb }
            r4 = r2
            goto L_0x00a9
        L_0x00a8:
            r4 = -1
        L_0x00a9:
            long r0 = (long) r4     // Catch:{ InterruptedException -> 0x00bb }
            long r0 = r0 - r7
            int r1 = (int) r0     // Catch:{ InterruptedException -> 0x00bb }
            if (r1 <= 0) goto L_0x00bb
            long r2 = r11.f7566i     // Catch:{ InterruptedException -> 0x00bb }
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b7
            long r0 = r11.f7566i     // Catch:{ InterruptedException -> 0x00bb }
            goto L_0x00b8
        L_0x00b7:
            long r0 = (long) r1     // Catch:{ InterruptedException -> 0x00bb }
        L_0x00b8:
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00bb }
        L_0x00bb:
            boolean r0 = r11.f7561d
            if (r0 != 0) goto L_0x0000
            goto L_0x00c2
        L_0x00c0:
            r11.f7561d = r4
        L_0x00c2:
            boolean r0 = r11.f7563f
            if (r0 == 0) goto L_0x00cd
            android.os.Handler r0 = r11.f7560c
            java.lang.Runnable r1 = r11.f7569l
            r0.post(r1)
        L_0x00cd:
            r0 = 0
            r11.f7564g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3176ig.run():void");
    }

    public final C3180b getOnFrameAvailable() {
        return this.f7565h;
    }

    public final void setOnFrameAvailable(C3180b bVar) {
        this.f7565h = bVar;
    }

    public final C3179a getOnAnimationStop() {
        return this.f7567j;
    }

    public final void setOnAnimationStop(C3179a aVar) {
        this.f7567j = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo30240c();
    }

    /* renamed from: e */
    private void m7337e() {
        if ((this.f7561d || this.f7562e) && this.f7558a != null && this.f7564g == null) {
            this.f7564g = new Thread(this);
            this.f7564g.start();
        }
    }
}
