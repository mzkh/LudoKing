package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzoo extends HandlerThread implements OnFrameAvailableListener, Callback {
    private Handler handler;
    private final int[] zzbhe = new int[1];
    private SurfaceTexture zzbhf;
    private Error zzbhg;
    private RuntimeException zzbhh;
    private zzom zzbhi;

    public zzoo() {
        super("dummySurface");
    }

    public final zzom zzl(boolean z) {
        boolean z2;
        start();
        this.handler = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.zzbhi == null && this.zzbhh == null && this.zzbhg == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzbhh;
        if (runtimeException == null) {
            Error error = this.zzbhg;
            if (error == null) {
                return this.zzbhi;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void release() {
        this.handler.sendEmptyMessage(3);
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.handler.sendEmptyMessage(2);
    }

    public final boolean handleMessage(Message message) {
        Message message2 = message;
        int i = message2.what;
        if (i == 1) {
            try {
                boolean z = message2.arg1 != 0;
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                zznr.checkState(eglGetDisplay != null, "eglGetDisplay failed");
                int[] iArr = new int[2];
                zznr.checkState(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                EGLConfig[] eGLConfigArr2 = eGLConfigArr;
                zznr.checkState(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr2[0] != null, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr2[0];
                EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
                zznr.checkState(eglCreateContext != null, "eglCreateContext failed");
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, z ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                zznr.checkState(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                zznr.checkState(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.zzbhe, 0);
                this.zzbhf = new SurfaceTexture(this.zzbhe[0]);
                this.zzbhf.setOnFrameAvailableListener(this);
                this.zzbhi = new zzom(this, this.zzbhf, z);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e);
                this.zzbhh = e;
                synchronized (this) {
                    notify();
                }
            } catch (Error e2) {
                try {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.zzbhg = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                        throw th;
                    }
                }
            }
            return true;
        } else if (i == 2) {
            this.zzbhf.updateTexImage();
            return true;
        } else if (i != 3) {
            return true;
        } else {
            try {
                this.zzbhf.release();
                this.zzbhi = null;
                this.zzbhf = null;
                GLES20.glDeleteTextures(1, this.zzbhe, 0);
                quit();
            } catch (Throwable th2) {
                try {
                    Log.e("DummySurface", "Failed to release dummy surface", th2);
                } finally {
                    quit();
                }
            }
            return true;
        }
    }
}
