package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.ic */
public class C1847ic {

    /* renamed from: d */
    private static final String f3879d = "ic";

    /* renamed from: a */
    int f3880a;

    /* renamed from: b */
    int f3881b;

    /* renamed from: c */
    C3174ie f3882c;

    /* renamed from: e */
    private int[] f3883e;

    /* renamed from: f */
    private final int[] f3884f;

    /* renamed from: g */
    private ByteBuffer f3885g;

    /* renamed from: h */
    private byte[] f3886h;
    @Nullable

    /* renamed from: i */
    private byte[] f3887i;

    /* renamed from: j */
    private int f3888j;

    /* renamed from: k */
    private int f3889k;

    /* renamed from: l */
    private C3175if f3890l;

    /* renamed from: m */
    private short[] f3891m;

    /* renamed from: n */
    private byte[] f3892n;

    /* renamed from: o */
    private byte[] f3893o;

    /* renamed from: p */
    private byte[] f3894p;

    /* renamed from: q */
    private int[] f3895q;

    /* renamed from: r */
    private C1848a f3896r;

    /* renamed from: s */
    private Bitmap f3897s;

    /* renamed from: t */
    private boolean f3898t;

    /* renamed from: u */
    private int f3899u;

    /* renamed from: v */
    private int f3900v;

    /* renamed from: w */
    private int f3901w;

    /* renamed from: x */
    private int f3902x;

    /* renamed from: y */
    private boolean f3903y;

    /* renamed from: com.tapjoy.internal.ic$a */
    interface C1848a {
        @Nonnull
        /* renamed from: a */
        Bitmap mo18192a(int i, int i2, Config config);

        /* renamed from: a */
        byte[] mo18193a(int i);

        /* renamed from: b */
        int[] mo18194b(int i);
    }

    C1847ic(C1848a aVar, C3174ie ieVar, ByteBuffer byteBuffer) {
        this(aVar, ieVar, byteBuffer, 0);
    }

    private C1847ic(C1848a aVar, C3174ie ieVar, ByteBuffer byteBuffer, byte b) {
        this(aVar);
        m3648b(ieVar, byteBuffer);
    }

    private C1847ic(C1848a aVar) {
        this.f3884f = new int[256];
        this.f3888j = 0;
        this.f3889k = 0;
        this.f3896r = aVar;
        this.f3882c = new C3174ie();
    }

