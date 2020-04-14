package com.applovin.impl.mediation.ads;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.p014b.C0959b;
import com.applovin.impl.mediation.p016d.C0990c;
import com.applovin.impl.sdk.C1119d;
import com.applovin.impl.sdk.C1119d.C1121a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.C1238u;
import com.applovin.impl.sdk.C1287v;
import com.applovin.impl.sdk.C1287v.C1290a;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.p021d.C1127ac;
import com.applovin.impl.sdk.utils.C1240b;
import com.applovin.impl.sdk.utils.C1245f;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.impl.sdk.utils.C1282p;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.TimeUnit;

public class MaxAdViewImpl extends C0955a implements C1121a, C1290a {

    /* renamed from: q */
    private static final int[] f1769q = {10, 14};
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f1770a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final MaxAdView f1771b;

    /* renamed from: c */
    private final View f1772c;

    /* renamed from: d */
    private long f1773d = Long.MAX_VALUE;

    /* renamed from: e */
    private C0959b f1774e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f1775f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C0941a f1776g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C0943c f1777h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C1119d f1778i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C1238u f1779j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C1287v f1780k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Object f1781l = new Object();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C0959b f1782m = null;

    /* renamed from: n */
    private boolean f1783n;

    /* renamed from: o */
    private boolean f1784o;

    /* renamed from: p */
    private boolean f1785p = false;

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$a */
    private class C0941a extends C0942b {
        private C0941a() {
            super();
        }

