package com.iab.omid.library.adcolony.walking.p030a;

import com.iab.omid.library.adcolony.adsession.C2029a;
import com.iab.omid.library.adcolony.p026b.C2031a;
import com.iab.omid.library.adcolony.walking.p030a.C2062b.C2064b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.walking.a.e */
public class C2067e extends C2061a {
    public C2067e(C2064b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m3919b(String str) {
        C2031a a = C2031a.m3760a();
        if (a != null) {
            for (C2029a aVar : a.mo27392b()) {
                if (this.f4084a.contains(aVar.getAdSessionId())) {
                    aVar.getAdSessionStatePublisher().mo27443b(str, this.f4086c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f4085b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        m3919b(str);
        super.onPostExecute(str);
    }
}
