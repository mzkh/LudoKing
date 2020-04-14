package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.applovin.impl.mediation.p014b.C0958a;
import com.applovin.impl.mediation.p014b.C0962e;
import com.applovin.impl.mediation.p014b.C0965g;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapter.InitializationStatus;
import com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.i */
public class C0999i {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f1925a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1192i f1926b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1227o f1927c;

    /* renamed from: d */
    private final String f1928d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C0962e f1929e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f1930f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MaxAdapter f1931g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f1932h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0958a f1933i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f1934j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C1015a f1935k = new C1015a();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public MaxAdapterResponseParameters f1936l;

    /* renamed from: m */
    private final AtomicBoolean f1937m = new AtomicBoolean(true);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final AtomicBoolean f1938n = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final AtomicBoolean f1939o = new AtomicBoolean(false);

    /* renamed from: com.applovin.impl.mediation.i$a */
    private class C1015a implements MaxAdViewAdapterListener, MaxInterstitialAdapterListener, MaxRewardedAdapterListener {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C0987d f1981b;

        private C1015a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1825a(C0987d dVar) {
            if (dVar != null) {
                this.f1981b = dVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        /* renamed from: a */
        private void m1828a(String str) {
            C0999i.this.f1939o.set(true);
            m1830a(str, (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    if (C0999i.this.f1938n.compareAndSet(false, true)) {
                        C1015a.this.f1981b.onAdLoaded(C0999i.this.f1933i);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m1829a(String str, int i) {
            m1831a(str, new MaxAdapterError(i));
        }

        /* renamed from: a */
        private void m1830a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            C0999i.this.f1925a.post(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        MaxAdListener maxAdListener = maxAdListener;
                        String name = maxAdListener != null ? maxAdListener.getClass().getName() : null;
                        C1227o e2 = C0999i.this.f1927c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to forward call (");
                        sb.append(str);
                        sb.append(") to ");
                        sb.append(name);
                        e2.mo10379b("MediationAdapterWrapper", sb.toString(), e);
                    }
                }
            });
        }

        /* renamed from: a */
        private void m1831a(String str, final MaxAdapterError maxAdapterError) {
            m1830a(str, (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    if (C0999i.this.f1938n.compareAndSet(false, true)) {
                        C1015a.this.f1981b.mo9284a(C0999i.this.f1932h, (C0993e) maxAdapterError);
                    }
                }
            });
        }

        /* renamed from: b */
        private void m1833b(String str) {
            if (C0999i.this.f1933i.mo9435h().compareAndSet(false, true)) {
                m1830a(str, (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                    public void run() {
                        C1015a.this.f1981b.onAdDisplayed(C0999i.this.f1933i);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m1834b(String str, int i) {
            m1835b(str, new MaxAdapterError(i));
        }

        /* renamed from: b */
        private void m1835b(String str, final MaxAdapterError maxAdapterError) {
            m1830a(str, (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    C1015a.this.f1981b.mo9283a((MaxAd) C0999i.this.f1933i, (C0993e) maxAdapterError);
                }
            });
        }

        public void onAdViewAdClicked() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": adview ad clicked");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onAdViewAdClicked", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    C1015a.this.f1981b.onAdClicked(C0999i.this.f1933i);
                }
            });
        }

        public void onAdViewAdCollapsed() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": adview ad collapsed");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onAdViewAdCollapsed", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    if (C1015a.this.f1981b instanceof MaxAdViewAdListener) {
                        ((MaxAdViewAdListener) C1015a.this.f1981b).onAdCollapsed(C0999i.this.f1933i);
                    }
                }
            });
        }

        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": adview ad failed to display with code: ");
            sb.append(maxAdapterError);
            e.mo10381d("MediationAdapterWrapper", sb.toString());
            m1835b("onAdViewAdDisplayFailed", maxAdapterError);
        }

        public void onAdViewAdDisplayed() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": adview ad displayed");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1833b("onAdViewAdDisplayed");
        }

        public void onAdViewAdExpanded() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": adview ad expanded");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onAdViewAdExpanded", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    if (C1015a.this.f1981b instanceof MaxAdViewAdListener) {
                        ((MaxAdViewAdListener) C1015a.this.f1981b).onAdExpanded(C0999i.this.f1933i);
                    }
                }
            });
        }

        public void onAdViewAdHidden() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": adview ad hidden");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onAdViewAdHidden", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    C1015a.this.f1981b.onAdHidden(C0999i.this.f1933i);
                }
            });
        }

        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": adview ad ad failed to load with code: ");
            sb.append(maxAdapterError);
            e.mo10381d("MediationAdapterWrapper", sb.toString());
            m1831a("onAdViewAdLoadFailed", maxAdapterError);
        }

        public void onAdViewAdLoaded(View view) {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": adview ad loaded");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            C0999i.this.f1934j = view;
            m1828a("onAdViewAdLoaded");
        }

        public void onInterstitialAdClicked() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": interstitial ad clicked");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onInterstitialAdClicked", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    C1015a.this.f1981b.onAdClicked(C0999i.this.f1933i);
                }
            });
        }

        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": interstitial ad failed to display with code ");
            sb.append(maxAdapterError);
            e.mo10381d("MediationAdapterWrapper", sb.toString());
            m1835b("onInterstitialAdDisplayFailed", maxAdapterError);
        }

        public void onInterstitialAdDisplayed() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": interstitial ad displayed");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1833b("onInterstitialAdDisplayed");
        }

        public void onInterstitialAdHidden() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": interstitial ad hidden");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onInterstitialAdHidden", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    C1015a.this.f1981b.onAdHidden(C0999i.this.f1933i);
                }
            });
        }

        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": interstitial ad failed to load with error ");
            sb.append(maxAdapterError);
            e.mo10381d("MediationAdapterWrapper", sb.toString());
            m1831a("onInterstitialAdLoadFailed", maxAdapterError);
        }

        public void onInterstitialAdLoaded() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": interstitial ad loaded");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1828a("onInterstitialAdLoaded");
        }

        public void onRewardedAdClicked() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": rewarded ad clicked");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onRewardedAdClicked", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    C1015a.this.f1981b.onAdClicked(C0999i.this.f1933i);
                }
            });
        }

        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": rewarded ad display failed with error: ");
            sb.append(maxAdapterError);
            e.mo10381d("MediationAdapterWrapper", sb.toString());
            m1835b("onRewardedAdDisplayFailed", maxAdapterError);
        }

        public void onRewardedAdDisplayed() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": rewarded ad displayed");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1833b("onRewardedAdDisplayed");
        }

        public void onRewardedAdHidden() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": rewarded ad hidden");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onRewardedAdHidden", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    C1015a.this.f1981b.onAdHidden(C0999i.this.f1933i);
                }
            });
        }

        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": rewarded ad failed to load with code: ");
            sb.append(maxAdapterError);
            e.mo10381d("MediationAdapterWrapper", sb.toString());
            m1831a("onRewardedAdLoadFailed", maxAdapterError);
        }

        public void onRewardedAdLoaded() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": rewarded ad loaded");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1828a("onRewardedAdLoaded");
        }

        public void onRewardedAdVideoCompleted() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": rewarded video completed");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onRewardedAdVideoCompleted", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    if (C1015a.this.f1981b instanceof MaxRewardedAdListener) {
                        ((MaxRewardedAdListener) C1015a.this.f1981b).onRewardedVideoCompleted(C0999i.this.f1933i);
                    }
                }
            });
        }

        public void onRewardedAdVideoStarted() {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": rewarded video started");
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onRewardedAdVideoStarted", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    if (C1015a.this.f1981b instanceof MaxRewardedAdListener) {
                        ((MaxRewardedAdListener) C1015a.this.f1981b).onRewardedVideoStarted(C0999i.this.f1933i);
                    }
                }
            });
        }

        public void onUserRewarded(final MaxReward maxReward) {
            C1227o e = C0999i.this.f1927c;
            StringBuilder sb = new StringBuilder();
            sb.append(C0999i.this.f1930f);
            sb.append(": user was rewarded: ");
            sb.append(maxReward);
            e.mo10380c("MediationAdapterWrapper", sb.toString());
            m1830a("onUserRewarded", (MaxAdListener) this.f1981b, (Runnable) new Runnable() {
                public void run() {
                    if (C1015a.this.f1981b instanceof MaxRewardedAdListener) {
                        ((MaxRewardedAdListener) C1015a.this.f1981b).onUserRewarded(C0999i.this.f1933i, maxReward);
                    }
                }
            });
        }
    }

    /* renamed from: com.applovin.impl.mediation.i$b */
    private static class C1032b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C0965g f2004a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final MaxSignalCollectionListener f2005b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final AtomicBoolean f2006c = new AtomicBoolean();

        C1032b(C0965g gVar, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.f2004a = gVar;
            this.f2005b = maxSignalCollectionListener;
        }
    }

    /* renamed from: com.applovin.impl.mediation.i$c */
    private class C1033c extends C1122a {
        private C1033c() {
            super("TaskTimeoutMediatedAd", C0999i.this.f1926b);
        }

        /* renamed from: a */
        public C1115i mo9338a() {
            return C1115i.f2685G;
        }

        public void run() {
            if (!C0999i.this.f1939o.get()) {
                StringBuilder sb = new StringBuilder();
                sb.append(C0999i.this.f1930f);
                sb.append(" is timing out ");
                sb.append(C0999i.this.f1933i);
                sb.append("...");
                mo10072d(sb.toString());
                this.f2745b.mo10176A().mo9628a(C0999i.this.f1933i);
                C0999i.this.f1935k.m1829a(mo10074f(), (int) MaxErrorCodes.MEDIATION_ADAPTER_TIMEOUT);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.i$d */
    private class C1034d extends C1122a {

        /* renamed from: c */
        private final C1032b f2009c;

        private C1034d(C1032b bVar) {
            super("TaskTimeoutSignalCollection", C0999i.this.f1926b);
            this.f2009c = bVar;
        }

        /* renamed from: a */
        public C1115i mo9338a() {
            return C1115i.f2686H;
        }

        public void run() {
            if (!this.f2009c.f2006c.get()) {
                StringBuilder sb = new StringBuilder();
                sb.append(C0999i.this.f1930f);
                sb.append(" is timing out ");
                sb.append(this.f2009c.f2004a);
                sb.append("...");
                mo10072d(sb.toString());
                C0999i iVar = C0999i.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The adapter (");
                sb2.append(C0999i.this.f1930f);
                sb2.append(") timed out");
                iVar.m1801b(sb2.toString(), this.f2009c);
            }
        }
    }

    C0999i(C0962e eVar, MaxAdapter maxAdapter, C1192i iVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        } else if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        } else if (iVar != null) {
            this.f1928d = eVar.mo9495z();
            this.f1931g = maxAdapter;
            this.f1926b = iVar;
            this.f1927c = iVar.mo10249v();
            this.f1929e = eVar;
            this.f1930f = maxAdapter.getClass().getSimpleName();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1796a(String str) {
        C1227o oVar = this.f1927c;
        StringBuilder sb = new StringBuilder();
        sb.append("Marking ");
        sb.append(this.f1930f);
        sb.append(" as disabled due to: ");
        sb.append(str);
        oVar.mo10380c("MediationAdapterWrapper", sb.toString());
        this.f1937m.set(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1797a(String str, C1032b bVar) {
        if (bVar.f2006c.compareAndSet(false, true) && bVar.f2005b != null) {
            bVar.f2005b.onSignalCollected(str);
        }
    }

    /* renamed from: a */
    private void m1798a(final String str, final Runnable runnable) {
        C10083 r0 = new Runnable() {
            public void run() {
                String str = "MediationAdapterWrapper";
                try {
                    C1227o e = C0999i.this.f1927c;
                    StringBuilder sb = new StringBuilder();
                    sb.append(C0999i.this.f1930f);
                    sb.append(": running ");
                    sb.append(str);
                    sb.append("...");
                    e.mo10378b(str, sb.toString());
                    runnable.run();
                    C1227o e2 = C0999i.this.f1927c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(C0999i.this.f1930f);
                    sb2.append(": finished ");
                    sb2.append(str);
                    sb2.append("");
                    e2.mo10378b(str, sb2.toString());
                } catch (Throwable th) {
                    C1227o e3 = C0999i.this.f1927c;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unable to run adapter operation ");
                    sb3.append(str);
                    sb3.append(", marking ");
                    sb3.append(C0999i.this.f1930f);
                    sb3.append(" as disabled");
                    e3.mo10379b(str, sb3.toString(), th);
                    C0999i iVar = C0999i.this;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("fail_");
                    sb4.append(str);
                    iVar.m1796a(sb4.toString());
                }
            }
        };
        if (this.f1929e.mo9465B()) {
            this.f1925a.post(r0);
        } else {
            r0.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1801b(String str, C1032b bVar) {
        if (bVar.f2006c.compareAndSet(false, true) && bVar.f2005b != null) {
            bVar.f2005b.onSignalCollectionFailed(str);
        }
    }

    /* renamed from: a */
    public View mo9550a() {
        return this.f1934j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9551a(final C0958a aVar, final Activity activity) {
        final Runnable runnable;
        if (aVar != null) {
            String str = "ad_show";
            if (aVar.mo9428c() == null) {
                this.f1935k.m1834b(str, -5201);
            } else if (aVar.mo9428c() != this) {
                throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
            } else if (activity != null) {
                String str2 = "Mediation adapter '";
                String str3 = "MediationAdapterWrapper";
                if (!this.f1937m.get()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(this.f1930f);
                    sb.append("' is disabled. Showing ads with this adapter is disabled.");
                    C1227o.m2841i(str3, sb.toString());
                    this.f1935k.m1834b(str, (int) MaxErrorCodes.MEDIATION_ADAPTER_DISABLED);
                } else if (!mo9558d()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(this.f1930f);
                    sb2.append("' does not have an ad loaded. Please load an ad first");
                    C1227o.m2841i(str3, sb2.toString());
                    this.f1935k.m1834b(str, (int) MaxErrorCodes.MEDIATION_ADAPTER_AD_NOT_READY);
                } else {
                    String str4 = "showFullscreenAd";
                    if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                        if (this.f1931g instanceof MaxInterstitialAdapter) {
                            runnable = new Runnable() {
                                public void run() {
                                    ((MaxInterstitialAdapter) C0999i.this.f1931g).showInterstitialAd(C0999i.this.f1936l, activity, C0999i.this.f1935k);
                                }
                            };
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str2);
                            sb3.append(this.f1930f);
                            sb3.append("' is not an interstitial adapter.");
                            C1227o.m2841i(str3, sb3.toString());
                            this.f1935k.m1834b(str4, (int) MaxErrorCodes.MEDIATION_ADAPTER_WRONG_TYPE);
                            return;
                        }
                    } else if (aVar.getFormat() != MaxAdFormat.REWARDED) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Failed to show ");
                        sb4.append(aVar);
                        sb4.append(": ");
                        sb4.append(aVar.getFormat());
                        sb4.append(" is not a supported ad format");
                        C1227o.m2841i(str3, sb4.toString());
                        this.f1935k.m1834b(str4, (int) MaxErrorCodes.MEDIATION_ADAPTER_WRONG_TYPE);
                        return;
                    } else if (this.f1931g instanceof MaxRewardedAdapter) {
                        runnable = new Runnable() {
                            public void run() {
                                ((MaxRewardedAdapter) C0999i.this.f1931g).showRewardedAd(C0999i.this.f1936l, activity, C0999i.this.f1935k);
                            }
                        };
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        sb5.append(this.f1930f);
                        sb5.append("' is not an incentivized adapter.");
                        C1227o.m2841i(str3, sb5.toString());
                        this.f1935k.m1834b(str4, (int) MaxErrorCodes.MEDIATION_ADAPTER_WRONG_TYPE);
                        return;
                    }
                    m1798a("ad_render", (Runnable) new Runnable() {
                        public void run() {
                            try {
                                runnable.run();
                            } catch (Throwable th) {
                                C1227o e = C0999i.this.f1927c;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Failed to start displaying ad");
                                sb.append(aVar);
                                e.mo10379b("MediationAdapterWrapper", sb.toString(), th);
                                C0999i.this.f1935k.m1834b("ad_render", (int) MaxAdapterError.ERROR_CODE_UNSPECIFIED);
                            }
                        }
                    });
                }
            } else {
                throw new IllegalArgumentException("No activity specified");
            }
        } else {
            throw new IllegalArgumentException("No mediated ad specified");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9552a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity) {
        m1798a("initialize", (Runnable) new Runnable() {
            public void run() {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                C0999i.this.f1931g.initialize(maxAdapterInitializationParameters, activity, new OnCompletionListener() {
                    public void onCompletion() {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                C0999i.this.f1926b.mo10251x().mo9541a(C0999i.this.f1929e, SystemClock.elapsedRealtime() - elapsedRealtime, InitializationStatus.ADAPTER_NOT_SUPPORTED, null);
                            }
                        }, C0999i.this.f1929e.mo9471H());
                    }

                    public void onCompletion(final InitializationStatus initializationStatus, final String str) {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                C0999i.this.f1926b.mo10251x().mo9541a(C0999i.this.f1929e, SystemClock.elapsedRealtime() - elapsedRealtime, initializationStatus, str);
                            }
                        }, C0999i.this.f1929e.mo9471H());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9553a(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, C0965g gVar, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener != null) {
            String str = "The adapter (";
            if (!this.f1937m.get()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Mediation adapter '");
                sb.append(this.f1930f);
                sb.append("' is disabled. Signal collection ads with this adapter is disabled.");
                C1227o.m2841i("MediationAdapterWrapper", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f1930f);
                sb2.append(") is disabled");
                maxSignalCollectionListener.onSignalCollectionFailed(sb2.toString());
                return;
            }
            final C1032b bVar = new C1032b(gVar, maxSignalCollectionListener);
            MaxAdapter maxAdapter = this.f1931g;
            if (maxAdapter instanceof MaxSignalProvider) {
                final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
                final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters2 = maxAdapterSignalCollectionParameters;
                final Activity activity2 = activity;
                final C0965g gVar2 = gVar;
                C100511 r0 = new Runnable() {
                    public void run() {
                        maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters2, activity2, new MaxSignalCollectionListener() {
                            public void onSignalCollected(String str) {
                                C0999i.this.m1797a(str, bVar);
                            }

                            public void onSignalCollectionFailed(String str) {
                                C0999i.this.m1801b(str, bVar);
                            }
                        });
                        if (!bVar.f2006c.get()) {
                            String str = "MediationAdapterWrapper";
                            if (gVar2.mo9467D() == 0) {
                                C1227o e = C0999i.this.f1927c;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Failing signal collection ");
                                sb.append(gVar2);
                                sb.append(" since it has 0 timeout");
                                e.mo10378b(str, sb.toString());
                                C0999i iVar = C0999i.this;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("The adapter (");
                                sb2.append(C0999i.this.f1930f);
                                sb2.append(") has 0 timeout");
                                iVar.m1801b(sb2.toString(), bVar);
                            } else if (gVar2.mo9467D() > 0) {
                                C1227o e2 = C0999i.this.f1927c;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Setting timeout ");
                                sb3.append(gVar2.mo9467D());
                                sb3.append("ms. for ");
                                sb3.append(gVar2);
                                e2.mo10378b(str, sb3.toString());
                                C0999i.this.f1926b.mo10185K().mo10132a(new C1034d(bVar), C1161a.MEDIATION_TIMEOUT, gVar2.mo9467D());
                            } else {
                                C1227o e3 = C0999i.this.f1927c;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Negative timeout set for ");
                                sb4.append(gVar2);
                                sb4.append(", not scheduling a timeout");
                                e3.mo10378b(str, sb4.toString());
                            }
                        }
                    }
                };
                m1798a("collect_signal", (Runnable) r0);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(this.f1930f);
                sb3.append(") does not support signal collection");
                m1801b(sb3.toString(), bVar);
            }
            return;
        }
        throw new IllegalArgumentException("No callback specified");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9554a(String str, C0958a aVar) {
        this.f1932h = str;
        this.f1933i = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9555a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final C0958a aVar, final Activity activity, C0987d dVar) {
        final Runnable runnable;
        if (aVar != null) {
            String str2 = "Mediation adapter '";
            String str3 = "MediationAdapterWrapper";
            if (!this.f1937m.get()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.f1930f);
                sb.append("' was disabled due to earlier failures. Loading ads with this adapter is disabled.");
                C1227o.m2841i(str3, sb.toString());
                dVar.onAdLoadFailed(str, MaxErrorCodes.MEDIATION_ADAPTER_DISABLED);
                return;
            }
            this.f1936l = maxAdapterResponseParameters;
            this.f1935k.m1825a(dVar);
            String str4 = "loadAd";
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                if (this.f1931g instanceof MaxInterstitialAdapter) {
                    runnable = new Runnable() {
                        public void run() {
                            ((MaxInterstitialAdapter) C0999i.this.f1931g).loadInterstitialAd(maxAdapterResponseParameters, activity, C0999i.this.f1935k);
                        }
                    };
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(this.f1930f);
                    sb2.append("' is not an interstitial adapter.");
                    C1227o.m2841i(str3, sb2.toString());
                    this.f1935k.m1829a(str4, (int) MaxErrorCodes.MEDIATION_ADAPTER_WRONG_TYPE);
                    return;
                }
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                if (this.f1931g instanceof MaxRewardedAdapter) {
                    runnable = new Runnable() {
                        public void run() {
                            ((MaxRewardedAdapter) C0999i.this.f1931g).loadRewardedAd(maxAdapterResponseParameters, activity, C0999i.this.f1935k);
                        }
                    };
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append(this.f1930f);
                    sb3.append("' is not an incentivized adapter.");
                    C1227o.m2841i(str3, sb3.toString());
                    this.f1935k.m1829a(str4, (int) MaxErrorCodes.MEDIATION_ADAPTER_WRONG_TYPE);
                    return;
                }
            } else if (aVar.getFormat() != MaxAdFormat.BANNER && aVar.getFormat() != MaxAdFormat.LEADER && aVar.getFormat() != MaxAdFormat.MREC) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to load ");
                sb4.append(aVar);
                sb4.append(": ");
                sb4.append(aVar.getFormat());
                sb4.append(" is not a supported ad format");
                C1227o.m2841i(str3, sb4.toString());
                this.f1935k.m1829a(str4, (int) MaxErrorCodes.FORMAT_TYPE_NOT_SUPPORTED);
                return;
            } else if (this.f1931g instanceof MaxAdViewAdapter) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxAdViewAdapter) C0999i.this.f1931g).loadAdViewAd(maxAdapterResponseParameters, aVar.getFormat(), activity, C0999i.this.f1935k);
                    }
                };
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append(this.f1930f);
                sb5.append("' is not an adview-based adapter.");
                C1227o.m2841i(str3, sb5.toString());
                this.f1935k.m1829a(str4, (int) MaxErrorCodes.MEDIATION_ADAPTER_WRONG_TYPE);
                return;
            }
            m1798a("ad_load", (Runnable) new Runnable() {
                public void run() {
                    String str = "loadAd";
                    String str2 = "MediationAdapterWrapper";
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        C1227o e = C0999i.this.f1927c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed start loading ");
                        sb.append(aVar);
                        e.mo10379b(str2, sb.toString(), th);
                        C0999i.this.f1935k.m1829a(str, -1);
                    }
                    if (!C0999i.this.f1938n.get()) {
                        long D = C0999i.this.f1929e.mo9467D();
                        if (D == 0) {
                            C1227o e2 = C0999i.this.f1927c;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failing ad ");
                            sb2.append(aVar);
                            sb2.append(" since it has 0 timeout");
                            e2.mo10378b(str2, sb2.toString());
                            C0999i.this.f1935k.m1829a(str, (int) MaxErrorCodes.MEDIATION_ADAPTER_IMMEDIATE_TIMEOUT);
                        } else if (D > 0) {
                            C1227o e3 = C0999i.this.f1927c;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Setting timeout ");
                            sb3.append(D);
                            sb3.append("ms. for ");
                            sb3.append(aVar);
                            e3.mo10378b(str2, sb3.toString());
                            C0999i.this.f1926b.mo10185K().mo10132a(new C1033c(), C1161a.MEDIATION_TIMEOUT, D);
                        } else {
                            C1227o e4 = C0999i.this.f1927c;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Negative timeout set for ");
                            sb4.append(aVar);
                            sb4.append(", not scheduling a timeout");
                            e4.mo10378b(str2, sb4.toString());
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    /* renamed from: b */
    public String mo9556b() {
        return this.f1928d;
    }

    /* renamed from: c */
    public boolean mo9557c() {
        return this.f1937m.get();
    }

    /* renamed from: d */
    public boolean mo9558d() {
        return this.f1938n.get() && this.f1939o.get();
    }

    /* renamed from: e */
    public String mo9559e() {
        MaxAdapter maxAdapter = this.f1931g;
        if (maxAdapter != null) {
            try {
                return maxAdapter.getSdkVersion();
            } catch (Throwable th) {
                C1227o oVar = this.f1927c;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to get adapter's SDK version, marking ");
                sb.append(this);
                sb.append(" as disabled");
                oVar.mo10379b("MediationAdapterWrapper", sb.toString(), th);
                m1796a("fail_version");
            }
        }
        return null;
    }

    /* renamed from: f */
    public String mo9560f() {
        MaxAdapter maxAdapter = this.f1931g;
        if (maxAdapter != null) {
            try {
                return maxAdapter.getAdapterVersion();
            } catch (Throwable th) {
                C1227o oVar = this.f1927c;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to get adapter version, marking ");
                sb.append(this);
                sb.append(" as disabled");
                oVar.mo10379b("MediationAdapterWrapper", sb.toString(), th);
                m1796a("fail_version");
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public void mo9561g() {
        m1798a("destroy", (Runnable) new Runnable() {
            public void run() {
                C0999i.this.m1796a("destroy");
                C0999i.this.f1931g.onDestroy();
                C0999i.this.f1931g = null;
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediationAdapterWrapper{adapterTag='");
        sb.append(this.f1930f);
        sb.append("'");
        sb.append('}');
        return sb.toString();
    }
}
