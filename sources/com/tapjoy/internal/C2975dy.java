package com.tapjoy.internal;

import android.os.AsyncTask;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dy */
public abstract class C2975dy extends AsyncTask {

    /* renamed from: d */
    C2976a f6867d;

    /* renamed from: e */
    protected final C2977b f6868e;

    /* renamed from: com.tapjoy.internal.dy$a */
    public interface C2976a {
        /* renamed from: a */
        void mo29970a();
    }

    /* renamed from: com.tapjoy.internal.dy$b */
    public interface C2977b {
        /* renamed from: a */
        JSONObject mo29971a();

        /* renamed from: a */
        void mo29972a(JSONObject jSONObject);
    }

    public C2975dy(C2977b bVar) {
        this.f6868e = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C2976a aVar = this.f6867d;
        if (aVar != null) {
            aVar.mo29970a();
        }
    }
}
