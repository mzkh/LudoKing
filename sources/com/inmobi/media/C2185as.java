package com.inmobi.media;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.media.C2426eq.C2430d;
import com.inmobi.media.C2438es.C2441c;
import com.inmobi.media.C2490fv.C2491a;
import com.inmobi.media.C2519gm.C2523c;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.inmobi.media.as */
/* compiled from: ClickManager */
public class C2185as implements C2441c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4457a = "as";

    /* renamed from: b */
    private static ExecutorService f4458b;

    /* renamed from: c */
    private static C2194b f4459c;

    /* renamed from: d */
    private static HandlerThread f4460d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static List<C2183aq> f4461e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static C2184ar f4462f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static AtomicBoolean f4463g = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static C2430d f4464h;

    /* renamed from: i */
    private static final Object f4465i = new Object();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f4466j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C2203e f4467k = new C2203e() {
        /* renamed from: a */
        public final void mo27916a(C2183aq aqVar) {
            if (aqVar != null) {
                C2185as.f4457a;
                C2185as.f4462f;
                C2184ar.m4428a(aqVar);
            }
        }

        /* renamed from: b */
        public final void mo27917b(C2183aq aqVar) {
            if (aqVar != null) {
                C2185as.f4457a;
                C2185as.m4436a(aqVar);
                C2185as.this.mo27910b();
            }
        }
    };

    /* renamed from: com.inmobi.media.as$a */
    /* compiled from: ClickManager */
    static class C2193a {

        /* renamed from: a */
        static final C2185as f4483a = new C2185as();
    }

    /* renamed from: com.inmobi.media.as$b */
    /* compiled from: ClickManager */
    final class C2194b extends Handler {
        public C2194b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            Message message2 = message;
            try {
                int i = message2.what;
                int i2 = 3;
                if (i == 1) {
                    String str = null;
                    if (!((C2454fa) C2438es.m5087a("root", C2505gd.m5306f(), null)).f5304f) {
                        C2185as.f4462f;
                        int i3 = C2185as.f4464h.f5200e;
                        int i4 = C2185as.f4464h.f5197b;
                        ArrayList arrayList = new ArrayList();
                        C2493fx a = C2493fx.m5237a();
                        if (a.mo28426a(String.CLICK) != 0) {
                            if (-1 != i3) {
                                str = Integer.toString(i3);
                            }
                            String str2 = str;
                            StringBuilder sb = new StringBuilder("ts < ");
                            sb.append(System.currentTimeMillis() - ((long) i4));
                            C2493fx fxVar = a;
                            List<ContentValues> a2 = a.mo28429a(String.CLICK, C2184ar.f4455a, null, null, "ts", sb.toString(), "ts ASC ", str2);
                            fxVar.mo28434b();
                            for (ContentValues a3 : a2) {
                                arrayList.add(C2184ar.m4426a(a3));
                            }
                        }
                        C2185as.f4461e = arrayList;
                        if (C2185as.f4461e.isEmpty()) {
                            C2185as.f4462f;
                            if (C2184ar.m4429a()) {
                                C2185as.f4463g.set(false);
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            sendMessageDelayed(obtain, (long) (C2185as.f4464h.f5197b * 1000));
                            return;
                        }
                        C2183aq aqVar = (C2183aq) C2185as.f4461e.get(0);
                        Message obtain2 = Message.obtain();
                        obtain2.what = aqVar.f4453h ? 3 : 2;
                        obtain2.obj = aqVar;
                        long currentTimeMillis = System.currentTimeMillis() - aqVar.f4449d;
                        if (currentTimeMillis < ((long) (C2185as.f4464h.f5197b * 1000))) {
                            sendMessageDelayed(obtain2, ((long) (C2185as.f4464h.f5197b * 1000)) - currentTimeMillis);
                            return;
                        }
                        sendMessage(obtain2);
                    }
                } else if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            C2185as.f4457a;
                            int i5 = message2.what;
                        } else {
                            C2183aq aqVar2 = (C2183aq) message2.obj;
                            C2185as.f4457a;
                            C2185as.f4462f;
                            C2184ar.m4428a(aqVar2);
                            C2185as.f4461e.remove(aqVar2);
                            if (C2185as.f4461e.isEmpty()) {
                                C2185as.f4462f;
                                if (C2184ar.m4429a()) {
                                    C2185as.f4457a;
                                    C2185as.f4463g.set(false);
                                    return;
                                }
                                Message obtain3 = Message.obtain();
                                obtain3.what = 1;
                                sendMessage(obtain3);
                                return;
                            }
                            C2183aq aqVar3 = (C2183aq) C2185as.f4461e.get(0);
                            Message obtain4 = Message.obtain();
                            if (!aqVar3.f4453h) {
                                i2 = 2;
                            }
                            obtain4.what = i2;
                            obtain4.obj = aqVar3;
                            sendMessage(obtain4);
                        }
                    } else if (!C2515gi.m5353a()) {
                        C2185as.f4463g.set(false);
                        C2185as.m4446i();
                    } else {
                        C2183aq aqVar4 = (C2183aq) message2.obj;
                        if (aqVar4.f4451f != 0 && !aqVar4.mo27906a(C2185as.f4464h.f5201f)) {
                            if ((C2185as.f4464h.f5196a - aqVar4.f4451f) + 1 == 0) {
                                C2185as.f4457a;
                            } else {
                                C2185as.f4457a;
                            }
                            new C2197c(new C2203e() {
                                /* renamed from: a */
                                public final void mo27916a(C2183aq aqVar) {
                                    C2194b.m4456a(C2194b.this, aqVar);
                                }

                                /* renamed from: b */
                                public final void mo27917b(C2183aq aqVar) {
                                    C2185as.f4457a;
                                    C2185as.m4436a(aqVar);
                                    C2194b.m4457b(C2194b.this, aqVar);
                                }
                            }).mo27919a(aqVar4);
                        }
                    }
                } else if (!C2515gi.m5353a()) {
                    C2185as.f4463g.set(false);
                    C2185as.m4446i();
                } else {
                    C2183aq aqVar5 = (C2183aq) message2.obj;
                    if (aqVar5.f4451f != 0 && !aqVar5.mo27906a(C2185as.f4464h.f5201f)) {
                        if ((C2185as.f4464h.f5196a - aqVar5.f4451f) + 1 == 0) {
                            C2185as.f4457a;
                        } else {
                            C2185as.f4457a;
                        }
                        new C2202d(new C2203e() {
                            /* renamed from: a */
                            public final void mo27916a(C2183aq aqVar) {
                                C2194b.m4456a(C2194b.this, aqVar);
                            }

                            /* renamed from: b */
                            public final void mo27917b(C2183aq aqVar) {
                                C2185as.f4457a;
                                C2185as.m4436a(aqVar);
                                C2194b.m4457b(C2194b.this, aqVar);
                            }
                        }).mo27930a(aqVar5);
                    }
                }
            } catch (Exception unused) {
                C2185as.f4457a;
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m4456a(C2194b bVar, C2183aq aqVar) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = aqVar;
            bVar.sendMessage(obtain);
        }

        /* renamed from: b */
        static /* synthetic */ void m4457b(C2194b bVar, C2183aq aqVar) {
            int indexOf = C2185as.f4461e.indexOf(aqVar);
            if (-1 != indexOf) {
                C2183aq aqVar2 = (C2183aq) C2185as.f4461e.get(indexOf == C2185as.f4461e.size() + -1 ? 0 : indexOf + 1);
                Message obtain = Message.obtain();
                obtain.what = aqVar2.f4453h ? 3 : 2;
                obtain.obj = aqVar2;
                if (System.currentTimeMillis() - aqVar2.f4449d < ((long) (C2185as.f4464h.f5197b * 1000))) {
                    bVar.sendMessageDelayed(obtain, (long) (C2185as.f4464h.f5197b * 1000));
                    return;
                }
                bVar.sendMessage(obtain);
            }
        }
    }

    /* renamed from: com.inmobi.media.as$c */
    /* compiled from: ClickManager */
    static final class C2197c {

        /* renamed from: a */
        C2203e f4487a;

        public C2197c(C2203e eVar) {
            this.f4487a = eVar;
        }

        /* renamed from: a */
        public final void mo27919a(final C2183aq aqVar) {
            aqVar.f4452g.set(false);
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                public final void run() {
                    C2486fr frVar = new C2486fr("GET", aqVar.f4447b);
                    frVar.f5450v = false;
                    frVar.f5444p = false;
                    HashMap b = C2185as.m4440c(aqVar);
                    if (!b.isEmpty()) {
                        frVar.mo28407a((Map<String, String>) b);
                    }
                    C2490fv fvVar = new C2490fv(frVar, new WebViewClient() {

                        /* renamed from: a */
                        AtomicBoolean f4491a = new AtomicBoolean(false);

                        /* renamed from: b */
                        boolean f4492b;

                        /* renamed from: c */
                        boolean f4493c;

                        public final void onPageStarted(final WebView webView, String str, Bitmap bitmap) {
                            this.f4493c = true;
                            this.f4492b = false;
                            new Thread(new Runnable() {
                                public final void run() {
                                    try {
                                        Thread.sleep((long) (C2185as.f4464h.f5198c * 1000));
                                    } catch (InterruptedException unused) {
                                    }
                                    if (!C21991.this.f4491a.get()) {
                                        C2185as.f4457a;
                                        aqVar.f4452g.set(true);
                                        handler.post(new Runnable() {
                                            public final void run() {
                                                try {
                                                    C2491a aVar = (C2491a) webView;
                                                    if (aVar != null && !aVar.f5462a) {
                                                        webView.stopLoading();
                                                    }
                                                } catch (Throwable th) {
                                                    C2463fd.m5161a().mo28382a(new C2495fz(th));
                                                }
                                            }
                                        });
                                        C2197c.this.f4487a.mo27917b(aqVar);
                                    }
                                }
                            }).start();
                        }

                        public final void onPageFinished(WebView webView, String str) {
                            this.f4491a.set(true);
                            if (!this.f4492b && !aqVar.f4452g.get()) {
                                C2197c.this.f4487a.mo27916a(aqVar);
                            }
                        }

                        @TargetApi(22)
                        public final void onReceivedError(WebView webView, int i, String str, String str2) {
                            this.f4492b = true;
                            C2197c.this.f4487a.mo27917b(aqVar);
                        }

                        @TargetApi(23)
                        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                            this.f4492b = true;
                            C2197c.this.f4487a.mo27917b(aqVar);
                        }

                        @TargetApi(23)
                        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                            this.f4492b = true;
                            C2197c.this.f4487a.mo27917b(aqVar);
                        }

                        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                            return VERSION.SDK_INT >= 21 && !aqVar.f4454i && !webResourceRequest.getUrl().toString().equals(aqVar.f4447b);
                        }

                        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                            return !aqVar.f4454i && !str.equals(aqVar.f4447b);
                        }
                    });
                    try {
                        fvVar.f5461c = new C2491a(fvVar, C2505gd.m5298c());
                        fvVar.f5461c.setWebViewClient(fvVar.f5460b);
                        fvVar.f5461c.getSettings().setJavaScriptEnabled(true);
                        fvVar.f5461c.getSettings().setCacheMode(2);
                        fvVar.f5461c.loadUrl(fvVar.f5459a.mo28414g(), fvVar.f5459a.mo28413f());
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* renamed from: com.inmobi.media.as$d */
    /* compiled from: ClickManager */
    static final class C2202d {

        /* renamed from: a */
        private C2203e f4498a;

        public C2202d(C2203e eVar) {
            this.f4498a = eVar;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0068 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo27930a(com.inmobi.media.C2183aq r8) {
            /*
                r7 = this;
                com.inmobi.media.fr r0 = new com.inmobi.media.fr     // Catch:{ Exception -> 0x009d }
                java.lang.String r1 = "GET"
                java.lang.String r2 = r8.f4447b     // Catch:{ Exception -> 0x009d }
                r0.<init>(r1, r2)     // Catch:{ Exception -> 0x009d }
                java.util.HashMap r1 = com.inmobi.media.C2185as.m4440c(r8)     // Catch:{ Exception -> 0x009d }
                boolean r2 = r1.isEmpty()     // Catch:{ Exception -> 0x009d }
                if (r2 != 0) goto L_0x0016
                r0.mo28407a(r1)     // Catch:{ Exception -> 0x009d }
            L_0x0016:
                r1 = 0
                r0.f5450v = r1     // Catch:{ Exception -> 0x009d }
                r0.f5444p = r1     // Catch:{ Exception -> 0x009d }
                java.util.Map<java.lang.String, java.lang.String> r1 = r8.f4448c     // Catch:{ Exception -> 0x009d }
                r0.mo28409b(r1)     // Catch:{ Exception -> 0x009d }
                boolean r1 = r8.f4454i     // Catch:{ Exception -> 0x009d }
                r0.f5443o = r1     // Catch:{ Exception -> 0x009d }
                com.inmobi.media.eq$d r1 = com.inmobi.media.C2185as.f4464h     // Catch:{ Exception -> 0x009d }
                int r1 = r1.f5198c     // Catch:{ Exception -> 0x009d }
                int r1 = r1 * 1000
                r0.f5441m = r1     // Catch:{ Exception -> 0x009d }
                com.inmobi.media.eq$d r1 = com.inmobi.media.C2185as.f4464h     // Catch:{ Exception -> 0x009d }
                int r1 = r1.f5198c     // Catch:{ Exception -> 0x009d }
                int r1 = r1 * 1000
                r0.f5442n = r1     // Catch:{ Exception -> 0x009d }
                long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x009d }
                com.inmobi.media.ft r3 = new com.inmobi.media.ft     // Catch:{ Exception -> 0x009d }
                r3.<init>(r0)     // Catch:{ Exception -> 0x009d }
                com.inmobi.media.fs r3 = r3.mo28422a()     // Catch:{ Exception -> 0x009d }
                com.inmobi.media.hi r4 = com.inmobi.media.C2566hi.m5571a()     // Catch:{ Exception -> 0x0068 }
                long r5 = r0.mo28416i()     // Catch:{ Exception -> 0x0068 }
                r4.mo28564a(r5)     // Catch:{ Exception -> 0x0068 }
                com.inmobi.media.hi r0 = com.inmobi.media.C2566hi.m5571a()     // Catch:{ Exception -> 0x0068 }
                long r4 = r3.mo28421d()     // Catch:{ Exception -> 0x0068 }
                r0.mo28565b(r4)     // Catch:{ Exception -> 0x0068 }
                com.inmobi.media.hi r0 = com.inmobi.media.C2566hi.m5571a()     // Catch:{ Exception -> 0x0068 }
                long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0068 }
                long r4 = r4 - r1
                r0.mo28566c(r4)     // Catch:{ Exception -> 0x0068 }
                goto L_0x006b
            L_0x0068:
                com.inmobi.media.C2185as.f4457a     // Catch:{ Exception -> 0x009d }
            L_0x006b:
                boolean r0 = r3.mo28417a()     // Catch:{ Exception -> 0x009d }
                if (r0 == 0) goto L_0x0097
                com.inmobi.media.fq r0 = r3.f5452a     // Catch:{ Exception -> 0x009d }
                int r0 = r0.f5427a     // Catch:{ Exception -> 0x009d }
                r1 = -9
                if (r1 != r0) goto L_0x007f
                com.inmobi.media.as$e r0 = r7.f4498a     // Catch:{ Exception -> 0x009d }
                r0.mo27916a(r8)     // Catch:{ Exception -> 0x009d }
                return
            L_0x007f:
                boolean r1 = r8.f4454i     // Catch:{ Exception -> 0x009d }
                if (r1 != 0) goto L_0x0091
                r1 = 303(0x12f, float:4.25E-43)
                if (r1 == r0) goto L_0x008b
                r1 = 302(0x12e, float:4.23E-43)
                if (r1 != r0) goto L_0x0091
            L_0x008b:
                com.inmobi.media.as$e r0 = r7.f4498a     // Catch:{ Exception -> 0x009d }
                r0.mo27916a(r8)     // Catch:{ Exception -> 0x009d }
                return
            L_0x0091:
                com.inmobi.media.as$e r0 = r7.f4498a     // Catch:{ Exception -> 0x009d }
                r0.mo27917b(r8)     // Catch:{ Exception -> 0x009d }
                return
            L_0x0097:
                com.inmobi.media.as$e r0 = r7.f4498a     // Catch:{ Exception -> 0x009d }
                r0.mo27916a(r8)     // Catch:{ Exception -> 0x009d }
                return
            L_0x009d:
                com.inmobi.media.C2185as.f4457a
                com.inmobi.media.as$e r0 = r7.f4498a
                com.inmobi.media.fq r1 = new com.inmobi.media.fq
                r2 = -1
                java.lang.String r3 = "Unknown error"
                r1.<init>(r2, r3)
                r0.mo27917b(r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2185as.C2202d.mo27930a(com.inmobi.media.aq):void");
        }
    }

    /* renamed from: com.inmobi.media.as$e */
    /* compiled from: ClickManager */
    interface C2203e {
        /* renamed from: a */
        void mo27916a(C2183aq aqVar);

        /* renamed from: b */
        void mo27917b(C2183aq aqVar);
    }

    /* renamed from: a */
    public static C2185as m4434a() {
        return C2193a.f4483a;
    }

    /* renamed from: a */
    public void mo27896a(C2436er erVar) {
        f4464h = ((C2426eq) erVar).f5179f;
    }

    /* renamed from: b */
    public void mo27910b() {
        try {
            if (C2515gi.m5353a()) {
                synchronized (f4465i) {
                    if (f4463g.compareAndSet(false, true)) {
                        if (f4460d == null) {
                            HandlerThread handlerThread = new HandlerThread("pingHandlerThread");
                            f4460d = handlerThread;
                            handlerThread.start();
                        }
                        if (f4459c == null) {
                            f4459c = new C2194b(f4460d.getLooper());
                        }
                        if (C2184ar.m4429a()) {
                            f4463g.set(false);
                            m4446i();
                        } else {
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            f4459c.sendMessage(obtain);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo27909a(final String str, final boolean z) {
        new Thread() {
            public final void run() {
                try {
                    if (!((C2454fa) C2438es.m5087a("root", C2505gd.m5306f(), null)).f5304f) {
                        C2183aq aqVar = new C2183aq(str, z, false, C2185as.f4464h.f5196a + 1);
                        C2185as.f4457a;
                        C2185as.m4437a(C2185as.this, aqVar);
                    }
                } catch (Exception unused) {
                    C2185as.f4457a;
                }
            }
        }.start();
    }

    /* renamed from: a */
    public void mo27908a(final String str, final Map<String, String> map, final boolean z) {
        new Thread() {
            public final void run() {
                try {
                    if (!((C2454fa) C2438es.m5087a("root", C2505gd.m5306f(), null)).f5304f) {
                        C2183aq aqVar = new C2183aq(str, map, z, C2185as.f4464h.f5196a + 1);
                        C2185as.f4457a;
                        C2185as.m4437a(C2185as.this, aqVar);
                    }
                } catch (Exception e) {
                    C2185as.f4457a;
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
        }.start();
    }

    /* renamed from: b */
    public void mo27911b(final String str, final boolean z) {
        new Thread() {
            public final void run() {
                try {
                    if (!((C2454fa) C2438es.m5087a("root", C2505gd.m5306f(), null)).f5304f) {
                        C2183aq aqVar = new C2183aq(str, z, true, C2185as.f4464h.f5196a + 1);
                        C2185as.f4457a;
                        C2185as.m4437a(C2185as.this, aqVar);
                    }
                } catch (Exception unused) {
                    C2185as.f4457a;
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static void m4446i() {
        try {
            f4463g.set(false);
            synchronized (f4465i) {
                if (!f4463g.get() && f4460d != null) {
                    f4460d.getLooper().quit();
                    f4460d.interrupt();
                    f4460d = null;
                    f4459c = null;
                }
            }
        } catch (Exception unused) {
        }
    }

    public C2185as() {
        try {
            f4458b = Executors.newFixedThreadPool(5);
            HandlerThread handlerThread = new HandlerThread("pingHandlerThread");
            f4460d = handlerThread;
            handlerThread.start();
            f4459c = new C2194b(f4460d.getLooper());
            f4464h = ((C2426eq) C2438es.m5087a("ads", C2505gd.m5306f(), this)).f5179f;
            f4462f = new C2184ar();
            C2519gm.m5364a().mo28470a((C2523c) new C2523c() {
                /* renamed from: a */
                public final void mo27900a(boolean z) {
                    if (z) {
                        C2185as.this.mo27910b();
                    }
                }
            });
            if (VERSION.SDK_INT >= 23) {
                C2519gm.m5364a().mo28471a("android.os.action.DEVICE_IDLE_MODE_CHANGED", (C2523c) new C2523c() {
                    /* renamed from: a */
                    public final void mo27900a(boolean z) {
                        if (!z) {
                            C2185as.this.mo27910b();
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static HashMap<String, String> m4440c(C2183aq aqVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            int i = (f4464h.f5196a - aqVar.f4451f) + 1;
            if (i > 0) {
                hashMap.put("X-im-retry-count", String.valueOf(i));
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    /* renamed from: a */
    static /* synthetic */ void m4437a(C2185as asVar, final C2183aq aqVar) {
        f4462f.mo27907a(aqVar, f4464h.f5199d);
        if (!C2515gi.m5353a()) {
            f4463g.set(false);
            m4446i();
            return;
        }
        f4458b.submit(new Runnable() {
            public final void run() {
                C2185as.this.f4466j = SystemClock.elapsedRealtime();
                if (aqVar.f4453h) {
                    new C2197c(C2185as.this.f4467k).mo27919a(aqVar);
                } else {
                    new C2202d(C2185as.this.f4467k).mo27930a(aqVar);
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m4436a(C2183aq aqVar) {
        if (aqVar.f4451f > 0) {
            aqVar.f4451f--;
            aqVar.f4449d = System.currentTimeMillis();
            C2493fx a = C2493fx.m5237a();
            String[] strArr = {String.valueOf(aqVar.f4446a)};
            a.mo28432b(String.CLICK, C2184ar.m4430b(aqVar), "id = ?", strArr);
            a.mo28434b();
        }
    }
}
