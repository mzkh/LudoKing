package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AdViewController;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1078a;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p018ad.C1084f.C1085a;
import com.applovin.impl.sdk.p018ad.C1088h;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1108d;
import com.applovin.impl.sdk.utils.C1240b;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.appsflyer.share.Constants;
import java.util.concurrent.atomic.AtomicReference;

public class AdViewControllerImpl implements AdViewController {

    /* renamed from: A */
    private volatile AppLovinAdClickListener f1317A;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f1318a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ViewGroup f1319b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C1192i f1320c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppLovinAdServiceImpl f1321d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1227o f1322e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AppLovinAdSize f1323f;

    /* renamed from: g */
    private String f1324g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1108d f1325h;

    /* renamed from: i */
    private C0821d f1326i;

    /* renamed from: j */
    private C0798d f1327j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C0801c f1328k;

    /* renamed from: l */
    private AppLovinAd f1329l;

    /* renamed from: m */
    private Runnable f1330m;

    /* renamed from: n */
    private Runnable f1331n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public volatile AppLovinAd f1332o = null;

    /* renamed from: p */
    private volatile AppLovinAd f1333p = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public C0833k f1334q = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public C0833k f1335r = null;

    /* renamed from: s */
    private final AtomicReference<AppLovinAd> f1336s = new AtomicReference<>();

    /* renamed from: t */
    private volatile boolean f1337t = false;

    /* renamed from: u */
    private volatile boolean f1338u = true;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public volatile boolean f1339v = false;

    /* renamed from: w */
    private volatile boolean f1340w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public volatile AppLovinAdLoadListener f1341x;

    /* renamed from: y */
    private volatile AppLovinAdDisplayListener f1342y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public volatile AppLovinAdViewEventListener f1343z;

    /* renamed from: com.applovin.impl.adview.AdViewControllerImpl$a */
    private class C0795a implements Runnable {
        private C0795a() {
        }

