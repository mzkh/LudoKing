package com.iab.omid.library.inmobi.walking.p036a;

import com.iab.omid.library.inmobi.adsession.C2077a;
import com.iab.omid.library.inmobi.p032b.C2079a;
import com.iab.omid.library.inmobi.walking.p036a.C2110b.C2112b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.inmobi.walking.a.e */
public class C2115e extends C2109a {
    public C2115e(C2112b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m4129b(String str) {
        C2079a a = C2079a.m3964a();
        if (a != null) {
            for (C2077a aVar : a.mo27555b()) {
                if (this.f4186a.contains(aVar.getAdSessionId())) {
                    aVar.getAdSessionStatePublisher().mo27607b(str, this.f4188c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f4187b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        m4129b(str);
        super.onPostExecute(str);
    }
}
