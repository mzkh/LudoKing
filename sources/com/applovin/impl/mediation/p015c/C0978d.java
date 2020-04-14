package com.applovin.impl.mediation.p015c;

import com.applovin.impl.mediation.C0993e;
import com.applovin.impl.mediation.p014b.C0958a;
import com.applovin.impl.mediation.p014b.C0960c;
import com.applovin.impl.mediation.p014b.C0962e;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.network.C1222f;
import com.applovin.impl.sdk.network.C1225g;
import com.applovin.impl.sdk.p019b.C1095b;
import com.applovin.impl.sdk.p020c.C1115i;
import com.applovin.impl.sdk.p021d.C1122a;
import com.applovin.impl.sdk.p021d.C1159r.C1161a;
import com.applovin.impl.sdk.utils.C1277l;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.mediation.c.d */
public class C0978d extends C1122a {

    /* renamed from: a */
    private final String f1881a;

    /* renamed from: c */
    private final String f1882c;

    /* renamed from: d */
    private final C0962e f1883d;

    /* renamed from: e */
    private final Map<String, String> f1884e;

    /* renamed from: f */
    private final Map<String, String> f1885f;

    /* renamed from: g */
    private final C0993e f1886g;

    public C0978d(String str, Map<String, String> map, C0993e eVar, C0962e eVar2, C1192i iVar) {
        super("TaskFireMediationPostbacks", iVar);
        this.f1881a = str;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_urls");
        this.f1882c = sb.toString();
        this.f1884e = C1281o.m3099b(map);
        if (eVar == null) {
            eVar = C0993e.EMPTY;
        }
        this.f1886g = eVar;
        this.f1883d = eVar2;
        HashMap hashMap = new HashMap(4);
        hashMap.put("Ad-Network-Name", eVar2.mo9495z());
        if (eVar2 instanceof C0958a) {
            C0958a aVar = (C0958a) eVar2;
            hashMap.put("Ad-Unit-Id", aVar.getAdUnitId());
            hashMap.put("Ad-Format", aVar.getFormat().getLabel());
            if (aVar instanceof C0960c) {
                hashMap.put("Ad-Is-Fallback", String.valueOf(((C0960c) aVar).mo9437j()));
            }
        }
        this.f1885f = hashMap;
    }

    /* renamed from: a */
    private C1225g m1717a(String str, C0993e eVar, Map<String, String> map) {
        return C1225g.m2812b(mo10073e()).mo10324a(m1718a(str, eVar)).mo10327a(false).mo10366c(map).mo10328a();
    }

    /* renamed from: a */
    private String m1718a(String str, C0993e eVar) {
        int i;
        String str2;
        if (eVar instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) eVar;
            i = maxAdapterError.getThirdPartySdkErrorCode();
            str2 = maxAdapterError.getThirdPartySdkErrorMessage();
        } else {
            i = 0;
            str2 = "";
        }
        String str3 = "{ERROR_MESSAGE}";
        return str.replace("{ERROR_CODE}", String.valueOf(eVar.getErrorCode())).replace(str3, C1277l.m3044d(eVar.getErrorMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(i)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", C1277l.m3044d(str2));
    }

    /* renamed from: b */
    private C1222f m1720b(String str, C0993e eVar, Map<String, String> map) {
        return C1222f.m2788k().mo10355a(m1718a(str, eVar)).mo10357a(false).mo10360b(map).mo10358a();
    }

    /* renamed from: b */
    private void m1721b() {
        List<String> a = this.f1883d.mo9478a(this.f1882c, this.f1884e);
        if (!a.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Firing ");
            sb.append(a.size());
            sb.append(" '");
            sb.append(this.f1881a);
            sb.append("' postback(s)");
            mo10068a(sb.toString());
            for (String a2 : a) {
                mo10073e().mo10192R().dispatchPostbackRequest(m1717a(a2, this.f1886g, this.f1885f), C1161a.MEDIATION_POSTBACKS, new AppLovinPostbackListener() {
                    public void onPostbackFailure(String str, int i) {
                        C0978d dVar = C0978d.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to fire postback with code: ");
                        sb.append(i);
                        sb.append(" and url: ");
                        sb.append(str);
                        dVar.mo10072d(sb.toString());
                    }

                    public void onPostbackSuccess(String str) {
                        C0978d dVar = C0978d.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Successfully fired postback: ");
                        sb.append(str);
                        dVar.mo10068a(sb.toString());
                    }
                });
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No postbacks to fire for event: ");
        sb2.append(this.f1881a);
        mo10068a(sb2.toString());
    }

    /* renamed from: c */
    private void m1723c() {
        List<String> a = this.f1883d.mo9478a(this.f1882c, this.f1884e);
        if (!a.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Firing ");
            sb.append(a.size());
            sb.append(" '");
            sb.append(this.f1881a);
            sb.append("' persistent postback(s)");
            mo10068a(sb.toString());
            for (String b : a) {
                mo10073e().mo10188N().mo10338a(m1720b(b, this.f1886g, this.f1885f));
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No persistent postbacks to fire for event: ");
        sb2.append(this.f1881a);
        mo10068a(sb2.toString());
    }

    /* renamed from: a */
    public C1115i mo9338a() {
        return C1115i.f2687I;
    }

    public void run() {
        if (((Boolean) mo10073e().mo10202a(C1095b.f2259j)).booleanValue()) {
            m1723c();
        } else {
            m1721b();
        }
    }
}
