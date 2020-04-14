package com.inmobi.media;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.facebook.appevents.AppEventsConstants;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.media.C2257by.C2259a;
import com.inmobi.media.C2265cb.C2269a;
import com.inmobi.media.C2265cb.C2270b;
import com.inmobi.media.C2265cb.C2271c;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bw */
/* compiled from: JavaScriptBridge */
public class C2243bw {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4678a = "bw";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C2600j f4679b;

    /* renamed from: c */
    private int f4680c;

    /* renamed from: d */
    private C2274cd f4681d;

    @TargetApi(16)
    /* renamed from: com.inmobi.media.bw$a */
    /* compiled from: JavaScriptBridge */
    static class C2255a implements OnGlobalLayoutListener {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f4709a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f4710b;

        /* renamed from: c */
        private View f4711c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Boolean f4712d = Boolean.FALSE;

        C2255a(View view) {
            this.f4711c = view;
        }

        public final void onGlobalLayout() {
            try {
                this.f4709a = C2528gq.m5396b(this.f4711c.getWidth());
                this.f4710b = C2528gq.m5396b(this.f4711c.getHeight());
                if (VERSION.SDK_INT >= 16) {
                    this.f4711c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    this.f4711c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                synchronized (this.f4712d) {
                    this.f4712d.notify();
                }
            } catch (Exception unused) {
                C2243bw.f4678a;
            }
        }
    }

    @JavascriptInterface
    public void cancelSaveContent(String str, String str2) {
    }

    @JavascriptInterface
    public void fireSkip(String str) {
    }

    @JavascriptInterface
    public void log(String str, String str2) {
    }

    @JavascriptInterface
    public void onOrientationChange(String str) {
    }

    @JavascriptInterface
    public void showAlert(String str, String str2) {
    }

    @JavascriptInterface
    public void storePicture(String str, String str2) {
    }

    public C2243bw(C2600j jVar, int i) {
        this.f4679b = jVar;
        this.f4680c = i;
    }

