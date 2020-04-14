package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.sdk.C1061a;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1239a;

/* renamed from: com.applovin.impl.mediation.a */
public class C0906a extends C1239a {

    /* renamed from: a */
    private final C1061a f1676a;

    /* renamed from: b */
    private final C1227o f1677b;

    /* renamed from: c */
    private C0907a f1678c;

    /* renamed from: d */
    private C0960c f1679d;

    /* renamed from: e */
    private int f1680e;

    /* renamed from: f */
    private boolean f1681f;

    /* renamed from: com.applovin.impl.mediation.a$a */
    public interface C0907a {
        /* renamed from: a */
        void mo9300a(C0960c cVar);
    }

    C0906a(C1192i iVar) {
        this.f1677b = iVar.mo10249v();
        this.f1676a = iVar.mo10217aa();
    }

    /* renamed from: a */
    public void mo9297a() {
        this.f1677b.mo10378b("AdActivityObserver", "Cancelling...");
        this.f1676a.mo9737b(this);
        this.f1678c = null;
        this.f1679d = null;
        this.f1680e = 0;
        this.f1681f = false;
    }

    /* renamed from: a */
    public void mo9298a(C0960c cVar, C0907a aVar) {
        C1227o oVar = this.f1677b;
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for ad ");
        sb.append(cVar.getAdUnitId());
        sb.append("...");
        oVar.mo10378b("AdActivityObserver", sb.toString());
        mo9297a();
        this.f1678c = aVar;
        this.f1679d = cVar;
        this.f1676a.mo9736a(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f1681f) {
            this.f1681f = true;
        }
        this.f1680e++;
        C1227o oVar = this.f1677b;
        StringBuilder sb = new StringBuilder();
        sb.append("Created Activity: ");
        sb.append(activity);
        sb.append(", counter is ");
        sb.append(this.f1680e);
        oVar.mo10378b("AdActivityObserver", sb.toString());
    }

    public void onActivityDestroyed(Activity activity) {
        if (this.f1681f) {
            this.f1680e--;
            C1227o oVar = this.f1677b;
            StringBuilder sb = new StringBuilder();
            sb.append("Destroyed Activity: ");
            sb.append(activity);
            sb.append(", counter is ");
            sb.append(this.f1680e);
            String sb2 = sb.toString();
            String str = "AdActivityObserver";
            oVar.mo10378b(str, sb2);
            if (this.f1680e <= 0) {
                this.f1677b.mo10378b(str, "Last ad Activity destroyed");
                if (this.f1678c != null) {
                    this.f1677b.mo10378b(str, "Invoking callback...");
                    this.f1678c.mo9300a(this.f1679d);
                }
                mo9297a();
            }
        }
    }
}
