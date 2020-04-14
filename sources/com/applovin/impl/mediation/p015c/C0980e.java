package com.applovin.impl.mediation.p015c;

import android.app.Activity;
import com.applovin.impl.mediation.p014b.C0958a;
import com.applovin.impl.mediation.p014b.C0959b;
import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.mediation.p014b.C0961d;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.utils.C1248i;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.e */
public class C0980e extends C1122a {

    /* renamed from: a */
    private final String f1888a;

    /* renamed from: c */
    private final JSONObject f1889c;

    /* renamed from: d */
    private final JSONObject f1890d;

    /* renamed from: e */
    private final MaxAdListener f1891e;

    /* renamed from: f */
    private final Activity f1892f;

    C0980e(String str, JSONObject jSONObject, JSONObject jSONObject2, C1192i iVar, Activity activity, MaxAdListener maxAdListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("TaskLoadAdapterAd ");
        sb.append(str);
        super(sb.toString(), iVar);
        this.f1888a = str;
        this.f1889c = jSONObject;
        this.f1890d = jSONObject2;
        this.f1892f = activity;
        this.f1891e = maxAdListener;
    }

    /* renamed from: b */
    private C0958a m1725b() throws JSONException {
        String string = this.f1890d.getString("ad_format");
        MaxAdFormat c = C1281o.m3104c(string);
        if (c == MaxAdFormat.BANNER || c == MaxAdFormat.MREC || c == MaxAdFormat.LEADER) {
            return new C0959b(this.f1889c, this.f1890d, this.f2745b);
        }
        if (c == MaxAdFormat.NATIVE) {
            return new C0961d(this.f1889c, this.f1890d, this.f2745b);
        }
        if (c == MaxAdFormat.INTERSTITIAL || c == MaxAdFormat.REWARDED) {
            return new C0960c(this.f1889c, this.f1890d, this.f2745b);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported ad format: ");
        sb.append(string);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2682D;
    }

    public void run() {
        try {
            this.f2745b.mo10252y().loadThirdPartyMediatedAd(this.f1888a, m1725b(), this.f1892f, this.f1891e);
        } catch (Throwable th) {
            mo10069a("Unable to process adapter ad", th);
            this.f2745b.mo10187M().mo10047a(mo9338a());
            C1248i.m2997a(this.f1891e, this.f1888a, (int) MaxErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED);
        }
    }
}
