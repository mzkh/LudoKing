package com.tapjoy.internal;

import com.tapjoy.internal.C2964ds.C2965a;
import com.tapjoy.internal.C2975dy.C2977b;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.eb */
public final class C2981eb extends C2974dx {
    public C2981eb(C2977b bVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onPostExecute(String str) {
        C2944dd a = C2944dd.m6718a();
        if (a != null) {
            for (C2940cz czVar : Collections.unmodifiableCollection(a.f6800a)) {
                if (this.f6864a.contains(czVar.f6784f)) {
                    C2964ds dsVar = czVar.f6781c;
                    if (this.f6866c >= dsVar.f6834e && dsVar.f6833d != C2965a.f6837c) {
                        dsVar.f6833d = C2965a.f6837c;
                        C2949dg.m6726a().mo29949b(dsVar.mo29961c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.f6865b.toString();
    }
}
