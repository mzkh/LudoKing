package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import com.google.android.gms.drive.DriveFile;
import com.unity3d.player.GoogleVrVideo.GoogleVrVideoCallbacks;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

class GoogleVrProxy extends C3337b implements GoogleVrVideo {

    /* renamed from: f */
    private boolean f7794f = false;

    /* renamed from: g */
    private boolean f7795g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Runnable f7796h = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Vector f7797i = new Vector();

    /* renamed from: j */
    private SurfaceView f7798j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C3291a f7799k = new C3291a();

    /* renamed from: l */
    private Thread f7800l = null;

    /* renamed from: m */
    private Handler f7801m = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message.what != 135711) {
                super.handleMessage(message);
                return;
            }
            switch (message.arg1) {
                case 2147483645:
                    Iterator it = GoogleVrProxy.this.f7797i.iterator();
                    while (it.hasNext()) {
                        ((GoogleVrVideoCallbacks) it.next()).onFrameAvailable();
                    }
                    return;
                case 2147483646:
                    Surface surface = (Surface) message.obj;
                    Iterator it2 = GoogleVrProxy.this.f7797i.iterator();
                    while (it2.hasNext()) {
                        ((GoogleVrVideoCallbacks) it2.next()).onSurfaceAvailable(surface);
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    /* renamed from: com.unity3d.player.GoogleVrProxy$a */
    class C3291a {

        /* renamed from: a */
        public boolean f7813a = false;

        /* renamed from: b */
        public boolean f7814b = false;

        /* renamed from: c */
        public boolean f7815c = false;

        /* renamed from: d */
        public boolean f7816d = false;

        /* renamed from: e */
        public boolean f7817e = true;

        /* renamed from: f */
        public boolean f7818f = false;

        C3291a() {
        }

        /* renamed from: a */
        public final boolean mo30578a() {
            return this.f7813a && this.f7814b;
        }

        /* renamed from: b */
        public final void mo30579b() {
            this.f7813a = false;
            this.f7814b = false;
            this.f7816d = false;
            this.f7817e = true;
            this.f7818f = false;
        }
    }

    public GoogleVrProxy(C3341e eVar) {
        super("Google VR", eVar);
        initVrJni();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7582a(boolean z) {
        this.f7799k.f7816d = z;
    }

    /* renamed from: a */
    private static boolean m7583a(int i) {
        return VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    private boolean m7584a(ClassLoader classLoader) {
        try {
            Class loadClass = classLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
            C3356n nVar = new C3356n(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            nVar.mo30751a("initialize", new Class[]{Activity.class, Context.class, SurfaceView.class, Boolean.TYPE, Handler.class});
            nVar.mo30751a("deinitialize", new Class[0]);
            nVar.mo30751a("load", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Runnable.class});
            nVar.mo30751a("enable", new Class[]{Boolean.TYPE});
            nVar.mo30751a("unload", new Class[0]);
            nVar.mo30751a("pause", new Class[0]);
            nVar.mo30751a("resume", new Class[0]);
            nVar.mo30751a("getGvrLayout", new Class[0]);
            nVar.mo30751a("getVideoSurfaceId", new Class[0]);
            nVar.mo30751a("getVideoSurface", new Class[0]);
            this.f7994a = nVar;
            return true;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Exception initializing GoogleVR from Unity library. ");
            sb.append(e.getLocalizedMessage());
            reportError(sb.toString());
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m7587d() {
        return this.f7799k.f7816d;
    }

    /* renamed from: e */
    private void m7589e() {
        Activity activity = (Activity) this.f7996c;
        if (this.f7795g && !this.f7799k.f7818f && activity != null) {
            this.f7799k.f7818f = true;
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            activity.startActivity(intent);
        }
    }

    private final native void initVrJni();

    private final native boolean isQuiting();

    private final native void setVrVideoTransform(float[][] fArr);

    /* renamed from: a */
    public final void mo30559a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) {
            this.f7795g = true;
        }
    }

    /* renamed from: a */
    public final boolean mo30560a() {
        return this.f7799k.f7813a;
    }

    /* renamed from: a */
    public final boolean mo30561a(Activity activity, Context context, SurfaceView surfaceView, Runnable runnable) {
        String str;
        boolean z;
        if (activity == null || context == null || surfaceView == null || runnable == null) {
            str = "Invalid parameters passed to Google VR initiialization.";
        } else {
            this.f7799k.mo30579b();
            this.f7996c = context;
            this.f7796h = runnable;
            if (!m7583a(19)) {
                str = "Google VR requires a device that supports an api version of 19 (KitKat) or better.";
            } else if (this.f7795g && !m7583a(24)) {
                str = "Daydream requires a device that supports an api version of 24 (Nougat) or better.";
            } else if (!m7584a(UnityPlayer.class.getClassLoader())) {
                return false;
            } else {
                try {
                    z = ((Boolean) this.f7994a.mo30750a("initialize", activity, context, surfaceView, Boolean.valueOf(this.f7795g), this.f7801m)).booleanValue();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("Exception while trying to intialize Unity Google VR Library. ");
                    sb.append(e.getLocalizedMessage());
                    reportError(sb.toString());
                    z = false;
                }
                if (!z) {
                    str = "Unable to initialize GoogleVR library.";
                } else {
                    this.f7798j = surfaceView;
                    this.f7799k.f7813a = true;
                    this.f7997d = "";
                    return true;
                }
            }
        }
        reportError(str);
        return false;
    }

    /* renamed from: b */
    public final void mo30562b() {
        resumeGvrLayout();
    }

    /* renamed from: c */
    public final void mo30563c() {
        SurfaceView surfaceView = this.f7798j;
        if (surfaceView != null) {
            surfaceView.getHolder().setSizeFromLayout();
        }
    }

    public void deregisterGoogleVrVideoListener(GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (this.f7797i.contains(googleVrVideoCallbacks)) {
            googleVrVideoCallbacks.onSurfaceUnavailable();
            this.f7797i.remove(googleVrVideoCallbacks);
        }
    }

    /* access modifiers changed from: protected */
    public Object getVideoSurface() {
        if (m7587d() && !this.f7799k.f7817e) {
            try {
                return this.f7994a.mo30750a("getVideoSurface", new Object[0]);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Exception caught while Getting GoogleVR Video Surface. ");
                sb.append(e.getLocalizedMessage());
                reportError(sb.toString());
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getVideoSurfaceId() {
        if (m7587d() && !this.f7799k.f7817e) {
            try {
                return ((Integer) this.f7994a.mo30750a("getVideoSurfaceId", new Object[0])).intValue();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Exception caught while getting Video Surface ID from GoogleVR. ");
                sb.append(e.getLocalizedMessage());
                reportError(sb.toString());
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public long loadGoogleVr(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!this.f7799k.f7813a) {
            return 0;
        }
        AtomicLong atomicLong = new AtomicLong(0);
        this.f7997d = (z || z2) ? "Daydream" : "Cardboard";
        final AtomicLong atomicLong2 = atomicLong;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final boolean z10 = z5;
        C32882 r0 = new Runnable() {
            public final void run() {
                try {
                    atomicLong2.set(((Long) GoogleVrProxy.this.f7994a.mo30750a("load", Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), Boolean.valueOf(z9), Boolean.valueOf(z10), GoogleVrProxy.this.f7796h)).longValue());
                    GoogleVrProxy.this.f7799k.f7814b = true;
                } catch (Exception e) {
                    GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                    StringBuilder sb = new StringBuilder("Exception caught while loading GoogleVR. ");
                    sb.append(e.getLocalizedMessage());
                    googleVrProxy.reportError(sb.toString());
                    atomicLong2.set(0);
                }
            }
        };
        if (!runOnUiThreadWithSync(r0) || atomicLong.longValue() == 0) {
            reportError("Google VR had a fatal issue while loading. VR will not be available.");
        }
        return atomicLong.longValue();
    }

    /* access modifiers changed from: protected */
    public void pauseGvrLayout() {
        if (this.f7799k.mo30578a() && !this.f7799k.f7817e) {
            if (m7587d()) {
                Iterator it = this.f7797i.iterator();
                while (it.hasNext()) {
                    ((GoogleVrVideoCallbacks) it.next()).onSurfaceUnavailable();
                }
            }
            if (this.f7994a != null) {
                this.f7994a.mo30750a("pause", new Object[0]);
            }
            this.f7799k.f7817e = true;
        }
    }

    public void registerGoogleVrVideoListener(GoogleVrVideoCallbacks googleVrVideoCallbacks) {
        if (!this.f7797i.contains(googleVrVideoCallbacks)) {
            this.f7797i.add(googleVrVideoCallbacks);
            Surface surface = (Surface) getVideoSurface();
            if (surface != null) {
                googleVrVideoCallbacks.onSurfaceAvailable(surface);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resumeGvrLayout() {
        if (this.f7799k.mo30578a() && this.f7799k.f7817e) {
            if (this.f7994a != null) {
                this.f7994a.mo30750a("resume", new Object[0]);
            }
            this.f7799k.f7817e = false;
        }
    }

    /* access modifiers changed from: protected */
    public void setGoogleVrModeEnabled(final boolean z) {
        if (!(!this.f7799k.mo30578a() || this.f7995b == null || this.f7996c == null)) {
            if (!z && isQuiting()) {
                m7589e();
            }
            runOnUiThread(new Runnable() {
                public final void run() {
                    if (z != GoogleVrProxy.this.m7587d()) {
                        try {
                            String str = "getGvrLayout";
                            String str2 = "enable";
                            if (z) {
                                if (!GoogleVrProxy.this.m7587d()) {
                                    if (GoogleVrProxy.this.f7994a == null || GoogleVrProxy.this.f7995b == null || GoogleVrProxy.this.f7995b.addViewToPlayer((View) GoogleVrProxy.this.f7994a.mo30750a(str, new Object[0]), true)) {
                                        if (GoogleVrProxy.this.f7994a != null) {
                                            GoogleVrProxy.this.f7994a.mo30750a(str2, Boolean.valueOf(true));
                                        }
                                        GoogleVrProxy.this.m7582a(true);
                                        return;
                                    }
                                    GoogleVrProxy.this.reportError("Unable to add Google VR to view hierarchy.");
                                    return;
                                }
                            }
                            if (!z && GoogleVrProxy.this.m7587d()) {
                                GoogleVrProxy.this.m7582a(false);
                                if (GoogleVrProxy.this.f7994a != null) {
                                    GoogleVrProxy.this.f7994a.mo30750a(str2, Boolean.valueOf(false));
                                }
                                if (!(GoogleVrProxy.this.f7994a == null || GoogleVrProxy.this.f7995b == null)) {
                                    GoogleVrProxy.this.f7995b.removeViewFromPlayer((View) GoogleVrProxy.this.f7994a.mo30750a(str, new Object[0]));
                                }
                            }
                        } catch (Exception e) {
                            GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                            StringBuilder sb = new StringBuilder("Exception enabling Google VR on UI Thread. ");
                            sb.append(e.getLocalizedMessage());
                            googleVrProxy.reportError(sb.toString());
                        }
                    }
                }
            });
        }
    }

    public void setVideoLocationTransform(float[] fArr) {
        float[][] fArr2 = (float[][]) Array.newInstance(float.class, new int[]{4, 4});
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                fArr2[i][i2] = fArr[(i * 4) + i2];
            }
        }
        setVrVideoTransform(fArr2);
    }

    /* access modifiers changed from: protected */
    public void unloadGoogleVr() {
        if (this.f7799k.f7816d) {
            setGoogleVrModeEnabled(false);
        }
        if (this.f7799k.f7815c) {
            this.f7799k.f7815c = false;
        }
        this.f7798j = null;
        runOnUiThread(new Runnable() {
            public final void run() {
                try {
                    if (GoogleVrProxy.this.f7994a != null) {
                        GoogleVrProxy.this.f7994a.mo30750a("unload", new Object[0]);
                        GoogleVrProxy.this.f7994a.mo30750a("deinitialize", new Object[0]);
                        GoogleVrProxy.this.f7994a = null;
                    }
                    GoogleVrProxy.this.f7799k.f7814b = false;
                } catch (Exception e) {
                    GoogleVrProxy googleVrProxy = GoogleVrProxy.this;
                    StringBuilder sb = new StringBuilder("Exception unloading Google VR on UI Thread. ");
                    sb.append(e.getLocalizedMessage());
                    googleVrProxy.reportError(sb.toString());
                }
            }
        });
    }
}
