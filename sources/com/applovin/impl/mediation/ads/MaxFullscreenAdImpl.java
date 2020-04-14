package com.applovin.impl.mediation.ads;

import android.app.Activity;
import com.applovin.impl.mediation.C0956b;
import com.applovin.impl.mediation.C0993e;
import com.applovin.impl.mediation.C1035j.C1040b;
import com.applovin.impl.mediation.C1043l;
import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.sdk.C1091b;
import com.applovin.impl.sdk.C1091b.C1093a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MaxFullscreenAdImpl extends C0955a implements C1093a {

    /* renamed from: a */
    private final C0948a f1797a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1091b f1798b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0956b f1799c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Object f1800d = new Object();

    /* renamed from: e */
    private C0960c f1801e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0960c f1802f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0960c f1803g = null;

    /* renamed from: h */
    private C0954c f1804h = C0954c.IDLE;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicBoolean f1805i = new AtomicBoolean();
    protected final C0949b listenerWrapper;

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$a */
    public interface C0948a {
        Activity getActivity();
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$b */
    private class C0949b implements C1040b, MaxAdListener, MaxRewardedAdListener {
        private C0949b() {
        }

        /* renamed from: a */
        public void mo9413a(C0960c cVar) {
            if (cVar.getFormat() == MaxFullscreenAdImpl.this.adFormat) {
                onAdLoaded(cVar);
            }
        }

        public void onAdClicked(MaxAd maxAd) {
            C1248i.m3015d(MaxFullscreenAdImpl.this.adListener, MaxFullscreenAdImpl.this.m1570d());
        }

        public void onAdDisplayFailed(MaxAd maxAd, final int i) {
            MaxFullscreenAdImpl.this.m1559a(C0954c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.f1798b.mo9942a();
                    MaxFullscreenAdImpl.this.m1566b();
                    C1248i.m2995a(MaxFullscreenAdImpl.this.adListener, (MaxAd) MaxFullscreenAdImpl.this.m1570d(), i);
                }
            });
        }

        public void onAdDisplayed(MaxAd maxAd) {
            if (!((C0960c) maxAd).mo9437j()) {
                MaxFullscreenAdImpl.this.f1798b.mo9942a();
            }
            C1248i.m3009b(MaxFullscreenAdImpl.this.adListener, (MaxAd) MaxFullscreenAdImpl.this.m1570d());
        }

        public void onAdHidden(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f1799c.mo9421a(maxAd);
            MaxFullscreenAdImpl.this.m1559a(C0954c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m1566b();
                    C1248i.m3013c(MaxFullscreenAdImpl.this.adListener, MaxFullscreenAdImpl.this.m1570d());
                }
            });
        }

        public void onAdLoadFailed(final String str, final int i) {
            MaxFullscreenAdImpl.this.m1569c();
            if (MaxFullscreenAdImpl.this.f1803g == null) {
                MaxFullscreenAdImpl.this.m1559a(C0954c.IDLE, (Runnable) new Runnable() {
                    public void run() {
                        C1248i.m2997a(MaxFullscreenAdImpl.this.adListener, str, i);
                    }
                });
            }
        }

        public void onAdLoaded(MaxAd maxAd) {
            C0960c cVar = (C0960c) maxAd;
            MaxFullscreenAdImpl.this.m1563a(cVar);
            if (cVar.mo9437j() || !MaxFullscreenAdImpl.this.f1805i.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.m1559a(C0954c.READY, (Runnable) new Runnable() {
                    public void run() {
                        C1248i.m2994a(MaxFullscreenAdImpl.this.adListener, (MaxAd) MaxFullscreenAdImpl.this.m1570d());
                    }
                });
            } else {
                MaxFullscreenAdImpl.this.loadRequestBuilder.mo9537a("expired_ad_ad_unit_id");
            }
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1248i.m3017f(MaxFullscreenAdImpl.this.adListener, MaxFullscreenAdImpl.this.m1570d());
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1248i.m3016e(MaxFullscreenAdImpl.this.adListener, MaxFullscreenAdImpl.this.m1570d());
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1248i.m2996a(MaxFullscreenAdImpl.this.adListener, (MaxAd) MaxFullscreenAdImpl.this.m1570d(), maxReward);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c */
    public enum C0954c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, C0948a aVar, String str2, C1192i iVar) {
        super(str, maxAdFormat, str2, iVar);
        this.f1797a = aVar;
        this.listenerWrapper = new C0949b();
        this.f1798b = new C1091b(iVar, this);
        this.f1799c = new C0956b(iVar, this.listenerWrapper);
        StringBuilder sb = new StringBuilder();
        sb.append("Created new ");
        sb.append(str2);
        sb.append(" (");
        sb.append(this);
        sb.append(")");
        C1227o.m2838f(str2, sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C0960c m1557a() {
        C0960c cVar;
        synchronized (this.f1800d) {
            cVar = this.f1802f != null ? this.f1802f : this.f1803g;
        }
        return cVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x016e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1559a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c r7, java.lang.Runnable r8) {
        /*
            r6 = this;
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = r6.f1804h
            java.lang.Object r1 = r6.f1800d
            monitor-enter(r1)
            com.applovin.impl.sdk.o r2 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r4.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "Attempting state transition from "
            r4.append(r5)     // Catch:{ all -> 0x0199 }
            r4.append(r0)     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x0199 }
            r4.append(r7)     // Catch:{ all -> 0x0199 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0199 }
            r2.mo10378b(r3, r4)     // Catch:{ all -> 0x0199 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.IDLE     // Catch:{ all -> 0x0199 }
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x005e
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.LOADING     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0032
        L_0x002f:
            r4 = 1
            goto L_0x0142
        L_0x0032:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.DESTROYED     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0037
            goto L_0x002f
        L_0x0037:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.SHOWING     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0044
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "No ad is loading or loaded"
        L_0x003f:
            com.applovin.impl.sdk.C1227o.m2841i(r0, r2)     // Catch:{ all -> 0x0199 }
            goto L_0x0142
        L_0x0044:
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r3.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            r3.append(r7)     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0199 }
        L_0x0059:
            r0.mo10382e(r2, r3)     // Catch:{ all -> 0x0199 }
            goto L_0x0142
        L_0x005e:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.LOADING     // Catch:{ all -> 0x0199 }
            if (r0 != r2) goto L_0x0099
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.IDLE     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0067
            goto L_0x002f
        L_0x0067:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.LOADING     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0070
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "An ad is already loading"
            goto L_0x003f
        L_0x0070:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.READY     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0075
            goto L_0x002f
        L_0x0075:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.SHOWING     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x007e
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "An ad is not ready to be shown yet"
            goto L_0x003f
        L_0x007e:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.DESTROYED     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0083
            goto L_0x002f
        L_0x0083:
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r3.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            r3.append(r7)     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0199 }
            goto L_0x0059
        L_0x0099:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.READY     // Catch:{ all -> 0x0199 }
            if (r0 != r2) goto L_0x00d8
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.IDLE     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x00a2
            goto L_0x002f
        L_0x00a2:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.LOADING     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x00ab
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "An ad is already loaded"
            goto L_0x003f
        L_0x00ab:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.READY     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x00b6
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = "An ad is already marked as ready"
            goto L_0x0059
        L_0x00b6:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.SHOWING     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x00bc
            goto L_0x002f
        L_0x00bc:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.DESTROYED     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x00c2
            goto L_0x002f
        L_0x00c2:
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r3.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            r3.append(r7)     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0199 }
            goto L_0x0059
        L_0x00d8:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.SHOWING     // Catch:{ all -> 0x0199 }
            if (r0 != r2) goto L_0x011f
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.IDLE     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x00e2
            goto L_0x002f
        L_0x00e2:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.LOADING     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x00ec
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "Can not load another ad while the ad is showing"
            goto L_0x003f
        L_0x00ec:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.READY     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x00f8
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = "An ad is already showing, ignoring"
            goto L_0x0059
        L_0x00f8:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.SHOWING     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0102
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "The ad is already showing, not showing another one"
            goto L_0x003f
        L_0x0102:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.DESTROYED     // Catch:{ all -> 0x0199 }
            if (r7 != r0) goto L_0x0108
            goto L_0x002f
        L_0x0108:
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r3.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            r3.append(r7)     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0199 }
            goto L_0x0059
        L_0x011f:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0954c.DESTROYED     // Catch:{ all -> 0x0199 }
            if (r0 != r2) goto L_0x0129
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = "No operations are allowed on a destroyed instance"
            goto L_0x003f
        L_0x0129:
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r3.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "Unknown state: "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f1804h     // Catch:{ all -> 0x0199 }
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0199 }
            goto L_0x0059
        L_0x0142:
            if (r4 == 0) goto L_0x016e
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r3.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "Transitioning from "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f1804h     // Catch:{ all -> 0x0199 }
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = " to "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            r3.append(r7)     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "..."
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0199 }
            r0.mo10378b(r2, r3)     // Catch:{ all -> 0x0199 }
            r6.f1804h = r7     // Catch:{ all -> 0x0199 }
            goto L_0x0190
        L_0x016e:
            com.applovin.impl.sdk.o r0 = r6.logger     // Catch:{ all -> 0x0199 }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0199 }
            r3.<init>()     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = "Not allowed transition from "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f1804h     // Catch:{ all -> 0x0199 }
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            java.lang.String r5 = " to "
            r3.append(r5)     // Catch:{ all -> 0x0199 }
            r3.append(r7)     // Catch:{ all -> 0x0199 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0199 }
            r0.mo10381d(r2, r7)     // Catch:{ all -> 0x0199 }
        L_0x0190:
            monitor-exit(r1)     // Catch:{ all -> 0x0199 }
            if (r4 == 0) goto L_0x0198
            if (r8 == 0) goto L_0x0198
            r8.run()
        L_0x0198:
            return
        L_0x0199:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0199 }
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.m1559a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c, java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1563a(C0960c cVar) {
        if (cVar.mo9437j()) {
            this.f1803g = cVar;
            C1227o oVar = this.logger;
            String str = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Handle ad loaded for fallback ad: ");
            sb.append(cVar);
            oVar.mo10378b(str, sb.toString());
            return;
        }
        this.f1802f = cVar;
        C1227o oVar2 = this.logger;
        String str2 = this.tag;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Handle ad loaded for regular ad: ");
        sb2.append(cVar);
        oVar2.mo10378b(str2, sb2.toString());
        m1567b(cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1564a(String str, Activity activity) {
        synchronized (this.f1800d) {
            this.f1801e = m1557a();
            this.sdk.mo10177B().mo9623b((C1040b) this.listenerWrapper);
            if (this.f1801e.mo9437j()) {
                if (this.f1801e.mo9435h().get()) {
                    C1227o oVar = this.logger;
                    String str2 = this.tag;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to display ad: ");
                    sb.append(this.f1801e);
                    sb.append(" - displayed already");
                    oVar.mo10382e(str2, sb.toString());
                    this.sdk.mo10252y().maybeScheduleAdDisplayErrorPostback(new C0993e(-5201, "Ad displayed already"), this.f1801e);
                    C1248i.m2995a(this.adListener, (MaxAd) m1570d(), -5201);
                    return;
                }
                this.sdk.mo10177B().mo9622a(this.listenerWrapper, this.adFormat);
            }
            this.f1801e.mo9450a(this.adUnitId);
            this.f1799c.mo9422b(this.f1801e);
            C1227o oVar2 = this.logger;
            String str3 = this.tag;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Showing ad for '");
            sb2.append(this.adUnitId);
            sb2.append("'; loaded ad: ");
            sb2.append(this.f1801e);
            sb2.append("...");
            oVar2.mo10378b(str3, sb2.toString());
            this.sdk.mo10252y().showFullscreenAd(this.f1801e, str, activity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1566b() {
        C0960c cVar;
        synchronized (this.f1800d) {
            cVar = this.f1801e;
            this.f1801e = null;
            if (cVar == this.f1803g) {
                this.f1803g = null;
            } else if (cVar == this.f1802f) {
                this.f1802f = null;
            }
        }
        this.sdk.mo10252y().destroyAd(cVar);
    }

    /* renamed from: b */
    private void m1567b(C0960c cVar) {
        long n = cVar.mo9454n();
        if (n >= 0) {
            C1227o oVar = this.logger;
            String str = this.tag;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling ad expiration ");
            sb.append(TimeUnit.MILLISECONDS.toMinutes(n));
            sb.append(" minutes from now for ");
            sb.append(getAdUnitId());
            sb.append(" ...");
            oVar.mo10378b(str, sb.toString());
            this.f1798b.mo9943a(n);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1569c() {
        C0960c cVar;
        if (this.f1805i.compareAndSet(true, false)) {
            synchronized (this.f1800d) {
                cVar = this.f1802f;
                this.f1802f = null;
            }
            this.sdk.mo10252y().destroyAd(cVar);
            this.loadRequestBuilder.mo9537a("expired_ad_ad_unit_id");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public C1043l m1570d() {
        return new C1043l(this.adUnitId, this.adFormat);
    }

    public void destroy() {
        m1559a(C0954c.DESTROYED, (Runnable) new Runnable() {
            public void run() {
                synchronized (MaxFullscreenAdImpl.this.f1800d) {
                    if (MaxFullscreenAdImpl.this.f1802f != null) {
                        C1227o oVar = MaxFullscreenAdImpl.this.logger;
                        String str = MaxFullscreenAdImpl.this.tag;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Destroying ad for '");
                        sb.append(MaxFullscreenAdImpl.this.adUnitId);
                        sb.append("'; current ad: ");
                        sb.append(MaxFullscreenAdImpl.this.f1802f);
                        sb.append("...");
                        oVar.mo10378b(str, sb.toString());
                        MaxFullscreenAdImpl.this.sdk.mo10252y().destroyAd(MaxFullscreenAdImpl.this.f1802f);
                    }
                }
            }
        });
    }

    public boolean isReady() {
        boolean z;
        synchronized (this.f1800d) {
            z = m1557a() != null && m1557a().mo9426a() && this.f1804h == C0954c.READY;
        }
        return z;
    }

    public void loadAd(final Activity activity) {
        C1227o oVar = this.logger;
        String str = this.tag;
        StringBuilder sb = new StringBuilder();
        sb.append("Loading ad for '");
        sb.append(this.adUnitId);
        sb.append("'...");
        oVar.mo10378b(str, sb.toString());
        if (isReady()) {
            C1227o oVar2 = this.logger;
            String str2 = this.tag;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("An ad is already loaded for '");
            sb2.append(this.adUnitId);
            sb2.append("'");
            oVar2.mo10378b(str2, sb2.toString());
            C1248i.m2994a(this.adListener, (MaxAd) m1570d());
            return;
        }
        m1559a(C0954c.LOADING, (Runnable) new Runnable() {
            public void run() {
                final C0960c c = MaxFullscreenAdImpl.this.m1557a();
                if (c == null || c.mo9437j()) {
                    MaxFullscreenAdImpl.this.sdk.mo10177B().mo9621a((C1040b) MaxFullscreenAdImpl.this.listenerWrapper);
                    MaxFullscreenAdImpl.this.sdk.mo10252y().loadAd(MaxFullscreenAdImpl.this.adUnitId, MaxFullscreenAdImpl.this.adFormat, MaxFullscreenAdImpl.this.loadRequestBuilder.mo9539a(), false, activity, MaxFullscreenAdImpl.this.listenerWrapper);
                    return;
                }
                MaxFullscreenAdImpl.this.m1559a(C0954c.READY, (Runnable) new Runnable() {
                    public void run() {
                        C1248i.m2994a(MaxFullscreenAdImpl.this.adListener, (MaxAd) c);
                    }
                });
            }
        });
    }

    public void onAdExpired() {
        C1227o oVar = this.logger;
        String str = this.tag;
        StringBuilder sb = new StringBuilder();
        sb.append("Ad expired ");
        sb.append(getAdUnitId());
        oVar.mo10378b(str, sb.toString());
        Activity activity = this.f1797a.getActivity();
        if (activity == null) {
            activity = this.sdk.mo10217aa().mo9735a();
            if (!((Boolean) this.sdk.mo10202a(C1095b.f2241I)).booleanValue() || activity == null) {
                this.listenerWrapper.onAdLoadFailed(this.adUnitId, MaxErrorCodes.NO_ACTIVITY);
                return;
            }
        }
        Activity activity2 = activity;
        this.f1805i.set(true);
        this.loadRequestBuilder.mo9538a("expired_ad_ad_unit_id", getAdUnitId());
        this.sdk.mo10252y().loadAd(this.adUnitId, this.adFormat, this.loadRequestBuilder.mo9539a(), false, activity2, this.listenerWrapper);
    }

    public void showAd(final String str, final Activity activity) {
        if (!((Boolean) this.sdk.mo10202a(C1095b.f2238F)).booleanValue() || (!this.sdk.mo10200Z().mo10282a() && !this.sdk.mo10200Z().mo10284b())) {
            m1559a(C0954c.SHOWING, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m1564a(str, activity);
                }
            });
            return;
        }
        C1227o.m2841i(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
        C1248i.m2995a(this.adListener, (MaxAd) m1557a(), -23);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tag);
        sb.append("{adUnitId='");
        sb.append(this.adUnitId);
        sb.append('\'');
        sb.append(", adListener=");
        sb.append(this.adListener);
        sb.append(", isReady=");
        sb.append(isReady());
        sb.append('}');
        return sb.toString();
    }
}
