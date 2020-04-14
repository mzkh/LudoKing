package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.unity3d.player.C3361p.C3368a;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UnityPlayer extends FrameLayout implements C3341e {
    public static Activity currentActivity;

    /* renamed from: a */
    C3327e f7850a = new C3327e(this, 0);

    /* renamed from: b */
    C3346j f7851b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f7852c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f7853d = false;

    /* renamed from: e */
    private boolean f7854e = true;

    /* renamed from: f */
    private C3355m f7855f = new C3355m();

    /* renamed from: g */
    private final ConcurrentLinkedQueue f7856g = new ConcurrentLinkedQueue();

    /* renamed from: h */
    private BroadcastReceiver f7857h = null;

    /* renamed from: i */
    private boolean f7858i = false;

    /* renamed from: j */
    private C3325c f7859j = new C3325c(this, 0);

    /* renamed from: k */
    private TelephonyManager f7860k;

    /* renamed from: l */
    private ClipboardManager f7861l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C3351k f7862m;

    /* renamed from: n */
    private GoogleARCoreApi f7863n = null;

    /* renamed from: o */
    private C3323a f7864o = new C3323a();

    /* renamed from: p */
    private Camera2Wrapper f7865p = null;

    /* renamed from: q */
    private HFPStatus f7866q = null;

    /* renamed from: r */
    private Uri f7867r = null;

    /* renamed from: s */
    private NetworkConnectivity f7868s = null;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Context f7869t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public SurfaceView f7870u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f7871v;

    /* renamed from: w */
    private boolean f7872w = true;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public C3361p f7873x;

    /* renamed from: com.unity3d.player.UnityPlayer$a */
    class C3323a implements SensorEventListener {
        C3323a() {
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$b */
    enum C3324b {
        ;

        static {
            f7934d = new int[]{f7931a, f7932b, f7933c};
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$c */
    private class C3325c extends PhoneStateListener {
        private C3325c() {
        }

        /* synthetic */ C3325c(UnityPlayer unityPlayer, byte b) {
            this();
        }

        public final void onCallStateChanged(int i, String str) {
            UnityPlayer unityPlayer = UnityPlayer.this;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            unityPlayer.nativeMuteMasterAudio(z);
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$d */
    enum C3326d {
        PAUSE,
        RESUME,
        QUIT,
        SURFACE_LOST,
        SURFACE_ACQUIRED,
        FOCUS_LOST,
        FOCUS_GAINED,
        NEXT_FRAME,
        URL_ACTIVATED
    }

    /* renamed from: com.unity3d.player.UnityPlayer$e */
    private class C3327e extends Thread {

        /* renamed from: a */
        Handler f7946a;

        /* renamed from: b */
        boolean f7947b;

        /* renamed from: c */
        boolean f7948c;

        /* renamed from: d */
        int f7949d;

        /* renamed from: e */
        int f7950e;

        /* renamed from: f */
        int f7951f;

        private C3327e() {
            this.f7947b = false;
            this.f7948c = false;
            this.f7949d = C3324b.f7932b;
            this.f7950e = 0;
            this.f7951f = 5;
        }

        /* synthetic */ C3327e(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        private void m7678a(C3326d dVar) {
            Handler handler = this.f7946a;
            if (handler != null) {
                Message.obtain(handler, 2269, dVar).sendToTarget();
            }
        }

        /* renamed from: a */
        public final void mo30676a() {
            m7678a(C3326d.QUIT);
        }

        /* renamed from: a */
        public final void mo30677a(Runnable runnable) {
            if (this.f7946a != null) {
                m7678a(C3326d.PAUSE);
                Message.obtain(this.f7946a, runnable).sendToTarget();
            }
        }

        /* renamed from: b */
        public final void mo30678b() {
            m7678a(C3326d.RESUME);
        }

        /* renamed from: b */
        public final void mo30679b(Runnable runnable) {
            if (this.f7946a != null) {
                m7678a(C3326d.SURFACE_LOST);
                Message.obtain(this.f7946a, runnable).sendToTarget();
            }
        }

        /* renamed from: c */
        public final void mo30680c() {
            m7678a(C3326d.FOCUS_GAINED);
        }

        /* renamed from: c */
        public final void mo30681c(Runnable runnable) {
            Handler handler = this.f7946a;
            if (handler != null) {
                Message.obtain(handler, runnable).sendToTarget();
                m7678a(C3326d.SURFACE_ACQUIRED);
            }
        }

        /* renamed from: d */
        public final void mo30682d() {
            m7678a(C3326d.FOCUS_LOST);
        }

        /* renamed from: d */
        public final void mo30683d(Runnable runnable) {
            Handler handler = this.f7946a;
            if (handler != null) {
                Message.obtain(handler, runnable).sendToTarget();
            }
        }

        /* renamed from: e */
        public final void mo30684e() {
            m7678a(C3326d.URL_ACTIVATED);
        }

        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.f7946a = new Handler(new Callback() {
                /* renamed from: a */
                private void m7688a() {
                    if (C3327e.this.f7949d == C3324b.f7933c && C3327e.this.f7948c) {
                        UnityPlayer.this.nativeFocusChanged(true);
                        C3327e.this.f7949d = C3324b.f7931a;
                    }
                }

                public final boolean handleMessage(Message message) {
                    if (message.what != 2269) {
                        return false;
                    }
                    C3326d dVar = (C3326d) message.obj;
                    if (dVar == C3326d.NEXT_FRAME) {
                        C3327e.this.f7950e--;
                        UnityPlayer.this.executeGLThreadJobs();
                        if (!C3327e.this.f7947b || !C3327e.this.f7948c) {
                            return true;
                        }
                        if (C3327e.this.f7951f >= 0) {
                            if (C3327e.this.f7951f == 0 && UnityPlayer.this.m7657k()) {
                                UnityPlayer.this.m7620a();
                            }
                            C3327e.this.f7951f--;
                        }
                        if (!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                            UnityPlayer.this.m7645e();
                        }
                    } else if (dVar == C3326d.QUIT) {
                        Looper.myLooper().quit();
                    } else if (dVar == C3326d.RESUME) {
                        C3327e.this.f7947b = true;
                    } else if (dVar == C3326d.PAUSE) {
                        C3327e.this.f7947b = false;
                    } else if (dVar == C3326d.SURFACE_LOST) {
                        C3327e.this.f7948c = false;
                    } else {
                        if (dVar == C3326d.SURFACE_ACQUIRED) {
                            C3327e.this.f7948c = true;
                        } else if (dVar == C3326d.FOCUS_LOST) {
                            if (C3327e.this.f7949d == C3324b.f7931a) {
                                UnityPlayer.this.nativeFocusChanged(false);
                            }
                            C3327e.this.f7949d = C3324b.f7932b;
                        } else if (dVar == C3326d.FOCUS_GAINED) {
                            C3327e.this.f7949d = C3324b.f7933c;
                        } else if (dVar == C3326d.URL_ACTIVATED) {
                            UnityPlayer.this.nativeSetLaunchURL(UnityPlayer.this.getLaunchURL());
                        }
                        m7688a();
                    }
                    if (C3327e.this.f7947b && C3327e.this.f7950e <= 0) {
                        Message.obtain(C3327e.this.f7946a, 2269, C3326d.NEXT_FRAME).sendToTarget();
                        C3327e.this.f7950e++;
                    }
                    return true;
                }
            });
            Looper.loop();
        }
    }

    /* renamed from: com.unity3d.player.UnityPlayer$f */
    private abstract class C3329f implements Runnable {
        private C3329f() {
        }

        /* synthetic */ C3329f(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        public abstract void mo30652a();

        public final void run() {
            if (!UnityPlayer.this.isFinishing()) {
                mo30652a();
            }
        }
    }

    static {
        new C3354l().mo30739a();
        try {
            System.loadLibrary("main");
        } catch (UnsatisfiedLinkError e) {
            C3342f.Log(6, "Failed to load 'libmain.so', the application will terminate.");
            throw e;
        }
    }

    public UnityPlayer(Context context) {
        super(context);
        if (context instanceof Activity) {
            currentActivity = (Activity) context;
            this.f7852c = currentActivity.getRequestedOrientation();
            this.f7867r = currentActivity.getIntent().getData();
        }
        m7622a(currentActivity);
        this.f7869t = context;
        if (currentActivity != null && m7657k()) {
            this.f7862m = new C3351k(this.f7869t, C3353a.m7750a()[getSplashMode()]);
            addView(this.f7862m);
        }
        m7623a(this.f7869t.getApplicationInfo());
        if (!C3355m.m7754c()) {
            AlertDialog create = new Builder(this.f7869t).setTitle("Failure to initialize!").setPositiveButton("OK", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.m7645e();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(context);
        this.f7855f.mo30743c(true);
        this.f7870u = m7639c();
        this.f7870u.setContentDescription(m7619a(context));
        addView(this.f7870u);
        bringChildToFront(this.f7862m);
        this.f7871v = false;
        m7660m();
        this.f7860k = (TelephonyManager) this.f7869t.getSystemService("phone");
        this.f7861l = (ClipboardManager) this.f7869t.getSystemService("clipboard");
        this.f7865p = new Camera2Wrapper(this.f7869t);
        this.f7866q = new HFPStatus(this.f7869t);
        this.f7850a.start();
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (!C3355m.m7754c()) {
            StringBuilder sb = new StringBuilder("Native libraries not loaded - dropping message for ");
            sb.append(str);
            sb.append(".");
            sb.append(str2);
            C3342f.Log(5, sb.toString());
            return;
        }
        try {
            nativeUnitySendMessage(str, str2, str3.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* renamed from: a */
    private static String m7619a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", "string", context.getPackageName()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7620a() {
        mo30598a((Runnable) new Runnable() {
            public final void run() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                unityPlayer.removeView(unityPlayer.f7862m);
                UnityPlayer.this.f7862m = null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7621a(int i, Surface surface) {
        if (!this.f7853d) {
            m7638b(0, surface);
        }
    }

    /* renamed from: a */
    private static void m7622a(Activity activity) {
        if (activity != null && activity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false) && activity.getWindow() != null) {
            View decorView = activity.getWindow().getDecorView();
            if (decorView != null) {
                decorView.setSystemUiVisibility(7);
            }
        }
    }

    /* renamed from: a */
    private static void m7623a(ApplicationInfo applicationInfo) {
        if (NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            C3355m.m7752a();
        } else {
            C3342f.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
        }
    }

    /* renamed from: a */
    private void m7624a(View view, View view2) {
        boolean z;
        if (!this.f7855f.mo30745d()) {
            pause();
            z = true;
        } else {
            z = false;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof UnityPlayer) || ((UnityPlayer) parent) != this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(0);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            removeView(view2);
        }
        if (z) {
            resume();
        }
    }

    /* renamed from: a */
    private void m7625a(C3329f fVar) {
        if (!isFinishing()) {
            m7636b((Runnable) fVar);
        }
    }

    /* renamed from: b */
    private void m7636b(Runnable runnable) {
        if (C3355m.m7754c()) {
            if (Thread.currentThread() == this.f7850a) {
                runnable.run();
            } else {
                this.f7856g.add(runnable);
            }
        }
    }

    /* renamed from: b */
    private static boolean m7637b() {
        if (currentActivity == null) {
            return false;
        }
        TypedValue typedValue = new TypedValue();
        return currentActivity.getTheme().resolveAttribute(16842840, typedValue, true) && typedValue.type == 18 && typedValue.data != 0;
    }

    /* renamed from: b */
    private boolean m7638b(final int i, final Surface surface) {
        if (!C3355m.m7754c() || !this.f7855f.mo30746e()) {
            return false;
        }
        final Semaphore semaphore = new Semaphore(0);
        C331222 r1 = new Runnable() {
            public final void run() {
                UnityPlayer.this.nativeRecreateGfxState(i, surface);
                semaphore.release();
            }
        };
        if (i != 0) {
            r1.run();
        } else if (surface == null) {
            this.f7850a.mo30679b(r1);
        } else {
            this.f7850a.mo30681c(r1);
        }
        if (surface == null && i == 0) {
            try {
                if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                    C3342f.Log(5, "Timeout while trying detaching primary window.");
                }
            } catch (InterruptedException unused) {
                C3342f.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public SurfaceView m7639c() {
        SurfaceView surfaceView = new SurfaceView(this.f7869t);
        if (m7637b()) {
            surfaceView.getHolder().setFormat(-3);
            surfaceView.setZOrderOnTop(true);
        } else {
            surfaceView.getHolder().setFormat(-1);
        }
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                UnityPlayer.this.m7621a(0, surfaceHolder.getSurface());
                UnityPlayer.this.m7642d();
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m7621a(0, surfaceHolder.getSurface());
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m7621a(0, (Surface) null);
            }
        });
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        return surfaceView;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7642d() {
        if (C3355m.m7754c() && this.f7855f.mo30746e()) {
            this.f7850a.mo30683d(new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeSendSurfaceChangedEvent();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7645e() {
        Context context = this.f7869t;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            ((Activity) this.f7869t).finish();
        }
    }

    /* renamed from: f */
    private void m7647f() {
        reportSoftInputStr(null, 1, true);
        if (this.f7855f.mo30748g()) {
            if (C3355m.m7754c()) {
                final Semaphore semaphore = new Semaphore(0);
                this.f7850a.mo30677a(isFinishing() ? new Runnable() {
                    public final void run() {
                        UnityPlayer.this.m7648g();
                        semaphore.release();
                    }
                } : new Runnable() {
                    public final void run() {
                        if (UnityPlayer.this.nativePause()) {
                            UnityPlayer.this.f7871v = true;
                            UnityPlayer.this.m7648g();
                            semaphore.release(2);
                            return;
                        }
                        semaphore.release();
                    }
                });
                try {
                    if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                        C3342f.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException unused) {
                    C3342f.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    destroy();
                }
            }
            this.f7855f.mo30744d(false);
            this.f7855f.mo30742b(true);
            if (this.f7858i) {
                this.f7860k.listen(this.f7859j, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m7648g() {
        this.f7872w = nativeDone();
        this.f7855f.mo30743c(false);
    }

    /* renamed from: h */
    private void m7650h() {
        if (this.f7855f.mo30747f()) {
            this.f7855f.mo30744d(true);
            m7636b((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeResume();
                }
            });
            this.f7850a.mo30678b();
        }
    }

    /* renamed from: i */
    private static void m7652i() {
        if (C3355m.m7754c()) {
            if (NativeLoader.unload()) {
                C3355m.m7753b();
                return;
            }
            throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
        }
    }

    private final native void initJni(Context context);

    /* renamed from: j */
    private ApplicationInfo m7654j() {
        return this.f7869t.getPackageManager().getApplicationInfo(this.f7869t.getPackageName(), 128);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m7657k() {
        try {
            return m7654j().metaData.getBoolean("unity.splash-enable");
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: l */
    private boolean m7658l() {
        try {
            return m7654j().metaData.getBoolean("unity.tango-enable");
        } catch (Exception unused) {
            return false;
        }
    }

    protected static boolean loadLibraryStatic(String str) {
        StringBuilder sb;
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            sb = new StringBuilder("Unable to find ");
            sb.append(str);
            C3342f.Log(6, sb.toString());
            return false;
        } catch (Exception e) {
            sb = new StringBuilder("Unknown error ");
            sb.append(e);
            C3342f.Log(6, sb.toString());
            return false;
        }
    }

    /* renamed from: m */
    private void m7660m() {
        Context context = this.f7869t;
        if (context instanceof Activity) {
            ((Activity) context).getWindow().setFlags(1024, 1024);
        }
    }

    private final native boolean nativeDone();

    /* access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* access modifiers changed from: private */
    public final native void nativeLowMemory();

    /* access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* access modifiers changed from: private */
    public final native boolean nativePause();

    /* access modifiers changed from: private */
    public final native void nativeRecreateGfxState(int i, Surface surface);

    /* access modifiers changed from: private */
    public final native boolean nativeRender();

    private final native void nativeRestartActivityIndicator();

    /* access modifiers changed from: private */
    public final native void nativeResume();

    /* access modifiers changed from: private */
    public final native void nativeSendSurfaceChangedEvent();

    /* access modifiers changed from: private */
    public final native void nativeSetInputArea(int i, int i2, int i3, int i4);

    /* access modifiers changed from: private */
    public final native void nativeSetInputSelection(int i, int i2);

    /* access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* access modifiers changed from: private */
    public final native void nativeSetKeyboardIsVisible(boolean z);

    /* access modifiers changed from: private */
    public final native void nativeSetLaunchURL(String str);

    /* access modifiers changed from: private */
    public final native void nativeSoftInputCanceled();

    /* access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    private final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30598a(Runnable runnable) {
        Context context = this.f7869t;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            C3342f.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    /* access modifiers changed from: protected */
    public void addPhoneCallListener() {
        this.f7858i = true;
        this.f7860k.listen(this.f7859j, 32);
    }

    public boolean addViewToPlayer(View view, boolean z) {
        m7624a(view, (View) z ? this.f7870u : null);
        boolean z2 = true;
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.f7870u.getParent() == null;
        boolean z5 = this.f7870u.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                C3342f.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                C3342f.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        SurfaceView surfaceView = this.f7870u;
        if (surfaceView instanceof SurfaceView) {
            surfaceView.getHolder().setSizeFromLayout();
        }
        C3361p pVar = this.f7873x;
        if (pVar != null) {
            pVar.mo30782c();
        }
        GoogleVrProxy b = GoogleVrApi.m7579b();
        if (b != null) {
            b.mo30563c();
        }
    }

    public void destroy() {
        if (GoogleVrApi.m7579b() != null) {
            GoogleVrApi.m7577a();
        }
        Camera2Wrapper camera2Wrapper = this.f7865p;
        if (camera2Wrapper != null) {
            camera2Wrapper.mo30540a();
            this.f7865p = null;
        }
        HFPStatus hFPStatus = this.f7866q;
        if (hFPStatus != null) {
            hFPStatus.mo30583a();
            this.f7866q = null;
        }
        NetworkConnectivity networkConnectivity = this.f7868s;
        if (networkConnectivity != null) {
            networkConnectivity.mo30588b();
            this.f7868s = null;
        }
        this.f7871v = true;
        if (!this.f7855f.mo30745d()) {
            pause();
        }
        this.f7850a.mo30676a();
        try {
            this.f7850a.join(4000);
        } catch (InterruptedException unused) {
            this.f7850a.interrupt();
        }
        BroadcastReceiver broadcastReceiver = this.f7857h;
        if (broadcastReceiver != null) {
            this.f7869t.unregisterReceiver(broadcastReceiver);
        }
        this.f7857h = null;
        if (C3355m.m7754c()) {
            removeAllViews();
        }
        if (this.f7872w) {
            kill();
        }
        m7652i();
    }

    /* access modifiers changed from: protected */
    public void disableLogger() {
        C3342f.f8002a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.f7853d = surface != null;
            mo30598a((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.f7853d) {
                        UnityPlayer unityPlayer = UnityPlayer.this;
                        unityPlayer.removeView(unityPlayer.f7870u);
                        return;
                    }
                    UnityPlayer unityPlayer2 = UnityPlayer.this;
                    unityPlayer2.addView(unityPlayer2.f7870u);
                }
            });
        }
        return m7638b(i, surface);
    }

    /* access modifiers changed from: protected */
    public void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.f7856g.poll();
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getClipboardText() {
        ClipData primaryClip = this.f7861l.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.f7869t).toString() : "";
    }

    /* access modifiers changed from: protected */
    public String getLaunchURL() {
        Uri uri = this.f7867r;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getNetworkConnectivity() {
        if (!C3345i.f8006d) {
            return 0;
        }
        if (this.f7868s == null) {
            this.f7868s = new NetworkConnectivity(this.f7869t);
        }
        return this.f7868s.mo30587a();
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    /* access modifiers changed from: protected */
    public int getSplashMode() {
        try {
            return m7654j().metaData.getInt("unity.splash-mode");
        } catch (Exception unused) {
            return 0;
        }
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void hideSoftInput() {
        reportSoftInputArea(new Rect());
        reportSoftInputIsVisible(false);
        final C33185 r0 = new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f7851b != null) {
                    UnityPlayer.this.f7851b.dismiss();
                    UnityPlayer.this.f7851b = null;
                }
            }
        };
        if (C3345i.f8004b) {
            m7625a((C3329f) new C3329f() {
                /* renamed from: a */
                public final void mo30652a() {
                    UnityPlayer.this.mo30598a(r0);
                }
            });
        } else {
            mo30598a((Runnable) r0);
        }
    }

    public void init(int i, boolean z) {
    }

    /* access modifiers changed from: protected */
    public boolean initializeGoogleAr() {
        if (this.f7863n == null && currentActivity != null && m7658l()) {
            this.f7863n = new GoogleARCoreApi();
            this.f7863n.initializeARCore(currentActivity);
            if (!this.f7855f.mo30745d()) {
                this.f7863n.resumeARCore();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean initializeGoogleVr() {
        final GoogleVrProxy b = GoogleVrApi.m7579b();
        if (b == null) {
            GoogleVrApi.m7578a(this);
            b = GoogleVrApi.m7579b();
            if (b == null) {
                C3342f.Log(6, "Unable to create Google VR subsystem.");
                return false;
            }
        }
        final Semaphore semaphore = new Semaphore(0);
        final C330415 r3 = new Runnable() {
            public final void run() {
                UnityPlayer.this.injectEvent(new KeyEvent(0, 4));
                UnityPlayer.this.injectEvent(new KeyEvent(1, 4));
            }
        };
        mo30598a((Runnable) new Runnable() {
            public final void run() {
                if (!b.mo30561a(UnityPlayer.currentActivity, UnityPlayer.this.f7869t, UnityPlayer.this.m7639c(), r3)) {
                    C3342f.Log(6, "Unable to initialize Google VR subsystem.");
                }
                if (UnityPlayer.currentActivity != null) {
                    b.mo30559a(UnityPlayer.currentActivity.getIntent());
                }
                semaphore.release();
            }
        });
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                return b.mo30560a();
            }
            C3342f.Log(5, "Timeout while trying to initialize Google VR.");
            return false;
        } catch (InterruptedException e) {
            StringBuilder sb = new StringBuilder("UI thread was interrupted while initializing Google VR. ");
            sb.append(e.getLocalizedMessage());
            C3342f.Log(5, sb.toString());
            return false;
        }
    }

    public boolean injectEvent(InputEvent inputEvent) {
        if (!C3355m.m7754c()) {
            return false;
        }
        return nativeInjectEvent(inputEvent);
    }

    /* access modifiers changed from: protected */
    public boolean isFinishing() {
        if (!this.f7871v) {
            Context context = this.f7869t;
            boolean z = (context instanceof Activity) && ((Activity) context).isFinishing();
            this.f7871v = z;
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public void kill() {
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: protected */
    public boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    public void lowMemory() {
        if (C3355m.m7754c()) {
            m7636b((Runnable) new Runnable() {
                public final void run() {
                    UnityPlayer.this.nativeLowMemory();
                }
            });
        }
    }

    public void newIntent(Intent intent) {
        this.f7867r = intent.getData();
        this.f7850a.mo30684e();
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        GoogleARCoreApi googleARCoreApi = this.f7863n;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        C3361p pVar = this.f7873x;
        if (pVar != null) {
            pVar.mo30779a();
        }
        GoogleVrProxy b = GoogleVrApi.m7579b();
        if (b != null) {
            b.pauseGvrLayout();
        }
        m7647f();
    }

    public void quit() {
        destroy();
    }

    public void removeViewFromPlayer(View view) {
        m7624a((View) this.f7870u, view);
        boolean z = true;
        boolean z2 = view.getParent() == null;
        boolean z3 = this.f7870u.getParent() == this;
        if (!z2 || !z3) {
            z = false;
        }
        if (!z) {
            if (!z2) {
                C3342f.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
            }
            if (!z3) {
                C3342f.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
            }
        }
    }

    public void reportError(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": ");
        sb.append(str2);
        C3342f.Log(6, sb.toString());
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputArea(final Rect rect) {
        m7625a((C3329f) new C3329f() {
            /* renamed from: a */
            public final void mo30652a() {
                UnityPlayer.this.nativeSetInputArea(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputIsVisible(final boolean z) {
        m7625a((C3329f) new C3329f() {
            /* renamed from: a */
            public final void mo30652a() {
                UnityPlayer.this.nativeSetKeyboardIsVisible(z);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputSelection(final int i, final int i2) {
        m7625a((C3329f) new C3329f() {
            /* renamed from: a */
            public final void mo30652a() {
                UnityPlayer.this.nativeSetInputSelection(i, i2);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputStr(final String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        m7625a((C3329f) new C3329f() {
            /* renamed from: a */
            public final void mo30652a() {
                if (z) {
                    UnityPlayer.this.nativeSoftInputCanceled();
                } else {
                    String str = str;
                    if (str != null) {
                        UnityPlayer.this.nativeSetInputString(str);
                    }
                }
                if (i == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void requestUserAuthorization(String str) {
        if (C3345i.f8005c && str != null && !str.isEmpty() && currentActivity != null) {
            C3345i.f8007e.mo30717a(currentActivity, str);
        }
    }

    public void resume() {
        GoogleARCoreApi googleARCoreApi = this.f7863n;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.f7855f.mo30742b(false);
        C3361p pVar = this.f7873x;
        if (pVar != null) {
            pVar.mo30781b();
        }
        m7650h();
        nativeRestartActivityIndicator();
        GoogleVrProxy b = GoogleVrApi.m7579b();
        if (b != null) {
            b.mo30562b();
        }
    }

    /* access modifiers changed from: protected */
    public void setCharacterLimit(final int i) {
        mo30598a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f7851b != null) {
                    UnityPlayer.this.f7851b.mo30721a(i);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setClipboardText(String str) {
        this.f7861l.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    /* access modifiers changed from: protected */
    public void setHideInputField(final boolean z) {
        mo30598a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f7851b != null) {
                    UnityPlayer.this.f7851b.mo30724a(z);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setSelection(final int i, final int i2) {
        mo30598a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f7851b != null) {
                    UnityPlayer.this.f7851b.mo30722a(i, i2);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setSoftInputStr(final String str) {
        mo30598a((Runnable) new Runnable() {
            public final void run() {
                if (UnityPlayer.this.f7851b != null && str != null) {
                    UnityPlayer.this.f7851b.mo30723a(str);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showSoftInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5) {
        final String str3 = str;
        final int i3 = i;
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final boolean z9 = z4;
        final String str4 = str2;
        final int i4 = i2;
        final boolean z10 = z5;
        C33174 r0 = new Runnable() {
            public final void run() {
                UnityPlayer unityPlayer = UnityPlayer.this;
                C3346j jVar = new C3346j(unityPlayer.f7869t, this, str3, i3, z6, z7, z8, str4, i4, z10);
                unityPlayer.f7851b = jVar;
                UnityPlayer.this.f7851b.show();
            }
        };
        mo30598a((Runnable) r0);
    }

    /* access modifiers changed from: protected */
    public boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.f7873x == null) {
            this.f7873x = new C3361p(this);
        }
        boolean a = this.f7873x.mo30780a(this.f7869t, str, i, i2, i3, z, (long) i4, (long) i5, new C3368a() {
            /* renamed from: a */
            public final void mo30655a() {
                UnityPlayer.this.f7873x = null;
            }
        });
        if (a) {
            mo30598a((Runnable) new Runnable() {
                public final void run() {
                    if (UnityPlayer.this.nativeIsAutorotationOn() && (UnityPlayer.this.f7869t instanceof Activity)) {
                        ((Activity) UnityPlayer.this.f7869t).setRequestedOrientation(UnityPlayer.this.f7852c);
                    }
                }
            });
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public boolean skipPermissionsDialog() {
        if (!C3345i.f8005c || currentActivity == null) {
            return false;
        }
        return C3345i.f8007e.mo30718a(currentActivity);
    }

    public void start() {
    }

    public void stop() {
    }

    /* access modifiers changed from: protected */
    public void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.f7869t.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.f7864o, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.f7864o);
        }
    }

    public void windowFocusChanged(boolean z) {
        this.f7855f.mo30741a(z);
        if (this.f7855f.mo30746e()) {
            if (z && this.f7851b != null) {
                nativeSoftInputLostFocus();
                reportSoftInputStr(null, 1, false);
            }
            if (z) {
                this.f7850a.mo30680c();
            } else {
                this.f7850a.mo30682d();
            }
            m7650h();
        }
    }
}
