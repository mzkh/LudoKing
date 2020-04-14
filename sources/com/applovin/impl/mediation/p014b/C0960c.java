package com.applovin.impl.mediation.p014b;

import com.applovin.impl.mediation.C0999i;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p017a.C1075c;
import com.applovin.impl.sdk.p019b.C1095b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.c */
public class C0960c extends C0958a {

    /* renamed from: c */
    private String f1837c;

    /* renamed from: d */
    private final AtomicReference<C1075c> f1838d;

    /* renamed from: e */
    private final AtomicBoolean f1839e;

    private C0960c(C0960c cVar, C0999i iVar) {
        super(cVar.mo9493x(), cVar.mo9492w(), iVar, cVar.f1841b);
        this.f1838d = cVar.f1838d;
        this.f1839e = cVar.f1839e;
    }

    public C0960c(JSONObject jSONObject, JSONObject jSONObject2, C1192i iVar) {
        super(jSONObject, jSONObject2, null, iVar);
        this.f1838d = new AtomicReference<>();
        this.f1839e = new AtomicBoolean();
    }

    /* renamed from: a */
    public C0958a mo9425a(C0999i iVar) {
        return new C0960c(this, iVar);
    }

    /* renamed from: a */
    public void mo9449a(C1075c cVar) {
        this.f1838d.set(cVar);
    }

    /* renamed from: a */
    public void mo9450a(String str) {
        this.f1837c = str;
    }

    /* renamed from: j */
    public boolean mo9437j() {
        return mo9488b("fa", Boolean.valueOf(false));
    }

    /* renamed from: k */
    public long mo9451k() {
        return mo9483b("ifacd_ms", -1);
    }

    /* renamed from: l */
    public long mo9452l() {
        return mo9483b("fard_ms", TimeUnit.HOURS.toMillis(1));
    }

    /* renamed from: m */
    public String mo9453m() {
        return this.f1837c;
    }

    /* renamed from: n */
    public long mo9454n() {
        String str = "ad_expiration_ms";
        long b = mo9483b(str, -1);
        return b >= 0 ? b : mo9476a(str, ((Long) this.f1841b.mo10202a(C1095b.f2239G)).longValue());
    }

    /* renamed from: o */
    public long mo9455o() {
        String str = "ad_hidden_timeout_ms";
        long b = mo9483b(str, -1);
        return b >= 0 ? b : mo9476a(str, ((Long) this.f1841b.mo10202a(C1095b.f2242J)).longValue());
    }

    /* renamed from: p */
    public boolean mo9456p() {
        String str = "schedule_ad_hidden_on_ad_dismiss";
        if (mo9488b(str, Boolean.valueOf(false))) {
            return true;
        }
        return mo9482a(str, (Boolean) this.f1841b.mo10202a(C1095b.f2243K));
    }

    /* renamed from: q */
    public long mo9457q() {
        String str = "ad_hidden_on_ad_dismiss_callback_delay_ms";
        long b = mo9483b(str, -1);
        return b >= 0 ? b : mo9476a(str, ((Long) this.f1841b.mo10202a(C1095b.f2244L)).longValue());
    }

    /* renamed from: r */
    public String mo9458r() {
        return mo9484b("bcode", "");
    }

    /* renamed from: s */
    public String mo9459s() {
        return mo9477a("mcode", "");
    }

    /* renamed from: t */
    public boolean mo9460t() {
        return this.f1839e.get();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediatedFullscreenAd{format=");
        sb.append(getFormat());
        sb.append(", adUnitId=");
        sb.append(getAdUnitId());
        sb.append(", isReady=");
        sb.append(mo9426a());
        sb.append(", adapterClass='");
        sb.append(mo9494y());
        sb.append("', adapterName='");
        sb.append(mo9495z());
        sb.append("', isTesting=");
        sb.append(mo9464A());
        sb.append(", isRefreshEnabled=");
        sb.append(mo9468E());
        sb.append(", getAdRefreshMillis=");
        sb.append(mo9469F());
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: u */
    public void mo9462u() {
        this.f1839e.set(true);
    }

    /* renamed from: v */
    public C1075c mo9463v() {
        return (C1075c) this.f1838d.getAndSet(null);
    }
}
