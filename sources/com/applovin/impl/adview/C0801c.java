package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.applovin.impl.p005a.C0769a;
import com.applovin.impl.p005a.C0774b;
import com.applovin.impl.p005a.C0777e;
import com.applovin.impl.p005a.C0777e.C0778a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1078a;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p018ad.C1088h;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1108d;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAd;
import com.appsflyer.share.Constants;

/* renamed from: com.applovin.impl.adview.c */
class C0801c extends C0825g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1227o f1372a;

    /* renamed from: b */
    private final C1192i f1373b;

    /* renamed from: c */
    private C1108d f1374c;

    /* renamed from: d */
    private AppLovinAd f1375d = null;

    /* renamed from: e */
    private boolean f1376e = false;

    C0801c(C0821d dVar, C1192i iVar, Context context) {
        super(context);
        if (iVar != null) {
            this.f1373b = iVar;
            this.f1372a = iVar.mo10249v();
            setBackgroundColor(0);
            WebSettings settings = getSettings();
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptEnabled(true);
            setWebViewClient(dVar);
            setWebChromeClient(new C0800b(iVar));
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            if (C1245f.m2938i()) {
                setWebViewRenderProcessClient(new C0822e(iVar));
            }
            setOnTouchListener(new OnTouchListener() {
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!view.hasFocus()) {
                        view.requestFocus();
                    }
                    return false;
                }
            });
            setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View view) {
                    C0801c.this.f1372a.mo10378b("AdWebView", "Received a LongClick event.");
                    return true;
                }
            });
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    /* renamed from: a */
    private String m1147a(String str, String str2) {
        if (C1277l.m3042b(str)) {
            return C1281o.m3098b(str).replace("{SOURCE}", str2);
        }
        return null;
    }

    /* renamed from: a */
    private void m1148a(final C1084f fVar) {
        try {
            if (((Boolean) this.f1373b.mo10202a(C1096c.f2513eS)).booleanValue() || fVar.mo9910ap()) {
                m1149a((Runnable) new Runnable() {
                    public void run() {
                        C0801c.this.loadUrl("about:blank");
                    }
                });
            }
            if (C1245f.m2933d()) {
                m1149a((Runnable) new Runnable() {
                    @TargetApi(17)
                    public void run() {
                        C0801c.this.getSettings().setMediaPlaybackRequiresUserGesture(fVar.mo9909ao());
                    }
                });
            }
            if (C1245f.m2934e() && fVar.mo9912ar()) {
                m1149a((Runnable) new Runnable() {
                    @TargetApi(19)
                    public void run() {
                        WebView.setWebContentsDebuggingEnabled(true);
                    }
                });
            }
            C0894w as = fVar.mo9913as();
            if (as != null) {
                final WebSettings settings = getSettings();
                final PluginState b = as.mo9226b();
                if (b != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setPluginState(b);
                        }
                    });
                }
                final Boolean c = as.mo9227c();
                if (c != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setAllowFileAccess(c.booleanValue());
                        }
                    });
                }
                final Boolean d = as.mo9228d();
                if (d != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setLoadWithOverviewMode(d.booleanValue());
                        }
                    });
                }
                final Boolean e = as.mo9229e();
                if (e != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setUseWideViewPort(e.booleanValue());
                        }
                    });
                }
                final Boolean f = as.mo9230f();
                if (f != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setAllowContentAccess(f.booleanValue());
                        }
                    });
                }
                final Boolean g = as.mo9231g();
                if (g != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setBuiltInZoomControls(g.booleanValue());
                        }
                    });
                }
                final Boolean h = as.mo9232h();
                if (h != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setDisplayZoomControls(h.booleanValue());
                        }
                    });
                }
                final Boolean i = as.mo9233i();
                if (i != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setSaveFormData(i.booleanValue());
                        }
                    });
                }
                final Boolean j = as.mo9234j();
                if (j != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setGeolocationEnabled(j.booleanValue());
                        }
                    });
                }
                final Boolean k = as.mo9235k();
                if (k != null) {
                    m1149a((Runnable) new Runnable() {
                        public void run() {
                            settings.setNeedInitialFocus(k.booleanValue());
                        }
                    });
                }
                if (C1245f.m2932c()) {
                    final Boolean l = as.mo9236l();
                    if (l != null) {
                        m1149a((Runnable) new Runnable() {
                            @TargetApi(16)
                            public void run() {
                                settings.setAllowFileAccessFromFileURLs(l.booleanValue());
                            }
                        });
                    }
                    final Boolean m = as.mo9237m();
                    if (m != null) {
                        m1149a((Runnable) new Runnable() {
                            @TargetApi(16)
                            public void run() {
                                settings.setAllowUniversalAccessFromFileURLs(m.booleanValue());
                            }
                        });
                    }
                }
                if (C1245f.m2935f()) {
                    final Integer a = as.mo9225a();
                    if (a != null) {
                        m1149a((Runnable) new Runnable() {
                            @TargetApi(21)
                            public void run() {
                                settings.setMixedContentMode(a.intValue());
                            }
                        });
                    }
                }
                if (C1245f.m2936g()) {
                    final Boolean n = as.mo9238n();
                    if (n != null) {
                        m1149a((Runnable) new Runnable() {
                            @TargetApi(23)
                            public void run() {
                                settings.setOffscreenPreRaster(n.booleanValue());
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            this.f1372a.mo10379b("AdWebView", "Unable to apply WebView settings", th);
        }
    }

    /* renamed from: a */
    private void m1149a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.f1372a.mo10379b("AdWebView", "Unable to apply WebView setting", th);
        }
    }

    /* renamed from: a */
    private void m1150a(String str, String str2, String str3, C1192i iVar) {
        String a = m1147a(str3, str);
        String str4 = "Rendering webview for VAST ad with resourceContents : ";
        String str5 = "AdWebView";
        if (C1277l.m3042b(a)) {
            C1227o oVar = this.f1372a;
            StringBuilder sb = new StringBuilder();
            sb.append(str4);
            sb.append(a);
            oVar.mo10378b(str5, sb.toString());
            loadDataWithBaseURL(str2, a, "text/html", null, "");
            return;
        }
        String a2 = m1147a((String) iVar.mo10202a(C1096c.f2497eC), str);
        if (C1277l.m3042b(a2)) {
            C1227o oVar2 = this.f1372a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append(a2);
            oVar2.mo10378b(str5, sb2.toString());
            loadDataWithBaseURL(str2, a2, "text/html", null, "");
            return;
        }
        C1227o oVar3 = this.f1372a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Rendering webview for VAST ad with resourceURL : ");
        sb3.append(str);
        oVar3.mo10378b(str5, sb3.toString());
        loadUrl(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public AppLovinAd mo9002a() {
        return this.f1375d;
    }

    /* renamed from: a */
    public void mo9003a(C1108d dVar) {
        this.f1374c = dVar;
    }

    /* renamed from: a */
    public void mo9004a(AppLovinAd appLovinAd) {
        C1227o oVar;
        String str;
        C1227o oVar2;
        String str2;
        String str3;
        String aq;
        String str4;
        String str5;
        String str6;
        String aq2;
        C1192i iVar;
        String str7 = "AdWebView";
        if (!this.f1376e) {
            this.f1375d = appLovinAd;
            try {
                if (appLovinAd instanceof C1088h) {
                    loadDataWithBaseURL(Constants.URL_PATH_DELIMITER, ((C1088h) appLovinAd).mo9941a(), "text/html", null, "");
                    oVar = this.f1372a;
                    str = "Empty ad rendered";
                } else {
                    C1084f fVar = (C1084f) appLovinAd;
                    m1148a(fVar);
                    if (fVar.mo9901af()) {
                        setVisibility(0);
                    }
                    if (appLovinAd instanceof C1078a) {
                        loadDataWithBaseURL(fVar.mo9911aq(), C1281o.m3098b(((C1078a) appLovinAd).mo8878a()), "text/html", null, "");
                        oVar = this.f1372a;
                        str = "AppLovinAd rendered";
                    } else if (appLovinAd instanceof C0769a) {
                        C0769a aVar = (C0769a) appLovinAd;
                        C0774b j = aVar.mo8896j();
                        if (j != null) {
                            C0777e b = j.mo8914b();
                            Uri b2 = b.mo8933b();
                            String uri = b2 != null ? b2.toString() : "";
                            String c = b.mo8934c();
                            String aD = aVar.mo8879aD();
                            if (!C1277l.m3042b(uri)) {
                                if (!C1277l.m3042b(c)) {
                                    oVar2 = this.f1372a;
                                    str2 = "Unable to load companion ad. No resources provided.";
                                    oVar2.mo10382e(str7, str2);
                                    return;
                                }
                            }
                            if (b.mo8930a() == C0778a.STATIC) {
                                this.f1372a.mo10378b(str7, "Rendering WebView for static VAST ad");
                                loadDataWithBaseURL(fVar.mo9911aq(), m1147a((String) this.f1373b.mo10202a(C1096c.f2496eB), uri), "text/html", null, "");
                                return;
                            }
                            if (b.mo8930a() == C0778a.HTML) {
                                if (C1277l.m3042b(c)) {
                                    String a = m1147a(aD, c);
                                    str3 = C1277l.m3042b(a) ? a : c;
                                    C1227o oVar3 = this.f1372a;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Rendering WebView for HTML VAST ad with resourceContents: ");
                                    sb.append(str3);
                                    oVar3.mo10378b(str7, sb.toString());
                                    aq = fVar.mo9911aq();
                                    str4 = "text/html";
                                    str5 = null;
                                    str6 = "";
                                } else if (C1277l.m3042b(uri)) {
                                    this.f1372a.mo10378b(str7, "Preparing to load HTML VAST ad resourceUri");
                                    aq2 = fVar.mo9911aq();
                                    iVar = this.f1373b;
                                    m1150a(uri, aq2, aD, iVar);
                                    return;
                                } else {
                                    return;
                                }
                            } else if (b.mo8930a() != C0778a.IFRAME) {
                                oVar2 = this.f1372a;
                                str2 = "Failed to render VAST companion ad of invalid type";
                                oVar2.mo10382e(str7, str2);
                                return;
                            } else if (C1277l.m3042b(uri)) {
                                this.f1372a.mo10378b(str7, "Preparing to load iFrame VAST ad resourceUri");
                                aq2 = fVar.mo9911aq();
                                iVar = this.f1373b;
                                m1150a(uri, aq2, aD, iVar);
                                return;
                            } else if (C1277l.m3042b(c)) {
                                String a2 = m1147a(aD, c);
                                str3 = C1277l.m3042b(a2) ? a2 : c;
                                C1227o oVar4 = this.f1372a;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Rendering WebView for iFrame VAST ad with resourceContents: ");
                                sb2.append(str3);
                                oVar4.mo10378b(str7, sb2.toString());
                                aq = fVar.mo9911aq();
                                str4 = "text/html";
                                str5 = null;
                                str6 = "";
                            } else {
                                return;
                            }
                            loadDataWithBaseURL(aq, str3, str4, str5, str6);
                            return;
                        }
                        oVar = this.f1372a;
                        str = "No companion ad provided.";
                    } else {
                        return;
                    }
                }
                oVar.mo10378b(str7, str);
            } catch (Throwable th) {
                this.f1372a.mo10379b(str7, "Unable to render AppLovinAd", th);
            }
        } else {
            C1227o.m2841i(str7, "Ad can not be loaded in a destroyed webview");
        }
    }

    /* renamed from: a */
    public void mo9005a(String str) {
        mo9006a(str, (Runnable) null);
    }

    /* renamed from: a */
    public void mo9006a(String str, Runnable runnable) {
        String str2 = "AdWebView";
        try {
            C1227o oVar = this.f1372a;
            StringBuilder sb = new StringBuilder();
            sb.append("Forwarding \"");
            sb.append(str);
            sb.append("\" to ad template");
            oVar.mo10378b(str2, sb.toString());
            loadUrl(str);
        } catch (Throwable th) {
            this.f1372a.mo10379b(str2, "Unable to forward to template", th);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: b */
    public C1108d mo9007b() {
        return this.f1374c;
    }

    public void computeScroll() {
    }

    public void destroy() {
        String str = "AdWebView";
        this.f1376e = true;
        try {
            super.destroy();
            this.f1372a.mo10378b(str, "Web view destroyed");
        } catch (Throwable th) {
            C1227o oVar = this.f1372a;
            if (oVar != null) {
                oVar.mo10379b(str, "destroy() threw exception", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Exception e) {
            this.f1372a.mo10379b("AdWebView", "onFocusChanged() threw exception", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (Exception e) {
            this.f1372a.mo10379b("AdWebView", "onWindowFocusChanged() threw exception", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        try {
            super.onWindowVisibilityChanged(i);
        } catch (Exception e) {
            this.f1372a.mo10379b("AdWebView", "onWindowVisibilityChanged() threw exception", e);
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        try {
            return super.requestFocus(i, rect);
        } catch (Exception e) {
            this.f1372a.mo10379b("AdWebView", "requestFocus() threw exception", e);
            return false;
        }
    }

    public void scrollTo(int i, int i2) {
    }
}
