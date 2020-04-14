package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzazh extends Thread implements OnFrameAvailableListener, zzazi {
    private static final float[] zzdzj = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzdzg;
    private final zzazg zzdzk;
    private final float[] zzdzl;
    private final float[] zzdzm;
    private final float[] zzdzn;
    private final float[] zzdzo;
    private final float[] zzdzp;
    private final float[] zzdzq;
    private float zzdzr;
    private float zzdzs;
    private float zzdzt;
    private SurfaceTexture zzdzu;
    private SurfaceTexture zzdzv;
    private int zzdzw;
    private int zzdzx;
    private int zzdzy;
    private FloatBuffer zzdzz = ByteBuffer.allocateDirect(zzdzj.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final CountDownLatch zzeaa;
    private final Object zzeab;
    private EGL10 zzeac;
    private EGLDisplay zzead;
    private EGLContext zzeae;
    private EGLSurface zzeaf;
    private volatile boolean zzeag;
    private volatile boolean zzeah;

    public zzazh(Context context) {
        super("SphericalVideoProcessor");
        this.zzdzz.put(zzdzj).position(0);
        this.zzdzg = new float[9];
        this.zzdzl = new float[9];
        this.zzdzm = new float[9];
        this.zzdzn = new float[9];
        this.zzdzo = new float[9];
        this.zzdzp = new float[9];
        this.zzdzq = new float[9];
        this.zzdzr = Float.NaN;
        this.zzdzk = new zzazg(context);
        this.zzdzk.zza((zzazi) this);
        this.zzeaa = new CountDownLatch(1);
        this.zzeab = new Object();
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.zzdzv = surfaceTexture;
    }

    public final void zzl(int i, int i2) {
        synchronized (this.zzeab) {
            this.width = i;
            this.height = i2;
            this.zzeag = true;
            this.zzeab.notifyAll();
        }
    }

    public final void zzxh() {
        synchronized (this.zzeab) {
            this.zzeah = true;
            this.zzdzv = null;
            this.zzeab.notifyAll();
        }
    }

    public final SurfaceTexture zzxi() {
        if (this.zzdzv == null) {
            return null;
        }
        try {
            this.zzeaa.await();
        } catch (InterruptedException unused) {
        }
        return this.zzdzu;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzdzy++;
        synchronized (this.zzeab) {
            this.zzeab.notifyAll();
        }
    }

    public final void zzst() {
        synchronized (this.zzeab) {
            this.zzeab.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x03b5  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01df A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            android.graphics.SurfaceTexture r0 = r14.zzdzv
            if (r0 != 0) goto L_0x000f
            java.lang.String r0 = "SphericalVideoProcessor started with no output texture."
            com.google.android.gms.internal.ads.zzaug.zzes(r0)
            java.util.concurrent.CountDownLatch r0 = r14.zzeaa
            r0.countDown()
            return
        L_0x000f:
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r14.zzeac = r0
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzeac
            java.lang.Object r1 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r0 = r0.eglGetDisplay(r1)
            r14.zzead = r0
            javax.microedition.khronos.egl.EGLDisplay r0 = r14.zzead
            javax.microedition.khronos.egl.EGLDisplay r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r0 != r1) goto L_0x002f
        L_0x002c:
            r0 = 0
            goto L_0x009e
        L_0x002f:
            int[] r0 = new int[r3]
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzeac
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzead
            boolean r0 = r1.eglInitialize(r7, r0)
            if (r0 != 0) goto L_0x003c
            goto L_0x002c
        L_0x003c:
            int[] r0 = new int[r5]
            javax.microedition.khronos.egl.EGLConfig[] r1 = new javax.microedition.khronos.egl.EGLConfig[r5]
            r7 = 11
            int[] r9 = new int[r7]
            r9 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzeac
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzead
            r11 = 1
            r10 = r1
            r12 = r0
            boolean r7 = r7.eglChooseConfig(r8, r9, r10, r11, r12)
            if (r7 == 0) goto L_0x005b
            r0 = r0[r6]
            if (r0 <= 0) goto L_0x005b
            r0 = r1[r6]
            goto L_0x005c
        L_0x005b:
            r0 = r4
        L_0x005c:
            if (r0 != 0) goto L_0x005f
            goto L_0x002c
        L_0x005f:
            int[] r1 = new int[r2]
            r1 = {12440, 2, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzeac
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzead
            javax.microedition.khronos.egl.EGLContext r9 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r1 = r7.eglCreateContext(r8, r0, r9, r1)
            r14.zzeae = r1
            javax.microedition.khronos.egl.EGLContext r1 = r14.zzeae
            if (r1 == 0) goto L_0x002c
            javax.microedition.khronos.egl.EGLContext r7 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r1 != r7) goto L_0x0079
            goto L_0x002c
        L_0x0079:
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzeac
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzead
            android.graphics.SurfaceTexture r8 = r14.zzdzv
            javax.microedition.khronos.egl.EGLSurface r0 = r1.eglCreateWindowSurface(r7, r0, r8, r4)
            r14.zzeaf = r0
            javax.microedition.khronos.egl.EGLSurface r0 = r14.zzeaf
            if (r0 == 0) goto L_0x002c
            javax.microedition.khronos.egl.EGLSurface r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r1) goto L_0x008e
            goto L_0x002c
        L_0x008e:
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzeac
            javax.microedition.khronos.egl.EGLDisplay r1 = r14.zzead
            javax.microedition.khronos.egl.EGLSurface r7 = r14.zzeaf
            javax.microedition.khronos.egl.EGLContext r8 = r14.zzeae
            boolean r0 = r0.eglMakeCurrent(r1, r7, r7, r8)
            if (r0 != 0) goto L_0x009d
            goto L_0x002c
        L_0x009d:
            r0 = 1
        L_0x009e:
            r1 = 35633(0x8b31, float:4.9932E-41)
            com.google.android.gms.internal.ads.zzyp<java.lang.String> r7 = com.google.android.gms.internal.ads.zzza.zzclt
            com.google.android.gms.internal.ads.zzyw r8 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r8 = r8.zzd(r7)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r7.zzpq()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzyw r8 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r7 = r8.zzd(r7)
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00c4
        L_0x00c2:
            java.lang.String r7 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}"
        L_0x00c4:
            int r1 = zzd(r1, r7)
            if (r1 != 0) goto L_0x00cd
        L_0x00ca:
            r8 = 0
            goto L_0x014f
        L_0x00cd:
            r7 = 35632(0x8b30, float:4.9931E-41)
            com.google.android.gms.internal.ads.zzyp<java.lang.String> r8 = com.google.android.gms.internal.ads.zzza.zzclu
            com.google.android.gms.internal.ads.zzyw r9 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r9 = r9.zzd(r8)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r8.zzpq()
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzyw r9 = com.google.android.gms.internal.ads.zzuv.zzon()
            java.lang.Object r8 = r9.zzd(r8)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00f3
        L_0x00f1:
            java.lang.String r8 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}"
        L_0x00f3:
            int r7 = zzd(r7, r8)
            if (r7 != 0) goto L_0x00fa
            goto L_0x00ca
        L_0x00fa:
            int r8 = android.opengl.GLES20.glCreateProgram()
            java.lang.String r9 = "createProgram"
            zzey(r9)
            if (r8 == 0) goto L_0x014f
            android.opengl.GLES20.glAttachShader(r8, r1)
            java.lang.String r1 = "attachShader"
            zzey(r1)
            android.opengl.GLES20.glAttachShader(r8, r7)
            java.lang.String r1 = "attachShader"
            zzey(r1)
            android.opengl.GLES20.glLinkProgram(r8)
            java.lang.String r1 = "linkProgram"
            zzey(r1)
            int[] r1 = new int[r5]
            r7 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r8, r7, r1, r6)
            java.lang.String r7 = "getProgramiv"
            zzey(r7)
            r1 = r1[r6]
            if (r1 == r5) goto L_0x0147
            java.lang.String r1 = "SphericalVideoRenderer"
            java.lang.String r7 = "Could not link program: "
            android.util.Log.e(r1, r7)
            java.lang.String r1 = android.opengl.GLES20.glGetProgramInfoLog(r8)
            java.lang.String r7 = "SphericalVideoRenderer"
            android.util.Log.e(r7, r1)
            android.opengl.GLES20.glDeleteProgram(r8)
            java.lang.String r1 = "deleteProgram"
            zzey(r1)
            goto L_0x00ca
        L_0x0147:
            android.opengl.GLES20.glValidateProgram(r8)
            java.lang.String r1 = "validateProgram"
            zzey(r1)
        L_0x014f:
            r14.zzdzw = r8
            int r1 = r14.zzdzw
            android.opengl.GLES20.glUseProgram(r1)
            java.lang.String r1 = "useProgram"
            zzey(r1)
            int r1 = r14.zzdzw
            java.lang.String r7 = "aPosition"
            int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r7)
            r9 = 3
            r10 = 5126(0x1406, float:7.183E-42)
            r11 = 0
            r12 = 12
            java.nio.FloatBuffer r13 = r14.zzdzz
            r8 = r1
            android.opengl.GLES20.glVertexAttribPointer(r8, r9, r10, r11, r12, r13)
            java.lang.String r7 = "vertexAttribPointer"
            zzey(r7)
            android.opengl.GLES20.glEnableVertexAttribArray(r1)
            java.lang.String r1 = "enableVertexAttribArray"
            zzey(r1)
            int[] r1 = new int[r5]
            android.opengl.GLES20.glGenTextures(r5, r1, r6)
            java.lang.String r7 = "genTextures"
            zzey(r7)
            r1 = r1[r6]
            r7 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r7, r1)
            java.lang.String r8 = "bindTextures"
            zzey(r8)
            r8 = 10240(0x2800, float:1.4349E-41)
            r9 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzey(r8)
            r8 = 10241(0x2801, float:1.435E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzey(r8)
            r8 = 10242(0x2802, float:1.4352E-41)
            r9 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzey(r8)
            r8 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r7 = "texParameteri"
            zzey(r7)
            int r7 = r14.zzdzw
            java.lang.String r8 = "uVMat"
            int r7 = android.opengl.GLES20.glGetUniformLocation(r7, r8)
            r14.zzdzx = r7
            r7 = 9
            float[] r7 = new float[r7]
            r7 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216} // fill-array
            int r8 = r14.zzdzx
            android.opengl.GLES20.glUniformMatrix3fv(r8, r5, r6, r7, r6)
            int r7 = r14.zzdzw
            if (r7 == 0) goto L_0x01dc
            r7 = 1
            goto L_0x01dd
        L_0x01dc:
            r7 = 0
        L_0x01dd:
            if (r0 == 0) goto L_0x039f
            if (r7 != 0) goto L_0x01e3
            goto L_0x039f
        L_0x01e3:
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            r0.<init>(r1)
            r14.zzdzu = r0
            android.graphics.SurfaceTexture r0 = r14.zzdzu
            r0.setOnFrameAvailableListener(r14)
            java.util.concurrent.CountDownLatch r0 = r14.zzeaa
            r0.countDown()
            com.google.android.gms.internal.ads.zzazg r0 = r14.zzdzk
            r0.start()
            r14.zzeag = r5     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        L_0x01fb:
            boolean r0 = r14.zzeah     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            if (r0 != 0) goto L_0x0349
        L_0x01ff:
            int r0 = r14.zzdzy     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            if (r0 <= 0) goto L_0x020e
            android.graphics.SurfaceTexture r0 = r14.zzdzu     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r0.updateTexImage()     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r0 = r14.zzdzy     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r0 = r0 - r5
            r14.zzdzy = r0     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            goto L_0x01ff
        L_0x020e:
            com.google.android.gms.internal.ads.zzazg r0 = r14.zzdzk     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r1 = r14.zzdzg     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            boolean r0 = r0.zza(r1)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r1 = 5
            r7 = 4
            r8 = 1070141403(0x3fc90fdb, float:1.5707964)
            if (r0 == 0) goto L_0x0294
            float r0 = r14.zzdzr     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            boolean r0 = java.lang.Float.isNaN(r0)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            if (r0 == 0) goto L_0x0289
            float[] r0 = r14.zzdzg     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r9 = new float[r2]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r10 = 0
            r9[r6] = r10     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r11 = 1065353216(0x3f800000, float:1.0)
            r9[r5] = r11     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r9[r3] = r10     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r10 = new float[r2]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r11 = r0[r6]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r11 = r11 * r12
            r12 = r0[r5]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = r0[r3]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r13 = r9[r3]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r10[r6] = r11     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r11 = r0[r2]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r11 = r11 * r12
            r12 = r0[r7]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = r0[r1]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r13 = r9[r3]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r10[r5] = r11     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r11 = 6
            r11 = r0[r11]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r12 = r9[r6]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r11 = r11 * r12
            r12 = 7
            r12 = r0[r12]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r13 = r9[r5]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r12 = r12 * r13
            float r11 = r11 + r12
            r12 = 8
            r0 = r0[r12]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r9 = r9[r3]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r0 = r0 * r9
            float r11 = r11 + r0
            r10[r3] = r11     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r0 = r10[r5]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            double r11 = (double) r0     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r0 = r10[r6]     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            double r9 = (double) r0     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            double r9 = java.lang.Math.atan2(r11, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r0 = (float) r9     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r0 = r0 - r8
            float r0 = -r0
            r14.zzdzr = r0     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        L_0x0289:
            float[] r0 = r14.zzdzp     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r9 = r14.zzdzr     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r10 = r14.zzdzs     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r9 = r9 + r10
            zzb(r0, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            goto L_0x02a3
        L_0x0294:
            float[] r0 = r14.zzdzg     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r9 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            zza(r0, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r0 = r14.zzdzp     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r9 = r14.zzdzs     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            zzb(r0, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        L_0x02a3:
            float[] r0 = r14.zzdzl     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            zza(r0, r8)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r0 = r14.zzdzm     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r8 = r14.zzdzp     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r9 = r14.zzdzl     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            zza(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r0 = r14.zzdzn     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r8 = r14.zzdzg     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r9 = r14.zzdzm     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            zza(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r0 = r14.zzdzo     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r8 = r14.zzdzt     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            zza(r0, r8)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r0 = r14.zzdzq     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r8 = r14.zzdzo     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r9 = r14.zzdzn     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            zza(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r0 = r14.zzdzx     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float[] r8 = r14.zzdzq     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            android.opengl.GLES20.glUniformMatrix3fv(r0, r5, r6, r8, r6)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            android.opengl.GLES20.glDrawArrays(r1, r6, r7)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            java.lang.String r0 = "drawArrays"
            zzey(r0)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            android.opengl.GLES20.glFinish()     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzeac     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            javax.microedition.khronos.egl.EGLDisplay r1 = r14.zzead     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            javax.microedition.khronos.egl.EGLSurface r7 = r14.zzeaf     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r0.eglSwapBuffers(r1, r7)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            boolean r0 = r14.zzeag     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            if (r0 == 0) goto L_0x032f
            int r0 = r14.width     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r1 = r14.height     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            android.opengl.GLES20.glViewport(r6, r6, r0, r1)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            java.lang.String r0 = "viewport"
            zzey(r0)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r0 = r14.zzdzw     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            java.lang.String r1 = "uFOVx"
            int r0 = android.opengl.GLES20.glGetUniformLocation(r0, r1)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r1 = r14.zzdzw     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            java.lang.String r7 = "uFOVy"
            int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r7)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r8 = r14.height     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            r9 = 1063216883(0x3f5f66f3, float:0.87266463)
            if (r7 <= r8) goto L_0x031e
            android.opengl.GLES20.glUniform1f(r0, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            int r0 = r14.height     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r0 = (float) r0     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r0 = r0 * r9
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r0 = r0 / r7
            android.opengl.GLES20.glUniform1f(r1, r0)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            goto L_0x032d
        L_0x031e:
            int r7 = r14.width     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r7 = r7 * r9
            int r8 = r14.height     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            float r7 = r7 / r8
            android.opengl.GLES20.glUniform1f(r0, r7)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
            android.opengl.GLES20.glUniform1f(r1, r9)     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        L_0x032d:
            r14.zzeag = r6     // Catch:{ IllegalStateException -> 0x037a, Throwable -> 0x035b }
        L_0x032f:
            java.lang.Object r0 = r14.zzeab     // Catch:{ InterruptedException -> 0x01fb }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x01fb }
            boolean r1 = r14.zzeah     // Catch:{ all -> 0x0346 }
            if (r1 != 0) goto L_0x0343
            boolean r1 = r14.zzeag     // Catch:{ all -> 0x0346 }
            if (r1 != 0) goto L_0x0343
            int r1 = r14.zzdzy     // Catch:{ all -> 0x0346 }
            if (r1 != 0) goto L_0x0343
            java.lang.Object r1 = r14.zzeab     // Catch:{ all -> 0x0346 }
            r1.wait()     // Catch:{ all -> 0x0346 }
        L_0x0343:
            monitor-exit(r0)     // Catch:{ all -> 0x0346 }
            goto L_0x01fb
        L_0x0346:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0346 }
            throw r1     // Catch:{ InterruptedException -> 0x01fb }
        L_0x0349:
            com.google.android.gms.internal.ads.zzazg r0 = r14.zzdzk
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzdzu
            r0.setOnFrameAvailableListener(r4)
            r14.zzdzu = r4
            r14.zzxj()
            return
        L_0x0359:
            r0 = move-exception
            goto L_0x038f
        L_0x035b:
            r0 = move-exception
            java.lang.String r1 = "SphericalVideoProcessor died."
            com.google.android.gms.internal.ads.zzaug.zzc(r1, r0)     // Catch:{ all -> 0x0359 }
            com.google.android.gms.internal.ads.zzatr r1 = com.google.android.gms.ads.internal.zzq.zzkn()     // Catch:{ all -> 0x0359 }
            java.lang.String r2 = "SphericalVideoProcessor.run.2"
            r1.zza(r0, r2)     // Catch:{ all -> 0x0359 }
            com.google.android.gms.internal.ads.zzazg r0 = r14.zzdzk
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzdzu
            r0.setOnFrameAvailableListener(r4)
            r14.zzdzu = r4
            r14.zzxj()
            return
        L_0x037a:
            java.lang.String r0 = "SphericalVideoProcessor halted unexpectedly."
            com.google.android.gms.internal.ads.zzaug.zzeu(r0)     // Catch:{ all -> 0x0359 }
            com.google.android.gms.internal.ads.zzazg r0 = r14.zzdzk
            r0.stop()
            android.graphics.SurfaceTexture r0 = r14.zzdzu
            r0.setOnFrameAvailableListener(r4)
            r14.zzdzu = r4
            r14.zzxj()
            return
        L_0x038f:
            com.google.android.gms.internal.ads.zzazg r1 = r14.zzdzk
            r1.stop()
            android.graphics.SurfaceTexture r1 = r14.zzdzu
            r1.setOnFrameAvailableListener(r4)
            r14.zzdzu = r4
            r14.zzxj()
            throw r0
        L_0x039f:
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzeac
            int r0 = r0.eglGetError()
            java.lang.String r0 = android.opengl.GLUtils.getEGLErrorString(r0)
            java.lang.String r1 = "EGL initialization failed: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x03ba
            java.lang.String r0 = r1.concat(r0)
            goto L_0x03bf
        L_0x03ba:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x03bf:
            com.google.android.gms.internal.ads.zzaug.zzes(r0)
            com.google.android.gms.internal.ads.zzatr r1 = com.google.android.gms.ads.internal.zzq.zzkn()
            java.lang.Throwable r2 = new java.lang.Throwable
            r2.<init>(r0)
            java.lang.String r0 = "SphericalVideoProcessor.run.1"
            r1.zza(r2, r0)
            r14.zzxj()
            java.util.concurrent.CountDownLatch r0 = r14.zzeaa
            r0.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazh.run():void");
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        float f5;
        int i = this.width;
        int i2 = this.height;
        if (i > i2) {
            f4 = (f * 1.7453293f) / ((float) i);
            f3 = f2 * 1.7453293f;
            f5 = (float) i;
        } else {
            f4 = (f * 1.7453293f) / ((float) i2);
            f3 = f2 * 1.7453293f;
            f5 = (float) i2;
        }
        float f6 = f3 / f5;
        this.zzdzs -= f4;
        this.zzdzt -= f6;
        if (this.zzdzt < -1.5707964f) {
            this.zzdzt = -1.5707964f;
        }
        if (this.zzdzt > 1.5707964f) {
            this.zzdzt = 1.5707964f;
        }
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static void zzb(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static int zzd(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzey("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        zzey("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        zzey("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        zzey("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        String str2 = "SphericalVideoRenderer";
        Log.e(str2, sb.toString());
        Log.e(str2, GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        zzey("deleteShader");
        return 0;
    }

    @VisibleForTesting
    private final boolean zzxj() {
        EGLSurface eGLSurface = this.zzeaf;
        boolean z = false;
        if (!(eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE)) {
            z = this.zzeac.eglDestroySurface(this.zzead, this.zzeaf) | this.zzeac.eglMakeCurrent(this.zzead, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false;
            this.zzeaf = null;
        }
        EGLContext eGLContext = this.zzeae;
        if (eGLContext != null) {
            z |= this.zzeac.eglDestroyContext(this.zzead, eGLContext);
            this.zzeae = null;
        }
        EGLDisplay eGLDisplay = this.zzead;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.zzeac.eglTerminate(eGLDisplay);
        this.zzead = null;
        return eglTerminate;
    }

    private static void zzey(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }
}