        public void run() {
            if (AdViewControllerImpl.this.f1328k != null) {
                AdViewControllerImpl.this.f1328k.setVisibility(8);
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.AdViewControllerImpl$b */
    private class C0796b implements Runnable {
        private C0796b() {
        }

        public void run() {
            if (AdViewControllerImpl.this.f1328k != null) {
                try {
                    AdViewControllerImpl.this.f1328k.loadDataWithBaseURL(Constants.URL_PATH_DELIMITER, "<html></html>", "text/html", null, "");
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.AdViewControllerImpl$c */
    private class C0797c implements Runnable {
        private C0797c() {
        }

        public void run() {
            if (AdViewControllerImpl.this.f1332o != null) {
                String str = "AppLovinAdView";
                if (AdViewControllerImpl.this.f1328k != null) {
                    C1227o b = AdViewControllerImpl.this.f1322e;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Rendering advertisement ad for #");
                    sb.append(AdViewControllerImpl.this.f1332o.getAdIdNumber());
                    sb.append("...");
                    b.mo10378b(str, sb.toString());
                    AdViewControllerImpl.m1120b((View) AdViewControllerImpl.this.f1328k, AdViewControllerImpl.this.f1332o.getSize());
                    AdViewControllerImpl.this.f1328k.mo9004a(AdViewControllerImpl.this.f1332o);
                    if (AdViewControllerImpl.this.f1332o.getSize() != AppLovinAdSize.INTERSTITIAL && !AdViewControllerImpl.this.f1339v && (AdViewControllerImpl.this.f1332o instanceof C1084f)) {
                        C1084f fVar = (C1084f) AdViewControllerImpl.this.f1332o;
                        AdViewControllerImpl adViewControllerImpl = AdViewControllerImpl.this;
                        adViewControllerImpl.f1325h = new C1108d(fVar, adViewControllerImpl.f1320c);
                        AdViewControllerImpl.this.f1325h.mo10005a();
                        AdViewControllerImpl.this.f1328k.mo9003a(AdViewControllerImpl.this.f1325h);
                        fVar.setHasShown(true);
                    }
                    if (AdViewControllerImpl.this.f1328k.mo9007b() != null && (AdViewControllerImpl.this.f1332o instanceof C1084f)) {
                        AdViewControllerImpl.this.f1328k.mo9007b().mo10006a(((C1084f) AdViewControllerImpl.this.f1332o).mo9930r() ? 0 : 1);
                        return;
                    }
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to render advertisement for ad #");
                sb2.append(AdViewControllerImpl.this.f1332o.getAdIdNumber());
                sb2.append(". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
                C1227o.m2841i(str, sb2.toString());
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.AdViewControllerImpl$d */
    static class C0798d implements AppLovinAdLoadListener {

        /* renamed from: a */
        private final AppLovinAdService f1357a;

        /* renamed from: b */
        private final C1227o f1358b;

        /* renamed from: c */
        private final AdViewControllerImpl f1359c;

        C0798d(AdViewControllerImpl adViewControllerImpl, C1192i iVar) {
            if (adViewControllerImpl == null) {
                throw new IllegalArgumentException("No view specified");
            } else if (iVar != null) {
                this.f1358b = iVar.mo10249v();
                this.f1357a = iVar.mo10241o();
                this.f1359c = adViewControllerImpl;
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        /* renamed from: a */
        private AdViewControllerImpl m1141a() {
            return this.f1359c;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            AdViewControllerImpl a = m1141a();
            if (a != null) {
                a.mo8969a(appLovinAd);
            } else {
                C1227o.m2841i("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        public void failedToReceiveAd(int i) {
            AdViewControllerImpl a = m1141a();
            if (a != null) {
                a.mo8968a(i);
            }
        }
    }

    /* renamed from: a */
    private void m1113a(AppLovinAdView appLovinAdView, C1192i iVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (iVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize != null) {
            this.f1320c = iVar;
            this.f1321d = iVar.mo10241o();
            this.f1322e = iVar.mo10249v();
            this.f1323f = appLovinAdSize;
            this.f1324g = str;
            this.f1318a = context;
            this.f1319b = appLovinAdView;
            this.f1329l = new C1088h();
            this.f1326i = new C0821d(this, iVar);
            this.f1331n = new C0795a();
            this.f1330m = new C0797c();
            this.f1327j = new C0798d(this, iVar);
            m1115a(appLovinAdSize);
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1115a(AppLovinAdSize appLovinAdSize) {
        try {
            this.f1328k = new C0801c(this.f1326i, this.f1320c, this.f1318a);
            this.f1328k.setBackgroundColor(0);
            this.f1328k.setWillNotCacheDrawing(false);
            this.f1319b.setBackgroundColor(0);
            this.f1319b.addView(this.f1328k);
            m1120b((View) this.f1328k, appLovinAdSize);
            if (!this.f1337t) {
                m1116a(this.f1331n);
            }
            if (((Boolean) this.f1320c.mo10202a(C1096c.f2516eV)).booleanValue()) {
                m1116a((Runnable) new C0796b());
            }
            this.f1337t = true;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to create AdView: ");
            sb.append(th.getMessage());
            C1227o.m2841i("AppLovinAdView", sb.toString());
        }
    }

    /* renamed from: a */
    private void m1116a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* renamed from: b */
    private void m1119b() {
        C1227o oVar = this.f1322e;
        String str = "AppLovinAdView";
        if (oVar != null) {
            oVar.mo10378b(str, "Destroying...");
        }
        C0801c cVar = this.f1328k;
        if (cVar != null) {
            try {
                ViewParent parent = cVar.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f1328k);
                }
                this.f1328k.removeAllViews();
                if (((Boolean) this.f1320c.mo10202a(C1096c.f2512eR)).booleanValue()) {
                    this.f1328k.loadUrl("about:blank");
                    this.f1328k.onPause();
                    this.f1328k.destroyDrawingCache();
                }
            } catch (Throwable th) {
                this.f1322e.mo10377a(str, "Unable to destroy ad view", th);
            }
            this.f1328k.destroy();
            this.f1328k = null;
        }
        this.f1339v = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m1120b(View view, AppLovinAdSize appLovinAdSize) {
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            int i = -1;
            int i2 = appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
            if (!appLovinAdSize.getLabel().equals(AppLovinAdSize.INTERSTITIAL.getLabel())) {
                i = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
            }
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.width = i2;
            layoutParams.height = i;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: c */
    private void m1122c() {
        m1116a((Runnable) new Runnable() {
            public void run() {
                if (AdViewControllerImpl.this.f1334q != null) {
                    C1227o b = AdViewControllerImpl.this.f1322e;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Detaching expanded ad: ");
                    sb.append(AdViewControllerImpl.this.f1334q.mo9094a());
                    b.mo10378b("AppLovinAdView", sb.toString());
                    AdViewControllerImpl adViewControllerImpl = AdViewControllerImpl.this;
                    adViewControllerImpl.f1335r = adViewControllerImpl.f1334q;
                    AdViewControllerImpl.this.f1334q = null;
                    AdViewControllerImpl adViewControllerImpl2 = AdViewControllerImpl.this;
                    adViewControllerImpl2.m1115a(adViewControllerImpl2.f1323f);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1124d() {
        m1116a((Runnable) new Runnable() {
            public void run() {
                C1078a aVar;
                if (AdViewControllerImpl.this.f1335r != null || AdViewControllerImpl.this.f1334q != null) {
                    if (AdViewControllerImpl.this.f1335r != null) {
                        aVar = AdViewControllerImpl.this.f1335r.mo9094a();
                        AdViewControllerImpl.this.f1335r.dismiss();
                        AdViewControllerImpl.this.f1335r = null;
                    } else {
                        aVar = AdViewControllerImpl.this.f1334q.mo9094a();
                        AdViewControllerImpl.this.f1334q.dismiss();
                        AdViewControllerImpl.this.f1334q = null;
                    }
                    C1248i.m3008b(AdViewControllerImpl.this.f1343z, (AppLovinAd) aVar, (AppLovinAdView) AdViewControllerImpl.this.f1319b);
                }
            }
        });
    }

    /* renamed from: e */
    private void m1126e() {
        C1108d dVar = this.f1325h;
        if (dVar != null) {
            dVar.mo10009c();
            this.f1325h = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8967a() {
        if (this.f1334q == null && this.f1335r == null) {
            C1227o oVar = this.f1322e;
            StringBuilder sb = new StringBuilder();
            sb.append("Ad: ");
            sb.append(this.f1332o);
            sb.append(" closed.");
            oVar.mo10378b("AppLovinAdView", sb.toString());
            m1116a(this.f1331n);
            C1248i.m3010b(this.f1342y, this.f1332o);
            this.f1332o = null;
        } else if (((Boolean) this.f1320c.mo10202a(C1096c.f2434cr)).booleanValue()) {
            contractAd();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8968a(final int i) {
        if (!this.f1339v) {
            m1116a(this.f1331n);
        }
        m1116a((Runnable) new Runnable() {
            public void run() {
                try {
                    if (AdViewControllerImpl.this.f1341x != null) {
                        AdViewControllerImpl.this.f1341x.failedToReceiveAd(i);
                    }
                } catch (Throwable th) {
                    C1227o.m2837c("AppLovinAdView", "Exception while running app load  callback", th);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8969a(final AppLovinAd appLovinAd) {
        String str = "AppLovinAdView";
        if (appLovinAd != null) {
            this.f1340w = true;
            if (!this.f1339v) {
                renderAd(appLovinAd);
            } else {
                this.f1336s.set(appLovinAd);
                this.f1322e.mo10378b(str, "Ad view has paused when an ad was received, ad saved for later");
            }
            m1116a((Runnable) new Runnable() {
                public void run() {
                    try {
                        if (AdViewControllerImpl.this.f1341x != null) {
                            AdViewControllerImpl.this.f1341x.adReceived(appLovinAd);
                        }
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Exception while running ad load callback: ");
                        sb.append(th.getMessage());
                        C1227o.m2841i("AppLovinAdView", sb.toString());
                    }
                }
            });
            return;
        }
        this.f1322e.mo10382e(str, "No provided when to the view controller");
        mo8968a(-1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8970a(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        String str;
        C1227o oVar;
        C1248i.m2998a(this.f1317A, appLovinAd);
        String str2 = "AppLovinAdView";
        if (appLovinAdView == null) {
            oVar = this.f1322e;
            str = "Unable to process ad click - AppLovinAdView destroyed prematurely";
        } else if (appLovinAd instanceof C1084f) {
            this.f1321d.trackAndLaunchClick(appLovinAd, appLovinAdView, this, uri, pointF);
            return;
        } else {
            oVar = this.f1322e;
            str = "Unable to process ad click - EmptyAd is not supported.";
        }
        oVar.mo10382e(str2, str);
    }

    public void contractAd() {
        m1116a((Runnable) new Runnable() {
            public void run() {
                AdViewControllerImpl.this.m1124d();
                if (AdViewControllerImpl.this.f1319b != null && AdViewControllerImpl.this.f1328k != null && AdViewControllerImpl.this.f1328k.getParent() == null) {
                    AdViewControllerImpl.this.f1319b.addView(AdViewControllerImpl.this.f1328k);
                    AdViewControllerImpl.m1120b((View) AdViewControllerImpl.this.f1328k, AdViewControllerImpl.this.f1332o.getSize());
                }
            }
        });
    }

    public void destroy() {
        if (!(this.f1328k == null || this.f1334q == null)) {
            contractAd();
        }
        m1119b();
    }

    public void dismissInterstitialIfRequired() {
        if ((this.f1318a instanceof C0842m) && (this.f1332o instanceof C1084f)) {
            C0842m mVar = (C0842m) this.f1318a;
            if ((((C1084f) this.f1332o).mo9867E() == C1085a.DISMISS) && mVar.getPoststitialWasDisplayed()) {
                mVar.dismiss();
            }
        }
    }

    public void expandAd(final PointF pointF) {
        m1116a((Runnable) new Runnable() {
            public void run() {
                if (AdViewControllerImpl.this.f1334q == null && (AdViewControllerImpl.this.f1332o instanceof C1078a) && AdViewControllerImpl.this.f1328k != null) {
                    C1078a aVar = (C1078a) AdViewControllerImpl.this.f1332o;
                    Activity a = AdViewControllerImpl.this.f1318a instanceof Activity ? (Activity) AdViewControllerImpl.this.f1318a : C1281o.m3065a((View) AdViewControllerImpl.this.f1328k, AdViewControllerImpl.this.f1320c);
                    if (a != null) {
                        if (AdViewControllerImpl.this.f1319b != null) {
                            AdViewControllerImpl.this.f1319b.removeView(AdViewControllerImpl.this.f1328k);
                        }
                        AdViewControllerImpl adViewControllerImpl = AdViewControllerImpl.this;
                        adViewControllerImpl.f1334q = new C0833k(aVar, adViewControllerImpl.f1328k, a, AdViewControllerImpl.this.f1320c);
                        AdViewControllerImpl.this.f1334q.setOnDismissListener(new OnDismissListener() {
                            public void onDismiss(DialogInterface dialogInterface) {
                                AdViewControllerImpl.this.contractAd();
                            }
                        });
                        AdViewControllerImpl.this.f1334q.show();
                        C1248i.m2993a(AdViewControllerImpl.this.f1343z, AdViewControllerImpl.this.f1332o, (AppLovinAdView) AdViewControllerImpl.this.f1319b);
                        if (AdViewControllerImpl.this.f1325h != null) {
                            AdViewControllerImpl.this.f1325h.mo10011d();
                        }
                    } else {
                        C1227o.m2841i("AppLovinAdView", "Unable to expand ad. No Activity found.");
                        Uri f = aVar.mo8889f();
                        if (f != null && ((Boolean) AdViewControllerImpl.this.f1320c.mo10202a(C1096c.f2441cy)).booleanValue()) {
                            AdViewControllerImpl.this.f1321d.trackAndLaunchClick(aVar, AdViewControllerImpl.this.getParentView(), AdViewControllerImpl.this, f, pointF);
                            if (AdViewControllerImpl.this.f1325h != null) {
                                AdViewControllerImpl.this.f1325h.mo10007b();
                            }
                        }
                        AdViewControllerImpl.this.f1328k.mo9005a("javascript:al_onFailedExpand();");
                    }
                }
            }
        });
    }

    public AppLovinAdViewEventListener getAdViewEventListener() {
        return this.f1343z;
    }

    public C0801c getAdWebView() {
        return this.f1328k;
    }

    public AppLovinAd getCurrentAd() {
        return this.f1332o;
    }

    public AppLovinAdView getParentView() {
        return (AppLovinAdView) this.f1319b;
    }

    public C1192i getSdk() {
        return this.f1320c;
    }

    public AppLovinAdSize getSize() {
        return this.f1323f;
    }

    public String getZoneId() {
        return this.f1324g;
    }

    public void initializeAdView(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context == null) {
            C1227o.m2841i("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        } else {
            if (appLovinAdSize == null) {
                appLovinAdSize = C1240b.m2915a(attributeSet);
                if (appLovinAdSize == null) {
                    appLovinAdSize = AppLovinAdSize.BANNER;
                }
            }
            AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null && !appLovinSdk.hasCriticalErrors()) {
                m1113a(appLovinAdView, C1281o.m3071a(appLovinSdk), appLovinAdSize2, str, context);
                if (C1240b.m2917b(attributeSet)) {
                    loadNextAd();
                }
            }
        }
    }

    public boolean isAdReadyToDisplay() {
        return !TextUtils.isEmpty(this.f1324g) ? this.f1321d.hasPreloadedAdForZoneId(this.f1324g) : this.f1321d.hasPreloadedAd(this.f1323f);
    }

    public boolean isAutoDestroy() {
        return this.f1338u;
    }

    public void loadNextAd() {
        if (this.f1320c == null || this.f1327j == null || this.f1318a == null || !this.f1337t) {
            C1227o.m2839g("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f1321d.loadNextAd(this.f1324g, this.f1323f, this.f1327j);
        }
    }

    public void onAdHtmlLoaded(WebView webView) {
        if (this.f1332o instanceof C1084f) {
            webView.setVisibility(0);
            try {
                if (this.f1332o != this.f1333p && this.f1342y != null) {
                    this.f1333p = this.f1332o;
                    C1248i.m2999a(this.f1342y, this.f1332o);
                }
            } catch (Throwable th) {
                C1227o.m2837c("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (this.f1337t) {
            if (this.f1332o != this.f1329l) {
                C1248i.m3010b(this.f1342y, this.f1332o);
            }
            String str = "AppLovinAdView";
            if (this.f1328k == null || this.f1334q == null) {
                this.f1322e.mo10378b(str, "onDetachedFromWindowCalled without an expanded ad present");
            } else {
                this.f1322e.mo10378b(str, "onDetachedFromWindowCalled with expanded ad present");
                if (((Boolean) this.f1320c.mo10202a(C1096c.f2433cq)).booleanValue()) {
                    contractAd();
                } else {
                    m1122c();
                }
            }
            if (this.f1338u) {
                m1119b();
            }
        }
    }

    public void onVisibilityChanged(int i) {
        if (this.f1337t && this.f1338u) {
            if (i == 8 || i == 4) {
                pause();
            } else if (i == 0) {
                resume();
            }
        }
    }

    public void pause() {
        if (this.f1337t && !this.f1339v) {
            AppLovinAd appLovinAd = this.f1332o;
            renderAd(this.f1329l);
            if (appLovinAd != null) {
                this.f1336s.set(appLovinAd);
            }
            this.f1339v = true;
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        renderAd(appLovinAd, null);
    }

    public void renderAd(AppLovinAd appLovinAd, String str) {
        String str2;
        C1227o oVar;
        if (appLovinAd != null) {
            C1281o.m3100b(appLovinAd, this.f1320c);
            String str3 = "AppLovinAdView";
            if (this.f1337t) {
                AppLovinAd a = C1281o.m3072a(appLovinAd, this.f1320c);
                if (a == null || a == this.f1332o) {
                    if (a == null) {
                        oVar = this.f1322e;
                        str2 = "Unable to render ad. Ad is null. Internal inconsistency error.";
                    } else {
                        oVar = this.f1322e;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Ad #");
                        sb.append(a.getAdIdNumber());
                        sb.append(" is already showing, ignoring");
                        str2 = sb.toString();
                    }
                    oVar.mo10381d(str3, str2);
                    return;
                }
                C1227o oVar2 = this.f1322e;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Rendering ad #");
                sb2.append(a.getAdIdNumber());
                sb2.append(" (");
                sb2.append(a.getSize());
                sb2.append(")");
                oVar2.mo10378b(str3, sb2.toString());
                if (!(this.f1332o instanceof C1088h)) {
                    C1248i.m3010b(this.f1342y, this.f1332o);
                    if (!(a instanceof C1088h) && a.getSize() != AppLovinAdSize.INTERSTITIAL) {
                        m1126e();
                    }
                }
                this.f1336s.set(null);
                this.f1333p = null;
                this.f1332o = a;
                if ((appLovinAd instanceof C1084f) && !this.f1339v && (this.f1323f == AppLovinAdSize.BANNER || this.f1323f == AppLovinAdSize.MREC || this.f1323f == AppLovinAdSize.LEADER)) {
                    this.f1320c.mo10241o().trackImpression((C1084f) appLovinAd);
                }
                boolean z = a instanceof C1088h;
                if (!z && this.f1334q != null) {
                    if (((Boolean) this.f1320c.mo10202a(C1096c.f2432cp)).booleanValue()) {
                        m1124d();
                        this.f1322e.mo10378b(str3, "Fade out the old ad scheduled");
                    } else {
                        m1122c();
                    }
                }
                if (!z || (this.f1334q == null && this.f1335r == null)) {
                    m1116a(this.f1330m);
                } else {
                    this.f1322e.mo10378b(str3, "Ignoring empty ad render with expanded ad");
                }
            } else {
                C1227o.m2839g(str3, "Unable to render ad: AppLovinAdView is not initialized.");
            }
        } else {
            throw new IllegalArgumentException("No ad specified");
        }
    }

    public void resume() {
        if (this.f1337t) {
            AppLovinAd appLovinAd = (AppLovinAd) this.f1336s.getAndSet(null);
            if (appLovinAd != null) {
                renderAd(appLovinAd);
            }
            this.f1339v = false;
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f1317A = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f1342y = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f1341x = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f1343z = appLovinAdViewEventListener;
    }

    public void setAutoDestroy(boolean z) {
        this.f1338u = z;
    }

    public void setStatsManagerHelper(C1108d dVar) {
        C0801c cVar = this.f1328k;
        if (cVar != null) {
            cVar.mo9003a(dVar);
        }
    }
}
