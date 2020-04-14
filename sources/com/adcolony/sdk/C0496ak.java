package com.adcolony.sdk;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.opengl.GLES20;
import android.util.Log;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

/* renamed from: com.adcolony.sdk.ak */
class C0496ak {

    /* renamed from: a */
    static final int f238a = 1;

    /* renamed from: b */
    static final int f239b = 2;

    /* renamed from: c */
    static final int f240c = 4;

    /* renamed from: d */
    static final int f241d = 1;

    /* renamed from: e */
    static final int f242e = 2;

    /* renamed from: f */
    static final int f243f = 512;

    /* renamed from: g */
    static int f244g = 1;

    /* renamed from: h */
    static ByteBuffer f245h;

    /* renamed from: i */
    static IntBuffer f246i;

    /* renamed from: j */
    static Options f247j = new Options();

    /* renamed from: k */
    static int[] f248k = new int[1];

    /* renamed from: A */
    C0500am f249A;

    /* renamed from: B */
    C0500am f250B;

    /* renamed from: C */
    C0500am f251C;

    /* renamed from: D */
    C0500am f252D;

    /* renamed from: E */
    C0500am f253E;

    /* renamed from: F */
    C0500am f254F;

    /* renamed from: l */
    int f255l;

    /* renamed from: m */
    int f256m;

    /* renamed from: n */
    int f257n;

    /* renamed from: o */
    int f258o;

    /* renamed from: p */
    ArrayList<C0497a> f259p = new ArrayList<>();

    /* renamed from: q */
    int f260q;

    /* renamed from: r */
    int f261r;

    /* renamed from: s */
    boolean f262s = true;

    /* renamed from: t */
    boolean f263t = true;

    /* renamed from: u */
    C0497a f264u;

    /* renamed from: v */
    int f265v;

    /* renamed from: w */
    FloatBuffer f266w;

    /* renamed from: x */
    FloatBuffer f267x;

    /* renamed from: y */
    IntBuffer f268y;

    /* renamed from: z */
    C0542as f269z = new C0542as(this);

    /* renamed from: com.adcolony.sdk.ak$a */
    class C0497a {

        /* renamed from: a */
        int f270a = C0496ak.f248k[0];

        /* renamed from: b */
        int f271b;

        /* renamed from: c */
        int f272c;

        /* renamed from: d */
        int f273d;

        /* renamed from: e */
        int f274e;

        /* renamed from: f */
        int f275f;

        /* renamed from: g */
        double f276g;

        /* renamed from: h */
        double f277h;

