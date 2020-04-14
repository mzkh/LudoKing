package com.iab.omid.library.adcolony.walking.p030a;

import android.text.TextUtils;
import com.iab.omid.library.adcolony.adsession.C2029a;
import com.iab.omid.library.adcolony.p026b.C2031a;
import com.iab.omid.library.adcolony.p028d.C2045b;
import com.iab.omid.library.adcolony.walking.p030a.C2062b.C2064b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.walking.a.f */
public class C2068f extends C2061a {
    public C2068f(C2064b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m3922b(String str) {
        C2031a a = C2031a.m3760a();
        if (a != null) {
            for (C2029a aVar : a.mo27392b()) {
                if (this.f4084a.contains(aVar.getAdSessionId())) {
                    aVar.getAdSessionStatePublisher().mo27439a(str, this.f4086c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (C2045b.m3830b(this.f4085b, this.f4088d.mo27478b())) {
            return null;
        }
        this.f4088d.mo27477a(this.f4085b);
        return this.f4085b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m3922b(str);
        }
        super.onPostExecute(str);
    }
}
