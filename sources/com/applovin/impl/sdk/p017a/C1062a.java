package com.applovin.impl.sdk.p017a;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p018ad.C1087g;
import com.applovin.impl.sdk.p018ad.C1089i;
import com.applovin.impl.sdk.p020c.C1113g;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1128ad;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.p021d.C1175y;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.a.a */
public class C1062a {

    /* renamed from: a */
    protected final C1192i f2101a;

    /* renamed from: b */
    protected final AppLovinAdServiceImpl f2102b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppLovinAd f2103c;

    /* renamed from: d */
    private String f2104d;

    /* renamed from: e */
    private SoftReference<AppLovinAdLoadListener> f2105e;

    /* renamed from: f */
    private final Object f2106f = new Object();

    /* renamed from: g */
    private volatile String f2107g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile boolean f2108h = false;

    /* renamed from: i */
    private SoftReference<AppLovinInterstitialAdDialog> f2109i;

    /* renamed from: com.applovin.impl.sdk.a.a$a */
    private class C1064a implements AppLovinAdLoadListener {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final AppLovinAdLoadListener f2112b;

        C1064a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f2112b = appLovinAdLoadListener;
        }

        public void adReceived(final AppLovinAd appLovinAd) {
            C1062a.this.f2103c = appLovinAd;
            if (this.f2112b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1064a.this.f2112b.adReceived(appLovinAd);
                        } catch (Throwable th) {
                            C1227o.m2837c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                        }
                    }
                });
            }
        }

        public void failedToReceiveAd(final int i) {
            if (this.f2112b != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            C1064a.this.f2112b.failedToReceiveAd(i);
                        } catch (Throwable th) {
                            C1227o.m2837c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.applovin.impl.sdk.a.a$b */
    private class C1067b implements C1089i, AppLovinAdClickListener, AppLovinAdRewardListener, AppLovinAdVideoPlaybackListener {

        /* renamed from: b */
        private final AppLovinAdDisplayListener f2118b;

        /* renamed from: c */
        private final AppLovinAdClickListener f2119c;

        /* renamed from: d */
        private final AppLovinAdVideoPlaybackListener f2120d;

        /* renamed from: e */
        private final AppLovinAdRewardListener f2121e;

        private C1067b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f2118b = appLovinAdDisplayListener;
            this.f2119c = appLovinAdClickListener;
            this.f2120d = appLovinAdVideoPlaybackListener;
            this.f2121e = appLovinAdRewardListener;
        }

        /* renamed from: a */
        private void m1939a(C1084f fVar) {
            String str;
            int i;
            if (!C1277l.m3042b(C1062a.this.m1931e()) || !C1062a.this.f2108h) {
                fVar.mo9894aB();
                if (C1062a.this.f2108h) {
                    i = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                    str = "network_timeout";
                } else {
                    i = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                    str = "user_closed_video";
                }
                fVar.mo9891a(C1075c.m1948a(str));
                C1248i.m3001a(this.f2121e, (AppLovinAd) fVar, i);
            }
            C1062a.this.m1922a((AppLovinAd) fVar);
            C1248i.m3010b(this.f2118b, (AppLovinAd) fVar);
            if (!fVar.mo9905aj().getAndSet(true)) {
                C1062a.this.f2101a.mo10185K().mo10131a((C1122a) new C1175y(fVar, C1062a.this.f2101a), C1161a.REWARD);
            }
        }

        public void adClicked(AppLovinAd appLovinAd) {
            C1248i.m2998a(this.f2119c, appLovinAd);
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            C1248i.m2999a(this.f2118b, appLovinAd);
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (appLovinAd instanceof C1087g) {
                appLovinAd = ((C1087g) appLovinAd).mo9938a();
            }
            if (appLovinAd instanceof C1084f) {
                m1939a((C1084f) appLovinAd);
                return;
            }
            C1227o v = C1062a.this.f2101a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Something is terribly wrong. Received `adHidden` callback for invalid ad of type: ");
            sb.append(appLovinAd);
            v.mo10382e("IncentivizedAdController", sb.toString());
        }

        public void onAdDisplayFailed(String str) {
            C1248i.m3000a(this.f2118b, str);
        }

        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            C1062a.this.m1925a("quota_exceeded");
            C1248i.m3011b(this.f2121e, appLovinAd, map);
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            C1062a.this.m1925a("rejected");
            C1248i.m3014c(this.f2121e, appLovinAd, map);
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            C1062a.this.m1925a("accepted");
            C1248i.m3002a(this.f2121e, appLovinAd, map);
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            C1062a.this.m1925a("network_timeout");
            C1248i.m3001a(this.f2121e, appLovinAd, i);
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            C1248i.m3003a(this.f2120d, appLovinAd);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            C1248i.m3004a(this.f2120d, appLovinAd, d, z);
            C1062a.this.f2108h = z;
        }
    }

    public C1062a(String str, AppLovinSdk appLovinSdk) {
        this.f2101a = C1281o.m3071a(appLovinSdk);
        this.f2102b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f2104d = str;
    }

    /* renamed from: a */
    private void m1918a(AppLovinAdBase appLovinAdBase, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (!appLovinAdBase.getType().equals(AppLovinAdType.INCENTIVIZED)) {
            C1227o v = this.f2101a.mo10249v();
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to render an ad of type ");
            sb.append(appLovinAdBase.getType());
            sb.append(" in an Incentivized Ad interstitial.");
            v.mo10382e("IncentivizedAdController", sb.toString());
            m1924a(appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
            return;
        }
        AppLovinAd a = C1281o.m3072a((AppLovinAd) appLovinAdBase, this.f2101a);
        if (a != null) {
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f2101a.mo10193S(), context);
            C1067b bVar = new C1067b(appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            create.setAdDisplayListener(bVar);
            create.setAdVideoPlaybackListener(bVar);
            create.setAdClickListener(bVar);
            create.showAndRender(a);
            this.f2109i = new SoftReference<>(create);
            if (a instanceof C1084f) {
                m1921a((C1084f) a, (AppLovinAdRewardListener) bVar);
            }
        } else {
            m1924a(appLovinAdBase, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener);
        }
    }

    /* renamed from: a */
    private void m1921a(C1084f fVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f2101a.mo10185K().mo10131a((C1122a) new C1128ad(fVar, appLovinAdRewardListener, this.f2101a), C1161a.REWARD);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1922a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f2103c;
        if (appLovinAd2 != null) {
            if (appLovinAd2 instanceof C1087g) {
                if (appLovinAd != ((C1087g) appLovinAd2).mo9938a()) {
                    return;
                }
            } else if (appLovinAd != appLovinAd2) {
                return;
            }
            this.f2103c = null;
        }
    }

    /* renamed from: a */
    private void m1923a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAd == null) {
            appLovinAd = this.f2103c;
        }
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
        if (appLovinAdBase != null) {
            m1918a(appLovinAdBase, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
            return;
        }
        C1227o.m2841i("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m1930d();
    }

    /* renamed from: a */
    private void m1924a(AppLovinAd appLovinAd, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f2101a.mo10186L().mo10036a(C1113g.f2665j);
        C1248i.m3004a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        C1248i.m3010b(appLovinAdDisplayListener, appLovinAd);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1925a(String str) {
        synchronized (this.f2106f) {
            this.f2107g = str;
        }
    }

    /* renamed from: b */
    private void m1928b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f2102b.loadNextIncentivizedAd(this.f2104d, appLovinAdLoadListener);
    }

    /* renamed from: d */
    private void m1930d() {
        SoftReference<AppLovinAdLoadListener> softReference = this.f2105e;
        if (softReference != null) {
            AppLovinAdLoadListener appLovinAdLoadListener = (AppLovinAdLoadListener) softReference.get();
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public String m1931e() {
        String str;
        synchronized (this.f2106f) {
            str = this.f2107g;
        }
        return str;
    }

    /* renamed from: f */
    private AppLovinAdRewardListener m1932f() {
        return new AppLovinAdRewardListener() {
            public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
                C1062a.this.f2101a.mo10249v().mo10378b("IncentivizedAdController", "User declined to view");
            }

            public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
                C1227o v = C1062a.this.f2101a.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("User over quota: ");
                sb.append(map);
                v.mo10378b("IncentivizedAdController", sb.toString());
            }

            public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
                C1227o v = C1062a.this.f2101a.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Reward rejected: ");
                sb.append(map);
                v.mo10378b("IncentivizedAdController", sb.toString());
            }

            public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
                C1227o v = C1062a.this.f2101a.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Reward validated: ");
                sb.append(map);
                v.mo10378b("IncentivizedAdController", sb.toString());
            }

            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                C1227o v = C1062a.this.f2101a.mo10249v();
                StringBuilder sb = new StringBuilder();
                sb.append("Reward validation failed: ");
                sb.append(i);
                v.mo10378b("IncentivizedAdController", sb.toString());
            }
        };
    }

    /* renamed from: a */
    public void mo9745a(AppLovinAd appLovinAd, Context context, String str, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = m1932f();
        }
        m1923a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    /* renamed from: a */
    public void mo9746a(AppLovinAdLoadListener appLovinAdLoadListener) {
        String str = "IncentivizedAdController";
        this.f2101a.mo10249v().mo10378b(str, "User requested preload of incentivized ad...");
        this.f2105e = new SoftReference<>(appLovinAdLoadListener);
        if (mo9747a()) {
            C1227o.m2841i(str, "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f2103c);
            }
            return;
        }
        m1928b((AppLovinAdLoadListener) new C1064a(appLovinAdLoadListener));
    }

    /* renamed from: a */
    public boolean mo9747a() {
        return this.f2103c != null;
    }

    /* renamed from: b */
    public String mo9748b() {
        return this.f2104d;
    }

    /* renamed from: c */
    public void mo9749c() {
        SoftReference<AppLovinInterstitialAdDialog> softReference = this.f2109i;
        if (softReference != null) {
            AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = (AppLovinInterstitialAdDialog) softReference.get();
            if (appLovinInterstitialAdDialog != null) {
                appLovinInterstitialAdDialog.dismiss();
            }
        }
    }
}