        public void onAdLoadFailed(String str, int i) {
            C1248i.m2997a(MaxAdViewImpl.this.adListener, str, i);
            MaxAdViewImpl.this.m1527a(i);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (maxAd instanceof C0959b) {
                C0959b bVar = (C0959b) maxAd;
                bVar.mo9491d(MaxAdViewImpl.this.f1775f);
                MaxAdViewImpl.this.m1538a(bVar);
                if (bVar.mo9468E()) {
                    long F = bVar.mo9469F();
                    C1227o v = MaxAdViewImpl.this.sdk.mo10249v();
                    String str = MaxAdViewImpl.this.tag;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Scheduling banner ad refresh ");
                    sb.append(F);
                    sb.append(" milliseconds from now for '");
                    sb.append(MaxAdViewImpl.this.adUnitId);
                    sb.append("'...");
                    v.mo10378b(str, sb.toString());
                    MaxAdViewImpl.this.f1778i.mo10056a(F);
                }
                C1248i.m2994a(MaxAdViewImpl.this.adListener, maxAd);
                return;
            }
            C1227o oVar = MaxAdViewImpl.this.logger;
            String str2 = MaxAdViewImpl.this.tag;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Not a MediatedAdViewAd received: ");
            sb2.append(maxAd);
            oVar.mo10382e(str2, sb2.toString());
            onAdLoadFailed(MaxAdViewImpl.this.adUnitId, -5201);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$b */
    private abstract class C0942b implements MaxAdListener, MaxAdViewAdListener {
        private C0942b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f1782m)) {
                C1248i.m3015d(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f1782m)) {
                if (MaxAdViewImpl.this.f1782m.mo9447t()) {
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                C1248i.m3019h(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
            if (maxAd.equals(MaxAdViewImpl.this.f1782m)) {
                C1248i.m2995a(MaxAdViewImpl.this.adListener, maxAd, i);
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f1782m)) {
                C1248i.m3009b(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f1782m)) {
                if (MaxAdViewImpl.this.f1782m.mo9447t()) {
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                C1248i.m3018g(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f1782m)) {
                C1248i.m3013c(MaxAdViewImpl.this.adListener, maxAd);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$c */
    private class C0943c extends C0942b {
        private C0943c() {
            super();
        }

        public void onAdLoadFailed(String str, int i) {
            C1227o oVar = MaxAdViewImpl.this.logger;
            String str2 = MaxAdViewImpl.this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to pre-cache ad for refresh with error code ");
            sb.append(i);
            oVar.mo10378b(str2, sb.toString());
            MaxAdViewImpl.this.m1527a(i);
        }

        public void onAdLoaded(MaxAd maxAd) {
            MaxAdViewImpl.this.logger.mo10378b(MaxAdViewImpl.this.tag, "Successfully pre-cached ad for refresh");
            MaxAdViewImpl.this.m1541a(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdView maxAdView, View view, C1192i iVar, Activity activity) {
        super(str, MaxAdFormat.BANNER, "MaxAdView", iVar);
        if (activity != null) {
            this.f1770a = activity;
            this.f1771b = maxAdView;
            this.f1772c = view;
            this.f1776g = new C0941a();
            this.f1777h = new C0943c();
            this.f1778i = new C1119d(iVar, this);
            this.f1779j = new C1238u(maxAdView, iVar);
            this.f1780k = new C1287v(maxAdView, iVar, this);
            C1227o oVar = this.logger;
            String str2 = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Created new MaxAdView (");
            sb.append(this);
            sb.append(")");
            oVar.mo10378b(str2, sb.toString());
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1526a() {
        C0959b bVar;
        MaxAdView maxAdView = this.f1771b;
        if (maxAdView != null) {
            C1240b.m2916a(maxAdView, this.f1772c);
        }
        this.f1780k.mo10469a();
        synchronized (this.f1781l) {
            bVar = this.f1782m;
        }
        if (bVar != null) {
            this.sdk.mo10252y().destroyAd(bVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1527a(int i) {
        String str = "'...";
        if (this.sdk.mo10224b((C1096c) C1095b.f2269t).contains(String.valueOf(i))) {
            C1227o v = this.sdk.mo10249v();
            String str2 = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring banner ad refresh for error code '");
            sb.append(i);
            sb.append(str);
            v.mo10378b(str2, sb.toString());
            return;
        }
        this.f1783n = true;
        long longValue = ((Long) this.sdk.mo10202a(C1095b.f2268s)).longValue();
        if (longValue >= 0) {
            C1227o v2 = this.sdk.mo10249v();
            String str3 = this.tag;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Scheduling failed banner ad refresh ");
            sb2.append(longValue);
            sb2.append(" milliseconds from now for '");
            sb2.append(this.adUnitId);
            sb2.append(str);
            v2.mo10378b(str3, sb2.toString());
            this.f1778i.mo10056a(longValue);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1528a(long j) {
        if (C1281o.m3089a(j, ((Long) this.sdk.mo10202a(C1095b.f2235C)).longValue())) {
            C1227o oVar = this.logger;
            String str = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Undesired flags matched - current: ");
            sb.append(Long.toBinaryString(j));
            sb.append(", undesired: ");
            sb.append(Long.toBinaryString(j));
            oVar.mo10378b(str, sb.toString());
            this.logger.mo10378b(this.tag, "Waiting for refresh timer to manually fire request");
            this.f1783n = true;
            return;
        }
        this.logger.mo10378b(this.tag, "No undesired viewability flags matched - scheduling viewability");
        this.f1783n = false;
        m1544b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1529a(AnimatorListenerAdapter animatorListenerAdapter) {
        C0959b bVar = this.f1782m;
        if (bVar == null || bVar.mo9439l() == null) {
            animatorListenerAdapter.onAnimationEnd(null);
            return;
        }
        View l = this.f1782m.mo9439l();
        l.animate().alpha(0.0f).setDuration(((Long) this.sdk.mo10202a(C1095b.f2275z)).longValue()).setListener(animatorListenerAdapter).start();
    }

    /* renamed from: a */
    private void m1530a(View view, C0959b bVar) {
        int j = bVar.mo9437j();
        int k = bVar.mo9438k();
        int i = -1;
        int dpToPx = j == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), j);
        if (k != -1) {
            i = AppLovinSdkUtils.dpToPx(view.getContext(), k);
        }
        int height = this.f1771b.getHeight();
        int width = this.f1771b.getWidth();
        if ((height > 0 && height < i) || (width > 0 && width < dpToPx)) {
            int pxToDp = AppLovinSdkUtils.pxToDp(view.getContext(), height);
            int pxToDp2 = AppLovinSdkUtils.pxToDp(view.getContext(), width);
            StringBuilder sb = new StringBuilder();
            sb.append("\n**************************************************\n`MaxAdView` size ");
            sb.append(pxToDp2);
            String str = "x";
            sb.append(str);
            sb.append(pxToDp);
            sb.append(" dp smaller than required size: ");
            sb.append(j);
            sb.append(str);
            sb.append(k);
            sb.append(" dp\n**************************************************\n");
            C1227o.m2840h("AppLovinSdk", sb.toString());
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, i);
        } else {
            layoutParams.width = dpToPx;
            layoutParams.height = i;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            C1227o oVar = this.logger;
            String str2 = this.tag;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Pinning ad view to MAX ad view with width: ");
            sb2.append(dpToPx);
            sb2.append(" and height: ");
            sb2.append(i);
            sb2.append(".");
            oVar.mo10378b(str2, sb2.toString());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int addRule : C1245f.m2932c() ? C1282p.m3120a(this.f1771b.getGravity(), 10, 14) : f1769q) {
                layoutParams2.addRule(addRule);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1538a(final C0959b bVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                String str;
                String str2;
                C1227o oVar;
                if (bVar.mo9439l() != null) {
                    final MaxAdView d = MaxAdViewImpl.this.f1771b;
                    if (d != null) {
                        MaxAdViewImpl.this.m1529a((AnimatorListenerAdapter) new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                MaxAdViewImpl.this.m1526a();
                                if (bVar.mo9445r()) {
                                    MaxAdViewImpl.this.f1780k.mo10470a((Context) MaxAdViewImpl.this.f1770a, bVar);
                                }
                                MaxAdViewImpl.this.m1540a(bVar, d);
                                synchronized (MaxAdViewImpl.this.f1781l) {
                                    MaxAdViewImpl.this.f1782m = bVar;
                                }
                                MaxAdViewImpl.this.logger.mo10378b(MaxAdViewImpl.this.tag, "Scheduling impression for ad manually...");
                                MaxAdViewImpl.this.sdk.mo10252y().maybeScheduleRawAdImpressionPostback(bVar);
                                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                                    public void run() {
                                        long a = MaxAdViewImpl.this.f1779j.mo10405a(bVar);
                                        if (!bVar.mo9445r()) {
                                            MaxAdViewImpl.this.m1539a(bVar, a);
                                        }
                                        MaxAdViewImpl.this.m1528a(a);
                                    }
                                }, bVar.mo9440m());
                            }
                        });
                        return;
                    }
                    oVar = MaxAdViewImpl.this.logger;
                    str2 = MaxAdViewImpl.this.tag;
                    str = "Max ad view does not have a parent View";
                } else {
                    oVar = MaxAdViewImpl.this.logger;
                    str2 = MaxAdViewImpl.this.tag;
                    str = "Max ad does not have a loaded ad view";
                }
                oVar.mo10382e(str2, str);
                MaxAdViewImpl.this.f1776g.onAdDisplayFailed(bVar, -5201);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1539a(C0959b bVar, long j) {
        this.logger.mo10378b(this.tag, "Scheduling viewability impression for ad...");
        this.sdk.mo10252y().maybeScheduleViewabilityAdImpressionPostback(bVar, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1540a(C0959b bVar, MaxAdView maxAdView) {
        View l = bVar.mo9439l();
        l.setAlpha(0.0f);
        if (bVar.mo9448u() != Long.MAX_VALUE) {
            this.f1772c.setBackgroundColor((int) bVar.mo9448u());
        } else {
            long j = this.f1773d;
            if (j != Long.MAX_VALUE) {
                this.f1772c.setBackgroundColor((int) j);
            } else {
                this.f1772c.setBackgroundColor(0);
            }
        }
        maxAdView.addView(l);
        m1530a(l, bVar);
        l.animate().alpha(1.0f).setDuration(((Long) this.sdk.mo10202a(C1095b.f2274y)).longValue()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1541a(MaxAd maxAd) {
        if (this.f1784o) {
            this.f1784o = false;
            C1227o oVar = this.logger;
            String str = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Rendering precache request ad: ");
            sb.append(maxAd.getAdUnitId());
            sb.append("...");
            oVar.mo10378b(str, sb.toString());
            this.f1776g.onAdLoaded(maxAd);
            return;
        }
        this.f1774e = (C0959b) maxAd;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1542a(final MaxAdListener maxAdListener) {
        if (m1549d()) {
            C1227o.m2841i(this.tag, "Unable to load new ad; ad is already destroyed");
            C1248i.m2997a(this.adListener, this.adUnitId, -1);
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                String str = "viewability_flags";
                String str2 = "visible_ad_ad_unit_id";
                if (MaxAdViewImpl.this.f1782m != null) {
                    MaxAdViewImpl.this.loadRequestBuilder.mo9538a(str2, MaxAdViewImpl.this.f1782m.getAdUnitId()).mo9538a(str, String.valueOf(MaxAdViewImpl.this.f1779j.mo10405a(MaxAdViewImpl.this.f1782m)));
                } else {
                    MaxAdViewImpl.this.loadRequestBuilder.mo9537a(str2).mo9537a(str);
                }
                C1227o oVar = MaxAdViewImpl.this.logger;
                String str3 = MaxAdViewImpl.this.tag;
                StringBuilder sb = new StringBuilder();
                sb.append("Loading banner ad for '");
                sb.append(MaxAdViewImpl.this.adUnitId);
                sb.append("' and notifying ");
                sb.append(maxAdListener);
                sb.append("...");
                oVar.mo10378b(str3, sb.toString());
                MaxAdViewImpl.this.sdk.mo10252y().loadAd(MaxAdViewImpl.this.adUnitId, MaxAdViewImpl.this.adFormat, MaxAdViewImpl.this.loadRequestBuilder.mo9539a(), false, MaxAdViewImpl.this.f1770a, maxAdListener);
            }
        });
    }

    /* renamed from: b */
    private void m1544b() {
        if (m1547c()) {
            long longValue = ((Long) this.sdk.mo10202a(C1095b.f2236D)).longValue();
            C1227o oVar = this.logger;
            String str = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling refresh precache request in ");
            sb.append(TimeUnit.MICROSECONDS.toSeconds(longValue));
            sb.append(" seconds...");
            oVar.mo10378b(str, sb.toString());
            this.sdk.mo10185K().mo10132a(new C1127ac(this.sdk, new Runnable() {
                public void run() {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.m1542a((MaxAdListener) maxAdViewImpl.f1777h);
                }
            }), C0990c.m1769a(this.adFormat), longValue);
        }
    }

    /* renamed from: c */
    private boolean m1547c() {
        return ((Long) this.sdk.mo10202a(C1095b.f2236D)).longValue() > 0;
    }

    /* renamed from: d */
    private boolean m1549d() {
        boolean z;
        synchronized (this.f1781l) {
            z = this.f1785p;
        }
        return z;
    }

    public void destroy() {
        m1526a();
        synchronized (this.f1781l) {
            this.f1785p = true;
        }
        this.f1778i.mo10059c();
    }

    public String getPlacement() {
        return this.f1775f;
    }

    public void loadAd() {
        C1227o oVar = this.logger;
        String str = this.tag;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this);
        sb.append(" Loading ad for ");
        sb.append(this.adUnitId);
        sb.append("...");
        oVar.mo10378b(str, sb.toString());
        if (m1549d()) {
            C1227o.m2841i(this.tag, "Unable to load new ad; ad is already destroyed");
            C1248i.m2997a(this.adListener, this.adUnitId, -1);
        } else if (!((Boolean) this.sdk.mo10202a(C1095b.f2237E)).booleanValue() || !this.f1778i.mo10057a()) {
            m1542a((MaxAdListener) this.f1776g);
        } else {
            String str2 = this.tag;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to load a new ad. An ad refresh has already been scheduled in ");
            sb2.append(TimeUnit.MILLISECONDS.toSeconds(this.f1778i.mo10058b()));
            sb2.append(" seconds.");
            C1227o.m2841i(str2, sb2.toString());
        }
    }

    public void onAdRefresh() {
        String str;
        String str2;
        C1227o oVar;
        this.f1784o = false;
        if (this.f1774e != null) {
            C1227o oVar2 = this.logger;
            String str3 = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Refreshing for cached ad: ");
            sb.append(this.f1774e.getAdUnitId());
            sb.append("...");
            oVar2.mo10378b(str3, sb.toString());
            this.f1776g.onAdLoaded(this.f1774e);
            this.f1774e = null;
            return;
        }
        if (!m1547c()) {
            oVar = this.logger;
            str2 = this.tag;
            str = "Refreshing ad from network...";
        } else if (this.f1783n) {
            oVar = this.logger;
            str2 = this.tag;
            str = "Refreshing ad from network due to viewability requirements not met for refresh request...";
        } else {
            this.logger.mo10382e(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            this.f1784o = true;
            return;
        }
        oVar.mo10378b(str2, str);
        loadAd();
    }

    public void onLogVisibilityImpression() {
        m1539a(this.f1782m, this.f1779j.mo10405a(this.f1782m));
    }

    public void onWindowVisibilityChanged(int i) {
        if (((Boolean) this.sdk.mo10202a(C1095b.f2273x)).booleanValue() && this.f1778i.mo10057a()) {
            if (C1282p.m3118a(i)) {
                this.logger.mo10378b(this.tag, "Ad view visible");
                this.f1778i.mo10063g();
                return;
            }
            this.logger.mo10378b(this.tag, "Ad view hidden");
            this.f1778i.mo10062f();
        }
    }

    public void setPlacement(String str) {
        this.f1775f = str;
    }

    public void setPublisherBackgroundColor(int i) {
        this.f1773d = (long) i;
    }

    public void startAutoRefresh() {
        this.f1778i.mo10061e();
        C1227o oVar = this.logger;
        String str = this.tag;
        StringBuilder sb = new StringBuilder();
        sb.append("Resumed auto-refresh with remaining time: ");
        sb.append(this.f1778i.mo10058b());
        oVar.mo10378b(str, sb.toString());
    }

    public void stopAutoRefresh() {
        if (this.f1782m != null) {
            C1227o oVar = this.logger;
            String str = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Pausing auto-refresh with remaining time: ");
            sb.append(this.f1778i.mo10058b());
            oVar.mo10378b(str, sb.toString());
            this.f1778i.mo10060d();
            return;
        }
        C1227o.m2840h(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxAdView{adUnitId='");
        sb.append(this.adUnitId);
        sb.append('\'');
        sb.append(", adListener=");
        sb.append(this.adListener);
        sb.append(", isDestroyed=");
        sb.append(m1549d());
        sb.append('}');
        return sb.toString();
    }
}
