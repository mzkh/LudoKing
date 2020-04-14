package com.applovin.impl.mediation.p006a.p007a;

import android.content.Context;
import com.applovin.impl.mediation.p016d.C0990c;
import com.applovin.impl.sdk.C1192i;
import com.applovin.impl.sdk.C1227o;
import com.applovin.impl.sdk.utils.C1247h;
import com.applovin.impl.sdk.utils.C1281o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a.c */
public class C0913c implements Comparable<C0913c> {

    /* renamed from: a */
    private static String f1704a = "MediatedNetwork";

    /* renamed from: b */
    private final C0914a f1705b;

    /* renamed from: c */
    private final boolean f1706c;

    /* renamed from: d */
    private final boolean f1707d;

    /* renamed from: e */
    private final String f1708e;

    /* renamed from: f */
    private final String f1709f;

    /* renamed from: g */
    private final String f1710g;

    /* renamed from: h */
    private final String f1711h;

    /* renamed from: i */
    private final List<MaxAdFormat> f1712i;

    /* renamed from: j */
    private final List<C0916e> f1713j;

    /* renamed from: k */
    private final C0915d f1714k;

    /* renamed from: com.applovin.impl.mediation.a.a.c$a */
    public enum C0914a {
        MISSING,
        INCOMPLETE_INTEGRATION,
        INVALID_INTEGRATION,
        COMPLETE
    }

    public C0913c(JSONObject jSONObject, C1192i iVar) {
        String str;
        String str2 = "";
        this.f1708e = C1247h.m2985b(jSONObject, "display_name", str2, iVar);
        this.f1711h = C1247h.m2985b(jSONObject, "name", str2, iVar);
        JSONObject b = C1247h.m2989b(jSONObject, "configuration", new JSONObject(), iVar);
        this.f1713j = m1453a(b, iVar, iVar.mo10179D());
        this.f1714k = new C0915d(b, iVar);
        this.f1706c = C1281o.m3112e(C1247h.m2985b(jSONObject, "existence_class", str2, iVar));
        List<MaxAdFormat> emptyList = Collections.emptyList();
        MaxAdapter a = C0990c.m1770a(C1247h.m2985b(jSONObject, "adapter_class", str2, iVar), iVar);
        if (a != null) {
            this.f1707d = true;
            try {
                String adapterVersion = a.getAdapterVersion();
                try {
                    String sdkVersion = a.getSdkVersion();
                    emptyList = m1452a(a);
                    String str3 = sdkVersion;
                    str2 = adapterVersion;
                    str = str3;
                } catch (Throwable th) {
                    th = th;
                    String str4 = str2;
                    str2 = adapterVersion;
                    str = str4;
                    String str5 = f1704a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to load adapter for network ");
                    sb.append(this.f1708e);
                    sb.append(". Please check that you have a compatible network SDK integrated. Error: ");
                    sb.append(th);
                    C1227o.m2841i(str5, sb.toString());
                    this.f1710g = str2;
                    this.f1709f = str;
                    this.f1712i = emptyList;
                    this.f1705b = m1454i();
                }
            } catch (Throwable th2) {
                th = th2;
                str = str2;
                String str52 = f1704a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to load adapter for network ");
                sb2.append(this.f1708e);
                sb2.append(". Please check that you have a compatible network SDK integrated. Error: ");
                sb2.append(th);
                C1227o.m2841i(str52, sb2.toString());
                this.f1710g = str2;
                this.f1709f = str;
                this.f1712i = emptyList;
                this.f1705b = m1454i();
            }
        } else {
            this.f1707d = false;
            str = str2;
        }
        this.f1710g = str2;
        this.f1709f = str;
        this.f1712i = emptyList;
        this.f1705b = m1454i();
    }

    /* renamed from: a */
    private List<MaxAdFormat> m1452a(MaxAdapter maxAdapter) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            arrayList.add(MaxAdFormat.MREC);
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C0916e> m1453a(JSONObject jSONObject, C1192i iVar, Context context) {
        ArrayList arrayList = new ArrayList();
        JSONObject b = C1247h.m2989b(jSONObject, NativeProtocol.RESULT_ARGS_PERMISSIONS, new JSONObject(), iVar);
        Iterator keys = b.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                arrayList.add(new C0916e(str, b.getString(str), context));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    /* renamed from: i */
    private C0914a m1454i() {
        if (!this.f1706c && !this.f1707d) {
            return C0914a.MISSING;
        }
        for (C0916e c : this.f1713j) {
            if (!c.mo9336c()) {
                return C0914a.INVALID_INTEGRATION;
            }
        }
        return (!this.f1714k.mo9331a() || this.f1714k.mo9332b()) ? (!this.f1706c || !this.f1707d) ? C0914a.INCOMPLETE_INTEGRATION : C0914a.COMPLETE : C0914a.INVALID_INTEGRATION;
    }

    /* renamed from: a */
    public int compareTo(C0913c cVar) {
        return this.f1708e.compareToIgnoreCase(cVar.f1708e);
    }

    /* renamed from: a */
    public C0914a mo9321a() {
        return this.f1705b;
    }

    /* renamed from: b */
    public boolean mo9322b() {
        return this.f1706c;
    }

    /* renamed from: c */
    public boolean mo9323c() {
        return this.f1707d;
    }

    /* renamed from: d */
    public String mo9325d() {
        return this.f1708e;
    }

    /* renamed from: e */
    public String mo9326e() {
        return this.f1709f;
    }

    /* renamed from: f */
    public String mo9327f() {
        return this.f1710g;
    }

    /* renamed from: g */
    public List<C0916e> mo9328g() {
        return this.f1713j;
    }

    /* renamed from: h */
    public final C0915d mo9329h() {
        return this.f1714k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediatedNetwork{name=");
        sb.append(this.f1708e);
        sb.append(", sdkAvailable=");
        sb.append(this.f1706c);
        sb.append(", sdkVersion=");
        sb.append(this.f1709f);
        sb.append(", adapterAvailable=");
        sb.append(this.f1707d);
        sb.append(", adapterVersion=");
        sb.append(this.f1710g);
        sb.append("}");
        return sb.toString();
    }
}