    @JavascriptInterface
    public void open(final String str, final String str2) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            if (!jVar.mo28663j()) {
                this.f4679b.mo28632d("open");
            } else {
                new Handler(this.f4679b.getContainerContext().getMainLooper()).post(new Runnable() {
                    public final void run() {
                        String str = "open";
                        try {
                            C2243bw.this.f4679b.mo28631c(str, str, str2);
                        } catch (Exception unused) {
                            C2243bw.this.f4679b.mo28628b(str, "Unexpected error", str);
                            C2514gh.m5342a(1, "InMobi", "Failed to open URL; SDK encountered unexpected error");
                            C2243bw.f4678a;
                        }
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void openEmbedded(final String str, final String str2) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            if (!jVar.mo28663j()) {
                this.f4679b.mo28632d("openEmbedded");
            } else {
                new Handler(this.f4679b.getContainerContext().getMainLooper()).post(new Runnable() {
                    public final void run() {
                        String str = "openEmbedded";
                        try {
                            C2243bw.this.f4679b.mo28631c(str, str, str2);
                        } catch (Exception unused) {
                            C2243bw.this.f4679b.mo28628b(str, "Unexpected error", str);
                            C2514gh.m5342a(1, "InMobi", "Failed to open URL; SDK encountered unexpected error");
                            C2243bw.f4678a;
                        }
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void ping(String str, String str2, boolean z) {
        if (this.f4679b != null) {
            String str3 = "ping";
            if (str2 == null || str2.trim().length() == 0 || !URLUtil.isValidUrl(str2)) {
                this.f4679b.mo28628b(str, "Invalid URL:".concat(String.valueOf(str2)), str3);
                return;
            }
            try {
                C2185as.m4434a().mo27909a(str2, z);
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", str3);
                C2514gh.m5342a(1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
            }
        }
    }

    @JavascriptInterface
    public void pingInWebView(String str, String str2, boolean z) {
        if (this.f4679b != null) {
            String str3 = "pingInWebView";
            if (str2 == null || str2.trim().length() == 0 || !URLUtil.isValidUrl(str2)) {
                this.f4679b.mo28628b(str, "Invalid URL:".concat(String.valueOf(str2)), str3);
                return;
            }
            try {
                C2185as.m4434a().mo27911b(str2, z);
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", str3);
                C2514gh.m5342a(1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
            }
        }
    }

    @JavascriptInterface
    public String getPlatformVersion(String str) {
        return Integer.toString(VERSION.SDK_INT);
    }

    @JavascriptInterface
    public String getPlatform(String str) {
        C2506ge.m5323d();
        return C2506ge.m5323d();
    }

    @JavascriptInterface
    public void fireAdReady(String str) {
        try {
            this.f4679b.getListener().mo28526a(this.f4679b);
        } catch (Exception unused) {
            this.f4679b.mo28628b(str, "Unexpected error", "fireAdReady");
        }
    }

    @JavascriptInterface
    public void fireAdFailed(String str) {
        try {
            this.f4679b.getListener().mo28530b(this.f4679b);
        } catch (Exception unused) {
            this.f4679b.mo28628b(str, "Unexpected error", "fireAdFailed");
        }
    }

    @JavascriptInterface
    public String getDefaultPosition(String str) {
        C2600j jVar = this.f4679b;
        if (jVar == null) {
            return new JSONObject().toString();
        }
        synchronized (jVar.getDefaultPositionMonitor()) {
            this.f4679b.f5803i = true;
            new Handler(this.f4679b.getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        C2243bw.this.f4679b.mo28635g();
                    } catch (Exception unused) {
                        C2243bw.f4678a;
                    }
                }
            });
            while (this.f4679b.f5803i) {
                try {
                    this.f4679b.getDefaultPositionMonitor().wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        return this.f4679b.getDefaultPosition();
    }

    @JavascriptInterface
    public String getCurrentPosition(String str) {
        C2600j jVar = this.f4679b;
        if (jVar == null) {
            return "";
        }
        synchronized (jVar.getCurrentPositionMonitor()) {
            this.f4679b.f5804j = true;
            new Handler(this.f4679b.getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        C2243bw.this.f4679b.mo28661h();
                    } catch (Exception unused) {
                        C2243bw.f4678a;
                    }
                }
            });
            while (this.f4679b.f5804j) {
                try {
                    this.f4679b.getCurrentPositionMonitor().wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        return this.f4679b.getCurrentPosition();
    }

    @JavascriptInterface
    public void setExpandProperties(String str, String str2) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            if (!"Expanded".equals(jVar.getState())) {
                try {
                    this.f4679b.setExpandProperties(C2256bx.m4574a(str2));
                } catch (Exception unused) {
                    this.f4679b.mo28628b(str, "Unexpected error", "setExpandProperties");
                }
            }
        }
    }

    @JavascriptInterface
    public String getExpandProperties(String str) {
        C2600j jVar = this.f4679b;
        if (jVar == null) {
            return "";
        }
        return jVar.getExpandProperties().f4716c;
    }

    @JavascriptInterface
    public void expand(final String str, final String str2) {
        if (this.f4680c != 1) {
            C2600j jVar = this.f4679b;
            if (jVar != null) {
                String str3 = "expand";
                if (!jVar.mo28663j()) {
                    this.f4679b.mo28632d(str3);
                } else if (!this.f4679b.f5807m) {
                    this.f4679b.mo28628b(str, "Creative is not visible. Ignoring request.", str3);
                } else if (str2 == null || str2.length() == 0 || str2.startsWith("http")) {
                    new Handler(this.f4679b.getContainerContext().getMainLooper()).post(new Runnable() {
                        public final void run() {
                            int i;
                            try {
                                C2600j a = C2243bw.this.f4679b;
                                String str = str2;
                                if ("Default".equals(a.f5797c) || "Resized".equals(a.f5797c)) {
                                    a.f5812r = true;
                                    C2261bz bzVar = a.f5799e;
                                    if (bzVar.f4736c == null) {
                                        bzVar.f4736c = (ViewGroup) bzVar.f4734a.getParent();
                                        bzVar.f4737d = bzVar.f4736c.indexOfChild(bzVar.f4734a);
                                    }
                                    if (bzVar.f4734a != null) {
                                        C2256bx expandProperties = bzVar.f4734a.getExpandProperties();
                                        bzVar.f4735b = URLUtil.isValidUrl(str);
                                        C2600j jVar = bzVar.f4734a;
                                        if (bzVar.f4735b) {
                                            try {
                                                jVar = new C2600j(bzVar.f4734a.getContainerContext(), 0, null, bzVar.f4734a.getImpressionId());
                                                jVar.mo28623a(bzVar.f4734a.getListener(), bzVar.f4734a.getAdConfig(), false, false);
                                                jVar.setOriginalRenderView(bzVar.f4734a);
                                                jVar.loadUrl(str);
                                                jVar.setPlacementId(bzVar.f4734a.getPlacementId());
                                                jVar.setAllowAutoRedirection(bzVar.f4734a.getAllowAutoRedirection());
                                                jVar.setCreativeId(bzVar.f4734a.getCreativeId());
                                                i = InMobiAdActivity.m4207a((C2452f) jVar);
                                                if (expandProperties != null) {
                                                    jVar.setUseCustomClose(bzVar.f4734a.f5805k);
                                                }
                                            } catch (Exception e) {
                                                C2463fd.m5161a().mo28382a(new C2495fz(e));
                                                bzVar.f4734a.getListener().mo28538h(bzVar.f4734a);
                                            }
                                        } else {
                                            jVar.setShouldFireRenderBeacon(false);
                                            FrameLayout frameLayout = new FrameLayout(bzVar.f4734a.getContainerContext());
                                            LayoutParams layoutParams = new LayoutParams(bzVar.f4734a.getWidth(), bzVar.f4734a.getHeight());
                                            frameLayout.setId(65535);
                                            bzVar.f4736c.addView(frameLayout, bzVar.f4737d, layoutParams);
                                            bzVar.f4736c.removeView(bzVar.f4734a);
                                            i = InMobiAdActivity.m4207a((C2452f) bzVar.f4734a);
                                        }
                                        bzVar.f4734a.getListener().mo28540j(jVar);
                                        Intent intent = new Intent(bzVar.f4734a.getContainerContext(), InMobiAdActivity.class);
                                        intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
                                        intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", i);
                                        intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                                        C2505gd.m5287a(bzVar.f4734a.getContainerContext(), intent);
                                    }
                                    a.requestLayout();
                                    a.invalidate();
                                    a.f5806l = true;
                                    a.setFocusable(true);
                                    a.setFocusableInTouchMode(true);
                                    a.requestFocus();
                                }
                            } catch (Exception unused) {
                                C2243bw.this.f4679b.mo28628b(str, "Unexpected error", "expand");
                                C2514gh.m5342a(1, "InMobi", "Failed to expand ad; SDK encountered an unexpected error");
                                C2243bw.f4678a;
                            }
                        }
                    });
                } else {
                    this.f4679b.mo28628b(str, "Invalid URL", str3);
                }
            }
        }
    }

    @JavascriptInterface
    public String getVersion(String str) {
        C2506ge.m5322c();
        return C2506ge.m5322c();
    }

    @JavascriptInterface
    public void setResizeProperties(String str, String str2) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            C2275ce a = C2275ce.m4612a(str2, jVar.getResizeProperties());
            if (a == null) {
                this.f4679b.mo28628b(str, "setResizeProperties", "All mandatory fields are not present");
            }
            this.f4679b.setResizeProperties(a);
        }
    }

    @JavascriptInterface
    public String getResizeProperties(String str) {
        C2600j jVar = this.f4679b;
        String str2 = "";
        if (jVar == null) {
            return str2;
        }
        C2275ce resizeProperties = jVar.getResizeProperties();
        if (resizeProperties == null) {
            return str2;
        }
        return resizeProperties.mo28106a();
    }

    @JavascriptInterface
    public void resize(final String str) {
        if (this.f4680c != 1 && this.f4679b != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
                    if (r3.equals(r1.f5797c) != false) goto L_0x001b;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r5 = this;
                        r0 = 1
                        com.inmobi.media.bw r1 = com.inmobi.media.C2243bw.this     // Catch:{ Exception -> 0x0047 }
                        com.inmobi.media.j r1 = r1.f4679b     // Catch:{ Exception -> 0x0047 }
                        java.lang.String r2 = "Default"
                        java.lang.String r3 = r1.f5797c     // Catch:{ Exception -> 0x0047 }
                        boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0047 }
                        java.lang.String r3 = "Resized"
                        if (r2 != 0) goto L_0x001b
                        java.lang.String r2 = r1.f5797c     // Catch:{ Exception -> 0x0047 }
                        boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x0047 }
                        if (r2 == 0) goto L_0x0046
                    L_0x001b:
                        com.inmobi.media.ce r2 = r1.getResizeProperties()     // Catch:{ Exception -> 0x0047 }
                        if (r2 == 0) goto L_0x0046
                        r1.f5812r = r0     // Catch:{ Exception -> 0x0047 }
                        com.inmobi.media.cc r2 = r1.f5800f     // Catch:{ Exception -> 0x0047 }
                        r2.mo28104a()     // Catch:{ Exception -> 0x0047 }
                        r1.requestLayout()     // Catch:{ Exception -> 0x0047 }
                        r1.invalidate()     // Catch:{ Exception -> 0x0047 }
                        r1.f5806l = r0     // Catch:{ Exception -> 0x0047 }
                        r1.setFocusable(r0)     // Catch:{ Exception -> 0x0047 }
                        r1.setFocusableInTouchMode(r0)     // Catch:{ Exception -> 0x0047 }
                        r1.requestFocus()     // Catch:{ Exception -> 0x0047 }
                        r1.setAndUpdateViewState(r3)     // Catch:{ Exception -> 0x0047 }
                        com.inmobi.media.j$a r2 = r1.getListener()     // Catch:{ Exception -> 0x0047 }
                        r2.mo28536f(r1)     // Catch:{ Exception -> 0x0047 }
                        r2 = 0
                        r1.f5812r = r2     // Catch:{ Exception -> 0x0047 }
                    L_0x0046:
                        return
                    L_0x0047:
                        com.inmobi.media.bw r1 = com.inmobi.media.C2243bw.this
                        com.inmobi.media.j r1 = r1.f4679b
                        java.lang.String r2 = r3
                        java.lang.String r3 = "Unexpected error"
                        java.lang.String r4 = "resize"
                        r1.mo28628b(r2, r3, r4)
                        java.lang.String r1 = com.inmobi.media.C2243bw.f4678a
                        java.lang.String r2 = "Could not resize ad; SDK encountered an unexpected error"
                        com.inmobi.media.C2514gh.m5342a(r0, r1, r2)
                        com.inmobi.media.C2243bw.f4678a
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2243bw.C22538.run():void");
                }
            });
        }
    }

    @JavascriptInterface
    public void setOrientationProperties(String str, String str2) {
        this.f4681d = C2274cd.m4611a(str2, this.f4679b.getOrientationProperties());
        this.f4679b.setOrientationProperties(this.f4681d);
    }

    @JavascriptInterface
    public String getOrientationProperties(String str) {
        return this.f4681d.f4771d;
    }

    @JavascriptInterface
    public boolean isViewable(String str) {
        C2600j jVar = this.f4679b;
        if (jVar == null) {
            return false;
        }
        return jVar.f5807m;
    }

    @JavascriptInterface
    public void useCustomClose(final String str, final boolean z) {
        new Handler(this.f4679b.getContainerContext().getMainLooper()).post(new Runnable() {
            public final void run() {
                try {
                    C2243bw.this.f4679b.mo28629b(z);
                } catch (Exception unused) {
                    C2243bw.this.f4679b.mo28628b(str, "Unexpected error", "useCustomClose");
                    C2243bw.f4678a;
                }
            }
        });
    }

    @JavascriptInterface
    public void playVideo(final String str, final String str2) {
        if (this.f4679b != null) {
            if (str2 == null || str2.trim().length() == 0 || !str2.startsWith("http") || (!str2.endsWith("mp4") && !str2.endsWith("avi") && !str2.endsWith("m4v"))) {
                this.f4679b.mo28628b(str, "Null or empty or invalid media playback URL supplied", "playVideo");
            } else {
                new Handler(this.f4679b.getContainerContext().getMainLooper()).post(new Runnable() {
                    public final void run() {
                        String str = "playVideo";
                        try {
                            C2600j a = C2243bw.this.f4679b;
                            String str2 = str;
                            String trim = str2.trim();
                            if (1 == a.f5798d || "Expanded".equals(a.getViewState())) {
                                if (a.f5796b != null) {
                                    if (a.f5796b.get() != null) {
                                        a.setAdActiveFlag(true);
                                        C2265cb cbVar = a.f5801g;
                                        Activity activity = (Activity) a.f5796b.get();
                                        cbVar.f4747b = new C2257by(activity);
                                        C2257by byVar = cbVar.f4747b;
                                        byVar.f4726h = C2257by.m4577a(trim);
                                        byVar.f4725g = "anonymous";
                                        if (byVar.f4720b == null) {
                                            byVar.f4720b = Bitmap.createBitmap(24, 24, Config.ARGB_8888);
                                            byVar.f4720b = C2257by.m4578b(byVar.f4726h);
                                        }
                                        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                                        layoutParams.addRule(13);
                                        cbVar.f4747b.setLayoutParams(layoutParams);
                                        RelativeLayout relativeLayout = new RelativeLayout(activity);
                                        relativeLayout.setOnTouchListener(new OnTouchListener() {
                                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                                return true;
                                            }
                                        });
                                        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                                        relativeLayout.addView(cbVar.f4747b);
                                        viewGroup.addView(relativeLayout, new LayoutParams(-1, -1));
                                        cbVar.f4747b.f4721c = relativeLayout;
                                        cbVar.f4747b.requestFocus();
                                        cbVar.f4747b.setOnKeyListener(new OnKeyListener() {
                                            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                                                if (4 != i || keyEvent.getAction() != 0) {
                                                    return false;
                                                }
                                                C2265cb.this.f4747b.mo28071a();
                                                return true;
                                            }
                                        });
                                        cbVar.f4747b.f4722d = new C2260b() {
                                            /* renamed from: a */
                                            public final void mo28094a(C2257by byVar) {
                                                C2265cb.f4745f;
                                                C2265cb.this.f4746a.setAdActiveFlag(false);
                                                ViewGroup viewGroup = byVar.f4721c;
                                                if (viewGroup != null) {
                                                    ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                                                }
                                                byVar.f4721c = null;
                                            }

                                            /* renamed from: a */
                                            public final void mo28093a() {
                                                C2265cb.f4745f;
                                            }
                                        };
                                        C2257by byVar2 = cbVar.f4747b;
                                        byVar2.setVideoPath(byVar2.f4726h);
                                        byVar2.setOnCompletionListener(byVar2);
                                        byVar2.setOnPreparedListener(byVar2);
                                        byVar2.setOnErrorListener(byVar2);
                                        if (byVar2.f4719a == null && VERSION.SDK_INT >= 19) {
                                            byVar2.f4719a = new C2259a(byVar2.getContext());
                                            byVar2.f4719a.setAnchorView(byVar2);
                                            byVar2.setMediaController(byVar2.f4719a);
                                        }
                                    }
                                }
                                a.mo28628b(str2, "Media playback is  not allowed before it is visible! Ignoring request ...", str);
                            }
                        } catch (Exception unused) {
                            C2243bw.this.f4679b.mo28628b(str, "Unexpected error", str);
                            C2514gh.m5342a(1, "InMobi", "Error playing video; SDK encountered an unexpected error");
                            C2243bw.f4678a;
                        }
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public String getState(String str) {
        return this.f4679b.getState().toLowerCase(Locale.ENGLISH);
    }

    @JavascriptInterface
    public String getScreenSize(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", C2528gq.m5393a().f5541a);
            jSONObject.put("height", C2528gq.m5393a().f5542b);
        } catch (JSONException unused) {
        } catch (Exception unused2) {
            this.f4679b.mo28628b(str, "Unexpected error", "getScreenSize");
        }
        return jSONObject.toString();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0064 */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMaxSize(java.lang.String r7) {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.inmobi.media.j r1 = r6.f4679b     // Catch:{ Exception -> 0x007e }
            android.app.Activity r1 = r1.getFullScreenActivity()     // Catch:{ Exception -> 0x007e }
            if (r1 != 0) goto L_0x0024
            com.inmobi.media.j r1 = r6.f4679b     // Catch:{ Exception -> 0x007e }
            android.content.Context r1 = r1.getContainerContext()     // Catch:{ Exception -> 0x007e }
            boolean r1 = r1 instanceof android.app.Activity     // Catch:{ Exception -> 0x007e }
            if (r1 != 0) goto L_0x001c
            java.lang.String r7 = r6.getScreenSize(r7)     // Catch:{ Exception -> 0x007e }
            return r7
        L_0x001c:
            com.inmobi.media.j r1 = r6.f4679b     // Catch:{ Exception -> 0x007e }
            android.content.Context r1 = r1.getContainerContext()     // Catch:{ Exception -> 0x007e }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x007e }
        L_0x0024:
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ Exception -> 0x007e }
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1     // Catch:{ Exception -> 0x007e }
            int r2 = r1.getWidth()     // Catch:{ Exception -> 0x007e }
            int r2 = com.inmobi.media.C2528gq.m5396b(r2)     // Catch:{ Exception -> 0x007e }
            int r3 = r1.getHeight()     // Catch:{ Exception -> 0x007e }
            int r3 = com.inmobi.media.C2528gq.m5396b(r3)     // Catch:{ Exception -> 0x007e }
            com.inmobi.media.j r4 = r6.f4679b     // Catch:{ Exception -> 0x007e }
            android.app.Activity r4 = r4.getFullScreenActivity()     // Catch:{ Exception -> 0x007e }
            if (r4 == 0) goto L_0x0073
            if (r2 == 0) goto L_0x0049
            if (r3 != 0) goto L_0x0073
        L_0x0049:
            com.inmobi.media.bw$a r2 = new com.inmobi.media.bw$a     // Catch:{ Exception -> 0x007e }
            r2.<init>(r1)     // Catch:{ Exception -> 0x007e }
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()     // Catch:{ Exception -> 0x007e }
            r1.addOnGlobalLayoutListener(r2)     // Catch:{ Exception -> 0x007e }
            java.lang.Boolean r1 = r2.f4712d     // Catch:{ Exception -> 0x007e }
            monitor-enter(r1)     // Catch:{ Exception -> 0x007e }
            java.lang.Boolean r3 = r2.f4712d     // Catch:{ InterruptedException -> 0x0064 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0064 }
            goto L_0x0064
        L_0x0062:
            r2 = move-exception
            goto L_0x0071
        L_0x0064:
            int r3 = r2.f4709a     // Catch:{ all -> 0x0062 }
            int r2 = r2.f4710b     // Catch:{ all -> 0x0062 }
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            r5 = r3
            r3 = r2
            r2 = r5
            goto L_0x0073
        L_0x0071:
            monitor-exit(r1)     // Catch:{ all -> 0x0062 }
            throw r2     // Catch:{ Exception -> 0x007e }
        L_0x0073:
            java.lang.String r1 = "width"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0087 }
            java.lang.String r1 = "height"
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0087 }
            goto L_0x0087
        L_0x007e:
            com.inmobi.media.j r1 = r6.f4679b
            java.lang.String r2 = "Unexpected error"
            java.lang.String r3 = "getMaxSize"
            r1.mo28628b(r7, r2, r3)
        L_0x0087:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2243bw.getMaxSize(java.lang.String):java.lang.String");
    }

    @JavascriptInterface
    public void close(final String str) {
        new Handler(this.f4679b.getContainerContext().getMainLooper()).post(new Runnable() {
            public final void run() {
                try {
                    C2243bw.this.f4679b.getReferenceContainer().mo28360b();
                } catch (Exception unused) {
                    C2243bw.this.f4679b.mo28628b(str, "Unexpected error", String.CLOSE);
                    C2514gh.m5342a(1, "InMobi", "Failed to close ad; SDK encountered an unexpected error");
                    C2243bw.f4678a;
                }
            }
        });
    }

    @JavascriptInterface
    public String getPlacementType(String str) {
        return 1 == this.f4680c ? "interstitial" : String.INLINE;
    }

    @JavascriptInterface
    public String getSdkVersion(String str) {
        C2506ge.m5320b();
        return C2506ge.m5320b();
    }

    @JavascriptInterface
    public String supports(String str, String str2) {
        return String.valueOf(this.f4679b.mo28634f(str2));
    }

    @JavascriptInterface
    public void openExternal(String str, String str2, @Nullable String str3) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            String str4 = "openExternal";
            if (!jVar.mo28663j()) {
                this.f4679b.mo28632d(str4);
                return;
            }
            C2600j jVar2 = this.f4679b;
            if (str2 != null) {
                jVar2.mo28625a(str4, str, str2, str3);
            } else if (str3 != null) {
                jVar2.mo28625a(str4, str, str3, (String) null);
            } else {
                jVar2.mo28628b(str, "Empty url and fallback url", str4);
            }
        }
    }

