package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera.Area;

public class Camera2Wrapper implements C3339c {

    /* renamed from: a */
    private Context f7790a;

    /* renamed from: b */
    private C3330a f7791b = null;

    /* renamed from: c */
    private final int f7792c = 100;

    public Camera2Wrapper(Context context) {
        this.f7790a = context;
        initCamera2Jni();
    }

    /* renamed from: a */
    private static int m7573a(float f) {
        return (int) Math.min(Math.max((f * 2000.0f) - 0.0040893555f, -900.0f), 900.0f);
    }

    private final native void deinitCamera2Jni();

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    /* renamed from: a */
    public final void mo30540a() {
        deinitCamera2Jni();
        closeCamera2();
    }

    /* renamed from: a */
    public final void mo30541a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    /* renamed from: a */
    public final void mo30542a(Object obj, Object obj2, Object obj3, int i, int i2, int i3) {
        nativeFrameReady(obj, obj2, obj3, i, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void closeCamera2() {
        C3330a aVar = this.f7791b;
        if (aVar != null) {
            aVar.mo30697b();
        }
        this.f7791b = null;
    }

    /* access modifiers changed from: protected */
    public int getCamera2Count() {
        if (C3345i.f8004b) {
            return C3330a.m7690a(this.f7790a);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int[] getCamera2Resolutions(int i) {
        if (C3345i.f8004b) {
            return C3330a.m7712d(this.f7790a, i);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getCamera2SensorOrientation(int i) {
        if (C3345i.f8004b) {
            return C3330a.m7691a(this.f7790a, i);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public Object getCameraFocusArea(float f, float f2) {
        int a = m7573a(f);
        int a2 = m7573a(1.0f - f2);
        return new Area(new Rect(a - 100, a2 - 100, a + 100, a2 + 100), 1000);
    }

    /* access modifiers changed from: protected */
    public Rect getFrameSizeCamera2() {
        C3330a aVar = this.f7791b;
        return aVar != null ? aVar.mo30694a() : new Rect();
    }

    /* access modifiers changed from: protected */
    public boolean initializeCamera2(int i, int i2, int i3, int i4, int i5) {
        if (!C3345i.f8004b || this.f7791b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        this.f7791b = new C3330a(this);
        return this.f7791b.mo30696a(this.f7790a, i, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public boolean isCamera2AutoFocusPointSupported(int i) {
        if (C3345i.f8004b) {
            return C3330a.m7709c(this.f7790a, i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isCamera2FrontFacing(int i) {
        if (C3345i.f8004b) {
            return C3330a.m7707b(this.f7790a, i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void pauseCamera2() {
        C3330a aVar = this.f7791b;
        if (aVar != null) {
            aVar.mo30699d();
        }
    }

    /* access modifiers changed from: protected */
    public boolean setAutoFocusPoint(float f, float f2) {
        if (C3345i.f8004b) {
            C3330a aVar = this.f7791b;
            if (aVar != null) {
                return aVar.mo30695a(f, f2);
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void startCamera2() {
        C3330a aVar = this.f7791b;
        if (aVar != null) {
            aVar.mo30698c();
        }
    }

    /* access modifiers changed from: protected */
    public void stopCamera2() {
        C3330a aVar = this.f7791b;
        if (aVar != null) {
            aVar.mo30700e();
        }
    }
}
