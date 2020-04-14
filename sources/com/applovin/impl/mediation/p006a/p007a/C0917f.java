package com.applovin.impl.mediation.p006a.p007a;

import android.text.SpannedString;
import com.applovin.impl.mediation.p006a.p007a.C0911b.C0912a;

/* renamed from: com.applovin.impl.mediation.a.a.f */
public class C0917f extends C0911b {
    public C0917f(String str) {
        super(C0912a.SECTION);
        this.f1695b = new SpannedString(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SectionListItemViewModel{text=");
        sb.append(this.f1695b);
        sb.append("}");
        return sb.toString();
    }
}