    C1847ic() {
        this(new C1849ih());
    }

    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r27v5 */
    /* JADX WARNING: type inference failed for: r27v6 */
    /* JADX WARNING: type inference failed for: r2v32 */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r24v3 */
    /* JADX WARNING: type inference failed for: r16v4 */
    /* JADX WARNING: type inference failed for: r27v7 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r2v36 */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r27v8 */
    /* JADX WARNING: type inference failed for: r9v23 */
    /* JADX WARNING: type inference failed for: r27v10 */
    /* JADX WARNING: type inference failed for: r4v49, types: [short[]] */
    /* JADX WARNING: type inference failed for: r2v43, types: [short] */
    /* JADX WARNING: type inference failed for: r4v50 */
    /* JADX WARNING: type inference failed for: r2v45, types: [int] */
    /* JADX WARNING: type inference failed for: r9v27 */
    /* JADX WARNING: type inference failed for: r27v11 */
    /* JADX WARNING: type inference failed for: r9v28 */
    /* JADX WARNING: type inference failed for: r24v5 */
    /* JADX WARNING: type inference failed for: r27v12 */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r16v6 */
    /* JADX WARNING: type inference failed for: r27v13 */
    /* JADX WARNING: type inference failed for: r9v36 */
    /* JADX WARNING: type inference failed for: r2v50 */
    /* JADX WARNING: type inference failed for: r9v37 */
    /* JADX WARNING: type inference failed for: r9v38 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r2v43, types: [short] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short[], code=null, for r4v49, types: [short[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r24v3
      assigns: []
      uses: []
      mth insns count: 539
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0223  */
    /* JADX WARNING: Unknown variable types count: 16 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.Bitmap mo18191a() {
        /*
            r30 = this;
            r1 = r30
            monitor-enter(r30)
            com.tapjoy.internal.ie r0 = r1.f3882c     // Catch:{ all -> 0x0407 }
            int r0 = r0.f7543c     // Catch:{ all -> 0x0407 }
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 <= 0) goto L_0x0010
            int r0 = r1.f3880a     // Catch:{ all -> 0x0407 }
            if (r0 >= 0) goto L_0x0026
        L_0x0010:
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0407 }
            com.tapjoy.internal.ie r5 = r1.f3882c     // Catch:{ all -> 0x0407 }
            int r5 = r5.f7543c     // Catch:{ all -> 0x0407 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0407 }
            r0[r3] = r5     // Catch:{ all -> 0x0407 }
            int r5 = r1.f3880a     // Catch:{ all -> 0x0407 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0407 }
            r0[r4] = r5     // Catch:{ all -> 0x0407 }
            r1.f3899u = r4     // Catch:{ all -> 0x0407 }
        L_0x0026:
            int r0 = r1.f3899u     // Catch:{ all -> 0x0407 }
            r5 = 0
            if (r0 == r4) goto L_0x03f9
            int r0 = r1.f3899u     // Catch:{ all -> 0x0407 }
            if (r0 != r2) goto L_0x0031
            goto L_0x03f9
        L_0x0031:
            r1.f3899u = r3     // Catch:{ all -> 0x0407 }
            com.tapjoy.internal.ie r0 = r1.f3882c     // Catch:{ all -> 0x0407 }
            java.util.List r0 = r0.f7545e     // Catch:{ all -> 0x0407 }
            int r6 = r1.f3880a     // Catch:{ all -> 0x0407 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0407 }
            com.tapjoy.internal.id r0 = (com.tapjoy.internal.C3173id) r0     // Catch:{ all -> 0x0407 }
            int r6 = r1.f3880a     // Catch:{ all -> 0x0407 }
            int r6 = r6 - r4
            if (r6 < 0) goto L_0x004f
            com.tapjoy.internal.ie r7 = r1.f3882c     // Catch:{ all -> 0x0407 }
            java.util.List r7 = r7.f7545e     // Catch:{ all -> 0x0407 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x0407 }
            com.tapjoy.internal.id r6 = (com.tapjoy.internal.C3173id) r6     // Catch:{ all -> 0x0407 }
            goto L_0x0050
        L_0x004f:
            r6 = r5
        L_0x0050:
            int[] r7 = r0.f7540k     // Catch:{ all -> 0x0407 }
            if (r7 == 0) goto L_0x0057
            int[] r7 = r0.f7540k     // Catch:{ all -> 0x0407 }
            goto L_0x005b
        L_0x0057:
            com.tapjoy.internal.ie r7 = r1.f3882c     // Catch:{ all -> 0x0407 }
            int[] r7 = r7.f7541a     // Catch:{ all -> 0x0407 }
        L_0x005b:
            r1.f3883e = r7     // Catch:{ all -> 0x0407 }
            int[] r7 = r1.f3883e     // Catch:{ all -> 0x0407 }
            if (r7 != 0) goto L_0x006f
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x0407 }
            int r2 = r1.f3880a     // Catch:{ all -> 0x0407 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0407 }
            r0[r3] = r2     // Catch:{ all -> 0x0407 }
            r1.f3899u = r4     // Catch:{ all -> 0x0407 }
            monitor-exit(r30)
            return r5
        L_0x006f:
            boolean r5 = r0.f7535f     // Catch:{ all -> 0x0407 }
            if (r5 == 0) goto L_0x0087
            int[] r5 = r1.f3883e     // Catch:{ all -> 0x0407 }
            int[] r7 = r1.f3884f     // Catch:{ all -> 0x0407 }
            int[] r8 = r1.f3883e     // Catch:{ all -> 0x0407 }
            int r8 = r8.length     // Catch:{ all -> 0x0407 }
            java.lang.System.arraycopy(r5, r3, r7, r3, r8)     // Catch:{ all -> 0x0407 }
            int[] r5 = r1.f3884f     // Catch:{ all -> 0x0407 }
            r1.f3883e = r5     // Catch:{ all -> 0x0407 }
            int[] r5 = r1.f3883e     // Catch:{ all -> 0x0407 }
            int r7 = r0.f7537h     // Catch:{ all -> 0x0407 }
            r5[r7] = r3     // Catch:{ all -> 0x0407 }
        L_0x0087:
            int[] r5 = r1.f3895q     // Catch:{ all -> 0x0407 }
            if (r6 != 0) goto L_0x008e
            java.util.Arrays.fill(r5, r3)     // Catch:{ all -> 0x0407 }
        L_0x008e:
            r7 = 3
            if (r6 == 0) goto L_0x00eb
            int r8 = r6.f7536g     // Catch:{ all -> 0x0407 }
            if (r8 <= 0) goto L_0x00eb
            int r8 = r6.f7536g     // Catch:{ all -> 0x0407 }
            if (r8 != r2) goto L_0x00b9
            boolean r8 = r0.f7535f     // Catch:{ all -> 0x0407 }
            if (r8 != 0) goto L_0x00ae
            com.tapjoy.internal.ie r8 = r1.f3882c     // Catch:{ all -> 0x0407 }
            int r8 = r8.f7552l     // Catch:{ all -> 0x0407 }
            int[] r9 = r0.f7540k     // Catch:{ all -> 0x0407 }
            if (r9 == 0) goto L_0x00b5
            com.tapjoy.internal.ie r9 = r1.f3882c     // Catch:{ all -> 0x0407 }
            int r9 = r9.f7550j     // Catch:{ all -> 0x0407 }
            int r10 = r0.f7537h     // Catch:{ all -> 0x0407 }
            if (r9 != r10) goto L_0x00b5
            goto L_0x00b4
        L_0x00ae:
            int r8 = r1.f3880a     // Catch:{ all -> 0x0407 }
            if (r8 != 0) goto L_0x00b4
            r1.f3903y = r4     // Catch:{ all -> 0x0407 }
        L_0x00b4:
            r8 = 0
        L_0x00b5:
            r1.m3646a(r5, r6, r8)     // Catch:{ all -> 0x0407 }
            goto L_0x00eb
        L_0x00b9:
            int r8 = r6.f7536g     // Catch:{ all -> 0x0407 }
            if (r8 != r7) goto L_0x00eb
            android.graphics.Bitmap r8 = r1.f3897s     // Catch:{ all -> 0x0407 }
            if (r8 != 0) goto L_0x00c5
            r1.m3646a(r5, r6, r3)     // Catch:{ all -> 0x0407 }
            goto L_0x00eb
        L_0x00c5:
            int r8 = r6.f7533d     // Catch:{ all -> 0x0407 }
            int r9 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r15 = r8 / r9
            int r8 = r6.f7531b     // Catch:{ all -> 0x0407 }
            int r9 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r13 = r8 / r9
            int r8 = r6.f7532c     // Catch:{ all -> 0x0407 }
            int r9 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r14 = r8 / r9
            int r6 = r6.f7530a     // Catch:{ all -> 0x0407 }
            int r8 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r12 = r6 / r8
            int r6 = r1.f3902x     // Catch:{ all -> 0x0407 }
            int r6 = r6 * r13
            int r10 = r6 + r12
            android.graphics.Bitmap r8 = r1.f3897s     // Catch:{ all -> 0x0407 }
            int r11 = r1.f3902x     // Catch:{ all -> 0x0407 }
            r9 = r5
            r8.getPixels(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0407 }
        L_0x00eb:
            r1.f3888j = r3     // Catch:{ all -> 0x0407 }
            r1.f3889k = r3     // Catch:{ all -> 0x0407 }
            if (r0 == 0) goto L_0x00f8
            java.nio.ByteBuffer r6 = r1.f3885g     // Catch:{ all -> 0x0407 }
            int r8 = r0.f7539j     // Catch:{ all -> 0x0407 }
            r6.position(r8)     // Catch:{ all -> 0x0407 }
        L_0x00f8:
            if (r0 != 0) goto L_0x0105
            com.tapjoy.internal.ie r6 = r1.f3882c     // Catch:{ all -> 0x0407 }
            int r6 = r6.f7546f     // Catch:{ all -> 0x0407 }
            com.tapjoy.internal.ie r8 = r1.f3882c     // Catch:{ all -> 0x0407 }
            int r8 = r8.f7547g     // Catch:{ all -> 0x0407 }
        L_0x0102:
            int r6 = r6 * r8
            goto L_0x010a
        L_0x0105:
            int r6 = r0.f7532c     // Catch:{ all -> 0x0407 }
            int r8 = r0.f7533d     // Catch:{ all -> 0x0407 }
            goto L_0x0102
        L_0x010a:
            byte[] r8 = r1.f3894p     // Catch:{ all -> 0x0407 }
            if (r8 == 0) goto L_0x0113
            byte[] r8 = r1.f3894p     // Catch:{ all -> 0x0407 }
            int r8 = r8.length     // Catch:{ all -> 0x0407 }
            if (r8 >= r6) goto L_0x011b
        L_0x0113:
            com.tapjoy.internal.ic$a r8 = r1.f3896r     // Catch:{ all -> 0x0407 }
            byte[] r8 = r8.mo18193a(r6)     // Catch:{ all -> 0x0407 }
            r1.f3894p = r8     // Catch:{ all -> 0x0407 }
        L_0x011b:
            short[] r8 = r1.f3891m     // Catch:{ all -> 0x0407 }
            r9 = 4096(0x1000, float:5.74E-42)
            if (r8 != 0) goto L_0x0125
            short[] r8 = new short[r9]     // Catch:{ all -> 0x0407 }
            r1.f3891m = r8     // Catch:{ all -> 0x0407 }
        L_0x0125:
            byte[] r8 = r1.f3892n     // Catch:{ all -> 0x0407 }
            if (r8 != 0) goto L_0x012d
            byte[] r8 = new byte[r9]     // Catch:{ all -> 0x0407 }
            r1.f3892n = r8     // Catch:{ all -> 0x0407 }
        L_0x012d:
            byte[] r8 = r1.f3893o     // Catch:{ all -> 0x0407 }
            if (r8 != 0) goto L_0x0137
            r8 = 4097(0x1001, float:5.741E-42)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x0407 }
            r1.f3893o = r8     // Catch:{ all -> 0x0407 }
        L_0x0137:
            int r8 = r30.m3649c()     // Catch:{ all -> 0x0407 }
            int r10 = r4 << r8
            int r11 = r10 + 1
            int r12 = r10 + 2
            int r8 = r8 + r4
            int r13 = r4 << r8
            int r13 = r13 - r4
            r14 = 0
        L_0x0146:
            if (r14 >= r10) goto L_0x0155
            short[] r15 = r1.f3891m     // Catch:{ all -> 0x0407 }
            r15[r14] = r3     // Catch:{ all -> 0x0407 }
            byte[] r15 = r1.f3892n     // Catch:{ all -> 0x0407 }
            byte r4 = (byte) r14     // Catch:{ all -> 0x0407 }
            r15[r14] = r4     // Catch:{ all -> 0x0407 }
            int r14 = r14 + 1
            r4 = 1
            goto L_0x0146
        L_0x0155:
            r4 = -1
            r22 = r8
            r20 = r12
            r21 = r13
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r23 = -1
            r24 = 0
            r25 = 0
        L_0x016c:
            r26 = 8
            if (r14 >= r6) goto L_0x026b
            if (r15 != 0) goto L_0x017e
            int r15 = r30.m3650d()     // Catch:{ all -> 0x0407 }
            if (r15 > 0) goto L_0x017c
            r1.f3899u = r7     // Catch:{ all -> 0x0407 }
            goto L_0x026b
        L_0x017c:
            r18 = 0
        L_0x017e:
            byte[] r2 = r1.f3886h     // Catch:{ all -> 0x0407 }
            byte r2 = r2[r18]     // Catch:{ all -> 0x0407 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r16
            int r17 = r17 + r2
            int r16 = r16 + 8
            int r18 = r18 + 1
            int r15 = r15 + r4
            r2 = r16
            r3 = r20
            r9 = r23
            r27 = r24
            r29 = r19
            r19 = r14
            r14 = r22
            r22 = r29
        L_0x019d:
            if (r2 < r14) goto L_0x0251
            r4 = r17 & r21
            int r17 = r17 >> r14
            int r2 = r2 - r14
            if (r4 != r10) goto L_0x01ad
            r14 = r8
            r3 = r12
            r21 = r13
            r4 = -1
            r9 = -1
            goto L_0x019d
        L_0x01ad:
            if (r4 <= r3) goto L_0x01b3
            r1.f3899u = r7     // Catch:{ all -> 0x0407 }
            goto L_0x0240
        L_0x01b3:
            if (r4 == r11) goto L_0x0240
            r7 = -1
            if (r9 != r7) goto L_0x01ca
            byte[] r9 = r1.f3893o     // Catch:{ all -> 0x0407 }
            int r23 = r25 + 1
            byte[] r7 = r1.f3892n     // Catch:{ all -> 0x0407 }
            byte r7 = r7[r4]     // Catch:{ all -> 0x0407 }
            r9[r25] = r7     // Catch:{ all -> 0x0407 }
            r9 = r4
            r27 = r9
            r25 = r23
            r4 = -1
            r7 = 3
            goto L_0x019d
        L_0x01ca:
            if (r4 < r3) goto L_0x01d9
            byte[] r7 = r1.f3893o     // Catch:{ all -> 0x0407 }
            int r23 = r25 + 1
            r28 = r2
            r2 = r27
            byte r2 = (byte) r2     // Catch:{ all -> 0x0407 }
            r7[r25] = r2     // Catch:{ all -> 0x0407 }
            r2 = r9
            goto L_0x01de
        L_0x01d9:
            r28 = r2
            r2 = r4
            r23 = r25
        L_0x01de:
            if (r2 < r10) goto L_0x01f5
            byte[] r7 = r1.f3893o     // Catch:{ all -> 0x0407 }
            int r25 = r23 + 1
            r27 = r4
            byte[] r4 = r1.f3892n     // Catch:{ all -> 0x0407 }
            byte r4 = r4[r2]     // Catch:{ all -> 0x0407 }
            r7[r23] = r4     // Catch:{ all -> 0x0407 }
            short[] r4 = r1.f3891m     // Catch:{ all -> 0x0407 }
            short r2 = r4[r2]     // Catch:{ all -> 0x0407 }
            r23 = r25
            r4 = r27
            goto L_0x01de
        L_0x01f5:
            r27 = r4
            byte[] r4 = r1.f3892n     // Catch:{ all -> 0x0407 }
            byte r2 = r4[r2]     // Catch:{ all -> 0x0407 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r4 = r1.f3893o     // Catch:{ all -> 0x0407 }
            int r7 = r23 + 1
            r25 = r7
            byte r7 = (byte) r2     // Catch:{ all -> 0x0407 }
            r4[r23] = r7     // Catch:{ all -> 0x0407 }
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 >= r4) goto L_0x0221
            short[] r4 = r1.f3891m     // Catch:{ all -> 0x0407 }
            short r9 = (short) r9     // Catch:{ all -> 0x0407 }
            r4[r3] = r9     // Catch:{ all -> 0x0407 }
            byte[] r4 = r1.f3892n     // Catch:{ all -> 0x0407 }
            r4[r3] = r7     // Catch:{ all -> 0x0407 }
            int r3 = r3 + 1
            r4 = r3 & r21
            if (r4 != 0) goto L_0x0233
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 >= r4) goto L_0x0221
            int r14 = r14 + 1
            int r21 = r21 + r3
        L_0x0221:
            if (r25 <= 0) goto L_0x0236
            byte[] r7 = r1.f3894p     // Catch:{ all -> 0x0407 }
            int r9 = r22 + 1
            byte[] r4 = r1.f3893o     // Catch:{ all -> 0x0407 }
            int r25 = r25 + -1
            byte r4 = r4[r25]     // Catch:{ all -> 0x0407 }
            r7[r22] = r4     // Catch:{ all -> 0x0407 }
            int r19 = r19 + 1
            r22 = r9
        L_0x0233:
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x0221
        L_0x0236:
            r9 = r27
            r4 = -1
            r7 = 3
            r27 = r2
            r2 = r28
            goto L_0x019d
        L_0x0240:
            r28 = r2
            r2 = r27
            r24 = r2
            r20 = r3
            r23 = r9
            r16 = r28
            r2 = 2
            r3 = 0
            r4 = -1
            r7 = 3
            goto L_0x025f
        L_0x0251:
            r28 = r2
            r2 = r27
            r24 = r2
            r20 = r3
            r23 = r9
            r16 = r28
            r2 = 2
            r3 = 0
        L_0x025f:
            r9 = 4096(0x1000, float:5.74E-42)
            r29 = r22
            r22 = r14
            r14 = r19
            r19 = r29
            goto L_0x016c
        L_0x026b:
            r2 = r19
        L_0x026d:
            if (r2 >= r6) goto L_0x0277
            byte[] r3 = r1.f3894p     // Catch:{ all -> 0x0407 }
            r4 = 0
            r3[r2] = r4     // Catch:{ all -> 0x0407 }
            int r2 = r2 + 1
            goto L_0x026d
        L_0x0277:
            int r2 = r0.f7533d     // Catch:{ all -> 0x0407 }
            int r3 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r2 = r2 / r3
            int r3 = r0.f7531b     // Catch:{ all -> 0x0407 }
            int r4 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r3 = r3 / r4
            int r4 = r0.f7532c     // Catch:{ all -> 0x0407 }
            int r6 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r4 = r4 / r6
            int r6 = r0.f7530a     // Catch:{ all -> 0x0407 }
            int r7 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r6 = r6 / r7
            int r7 = r1.f3880a     // Catch:{ all -> 0x0407 }
            if (r7 != 0) goto L_0x0291
            r7 = 1
            goto L_0x0292
        L_0x0291:
            r7 = 0
        L_0x0292:
            r8 = 0
            r9 = 0
            r10 = 1
            r11 = 8
        L_0x0297:
            if (r8 >= r2) goto L_0x03bf
            boolean r12 = r0.f7534e     // Catch:{ all -> 0x0407 }
            if (r12 == 0) goto L_0x02b9
            r12 = 4
            if (r9 < r2) goto L_0x02b4
            int r10 = r10 + 1
            r13 = 2
            if (r10 == r13) goto L_0x02b1
            r14 = 3
            if (r10 == r14) goto L_0x02ae
            if (r10 == r12) goto L_0x02ab
            goto L_0x02b6
        L_0x02ab:
            r9 = 1
            r11 = 2
            goto L_0x02b6
        L_0x02ae:
            r9 = 2
            r11 = 4
            goto L_0x02b6
        L_0x02b1:
            r14 = 3
            r9 = 4
            goto L_0x02b6
        L_0x02b4:
            r13 = 2
            r14 = 3
        L_0x02b6:
            int r12 = r9 + r11
            goto L_0x02bd
        L_0x02b9:
            r13 = 2
            r14 = 3
            r12 = r9
            r9 = r8
        L_0x02bd:
            int r9 = r9 + r3
            int r15 = r1.f3901w     // Catch:{ all -> 0x0407 }
            if (r9 >= r15) goto L_0x03aa
            int r15 = r1.f3902x     // Catch:{ all -> 0x0407 }
            int r9 = r9 * r15
            int r15 = r9 + r6
            int r13 = r15 + r4
            int r14 = r1.f3902x     // Catch:{ all -> 0x0407 }
            int r14 = r14 + r9
            if (r14 >= r13) goto L_0x02d2
            int r13 = r1.f3902x     // Catch:{ all -> 0x0407 }
            int r13 = r13 + r9
        L_0x02d2:
            int r9 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r9 = r9 * r8
            int r14 = r0.f7532c     // Catch:{ all -> 0x0407 }
            int r9 = r9 * r14
            int r14 = r13 - r15
            r17 = r2
            int r2 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r14 = r14 * r2
            int r14 = r14 + r9
        L_0x02e3:
            if (r15 >= r13) goto L_0x03ac
            int r2 = r1.f3900v     // Catch:{ all -> 0x0407 }
            r18 = r3
            r3 = 1
            if (r2 != r3) goto L_0x02fc
            byte[] r2 = r1.f3894p     // Catch:{ all -> 0x0407 }
            byte r2 = r2[r9]     // Catch:{ all -> 0x0407 }
            r2 = r2 & 255(0xff, float:3.57E-43)
            int[] r3 = r1.f3883e     // Catch:{ all -> 0x0407 }
            r3 = r3[r2]     // Catch:{ all -> 0x0407 }
            r25 = r4
            r27 = r6
            goto L_0x038f
        L_0x02fc:
            int r2 = r0.f7532c     // Catch:{ all -> 0x0407 }
            r25 = r4
            r3 = r9
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
        L_0x030b:
            int r4 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r4 = r4 + r9
            if (r3 >= r4) goto L_0x0342
            byte[] r4 = r1.f3894p     // Catch:{ all -> 0x0407 }
            int r4 = r4.length     // Catch:{ all -> 0x0407 }
            if (r3 >= r4) goto L_0x0342
            if (r3 >= r14) goto L_0x0342
            byte[] r4 = r1.f3894p     // Catch:{ all -> 0x0407 }
            byte r4 = r4[r3]     // Catch:{ all -> 0x0407 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            r27 = r6
            int[] r6 = r1.f3883e     // Catch:{ all -> 0x0407 }
            r4 = r6[r4]     // Catch:{ all -> 0x0407 }
            if (r4 == 0) goto L_0x033d
            int r6 = r4 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r19 = r19 + r6
            int r6 = r4 >> 16
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r20 = r20 + r6
            int r6 = r4 >> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r21 = r21 + r6
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r22 = r22 + r4
            int r23 = r23 + 1
        L_0x033d:
            int r3 = r3 + 1
            r6 = r27
            goto L_0x030b
        L_0x0342:
            r27 = r6
            int r2 = r2 + r9
            r3 = r2
        L_0x0346:
            int r4 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r4 = r4 + r2
            if (r3 >= r4) goto L_0x0379
            byte[] r4 = r1.f3894p     // Catch:{ all -> 0x0407 }
            int r4 = r4.length     // Catch:{ all -> 0x0407 }
            if (r3 >= r4) goto L_0x0379
            if (r3 >= r14) goto L_0x0379
            byte[] r4 = r1.f3894p     // Catch:{ all -> 0x0407 }
            byte r4 = r4[r3]     // Catch:{ all -> 0x0407 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int[] r6 = r1.f3883e     // Catch:{ all -> 0x0407 }
            r4 = r6[r4]     // Catch:{ all -> 0x0407 }
            if (r4 == 0) goto L_0x0376
            int r6 = r4 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r19 = r19 + r6
            int r6 = r4 >> 16
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r20 = r20 + r6
            int r6 = r4 >> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r21 = r21 + r6
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r22 = r22 + r4
            int r23 = r23 + 1
        L_0x0376:
            int r3 = r3 + 1
            goto L_0x0346
        L_0x0379:
            if (r23 != 0) goto L_0x037d
            r3 = 0
            goto L_0x038f
        L_0x037d:
            int r19 = r19 / r23
            int r2 = r19 << 24
            int r20 = r20 / r23
            int r3 = r20 << 16
            r2 = r2 | r3
            int r21 = r21 / r23
            int r3 = r21 << 8
            r2 = r2 | r3
            int r22 = r22 / r23
            r3 = r2 | r22
        L_0x038f:
            if (r3 == 0) goto L_0x0394
            r5[r15] = r3     // Catch:{ all -> 0x0407 }
            goto L_0x039d
        L_0x0394:
            boolean r2 = r1.f3903y     // Catch:{ all -> 0x0407 }
            if (r2 != 0) goto L_0x039d
            if (r7 == 0) goto L_0x039d
            r2 = 1
            r1.f3903y = r2     // Catch:{ all -> 0x0407 }
        L_0x039d:
            int r2 = r1.f3900v     // Catch:{ all -> 0x0407 }
            int r9 = r9 + r2
            int r15 = r15 + 1
            r3 = r18
            r4 = r25
            r6 = r27
            goto L_0x02e3
        L_0x03aa:
            r17 = r2
        L_0x03ac:
            r18 = r3
            r25 = r4
            r27 = r6
            int r8 = r8 + 1
            r9 = r12
            r2 = r17
            r3 = r18
            r4 = r25
            r6 = r27
            goto L_0x0297
        L_0x03bf:
            boolean r2 = r1.f3898t     // Catch:{ all -> 0x0407 }
            if (r2 == 0) goto L_0x03e5
            int r2 = r0.f7536g     // Catch:{ all -> 0x0407 }
            if (r2 == 0) goto L_0x03cc
            int r0 = r0.f7536g     // Catch:{ all -> 0x0407 }
            r2 = 1
            if (r0 != r2) goto L_0x03e5
        L_0x03cc:
            android.graphics.Bitmap r0 = r1.f3897s     // Catch:{ all -> 0x0407 }
            if (r0 != 0) goto L_0x03d6
            android.graphics.Bitmap r0 = r30.m3651e()     // Catch:{ all -> 0x0407 }
            r1.f3897s = r0     // Catch:{ all -> 0x0407 }
        L_0x03d6:
            android.graphics.Bitmap r8 = r1.f3897s     // Catch:{ all -> 0x0407 }
            r10 = 0
            int r11 = r1.f3902x     // Catch:{ all -> 0x0407 }
            r12 = 0
            r13 = 0
            int r14 = r1.f3902x     // Catch:{ all -> 0x0407 }
            int r15 = r1.f3901w     // Catch:{ all -> 0x0407 }
            r9 = r5
            r8.setPixels(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0407 }
        L_0x03e5:
            android.graphics.Bitmap r0 = r30.m3651e()     // Catch:{ all -> 0x0407 }
            r10 = 0
            int r11 = r1.f3902x     // Catch:{ all -> 0x0407 }
            r12 = 0
            r13 = 0
            int r14 = r1.f3902x     // Catch:{ all -> 0x0407 }
            int r15 = r1.f3901w     // Catch:{ all -> 0x0407 }
            r8 = r0
            r9 = r5
            r8.setPixels(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0407 }
            monitor-exit(r30)
            return r0
        L_0x03f9:
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0407 }
            int r2 = r1.f3899u     // Catch:{ all -> 0x0407 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0407 }
            r3 = 0
            r0[r3] = r2     // Catch:{ all -> 0x0407 }
            monitor-exit(r30)
            return r5
        L_0x0407:
            r0 = move-exception
            monitor-exit(r30)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C1847ic.mo18191a():android.graphics.Bitmap");
    }

    /* renamed from: a */
    private synchronized void m3645a(C3174ie ieVar, byte[] bArr) {
        m3644a(ieVar, ByteBuffer.wrap(bArr));
    }

