package com.tapjoy.internal;

import android.text.TextUtils;
import com.tapjoy.internal.C2964ds.C2965a;
import com.tapjoy.internal.C2975dy.C2977b;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.ec */
public final class C2982ec extends C2974dx {
    public C2982ec(C2977b bVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            C2944dd a = C2944dd.m6718a();
            if (a != null) {
                for (C2940cz czVar : Collections.unmodifiableCollection(a.f6800a)) {
                    if (this.f6864a.contains(czVar.f6784f)) {
                        C2964ds dsVar = czVar.f6781c;
                        if (this.f6866c >= dsVar.f6834e) {
                            dsVar.f6833d = C2965a.f6836b;
                            C2949dg.m6726a().mo29949b(dsVar.mo29961c(), str);
                        }
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (C2957dm.m6751b(this.f6865b, this.f6868e.mo29971a())) {
            return null;
        }
        this.f6868e.mo29972a(this.f6865b);
        return this.f6865b.toString();
    }
}
