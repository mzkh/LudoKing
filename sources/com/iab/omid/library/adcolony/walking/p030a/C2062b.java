package com.iab.omid.library.adcolony.walking.p030a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.walking.a.b */
public abstract class C2062b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    private C2063a f4087a;

    /* renamed from: d */
    protected final C2064b f4088d;

    /* renamed from: com.iab.omid.library.adcolony.walking.a.b$a */
    public interface C2063a {
        /* renamed from: a */
        void mo27476a(C2062b bVar);
    }

    /* renamed from: com.iab.omid.library.adcolony.walking.a.b$b */
    public interface C2064b {
        /* renamed from: a */
        void mo27477a(JSONObject jSONObject);

        /* renamed from: b */
        JSONObject mo27478b();
    }

    public C2062b(C2064b bVar) {
        this.f4088d = bVar;
    }

    /* renamed from: a */
    public void mo27472a(C2063a aVar) {
        this.f4087a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C2063a aVar = this.f4087a;
        if (aVar != null) {
            aVar.mo27476a(this);
        }
    }

    /* renamed from: a */
    public void mo27474a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
