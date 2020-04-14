package com.moat.analytics.mobile.inm;

import android.view.View;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.y */
class C2764y extends C2702c implements ReactiveVideoTracker {

    /* renamed from: l */
    private Integer f6194l;

    public C2764y(String str) {
        super(str);
        C2735p.m6310a(3, "ReactiveVideoTracker", (Object) this, "Initializing.");
        StringBuilder sb = new StringBuilder();
        sb.append(mo28998a());
        sb.append(" created");
        C2735p.m6313a("[SUCCESS] ", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo28998a() {
        return "ReactiveVideoTracker";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public JSONObject mo29016a(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.f5999d == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.f5997b.equals(MoatAdEvent.f5995a) && !mo29017a(moatAdEvent.f5997b, this.f6194l)) {
            moatAdEvent.f5999d = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo29016a(moatAdEvent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo29002a(List<String> list) {
        if (this.f6194l.intValue() >= 1000) {
            super.mo29002a(list);
            return;
        }
        throw new C2726m(String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[]{this.f6194l}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public Map<String, Object> mo29020i() {
        Integer num;
        HashMap hashMap = new HashMap();
        View view = (View) this.f6030k.get();
        Integer valueOf = Integer.valueOf(0);
        if (view != null) {
            valueOf = Integer.valueOf(view.getWidth());
            num = Integer.valueOf(view.getHeight());
        } else {
            num = valueOf;
        }
        hashMap.put("duration", this.f6194l);
        hashMap.put("width", valueOf);
        hashMap.put("height", num);
        return hashMap;
    }

    public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
        try {
            mo29004c();
            mo29006d();
            this.f6194l = num;
            return super.mo29018a(map, view);
        } catch (Exception e) {
            mo29001a("trackVideoAd", e);
            return false;
        }
    }
}
