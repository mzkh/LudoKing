package com.moat.analytics.mobile.inm;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.c */
abstract class C2702c extends C2701b {

    /* renamed from: g */
    static final MoatAdEventType[] f6026g = {MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};

    /* renamed from: h */
    final Map<MoatAdEventType, Integer> f6027h;

    /* renamed from: i */
    final Handler f6028i;

    /* renamed from: j */
    Map<String, String> f6029j;

    /* renamed from: k */
    WeakReference<View> f6030k;

    /* renamed from: l */
    private final Set<MoatAdEventType> f6031l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public VideoTrackerListener f6032m;

    /* renamed from: n */
    private boolean f6033n;

    /* renamed from: o */
    private Double f6034o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final C2707g f6035p = new C2707g(C2695a.m6141a(), C2712a.VIDEO);

    /* renamed from: q */
    private final String f6036q;

    C2702c(String str) {
        super(null, false, true);
        C2735p.m6310a(3, "BaseVideoTracker", (Object) this, "Initializing.");
        this.f6036q = str;
        super.mo29000a(this.f6035p.f6041b);
        try {
            super.mo28999a(this.f6035p.f6040a);
        } catch (C2726m e) {
            this.f6015a = e;
        }
        this.f6027h = new HashMap();
        this.f6031l = new HashSet();
        this.f6028i = new Handler();
        this.f6033n = false;
        this.f6034o = Double.valueOf(1.0d);
    }

    /* renamed from: a */
    private static boolean m6177a(MoatAdEventType moatAdEventType) {
        return moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED;
    }

    /* renamed from: b */
    private void m6178b(MoatAdEvent moatAdEvent) {
        JSONObject a = mo29016a(moatAdEvent);
        String str = "BaseVideoTracker";
        C2735p.m6310a(3, str, (Object) this, String.format("Received event: %s", new Object[]{a.toString()}));
        StringBuilder sb = new StringBuilder();
        sb.append(mo28998a());
        sb.append(String.format(" Received event: %s", new Object[]{a.toString()}));
        C2735p.m6313a("[SUCCESS] ", sb.toString());
        if (mo29007e() && this.f6017c != null) {
            this.f6017c.mo29053a(this.f6035p.f6042c, a);
            if (!this.f6031l.contains(moatAdEvent.f5999d)) {
                this.f6031l.add(moatAdEvent.f5999d);
                VideoTrackerListener videoTrackerListener = this.f6032m;
                if (videoTrackerListener != null) {
                    videoTrackerListener.onVideoEventReported(moatAdEvent.f5999d);
                }
            }
        }
        MoatAdEventType moatAdEventType = moatAdEvent.f5999d;
        if (m6177a(moatAdEventType)) {
            this.f6027h.put(moatAdEventType, Integer.valueOf(1));
            if (this.f6017c != null) {
                this.f6017c.mo29057c((C2701b) this);
            }
            mo29023l();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo29016a(MoatAdEvent moatAdEvent) {
        if (Double.isNaN(moatAdEvent.f5998c.doubleValue())) {
            moatAdEvent.f5998c = this.f6034o;
        }
        return new JSONObject(moatAdEvent.mo28935a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29002a(List<String> list) {
        if (this.f6029j == null) {
            list.add("Null adIds object");
        }
        if (list.isEmpty()) {
            super.mo29002a(list);
            return;
        }
        throw new C2726m(TextUtils.join(" and ", list));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo29017a(Integer num, Integer num2) {
        int abs = Math.abs(num2.intValue() - num.intValue());
        double intValue = (double) num2.intValue();
        Double.isNaN(intValue);
        return ((double) abs) <= Math.min(750.0d, intValue * 0.05d);
    }

    @CallSuper
    /* renamed from: a */
    public boolean mo29018a(Map<String, String> map, View view) {
        try {
            mo29004c();
            mo29006d();
            String str = "BaseVideoTracker";
            if (view == null) {
                C2735p.m6310a(3, str, (Object) this, "trackVideoAd received null video view instance");
            }
            this.f6029j = map;
            this.f6030k = new WeakReference<>(view);
            mo29003b();
            String format = String.format("trackVideoAd tracking ids: %s | view: %s", new Object[]{new JSONObject(map).toString(), C2735p.m6308a(view)});
            C2735p.m6310a(3, str, (Object) this, format);
            StringBuilder sb = new StringBuilder();
            sb.append(mo28998a());
            sb.append(" ");
            sb.append(format);
            C2735p.m6313a("[SUCCESS] ", sb.toString());
            if (this.f6018d != null) {
                this.f6018d.onTrackingStarted(mo29009g());
            }
            return true;
        } catch (Exception e) {
            mo29001a("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo29003b() {
        super.changeTargetView((View) this.f6030k.get());
        super.mo29003b();
        Map i = mo29020i();
        Integer num = (Integer) i.get("width");
        Integer num2 = (Integer) i.get("height");
        Integer num3 = (Integer) i.get("duration");
        C2735p.m6310a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "Player metadata: height = %d, width = %d, duration = %d", new Object[]{num2, num, num3}));
        this.f6035p.mo29031a(this.f6036q, this.f6029j, num, num2, num3);
    }

    public void changeTargetView(View view) {
        StringBuilder sb = new StringBuilder("changing view to ");
        sb.append(C2735p.m6308a(view));
        C2735p.m6310a(3, "BaseVideoTracker", (Object) this, sb.toString());
        this.f6030k = new WeakReference<>(view);
        try {
            super.changeTargetView(view);
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            m6178b(moatAdEvent);
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public abstract Map<String, Object> mo29020i();

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public Double mo29021j() {
        return Double.valueOf(mo29022k().doubleValue() * C2738s.m6318a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public Double mo29022k() {
        return this.f6034o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo29023l() {
        if (!this.f6033n) {
            this.f6033n = true;
            this.f6028i.postDelayed(new Runnable() {
                public void run() {
                    try {
                        C2735p.m6310a(3, "BaseVideoTracker", (Object) this, "Shutting down.");
                        C2702c.this.f6035p.mo29029a();
                        C2702c.this.f6032m = null;
                    } catch (Exception e) {
                        C2726m.m6274a(e);
                    }
                }
            }, 500);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo29024m() {
        return this.f6027h.containsKey(MoatAdEventType.AD_EVT_COMPLETE) || this.f6027h.containsKey(MoatAdEventType.AD_EVT_STOPPED) || this.f6027h.containsKey(MoatAdEventType.AD_EVT_SKIPPED);
    }

    public void removeVideoListener() {
        this.f6032m = null;
    }

    public void setPlayerVolume(Double d) {
        Double j = mo29021j();
        if (!d.equals(this.f6034o)) {
            C2735p.m6310a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "player volume changed to %f ", new Object[]{d}));
            this.f6034o = d;
            if (!j.equals(mo29021j())) {
                dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.f5995a, this.f6034o));
            }
        }
    }

    public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        this.f6032m = videoTrackerListener;
    }

    public void stopTracking() {
        try {
            super.stopTracking();
            mo29023l();
            if (this.f6032m != null) {
                this.f6032m = null;
            }
        } catch (Exception e) {
            C2726m.m6274a(e);
        }
    }
}
