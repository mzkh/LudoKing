package com.applovin.impl.mediation.p006a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.applovin.impl.mediation.p006a.p007a.C0913c;
import com.applovin.impl.mediation.p006a.p008b.C0918a;
import com.applovin.impl.mediation.p006a.p009c.p010a.C0926b;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.network.C1211a.C1214c;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1239a;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.mediation.MaxDebuggerActivity;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a */
public class C0908a implements C1214c<JSONObject> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static WeakReference<MaxDebuggerActivity> f1682a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final AtomicBoolean f1683b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1192i f1684c;

    /* renamed from: d */
    private final C1227o f1685d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C0926b f1686e;

    /* renamed from: f */
    private final AtomicBoolean f1687f = new AtomicBoolean();

    /* renamed from: g */
    private boolean f1688g;

    public C0908a(C1192i iVar) {
        this.f1684c = iVar;
        this.f1685d = iVar.mo10249v();
        this.f1686e = new C0926b(iVar.mo10179D());
    }

    /* renamed from: a */
    private void m1426a(JSONArray jSONArray) {
        String str = "MediationDebuggerService";
        this.f1685d.mo10378b(str, "Updating networks...");
        try {
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject a = C1247h.m2977a(jSONArray, i, (JSONObject) null, this.f1684c);
                if (a != null) {
                    arrayList.add(new C0913c(a, this.f1684c));
                }
            }
            Collections.sort(arrayList);
            this.f1686e.mo9362a((List<C0913c>) arrayList);
        } catch (Throwable th) {
            this.f1685d.mo10379b(str, "Failed to parse mediated network json object.", th);
        }
    }

    /* renamed from: e */
    private void m1432e() {
        if (this.f1687f.compareAndSet(false, true)) {
            this.f1684c.mo10185K().mo10131a((C1122a) new C0918a(this, this.f1684c), C1161a.MEDIATION_MAIN);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m1433f() {
        WeakReference<MaxDebuggerActivity> weakReference = f1682a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: a */
    public void mo9301a(int i) {
        C1227o oVar = this.f1685d;
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to fetch mediation debugger info: server returned ");
        sb.append(i);
        oVar.mo10382e("MediationDebuggerService", sb.toString());
        C1227o.m2841i("AppLovinSdk", "Unable to show mediation debugger.");
        this.f1686e.mo9362a(null);
        this.f1687f.set(false);
    }

    /* renamed from: a */
    public void mo9302a(JSONObject jSONObject, int i) {
        m1426a(C1247h.m2988b(jSONObject, "networks", new JSONArray(), this.f1684c));
    }

    /* renamed from: a */
    public void mo9304a(boolean z) {
        this.f1688g = z;
    }

    /* renamed from: a */
    public boolean mo9305a() {
        return this.f1688g;
    }

    /* renamed from: b */
    public void mo9306b() {
        m1432e();
        if (m1433f() || !f1683b.compareAndSet(false, true)) {
            C1227o.m2841i("AppLovinSdk", "Mediation Debugger is already showing.");
            return;
        }
        this.f1684c.mo10217aa().mo9736a(new C1239a() {
            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C0908a.this.f1684c.mo10217aa().mo9737b(this);
                    C0908a.f1682a = null;
                }
            }

            public void onActivityStarted(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    if (!C0908a.this.m1433f() || C0908a.f1682a.get() != activity) {
                        MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                        C0908a.f1682a = new WeakReference(maxDebuggerActivity);
                        maxDebuggerActivity.setListAdapter(C0908a.this.f1686e, C0908a.this.f1684c.mo10217aa());
                    }
                    C0908a.f1683b.set(false);
                }
            }
        });
        Context D = this.f1684c.mo10179D();
        Intent intent = new Intent(D, MaxDebuggerActivity.class);
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        D.startActivity(intent);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediationDebuggerService{, listAdapter=");
        sb.append(this.f1686e);
        sb.append("}");
        return sb.toString();
    }
}
