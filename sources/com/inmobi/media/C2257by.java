package com.inmobi.media;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.inmobi.media.by */
/* compiled from: MediaRenderView */
public final class C2257by extends VideoView implements ActivityLifecycleCallbacks, OnCompletionListener, OnErrorListener, OnPreparedListener {
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final String f4718l = "by";

    /* renamed from: a */
    public C2259a f4719a;

    /* renamed from: b */
    public Bitmap f4720b;

    /* renamed from: c */
    public ViewGroup f4721c;

    /* renamed from: d */
    public C2260b f4722d;

    /* renamed from: e */
    int f4723e;

    /* renamed from: f */
    boolean f4724f;

    /* renamed from: g */
    public String f4725g;

    /* renamed from: h */
    public String f4726h;

    /* renamed from: i */
    boolean f4727i;

    /* renamed from: j */
    int f4728j;

    /* renamed from: k */
    int f4729k;

    /* renamed from: m */
    private boolean f4730m = false;

    /* renamed from: n */
    private WeakReference<Activity> f4731n;

    /* renamed from: com.inmobi.media.by$a */
    /* compiled from: MediaRenderView */
    public static class C2259a extends MediaController {
        public C2259a(Context context) {
            super(context);
        }

        public final void show(int i) {
            super.show(i);
            if (VERSION.SDK_INT < 19) {
                try {
                    Field declaredField = MediaController.class.getDeclaredField("mAnchor");
                    declaredField.setAccessible(true);
                    View view = (View) declaredField.get(this);
                    Field declaredField2 = MediaController.class.getDeclaredField("mDecor");
                    declaredField2.setAccessible(true);
                    View view2 = (View) declaredField2.get(this);
                    Field declaredField3 = MediaController.class.getDeclaredField("mDecorLayoutParams");
                    declaredField3.setAccessible(true);
                    LayoutParams layoutParams = (LayoutParams) declaredField3.get(this);
                    Field declaredField4 = MediaController.class.getDeclaredField("mWindowManager");
                    declaredField4.setAccessible(true);
                    WindowManager windowManager = (WindowManager) declaredField4.get(this);
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    view2.measure(MeasureSpec.makeMeasureSpec(view.getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(view.getHeight(), Integer.MIN_VALUE));
                    view2.setPadding(0, 0, 0, 0);
                    layoutParams.verticalMargin = 0.0f;
                    layoutParams.horizontalMargin = 0.0f;
                    layoutParams.width = view.getWidth();
                    layoutParams.gravity = 8388659;
                    layoutParams.x = iArr[0];
                    layoutParams.y = (iArr[1] + view.getHeight()) - view2.getMeasuredHeight();
                    windowManager.updateViewLayout(view2, layoutParams);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: com.inmobi.media.by$b */
    /* compiled from: MediaRenderView */
    interface C2260b {
        /* renamed from: a */
        void mo28093a();

        /* renamed from: a */
        void mo28094a(C2257by byVar);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
    }

    public C2257by(Activity activity) {
        super(activity);
        setZOrderOnTop(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT < 28) {
            setDrawingCacheEnabled(true);
        }
        this.f4723e = 100;
        this.f4728j = -1;
        this.f4729k = 0;
        this.f4724f = false;
        this.f4731n = new WeakReference<>(activity);
        C2505gd.m5286a((Context) activity, (ActivityLifecycleCallbacks) this);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getHolder().setSizeFromLayout();
    }

    /* access modifiers changed from: protected */
    @TargetApi(16)
    public final void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            if (VERSION.SDK_INT >= 16) {
                Context c = C2505gd.m5298c();
                if (c != null) {
                    setBackground(new BitmapDrawable(c.getResources(), this.f4720b));
                }
                return;
            }
            setBackgroundDrawable(new BitmapDrawable(this.f4720b));
        }
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        mo28071a();
        return false;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                C2257by.f4718l;
                if (C2257by.this.f4719a == null) {
                    C2257by byVar = C2257by.this;
                    byVar.f4719a = new C2259a(byVar.getContext());
                    C2257by.this.f4719a.setAnchorView(C2257by.this);
                    C2257by byVar2 = C2257by.this;
                    byVar2.setMediaController(byVar2.f4719a);
                    C2257by.this.requestLayout();
                    C2257by.this.requestFocus();
                }
            }
        });
        int i = this.f4729k;
        if (i < getDuration()) {
            this.f4729k = i;
            seekTo(i);
        }
        this.f4727i = true;
        this.f4722d.mo28093a();
        start();
    }

    public final void setPlaybackData(String str) {
        this.f4726h = m4577a(str);
        this.f4725g = "anonymous";
        if (this.f4720b == null) {
            this.f4720b = Bitmap.createBitmap(24, 24, Config.ARGB_8888);
            this.f4720b = m4578b(this.f4726h);
        }
    }

    public final void start() {
        if (!this.f4730m) {
            super.start();
        }
    }

    public final void pause() {
        super.pause();
    }

    /* renamed from: a */
    public final void mo28071a() {
        stopPlayback();
        m4580c();
        super.setMediaController(null);
        this.f4719a = null;
        C2260b bVar = this.f4722d;
        if (bVar != null) {
            bVar.mo28094a(this);
        }
    }

    public final ViewGroup getViewContainer() {
        return this.f4721c;
    }

    public final void setViewContainer(ViewGroup viewGroup) {
        this.f4721c = viewGroup;
    }

    public final void setListener(C2260b bVar) {
        this.f4722d = bVar;
    }

    /* renamed from: c */
    private void m4580c() {
        ViewGroup viewGroup = this.f4721c;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f4721c);
            }
            ViewGroup viewGroup3 = (ViewGroup) getParent();
            if (viewGroup3 != null) {
                viewGroup3.removeView(this);
            }
            setBackgroundColor(0);
            this.f4721c = null;
        }
    }

    /* renamed from: a */
    public static String m4577a(String str) {
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            if ((b & 128) > 0) {
                sb.append("%");
                char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
                sb.append(new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]}));
            } else {
                sb.append((char) b);
            }
        }
        try {
            return new String(sb.toString().getBytes(), "ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static Bitmap m4578b(String str) {
        try {
            return (Bitmap) Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{str, Integer.valueOf(1)});
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void onActivityStarted(Activity activity) {
        if (this.f4731n.get() != null && ((Activity) this.f4731n.get()).equals(activity)) {
            this.f4730m = false;
            start();
        }
    }

    public final void onActivityStopped(Activity activity) {
        Activity activity2 = (Activity) this.f4731n.get();
        if (activity2 != null && activity2.equals(activity)) {
            this.f4730m = true;
            if (getCurrentPosition() != 0) {
                this.f4729k = getCurrentPosition();
            }
            pause();
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }
}
