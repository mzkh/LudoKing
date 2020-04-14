package com.applovin.impl.mediation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.mediation.C0994f.C0996a;
import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1278m;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.j */
public class C1035j {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<C1040b> f2010a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    private final C1037a f2011b;

    /* renamed from: c */
    private final C1037a f2012c;

    /* renamed from: com.applovin.impl.mediation.j$a */
    private static class C1037a extends BroadcastReceiver implements MaxAdListener, MaxRewardedAdListener {

        /* renamed from: a */
        private final C1192i f2013a;

        /* renamed from: b */
        private final C1035j f2014b;

        /* renamed from: c */
        private final MaxAdFormat f2015c;

        /* renamed from: d */
        private final C1096c<String> f2016d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public MaxAdListener f2017e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public C0960c f2018f;

        /* renamed from: g */
        private final Object f2019g;

        /* renamed from: h */
        private C1278m f2020h;

        /* renamed from: i */
        private long f2021i;

        /* renamed from: j */
        private final AtomicBoolean f2022j;

        /* renamed from: k */
        private volatile boolean f2023k;

        private C1037a(C1096c<String> cVar, MaxAdFormat maxAdFormat, C1035j jVar, C1192i iVar) {
            this.f2019g = new Object();
            this.f2022j = new AtomicBoolean();
            this.f2014b = jVar;
            this.f2013a = iVar;
            this.f2016d = cVar;
            this.f2015c = maxAdFormat;
            iVar.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            iVar.mo10220ad().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
        }

        /* renamed from: a */
        private void m1849a(long j) {
            if (j > 0) {
                this.f2021i = System.currentTimeMillis() + j;
                this.f2020h = C1278m.m3045a(j, this.f2013a, new Runnable() {
                    public void run() {
                        C1037a.this.m1855b(true);
                    }
                });
            }
        }

        /* renamed from: a */
        private void m1852a(boolean z) {
            if (this.f2013a.mo10199Y().mo10396a()) {
                this.f2023k = z;
                this.f2022j.set(true);
                return;
            }
            String str = (String) this.f2013a.mo10202a(this.f2016d);
            if (C1277l.m3042b(str)) {
                String str2 = "faie";
                this.f2013a.mo10252y().loadAd(str, this.f2015c, new C0996a().mo9538a("fa", String.valueOf(true)).mo9538a(str2, String.valueOf(z)).mo9539a(), true, this.f2013a.mo10221ae(), this);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m1854b() {
            m1852a(false);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m1855b(boolean z) {
            synchronized (this.f2019g) {
                this.f2021i = 0;
                m1856c();
                this.f2018f = null;
            }
            m1852a(z);
        }

        /* renamed from: c */
        private void m1856c() {
            synchronized (this.f2019g) {
                if (this.f2020h != null) {
                    this.f2020h.mo10441d();
                    this.f2020h = null;
                }
            }
        }

        /* renamed from: a */
        public void mo9624a() {
            if (this.f2022j.compareAndSet(true, false)) {
                m1852a(this.f2023k);
            } else {
                long j = this.f2021i;
                if (j != 0) {
                    long currentTimeMillis = j - System.currentTimeMillis();
                    if (currentTimeMillis <= 0) {
                        m1855b(true);
                    } else {
                        m1849a(currentTimeMillis);
                    }
                }
            }
        }

        public void onAdClicked(MaxAd maxAd) {
            this.f2017e.onAdClicked(maxAd);
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
            this.f2017e.onAdDisplayFailed(maxAd, i);
        }

        public void onAdDisplayed(MaxAd maxAd) {
            this.f2017e.onAdDisplayed(maxAd);
            m1855b(false);
        }

        public void onAdHidden(MaxAd maxAd) {
            this.f2017e.onAdHidden(maxAd);
            this.f2017e = null;
        }

        public void onAdLoadFailed(String str, int i) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1037a.this.m1854b();
                }
            }, TimeUnit.SECONDS.toMillis(((Long) this.f2013a.mo10202a(C1095b.f2249Q)).longValue()));
        }

        public void onAdLoaded(MaxAd maxAd) {
            this.f2018f = (C0960c) maxAd;
            m1849a(this.f2018f.mo9452l());
            Iterator it = new ArrayList(this.f2014b.f2010a).iterator();
            while (it.hasNext()) {
                ((C1040b) it.next()).mo9413a(this.f2018f);
            }
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.applovin.application_paused".equals(action)) {
                m1856c();
            } else if ("com.applovin.application_resumed".equals(action)) {
                mo9624a();
            }
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            MaxAdListener maxAdListener = this.f2017e;
            if (maxAdListener instanceof MaxRewardedAdListener) {
                ((MaxRewardedAdListener) maxAdListener).onRewardedVideoCompleted(maxAd);
            }
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            MaxAdListener maxAdListener = this.f2017e;
            if (maxAdListener instanceof MaxRewardedAdListener) {
                ((MaxRewardedAdListener) maxAdListener).onRewardedVideoStarted(maxAd);
            }
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            MaxAdListener maxAdListener = this.f2017e;
            if (maxAdListener instanceof MaxRewardedAdListener) {
                ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.j$b */
    public interface C1040b {
        /* renamed from: a */
        void mo9413a(C0960c cVar);
    }

    public C1035j(C1192i iVar) {
        C1037a aVar = new C1037a(C1095b.f2246N, MaxAdFormat.INTERSTITIAL, this, iVar);
        this.f2011b = aVar;
        C1037a aVar2 = new C1037a(C1095b.f2247O, MaxAdFormat.REWARDED, this, iVar);
        this.f2012c = aVar2;
    }

    /* renamed from: b */
    private C1037a m1842b(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            return this.f2011b;
        }
        if (MaxAdFormat.REWARDED == maxAdFormat) {
            return this.f2012c;
        }
        return null;
    }

    /* renamed from: a */
    public C0960c mo9619a(MaxAdFormat maxAdFormat) {
        C1037a b = m1842b(maxAdFormat);
        if (b != null) {
            return b.f2018f;
        }
        return null;
    }

    /* renamed from: a */
    public void mo9620a() {
        this.f2011b.m1854b();
        this.f2012c.m1854b();
    }

    /* renamed from: a */
    public void mo9621a(C1040b bVar) {
        this.f2010a.add(bVar);
    }

    /* renamed from: a */
    public void mo9622a(MaxAdListener maxAdListener, MaxAdFormat maxAdFormat) {
        C1037a b = m1842b(maxAdFormat);
        if (b != null) {
            b.f2017e = maxAdListener;
        }
    }

    /* renamed from: b */
    public void mo9623b(C1040b bVar) {
        this.f2010a.remove(bVar);
    }
}