    @JavascriptInterface
    public void asyncPing(String str, String str2) {
        String str3 = "asyncPing";
        if (!URLUtil.isValidUrl(str2)) {
            this.f4679b.mo28628b(str, "Invalid url", str3);
            return;
        }
        try {
            final C2486fr frVar = new C2486fr("GET", str2);
            frVar.f5450v = false;
            frVar.f5444p = false;
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        C2487fs a = new C2484fp(C2481fo.this.f5421b).mo28405a();
                        if (a.mo28417a()) {
                            C2481fo.this.f5422c.mo28061a();
                        } else {
                            C2481fo.this.f5422c.mo28062a(a);
                        }
                    } catch (Exception unused) {
                        C2481fo.f5420a;
                        new C2487fs().f5452a = new C2485fq(-1, "Network request failed with unknown error");
                        C2481fo.this.f5422c.mo28061a();
                    }
                }
            }).start();
        } catch (Exception unused) {
            this.f4679b.mo28628b(str, "Unexpected error", str3);
        }
    }

    @JavascriptInterface
    public void disableCloseRegion(final String str, final boolean z) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            new Handler(jVar.getContainerContext().getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        C2243bw.this.f4679b.mo28626a(z);
                    } catch (Exception unused) {
                        C2243bw.this.f4679b.mo28628b(str, "Unexpected error", "disableCloseRegion");
                        C2243bw.f4678a;
                    }
                }
            });
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r6.f4679b.mo28628b(r7, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r6.f4679b.getListener().mo28531b(r6.f4679b, new java.util.HashMap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0072, code lost:
        r6.f4679b.mo28628b(r7, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0061 */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUserInteraction(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            com.inmobi.media.j r0 = r6.f4679b
            java.lang.String r1 = "onUserInteraction"
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.mo28663j()
            if (r0 != 0) goto L_0x0012
            com.inmobi.media.j r7 = r6.f4679b
            r7.mo28632d(r1)
            return
        L_0x0012:
            java.lang.String r0 = "Unexpected error"
            if (r8 != 0) goto L_0x002d
            com.inmobi.media.j r8 = r6.f4679b     // Catch:{ Exception -> 0x0027 }
            com.inmobi.media.j$a r8 = r8.getListener()     // Catch:{ Exception -> 0x0027 }
            com.inmobi.media.j r2 = r6.f4679b     // Catch:{ Exception -> 0x0027 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0027 }
            r3.<init>()     // Catch:{ Exception -> 0x0027 }
            r8.mo28531b(r2, r3)     // Catch:{ Exception -> 0x0027 }
            return
        L_0x0027:
            com.inmobi.media.j r8 = r6.f4679b
            r8.mo28628b(r7, r0, r1)
            return
        L_0x002d:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0061 }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x0061 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ JSONException -> 0x0061 }
            r8.<init>()     // Catch:{ JSONException -> 0x0061 }
            java.util.Iterator r3 = r2.keys()     // Catch:{ JSONException -> 0x0061 }
        L_0x003b:
            boolean r4 = r3.hasNext()     // Catch:{ JSONException -> 0x0061 }
            if (r4 == 0) goto L_0x004f
            java.lang.Object r4 = r3.next()     // Catch:{ JSONException -> 0x0061 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x0061 }
            java.lang.Object r5 = r2.get(r4)     // Catch:{ JSONException -> 0x0061 }
            r8.put(r4, r5)     // Catch:{ JSONException -> 0x0061 }
            goto L_0x003b
        L_0x004f:
            com.inmobi.media.j r2 = r6.f4679b     // Catch:{ Exception -> 0x005b }
            com.inmobi.media.j$a r2 = r2.getListener()     // Catch:{ Exception -> 0x005b }
            com.inmobi.media.j r3 = r6.f4679b     // Catch:{ Exception -> 0x005b }
            r2.mo28531b(r3, r8)     // Catch:{ Exception -> 0x005b }
            return
        L_0x005b:
            com.inmobi.media.j r8 = r6.f4679b     // Catch:{ JSONException -> 0x0061 }
            r8.mo28628b(r7, r0, r1)     // Catch:{ JSONException -> 0x0061 }
            return
        L_0x0061:
            com.inmobi.media.j r8 = r6.f4679b     // Catch:{ Exception -> 0x0072 }
            com.inmobi.media.j$a r8 = r8.getListener()     // Catch:{ Exception -> 0x0072 }
            com.inmobi.media.j r2 = r6.f4679b     // Catch:{ Exception -> 0x0072 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0072 }
            r3.<init>()     // Catch:{ Exception -> 0x0072 }
            r8.mo28531b(r2, r3)     // Catch:{ Exception -> 0x0072 }
            return
        L_0x0072:
            com.inmobi.media.j r8 = r6.f4679b
            r8.mo28628b(r7, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2243bw.onUserInteraction(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r6.f4679b.mo28628b(r7, r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r6.f4679b.getListener().mo28527a(r6.f4679b, new java.util.HashMap<>());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        r6.f4679b.mo28628b(r7, r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void incentCompleted(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "incentCompleted"
            java.lang.String r1 = "Unexpected error"
            if (r8 != 0) goto L_0x001d
            com.inmobi.media.j r8 = r6.f4679b     // Catch:{ Exception -> 0x0017 }
            com.inmobi.media.j$a r8 = r8.getListener()     // Catch:{ Exception -> 0x0017 }
            com.inmobi.media.j r2 = r6.f4679b     // Catch:{ Exception -> 0x0017 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0017 }
            r3.<init>()     // Catch:{ Exception -> 0x0017 }
            r8.mo28527a(r2, r3)     // Catch:{ Exception -> 0x0017 }
            return
        L_0x0017:
            com.inmobi.media.j r8 = r6.f4679b
            r8.mo28628b(r7, r1, r0)
            return
        L_0x001d:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0051 }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x0051 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ JSONException -> 0x0051 }
            r8.<init>()     // Catch:{ JSONException -> 0x0051 }
            java.util.Iterator r3 = r2.keys()     // Catch:{ JSONException -> 0x0051 }
        L_0x002b:
            boolean r4 = r3.hasNext()     // Catch:{ JSONException -> 0x0051 }
            if (r4 == 0) goto L_0x003f
            java.lang.Object r4 = r3.next()     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x0051 }
            java.lang.Object r5 = r2.get(r4)     // Catch:{ JSONException -> 0x0051 }
            r8.put(r4, r5)     // Catch:{ JSONException -> 0x0051 }
            goto L_0x002b
        L_0x003f:
            com.inmobi.media.j r2 = r6.f4679b     // Catch:{ Exception -> 0x004b }
            com.inmobi.media.j$a r2 = r2.getListener()     // Catch:{ Exception -> 0x004b }
            com.inmobi.media.j r3 = r6.f4679b     // Catch:{ Exception -> 0x004b }
            r2.mo28527a(r3, r8)     // Catch:{ Exception -> 0x004b }
            return
        L_0x004b:
            com.inmobi.media.j r8 = r6.f4679b     // Catch:{ JSONException -> 0x0051 }
            r8.mo28628b(r7, r1, r0)     // Catch:{ JSONException -> 0x0051 }
            return
        L_0x0051:
            com.inmobi.media.j r8 = r6.f4679b     // Catch:{ Exception -> 0x0062 }
            com.inmobi.media.j$a r8 = r8.getListener()     // Catch:{ Exception -> 0x0062 }
            com.inmobi.media.j r2 = r6.f4679b     // Catch:{ Exception -> 0x0062 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0062 }
            r3.<init>()     // Catch:{ Exception -> 0x0062 }
            r8.mo28527a(r2, r3)     // Catch:{ Exception -> 0x0062 }
            return
        L_0x0062:
            com.inmobi.media.j r8 = r6.f4679b
            r8.mo28628b(r7, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2243bw.incentCompleted(java.lang.String, java.lang.String):void");
    }

    @JavascriptInterface
    public String getOrientation(String str) {
        int b = C2528gq.m5395b();
        if (b == 1) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (b == 3) {
            return "90";
        }
        if (b == 2) {
            return "180";
        }
        return b == 4 ? "270" : "-1";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0037 */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveContent(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r10 = this;
            java.lang.String r0 = "saveContent"
            java.lang.String r1 = ""
            java.lang.String r2 = "\");"
            java.lang.String r3 = "\", 'failed', \""
            java.lang.String r4 = "reason"
            java.lang.String r5 = "sendSaveContentResult(\"saveContent_"
            java.lang.String r6 = "\\\""
            java.lang.String r7 = "\""
            java.lang.String r8 = "url"
            if (r12 == 0) goto L_0x008e
            int r9 = r12.length()
            if (r9 == 0) goto L_0x008e
            if (r13 == 0) goto L_0x008e
            int r9 = r13.length()
            if (r9 != 0) goto L_0x0023
            goto L_0x008e
        L_0x0023:
            com.inmobi.media.j r1 = r10.f4679b     // Catch:{ Exception -> 0x0086 }
            boolean r9 = r1.mo28634f(r0)     // Catch:{ Exception -> 0x0086 }
            if (r9 != 0) goto L_0x0058
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0086 }
            r9.<init>()     // Catch:{ Exception -> 0x0086 }
            r9.put(r8, r13)     // Catch:{ JSONException -> 0x0037 }
            r13 = 5
            r9.put(r4, r13)     // Catch:{ JSONException -> 0x0037 }
        L_0x0037:
            java.lang.String r13 = r9.toString()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r13 = r13.replace(r7, r6)     // Catch:{ Exception -> 0x0086 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0086 }
            r4.append(r12)     // Catch:{ Exception -> 0x0086 }
            r4.append(r3)     // Catch:{ Exception -> 0x0086 }
            r4.append(r13)     // Catch:{ Exception -> 0x0086 }
            r4.append(r2)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r12 = r4.toString()     // Catch:{ Exception -> 0x0086 }
            r1.mo28624a(r11, r12)     // Catch:{ Exception -> 0x0086 }
            return
        L_0x0058:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ Exception -> 0x0086 }
            r2.<init>()     // Catch:{ Exception -> 0x0086 }
            com.inmobi.media.av r3 = new com.inmobi.media.av     // Catch:{ Exception -> 0x0086 }
            r4 = -1
            r3.<init>(r4, r13)     // Catch:{ Exception -> 0x0086 }
            r2.add(r3)     // Catch:{ Exception -> 0x0086 }
            com.inmobi.media.ae r13 = new com.inmobi.media.ae     // Catch:{ Exception -> 0x0086 }
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0086 }
            com.inmobi.media.ap r1 = r1.f5817w     // Catch:{ Exception -> 0x0086 }
            r13.<init>(r3, r2, r1, r12)     // Catch:{ Exception -> 0x0086 }
            r13.f4358f = r11     // Catch:{ Exception -> 0x0086 }
            com.inmobi.media.ao r12 = com.inmobi.media.C2172ao.m4371a()     // Catch:{ Exception -> 0x0086 }
            java.util.concurrent.ExecutorService r1 = r12.f4415a     // Catch:{ Exception -> 0x0086 }
            com.inmobi.media.ao$3 r2 = new com.inmobi.media.ao$3     // Catch:{ Exception -> 0x0086 }
            r2.<init>(r13)     // Catch:{ Exception -> 0x0086 }
            r1.execute(r2)     // Catch:{ Exception -> 0x0086 }
            return
        L_0x0086:
            com.inmobi.media.j r12 = r10.f4679b
            java.lang.String r13 = "Unexpected error"
            r12.mo28628b(r11, r13, r0)
            return
        L_0x008e:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r13 != 0) goto L_0x0096
            r13 = r1
        L_0x0096:
            r0.put(r8, r13)     // Catch:{ JSONException -> 0x009d }
            r13 = 1
            r0.put(r4, r13)     // Catch:{ JSONException -> 0x009d }
        L_0x009d:
            java.lang.String r13 = r0.toString()
            java.lang.String r13 = r13.replace(r7, r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            if (r12 != 0) goto L_0x00ad
            r12 = r1
        L_0x00ad:
            r0.append(r12)
            r0.append(r3)
            r0.append(r13)
            r0.append(r2)
            java.lang.String r12 = r0.toString()
            com.inmobi.media.j r13 = r10.f4679b
            r13.mo28624a(r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2243bw.saveContent(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @JavascriptInterface
    public String isDeviceMuted(String str) {
        C2600j jVar = this.f4679b;
        if (jVar == null) {
            return "false";
        }
        boolean z = false;
        try {
            jVar.getMediaProcessor();
            z = C2265cb.m4593a();
        } catch (Exception unused) {
        }
        return String.valueOf(z);
    }

    @JavascriptInterface
    public String isHeadphonePlugged(String str) {
        C2600j jVar = this.f4679b;
        if (jVar == null) {
            return "false";
        }
        boolean z = false;
        try {
            jVar.getMediaProcessor();
            z = C2265cb.m4596d();
        } catch (Exception unused) {
        }
        return String.valueOf(z);
    }

    @JavascriptInterface
    public void registerDeviceMuteEventListener(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                C2265cb mediaProcessor = jVar.getMediaProcessor();
                Context c = C2505gd.m5298c();
                if (c != null && mediaProcessor.f4748c == null) {
                    mediaProcessor.f4748c = new C2270b(str);
                    c.registerReceiver(mediaProcessor.f4748c, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
                }
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "registerDeviceMuteEventListener");
            }
        }
    }

    @JavascriptInterface
    public void unregisterDeviceMuteEventListener(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                jVar.getMediaProcessor().mo28096b();
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "unRegisterDeviceMuteEventListener");
            }
        }
    }

    @JavascriptInterface
    public void registerDeviceVolumeChangeEventListener(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                C2265cb mediaProcessor = jVar.getMediaProcessor();
                Context c = C2505gd.m5298c();
                if (c != null && mediaProcessor.f4749d == null) {
                    mediaProcessor.f4749d = new C2271c(str, c, new Handler());
                    c.getContentResolver().registerContentObserver(System.CONTENT_URI, true, mediaProcessor.f4749d);
                }
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "registerDeviceVolumeChangeEventListener");
            }
        }
    }

    @JavascriptInterface
    public void unregisterDeviceVolumeChangeEventListener(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                jVar.getMediaProcessor().mo28097c();
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "unregisterDeviceVolumeChangeEventListener");
            }
        }
    }

    @JavascriptInterface
    public int getDeviceVolume(String str) {
        C2600j jVar = this.f4679b;
        if (jVar == null) {
            return -1;
        }
        try {
            C2265cb mediaProcessor = jVar.getMediaProcessor();
            Context c = C2505gd.m5298c();
            if (c == null) {
                return -1;
            }
            if (!mediaProcessor.f4746a.getRenderingConfig().f5225m || !C2505gd.m5305e()) {
                return ((AudioManager) c.getSystemService("audio")).getStreamVolume(3);
            }
            return 0;
        } catch (Exception unused) {
            this.f4679b.mo28628b(str, "Unexpected error", "getDeviceVolume");
            return -1;
        }
    }

    @JavascriptInterface
    public void registerHeadphonePluggedEventListener(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                C2265cb mediaProcessor = jVar.getMediaProcessor();
                Context c = C2505gd.m5298c();
                if (c != null && mediaProcessor.f4750e == null) {
                    mediaProcessor.f4750e = new C2269a(str);
                    c.registerReceiver(mediaProcessor.f4750e, new IntentFilter("android.intent.action.HEADSET_PLUG"));
                }
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "registerHeadphonePluggedEventListener");
            }
        }
    }

    @JavascriptInterface
    public void unregisterHeadphonePluggedEventListener(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                jVar.getMediaProcessor().mo28098e();
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "unregisterHeadphonePluggedEventListener");
            }
        }
    }

    @JavascriptInterface
    public void disableBackButton(String str, boolean z) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            jVar.setDisableBackButton(z);
        }
    }

    @JavascriptInterface
    public boolean isBackButtonDisabled(String str) {
        C2600j jVar = this.f4679b;
        if (jVar == null) {
            return false;
        }
        return jVar.f5809o;
    }

    @JavascriptInterface
    public void registerBackButtonPressedEventListener(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                jVar.f5810p = str;
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "registerBackButtonPressedEventListener");
            }
        }
    }

    @JavascriptInterface
    public void unregisterBackButtonPressedEventListener(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                jVar.f5810p = null;
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "unregisterBackButtonPressedEventListener");
            }
        }
    }

    @JavascriptInterface
    public void setCloseEndCardTracker(String str, String str2) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            try {
                jVar.setCloseEndCardTracker(str2);
            } catch (Exception unused) {
                this.f4679b.mo28628b(str, "Unexpected error", "getDownloadStatus");
            }
        }
    }

    @JavascriptInterface
    public void fireComplete(String str) {
        if (this.f4679b == null) {
        }
    }

    @JavascriptInterface
    public void showEndCard(String str) {
        C2600j jVar = this.f4679b;
        if (jVar != null) {
            C2452f referenceContainer = jVar.getReferenceContainer();
            if (referenceContainer instanceof C2542h) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        C2542h hVar = C2542h.this;
                        hVar.f5601p = true;
                        hVar.mo28495c((C2214bc) null);
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void saveBlob(String str, String str2) {
        C2600j jVar = this.f4679b;
        if (!(jVar == null || jVar.f5814t == null)) {
            jVar.f5814t.mo28749a(str2, jVar.f5813s);
        }
    }

    @JavascriptInterface
    public void getBlob(String str, String str2) {
        C2600j jVar = this.f4679b;
        if (!(jVar == null || jVar.f5814t == null)) {
            jVar.f5814t.mo28750a(str, str2, jVar, jVar.f5813s);
        }
    }
}
