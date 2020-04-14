package com.applovin.impl.mediation.p014b;

import android.view.View;
import com.applovin.impl.mediation.C0999i;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p019b.C1096c;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdkUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.b */
public class C0959b extends C0958a {

    /* renamed from: c */
    private static final int f1835c = AppLovinAdSize.BANNER.getHeight();

    /* renamed from: d */
    private static final int f1836d = AppLovinAdSize.LEADER.getHeight();

    private C0959b(C0959b bVar, C0999i iVar) {
        super(bVar.mo9493x(), bVar.mo9492w(), iVar, bVar.f1841b);
    }

    public C0959b(JSONObject jSONObject, JSONObject jSONObject2, C1192i iVar) {
        super(jSONObject, jSONObject2, null, iVar);
    }

    /* renamed from: a */
    public C0958a mo9425a(C0999i iVar) {
        return new C0959b(this, iVar);
    }

    /* renamed from: j */
    public int mo9437j() {
        int a = mo9475a("ad_view_width", ((Integer) this.f1841b.mo10202a(C1095b.f2265p)).intValue());
        return a == -2 ? AppLovinSdkUtils.isTablet(this.f1841b.mo10179D()) ? 728 : 320 : a;
    }

    /* renamed from: k */
    public int mo9438k() {
        int a = mo9475a("ad_view_height", ((Integer) this.f1841b.mo10202a(C1095b.f2266q)).intValue());
        return a == -2 ? AppLovinSdkUtils.isTablet(this.f1841b.mo10179D()) ? f1836d : f1835c : a;
    }

    /* renamed from: l */
    public View mo9439l() {
        if (!mo9426a() || this.f1833a == null) {
            return null;
        }
        View a = this.f1833a.mo9550a();
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Ad-view based ad is missing an ad view");
    }

    /* renamed from: m */
    public long mo9440m() {
        return mo9483b("viewability_imp_delay_ms", ((Long) this.f1841b.mo10202a(C1096c.f2422cf)).longValue());
    }

    /* renamed from: n */
    public int mo9441n() {
        C1096c<Integer> cVar = getFormat() == MaxAdFormat.BANNER ? C1096c.f2423cg : getFormat() == MaxAdFormat.MREC ? C1096c.f2425ci : C1096c.f2427ck;
        return mo9475a("viewability_min_width", ((Integer) this.f1841b.mo10202a(cVar)).intValue());
    }

    /* renamed from: o */
    public int mo9442o() {
        C1096c<Integer> cVar = getFormat() == MaxAdFormat.BANNER ? C1096c.f2424ch : getFormat() == MaxAdFormat.MREC ? C1096c.f2426cj : C1096c.f2428cl;
        return mo9475a("viewability_min_height", ((Integer) this.f1841b.mo10202a(cVar)).intValue());
    }

    /* renamed from: p */
    public float mo9443p() {
        return mo9474a("viewability_min_alpha", ((Float) this.f1841b.mo10202a(C1095b.f2429cm)).floatValue() / 100.0f);
    }

    /* renamed from: q */
    public int mo9444q() {
        return mo9475a("viewability_min_pixels", -1);
    }

    /* renamed from: r */
    public boolean mo9445r() {
        return mo9444q() >= 0;
    }

    /* renamed from: s */
    public long mo9446s() {
        return mo9483b("viewability_timer_min_visible_ms", ((Long) this.f1841b.mo10202a(C1095b.f2430cn)).longValue());
    }

    /* renamed from: t */
    public boolean mo9447t() {
        return mo9488b("proe", (Boolean) this.f1841b.mo10202a(C1095b.f2245M));
    }

    /* renamed from: u */
    public long mo9448u() {
        return C1281o.m3113f(mo9484b("bg_color", (String) null));
    }
}
