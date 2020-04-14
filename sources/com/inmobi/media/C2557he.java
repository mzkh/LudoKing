package com.inmobi.media;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.inmobi.media.he */
/* compiled from: CarbPostListNetworkRequest */
public final class C2557he extends C2486fr {

    /* renamed from: a */
    int f5631a;

    /* renamed from: b */
    int f5632b;

    /* renamed from: c */
    private List<C2555hc> f5633c;

    C2557he(String str, int i, int i2, C2540gy gyVar, List<C2555hc> list, C2554hb hbVar) {
        super("POST", str, true, gyVar);
        this.f5631a = i;
        this.f5632b = i2;
        this.f5633c = list;
        this.f5439k.put("req_id", hbVar.f5625c);
        this.f5439k.put("i_till", Integer.toString(hbVar.f5626d));
        Map map = this.f5439k;
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.f5633c.size(); i3++) {
            jSONArray.put(((C2555hc) this.f5633c.get(i3)).f5629b);
        }
        map.put("p_a_apps", jSONArray.toString());
    }
}
