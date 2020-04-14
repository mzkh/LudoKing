package com.applovin.impl.mediation;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.C0994f.C0996a;
import com.applovin.impl.mediation.p014b.C0958a;
import com.applovin.impl.mediation.p014b.C0959b;
import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.mediation.p014b.C0962e;
import com.applovin.impl.mediation.p014b.C0963f;
import com.applovin.impl.mediation.p014b.C0963f.C0964a;
import com.applovin.impl.mediation.p014b.C0965g;
import com.applovin.impl.mediation.p015c.C0971b;
import com.applovin.impl.mediation.p015c.C0971b.C0975a;
import com.applovin.impl.mediation.p015c.C0976c;
import com.applovin.impl.mediation.p015c.C0978d;
import com.applovin.impl.mediation.p015c.C0985g;
import com.applovin.impl.mediation.p015c.C0986h;
import com.applovin.impl.mediation.p016d.C0990c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter.InitializationStatus;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class MediationServiceImpl {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1192i f1652a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1227o f1653b;

    /* renamed from: com.applovin.impl.mediation.MediationServiceImpl$a */
    private class C0904a implements C0987d, MaxAdViewAdListener, MaxRewardedAdListener {

        /* renamed from: b */
        private final C0958a f1672b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final MaxAdListener f1673c;

        private C0904a(C0958a aVar, MaxAdListener maxAdListener) {
            this.f1672b = aVar;
            this.f1673c = maxAdListener;
        }

        /* renamed from: a */
        public void mo9283a(MaxAd maxAd, C0993e eVar) {
            MediationServiceImpl.this.m1416b(this.f1672b, eVar, this.f1673c);
            if (maxAd.getFormat() == MaxAdFormat.REWARDED && (maxAd instanceof C0960c)) {
                ((C0960c) maxAd).mo9462u();
            }
        }

        /* renamed from: a */
        public void mo9284a(String str, C0993e eVar) {
            MediationServiceImpl.this.m1406a(this.f1672b, eVar, this.f1673c);
        }

        public void onAdClicked(MaxAd maxAd) {
            MediationServiceImpl.this.f1652a.mo10219ac().mo10159a((C0958a) maxAd, "DID_CLICKED");
            MediationServiceImpl.this.m1417c(this.f1672b);
            C1248i.m3015d(this.f1673c, maxAd);
        }

        public void onAdCollapsed(MaxAd maxAd) {
            C1248i.m3019h(this.f1673c, maxAd);
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
            MediationServiceImpl.this.m1416b(this.f1672b, new C0993e(i), this.f1673c);
        }

        public void onAdDisplayed(MaxAd maxAd) {
            MediationServiceImpl.this.f1653b.mo10378b("MediationService", "Scheduling impression for ad via callback...");
            MediationServiceImpl.this.maybeScheduleCallbackAdImpressionPostback(this.f1672b);
            if (maxAd.getFormat() == MaxAdFormat.INTERSTITIAL || maxAd.getFormat() == MaxAdFormat.REWARDED) {
                MediationServiceImpl.this.f1652a.mo10200Z().mo10285c();
            }
            C1248i.m3009b(this.f1673c, maxAd);
        }

        public void onAdExpanded(MaxAd maxAd) {
            C1248i.m3018g(this.f1673c, maxAd);
        }

        public void onAdHidden(final MaxAd maxAd) {
            MediationServiceImpl.this.f1652a.mo10219ac().mo10159a((C0958a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (maxAd.getFormat() == MaxAdFormat.INTERSTITIAL || maxAd.getFormat() == MaxAdFormat.REWARDED) {
                        MediationServiceImpl.this.f1652a.mo10200Z().mo10286d();
                    }
                    C1248i.m3013c(C0904a.this.f1673c, maxAd);
                }
            }, maxAd instanceof C0962e ? ((C0962e) maxAd).mo9472I() : 0);
        }

        public void onAdLoadFailed(String str, int i) {
            MediationServiceImpl.this.m1406a(this.f1672b, new C0993e(i), this.f1673c);
        }

        public void onAdLoaded(MaxAd maxAd) {
            MediationServiceImpl.this.m1415b(this.f1672b);
            C1248i.m2994a(this.f1673c, maxAd);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1248i.m3017f(this.f1673c, maxAd);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1248i.m3016e(this.f1673c, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1248i.m2996a(this.f1673c, maxAd, maxReward);
            MediationServiceImpl.this.f1652a.mo10185K().mo10131a((C1122a) new C0985g((C0960c) maxAd, MediationServiceImpl.this.f1652a), C1161a.MEDIATION_REWARD);
        }
    }

    public MediationServiceImpl(C1192i iVar) {
        this.f1652a = iVar;
        this.f1653b = iVar.mo10249v();
    }

    /* renamed from: a */
    private void m1405a(C0958a aVar) {
        C1227o oVar = this.f1653b;
        StringBuilder sb = new StringBuilder();
        sb.append("Firing ad preload postback for ");
        sb.append(aVar.mo9495z());
        oVar.mo10378b("MediationService", sb.toString());
        m1408a("mpreload", (C0962e) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1406a(C0958a aVar, C0993e eVar, MaxAdListener maxAdListener) {
        m1407a(eVar, aVar);
        destroyAd(aVar);
        C1248i.m2997a(maxAdListener, aVar.getAdUnitId(), eVar.getErrorCode());
    }

    /* renamed from: a */
    private void m1407a(C0993e eVar, C0958a aVar) {
        long f = aVar.mo9431f();
        C1227o oVar = this.f1653b;
        StringBuilder sb = new StringBuilder();
        sb.append("Firing ad load failure postback with load time: ");
        sb.append(f);
        oVar.mo10378b("MediationService", sb.toString());
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(f));
        m1411a("mlerr", (Map<String, String>) hashMap, eVar, (C0962e) aVar);
    }

    /* renamed from: a */
    private void m1408a(String str, C0962e eVar) {
        m1411a(str, Collections.EMPTY_MAP, (C0993e) null, eVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1409a(String str, C0965g gVar) {
        m1411a("serr", Collections.EMPTY_MAP, new C0993e(str), (C0962e) gVar);
    }

    /* renamed from: a */
    private void m1410a(String str, Map<String, String> map, C0962e eVar) {
        m1411a(str, map, (C0993e) null, eVar);
    }

    /* renamed from: a */
    private void m1411a(String str, Map<String, String> map, C0993e eVar, C0962e eVar2) {
        HashMap hashMap = new HashMap(map);
        String str2 = "";
        hashMap.put("{PLACEMENT}", eVar2.mo9473J() != null ? eVar2.mo9473J() : str2);
        if (eVar2 instanceof C0960c) {
            C0960c cVar = (C0960c) eVar2;
            if (cVar.mo9453m() != null) {
                str2 = cVar.mo9453m();
            }
            hashMap.put("{PUBLISHER_AD_UNIT_ID}", str2);
        }
        C0978d dVar = new C0978d(str, hashMap, eVar, eVar2, this.f1652a);
        this.f1652a.mo10185K().mo10131a((C1122a) dVar, C1161a.MEDIATION_POSTBACKS);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1415b(C0958a aVar) {
        long f = aVar.mo9431f();
        C1227o oVar = this.f1653b;
        StringBuilder sb = new StringBuilder();
        sb.append("Firing ad load success postback with load time: ");
        sb.append(f);
        oVar.mo10378b("MediationService", sb.toString());
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(f));
        m1410a("load", (Map<String, String>) hashMap, (C0962e) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1416b(C0958a aVar, C0993e eVar, MaxAdListener maxAdListener) {
        this.f1652a.mo10219ac().mo10159a(aVar, "DID_FAIL_DISPLAY");
        maybeScheduleAdDisplayErrorPostback(eVar, aVar);
        if (aVar.mo9435h().compareAndSet(false, true)) {
            C1248i.m2995a(maxAdListener, (MaxAd) aVar, eVar.getErrorCode());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1417c(C0958a aVar) {
        m1408a("mclick", (C0962e) aVar);
    }

    public void collectSignal(MaxAdFormat maxAdFormat, final C0965g gVar, Activity activity, final C0964a aVar) {
        String str;
        C1227o oVar;
        String str2;
        StringBuilder sb;
        if (gVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (aVar != null) {
            final C0999i a = this.f1652a.mo10250w().mo9547a((C0962e) gVar);
            if (a != null) {
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.m1400a(gVar, maxAdFormat, activity.getApplicationContext());
                a.mo9552a((MaxAdapterInitializationParameters) a2, activity);
                C09034 r1 = new MaxSignalCollectionListener() {
                    public void onSignalCollected(String str) {
                        aVar.mo9502a(C0963f.m1662a(gVar, a, str));
                    }

                    public void onSignalCollectionFailed(String str) {
                        MediationServiceImpl.this.m1409a(str, gVar);
                        aVar.mo9502a(C0963f.m1664b(gVar, a, str));
                    }
                };
                String str3 = "MediationService";
                if (!gVar.mo9503b()) {
                    oVar = this.f1653b;
                    sb = new StringBuilder();
                    str2 = "Collecting signal for adapter: ";
                } else if (this.f1652a.mo10251x().mo9544a((C0962e) gVar)) {
                    oVar = this.f1653b;
                    sb = new StringBuilder();
                    str2 = "Collecting signal for now-initialized adapter: ";
                } else {
                    C1227o oVar2 = this.f1653b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Skip collecting signal for not-initialized adapter: ");
                    sb2.append(a.mo9556b());
                    oVar2.mo10382e(str3, sb2.toString());
                    str = "Adapter not initialized yet";
                }
                sb.append(str2);
                sb.append(a.mo9556b());
                oVar.mo10378b(str3, sb.toString());
                a.mo9553a(a2, gVar, activity, r1);
                return;
            }
            str = "Could not load adapter";
            aVar.mo9502a(C0963f.m1663a(gVar, str));
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof C0958a) {
            C1227o oVar = this.f1653b;
            StringBuilder sb = new StringBuilder();
            sb.append("Destroying ");
            sb.append(maxAd);
            oVar.mo10380c("MediationService", sb.toString());
            C0958a aVar = (C0958a) maxAd;
            C0999i c = aVar.mo9428c();
            if (c != null) {
                c.mo9561g();
                aVar.mo9436i();
            }
        }
    }

    public void loadAd(String str, MaxAdFormat maxAdFormat, C0994f fVar, boolean z, Activity activity, MaxAdListener maxAdListener) {
        final MaxAdListener maxAdListener2 = maxAdListener;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (maxAdListener2 != null) {
            if (!this.f1652a.mo10230d()) {
                C1227o.m2840h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
            }
            this.f1652a.mo10205a();
            MaxAdFormat maxAdFormat2 = maxAdFormat;
            final C0960c a = this.f1652a.mo10177B().mo9619a(maxAdFormat);
            if (a != null) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        maxAdListener2.onAdLoaded(a);
                    }
                }, a.mo9451k());
            }
            C1192i iVar = this.f1652a;
            final C0994f fVar2 = fVar;
            final String str2 = str;
            final MaxAdFormat maxAdFormat3 = maxAdFormat;
            final Activity activity2 = activity;
            final MaxAdListener maxAdListener3 = maxAdListener;
            C09012 r0 = new C0975a() {
                /* renamed from: a */
                public void mo9279a(JSONArray jSONArray) {
                    C0994f fVar = fVar2;
                    if (fVar == null) {
                        fVar = new C0996a().mo9539a();
                    }
                    C0976c cVar = new C0976c(str2, maxAdFormat3, fVar, jSONArray, activity2, MediationServiceImpl.this.f1652a, maxAdListener3);
                    MediationServiceImpl.this.f1652a.mo10185K().mo10130a((C1122a) cVar);
                }
            };
            C0971b bVar = new C0971b(maxAdFormat, z, activity, iVar, r0);
            this.f1652a.mo10185K().mo10131a((C1122a) bVar, C0990c.m1769a(maxAdFormat));
        } else {
            throw new IllegalArgumentException("No listener specified");
        }
    }

    public void loadThirdPartyMediatedAd(String str, C0958a aVar, Activity activity, MaxAdListener maxAdListener) {
        if (aVar != null) {
            C1227o oVar = this.f1653b;
            StringBuilder sb = new StringBuilder();
            sb.append("Loading ");
            sb.append(aVar);
            sb.append("...");
            String str2 = "MediationService";
            oVar.mo10378b(str2, sb.toString());
            this.f1652a.mo10219ac().mo10159a(aVar, "WILL_LOAD");
            m1405a(aVar);
            C0999i a = this.f1652a.mo10250w().mo9547a((C0962e) aVar);
            if (a != null) {
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.m1398a(aVar, activity.getApplicationContext());
                a.mo9552a((MaxAdapterInitializationParameters) a2, activity);
                C0958a a3 = aVar.mo9425a(a);
                a.mo9554a(str, a3);
                a3.mo9432g();
                a.mo9555a(str, a2, a3, activity, new C0904a(a3, maxAdListener));
                return;
            }
            C1227o oVar2 = this.f1653b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to load ");
            sb2.append(aVar);
            sb2.append(": adapter not loaded");
            oVar2.mo10381d(str2, sb2.toString());
            m1406a(aVar, new C0993e((int) MaxErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED), maxAdListener);
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    public void maybeScheduleAdDisplayErrorPostback(C0993e eVar, C0958a aVar) {
        m1411a("mierr", Collections.EMPTY_MAP, eVar, (C0962e) aVar);
    }

    public void maybeScheduleAdapterInitializationPostback(C0962e eVar, long j, InitializationStatus initializationStatus, String str) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        hashMap.put("{INIT_TIME_MS}", String.valueOf(j));
        m1411a("minit", (Map<String, String>) hashMap, new C0993e(str), eVar);
    }

    public void maybeScheduleCallbackAdImpressionPostback(C0958a aVar) {
        m1408a("mcimp", (C0962e) aVar);
    }

    public void maybeScheduleRawAdImpressionPostback(C0958a aVar) {
        this.f1652a.mo10219ac().mo10159a(aVar, "WILL_DISPLAY");
        m1408a("mimp", (C0962e) aVar);
    }

    public void maybeScheduleViewabilityAdImpressionPostback(C0959b bVar, long j) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        hashMap.put("{USED_VIEWABILITY_TIMER}", String.valueOf(bVar.mo9445r()));
        m1410a("mvimp", (Map<String, String>) hashMap, (C0962e) bVar);
    }

    public void showFullscreenAd(MaxAd maxAd, String str, final Activity activity) {
        if (maxAd == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null) {
            String str2 = "MediationService";
            if (maxAd instanceof C0960c) {
                this.f1652a.mo10200Z().mo10281a(true);
                final C0960c cVar = (C0960c) maxAd;
                final C0999i c = cVar.mo9428c();
                if (c != null) {
                    cVar.mo9491d(str);
                    long G = cVar.mo9470G();
                    C1227o oVar = this.f1653b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Showing ad ");
                    sb.append(maxAd.getAdUnitId());
                    sb.append(" with delay of ");
                    sb.append(G);
                    sb.append("ms...");
                    oVar.mo10380c(str2, sb.toString());
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                        public void run() {
                            if (cVar.getFormat() == MaxAdFormat.REWARDED) {
                                MediationServiceImpl.this.f1652a.mo10185K().mo10131a((C1122a) new C0986h(cVar, MediationServiceImpl.this.f1652a), C1161a.MEDIATION_REWARD);
                            }
                            c.mo9551a((C0958a) cVar, activity);
                            MediationServiceImpl.this.f1652a.mo10200Z().mo10281a(false);
                            MediationServiceImpl.this.f1653b.mo10378b("MediationService", "Scheduling impression for ad manually...");
                            MediationServiceImpl.this.maybeScheduleRawAdImpressionPostback(cVar);
                        }
                    }, G);
                    return;
                }
                this.f1652a.mo10200Z().mo10281a(false);
                C1227o oVar2 = this.f1653b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to show ");
                sb2.append(maxAd);
                sb2.append(": adapter not found");
                oVar2.mo10381d(str2, sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("There may be an integration problem with the adapter for ad unit id '");
                sb3.append(cVar.getAdUnitId());
                sb3.append("'. Please check if you have a supported version of that SDK integrated into your project.");
                C1227o.m2841i(str2, sb3.toString());
                throw new IllegalStateException("Could not find adapter for provided ad");
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unable to show ad for '");
            sb4.append(maxAd.getAdUnitId());
            sb4.append("': only REWARDED or INTERSTITIAL ads are eligible for showFullscreenAd(). ");
            sb4.append(maxAd.getFormat());
            sb4.append(" ad was provided.");
            C1227o.m2841i(str2, sb4.toString());
            throw new IllegalArgumentException("Provided ad is not a MediatedFullscreenAd");
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }
}
