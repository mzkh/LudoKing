package com.inmobi.media;

import android.util.Base64;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.fr */
/* compiled from: NetworkRequest */
public class C2486fr {

    /* renamed from: a */
    private static final String f5429a = "fr";

    /* renamed from: b */
    private String f5430b;

    /* renamed from: c */
    private C2540gy f5431c;

    /* renamed from: d */
    private boolean f5432d;

    /* renamed from: e */
    private byte[] f5433e;

    /* renamed from: f */
    private byte[] f5434f;

    /* renamed from: g */
    private boolean f5435g;

    /* renamed from: h */
    private C2451ez f5436h;

    /* renamed from: i */
    protected Map<String, String> f5437i;

    /* renamed from: j */
    protected Map<String, String> f5438j;

    /* renamed from: k */
    protected Map<String, String> f5439k;

    /* renamed from: l */
    String f5440l;

    /* renamed from: m */
    public int f5441m;

    /* renamed from: n */
    public int f5442n;

    /* renamed from: o */
    public boolean f5443o;

    /* renamed from: p */
    public boolean f5444p;

    /* renamed from: q */
    public long f5445q;

    /* renamed from: r */
    boolean f5446r;

    /* renamed from: s */
    public int f5447s;

    /* renamed from: t */
    public boolean f5448t;

    /* renamed from: u */
    protected String f5449u;

    /* renamed from: v */
    public boolean f5450v;

    public C2486fr(String str, String str2, boolean z, C2540gy gyVar) {
        this(str, str2, z, gyVar, false, 0);
    }

    public C2486fr(String str, String str2) {
        this(str, str2, false, null, false, 0);
        this.f5435g = false;
    }

    public C2486fr(String str, String str2, C2540gy gyVar, int i) {
        this(str, str2, true, gyVar, false, i);
    }

    public C2486fr(String str, String str2, boolean z, C2540gy gyVar, boolean z2, int i) {
        this.f5437i = new HashMap();
        this.f5441m = 60000;
        this.f5442n = 60000;
        this.f5443o = true;
        this.f5444p = true;
        this.f5445q = -1;
        this.f5447s = 0;
        this.f5435g = true;
        this.f5448t = false;
        this.f5449u = C2505gd.m5306f();
        this.f5450v = true;
        this.f5440l = str;
        this.f5430b = str2;
        this.f5432d = z;
        this.f5431c = gyVar;
        this.f5437i.put("User-Agent", C2505gd.m5311i());
        this.f5446r = z2;
        this.f5447s = i;
        if ("GET".equals(str)) {
            this.f5438j = new HashMap();
            return;
        }
        if ("POST".equals(str)) {
            this.f5439k = new HashMap();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final C2451ez mo28411d() {
        if (this.f5436h == null) {
            this.f5436h = (C2451ez) C2438es.m5087a("pk", this.f5449u, null);
        }
        return this.f5436h;
    }

    /* renamed from: e */
    public final boolean mo28412e() {
        return this.f5445q != -1;
    }

    /* renamed from: a */
    public final void mo28407a(Map<String, String> map) {
        if (map != null) {
            this.f5437i.putAll(map);
        }
    }

    /* renamed from: b */
    public final void mo28409b(Map<String, String> map) {
        if (map != null) {
            this.f5438j.putAll(map);
        }
    }

    /* renamed from: c */
    public final void mo28410c(Map<String, String> map) {
        this.f5439k.putAll(map);
    }

    /* renamed from: f */
    public final Map<String, String> mo28413f() {
        C2515gi.m5352a(this.f5437i);
        return this.f5437i;
    }

    /* renamed from: g */
    public final String mo28414g() {
        String str = this.f5430b;
        if (this.f5438j == null) {
            return str;
        }
        String c = mo28353c();
        if (c == null || c.trim().length() == 0) {
            return str;
        }
        String str2 = "?";
        if (!str.contains(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            str = sb.toString();
        }
        String str3 = "&";
        if (!str.endsWith(str3) && !str.endsWith(str2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str3);
            str = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(c);
        return sb3.toString();
    }

    @CallSuper
    /* renamed from: a */
    public void mo27984a() {
        C2532gs.m5405d();
        boolean z = true;
        if (this.f5447s != 1) {
            z = false;
        }
        this.f5447s = C2532gs.m5400a(z);
        String str = "POST";
        String str2 = "GET";
        if (this.f5444p) {
            if (str2.equals(this.f5440l)) {
                m5215d(this.f5438j);
            } else if (str.equals(this.f5440l)) {
                m5215d(this.f5439k);
            }
        }
        if (this.f5435g) {
            JSONObject b = C2532gs.m5403b();
            if (b != null) {
                String str3 = "consentObject";
                if (str2.equals(this.f5440l)) {
                    this.f5438j.put(str3, b.toString());
                } else if (str.equals(this.f5440l)) {
                    this.f5439k.put(str3, b.toString());
                }
            }
        }
        if (this.f5450v) {
            boolean equals = str2.equals(this.f5440l);
            String str4 = "u-appsecure";
            if (equals) {
                this.f5438j.put(str4, Integer.toString(C2525go.m5384a().f5535d));
            } else if (str.equals(this.f5440l)) {
                this.f5439k.put(str4, Integer.toString(C2525go.m5384a().f5535d));
            }
        }
    }

    /* renamed from: c */
    private String mo28353c() {
        C2515gi.m5352a(this.f5438j);
        return C2515gi.m5348a(this.f5438j, "&");
    }

    /* renamed from: h */
    public final String mo28415h() {
        C2515gi.m5352a(this.f5439k);
        String str = "&";
        String a = C2515gi.m5348a(this.f5439k, str);
        if (!mo27985b()) {
            return a;
        }
        this.f5433e = C2524gn.m5376a(16);
        this.f5434f = C2524gn.m5375a();
        byte[] bArr = this.f5433e;
        byte[] bArr2 = this.f5434f;
        C2451ez d = mo28411d();
        byte[] a2 = C2524gn.m5376a(8);
        HashMap hashMap = new HashMap();
        hashMap.put("sm", C2524gn.m5374a(a, bArr2, bArr, a2, d.f5295b, d.f5294a));
        hashMap.put("sn", d.f5296c);
        return C2515gi.m5348a((Map<String, String>) hashMap, str);
    }

    /* renamed from: b */
    public boolean mo27985b() {
        return this.f5432d;
    }

    /* renamed from: d */
    private void m5215d(Map<String, String> map) {
        map.putAll(C2525go.m5384a().f5534c);
        map.putAll(C2527gp.m5388a(this.f5448t));
        map.putAll(C2533gt.m5408a());
        C2540gy gyVar = this.f5431c;
        if (gyVar != null) {
            map.putAll(gyVar.mo28483a());
        }
    }

    @Nullable
    /* renamed from: a */
    public final byte[] mo28408a(byte[] bArr) {
        try {
            return C2524gn.m5380a(Base64.decode(bArr, 0), this.f5434f, this.f5433e);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: i */
    public final long mo28416i() {
        try {
            if ("GET".equals(this.f5440l)) {
                return 0 + ((long) mo28353c().length());
            }
            if ("POST".equals(this.f5440l)) {
                return ((long) mo28415h().length()) + 0;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
