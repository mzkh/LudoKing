package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ak */
/* compiled from: AdStore */
public class C2163ak {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final String f4399e = "ak";
    @NonNull

    /* renamed from: a */
    public final C2168a f4400a;
    @NonNull

    /* renamed from: b */
    public C2239bs f4401b;

    /* renamed from: c */
    public long f4402c = 0;

    /* renamed from: d */
    public final C2182ap f4403d = new C2182ap() {
        /* renamed from: a */
        public final void mo27888a(C2156ae aeVar) {
            C2163ak.this.f4405g.mo27888a(aeVar);
            C2163ak.f4399e;
            C2163ak.this.f4401b;
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    C2163ak.this.f4400a.mo27892a(C2163ak.this.f4401b.f4652a, false);
                }
            });
        }

        /* renamed from: b */
        public final void mo27889b(C2156ae aeVar) {
            C2163ak.this.f4405g.mo27889b(aeVar);
            C2163ak.f4399e;
            C2163ak.this.f4401b;
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    C2163ak.this.f4400a.mo27892a(C2163ak.this.f4401b.f4652a, true);
                }
            });
        }
    };
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: f */
    public final C2207aw f4404f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C2182ap f4405g = new C2182ap() {
        /* renamed from: a */
        public final void mo27888a(C2156ae aeVar) {
            C2163ak.f4399e;
            if (aeVar == null) {
            }
        }

        /* renamed from: b */
        public final void mo27889b(C2156ae aeVar) {
            C2163ak.f4399e;
            if (aeVar != null) {
                Set<C2206av> set = aeVar.f4354b;
                for (C2154ad adVar : aeVar.f4353a) {
                    if (!adVar.f4342j) {
                        String a = C2163ak.m4343a((Set) set, adVar);
                        HashMap hashMap = new HashMap();
                        hashMap.put("latency", Long.valueOf(adVar.f4333a));
                        hashMap.put("size", Float.valueOf((((float) C2541gz.m5441a(adVar.f4337e)) * 1.0f) / 1024.0f));
                        hashMap.put("assetType", a);
                        hashMap.put("networkType", C2527gp.m5390b());
                        hashMap.put("adType", C2163ak.this.f4401b.f4654c);
                        C2163ak.this.f4404f.mo27935b("AssetDownloaded", hashMap);
                    }
                }
            }
            C2163ak.f4399e;
            C2163ak.this.f4401b;
        }
    };

    /* renamed from: com.inmobi.media.ak$a */
    /* compiled from: AdStore */
    public interface C2168a {
        @UiThread
        /* renamed from: a */
        void mo27892a(@NonNull C2159ai aiVar, boolean z);
    }

    public C2163ak(@NonNull C2168a aVar, @NonNull C2239bs bsVar, @NonNull C2207aw awVar) {
        this.f4400a = aVar;
        this.f4401b = bsVar;
        this.f4404f = awVar;
    }

    @NonNull
    /* renamed from: a */
    public final C2162aj mo27886a(C2240bt btVar) throws C2208ax {
        StringBuilder sb = new StringBuilder();
        List a = m4344a(btVar, sb);
        boolean isEmpty = TextUtils.isEmpty(sb.toString());
        this.f4401b.mo28416i();
        btVar.f4660a.mo28421d();
        if (a != null) {
            String str = "networkType";
            String str2 = "adType";
            String str3 = "latency";
            if (a.size() != 0 || !isEmpty) {
                HashMap hashMap = new HashMap();
                hashMap.put(str3, Long.valueOf(SystemClock.elapsedRealtime() - this.f4402c));
                hashMap.put(str2, this.f4401b.f4654c);
                hashMap.put(str, C2527gp.m5390b());
                this.f4404f.mo27935b("ServerFill", hashMap);
                C2162aj ajVar = (C2162aj) a.get(0);
                if (!ajVar.mo27875b() || ajVar.mo27884k() != null) {
                    return ajVar;
                }
                throw new C2208ax(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            }
            btVar.f4660a.mo28418b();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str3, Long.valueOf(SystemClock.elapsedRealtime() - this.f4402c));
            hashMap2.put(str2, this.f4401b.f4654c);
            hashMap2.put(str, C2527gp.m5390b());
            this.f4404f.mo27935b("ServerNoFill", hashMap2);
            throw new C2208ax(new InMobiAdRequestStatus(StatusCode.NO_FILL));
        }
        btVar.f4660a.mo28418b();
        throw new C2208ax(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
    }

    @Nullable
    /* renamed from: a */
    private List<C2162aj> m4344a(C2240bt btVar, @Nullable StringBuilder sb) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(btVar.f4660a.mo28418b());
            sb.append(jSONObject.optString("winningAdSetId").trim());
            JSONArray jSONArray = jSONObject.getJSONArray("adSets");
            if (jSONArray != null) {
                C2239bs bsVar = btVar.f4662c;
                C2159ai aiVar = bsVar.f4652a;
                if (jSONArray.length() != 0) {
                    C2162aj a = C2162aj.m4325a(jSONArray.getJSONObject(0), aiVar.mo27849e(), bsVar.f4654c, aiVar.mo27856j(), bsVar.f4652a.mo27858l(), aiVar.mo27857k(), bsVar.f4657f);
                    if (a != null) {
                        arrayList.add(a);
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errorCode", Integer.valueOf(3));
                        mo27887a((Map<String, Object>) hashMap);
                        return null;
                    }
                }
            }
        } catch (JSONException unused) {
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo27887a(Map<String, Object> map) {
        map.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f4402c));
        map.put("adType", this.f4401b.f4654c);
        map.put("networkType", C2527gp.m5390b());
        this.f4404f.mo27935b("ServerError", map);
    }

    /* renamed from: a */
    public static void m4345a(C2239bs bsVar) {
        if (bsVar != null) {
            Map<String, String> map = bsVar.f4656e;
            if (map == null) {
                map = new HashMap<>();
            }
            bsVar.f4656e = map;
        }
    }

    /* renamed from: a */
    static /* synthetic */ String m4343a(Set set, C2154ad adVar) {
        String str;
        C2206av avVar;
        String str2;
        Iterator it = set.iterator();
        do {
            str = "";
            if (!it.hasNext()) {
                return str;
            }
            avVar = (C2206av) it.next();
        } while (!avVar.f4510b.equals(adVar.f4336d));
        int i = avVar.f4509a;
        if (i == 0) {
            str2 = "video";
        } else if (i == 1) {
            str2 = "gif";
        } else if (i != 2) {
            return str;
        } else {
            str2 = MessengerShareContentUtility.MEDIA_IMAGE;
        }
        return str2;
    }
}