    /* renamed from: a */
    private synchronized void m3644a(C3174ie ieVar, ByteBuffer byteBuffer) {
        m3648b(ieVar, byteBuffer);
    }

    /* renamed from: b */
    private synchronized void m3648b(C3174ie ieVar, ByteBuffer byteBuffer) {
        int highestOneBit = Integer.highestOneBit(1);
        this.f3899u = 0;
        this.f3882c = ieVar;
        this.f3903y = false;
        this.f3880a = -1;
        this.f3881b = 0;
        this.f3885g = byteBuffer.asReadOnlyBuffer();
        this.f3885g.position(0);
        this.f3885g.order(ByteOrder.LITTLE_ENDIAN);
        this.f3898t = false;
        Iterator it = ieVar.f7545e.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((C3173id) it.next()).f7536g == 3) {
                    this.f3898t = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f3900v = highestOneBit;
        this.f3902x = ieVar.f7546f / highestOneBit;
        this.f3901w = ieVar.f7547g / highestOneBit;
        this.f3894p = this.f3896r.mo18193a(ieVar.f7546f * ieVar.f7547g);
        this.f3895q = this.f3896r.mo18194b(this.f3902x * this.f3901w);
    }

    /* renamed from: a */
    private void m3646a(int[] iArr, C3173id idVar, int i) {
        int i2 = idVar.f7533d / this.f3900v;
        int i3 = idVar.f7531b / this.f3900v;
        int i4 = idVar.f7532c / this.f3900v;
        int i5 = idVar.f7530a / this.f3900v;
        int i6 = this.f3902x;
        int i7 = (i3 * i6) + i5;
        int i8 = (i2 * i6) + i7;
        while (i7 < i8) {
            int i9 = i7 + i4;
            for (int i10 = i7; i10 < i9; i10++) {
                iArr[i10] = i;
            }
            i7 += this.f3902x;
        }
    }