        C0497a() {
            int i = C0496ak.f244g;
            C0496ak.f244g = i + 1;
            this.f271b = i;
            GLES20.glGenTextures(1, C0496ak.f248k, 0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0497a mo8290a(IntBuffer intBuffer, int i, int i2) {
            int i3 = 1;
            int i4 = 1;
            while (i4 < i) {
                i4 <<= 1;
            }
            while (i3 < i2) {
                i3 <<= 1;
            }
            this.f272c = i;
            this.f273d = i2;
            this.f274e = i4;
            this.f275f = i3;
            double d = (double) this.f272c;
            double d2 = (double) this.f274e;
            Double.isNaN(d);
            Double.isNaN(d2);
            this.f276g = d / d2;
            double d3 = (double) this.f273d;
            double d4 = (double) this.f275f;
            Double.isNaN(d3);
            Double.isNaN(d4);
            this.f277h = d3 / d4;
            intBuffer.rewind();
            int i5 = i * i2;
            while (true) {
                i5--;
                if (i5 < 0) {
                    break;
                }
                int i6 = intBuffer.get(i5);
                intBuffer.put(i5, ((i6 << 16) & 16711680) | (-16711936 & i6) | ((i6 >> 16) & 255));
            }
            intBuffer.rewind();
            int i7 = this.f272c;
            int i8 = this.f274e;
            if (i7 < i8) {
                int i9 = this.f273d;
                int i10 = ((i9 - 1) * i8) + i7;
                int i11 = i7 * i9;
                int i12 = i8 - i7;
                while (true) {
                    i9--;
                    if (i9 < 0) {
                        break;
                    }
                    intBuffer.put(i10, intBuffer.get(i11 - 1));
                    int i13 = this.f272c;
                    while (true) {
                        i13--;
                        if (i13 < 0) {
                            break;
                        }
                        i10--;
                        i11--;
                        intBuffer.put(i10, intBuffer.get(i11));
                    }
                    i10 -= i12;
                }
            }
            intBuffer.rewind();
            int i14 = this.f273d;
            if (i14 < this.f275f) {
                int i15 = this.f274e;
                int i16 = i14 * i15;
                int i17 = i16 + i15;
                while (true) {
                    i15--;
                    if (i15 < 0) {
                        break;
                    }
                    i17--;
                    i16--;
                    intBuffer.put(i17, intBuffer.get(i16));
                }
            }
            GLES20.glBindTexture(3553, this.f270a);
            intBuffer.rewind();
            GLES20.glTexImage2D(3553, 0, 6408, this.f274e, this.f275f, 0, 6408, 5121, intBuffer);
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("ADC3 Texture::set gl_texture_id:");
            sb.append(this.f270a);
            sb.append(" texture_id:");
            sb.append(this.f271b);
            sb.append(" w:");
            sb.append(i);
            sb.append(" h:");
            sb.append(i2);
            printStream.println(sb.toString());
            return this;
        }
    }

    C0496ak() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4096);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f266w = allocateDirect.asFloatBuffer();
        this.f266w.rewind();
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(4096);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.f267x = allocateDirect2.asFloatBuffer();
        this.f267x.rewind();
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(Math.max(2048, 4194304));
        allocateDirect3.order(ByteOrder.nativeOrder());
        this.f268y = allocateDirect3.asIntBuffer();
        this.f268y.rewind();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8275a(double d, double d2, double d3, double d4, int i) {
        int i2 = (i >> 24) & 255;
        int i3 = (i >> 16) & 255;
        int i4 = (i >> 8) & 255;
        int i5 = i & 255;
        if (i2 > 0) {
            this.f263t = false;
        }
        if (i2 < 255) {
            this.f262s = false;
        }
        int i6 = (((i5 * i2) / 255) << 16) | (i2 << 24) | (((i4 * i2) / 255) << 8) | ((i3 * i2) / 255);
        this.f266w.put((float) d);
        this.f266w.put((float) d2);
        this.f267x.put((float) d3);
        this.f267x.put((float) d4);
        this.f268y.put(i6);
        this.f265v++;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8274a() {
        mo8284b((C0497a) null);
        this.f269z.mo8363b();
        mo8281b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8278a(int i, int i2, double d, int i3) {
        if (i != 0) {
            int i4 = 0;
            mo8286d();
            if ((i & 1) != 0) {
                i4 = 16384;
                GLES20.glClearColor(((float) ((i2 >> 16) & 255)) / 255.0f, ((float) ((i2 >> 8) & 255)) / 255.0f, ((float) (i2 & 255)) / 255.0f, ((float) ((i2 >> 24) & 255)) / 255.0f);
            }
            if ((i & 2) != 0) {
                i4 |= 256;
                GLES20.glClearDepthf((float) d);
            }
            if ((i & 4) != 0) {
                i4 |= 1024;
                GLES20.glClearStencil(i3);
            }
            GLES20.glClear(i4);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8281b() {
        mo8286d();
        GLES20.glDisable(3089);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0497a mo8271a(Bitmap bitmap) {
        mo8286d();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = 1;
        int i2 = 1;
        while (i2 < width) {
            i2 <<= 1;
        }
        while (i < height) {
            i <<= 1;
        }
        int i3 = i2 * i * 4;
        ByteBuffer byteBuffer = f245h;
        if (byteBuffer == null || byteBuffer.capacity() < i3) {
            int i4 = 4194304;
            if (i3 >= 4194304) {
                i4 = i3;
            }
            f245h = ByteBuffer.allocateDirect(i4);
            f245h.order(ByteOrder.nativeOrder());
            f246i = f245h.asIntBuffer();
        }
        f245h.rewind();
        bitmap.copyPixelsToBuffer(f245h);
        bitmap.recycle();
        C0497a aVar = new C0497a();
        this.f259p.add(aVar);
        return aVar.mo8290a(f246i, width, height);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8280a(C0497a aVar) {
        this.f259p.remove(aVar);
        f248k[0] = aVar.f271b;
        GLES20.glDeleteTextures(1, f248k, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo8285c() {
        mo8286d();
        mo8281b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0497a mo8270a(int i) {
        for (int i2 = 0; i2 < this.f259p.size(); i2++) {
            C0497a aVar = (C0497a) this.f259p.get(i2);
            if (aVar.f271b == i) {
                return aVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        if (r8 != 3) goto L_0x003d;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8286d() {
        /*
            r9 = this;
            int r0 = r9.f265v
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.adcolony.sdk.as r0 = r9.f269z
            r0.mo8370g()
            int r0 = r9.f260q
            r1 = r0 & 1
            r2 = 3042(0xbe2, float:4.263E-42)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x004a
            int r0 = r0 >> 8
            r0 = r0 & 15
            r1 = 771(0x303, float:1.08E-42)
            r6 = 770(0x302, float:1.079E-42)
            r7 = 3
            if (r0 == 0) goto L_0x002e
            if (r0 == r5) goto L_0x0026
            if (r0 == r3) goto L_0x002b
            if (r0 == r7) goto L_0x0028
        L_0x0026:
            r0 = 1
            goto L_0x002f
        L_0x0028:
            r0 = 771(0x303, float:1.08E-42)
            goto L_0x002f
        L_0x002b:
            r0 = 770(0x302, float:1.079E-42)
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            int r8 = r9.f260q
            int r8 = r8 >> 12
            r8 = r8 & 15
            if (r8 == 0) goto L_0x003d
            if (r8 == r5) goto L_0x0042
            if (r8 == r3) goto L_0x003f
            if (r8 == r7) goto L_0x0043
        L_0x003d:
            r1 = 0
            goto L_0x0043
        L_0x003f:
            r1 = 770(0x302, float:1.079E-42)
            goto L_0x0043
        L_0x0042:
            r1 = 1
        L_0x0043:
            android.opengl.GLES20.glBlendFunc(r0, r1)
            android.opengl.GLES20.glEnable(r2)
            goto L_0x004d
        L_0x004a:
            android.opengl.GLES20.glDisable(r2)
        L_0x004d:
            com.adcolony.sdk.ak$a r0 = r9.f264u
            r1 = 3553(0xde1, float:4.979E-42)
            if (r0 == 0) goto L_0x00e0
            android.opengl.GLES20.glEnable(r1)
            r0 = 33984(0x84c0, float:4.7622E-41)
            android.opengl.GLES20.glActiveTexture(r0)
            com.adcolony.sdk.ak$a r0 = r9.f264u
            int r0 = r0.f270a
            android.opengl.GLES20.glBindTexture(r1, r0)
            int r0 = r9.f260q
            r0 = r0 & 12
            r2 = 10243(0x2803, float:1.4354E-41)
            r6 = 10242(0x2802, float:1.4352E-41)
            if (r0 == 0) goto L_0x0077
            r0 = 1176765440(0x46240400, float:10497.0)
            android.opengl.GLES20.glTexParameterf(r1, r6, r0)
            android.opengl.GLES20.glTexParameterf(r1, r2, r0)
            goto L_0x0080
        L_0x0077:
            r0 = 1191259904(0x47012f00, float:33071.0)
            android.opengl.GLES20.glTexParameterf(r1, r6, r0)
            android.opengl.GLES20.glTexParameterf(r1, r2, r0)
        L_0x0080:
            int r0 = r9.f260q
            r0 = r0 & 16
            r2 = 10241(0x2801, float:1.435E-41)
            if (r0 == 0) goto L_0x0095
            r0 = 1175977984(0x46180000, float:9728.0)
            android.opengl.GLES20.glTexParameterf(r1, r2, r0)
            r0 = 10240(0x2800, float:1.4349E-41)
            r2 = 1175977984(0x46180000, float:9728.0)
            android.opengl.GLES20.glTexParameterf(r1, r0, r2)
            goto L_0x00a3
        L_0x0095:
            r0 = 1175979008(0x46180400, float:9729.0)
            android.opengl.GLES20.glTexParameterf(r1, r2, r0)
            r0 = 10240(0x2800, float:1.4349E-41)
            r2 = 1175979008(0x46180400, float:9729.0)
            android.opengl.GLES20.glTexParameterf(r1, r0, r2)
        L_0x00a3:
            int r0 = r9.f260q
            r1 = 16711680(0xff0000, float:2.3418052E-38)
            r0 = r0 & r1
            r1 = 65536(0x10000, float:9.18355E-41)
            if (r0 == r1) goto L_0x00da
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r0 == r1) goto L_0x00d4
            r1 = 196608(0x30000, float:2.75506E-40)
            if (r0 == r1) goto L_0x00ba
            com.adcolony.sdk.am r0 = r9.f250B
            r0.mo8303a()
            goto L_0x00e8
        L_0x00ba:
            boolean r0 = r9.f262s
            if (r0 == 0) goto L_0x00c4
            com.adcolony.sdk.am r0 = r9.f253E
            r0.mo8303a()
            goto L_0x00e8
        L_0x00c4:
            boolean r0 = r9.f263t
            if (r0 == 0) goto L_0x00ce
            com.adcolony.sdk.am r0 = r9.f250B
            r0.mo8303a()
            goto L_0x00e8
        L_0x00ce:
            com.adcolony.sdk.am r0 = r9.f254F
            r0.mo8303a()
            goto L_0x00e8
        L_0x00d4:
            com.adcolony.sdk.am r0 = r9.f252D
            r0.mo8303a()
            goto L_0x00e8
        L_0x00da:
            com.adcolony.sdk.am r0 = r9.f251C
            r0.mo8303a()
            goto L_0x00e8
        L_0x00e0:
            android.opengl.GLES20.glDisable(r1)
            com.adcolony.sdk.am r0 = r9.f249A
            r0.mo8303a()
        L_0x00e8:
            int r0 = r9.f261r
            if (r0 == r5) goto L_0x00f6
            if (r0 == r3) goto L_0x00ef
            goto L_0x0100
        L_0x00ef:
            r0 = 4
            int r1 = r9.f265v
            android.opengl.GLES20.glDrawArrays(r0, r4, r1)
            goto L_0x0100
        L_0x00f6:
            com.adcolony.sdk.am r0 = r9.f249A
            r0.mo8303a()
            int r0 = r9.f265v
            android.opengl.GLES20.glDrawArrays(r5, r4, r0)
        L_0x0100:
            r9.f265v = r4
            java.nio.FloatBuffer r0 = r9.f266w
            r0.rewind()
            java.nio.FloatBuffer r0 = r9.f267x
            r0.rewind()
            java.nio.IntBuffer r0 = r9.f268y
            r0.rewind()
            r9.f262s = r5
            r9.f263t = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0496ak.mo8286d():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0497a mo8273a(String str) {
        mo8286d();
        Options options = f247j;
        options.inScaled = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile == null) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to load ");
            sb.append(str);
            printStream.println(sb.toString());
            decodeFile = Bitmap.createBitmap(16, 16, Config.ARGB_8888);
        }
        return mo8271a(decodeFile);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0497a mo8272a(InputStream inputStream) {
        mo8286d();
        Options options = f247j;
        options.inScaled = false;
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        if (decodeStream == null) {
            Log.w("ADC3", "Failed to decode input stream.");
            decodeStream = Bitmap.createBitmap(16, 16, Config.ARGB_8888);
        }
        return mo8271a(decodeStream);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8287e() {
        System.out.println("ADCRenderer on_surface_created()");
        this.f249A = new C0501a(this);
        this.f250B = new C0502b(this);
        this.f251C = new C0504d(this);
        this.f252D = new C0503c(this);
        this.f253E = new C0505e(this);
        this.f254F = new C0506f(this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8276a(int i, int i2) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("ADCRenderer on_surface_changed ");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        printStream.println(sb.toString());
        this.f255l = i;
        this.f256m = i2;
        this.f257n = i;
        this.f258o = i2;
        GLES20.glViewport(0, 0, i, i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8279a(int i, int i2, int i3, int i4) {
        mo8286d();
        double d = (double) this.f255l;
        double d2 = (double) this.f257n;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        int i5 = this.f256m;
        double d4 = (double) i5;
        double d5 = (double) this.f258o;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        double d7 = (double) i3;
        Double.isNaN(d7);
        int i6 = (int) (d7 * d3);
        double d8 = (double) i4;
        Double.isNaN(d8);
        int i7 = (int) (d8 * d6);
        double d9 = (double) i;
        Double.isNaN(d9);
        int i8 = (int) (d9 * d3);
        double d10 = (double) i2;
        Double.isNaN(d10);
        GLES20.glScissor(i8, i5 - (((int) (d10 * d6)) + i7), i6, i7);
        GLES20.glEnable(3089);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo8288f() {
        if (this.f261r != 1) {
            mo8286d();
            this.f261r = 1;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8277a(int i, int i2, double d) {
        this.f257n = i;
        this.f258o = i2;
        C0542as asVar = this.f269z;
        asVar.mo8362a(asVar.f393d.mo8749a(i, i2, d));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8282b(int i) {
        if (i != this.f260q) {
            mo8286d();
            this.f260q = i;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8283b(int i, int i2, int i3, int i4) {
        mo8282b(i | 2 | (i2 << 8) | (i3 << 12) | (i4 << 16));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8284b(C0497a aVar) {
        if (aVar != this.f264u) {
            mo8286d();
            this.f264u = aVar;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo8289g() {
        if (this.f261r != 2) {
            mo8286d();
            this.f261r = 2;
        }
    }
}
