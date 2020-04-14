package com.applovin.impl.mediation.p006a.p009c.p012b;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.applovin.impl.mediation.p006a.p007a.C0911b;
import com.applovin.impl.mediation.p006a.p007a.C0911b.C0912a;
import com.applovin.impl.mediation.p006a.p007a.C0913c;
import com.applovin.impl.mediation.p006a.p007a.C0913c.C0914a;
import com.applovin.impl.mediation.p006a.p007a.C0915d;
import com.applovin.impl.mediation.p006a.p007a.C0916e;
import com.applovin.impl.mediation.p006a.p007a.C0917f;
import com.applovin.impl.mediation.p006a.p009c.C0920a;
import com.applovin.impl.mediation.p006a.p009c.p012b.p013a.C0931a;
import com.applovin.impl.mediation.p006a.p009c.p012b.p013a.C0931a.C0933a;
import com.applovin.impl.sdk.utils.C1244e;
import com.applovin.sdk.C1314R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.a.c.b.b */
public class C0934b extends C0920a {

    /* renamed from: c */
    private final C0911b f1763c = new C0917f("INTEGRATIONS");

    /* renamed from: d */
    private final C0911b f1764d = new C0917f("PERMISSIONS");

    /* renamed from: e */
    private final C0911b f1765e = new C0917f("CONFIGURATION");

    /* renamed from: f */
    private final C0911b f1766f;

    /* renamed from: g */
    private SpannedString f1767g;

    /* renamed from: h */
    private C0935a f1768h;

    /* renamed from: com.applovin.impl.mediation.a.c.b.b$a */
    public interface C0935a {
        /* renamed from: a */
        void mo9368a(String str);
    }

    C0934b(C0913c cVar, Context context) {
        super(context);
        String str = "";
        this.f1766f = new C0917f(str);
        if (cVar.mo9321a() == C0914a.INVALID_INTEGRATION) {
            SpannableString spannableString = new SpannableString("Tap for more information");
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
            this.f1767g = new SpannedString(spannableString);
        } else {
            this.f1767g = new SpannedString(str);
        }
        this.f1729b.add(this.f1763c);
        this.f1729b.add(mo9380a(cVar));
        this.f1729b.add(mo9384b(cVar));
        this.f1729b.addAll(mo9382a(cVar.mo9328g()));
        this.f1729b.addAll(mo9381a(cVar.mo9329h()));
        this.f1729b.add(this.f1766f);
    }

    /* renamed from: a */
    private int m1515a(boolean z) {
        return z ? C1314R.C1315drawable.applovin_ic_check_mark : C1314R.C1315drawable.applovin_ic_x_mark;
    }

    /* renamed from: b */
    private int m1516b(boolean z) {
        return C1244e.m2927a(z ? C1314R.color.applovin_sdk_checkmarkColor : C1314R.color.applovin_sdk_xmarkColor, this.f1728a);
    }

    /* renamed from: a */
    public C0911b mo9380a(C0913c cVar) {
        C0933a a = C0931a.m1501j().mo9374a("SDK").mo9378b(cVar.mo9326e()).mo9373a(TextUtils.isEmpty(cVar.mo9326e()) ? C0912a.DETAIL : C0912a.RIGHT_DETAIL);
        if (TextUtils.isEmpty(cVar.mo9326e())) {
            a.mo9371a(m1515a(cVar.mo9322b())).mo9377b(m1516b(cVar.mo9322b()));
        }
        return a.mo9376a();
    }

    /* renamed from: a */
    public List<C0911b> mo9381a(C0915d dVar) {
        ArrayList arrayList = new ArrayList(2);
        if (dVar.mo9331a()) {
            boolean b = dVar.mo9332b();
            arrayList.add(this.f1765e);
            arrayList.add(C0931a.m1501j().mo9374a("Cleartext Traffic").mo9372a(b ? null : this.f1767g).mo9379c(dVar.mo9333c()).mo9371a(m1515a(b)).mo9377b(m1516b(b)).mo9375a(!b).mo9376a());
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<C0911b> mo9382a(List<C0916e> list) {
        ArrayList arrayList = new ArrayList(list.size() + 1);
        if (list.size() > 0) {
            arrayList.add(this.f1764d);
            for (C0916e eVar : list) {
                boolean c = eVar.mo9336c();
                arrayList.add(C0931a.m1501j().mo9374a(eVar.mo9334a()).mo9372a(c ? null : this.f1767g).mo9379c(eVar.mo9335b()).mo9371a(m1515a(c)).mo9377b(m1516b(c)).mo9375a(!c).mo9376a());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9343a(C0911b bVar) {
        if (this.f1768h != null && (bVar instanceof C0931a)) {
            String i = ((C0931a) bVar).mo9369i();
            if (!TextUtils.isEmpty(i)) {
                this.f1768h.mo9368a(i);
            }
        }
    }

    /* renamed from: a */
    public void mo9383a(C0935a aVar) {
        this.f1768h = aVar;
    }

    /* renamed from: b */
    public C0911b mo9384b(C0913c cVar) {
        C0933a a = C0931a.m1501j().mo9374a("Adapter").mo9378b(cVar.mo9327f()).mo9373a(TextUtils.isEmpty(cVar.mo9327f()) ? C0912a.DETAIL : C0912a.RIGHT_DETAIL);
        if (TextUtils.isEmpty(cVar.mo9327f())) {
            a.mo9371a(m1515a(cVar.mo9323c())).mo9377b(m1516b(cVar.mo9323c()));
        }
        return a.mo9376a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediatedNetworkListAdapter{listItems=");
        sb.append(this.f1729b);
        sb.append("}");
        return sb.toString();
    }
}
