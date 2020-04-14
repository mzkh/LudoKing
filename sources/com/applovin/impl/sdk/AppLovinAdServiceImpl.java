package com.applovin.impl.sdk;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.sdk.network.C1222f;
import com.applovin.impl.sdk.p018ad.C1082d;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p018ad.C1087g;
import com.applovin.impl.sdk.p018ad.NativeAdImpl;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p020c.C1101a;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1149l;
import com.applovin.impl.sdk.p021d.C1150m;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1243d;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    public static String URI_LOAD_URL = "/adservice/load_url";
    public static String URI_NO_OP = "/adservice/no_op";
    public static String URI_TRACK_CLICK_IMMEDIATELY = "/adservice/track_click_now";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1192i f2033a;

    /* renamed from: b */
    private final C1227o f2034b;

    /* renamed from: c */
    private final Handler f2035c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private final Map<C1082d, C1047b> f2036d;

    /* renamed from: e */
    private final Object f2037e = new Object();

    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$a */
    private class C1046a implements AppLovinAdLoadListener {

        /* renamed from: b */
        private final C1047b f2045b;

        private C1046a(C1047b bVar) {
            this.f2045b = bVar;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            HashSet<AppLovinAdLoadListener> hashSet;
            C1082d adZone = ((AppLovinAdBase) appLovinAd).getAdZone();
            if (!(appLovinAd instanceof C1087g) && adZone.mo9857i()) {
                AppLovinAdServiceImpl.this.f2033a.mo10194T().adReceived(appLovinAd);
                appLovinAd = new C1087g(adZone, AppLovinAdServiceImpl.this.f2033a);
            }
            synchronized (this.f2045b.f2046a) {
                hashSet = new HashSet<>(this.f2045b.f2048c);
                this.f2045b.f2048c.clear();
                this.f2045b.f2047b = false;
            }
            for (AppLovinAdLoadListener a : hashSet) {
                AppLovinAdServiceImpl.this.m1875a(appLovinAd, a);
            }
        }

        public void failedToReceiveAd(int i) {
            HashSet<AppLovinAdLoadListener> hashSet;
            synchronized (this.f2045b.f2046a) {
                hashSet = new HashSet<>(this.f2045b.f2048c);
                this.f2045b.f2048c.clear();
                this.f2045b.f2047b = false;
            }
            for (AppLovinAdLoadListener a : hashSet) {
                AppLovinAdServiceImpl.this.m1867a(i, a);
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.AppLovinAdServiceImpl$b */
    private static class C1047b {

        /* renamed from: a */
        final Object f2046a;

        /* renamed from: b */
        boolean f2047b;

        /* renamed from: c */
        final Collection<AppLovinAdLoadListener> f2048c;

        private C1047b() {
            this.f2046a = new Object();
            this.f2048c = new HashSet();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AdLoadState{, isWaitingForAd=");
            sb.append(this.f2047b);
            sb.append(", pendingAdListeners=");
            sb.append(this.f2048c);
            sb.append('}');
            return sb.toString();
        }
    }

    AppLovinAdServiceImpl(C1192i iVar) {
        this.f2033a = iVar;
        this.f2034b = iVar.mo10249v();
        this.f2036d = new HashMap(5);
        this.f2036d.put(C1082d.m2004c(iVar), new C1047b());
        this.f2036d.put(C1082d.m2006d(iVar), new C1047b());
        this.f2036d.put(C1082d.m2007e(iVar), new C1047b());
        this.f2036d.put(C1082d.m2008f(iVar), new C1047b());
        this.f2036d.put(C1082d.m2009g(iVar), new C1047b());
    }

    /* renamed from: a */
    private C1047b m1863a(C1082d dVar) {
        C1047b bVar;
        synchronized (this.f2037e) {
            bVar = (C1047b) this.f2036d.get(dVar);
            if (bVar == null) {
                bVar = new C1047b();
                this.f2036d.put(dVar, bVar);
            }
        }
        return bVar;
    }

    /* renamed from: a */
    private String m1865a(String str, long j, int i, String str2, boolean z) {
        try {
            if (!C1277l.m3042b(str)) {
                return null;
            }
            if (i < 0 || i > 100) {
                i = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter(NativeAdImpl.QUERY_PARAM_VIDEO_PERCENT_VIEWED, Integer.toString(i)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
        } catch (Throwable th) {
            C1227o oVar = this.f2034b;
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown error parsing the video end url: ");
            sb.append(str);
            oVar.mo10379b("AppLovinAdService", sb.toString(), th);
            return null;
        }
    }

    /* renamed from: a */
    private String m1866a(String str, long j, long j2) {
        if (!C1277l.m3042b(str)) {
            return null;
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2)).build().toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1867a(final int i, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f2035c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.failedToReceiveAd(i);
                } catch (Throwable th) {
                    C1227o.m2837c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m1868a(Uri uri, C1084f fVar, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl) {
        if (appLovinAdView != null) {
            if (C1281o.m3090a(appLovinAdView.getContext(), uri, this.f2033a)) {
                C1248i.m3012c(adViewControllerImpl.getAdViewEventListener(), (AppLovinAd) fVar, appLovinAdView);
            }
            adViewControllerImpl.dismissInterstitialIfRequired();
            return;
        }
        this.f2034b.mo10382e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
    }

    /* renamed from: a */
    private void m1871a(C1082d dVar, C1046a aVar) {
        AppLovinAd appLovinAd = (AppLovinAd) this.f2033a.mo10194T().mo9983e(dVar);
        if (appLovinAd != null) {
            C1227o oVar = this.f2034b;
            StringBuilder sb = new StringBuilder();
            sb.append("Using pre-loaded ad: ");
            sb.append(appLovinAd);
            sb.append(" for ");
            sb.append(dVar);
            oVar.mo10378b("AppLovinAdService", sb.toString());
            aVar.adReceived(appLovinAd);
        } else {
            m1874a((C1122a) new C1150m(dVar, aVar, this.f2033a), (AppLovinAdLoadListener) aVar);
        }
        if (dVar.mo9857i() && appLovinAd == null) {
            return;
        }
        if (dVar.mo9858j() || (appLovinAd != null && dVar.mo9854g() > 0)) {
            this.f2033a.mo10194T().mo9987i(dVar);
        }
    }

    /* renamed from: a */
    private void m1872a(C1082d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1227o oVar;
        String str;
        String str2;
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        } else if (appLovinAdLoadListener != null) {
            C1227o v = this.f2033a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Loading next ad of zone {");
            sb.append(dVar);
            sb.append("}...");
            v.mo10378b("AppLovinAdService", sb.toString());
            C1047b a = m1863a(dVar);
            synchronized (a.f2046a) {
                a.f2048c.add(appLovinAdLoadListener);
                if (!a.f2047b) {
                    this.f2034b.mo10378b("AppLovinAdService", "Loading next ad...");
                    a.f2047b = true;
                    C1046a aVar = new C1046a(a);
                    if (!dVar.mo9855h()) {
                        this.f2034b.mo10378b("AppLovinAdService", "Task merge not necessary.");
                    } else if (this.f2033a.mo10194T().mo9978a(dVar, (Object) aVar)) {
                        oVar = this.f2034b;
                        str = "AppLovinAdService";
                        str2 = "Attaching load listener to initial preload task...";
                    } else {
                        this.f2034b.mo10378b("AppLovinAdService", "Skipped attach of initial preload callback.");
                    }
                    m1871a(dVar, aVar);
                } else {
                    oVar = this.f2034b;
                    str = "AppLovinAdService";
                    str2 = "Already waiting on an ad load...";
                }
                oVar.mo10378b(str, str2);
            }
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    /* renamed from: a */
    private void m1873a(C1101a aVar) {
        if (C1277l.m3042b(aVar.mo9988a())) {
            this.f2033a.mo10188N().mo10338a(C1222f.m2788k().mo10355a(C1281o.m3098b(aVar.mo9988a())).mo10359b(C1277l.m3042b(aVar.mo9989b()) ? C1281o.m3098b(aVar.mo9989b()) : null).mo10357a(false).mo10358a());
            return;
        }
        this.f2034b.mo10381d("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
    }

    /* renamed from: a */
    private void m1874a(C1122a aVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!this.f2033a.mo10230d()) {
            C1227o.m2840h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f2033a.mo10205a();
        this.f2033a.mo10185K().mo10131a(aVar, C1161a.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1875a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f2035c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.adReceived(appLovinAd);
                } catch (Throwable th) {
                    C1227o.m2837c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
                }
            }
        });
    }

    /* renamed from: a */
    private void m1876a(List<C1101a> list) {
        if (list != null && !list.isEmpty()) {
            for (C1101a a : list) {
                m1873a(a);
            }
        }
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener) {
    }

    public void addAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
    }

    public AppLovinAd dequeueAd(C1082d dVar) {
        AppLovinAd appLovinAd = (AppLovinAd) this.f2033a.mo10194T().mo9982d(dVar);
        C1227o oVar = this.f2034b;
        StringBuilder sb = new StringBuilder();
        sb.append("Dequeued ad: ");
        sb.append(appLovinAd);
        sb.append(" for zone: ");
        sb.append(dVar);
        sb.append("...");
        oVar.mo10378b("AppLovinAdService", sb.toString());
        return appLovinAd;
    }

    public String getBidToken() {
        if (!((Boolean) this.f2033a.mo10202a(C1096c.f2302aQ)).booleanValue()) {
            return "NONE";
        }
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String a = this.f2033a.mo10189O().mo10258a();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return a;
    }

    public boolean hasPreloadedAd(AppLovinAdSize appLovinAdSize) {
        return this.f2033a.mo10194T().mo9985g(C1082d.m1996a(appLovinAdSize, AppLovinAdType.REGULAR, this.f2033a));
    }

    public boolean hasPreloadedAdForZoneId(String str) {
        if (TextUtils.isEmpty(str)) {
            C1227o.m2841i("AppLovinAdService", "Unable to check if ad is preloaded - invalid zone id");
            return false;
        }
        return this.f2033a.mo10194T().mo9985g(C1082d.m1998a(str, this.f2033a));
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        m1872a(C1082d.m1996a(appLovinAdSize, AppLovinAdType.REGULAR, this.f2033a), appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1227o oVar = this.f2034b;
        StringBuilder sb = new StringBuilder();
        sb.append("Loading next ad of zone {");
        sb.append(str);
        sb.append("} with size ");
        sb.append(appLovinAdSize);
        oVar.mo10378b("AppLovinAdService", sb.toString());
        m1872a(C1082d.m1997a(appLovinAdSize, AppLovinAdType.REGULAR, str, this.f2033a), appLovinAdLoadListener);
    }

    /* JADX WARNING: type inference failed for: r11v18, types: [com.applovin.impl.sdk.d.a] */
    /* JADX WARNING: type inference failed for: r11v20, types: [com.applovin.impl.sdk.d.o] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadNextAdForAdToken(java.lang.String r11, com.applovin.sdk.AppLovinAdLoadListener r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0007
            java.lang.String r11 = r11.trim()
            goto L_0x0008
        L_0x0007:
            r11 = 0
        L_0x0008:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = -8
            java.lang.String r2 = "AppLovinAdService"
            if (r0 == 0) goto L_0x001a
            java.lang.String r11 = "Invalid ad token specified"
            com.applovin.impl.sdk.C1227o.m2841i(r2, r11)
            r10.m1867a(r1, r12)
            return
        L_0x001a:
            com.applovin.impl.sdk.ad.c r0 = new com.applovin.impl.sdk.ad.c
            com.applovin.impl.sdk.i r3 = r10.f2033a
            r0.<init>(r11, r3)
            com.applovin.impl.sdk.ad.c$a r11 = r0.mo9839b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.p018ad.C1080c.C1081a.f2192b
            if (r11 != r3) goto L_0x004b
            com.applovin.impl.sdk.o r11 = r10.f2034b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Loading next ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r11.mo10378b(r2, r1)
            com.applovin.impl.sdk.d.o r11 = new com.applovin.impl.sdk.d.o
            com.applovin.impl.sdk.i r1 = r10.f2033a
            r11.<init>(r0, r12, r1)
        L_0x0046:
            r10.m1874a(r11, r12)
            goto L_0x00ed
        L_0x004b:
            com.applovin.impl.sdk.ad.c$a r11 = r0.mo9839b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.p018ad.C1080c.C1081a.f2193c
            if (r11 != r3) goto L_0x00d6
            org.json.JSONObject r5 = r0.mo9841d()
            if (r5 == 0) goto L_0x00bf
            com.applovin.impl.sdk.i r11 = r10.f2033a
            com.applovin.impl.sdk.utils.C1246g.m2956f(r5, r11)
            com.applovin.impl.sdk.i r11 = r10.f2033a
            com.applovin.impl.sdk.utils.C1246g.m2952d(r5, r11)
            com.applovin.impl.sdk.i r11 = r10.f2033a
            com.applovin.impl.sdk.utils.C1246g.m2951c(r5, r11)
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            com.applovin.impl.sdk.i r1 = r10.f2033a
            java.lang.String r3 = "ads"
            org.json.JSONArray r11 = com.applovin.impl.sdk.utils.C1247h.m2988b(r5, r3, r11, r1)
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x00a3
            com.applovin.impl.sdk.o r11 = r10.f2034b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Rendering ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo10378b(r2, r0)
            com.applovin.impl.sdk.i r11 = r10.f2033a
            com.applovin.impl.sdk.ad.d r6 = com.applovin.impl.sdk.utils.C1281o.m3070a(r5, r11)
            com.applovin.impl.sdk.d.s r11 = new com.applovin.impl.sdk.d.s
            com.applovin.impl.sdk.ad.b r7 = com.applovin.impl.sdk.p018ad.C1079b.DECODED_AD_TOKEN_JSON
            com.applovin.impl.sdk.i r9 = r10.f2033a
            r4 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0046
        L_0x00a3:
            com.applovin.impl.sdk.o r11 = r10.f2034b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "No ad returned from the server for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.mo10382e(r2, r0)
            r11 = 204(0xcc, float:2.86E-43)
            r12.failedToReceiveAd(r11)
            goto L_0x00ed
        L_0x00bf:
            com.applovin.impl.sdk.o r11 = r10.f2034b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to retrieve ad response JSON from token: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r11.mo10382e(r2, r0)
            goto L_0x00ea
        L_0x00d6:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = "Invalid ad token specified: "
            r11.append(r3)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.applovin.impl.sdk.C1227o.m2841i(r2, r11)
        L_0x00ea:
            r12.failedToReceiveAd(r1)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinAdServiceImpl.loadNextAdForAdToken(java.lang.String, com.applovin.sdk.AppLovinAdLoadListener):void");
    }

    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!TextUtils.isEmpty(str)) {
            C1227o oVar = this.f2034b;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading next ad of zone {");
            sb.append(str);
            sb.append("}");
            oVar.mo10378b("AppLovinAdService", sb.toString());
            m1872a(C1082d.m1998a(str, this.f2033a), appLovinAdLoadListener);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List a = C1243d.m2926a(list);
        String str = "AppLovinAdService";
        if (a == null || a.isEmpty()) {
            C1227o.m2841i(str, "No zones were provided");
            m1867a(-7, appLovinAdLoadListener);
            return;
        }
        C1227o oVar = this.f2034b;
        StringBuilder sb = new StringBuilder();
        sb.append("Loading next ad for zones: ");
        sb.append(a);
        oVar.mo10378b(str, sb.toString());
        m1874a((C1122a) new C1149l(a, appLovinAdLoadListener, this.f2033a), appLovinAdLoadListener);
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        C1227o oVar = this.f2034b;
        StringBuilder sb = new StringBuilder();
        sb.append("Loading next incentivized ad of zone {");
        sb.append(str);
        sb.append("}");
        oVar.mo10378b("AppLovinAdService", sb.toString());
        m1872a(C1082d.m2005c(str, this.f2033a), appLovinAdLoadListener);
    }

    public void preloadAd(AppLovinAdSize appLovinAdSize) {
        this.f2033a.mo10205a();
        this.f2033a.mo10194T().mo9987i(C1082d.m1996a(appLovinAdSize, AppLovinAdType.REGULAR, this.f2033a));
    }

    public void preloadAdForZoneId(String str) {
        if (TextUtils.isEmpty(str)) {
            C1227o.m2841i("AppLovinAdService", "Unable to preload ad for invalid zone identifier");
            return;
        }
        C1082d a = C1082d.m1998a(str, this.f2033a);
        this.f2033a.mo10194T().mo9986h(a);
        this.f2033a.mo10194T().mo9987i(a);
    }

    public void preloadAds(C1082d dVar) {
        this.f2033a.mo10194T().mo9986h(dVar);
        int g = dVar.mo9854g();
        if (g == 0 && this.f2033a.mo10194T().mo9980b(dVar)) {
            g = 1;
        }
        this.f2033a.mo10194T().mo9979b(dVar, g);
    }

    public void removeAdUpdateListener(AppLovinAdUpdateListener appLovinAdUpdateListener, AppLovinAdSize appLovinAdSize) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinAdService{adLoadStates=");
        sb.append(this.f2036d);
        sb.append('}');
        return sb.toString();
    }

    public void trackAndLaunchClick(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AdViewControllerImpl adViewControllerImpl, Uri uri, PointF pointF) {
        String str = "AppLovinAdService";
        if (appLovinAd == null) {
            this.f2034b.mo10382e(str, "Unable to track ad view click. No ad specified");
            return;
        }
        this.f2034b.mo10378b(str, "Tracking click on an ad...");
        C1084f fVar = (C1084f) appLovinAd;
        m1876a(fVar.mo9890a(pointF));
        m1868a(uri, fVar, appLovinAdView, adViewControllerImpl);
    }

    public void trackAndLaunchVideoClick(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        String str = "AppLovinAdService";
        if (appLovinAd == null) {
            this.f2034b.mo10382e(str, "Unable to track video click. No ad specified");
            return;
        }
        this.f2034b.mo10378b(str, "Tracking VIDEO click on an ad...");
        m1876a(((C1084f) appLovinAd).mo9921b(pointF));
        C1281o.m3090a(appLovinAdView.getContext(), uri, this.f2033a);
    }

    public void trackFullScreenAdClosed(C1084f fVar, long j, long j2) {
        String str = "AppLovinAdService";
        if (fVar == null) {
            this.f2034b.mo10382e(str, "Unable to track ad closed. No ad specified.");
            return;
        }
        this.f2034b.mo10378b(str, "Tracking ad closed...");
        List<C1101a> am = fVar.mo9908am();
        if (am == null || am.isEmpty()) {
            C1227o oVar = this.f2034b;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to track ad closed for AD #");
            sb.append(fVar.getAdIdNumber());
            sb.append(". Missing ad close tracking URL.");
            sb.append(fVar.getAdIdNumber());
            oVar.mo10381d(str, sb.toString());
        } else {
            for (C1101a aVar : am) {
                String a = m1866a(aVar.mo9988a(), j, j2);
                String a2 = m1866a(aVar.mo9989b(), j, j2);
                if (C1277l.m3042b(a)) {
                    m1873a(new C1101a(a, a2));
                } else {
                    C1227o oVar2 = this.f2034b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to parse url: ");
                    sb2.append(aVar.mo9988a());
                    oVar2.mo10382e(str, sb2.toString());
                }
            }
        }
    }

    public void trackImpression(C1084f fVar) {
        String str = "AppLovinAdService";
        if (fVar == null) {
            this.f2034b.mo10382e(str, "Unable to track impression click. No ad specified");
            return;
        }
        this.f2034b.mo10378b(str, "Tracking impression on ad...");
        m1876a(fVar.mo8883an());
    }

    public void trackVideoEnd(C1084f fVar, long j, int i, boolean z) {
        String str = "AppLovinAdService";
        if (fVar == null) {
            this.f2034b.mo10382e(str, "Unable to track video end. No ad specified");
            return;
        }
        this.f2034b.mo10378b(str, "Tracking video end on ad...");
        List<C1101a> al = fVar.mo9907al();
        if (al == null || al.isEmpty()) {
            C1227o oVar = this.f2034b;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to submit persistent postback for AD #");
            sb.append(fVar.getAdIdNumber());
            sb.append(". Missing video end tracking URL.");
            oVar.mo10381d(str, sb.toString());
        } else {
            String l = Long.toString(System.currentTimeMillis());
            for (C1101a aVar : al) {
                if (C1277l.m3042b(aVar.mo9988a())) {
                    long j2 = j;
                    int i2 = i;
                    String str2 = l;
                    boolean z2 = z;
                    String a = m1865a(aVar.mo9988a(), j2, i2, str2, z2);
                    String a2 = m1865a(aVar.mo9989b(), j2, i2, str2, z2);
                    if (a != null) {
                        m1873a(new C1101a(a, a2));
                    } else {
                        C1227o oVar2 = this.f2034b;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to parse url: ");
                        sb2.append(aVar.mo9988a());
                        oVar2.mo10382e(str, sb2.toString());
                    }
                } else {
                    this.f2034b.mo10381d(str, "Requested a postback dispatch for an empty video end URL; nothing to do...");
                }
            }
        }
    }
}
