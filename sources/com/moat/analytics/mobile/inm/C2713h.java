package com.moat.analytics.mobile.inm;

import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.h */
abstract class C2713h extends C2702c {

    /* renamed from: l */
    int f6054l = Integer.MIN_VALUE;

    /* renamed from: m */
    private C2715a f6055m = C2715a.UNINITIALIZED;

    /* renamed from: n */
    private int f6056n = Integer.MIN_VALUE;

    /* renamed from: o */
    private double f6057o = Double.NaN;

    /* renamed from: p */
    private int f6058p = Integer.MIN_VALUE;

    /* renamed from: q */
    private int f6059q = 0;

    /* renamed from: com.moat.analytics.mobile.inm.h$a */
    enum C2715a {
        UNINITIALIZED,
        PAUSED,
        PLAYING,
        STOPPED,
        COMPLETED
    }

    C2713h(String str) {
        super(str);
    }

    /* renamed from: t */
    private void m6203t() {
        this.f6028i.postDelayed(new Runnable() {
            public void run() {
                try {
                    if (!C2713h.this.mo29037n() || C2713h.this.mo29024m()) {
                        C2713h.this.mo29023l();
                    } else if (C2713h.this.mo29042s()) {
                        C2713h.this.f6028i.postDelayed(this, 200);
                    } else {
                        C2713h.this.mo29023l();
                    }
                } catch (Exception e) {
                    C2713h.this.mo29023l();
                    C2726m.m6274a(e);
                }
            }
        }, 200);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo29016a(MoatAdEvent moatAdEvent) {
        Integer num;
        if (!moatAdEvent.f5997b.equals(MoatAdEvent.f5995a)) {
            num = moatAdEvent.f5997b;
        } else {
            try {
                num = mo29038o();
            } catch (Exception unused) {
                num = Integer.valueOf(this.f6056n);
            }
            moatAdEvent.f5997b = num;
        }
        if (moatAdEvent.f5997b.intValue() < 0 || (moatAdEvent.f5997b.intValue() == 0 && moatAdEvent.f5999d == MoatAdEventType.AD_EVT_COMPLETE && this.f6056n > 0)) {
            num = Integer.valueOf(this.f6056n);
            moatAdEvent.f5997b = num;
        }
        if (moatAdEvent.f5999d == MoatAdEventType.AD_EVT_COMPLETE) {
            if (num.intValue() != Integer.MIN_VALUE) {
                int i = this.f6054l;
                if (i != Integer.MIN_VALUE && mo29017a(num, Integer.valueOf(i))) {
                    this.f6055m = C2715a.COMPLETED;
                }
            }
            this.f6055m = C2715a.STOPPED;
            moatAdEvent.f5999d = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo29016a(moatAdEvent);
    }

    /* renamed from: a */
    public boolean mo29018a(Map<String, String> map, View view) {
        try {
            boolean a = super.mo29018a(map, view);
            if (!a || !mo29039p()) {
                return a;
            }
            m6203t();
            return a;
        } catch (Exception e) {
            C2735p.m6310a(3, "IntervalVideoTracker", (Object) this, "Problem with video loop");
            mo29001a("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public abstract boolean mo29037n();

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public abstract Integer mo29038o();

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo29039p() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public abstract boolean mo29040q();

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public abstract Integer mo29041r();

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009c A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009e A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00be A[Catch:{ Exception -> 0x00d3 }] */
    @androidx.annotation.CallSuper
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo29042s() {
        /*
            r12 = this;
            boolean r0 = r12.mo29037n()
            r1 = 0
            if (r0 == 0) goto L_0x00de
            boolean r0 = r12.mo29024m()
            if (r0 == 0) goto L_0x000f
            goto L_0x00de
        L_0x000f:
            r0 = 1
            java.lang.Integer r2 = r12.mo29038o()     // Catch:{ Exception -> 0x00d3 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x00d3 }
            int r3 = r12.f6056n     // Catch:{ Exception -> 0x00d3 }
            if (r3 < 0) goto L_0x001f
            if (r2 >= 0) goto L_0x001f
            return r1
        L_0x001f:
            r12.f6056n = r2     // Catch:{ Exception -> 0x00d3 }
            if (r2 != 0) goto L_0x0024
            return r0
        L_0x0024:
            java.lang.Integer r3 = r12.mo29041r()     // Catch:{ Exception -> 0x00d3 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x00d3 }
            boolean r4 = r12.mo29040q()     // Catch:{ Exception -> 0x00d3 }
            double r5 = (double) r3
            r7 = 4616189618054758400(0x4010000000000000, double:4.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r7
            java.lang.Double r7 = r12.mo29021j()     // Catch:{ Exception -> 0x00d3 }
            double r7 = r7.doubleValue()     // Catch:{ Exception -> 0x00d3 }
            r9 = 0
            int r10 = r12.f6058p     // Catch:{ Exception -> 0x00d3 }
            if (r2 <= r10) goto L_0x0046
            r12.f6058p = r2     // Catch:{ Exception -> 0x00d3 }
        L_0x0046:
            int r10 = r12.f6054l     // Catch:{ Exception -> 0x00d3 }
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 != r11) goto L_0x004e
            r12.f6054l = r3     // Catch:{ Exception -> 0x00d3 }
        L_0x004e:
            if (r4 == 0) goto L_0x008f
            com.moat.analytics.mobile.inm.h$a r3 = r12.f6055m     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r4 = com.moat.analytics.mobile.inm.C2713h.C2715a.UNINITIALIZED     // Catch:{ Exception -> 0x00d3 }
            if (r3 != r4) goto L_0x005d
            com.moat.analytics.mobile.inm.MoatAdEventType r9 = com.moat.analytics.mobile.inm.MoatAdEventType.AD_EVT_START     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r3 = com.moat.analytics.mobile.inm.C2713h.C2715a.PLAYING     // Catch:{ Exception -> 0x00d3 }
        L_0x005a:
            r12.f6055m = r3     // Catch:{ Exception -> 0x00d3 }
            goto L_0x009a
        L_0x005d:
            com.moat.analytics.mobile.inm.h$a r3 = r12.f6055m     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r4 = com.moat.analytics.mobile.inm.C2713h.C2715a.PAUSED     // Catch:{ Exception -> 0x00d3 }
            if (r3 != r4) goto L_0x0068
            com.moat.analytics.mobile.inm.MoatAdEventType r9 = com.moat.analytics.mobile.inm.MoatAdEventType.AD_EVT_PLAYING     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r3 = com.moat.analytics.mobile.inm.C2713h.C2715a.PLAYING     // Catch:{ Exception -> 0x00d3 }
            goto L_0x005a
        L_0x0068:
            double r3 = (double) r2
            java.lang.Double.isNaN(r3)
            double r3 = r3 / r5
            double r3 = java.lang.Math.floor(r3)     // Catch:{ Exception -> 0x00d3 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x00d3 }
            int r3 = r3 - r0
            if (r3 < 0) goto L_0x009a
            r4 = 3
            if (r3 >= r4) goto L_0x009a
            com.moat.analytics.mobile.inm.MoatAdEventType[] r4 = f6026g     // Catch:{ Exception -> 0x00d3 }
            r3 = r4[r3]     // Catch:{ Exception -> 0x00d3 }
            java.util.Map r4 = r12.f6027h     // Catch:{ Exception -> 0x00d3 }
            boolean r4 = r4.containsKey(r3)     // Catch:{ Exception -> 0x00d3 }
            if (r4 != 0) goto L_0x009a
            java.util.Map r4 = r12.f6027h     // Catch:{ Exception -> 0x00d3 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00d3 }
            r4.put(r3, r5)     // Catch:{ Exception -> 0x00d3 }
            r9 = r3
            goto L_0x009a
        L_0x008f:
            com.moat.analytics.mobile.inm.h$a r3 = r12.f6055m     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r4 = com.moat.analytics.mobile.inm.C2713h.C2715a.PAUSED     // Catch:{ Exception -> 0x00d3 }
            if (r3 == r4) goto L_0x009a
            com.moat.analytics.mobile.inm.MoatAdEventType r9 = com.moat.analytics.mobile.inm.MoatAdEventType.AD_EVT_PAUSED     // Catch:{ Exception -> 0x00d3 }
            com.moat.analytics.mobile.inm.h$a r3 = com.moat.analytics.mobile.inm.C2713h.C2715a.PAUSED     // Catch:{ Exception -> 0x00d3 }
            goto L_0x005a
        L_0x009a:
            if (r9 == 0) goto L_0x009e
            r3 = 1
            goto L_0x009f
        L_0x009e:
            r3 = 0
        L_0x009f:
            if (r3 != 0) goto L_0x00bc
            double r4 = r12.f6057o     // Catch:{ Exception -> 0x00d3 }
            boolean r4 = java.lang.Double.isNaN(r4)     // Catch:{ Exception -> 0x00d3 }
            if (r4 != 0) goto L_0x00bc
            double r4 = r12.f6057o     // Catch:{ Exception -> 0x00d3 }
            double r4 = r4 - r7
            double r4 = java.lang.Math.abs(r4)     // Catch:{ Exception -> 0x00d3 }
            r10 = 4587366580439587226(0x3fa999999999999a, double:0.05)
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x00bc
            com.moat.analytics.mobile.inm.MoatAdEventType r9 = com.moat.analytics.mobile.inm.MoatAdEventType.AD_EVT_VOLUME_CHANGE     // Catch:{ Exception -> 0x00d3 }
            r3 = 1
        L_0x00bc:
            if (r3 == 0) goto L_0x00ce
            com.moat.analytics.mobile.inm.MoatAdEvent r3 = new com.moat.analytics.mobile.inm.MoatAdEvent     // Catch:{ Exception -> 0x00d3 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00d3 }
            java.lang.Double r4 = r12.mo29022k()     // Catch:{ Exception -> 0x00d3 }
            r3.<init>(r9, r2, r4)     // Catch:{ Exception -> 0x00d3 }
            r12.dispatchEvent(r3)     // Catch:{ Exception -> 0x00d3 }
        L_0x00ce:
            r12.f6057o = r7     // Catch:{ Exception -> 0x00d3 }
            r12.f6059q = r1     // Catch:{ Exception -> 0x00d3 }
            return r0
        L_0x00d3:
            int r2 = r12.f6059q
            int r3 = r2 + 1
            r12.f6059q = r3
            r3 = 5
            if (r2 >= r3) goto L_0x00de
            return r0
        L_0x00de:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.inm.C2713h.mo29042s():boolean");
    }

    public void setPlayerVolume(Double d) {
        super.setPlayerVolume(d);
        this.f6057o = mo29021j().doubleValue();
    }

    public void stopTracking() {
        try {
            dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            super.stopTracking();
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }
}