    /* renamed from: b */
    private void m3647b() {
        if (this.f3888j <= this.f3889k) {
            if (this.f3887i == null) {
                this.f3887i = this.f3896r.mo18193a(16384);
            }
            this.f3889k = 0;
            this.f3888j = Math.min(this.f3885g.remaining(), 16384);
            this.f3885g.get(this.f3887i, 0, this.f3888j);
        }
    }

    /* renamed from: c */
    private int m3649c() {
        try {
            m3647b();
            byte[] bArr = this.f3887i;
            int i = this.f3889k;
            this.f3889k = i + 1;
            return bArr[i] & 255;
        } catch (Exception unused) {
            this.f3899u = 1;
            return 0;
        }
    }

    /* renamed from: d */
    private int m3650d() {
        int c = m3649c();
        if (c > 0) {
            try {
                if (this.f3886h == null) {
                    this.f3886h = this.f3896r.mo18193a(255);
                }
                int i = this.f3888j - this.f3889k;
                if (i >= c) {
                    System.arraycopy(this.f3887i, this.f3889k, this.f3886h, 0, c);
                    this.f3889k += c;
                } else if (this.f3885g.remaining() + i >= c) {
                    System.arraycopy(this.f3887i, this.f3889k, this.f3886h, 0, i);
                    this.f3889k = this.f3888j;
                    m3647b();
                    int i2 = c - i;
                    System.arraycopy(this.f3887i, 0, this.f3886h, i, i2);
                    this.f3889k += i2;
                } else {
                    this.f3899u = 1;
                }
            } catch (Exception e) {
                new Object[1][0] = e;
                this.f3899u = 1;
            }
        }
        return c;
    }

    /* renamed from: e */
    private Bitmap m3651e() {
        Bitmap a = this.f3896r.mo18192a(this.f3902x, this.f3901w, this.f3903y ? Config.ARGB_4444 : Config.RGB_565);
        if (VERSION.SDK_INT >= 12) {
            a.setHasAlpha(true);
        }
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final synchronized int mo18190a(byte[] bArr) {
        if (this.f3890l == null) {
            this.f3890l = new C3175if();
        }
        this.f3882c = this.f3890l.mo30236a(bArr).mo30235a();
        if (bArr != null) {
            m3645a(this.f3882c, bArr);
        }
        return this.f3899u;
    }
}
