package com.iab.omid.library.inmobi.walking.p036a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.inmobi.walking.a.b */
public abstract class C2110b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    private C2111a f4189a;

    /* renamed from: d */
    protected final C2112b f4190d;

    /* renamed from: com.iab.omid.library.inmobi.walking.a.b$a */
    public interface C2111a {
        /* renamed from: a */
        void mo27642a(C2110b bVar);
    }

    /* renamed from: com.iab.omid.library.inmobi.walking.a.b$b */
    public interface C2112b {
        /* renamed from: a */
        void mo27643a(JSONObject jSONObject);

        /* renamed from: b */
        JSONObject mo27644b();
    }

    public C2110b(C2112b bVar) {
        this.f4190d = bVar;
    }

    /* renamed from: a */
    public void mo27638a(C2111a aVar) {
        this.f4189a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C2111a aVar = this.f4189a;
        if (aVar != null) {
            aVar.mo27642a(this);
        }
    }

    /* renamed from: a */
    public void mo27640a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
