package com.applovin.impl.mediation.p014b;

import android.os.SystemClock;
import com.applovin.impl.mediation.C0999i;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.a */
public abstract class C0958a extends C0962e implements MaxAd {

    /* renamed from: a */
    protected C0999i f1833a;

    /* renamed from: c */
    private final AtomicBoolean f1834c = new AtomicBoolean();

    protected C0958a(JSONObject jSONObject, JSONObject jSONObject2, C0999i iVar, C1192i iVar2) {
        super(jSONObject, jSONObject2, iVar2);
        this.f1833a = iVar;
    }

    /* renamed from: j */
    private long mo9437j() {
        return mo9483b("load_started_time_ms", 0);
    }

    /* renamed from: a */
    public abstract C0958a mo9425a(C0999i iVar);

    /* renamed from: a */
    public boolean mo9426a() {
        C0999i iVar = this.f1833a;
        return iVar != null && iVar.mo9557c() && this.f1833a.mo9558d();
    }

    /* renamed from: b */
    public String mo9427b() {
        return mo9477a("event_id", "");
    }

    /* renamed from: c */
    public C0999i mo9428c() {
        return this.f1833a;
    }

    /* renamed from: d */
    public String mo9429d() {
        return mo9484b("bid_response", (String) null);
    }

    /* renamed from: e */
    public String mo9430e() {
        return mo9484b("third_party_ad_placement_id", (String) null);
    }

    /* renamed from: f */
    public long mo9431f() {
        if (mo9437j() > 0) {
            return SystemClock.elapsedRealtime() - mo9437j();
        }
        return -1;
    }

    /* renamed from: g */
    public void mo9432g() {
        mo9490c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public String getAdUnitId() {
        return mo9477a("ad_unit_id", "");
    }

    public MaxAdFormat getFormat() {
        return C1281o.m3104c(mo9477a("ad_format", (String) null));
    }

    /* renamed from: h */
    public AtomicBoolean mo9435h() {
        return this.f1834c;
    }

    /* renamed from: i */
    public void mo9436i() {
        this.f1833a = null;
    }
}
