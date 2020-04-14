package com.iab.omid.library.inmobi.walking.p036a;

import android.text.TextUtils;
import com.iab.omid.library.inmobi.adsession.C2077a;
import com.iab.omid.library.inmobi.p032b.C2079a;
import com.iab.omid.library.inmobi.p034d.C2093b;
import com.iab.omid.library.inmobi.walking.p036a.C2110b.C2112b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.inmobi.walking.a.f */
public class C2116f extends C2109a {
    public C2116f(C2112b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* renamed from: b */
    private void m4132b(String str) {
        C2079a a = C2079a.m3964a();
        if (a != null) {
            for (C2077a aVar : a.mo27555b()) {
                if (this.f4186a.contains(aVar.getAdSessionId())) {
                    aVar.getAdSessionStatePublisher().mo27603a(str, this.f4188c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (C2093b.m4036b(this.f4187b, this.f4190d.mo27644b())) {
            return null;
        }
        this.f4190d.mo27643a(this.f4187b);
        return this.f4187b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            m4132b(str);
        }
        super.onPostExecute(str);
    }
}
