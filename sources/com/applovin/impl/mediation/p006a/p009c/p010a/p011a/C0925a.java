package com.applovin.impl.mediation.p006a.p009c.p010a.p011a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.p006a.p007a.C0911b;
import com.applovin.impl.mediation.p006a.p007a.C0911b.C0912a;
import com.applovin.impl.mediation.p006a.p007a.C0913c;
import com.applovin.impl.mediation.p006a.p007a.C0913c.C0914a;
import com.applovin.impl.sdk.utils.C1244e;
import com.applovin.sdk.C1314R;

/* renamed from: com.applovin.impl.mediation.a.c.a.a.a */
public class C0925a extends C0911b {

    /* renamed from: d */
    private final C0913c f1741d;

    /* renamed from: e */
    private final Context f1742e;

    public C0925a(C0913c cVar, Context context) {
        super(cVar.mo9321a() == C0914a.MISSING ? C0912a.SIMPLE : C0912a.DETAIL);
        this.f1741d = cVar;
        this.f1742e = context;
    }

    /* renamed from: a */
    private SpannedString m1484a(String str, int i) {
        return m1485a(str, i, 16);
    }

    /* renamed from: a */
    private SpannedString m1485a(String str, int i, int i2) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, spannableString.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(i2, true), 0, spannableString.length(), 33);
        return new SpannedString(spannableString);
    }

    /* renamed from: j */
    private SpannedString m1486j() {
        int i;
        String str;
        if (this.f1741d.mo9322b()) {
            if (!TextUtils.isEmpty(this.f1741d.mo9326e())) {
                StringBuilder sb = new StringBuilder();
                sb.append("SDK ");
                sb.append(this.f1741d.mo9326e());
                str = sb.toString();
            } else {
                str = "SDK Found";
            }
            i = -7829368;
        } else {
            i = SupportMenu.CATEGORY_MASK;
            str = "SDK Missing";
        }
        return m1484a(str, i);
    }

    /* renamed from: k */
    private SpannedString m1487k() {
        int i;
        String str;
        if (this.f1741d.mo9323c()) {
            if (!TextUtils.isEmpty(this.f1741d.mo9327f())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Adapter ");
                sb.append(this.f1741d.mo9327f());
                str = sb.toString();
            } else {
                str = "Adapter Found";
            }
            i = -7829368;
        } else {
            i = SupportMenu.CATEGORY_MASK;
            str = "Adapter Missing";
        }
        return m1484a(str, i);
    }

    /* renamed from: l */
    private SpannedString m1488l() {
        return m1484a("Invalid Integration", SupportMenu.CATEGORY_MASK);
    }

    /* renamed from: b */
    public boolean mo9311b() {
        return this.f1741d.mo9321a() != C0914a.MISSING;
    }

    /* renamed from: c */
    public SpannedString mo9312c() {
        if (this.f1695b != null) {
            return this.f1695b;
        }
        this.f1695b = m1485a(this.f1741d.mo9325d(), this.f1741d.mo9321a() == C0914a.MISSING ? -7829368 : ViewCompat.MEASURED_STATE_MASK, 18);
        return this.f1695b;
    }

    /* renamed from: d */
    public SpannedString mo9313d() {
        if (this.f1696c != null) {
            return this.f1696c;
        }
        if (this.f1741d.mo9321a() != C0914a.MISSING) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(m1486j());
            spannableStringBuilder.append(m1484a(", ", -7829368));
            spannableStringBuilder.append(m1487k());
            if (this.f1741d.mo9321a() == C0914a.INVALID_INTEGRATION) {
                spannableStringBuilder.append(new SpannableString("\n"));
                spannableStringBuilder.append(m1488l());
            }
            this.f1696c = new SpannedString(spannableStringBuilder);
        } else {
            this.f1696c = new SpannedString("");
        }
        return this.f1696c;
    }

    /* renamed from: g */
    public int mo9316g() {
        return mo9311b() ? C1314R.C1315drawable.applovin_ic_disclosure_arrow : super.mo9316g();
    }

    /* renamed from: h */
    public int mo9317h() {
        return C1244e.m2927a(C1314R.color.applovin_sdk_disclosureButtonColor, this.f1742e);
    }

    /* renamed from: i */
    public C0913c mo9359i() {
        return this.f1741d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediatedNetworkListItemViewModel{text=");
        sb.append(this.f1695b);
        sb.append(", detailText=");
        sb.append(this.f1696c);
        sb.append(", network=");
        sb.append(this.f1741d);
        sb.append("}");
        return sb.toString();
    }
}
