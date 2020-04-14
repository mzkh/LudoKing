package com.applovin.impl.sdk.p021d;

import android.net.Uri;
import com.applovin.impl.mediation.p014b.C0958a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.p018ad.C1078a;
import com.applovin.impl.sdk.p018ad.C1084f;
import com.applovin.impl.sdk.p020c.C1108d;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.d.d */
public class C1135d extends C1133c {

    /* renamed from: c */
    private final C1078a f2768c;

    /* renamed from: d */
    private boolean f2769d;

    /* renamed from: e */
    private boolean f2770e;

    public C1135d(C1078a aVar, C1192i iVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, iVar, appLovinAdLoadListener);
        this.f2768c = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m2362j() {
        boolean b = this.f2768c.mo8884b();
        boolean z = this.f2770e;
        String str = "...";
        if (b || z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Begin caching for streaming ad #");
            sb.append(this.f2768c.getAdIdNumber());
            sb.append(str);
            mo10068a(sb.toString());
            mo10094d();
            if (b) {
                if (this.f2769d) {
                    mo10097i();
                }
                m2363k();
                if (!this.f2769d) {
                    mo10097i();
                }
                m2364l();
            } else {
                mo10097i();
                m2363k();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Begin processing for non-streaming ad #");
            sb2.append(this.f2768c.getAdIdNumber());
            sb2.append(str);
            mo10068a(sb2.toString());
            mo10094d();
            m2363k();
            m2364l();
            mo10097i();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f2768c.getCreatedAtMillis();
        C1108d.m2212a(this.f2768c, this.f2745b);
        C1108d.m2211a(currentTimeMillis, (AppLovinAdBase) this.f2768c, this.f2745b);
        mo10090a((AppLovinAdBase) this.f2768c);
        mo10092b();
    }

    /* renamed from: k */
    private void m2363k() {
        mo10068a("Caching HTML resources...");
        this.f2768c.mo9831a(mo10089a(this.f2768c.mo8878a(), this.f2768c.mo9868F(), (C1084f) this.f2768c));
        this.f2768c.mo9892a(true);
        StringBuilder sb = new StringBuilder();
        sb.append("Finish caching non-video resources for ad #");
        sb.append(this.f2768c.getAdIdNumber());
        mo10068a(sb.toString());
        C1227o v = this.f2745b.mo10249v();
        String f = mo10074f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ad updated with cachedHTML = ");
        sb2.append(this.f2768c.mo8878a());
        v.mo10376a(f, sb2.toString());
    }

    /* renamed from: l */
    private void m2364l() {
        if (!mo10093c()) {
            Uri e = mo10095e(this.f2768c.mo9833e());
            if (e != null) {
                this.f2768c.mo9832c();
                this.f2768c.mo9830a(e);
            }
        }
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2700i;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo9631a(C0958a aVar) {
        super.mo9631a(aVar);
    }

    /* renamed from: a */
    public void mo10100a(boolean z) {
        this.f2769d = z;
    }

    /* renamed from: b */
    public void mo10101b(boolean z) {
        this.f2770e = z;
    }

    public void run() {
        super.run();
        C11361 r0 = new Runnable() {
            public void run() {
                C1135d.this.m2362j();
            }
        };
        if (this.f2759a.mo9871I()) {
            this.f2745b.mo10185K().mo10136c().execute(r0);
        } else {
            r0.run();
        }
    }
}
