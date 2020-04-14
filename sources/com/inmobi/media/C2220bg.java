package com.inmobi.media;

import android.graphics.Point;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.inmobi.media.C2228bl.C2229a;
import com.inmobi.media.C2284ck.C2285a;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bg */
/* compiled from: NativeDataModel */
public class C2220bg {

    /* renamed from: m */
    private static final String f4563m = "bg";

    /* renamed from: a */
    public int f4564a;

    /* renamed from: b */
    public boolean f4565b;

    /* renamed from: c */
    public boolean f4566c;

    /* renamed from: d */
    public C2216be f4567d;

    /* renamed from: e */
    public JSONArray f4568e;
    @Nullable

    /* renamed from: f */
    public C2220bg f4569f;
    @Nullable

    /* renamed from: g */
    public Map<String, String> f4570g;
    @Nullable

    /* renamed from: h */
    public C2296cq f4571h;

    /* renamed from: i */
    public C2221a f4572i;

    /* renamed from: j */
    public boolean f4573j;

    /* renamed from: k */
    public C2237bq f4574k;
    @Nullable

    /* renamed from: l */
    HashMap<String, String> f4575l;

    /* renamed from: n */
    private JSONObject f4576n;

    /* renamed from: o */
    private JSONObject f4577o;

    /* renamed from: p */
    private Map<String, List<C2214bc>> f4578p;

    /* renamed from: q */
    private Map<String, C2214bc> f4579q;

    /* renamed from: r */
    private Map<String, String> f4580r;

    /* renamed from: s */
    private C2426eq f4581s;

    /* renamed from: t */
    private int f4582t;

    /* renamed from: u */
    private boolean f4583u;

    /* renamed from: com.inmobi.media.bg$a */
    /* compiled from: NativeDataModel */
    public class C2221a {

        /* renamed from: a */
        public JSONObject f4584a;
        @NonNull

        /* renamed from: b */
        public C2222a f4585b = new C2222a();

        /* renamed from: c */
        public C2214bc f4586c;

        /* renamed from: com.inmobi.media.bg$a$a */
        /* compiled from: NativeDataModel */
        public class C2222a {

            /* renamed from: a */
            public String f4588a;

            /* renamed from: b */
            public String f4589b;

            /* renamed from: c */
            public String f4590c;

            /* renamed from: d */
            public String f4591d;

            /* renamed from: e */
            public float f4592e;

            /* renamed from: f */
            public String f4593f;

            /* renamed from: g */
            public boolean f4594g;

            public C2222a() {
            }
        }

        public C2221a() {
        }
    }

    public C2220bg() {
        this.f4569f = null;
    }

    public C2220bg(int i, @NonNull JSONObject jSONObject, @NonNull C2426eq eqVar, @Nullable HashMap<String, String> hashMap, @Nullable C2296cq cqVar) {
        this(i, jSONObject, null, false, eqVar, hashMap, cqVar);
    }

    public C2220bg(int i, @NonNull JSONObject jSONObject, @Nullable C2220bg bgVar, boolean z, @NonNull C2426eq eqVar) {
        this(i, jSONObject, bgVar, z, eqVar, bgVar == null ? null : bgVar.f4575l, null);
    }

    private C2220bg(int i, @NonNull JSONObject jSONObject, @Nullable C2220bg bgVar, boolean z, @NonNull C2426eq eqVar, @Nullable HashMap<String, String> hashMap, @Nullable C2296cq cqVar) {
        this.f4582t = i;
        this.f4569f = bgVar;
        this.f4581s = eqVar;
        this.f4576n = jSONObject;
        this.f4564a = 0;
        this.f4565b = false;
        this.f4571h = cqVar;
        this.f4579q = new HashMap();
        this.f4580r = new HashMap();
        this.f4578p = new HashMap();
        this.f4572i = new C2221a();
        this.f4583u = z;
        this.f4575l = hashMap;
        m4521i();
    }

    @NonNull
    /* renamed from: a */
    public final HashMap<String, String> mo27958a() {
        HashMap<String, String> hashMap = this.f4575l;
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    /* renamed from: b */
    public final JSONObject mo27960b() {
        try {
            return this.f4568e.getJSONObject(0);
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return null;
        }
    }

    /* renamed from: f */
    private C2216be m4511f() {
        Iterator it = this.f4567d.iterator();
        while (it.hasNext()) {
            C2214bc bcVar = (C2214bc) it.next();
            if (bcVar.f4524d.equalsIgnoreCase("card_scrollable")) {
                return (C2216be) bcVar;
            }
        }
        return null;
    }

    /* renamed from: c */
    public final int mo27961c() {
        C2216be beVar = this.f4567d;
        if (beVar == null) {
            return 0;
        }
        Iterator it = beVar.iterator();
        while (it.hasNext()) {
            C2214bc bcVar = (C2214bc) it.next();
            if (bcVar.f4524d.equalsIgnoreCase("card_scrollable")) {
                return ((C2216be) bcVar).f4559C;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public final C2216be mo27957a(int i) {
        Iterator it = this.f4567d.iterator();
        while (it.hasNext()) {
            C2214bc bcVar = (C2214bc) it.next();
            if (bcVar.f4524d.equalsIgnoreCase("card_scrollable")) {
                C2216be beVar = (C2216be) bcVar;
                if (i >= beVar.f4559C) {
                    return null;
                }
                return (C2216be) beVar.mo27950a(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C2216be m4493a(@NonNull C2214bc bcVar) {
        if (bcVar instanceof C2216be) {
            C2216be beVar = (C2216be) bcVar;
            if (m4499a(beVar)) {
                return beVar;
            }
        }
        for (C2216be beVar2 = (C2216be) bcVar.f4540t; beVar2 != null; beVar2 = (C2216be) beVar2.f4540t) {
            if (m4499a(beVar2)) {
                return beVar2;
            }
        }
        return null;
    }

    /* renamed from: g */
    private void m4516g() {
        List list;
        for (C2214bc bcVar : mo27962c(ShareConstants.IMAGE_URL)) {
            if (!URLUtil.isValidUrl((String) bcVar.f4525e)) {
                C2214bc a = m4490a(this, bcVar);
                if (a != null) {
                    if (a.f4522b.equals(bcVar.f4522b)) {
                        bcVar.f4525e = a.f4525e;
                    } else {
                        if (ShareConstants.VIDEO_URL.equals(a.f4522b) && 1 != a.f4533m && 2 == a.f4533m) {
                            C2235bp bpVar = (C2235bp) a;
                            C2297cr b = bpVar.mo27982b();
                            C2284ck a2 = C2283cj.m4629a(bpVar, bcVar);
                            C2285a aVar = null;
                            if (a2 == null) {
                                list = null;
                            } else {
                                list = a2.mo28121a(1);
                            }
                            if (list != null) {
                                Iterator it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    C2285a aVar2 = (C2285a) it.next();
                                    if (URLUtil.isValidUrl(aVar2.f4804b)) {
                                        aVar = aVar2;
                                        break;
                                    }
                                }
                            }
                            if (a2 != null && aVar != null) {
                                b.mo28137a(a2);
                                bcVar.f4525e = aVar.f4804b;
                                bcVar.mo27941a(a2.mo28122a("creativeView"));
                                for (C2234bo boVar : bpVar.f4541u) {
                                    if ("error".equals(boVar.f4631d)) {
                                        bcVar.f4541u.add(boVar);
                                    }
                                }
                            } else if (b.mo28141e().size() > 0) {
                                m4498a(bpVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0107  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4519h() {
        /*
            r12 = this;
            java.lang.String r0 = "WEBVIEW"
            java.util.List r0 = r12.mo27962c(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0110
            java.lang.Object r1 = r0.next()
            com.inmobi.media.bc r1 = (com.inmobi.media.C2214bc) r1
            r2 = r1
            com.inmobi.media.bq r2 = (com.inmobi.media.C2237bq) r2
            java.lang.String r3 = r2.f4645z
            java.lang.String r4 = "URL"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x000a
            java.lang.String r3 = r2.f4645z
            java.lang.String r4 = "HTML"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x000a
            com.inmobi.media.bc r3 = m4490a(r12, r1)
            if (r3 == 0) goto L_0x000a
            java.lang.String r4 = r3.f4522b
            java.lang.String r5 = r1.f4522b
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0042
            java.lang.Object r2 = r3.f4525e
            r1.f4525e = r2
            goto L_0x000a
        L_0x0042:
            java.lang.String r4 = r3.f4522b
            java.lang.String r5 = "VIDEO"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x000a
            int r4 = r3.f4533m
            r5 = 2
            if (r5 != r4) goto L_0x000a
            com.inmobi.media.bp r3 = (com.inmobi.media.C2235bp) r3
            com.inmobi.media.cr r4 = r3.mo27982b()
            com.inmobi.media.ck r6 = com.inmobi.media.C2283cj.m4629a(r3, r1)
            java.lang.String r7 = "REF_HTML"
            java.lang.String r8 = "REF_IFRAME"
            if (r6 == 0) goto L_0x00d1
            java.lang.String r9 = r2.f4645z
            boolean r9 = r7.equals(r9)
            r10 = 3
            r11 = 0
            if (r9 == 0) goto L_0x0099
            java.util.List r5 = r6.mo28121a(r5)
            int r9 = r5.size()
            if (r9 <= 0) goto L_0x007e
            java.lang.Object r5 = r5.get(r11)
            com.inmobi.media.ck$a r5 = (com.inmobi.media.C2284ck.C2285a) r5
            java.lang.String r5 = r5.f4804b
            goto L_0x00d2
        L_0x007e:
            java.util.List r5 = r6.mo28121a(r10)
            int r9 = r5.size()
            if (r9 <= 0) goto L_0x00d1
            java.lang.Object r5 = r5.get(r11)
            com.inmobi.media.ck$a r5 = (com.inmobi.media.C2284ck.C2285a) r5
            java.lang.String r5 = r5.f4804b
            boolean r9 = android.webkit.URLUtil.isValidUrl(r5)
            if (r9 == 0) goto L_0x00d1
            r2.f4645z = r8
            goto L_0x00d2
        L_0x0099:
            java.lang.String r9 = r2.f4645z
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x00d1
            java.util.List r9 = r6.mo28121a(r10)
            int r10 = r9.size()
            if (r10 <= 0) goto L_0x00bc
            java.lang.Object r5 = r9.get(r11)
            com.inmobi.media.ck$a r5 = (com.inmobi.media.C2284ck.C2285a) r5
            java.lang.String r5 = r5.f4804b
            boolean r9 = android.webkit.URLUtil.isValidUrl(r5)
            if (r9 == 0) goto L_0x00d1
            r2.f4645z = r8
            goto L_0x00d2
        L_0x00bc:
            java.util.List r5 = r6.mo28121a(r5)
            int r9 = r5.size()
            if (r9 <= 0) goto L_0x00d1
            r2.f4645z = r7
            java.lang.Object r5 = r5.get(r11)
            com.inmobi.media.ck$a r5 = (com.inmobi.media.C2284ck.C2285a) r5
            java.lang.String r5 = r5.f4804b
            goto L_0x00d2
        L_0x00d1:
            r5 = 0
        L_0x00d2:
            java.lang.String r9 = r2.f4645z
            boolean r8 = r8.equals(r9)
            java.lang.String r9 = r2.f4645z
            boolean r7 = r7.equals(r9)
            if (r6 == 0) goto L_0x00fd
            if (r8 == 0) goto L_0x00e8
            boolean r8 = android.webkit.URLUtil.isValidUrl(r5)
            if (r8 == 0) goto L_0x00fd
        L_0x00e8:
            if (r7 == 0) goto L_0x00ed
            if (r5 != 0) goto L_0x00ed
            goto L_0x00fd
        L_0x00ed:
            r4.mo28137a(r6)
            r1.f4525e = r5
            java.lang.String r2 = "creativeView"
            java.util.List r2 = r6.mo28122a(r2)
            r1.mo27941a(r2)
            goto L_0x000a
        L_0x00fd:
            java.util.List r1 = r4.mo28141e()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x010a
            m4498a(r3)
        L_0x010a:
            java.lang.String r1 = "UNKNOWN"
            r2.f4645z = r1
            goto L_0x000a
        L_0x0110:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4519h():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:39|40|41|42|(2:44|45)(1:46)|47|(1:49)|50|51|52|(1:54)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x0152 */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x028e A[Catch:{ JSONException -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0296 A[Catch:{ JSONException -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c A[Catch:{ JSONException -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071 A[Catch:{ JSONException -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4 A[Catch:{ JSONException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6 A[Catch:{ JSONException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0115 A[Catch:{ JSONException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0158 A[Catch:{ JSONException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0175 A[Catch:{ JSONException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019c A[Catch:{ JSONException -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ab A[Catch:{ JSONException -> 0x029f }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c6 A[Catch:{ JSONException -> 0x029f }] */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4521i() {
        /*
            r14 = this;
            java.lang.String r0 = "pages"
            java.lang.String r1 = "openMode"
            java.lang.String r2 = "itemUrl"
            java.lang.String r3 = "onClick"
            java.lang.String r4 = "adContent"
            java.lang.String r5 = "passThroughJson"
            java.lang.String r6 = "orientation"
            org.json.JSONObject r7 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            java.lang.String r8 = "styleRefs"
            org.json.JSONObject r7 = r7.optJSONObject(r8)     // Catch:{ JSONException -> 0x029f }
            r14.f4577o = r7     // Catch:{ JSONException -> 0x029f }
            org.json.JSONObject r7 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            boolean r7 = r7.isNull(r6)     // Catch:{ JSONException -> 0x029f }
            r8 = -1
            r9 = 2
            r10 = 1
            r11 = 0
            if (r7 == 0) goto L_0x0026
        L_0x0024:
            r6 = 0
            goto L_0x0072
        L_0x0026:
            org.json.JSONObject r7 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            java.lang.String r6 = r7.getString(r6)     // Catch:{ JSONException -> 0x029f }
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ JSONException -> 0x029f }
            java.lang.String r6 = r6.toLowerCase(r7)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r6 = r6.trim()     // Catch:{ JSONException -> 0x029f }
            int r7 = r6.hashCode()     // Catch:{ JSONException -> 0x029f }
            r12 = -1626174665(0xffffffff9f128b37, float:-3.103186E-20)
            r13 = 3
            if (r7 == r12) goto L_0x005f
            r12 = 729267099(0x2b77bb9b, float:8.8012383E-13)
            if (r7 == r12) goto L_0x0055
            r12 = 1430647483(0x5545f2bb, float:1.36028944E13)
            if (r7 == r12) goto L_0x004b
            goto L_0x0069
        L_0x004b:
            java.lang.String r7 = "landscape"
            boolean r6 = r6.equals(r7)     // Catch:{ JSONException -> 0x029f }
            if (r6 == 0) goto L_0x0069
            r6 = 3
            goto L_0x006a
        L_0x0055:
            java.lang.String r7 = "portrait"
            boolean r6 = r6.equals(r7)     // Catch:{ JSONException -> 0x029f }
            if (r6 == 0) goto L_0x0069
            r6 = 2
            goto L_0x006a
        L_0x005f:
            java.lang.String r7 = "unspecified"
            boolean r6 = r6.equals(r7)     // Catch:{ JSONException -> 0x029f }
            if (r6 == 0) goto L_0x0069
            r6 = 1
            goto L_0x006a
        L_0x0069:
            r6 = -1
        L_0x006a:
            if (r6 == r9) goto L_0x0071
            if (r6 == r13) goto L_0x006f
            goto L_0x0024
        L_0x006f:
            r6 = 2
            goto L_0x0072
        L_0x0071:
            r6 = 1
        L_0x0072:
            r14.f4564a = r6     // Catch:{ JSONException -> 0x029f }
            org.json.JSONObject r6 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            java.lang.String r7 = "shouldAutoOpenLandingPage"
            boolean r6 = r6.optBoolean(r7, r10)     // Catch:{ JSONException -> 0x029f }
            r14.f4573j = r6     // Catch:{ JSONException -> 0x029f }
            org.json.JSONObject r6 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            java.lang.String r7 = "disableBackButton"
            boolean r6 = r6.optBoolean(r7, r11)     // Catch:{ JSONException -> 0x029f }
            r14.f4565b = r6     // Catch:{ JSONException -> 0x029f }
            org.json.JSONObject r6 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            java.lang.String r7 = "rootContainer"
            org.json.JSONObject r6 = r6.getJSONObject(r7)     // Catch:{ JSONException -> 0x029f }
            java.lang.String r7 = "CONTAINER"
            java.lang.String r12 = "/rootContainer"
            com.inmobi.media.bc r6 = r14.m4491a(r6, r7, r12)     // Catch:{ JSONException -> 0x029f }
            com.inmobi.media.be r6 = (com.inmobi.media.C2216be) r6     // Catch:{ JSONException -> 0x029f }
            r14.f4567d = r6     // Catch:{ JSONException -> 0x029f }
            org.json.JSONObject r6 = r14.f4576n     // Catch:{ JSONException -> 0x0183 }
            boolean r6 = r6.isNull(r5)     // Catch:{ JSONException -> 0x0183 }
            if (r6 != 0) goto L_0x00ae
            com.inmobi.media.bg$a r6 = r14.f4572i     // Catch:{ JSONException -> 0x0183 }
            org.json.JSONObject r7 = r14.f4576n     // Catch:{ JSONException -> 0x0183 }
            org.json.JSONObject r5 = r7.getJSONObject(r5)     // Catch:{ JSONException -> 0x0183 }
            r6.f4584a = r5     // Catch:{ JSONException -> 0x0183 }
        L_0x00ae:
            org.json.JSONObject r5 = r14.f4576n     // Catch:{ JSONException -> 0x0183 }
            boolean r5 = r5.isNull(r4)     // Catch:{ JSONException -> 0x0183 }
            if (r5 != 0) goto L_0x0108
            org.json.JSONObject r5 = r14.f4576n     // Catch:{ JSONException -> 0x0183 }
            org.json.JSONObject r4 = r5.getJSONObject(r4)     // Catch:{ JSONException -> 0x0183 }
            if (r4 == 0) goto L_0x0108
            com.inmobi.media.bg$a$a r5 = new com.inmobi.media.bg$a$a     // Catch:{ JSONException -> 0x0183 }
            com.inmobi.media.bg$a r6 = r14.f4572i     // Catch:{ JSONException -> 0x0183 }
            r6.getClass()     // Catch:{ JSONException -> 0x0183 }
            r5.<init>()     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r6 = "title"
            r7 = 0
            java.lang.String r6 = r4.optString(r6, r7)     // Catch:{ JSONException -> 0x0183 }
            r5.f4588a = r6     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r6 = "description"
            java.lang.String r6 = r4.optString(r6, r7)     // Catch:{ JSONException -> 0x0183 }
            r5.f4589b = r6     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r6 = "ctaText"
            java.lang.String r6 = r4.optString(r6, r7)     // Catch:{ JSONException -> 0x0183 }
            r5.f4591d = r6     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r6 = "iconUrl"
            java.lang.String r6 = r4.optString(r6, r7)     // Catch:{ JSONException -> 0x0183 }
            r5.f4590c = r6     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r6 = "rating"
            r12 = 0
            long r12 = r4.optLong(r6, r12)     // Catch:{ JSONException -> 0x0183 }
            float r6 = (float) r12     // Catch:{ JSONException -> 0x0183 }
            r5.f4592e = r6     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r6 = "landingPageUrl"
            java.lang.String r6 = r4.optString(r6, r7)     // Catch:{ JSONException -> 0x0183 }
            r5.f4593f = r6     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r6 = "isApp"
            boolean r4 = r4.optBoolean(r6)     // Catch:{ JSONException -> 0x0183 }
            r5.f4594g = r4     // Catch:{ JSONException -> 0x0183 }
            com.inmobi.media.bg$a r4 = r14.f4572i     // Catch:{ JSONException -> 0x0183 }
            r4.f4585b = r5     // Catch:{ JSONException -> 0x0183 }
        L_0x0108:
            com.inmobi.media.bc r4 = new com.inmobi.media.bc     // Catch:{ JSONException -> 0x0183 }
            r4.<init>()     // Catch:{ JSONException -> 0x0183 }
            org.json.JSONObject r5 = r14.f4576n     // Catch:{ JSONException -> 0x0183 }
            boolean r5 = r5.isNull(r3)     // Catch:{ JSONException -> 0x0183 }
            if (r5 != 0) goto L_0x016b
            org.json.JSONObject r5 = r14.f4576n     // Catch:{ JSONException -> 0x0183 }
            org.json.JSONObject r3 = r5.getJSONObject(r3)     // Catch:{ JSONException -> 0x0183 }
            boolean r5 = r3.isNull(r2)     // Catch:{ JSONException -> 0x0152 }
            java.lang.String r6 = ""
            if (r5 != 0) goto L_0x0129
            java.lang.String r2 = r3.getString(r2)     // Catch:{ JSONException -> 0x0152 }
            r5 = 1
            goto L_0x012b
        L_0x0129:
            r2 = r6
            r5 = 0
        L_0x012b:
            java.lang.String r7 = "action"
            boolean r7 = r3.isNull(r7)     // Catch:{ JSONException -> 0x0152 }
            if (r7 != 0) goto L_0x013a
            java.lang.String r5 = "action"
            java.lang.String r6 = r3.getString(r5)     // Catch:{ JSONException -> 0x0152 }
            r5 = 1
        L_0x013a:
            r4.mo27939a(r2)     // Catch:{ JSONException -> 0x0152 }
            java.lang.String r2 = "fallbackUrl"
            java.lang.String r2 = r3.optString(r2)     // Catch:{ JSONException -> 0x0152 }
            r4.mo27942b(r2)     // Catch:{ JSONException -> 0x0152 }
            r4.f4530j = r6     // Catch:{ JSONException -> 0x0152 }
            r4.f4528h = r5     // Catch:{ JSONException -> 0x0152 }
            java.lang.String r2 = "appBundleId"
            java.lang.String r2 = r3.optString(r2)     // Catch:{ JSONException -> 0x0152 }
            r4.f4543w = r2     // Catch:{ JSONException -> 0x0152 }
        L_0x0152:
            boolean r2 = r3.isNull(r1)     // Catch:{ JSONException -> 0x0183 }
            if (r2 != 0) goto L_0x016b
            java.lang.String r1 = r3.getString(r1)     // Catch:{ JSONException -> 0x0183 }
            int r1 = m4507d(r1)     // Catch:{ JSONException -> 0x0183 }
            r4.f4529i = r1     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r1 = "fallbackUrl"
            java.lang.String r1 = r3.optString(r1)     // Catch:{ JSONException -> 0x0183 }
            r4.mo27942b(r1)     // Catch:{ JSONException -> 0x0183 }
        L_0x016b:
            org.json.JSONObject r1 = r14.f4576n     // Catch:{ JSONException -> 0x0183 }
            java.lang.String r2 = "trackers"
            boolean r1 = r1.isNull(r2)     // Catch:{ JSONException -> 0x0183 }
            if (r1 != 0) goto L_0x017e
            org.json.JSONObject r1 = r14.f4576n     // Catch:{ JSONException -> 0x0183 }
            java.util.List r1 = m4504b(r1)     // Catch:{ JSONException -> 0x0183 }
            r4.mo27941a(r1)     // Catch:{ JSONException -> 0x0183 }
        L_0x017e:
            com.inmobi.media.bg$a r1 = r14.f4572i     // Catch:{ JSONException -> 0x0183 }
            r1.f4586c = r4     // Catch:{ JSONException -> 0x0183 }
            goto L_0x0190
        L_0x0183:
            r1 = move-exception
            com.inmobi.media.fd r2 = com.inmobi.media.C2463fd.m5161a()     // Catch:{ JSONException -> 0x029f }
            com.inmobi.media.fz r3 = new com.inmobi.media.fz     // Catch:{ JSONException -> 0x029f }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x029f }
            r2.mo28382a(r3)     // Catch:{ JSONException -> 0x029f }
        L_0x0190:
            r14.f4566c = r11     // Catch:{ JSONException -> 0x029f }
            org.json.JSONObject r1 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            java.lang.String r2 = "rewards"
            boolean r1 = r1.has(r2)     // Catch:{ JSONException -> 0x029f }
            if (r1 == 0) goto L_0x01a3
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ JSONException -> 0x029f }
            r1.<init>()     // Catch:{ JSONException -> 0x029f }
            r14.f4570g = r1     // Catch:{ JSONException -> 0x029f }
        L_0x01a3:
            org.json.JSONObject r1 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            java.util.Map r1 = com.inmobi.media.C2153ac.m4242b(r1)     // Catch:{ JSONException -> 0x029f }
            if (r1 == 0) goto L_0x01b0
            java.util.Map<java.lang.String, java.lang.String> r2 = r14.f4570g     // Catch:{ JSONException -> 0x029f }
            r2.putAll(r1)     // Catch:{ JSONException -> 0x029f }
        L_0x01b0:
            r14.m4516g()     // Catch:{ JSONException -> 0x029f }
            r14.m4519h()     // Catch:{ JSONException -> 0x029f }
            java.util.Map<java.lang.String, java.lang.String> r1 = r14.f4580r     // Catch:{ JSONException -> 0x029f }
            java.util.Set r1 = r1.entrySet()     // Catch:{ JSONException -> 0x029f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ JSONException -> 0x029f }
        L_0x01c0:
            boolean r2 = r1.hasNext()     // Catch:{ JSONException -> 0x029f }
            if (r2 == 0) goto L_0x0286
            java.lang.Object r2 = r1.next()     // Catch:{ JSONException -> 0x029f }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ JSONException -> 0x029f }
            java.lang.Object r3 = r2.getValue()     // Catch:{ JSONException -> 0x029f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x029f }
            java.util.Map<java.lang.String, com.inmobi.media.bc> r4 = r14.f4579q     // Catch:{ JSONException -> 0x029f }
            java.lang.Object r2 = r2.getKey()     // Catch:{ JSONException -> 0x029f }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ JSONException -> 0x029f }
            com.inmobi.media.bc r2 = (com.inmobi.media.C2214bc) r2     // Catch:{ JSONException -> 0x029f }
            if (r2 == 0) goto L_0x01c0
            int r4 = r2.f4534n     // Catch:{ JSONException -> 0x029f }
            r5 = 4
            if (r5 != r4) goto L_0x01c0
            int r4 = r2.f4535o     // Catch:{ JSONException -> 0x029f }
            if (r4 != r8) goto L_0x01ed
            int r4 = r2.f4536p     // Catch:{ JSONException -> 0x029f }
            if (r4 == r8) goto L_0x01c0
        L_0x01ed:
            java.util.Map<java.lang.String, com.inmobi.media.bc> r4 = r14.f4579q     // Catch:{ JSONException -> 0x029f }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ JSONException -> 0x029f }
            com.inmobi.media.bc r3 = (com.inmobi.media.C2214bc) r3     // Catch:{ JSONException -> 0x029f }
            if (r3 == 0) goto L_0x01c0
            java.lang.String r4 = "VIDEO"
            java.lang.String r6 = r3.f4522b     // Catch:{ JSONException -> 0x029f }
            boolean r4 = r4.equals(r6)     // Catch:{ JSONException -> 0x029f }
            if (r4 == 0) goto L_0x01c0
            r4 = r3
            com.inmobi.media.bp r4 = (com.inmobi.media.C2235bp) r4     // Catch:{ JSONException -> 0x029f }
            com.inmobi.media.cr r4 = r4.mo27982b()     // Catch:{ JSONException -> 0x029f }
            com.inmobi.media.cq r4 = (com.inmobi.media.C2296cq) r4     // Catch:{ JSONException -> 0x029f }
            java.lang.String r4 = r4.f4842b     // Catch:{ JSONException -> 0x029f }
            java.lang.String r6 = ":"
            java.lang.String[] r4 = r4.split(r6)     // Catch:{ JSONException -> 0x029f }
            r6 = r4[r10]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0222 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0222 }
            int r6 = r6 * 60
            r4 = r4[r9]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0222 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0222 }
            int r4 = r4 + r6
            goto L_0x0230
        L_0x0222:
            r4 = move-exception
            com.inmobi.media.fd r6 = com.inmobi.media.C2463fd.m5161a()     // Catch:{ JSONException -> 0x029f }
            com.inmobi.media.fz r7 = new com.inmobi.media.fz     // Catch:{ JSONException -> 0x029f }
            r7.<init>(r4)     // Catch:{ JSONException -> 0x029f }
            r6.mo28382a(r7)     // Catch:{ JSONException -> 0x029f }
            r4 = 0
        L_0x0230:
            if (r4 != 0) goto L_0x0235
            r2.f4535o = r11     // Catch:{ JSONException -> 0x029f }
            goto L_0x027d
        L_0x0235:
            int r6 = r2.f4535o     // Catch:{ JSONException -> 0x029f }
            if (r6 == r8) goto L_0x0259
            if (r6 == 0) goto L_0x0259
            r7 = 50
            if (r6 == r7) goto L_0x0255
            r7 = 75
            if (r6 == r7) goto L_0x024f
            r7 = 100
            if (r6 == r7) goto L_0x024c
            int r6 = r4 / 4
            r2.f4535o = r6     // Catch:{ JSONException -> 0x029f }
            goto L_0x0259
        L_0x024c:
            r2.f4535o = r4     // Catch:{ JSONException -> 0x029f }
            goto L_0x0259
        L_0x024f:
            int r6 = r4 * 3
            int r6 = r6 / r5
            r2.f4535o = r6     // Catch:{ JSONException -> 0x029f }
            goto L_0x0259
        L_0x0255:
            int r6 = r4 / 2
            r2.f4535o = r6     // Catch:{ JSONException -> 0x029f }
        L_0x0259:
            int r6 = r2.f4536p     // Catch:{ JSONException -> 0x029f }
            if (r6 == r8) goto L_0x027d
            if (r6 == 0) goto L_0x027d
            r7 = 50
            if (r6 == r7) goto L_0x0279
            r7 = 75
            if (r6 == r7) goto L_0x0273
            r5 = 100
            if (r6 == r5) goto L_0x0270
            int r4 = r4 / 4
            r2.f4536p = r4     // Catch:{ JSONException -> 0x029f }
            goto L_0x027d
        L_0x0270:
            r2.f4536p = r4     // Catch:{ JSONException -> 0x029f }
            goto L_0x027d
        L_0x0273:
            int r4 = r4 * 3
            int r4 = r4 / r5
            r2.f4536p = r4     // Catch:{ JSONException -> 0x029f }
            goto L_0x027d
        L_0x0279:
            int r4 = r4 / 2
            r2.f4536p = r4     // Catch:{ JSONException -> 0x029f }
        L_0x027d:
            com.inmobi.media.bp r3 = (com.inmobi.media.C2235bp) r3     // Catch:{ JSONException -> 0x029f }
            java.util.List<com.inmobi.media.bc> r3 = r3.f4642z     // Catch:{ JSONException -> 0x029f }
            r3.add(r2)     // Catch:{ JSONException -> 0x029f }
            goto L_0x01c0
        L_0x0286:
            org.json.JSONObject r1 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            boolean r1 = r1.isNull(r0)     // Catch:{ JSONException -> 0x029f }
            if (r1 == 0) goto L_0x0296
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x029f }
            r0.<init>()     // Catch:{ JSONException -> 0x029f }
            r14.f4568e = r0     // Catch:{ JSONException -> 0x029f }
            return
        L_0x0296:
            org.json.JSONObject r1 = r14.f4576n     // Catch:{ JSONException -> 0x029f }
            org.json.JSONArray r0 = r1.getJSONArray(r0)     // Catch:{ JSONException -> 0x029f }
            r14.f4568e = r0     // Catch:{ JSONException -> 0x029f }
            return
        L_0x029f:
            r0 = move-exception
            com.inmobi.media.fd r1 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r2 = new com.inmobi.media.fz
            r2.<init>(r0)
            r1.mo28382a(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4521i():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m4487a(java.lang.String r5) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r5 = r5.trim()
            int r0 = r5.hashCode()
            r1 = -1412832500(0xffffffffabc9e30c, float:-1.4344927E-12)
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L_0x0032
            if (r0 == 0) goto L_0x0028
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x001e
            goto L_0x003c
        L_0x001e:
            java.lang.String r0 = "video"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003c
            r5 = 2
            goto L_0x003d
        L_0x0028:
            java.lang.String r0 = ""
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003c
            r5 = 1
            goto L_0x003d
        L_0x0032:
            java.lang.String r0 = "companion"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003c
            r5 = 3
            goto L_0x003d
        L_0x003c:
            r5 = -1
        L_0x003d:
            if (r5 == r4) goto L_0x0046
            if (r5 == r3) goto L_0x0046
            if (r5 == r2) goto L_0x0045
            r5 = 0
            return r5
        L_0x0045:
            return r3
        L_0x0046:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4487a(java.lang.String):int");
    }

    /* renamed from: d */
    public final boolean mo27963d() {
        if (this.f4567d == null) {
            return false;
        }
        if (m4511f() == null) {
            return m4523j();
        }
        if (mo27961c() <= 0) {
            return false;
        }
        return m4523j();
    }

    /* renamed from: j */
    private boolean m4523j() {
        List<C2214bc> c = mo27962c(ShareConstants.VIDEO_URL);
        if (c != null && c.size() > 0) {
            for (C2214bc bcVar : c) {
                bcVar.f4521a.length();
                C2235bp bpVar = (C2235bp) bcVar;
                if (bpVar.mo27982b() == null) {
                    return false;
                }
                List c2 = bpVar.mo27982b().mo28139c();
                if (!(c2 == null || c2.size() == 0)) {
                    String b = bpVar.mo27982b().mo28138b();
                    if (b != null) {
                        if (b.length() == 0) {
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("[ERRORCODE]", "403");
                    bpVar.mo27940a("error", (Map<String, String>) hashMap);
                }
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r42v0, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r15v0, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r21v0 */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object, com.inmobi.media.bc] */
    /* JADX WARNING: type inference failed for: r21v1 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r7v1, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.inmobi.media.be, com.inmobi.media.bc] */
    /* JADX WARNING: type inference failed for: r8v24, types: [com.inmobi.media.be] */
    /* JADX WARNING: type inference failed for: r13v15, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r8v25, types: [com.inmobi.media.be] */
    /* JADX WARNING: type inference failed for: r14v3, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r2v20, types: [com.inmobi.media.bk, com.inmobi.media.bc] */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r13v17 */
    /* JADX WARNING: type inference failed for: r1v20, types: [com.inmobi.media.bi, com.inmobi.media.bc] */
    /* JADX WARNING: type inference failed for: r7v7, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r8v28 */
    /* JADX WARNING: type inference failed for: r13v18, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r1v25, types: [com.inmobi.media.bm, com.inmobi.media.bc] */
    /* JADX WARNING: type inference failed for: r13v19 */
    /* JADX WARNING: type inference failed for: r13v20 */
    /* JADX WARNING: type inference failed for: r7v11, types: [com.inmobi.media.bg] */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r7v12, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r3v16, types: [com.inmobi.media.bc] */
    /* JADX WARNING: type inference failed for: r21v2 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r8v34, types: [com.inmobi.media.bh] */
    /* JADX WARNING: type inference failed for: r14v4, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r8v35, types: [com.inmobi.media.bj] */
    /* JADX WARNING: type inference failed for: r14v5, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r8v36, types: [com.inmobi.media.bh] */
    /* JADX WARNING: type inference failed for: r15v13, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r8v37, types: [com.inmobi.media.bj] */
    /* JADX WARNING: type inference failed for: r15v14, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r9v43, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r1v47, types: [com.inmobi.media.bq] */
    /* JADX WARNING: type inference failed for: r21v3 */
    /* JADX WARNING: type inference failed for: r1v49 */
    /* JADX WARNING: type inference failed for: r8v50, types: [com.inmobi.media.bp] */
    /* JADX WARNING: type inference failed for: r3v30, types: [com.inmobi.media.bp, com.inmobi.media.bc] */
    /* JADX WARNING: type inference failed for: r19v2, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r1v53 */
    /* JADX WARNING: type inference failed for: r1v54 */
    /* JADX WARNING: type inference failed for: r15v17, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r0v79, types: [com.inmobi.media.bc] */
    /* JADX WARNING: type inference failed for: r21v4 */
    /* JADX WARNING: type inference failed for: r8v74, types: [com.inmobi.media.bf] */
    /* JADX WARNING: type inference failed for: r14v16, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r0v81 */
    /* JADX WARNING: type inference failed for: r8v75, types: [com.inmobi.media.bf] */
    /* JADX WARNING: type inference failed for: r2v65 */
    /* JADX WARNING: type inference failed for: r15v18, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r15v19 */
    /* JADX WARNING: type inference failed for: r0v83 */
    /* JADX WARNING: type inference failed for: r15v20 */
    /* JADX WARNING: type inference failed for: r21v5 */
    /* JADX WARNING: type inference failed for: r21v6 */
    /* JADX WARNING: type inference failed for: r1v95 */
    /* JADX WARNING: type inference failed for: r1v96 */
    /* JADX WARNING: type inference failed for: r1v97 */
    /* JADX WARNING: type inference failed for: r7v16 */
    /* JADX WARNING: type inference failed for: r8v80 */
    /* JADX WARNING: type inference failed for: r1v98 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: type inference failed for: r8v81, types: [com.inmobi.media.bh] */
    /* JADX WARNING: type inference failed for: r8v82, types: [com.inmobi.media.bj] */
    /* JADX WARNING: type inference failed for: r8v83, types: [com.inmobi.media.bh] */
    /* JADX WARNING: type inference failed for: r8v84, types: [com.inmobi.media.bj] */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0197, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0198, code lost:
        r8 = r7;
        r16 = r12;
        r28 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x019f, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        r3 = r15.getJSONObject(r11).optString(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01a8, code lost:
        if (r18 == null) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01ae, code lost:
        if (r18.size() != 0) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01b3, code lost:
        r8 = r8;
        r5 = r25;
        r6 = r24;
        r11 = r1;
        r1 = r12;
        r28 = r13;
        r6 = r44;
        r14 = r2;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r8 = new com.inmobi.media.C2218bf
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ca, code lost:
        r15 = r2;
        r0 = r8;
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01ce, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01cf, code lost:
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01d2, code lost:
        r6 = r44;
        r4 = r12;
        r28 = r13;
        r5 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r8 = new com.inmobi.media.C2218bf
        r0 = r8;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01e8, code lost:
        r0.f4527g = r6;
        m4497a((com.inmobi.media.C2214bc) r0, (org.json.JSONObject) r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01ed, code lost:
        if (r3 == null) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01ef, code lost:
        r0.mo27942b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01f2, code lost:
        r21 = r0;
        r16 = r4;
        r39 = r5;
        r8 = r7;
        r40 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01fd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01fe, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0200, code lost:
        r39 = r5;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0205, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0206, code lost:
        r28 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0209, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x020a, code lost:
        r28 = r19;
        r27 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x020e, code lost:
        r8 = r7;
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0211, code lost:
        r40 = r24;
        r39 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0217, code lost:
        r28 = r19;
        r27 = r20;
        r8 = r7;
        r16 = r12;
        r1 = 0;
        r40 = r24;
        r39 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0226, code lost:
        r11 = r6;
        r1 = r12;
        r28 = r19;
        r27 = r20;
        r14 = r24;
        r12 = r25;
        r6 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        r7.f4578p.get(r13);
        r38 = r7.m4532s(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0245, code lost:
        r25 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x024b, code lost:
        r24 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        r29 = new com.inmobi.media.C2235bp.C2236a(r2.x, r2.y, r3.x, r3.y, r4.x, r4.y, r5.x, r5.y, r38);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0268, code lost:
        if (r7.f4571h != null) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
        r0 = r7.m4495a((org.json.JSONObject) r15, r0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x026f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0270, code lost:
        r16 = r1;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r0 = r7.f4571h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0276, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0279, code lost:
        r2 = "showMute";
        r3 = "soundOn";
        r4 = "showProgress";
        r5 = "loop";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0284, code lost:
        if (r7.f4582t != 0) goto L_0x0300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0286, code lost:
        if (r11 == null) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0296, code lost:
        if (((java.lang.Boolean) r11.f4542v.get("didRequestFullScreen")).booleanValue() != false) goto L_0x02aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x029a, code lost:
        if (r7.f4583u == false) goto L_0x029d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x029d, code lost:
        r0 = false;
        r2 = Integer.MAX_VALUE;
        r3 = 0;
        r4 = true;
        r5 = true;
        r16 = true;
        r17 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02aa, code lost:
        r0 = r15.optBoolean(r5, false);
        r4 = r15.optBoolean(r4, true);
        r3 = r15.optBoolean(r3, true);
        r2 = r15.optBoolean(r2, true);
        r5 = r15.optBoolean("autoPlay", true);
        r8 = ((com.inmobi.media.C2235bp) r11).f4638E;
        r17 = r2;
        r16 = r3;
        r2 = r15.optDouble("pauseAfter", 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02d4, code lost:
        r0 = r15.optBoolean(r5, true);
        r4 = r15.optBoolean(r4, false);
        r3 = r15.optBoolean(r3, false);
        r2 = r15.optBoolean(r2, false);
        r5 = r15.optBoolean("autoPlay", true);
        r8 = r15.optInt("completeAfter", Integer.MAX_VALUE);
        r17 = r2;
        r16 = r3;
        r2 = r15.optDouble("pauseAfter", 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
        r0 = r15.optBoolean(r5, false);
        r4 = r15.optBoolean(r4, true);
        r3 = r15.optBoolean(r3, true);
        r2 = r15.optBoolean(r2, true);
        r5 = r15.optBoolean("autoPlay", true);
        r8 = r15.optInt("completeAfter", Integer.MAX_VALUE);
        r17 = r2;
        r16 = r3;
        r2 = r15.optDouble("pauseAfter", 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x032a, code lost:
        r3 = (int) r2;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x032d, code lost:
        r9 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0338, code lost:
        if (r15.isNull("videoViewabilityConfig") != false) goto L_0x0361;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        r8 = r15.getJSONObject("videoViewabilityConfig");
        r19 = r8.keys();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0348, code lost:
        if (r19.hasNext() == false) goto L_0x0361;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x034a, code lost:
        r14 = (java.lang.String) r19.next();
        r20 = r11;
        r9.put(r14, r8.get(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x035b, code lost:
        r11 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0361, code lost:
        r20 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        r11 = r7.f4581s.f5180g.f5225m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x036b, code lost:
        r8 = r8;
        r7 = r9;
        r9 = r1;
        r23 = r1;
        r1 = r20;
        r39 = r25;
        r22 = r3;
        r3 = r8;
        r40 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
        r8 = new com.inmobi.media.C2235bp
        r3.f4640G = new java.util.HashMap(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0396, code lost:
        if (r2 > 0) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0398, code lost:
        r2 = Integer.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x039b, code lost:
        r3.f4638E = r2;
        r3.f4527g = r6;
        r3.f4545y = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03a1, code lost:
        if (r1 == null) goto L_0x03a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03a3, code lost:
        r1.f4545y = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03a5, code lost:
        if (r22 == 0) goto L_0x03ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03a7, code lost:
        r3.f4639F = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03ab, code lost:
        r8 = r41;
        r1 = r3;
        r16 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03b2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03b3, code lost:
        r40 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03b6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03b7, code lost:
        r40 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x03b9, code lost:
        r39 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03bd, code lost:
        r39 = r12;
        r40 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x03c1, code lost:
        r8 = r41;
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x03c7, code lost:
        r6 = r44;
        r23 = r12;
        r28 = r19;
        r27 = r20;
        r40 = r24;
        r39 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x03d4, code lost:
        if (r0 != null) goto L_0x03d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x03d6, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x03d7, code lost:
        r7 = com.inmobi.media.C2237bq.m4557c(m4518h((org.json.JSONObject) r42));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x03e5, code lost:
        if ("URL".equals(r7) == false) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x03eb, code lost:
        if (android.webkit.URLUtil.isValidUrl(r0) != false) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x03ed, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x03ee, code lost:
        r15 = r23;
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:?, code lost:
        r9 = r42;
        r1 = new com.inmobi.media.C2237bq
        r1.f4645z = r7;
        r1.f4527g = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0414, code lost:
        if (r9.optBoolean("preload", false) == false) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0416, code lost:
        r1.f4643A = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0419, code lost:
        r7 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:?, code lost:
        r7.f4574k = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x041d, code lost:
        r1 = r1;
        r16 = r15;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0423, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0424, code lost:
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0427, code lost:
        r21 = r1;
        r16 = r15;
        r8 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x042f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0430, code lost:
        r8 = r41;
        r16 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0436, code lost:
        r13 = r44;
        r6 = r15;
        r28 = r19;
        r27 = r20;
        r40 = r24;
        r39 = r25;
        r15 = r12;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        r0 = m4492a(r2, r3, r4, r5, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x044f, code lost:
        if (m4529p(r42) == false) goto L_0x0475;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0459, code lost:
        if (r7.getJSONObject(r11).isNull(r14) != false) goto L_0x0468;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x045b, code lost:
        r1 = m4507d(r7.getJSONObject(r11).getString(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0468, code lost:
        r1 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0469, code lost:
        r2 = r7.getJSONObject(r11).optString(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0472, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0475, code lost:
        r2 = null;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0478, code lost:
        if (r18 == null) goto L_0x04b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x047e, code lost:
        if (r18.size() != 0) goto L_0x0481;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0489, code lost:
        if (r26.equals(r43) == false) goto L_0x049f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0491, code lost:
        r8 = r8;
        r4 = r13;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        r8 = new com.inmobi.media.C2225bj
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x049f, code lost:
        r4 = r13;
        r5 = r15;
        r8 = new com.inmobi.media.C2223bh
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x04b3, code lost:
        r4 = r13;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x04bd, code lost:
        if (r26.equals(r43) == false) goto L_0x04cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x04bf, code lost:
        r8 = new com.inmobi.media.C2225bj
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x04cf, code lost:
        r8 = new com.inmobi.media.C2223bh
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x04de, code lost:
        r3.f4527g = r4;
        m4497a((com.inmobi.media.C2214bc) r3, (org.json.JSONObject) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x04e3, code lost:
        if (r2 == null) goto L_0x04ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x04e5, code lost:
        r3.mo27942b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x04e8, code lost:
        r8 = r41;
        r1 = r3;
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x04ef, code lost:
        r8 = r41;
        r21 = r3;
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x04f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x04f8, code lost:
        r8 = r41;
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x04fe, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x04ff, code lost:
        r6 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0501, code lost:
        r8 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0503, code lost:
        r16 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0507, code lost:
        r9 = r12;
        r7 = r15;
        r28 = r19;
        r27 = r20;
        r40 = r24;
        r39 = r25;
        r12 = 0;
        r15 = r44;
        r11 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x051a, code lost:
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:?, code lost:
        r0 = m4492a(r2, r3, r4, r5, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0524, code lost:
        if (r7.has("startOffset") == false) goto L_0x0534;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0526, code lost:
        r1 = r7.getJSONObject("startOffset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x052c, code lost:
        r13 = r7;
        r7 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x052f, code lost:
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:?, code lost:
        r1 = r7.m4530q(r1);
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0534, code lost:
        r13 = r7;
        r7 = r41;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x053f, code lost:
        if (r13.has("timerDuration") == false) goto L_0x054c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0541, code lost:
        r2 = r7.m4530q(r13.getJSONObject("timerDuration"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x054c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x054e, code lost:
        r3 = r13.optBoolean("displayTimer", true);
        r1 = new com.inmobi.media.C2230bm
        r1.f4610z = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0567, code lost:
        if (r13.has("assetOnFinish") == false) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0569, code lost:
        r0 = (org.json.JSONObject) r13.get("assetOnFinish");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0577, code lost:
        if (r0.has(com.facebook.internal.NativeProtocol.WEB_DIALOG_ACTION) == false) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0579, code lost:
        r0 = r0.getString(com.facebook.internal.NativeProtocol.WEB_DIALOG_ACTION).toUpperCase(java.util.Locale.US).trim();
        r2 = r0.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0590, code lost:
        if (r2 == 2142494) goto L_0x05a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x0595, code lost:
        if (r2 == 2402104) goto L_0x0598;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x059e, code lost:
        if (r0.equals("NONE") == false) goto L_0x05ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x05a0, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x05a8, code lost:
        if (r0.equals("EXIT") == false) goto L_0x05ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x05aa, code lost:
        r0 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x05ac, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x05ae, code lost:
        if (r0 == 2) goto L_0x05b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x05b1, code lost:
        r12 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x05b2, code lost:
        r1.f4531k = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x05b4, code lost:
        r1.f4527g = r15;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x05b7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x05b8, code lost:
        r8 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x05bb, code lost:
        r11 = r43;
        r9 = r12;
        r13 = r15;
        r28 = r19;
        r27 = r20;
        r40 = r24;
        r39 = r25;
        r15 = r44;
        r1 = new com.inmobi.media.C2224bi
        r1.f4527g = r15;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x05dc, code lost:
        r11 = r43;
        r15 = r44;
        r9 = r12;
        r28 = r19;
        r27 = r20;
        r40 = r24;
        r39 = r25;
        r2 = new com.inmobi.media.C2226bk
        r2.f4527g = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x05f7, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x05f8, code lost:
        r8 = r7;
        r16 = r9;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x05fd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x05fe, code lost:
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x05ff, code lost:
        r16 = r9;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0603, code lost:
        r16 = r12;
        r7 = r15;
        r28 = r19;
        r27 = r20;
        r40 = r24;
        r39 = r25;
        r0 = r26;
        r15 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:?, code lost:
        r1 = m4492a(r2, r3, r4, r5, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0621, code lost:
        if (m4529p(r42) == false) goto L_0x0644;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x062b, code lost:
        if (r7.getJSONObject(r11).isNull(r14) != false) goto L_0x063a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x062d, code lost:
        r2 = m4507d(r7.getJSONObject(r11).getString(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x063a, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x063b, code lost:
        r3 = r7.getJSONObject(r11).optString(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0644, code lost:
        r3 = null;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x064d, code lost:
        if (r8.has("transitionEffect") == false) goto L_0x0683;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x064f, code lost:
        r4 = r8.getString("transitionEffect").trim();
        r5 = r4.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x0660, code lost:
        if (r5 == 3151468) goto L_0x0672;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x0665, code lost:
        if (r5 == 106426293) goto L_0x0668;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x066e, code lost:
        if (r4.equals("paged") == false) goto L_0x067c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x0670, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0678, code lost:
        if (r4.equals("free") == false) goto L_0x067c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x067a, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x067c, code lost:
        r4 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x067e, code lost:
        if (r4 == 2) goto L_0x0681;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x0681, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0684, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x0685, code lost:
        if (r18 == null) goto L_0x06a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x068b, code lost:
        if (r18.size() != 0) goto L_0x068e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x068e, code lost:
        r5 = r13;
        r2 = r15;
        r8 = new com.inmobi.media.C2216be
        r1 = r8;
        r15 = 0;
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x06a6, code lost:
        r5 = r13;
        r6 = r15;
        r15 = 0;
        r8 = new com.inmobi.media.C2216be
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x06bb, code lost:
        r1.f4527g = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x06bd, code lost:
        if (r3 == null) goto L_0x06c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x06bf, code lost:
        r1.mo27942b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x06c2, code lost:
        m4497a((com.inmobi.media.C2214bc) r1, (org.json.JSONObject) r7);
        r2 = r7.getJSONArray("assetValue");
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x06d0, code lost:
        if (r3 >= r2.length()) goto L_0x07ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06d2, code lost:
        r4 = new java.lang.StringBuilder();
        r4.append(r6);
        r4.append(".assetValue[");
        r4.append(r3);
        r4.append("]");
        r4 = r4.toString();
        r7 = r2.getJSONObject(r3);
        r8 = m4513f(r7).toLowerCase(java.util.Locale.US).trim();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x0701, code lost:
        switch(r8.hashCode()) {
            case -938102371: goto L_0x0763;
            case -410956671: goto L_0x0759;
            case 98832: goto L_0x074f;
            case 102340: goto L_0x0744;
            case 3226745: goto L_0x073a;
            case 3556653: goto L_0x0730;
            case 100313435: goto L_0x0726;
            case 110364485: goto L_0x071b;
            case 112202875: goto L_0x0711;
            case 1224424441: goto L_0x0706;
            default: goto L_0x0704;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x070c, code lost:
        if (r8.equals("webview") == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x070e, code lost:
        r9 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x0717, code lost:
        if (r8.equals("video") == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0719, code lost:
        r9 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x0721, code lost:
        if (r8.equals("timer") == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x0723, code lost:
        r9 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x072c, code lost:
        if (r8.equals(com.facebook.share.internal.MessengerShareContentUtility.MEDIA_IMAGE) == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x072e, code lost:
        r9 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0736, code lost:
        if (r8.equals(com.facebook.appevents.internal.ViewHierarchyConstants.TEXT_KEY) == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0738, code lost:
        r9 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0740, code lost:
        if (r8.equals(com.google.ads.mediation.inmobi.InMobiNetworkValues.ICON) == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0742, code lost:
        r9 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x074a, code lost:
        if (r8.equals("gif") == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x074c, code lost:
        r9 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0755, code lost:
        if (r8.equals(com.google.ads.mediation.inmobi.InMobiNetworkValues.CTA) == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x0757, code lost:
        r9 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x075f, code lost:
        if (r8.equals("container") == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0761, code lost:
        r9 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0769, code lost:
        if (r8.equals(com.google.ads.mediation.inmobi.InMobiNetworkValues.RATING) == false) goto L_0x076d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x076b, code lost:
        r9 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x076d, code lost:
        r9 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x076e, code lost:
        switch(r9) {
            case 2: goto L_0x0790;
            case 3: goto L_0x078c;
            case 4: goto L_0x0788;
            case 5: goto L_0x0785;
            case 6: goto L_0x0782;
            case 7: goto L_0x077f;
            case 8: goto L_0x077c;
            case 9: goto L_0x0779;
            case 10: goto L_0x0774;
            default: goto L_0x0771;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0771, code lost:
        r13 = "CONTAINER";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0774, code lost:
        r13 = "GIF";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0776, code lost:
        r8 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0779, code lost:
        r13 = "WEBVIEW";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x077c, code lost:
        r13 = "TIMER";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x077f, code lost:
        r13 = "RATING";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x0782, code lost:
        r13 = "CTA";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x0785, code lost:
        r13 = "TEXT";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x0788, code lost:
        r8 = r41;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x078c, code lost:
        r8 = r41;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0790, code lost:
        r13 = "ICON";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:?, code lost:
        r7 = r8.m4491a(r7, r13, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0797, code lost:
        if (r7 == null) goto L_0x07c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x0799, code lost:
        r7.f4527g = r4;
        r7.f4540t = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x07a1, code lost:
        if (r1.f4559C >= 16) goto L_0x07c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x07a8, code lost:
        if (r1.f4559C != r1.f4558B.length) goto L_0x07ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x07aa, code lost:
        r4 = new com.inmobi.media.C2214bc[(r1.f4558B.length * 2)];
        java.lang.System.arraycopy(r1.f4558B, r15, r4, r15, r1.f4559C);
        r1.f4558B = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x07ba, code lost:
        r4 = r1.f4558B;
        r9 = r1.f4559C;
        r1.f4559C = r9 + 1;
        r4[r9] = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x07c4, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x07c8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x07ca, code lost:
        r8 = r41;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x07cd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x07ce, code lost:
        r8 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x07ed, code lost:
        r1.f4534n = r40;
        r1.f4535o = r27;
        r1.f4536p = r39;
        r2 = r28;
        r1.f4537q = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x07fd, code lost:
        if (r2 == null) goto L_0x080d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0805, code lost:
        r3 = r16;
        r8.f4580r.put(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x080d, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x081d, code lost:
        r8.f4579q.put(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0822, code lost:
        r2 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x082a, code lost:
        if (r8.f4578p.containsKey(r2) != false) goto L_0x082c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x082c, code lost:
        ((java.util.List) r8.f4578p.get(r2)).add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:424:0x0838, code lost:
        r0 = new java.util.ArrayList();
        r0.add(r1);
        r8.f4578p.put(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0136, code lost:
        r25 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0156, code lost:
        r9 = "fallbackUrl";
        r14 = "openMode";
        r26 = r11;
        r11 = "assetOnclick";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x015e, code lost:
        switch(r1) {
            case 0: goto L_0x0603;
            case 1: goto L_0x05dc;
            case 2: goto L_0x05bb;
            case 3: goto L_0x0507;
            case 4: goto L_0x0436;
            case 5: goto L_0x0436;
            case 6: goto L_0x03c7;
            case 7: goto L_0x0226;
            case 8: goto L_0x0217;
            case 9: goto L_0x016e;
            default: goto L_0x0161;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0161, code lost:
        r8 = r7;
        r16 = r12;
        r28 = r19;
        r27 = r20;
        r40 = r24;
        r39 = r25;
        r21 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0172, code lost:
        if (m4529p(r42) != false) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0174, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0175, code lost:
        r13 = r19;
        r27 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r1 = m4505c(r2, r3, r4, r5, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0188, code lost:
        if (r15.getJSONObject(r11).isNull(r14) != false) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r2 = m4507d(r15.getJSONObject(r11).getString(r14));
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=org.json.JSONObject, code=null, for r42v0, types: [org.json.JSONObject] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v15
      assigns: []
      uses: []
      mth insns count: 945
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x07ed  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e5 A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f7 A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ff A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010b A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0117 A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0121 A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012c A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0139 A[Catch:{ JSONException -> 0x0145 }] */
    /* JADX WARNING: Unknown variable types count: 44 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.inmobi.media.C2214bc m4491a(@androidx.annotation.NonNull org.json.JSONObject r42, java.lang.String r43, java.lang.String r44) {
        /*
            r41 = this;
            r7 = r41
            r15 = r42
            r14 = r43
            r13 = r44
            java.lang.String r12 = m4508d(r42)
            java.lang.String r10 = m4510e(r42)
            org.json.JSONObject r8 = r41.m4520i(r42)
            boolean r0 = m4501a(r8, r14)
            r21 = 0
            if (r0 != 0) goto L_0x001d
            return r21
        L_0x001d:
            android.graphics.Point r2 = r41.m4522j(r42)
            android.graphics.Point r4 = r7.m4489a(r15, r2)
            android.graphics.Point r3 = r41.m4524k(r42)
            android.graphics.Point r5 = r7.m4502b(r15, r3)
            java.util.List r18 = m4504b(r42)
            int r11 = m4525l(r42)
            r9 = 1
            int r6 = m4488a(r15, r9)
            r1 = 0
            int r9 = m4488a(r15, r1)
            java.lang.String r1 = m4526m(r42)
            java.lang.String r0 = m4515g(r42)
            java.lang.String r0 = r0.trim()
            r19 = r1
            int r1 = r0.hashCode()
            r20 = r6
            r6 = -925155509(0xffffffffc8db3f4b, float:-449018.34)
            r22 = -1
            r13 = 2
            if (r1 == r6) goto L_0x006b
            r6 = 1728122231(0x67010d77, float:6.0943366E23)
            if (r1 == r6) goto L_0x0061
            goto L_0x0075
        L_0x0061:
            java.lang.String r1 = "absolute"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0075
            r0 = 1
            goto L_0x0076
        L_0x006b:
            java.lang.String r1 = "reference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0075
            r0 = 2
            goto L_0x0076
        L_0x0075:
            r0 = -1
        L_0x0076:
            if (r0 == r13) goto L_0x007a
            r0 = 0
            goto L_0x007b
        L_0x007a:
            r0 = 1
        L_0x007b:
            org.json.JSONArray r1 = m4528o(r42)
            if (r1 == 0) goto L_0x00c9
            int r6 = r1.length()
            if (r6 == 0) goto L_0x00c9
            r6 = 0
            java.lang.String r1 = r1.getString(r6)     // Catch:{ JSONException -> 0x00b4 }
            boolean r6 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00b0 }
            if (r6 == 0) goto L_0x0093
            return r21
        L_0x0093:
            r6 = 1
            if (r0 != r6) goto L_0x00ab
            com.inmobi.media.bc r6 = r7.mo27959b(r1)     // Catch:{ JSONException -> 0x00b0 }
            if (r6 != 0) goto L_0x00a9
            com.inmobi.media.bg r0 = r7.f4569f     // Catch:{ JSONException -> 0x00a7 }
            if (r0 == 0) goto L_0x00a9
            com.inmobi.media.bg r0 = r7.f4569f     // Catch:{ JSONException -> 0x00a7 }
            com.inmobi.media.bc r0 = r0.mo27959b(r1)     // Catch:{ JSONException -> 0x00a7 }
            goto L_0x00ad
        L_0x00a7:
            r0 = move-exception
            goto L_0x00b8
        L_0x00a9:
            r0 = r6
            goto L_0x00ad
        L_0x00ab:
            r0 = r21
        L_0x00ad:
            r6 = r0
            r0 = r1
            goto L_0x00cc
        L_0x00b0:
            r0 = move-exception
            r6 = r21
            goto L_0x00b8
        L_0x00b4:
            r0 = move-exception
            r1 = r21
            r6 = r1
        L_0x00b8:
            com.inmobi.media.fd r13 = com.inmobi.media.C2463fd.m5161a()
            r24 = r1
            com.inmobi.media.fz r1 = new com.inmobi.media.fz
            r1.<init>(r0)
            r13.mo28382a(r1)
            r0 = r24
            goto L_0x00cc
        L_0x00c9:
            r0 = r21
            r6 = r0
        L_0x00cc:
            int r1 = r43.hashCode()     // Catch:{ JSONException -> 0x07d1 }
            java.lang.String r13 = "VIDEO"
            r24 = r11
            java.lang.String r11 = "IMAGE"
            switch(r1) {
                case -1919329183: goto L_0x0139;
                case -1884772963: goto L_0x012c;
                case 67056: goto L_0x0121;
                case 70564: goto L_0x0117;
                case 2241657: goto L_0x010b;
                case 2571565: goto L_0x00ff;
                case 69775675: goto L_0x00f7;
                case 79826725: goto L_0x00ed;
                case 81665115: goto L_0x00e5;
                case 1942407129: goto L_0x00db;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            goto L_0x0153
        L_0x00db:
            java.lang.String r1 = "WEBVIEW"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r1 = 6
            goto L_0x0136
        L_0x00e5:
            boolean r1 = r14.equals(r13)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r1 = 7
            goto L_0x0136
        L_0x00ed:
            java.lang.String r1 = "TIMER"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r1 = 3
            goto L_0x0136
        L_0x00f7:
            boolean r1 = r14.equals(r11)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r1 = 4
            goto L_0x0136
        L_0x00ff:
            java.lang.String r1 = "TEXT"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r25 = r9
            r1 = 1
            goto L_0x0156
        L_0x010b:
            java.lang.String r1 = "ICON"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r25 = r9
            r1 = 2
            goto L_0x0156
        L_0x0117:
            java.lang.String r1 = "GIF"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r1 = 5
            goto L_0x0136
        L_0x0121:
            java.lang.String r1 = "CTA"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r1 = 9
            goto L_0x0136
        L_0x012c:
            java.lang.String r1 = "RATING"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r1 = 8
        L_0x0136:
            r25 = r9
            goto L_0x0156
        L_0x0139:
            java.lang.String r1 = "CONTAINER"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0145 }
            if (r1 == 0) goto L_0x0153
            r25 = r9
            r1 = 0
            goto L_0x0156
        L_0x0145:
            r0 = move-exception
            r8 = r7
            r39 = r9
            r16 = r12
            r28 = r19
            r27 = r20
        L_0x014f:
            r40 = r24
            goto L_0x07dd
        L_0x0153:
            r25 = r9
            r1 = -1
        L_0x0156:
            java.lang.String r9 = "fallbackUrl"
            java.lang.String r14 = "openMode"
            r26 = r11
            java.lang.String r11 = "assetOnclick"
            switch(r1) {
                case 0: goto L_0x0603;
                case 1: goto L_0x05dc;
                case 2: goto L_0x05bb;
                case 3: goto L_0x0507;
                case 4: goto L_0x0436;
                case 5: goto L_0x0436;
                case 6: goto L_0x03c7;
                case 7: goto L_0x0226;
                case 8: goto L_0x0217;
                case 9: goto L_0x016e;
                default: goto L_0x0161;
            }
        L_0x0161:
            r8 = r7
            r16 = r12
            r28 = r19
            r27 = r20
            r40 = r24
            r39 = r25
            goto L_0x07e9
        L_0x016e:
            boolean r1 = m4529p(r42)     // Catch:{ JSONException -> 0x0209 }
            if (r1 != 0) goto L_0x0175
            return r21
        L_0x0175:
            r13 = r19
            r1 = r41
            r27 = r20
            r6 = r8
            com.inmobi.media.bk$a r1 = r1.m4505c(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x0205 }
            org.json.JSONObject r2 = r15.getJSONObject(r11)     // Catch:{ JSONException -> 0x0205 }
            boolean r2 = r2.isNull(r14)     // Catch:{ JSONException -> 0x0205 }
            if (r2 != 0) goto L_0x019f
            org.json.JSONObject r2 = r15.getJSONObject(r11)     // Catch:{ JSONException -> 0x0197 }
            java.lang.String r2 = r2.getString(r14)     // Catch:{ JSONException -> 0x0197 }
            int r2 = m4507d(r2)     // Catch:{ JSONException -> 0x0197 }
            goto L_0x01a0
        L_0x0197:
            r0 = move-exception
            r8 = r7
            r16 = r12
            r28 = r13
            goto L_0x0211
        L_0x019f:
            r2 = 2
        L_0x01a0:
            org.json.JSONObject r3 = r15.getJSONObject(r11)     // Catch:{ JSONException -> 0x0205 }
            java.lang.String r3 = r3.optString(r9)     // Catch:{ JSONException -> 0x0205 }
            if (r18 == 0) goto L_0x01d2
            int r4 = r18.size()     // Catch:{ JSONException -> 0x0205 }
            if (r4 != 0) goto L_0x01b1
            goto L_0x01d2
        L_0x01b1:
            com.inmobi.media.bf r4 = new com.inmobi.media.bf     // Catch:{ JSONException -> 0x0205 }
            r8 = r4
            r5 = r25
            r9 = r12
            r6 = r24
            r11 = r1
            r1 = r12
            r12 = r0
            r14 = r44
            r28 = r13
            r13 = r18
            r6 = r14
            r14 = r2
            r2 = r15
            r15 = r42
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x01ce }
            r15 = r2
            r0 = r4
            r4 = r1
            goto L_0x01e8
        L_0x01ce:
            r0 = move-exception
            r16 = r1
            goto L_0x0200
        L_0x01d2:
            r6 = r44
            r4 = r12
            r28 = r13
            r5 = r25
            com.inmobi.media.bf r16 = new com.inmobi.media.bf     // Catch:{ JSONException -> 0x01fd }
            r8 = r16
            r9 = r4
            r11 = r1
            r12 = r0
            r13 = r2
            r14 = r42
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x01fd }
            r0 = r16
        L_0x01e8:
            r0.f4527g = r6     // Catch:{ JSONException -> 0x01fd }
            m4497a(r0, r15)     // Catch:{ JSONException -> 0x01fd }
            if (r3 == 0) goto L_0x01f2
            r0.mo27942b(r3)     // Catch:{ JSONException -> 0x01fd }
        L_0x01f2:
            r21 = r0
            r16 = r4
            r39 = r5
            r8 = r7
            r40 = r24
            goto L_0x07e9
        L_0x01fd:
            r0 = move-exception
            r16 = r4
        L_0x0200:
            r39 = r5
            r8 = r7
            goto L_0x014f
        L_0x0205:
            r0 = move-exception
            r28 = r13
            goto L_0x020e
        L_0x0209:
            r0 = move-exception
            r28 = r19
            r27 = r20
        L_0x020e:
            r8 = r7
            r16 = r12
        L_0x0211:
            r40 = r24
            r39 = r25
            goto L_0x07dd
        L_0x0217:
            r28 = r19
            r27 = r20
            r8 = r7
            r16 = r12
            r1 = r21
            r40 = r24
            r39 = r25
            goto L_0x07eb
        L_0x0226:
            r11 = r6
            r1 = r12
            r28 = r19
            r27 = r20
            r14 = r24
            r12 = r25
            r6 = r44
            java.util.Map<java.lang.String, java.util.List<com.inmobi.media.bc>> r9 = r7.f4578p     // Catch:{ JSONException -> 0x03bc }
            r9.get(r13)     // Catch:{ JSONException -> 0x03bc }
            com.inmobi.media.bl r38 = r7.m4532s(r8)     // Catch:{ JSONException -> 0x03bc }
            com.inmobi.media.bp$a r13 = new com.inmobi.media.bp$a     // Catch:{ JSONException -> 0x03bc }
            int r8 = r2.x     // Catch:{ JSONException -> 0x03bc }
            int r2 = r2.y     // Catch:{ JSONException -> 0x03bc }
            int r9 = r3.x     // Catch:{ JSONException -> 0x03bc }
            int r3 = r3.y     // Catch:{ JSONException -> 0x03bc }
            r25 = r12
            int r12 = r4.x     // Catch:{ JSONException -> 0x03b6 }
            int r4 = r4.y     // Catch:{ JSONException -> 0x03b6 }
            r24 = r14
            int r14 = r5.x     // Catch:{ JSONException -> 0x03b2 }
            int r5 = r5.y     // Catch:{ JSONException -> 0x03b2 }
            r29 = r13
            r30 = r8
            r31 = r2
            r32 = r9
            r33 = r3
            r34 = r12
            r35 = r4
            r36 = r14
            r37 = r5
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ JSONException -> 0x03b2 }
            com.inmobi.media.cq r2 = r7.f4571h     // Catch:{ JSONException -> 0x03b2 }
            if (r2 != 0) goto L_0x0274
            com.inmobi.media.cr r0 = r7.m4495a(r15, r0, r11)     // Catch:{ JSONException -> 0x026f }
            goto L_0x0276
        L_0x026f:
            r0 = move-exception
            r16 = r1
            r8 = r7
            goto L_0x0211
        L_0x0274:
            com.inmobi.media.cq r0 = r7.f4571h     // Catch:{ JSONException -> 0x03b2 }
        L_0x0276:
            r12 = r0
            int r0 = r7.f4582t     // Catch:{ JSONException -> 0x03b2 }
            java.lang.String r2 = "showMute"
            java.lang.String r3 = "soundOn"
            java.lang.String r4 = "showProgress"
            java.lang.String r5 = "loop"
            r14 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != 0) goto L_0x0300
            if (r11 == 0) goto L_0x02d4
            java.util.Map<java.lang.String, java.lang.Object> r0 = r11.f4542v     // Catch:{ JSONException -> 0x026f }
            java.lang.String r8 = "didRequestFullScreen"
            java.lang.Object r0 = r0.get(r8)     // Catch:{ JSONException -> 0x026f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x026f }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x026f }
            if (r0 != 0) goto L_0x02aa
            boolean r0 = r7.f4583u     // Catch:{ JSONException -> 0x026f }
            if (r0 == 0) goto L_0x029d
            goto L_0x02aa
        L_0x029d:
            r0 = 0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r4 = 1
            r5 = 1
            r16 = 1
            r17 = 1
            goto L_0x032d
        L_0x02aa:
            r8 = 0
            boolean r0 = r15.optBoolean(r5, r8)     // Catch:{ JSONException -> 0x026f }
            r5 = 1
            boolean r4 = r15.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x026f }
            boolean r3 = r15.optBoolean(r3, r5)     // Catch:{ JSONException -> 0x026f }
            boolean r2 = r15.optBoolean(r2, r5)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r8 = "autoPlay"
            boolean r5 = r15.optBoolean(r8, r5)     // Catch:{ JSONException -> 0x026f }
            r8 = r11
            com.inmobi.media.bp r8 = (com.inmobi.media.C2235bp) r8     // Catch:{ JSONException -> 0x026f }
            int r8 = r8.f4638E     // Catch:{ JSONException -> 0x026f }
            java.lang.String r9 = "pauseAfter"
            r17 = r2
            r16 = r3
            r2 = 0
            double r2 = r15.optDouble(r9, r2)     // Catch:{ JSONException -> 0x026f }
            goto L_0x032a
        L_0x02d4:
            r8 = 1
            boolean r0 = r15.optBoolean(r5, r8)     // Catch:{ JSONException -> 0x026f }
            r5 = 0
            boolean r4 = r15.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x026f }
            boolean r3 = r15.optBoolean(r3, r5)     // Catch:{ JSONException -> 0x026f }
            boolean r2 = r15.optBoolean(r2, r5)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r5 = "autoPlay"
            r8 = 1
            boolean r5 = r15.optBoolean(r5, r8)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r8 = "completeAfter"
            int r8 = r15.optInt(r8, r14)     // Catch:{ JSONException -> 0x026f }
            java.lang.String r9 = "pauseAfter"
            r17 = r2
            r16 = r3
            r2 = 0
            double r2 = r15.optDouble(r9, r2)     // Catch:{ JSONException -> 0x026f }
            goto L_0x032a
        L_0x0300:
            r9 = 0
            boolean r0 = r15.optBoolean(r5, r9)     // Catch:{ JSONException -> 0x03b2 }
            r5 = 1
            boolean r4 = r15.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x03b2 }
            boolean r3 = r15.optBoolean(r3, r5)     // Catch:{ JSONException -> 0x03b2 }
            boolean r2 = r15.optBoolean(r2, r5)     // Catch:{ JSONException -> 0x03b2 }
            java.lang.String r8 = "autoPlay"
            boolean r5 = r15.optBoolean(r8, r5)     // Catch:{ JSONException -> 0x03b2 }
            java.lang.String r8 = "completeAfter"
            int r8 = r15.optInt(r8, r14)     // Catch:{ JSONException -> 0x03b2 }
            java.lang.String r9 = "pauseAfter"
            r17 = r2
            r16 = r3
            r2 = 0
            double r2 = r15.optDouble(r9, r2)     // Catch:{ JSONException -> 0x03b2 }
        L_0x032a:
            int r2 = (int) r2     // Catch:{ JSONException -> 0x03b2 }
            r3 = r2
            r2 = r8
        L_0x032d:
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ JSONException -> 0x03b2 }
            r9.<init>()     // Catch:{ JSONException -> 0x03b2 }
            java.lang.String r8 = "videoViewabilityConfig"
            boolean r8 = r15.isNull(r8)     // Catch:{ JSONException -> 0x03b2 }
            if (r8 != 0) goto L_0x0361
            java.lang.String r8 = "videoViewabilityConfig"
            org.json.JSONObject r8 = r15.getJSONObject(r8)     // Catch:{ JSONException -> 0x026f }
            java.util.Iterator r19 = r8.keys()     // Catch:{ JSONException -> 0x026f }
        L_0x0344:
            boolean r20 = r19.hasNext()     // Catch:{ JSONException -> 0x026f }
            if (r20 == 0) goto L_0x0361
            java.lang.Object r20 = r19.next()     // Catch:{ JSONException -> 0x026f }
            r14 = r20
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ JSONException -> 0x026f }
            r20 = r11
            java.lang.Object r11 = r8.get(r14)     // Catch:{ JSONException -> 0x026f }
            r9.put(r14, r11)     // Catch:{ JSONException -> 0x026f }
            r11 = r20
            r14 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0344
        L_0x0361:
            r20 = r11
            com.inmobi.media.bp r14 = new com.inmobi.media.bp     // Catch:{ JSONException -> 0x03b2 }
            com.inmobi.media.eq r8 = r7.f4581s     // Catch:{ JSONException -> 0x03b2 }
            com.inmobi.media.eq$g r8 = r8.f5180g     // Catch:{ JSONException -> 0x03b2 }
            boolean r11 = r8.f5225m     // Catch:{ JSONException -> 0x03b2 }
            r8 = r14
            r7 = r9
            r9 = r1
            r23 = r1
            r1 = r20
            r20 = r11
            r11 = r13
            r13 = r25
            r39 = r13
            r13 = r16
            r22 = r3
            r3 = r14
            r40 = r24
            r24 = 2147483647(0x7fffffff, float:NaN)
            r14 = r17
            r15 = r0
            r16 = r4
            r17 = r5
            r19 = r42
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ JSONException -> 0x042f }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ JSONException -> 0x042f }
            r0.<init>(r7)     // Catch:{ JSONException -> 0x042f }
            r3.f4640G = r0     // Catch:{ JSONException -> 0x042f }
            if (r2 > 0) goto L_0x039b
            r2 = 2147483647(0x7fffffff, float:NaN)
        L_0x039b:
            r3.f4638E = r2     // Catch:{ JSONException -> 0x042f }
            r3.f4527g = r6     // Catch:{ JSONException -> 0x042f }
            r3.f4545y = r1     // Catch:{ JSONException -> 0x042f }
            if (r1 == 0) goto L_0x03a5
            r1.f4545y = r3     // Catch:{ JSONException -> 0x042f }
        L_0x03a5:
            if (r22 == 0) goto L_0x03ab
            r2 = r22
            r3.f4639F = r2     // Catch:{ JSONException -> 0x042f }
        L_0x03ab:
            r8 = r41
            r1 = r3
            r16 = r23
            goto L_0x07eb
        L_0x03b2:
            r0 = move-exception
            r40 = r24
            goto L_0x03b9
        L_0x03b6:
            r0 = move-exception
            r40 = r14
        L_0x03b9:
            r39 = r25
            goto L_0x03c1
        L_0x03bc:
            r0 = move-exception
            r39 = r12
            r40 = r14
        L_0x03c1:
            r8 = r41
            r16 = r1
            goto L_0x07dd
        L_0x03c7:
            r6 = r44
            r23 = r12
            r28 = r19
            r27 = r20
            r40 = r24
            r39 = r25
            r9 = 0
            if (r0 != 0) goto L_0x03d7
            return r21
        L_0x03d7:
            java.lang.String r1 = m4518h(r42)     // Catch:{ JSONException -> 0x042f }
            java.lang.String r7 = com.inmobi.media.C2237bq.m4557c(r1)     // Catch:{ JSONException -> 0x042f }
            java.lang.String r1 = "URL"
            boolean r1 = r1.equals(r7)     // Catch:{ JSONException -> 0x042f }
            if (r1 == 0) goto L_0x03ee
            boolean r1 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ JSONException -> 0x042f }
            if (r1 != 0) goto L_0x03ee
            return r21
        L_0x03ee:
            r15 = r23
            r12 = 0
            r1 = r41
            r13 = r6
            r6 = r8
            com.inmobi.media.bd r4 = r1.m4492a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x0472 }
            com.inmobi.media.bq r8 = new com.inmobi.media.bq     // Catch:{ JSONException -> 0x0472 }
            java.lang.String r1 = "isScrollable"
            r9 = r42
            boolean r6 = r9.optBoolean(r1)     // Catch:{ JSONException -> 0x0472 }
            r1 = r8
            r2 = r15
            r3 = r10
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x0472 }
            r8.f4645z = r7     // Catch:{ JSONException -> 0x0472 }
            r8.f4527g = r13     // Catch:{ JSONException -> 0x0472 }
            java.lang.String r0 = "preload"
            boolean r0 = r9.optBoolean(r0, r12)     // Catch:{ JSONException -> 0x0472 }
            if (r0 == 0) goto L_0x0427
            r1 = 1
            r8.f4643A = r1     // Catch:{ JSONException -> 0x0472 }
            r7 = r41
            r7.f4574k = r8     // Catch:{ JSONException -> 0x0423 }
            r1 = r8
            r16 = r15
            r8 = r7
            goto L_0x07eb
        L_0x0423:
            r0 = move-exception
            r8 = r7
            goto L_0x0503
        L_0x0427:
            r21 = r8
            r16 = r15
            r8 = r41
            goto L_0x07e9
        L_0x042f:
            r0 = move-exception
            r8 = r41
            r16 = r23
            goto L_0x07dd
        L_0x0436:
            r13 = r44
            r6 = r15
            r28 = r19
            r27 = r20
            r40 = r24
            r39 = r25
            r15 = r12
            r12 = 0
            r1 = r41
            r7 = r6
            r6 = r8
            com.inmobi.media.bd r0 = r1.m4492a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x04fe }
            boolean r1 = m4529p(r42)     // Catch:{ JSONException -> 0x04fe }
            if (r1 == 0) goto L_0x0475
            org.json.JSONObject r1 = r7.getJSONObject(r11)     // Catch:{ JSONException -> 0x0472 }
            boolean r1 = r1.isNull(r14)     // Catch:{ JSONException -> 0x0472 }
            if (r1 != 0) goto L_0x0468
            org.json.JSONObject r1 = r7.getJSONObject(r11)     // Catch:{ JSONException -> 0x0472 }
            java.lang.String r1 = r1.getString(r14)     // Catch:{ JSONException -> 0x0472 }
            int r1 = m4507d(r1)     // Catch:{ JSONException -> 0x0472 }
            goto L_0x0469
        L_0x0468:
            r1 = 2
        L_0x0469:
            org.json.JSONObject r2 = r7.getJSONObject(r11)     // Catch:{ JSONException -> 0x0472 }
            java.lang.String r2 = r2.optString(r9)     // Catch:{ JSONException -> 0x0472 }
            goto L_0x0478
        L_0x0472:
            r0 = move-exception
            goto L_0x0501
        L_0x0475:
            r2 = r21
            r1 = 0
        L_0x0478:
            if (r18 == 0) goto L_0x04b3
            int r3 = r18.size()     // Catch:{ JSONException -> 0x04fe }
            if (r3 != 0) goto L_0x0481
            goto L_0x04b3
        L_0x0481:
            r6 = r43
            r3 = r26
            boolean r3 = r3.equals(r6)     // Catch:{ JSONException -> 0x0472 }
            if (r3 == 0) goto L_0x049f
            com.inmobi.media.bj r3 = new com.inmobi.media.bj     // Catch:{ JSONException -> 0x0472 }
            java.lang.String r12 = m4506c(r42)     // Catch:{ JSONException -> 0x0472 }
            r8 = r3
            r9 = r15
            r11 = r0
            r4 = r13
            r13 = r18
            r14 = r1
            r5 = r15
            r15 = r42
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x04f7 }
            goto L_0x04de
        L_0x049f:
            r4 = r13
            r5 = r15
            com.inmobi.media.bh r3 = new com.inmobi.media.bh     // Catch:{ JSONException -> 0x04f7 }
            java.lang.String r12 = m4506c(r42)     // Catch:{ JSONException -> 0x04f7 }
            r8 = r3
            r9 = r5
            r11 = r0
            r13 = r18
            r14 = r1
            r15 = r42
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x04f7 }
            goto L_0x04de
        L_0x04b3:
            r6 = r43
            r4 = r13
            r5 = r15
            r3 = r26
            boolean r3 = r3.equals(r6)     // Catch:{ JSONException -> 0x04f7 }
            if (r3 == 0) goto L_0x04cf
            com.inmobi.media.bj r3 = new com.inmobi.media.bj     // Catch:{ JSONException -> 0x04f7 }
            java.lang.String r12 = m4506c(r42)     // Catch:{ JSONException -> 0x04f7 }
            r8 = r3
            r9 = r5
            r11 = r0
            r13 = r1
            r14 = r42
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x04f7 }
            goto L_0x04de
        L_0x04cf:
            com.inmobi.media.bh r3 = new com.inmobi.media.bh     // Catch:{ JSONException -> 0x04f7 }
            java.lang.String r12 = m4506c(r42)     // Catch:{ JSONException -> 0x04f7 }
            r8 = r3
            r9 = r5
            r11 = r0
            r13 = r1
            r14 = r42
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x04f7 }
        L_0x04de:
            r3.f4527g = r4     // Catch:{ JSONException -> 0x04f7 }
            m4497a(r3, r7)     // Catch:{ JSONException -> 0x04f7 }
            if (r2 == 0) goto L_0x04ef
            r3.mo27942b(r2)     // Catch:{ JSONException -> 0x04f7 }
            r8 = r41
            r1 = r3
            r16 = r5
            goto L_0x07eb
        L_0x04ef:
            r8 = r41
            r21 = r3
            r16 = r5
            goto L_0x07e9
        L_0x04f7:
            r0 = move-exception
            r8 = r41
            r16 = r5
            goto L_0x07dd
        L_0x04fe:
            r0 = move-exception
            r6 = r43
        L_0x0501:
            r8 = r41
        L_0x0503:
            r16 = r15
            goto L_0x07dd
        L_0x0507:
            r6 = r43
            r9 = r12
            r7 = r15
            r28 = r19
            r27 = r20
            r40 = r24
            r39 = r25
            r12 = 0
            r15 = r44
            r1 = r41
            r11 = r6
            r6 = r8
            com.inmobi.media.bd r0 = r1.m4492a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x05b7 }
            java.lang.String r1 = "startOffset"
            boolean r1 = r7.has(r1)     // Catch:{ JSONException -> 0x05b7 }
            if (r1 == 0) goto L_0x0534
            java.lang.String r1 = "startOffset"
            org.json.JSONObject r1 = r7.getJSONObject(r1)     // Catch:{ JSONException -> 0x05b7 }
            r13 = r7
            r7 = r41
            com.inmobi.media.bl$a r1 = r7.m4530q(r1)     // Catch:{ JSONException -> 0x05fd }
            goto L_0x0539
        L_0x0534:
            r13 = r7
            r7 = r41
            r1 = r21
        L_0x0539:
            java.lang.String r2 = "timerDuration"
            boolean r2 = r13.has(r2)     // Catch:{ JSONException -> 0x05fd }
            if (r2 == 0) goto L_0x054c
            java.lang.String r2 = "timerDuration"
            org.json.JSONObject r2 = r13.getJSONObject(r2)     // Catch:{ JSONException -> 0x05fd }
            com.inmobi.media.bl$a r2 = r7.m4530q(r2)     // Catch:{ JSONException -> 0x05fd }
            goto L_0x054e
        L_0x054c:
            r2 = r21
        L_0x054e:
            java.lang.String r3 = "displayTimer"
            r6 = 1
            boolean r3 = r13.optBoolean(r3, r6)     // Catch:{ JSONException -> 0x05fd }
            com.inmobi.media.bl r4 = new com.inmobi.media.bl     // Catch:{ JSONException -> 0x05fd }
            r4.<init>(r1, r2)     // Catch:{ JSONException -> 0x05fd }
            com.inmobi.media.bm r1 = new com.inmobi.media.bm     // Catch:{ JSONException -> 0x05fd }
            r1.<init>(r9, r10, r0, r4)     // Catch:{ JSONException -> 0x05fd }
            r1.f4610z = r3     // Catch:{ JSONException -> 0x05fd }
            java.lang.String r0 = "assetOnFinish"
            boolean r0 = r13.has(r0)     // Catch:{ JSONException -> 0x05fd }
            if (r0 == 0) goto L_0x05b4
            java.lang.String r0 = "assetOnFinish"
            java.lang.Object r0 = r13.get(r0)     // Catch:{ JSONException -> 0x05fd }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x05fd }
            java.lang.String r2 = "action"
            boolean r2 = r0.has(r2)     // Catch:{ JSONException -> 0x05fd }
            if (r2 == 0) goto L_0x05b4
            java.lang.String r2 = "action"
            java.lang.String r0 = r0.getString(r2)     // Catch:{ JSONException -> 0x05fd }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ JSONException -> 0x05fd }
            java.lang.String r0 = r0.toUpperCase(r2)     // Catch:{ JSONException -> 0x05fd }
            java.lang.String r0 = r0.trim()     // Catch:{ JSONException -> 0x05fd }
            int r2 = r0.hashCode()     // Catch:{ JSONException -> 0x05fd }
            r3 = 2142494(0x20b11e, float:3.002274E-39)
            if (r2 == r3) goto L_0x05a2
            r3 = 2402104(0x24a738, float:3.366065E-39)
            if (r2 == r3) goto L_0x0598
            goto L_0x05ac
        L_0x0598:
            java.lang.String r2 = "NONE"
            boolean r0 = r0.equals(r2)     // Catch:{ JSONException -> 0x05fd }
            if (r0 == 0) goto L_0x05ac
            r0 = 1
            goto L_0x05ad
        L_0x05a2:
            java.lang.String r2 = "EXIT"
            boolean r0 = r0.equals(r2)     // Catch:{ JSONException -> 0x05fd }
            if (r0 == 0) goto L_0x05ac
            r0 = 2
            goto L_0x05ad
        L_0x05ac:
            r0 = -1
        L_0x05ad:
            r2 = 2
            if (r0 == r2) goto L_0x05b1
            goto L_0x05b2
        L_0x05b1:
            r12 = 1
        L_0x05b2:
            r1.f4531k = r12     // Catch:{ JSONException -> 0x05fd }
        L_0x05b4:
            r1.f4527g = r15     // Catch:{ JSONException -> 0x05fd }
            goto L_0x05f8
        L_0x05b7:
            r0 = move-exception
            r8 = r41
            goto L_0x05ff
        L_0x05bb:
            r11 = r43
            r9 = r12
            r13 = r15
            r28 = r19
            r27 = r20
            r40 = r24
            r39 = r25
            r15 = r44
            r1 = r41
            r6 = r8
            com.inmobi.media.bd r0 = r1.m4492a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x05fd }
            com.inmobi.media.bi r1 = new com.inmobi.media.bi     // Catch:{ JSONException -> 0x05fd }
            java.lang.String r2 = m4506c(r42)     // Catch:{ JSONException -> 0x05fd }
            r1.<init>(r9, r10, r0, r2)     // Catch:{ JSONException -> 0x05fd }
            r1.f4527g = r15     // Catch:{ JSONException -> 0x05fd }
            goto L_0x05f8
        L_0x05dc:
            r11 = r43
            r15 = r44
            r9 = r12
            r28 = r19
            r27 = r20
            r40 = r24
            r39 = r25
            r1 = r41
            r6 = r8
            com.inmobi.media.bk$a r1 = r1.m4503b(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x05fd }
            com.inmobi.media.bk r2 = new com.inmobi.media.bk     // Catch:{ JSONException -> 0x05fd }
            r2.<init>(r9, r10, r1, r0)     // Catch:{ JSONException -> 0x05fd }
            r2.f4527g = r15     // Catch:{ JSONException -> 0x05fd }
            r1 = r2
        L_0x05f8:
            r8 = r7
            r16 = r9
            goto L_0x07eb
        L_0x05fd:
            r0 = move-exception
            r8 = r7
        L_0x05ff:
            r16 = r9
            goto L_0x07dd
        L_0x0603:
            r16 = r12
            r7 = r15
            r28 = r19
            r27 = r20
            r40 = r24
            r39 = r25
            r0 = r26
            r6 = 1
            r12 = 0
            r15 = r44
            r1 = r41
            r17 = 1
            r6 = r8
            com.inmobi.media.bd r1 = r1.m4492a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x07cd }
            boolean r2 = m4529p(r42)     // Catch:{ JSONException -> 0x07cd }
            if (r2 == 0) goto L_0x0644
            org.json.JSONObject r2 = r7.getJSONObject(r11)     // Catch:{ JSONException -> 0x07cd }
            boolean r2 = r2.isNull(r14)     // Catch:{ JSONException -> 0x07cd }
            if (r2 != 0) goto L_0x063a
            org.json.JSONObject r2 = r7.getJSONObject(r11)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r2 = r2.getString(r14)     // Catch:{ JSONException -> 0x07cd }
            int r2 = m4507d(r2)     // Catch:{ JSONException -> 0x07cd }
            goto L_0x063b
        L_0x063a:
            r2 = 2
        L_0x063b:
            org.json.JSONObject r3 = r7.getJSONObject(r11)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r3 = r3.optString(r9)     // Catch:{ JSONException -> 0x07cd }
            goto L_0x0647
        L_0x0644:
            r3 = r21
            r2 = 0
        L_0x0647:
            java.lang.String r4 = "transitionEffect"
            boolean r4 = r8.has(r4)     // Catch:{ JSONException -> 0x07cd }
            if (r4 == 0) goto L_0x0683
            java.lang.String r4 = "transitionEffect"
            java.lang.String r4 = r8.getString(r4)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r4 = r4.trim()     // Catch:{ JSONException -> 0x07cd }
            int r5 = r4.hashCode()     // Catch:{ JSONException -> 0x07cd }
            r6 = 3151468(0x30166c, float:4.416147E-39)
            if (r5 == r6) goto L_0x0672
            r6 = 106426293(0x657efb5, float:4.0613115E-35)
            if (r5 == r6) goto L_0x0668
            goto L_0x067c
        L_0x0668:
            java.lang.String r5 = "paged"
            boolean r4 = r4.equals(r5)     // Catch:{ JSONException -> 0x07cd }
            if (r4 == 0) goto L_0x067c
            r4 = 1
            goto L_0x067d
        L_0x0672:
            java.lang.String r5 = "free"
            boolean r4 = r4.equals(r5)     // Catch:{ JSONException -> 0x07cd }
            if (r4 == 0) goto L_0x067c
            r4 = 2
            goto L_0x067d
        L_0x067c:
            r4 = -1
        L_0x067d:
            r5 = 2
            if (r4 == r5) goto L_0x0681
            goto L_0x0684
        L_0x0681:
            r4 = 1
            goto L_0x0685
        L_0x0683:
            r5 = 2
        L_0x0684:
            r4 = 0
        L_0x0685:
            if (r18 == 0) goto L_0x06a6
            int r6 = r18.size()     // Catch:{ JSONException -> 0x07cd }
            if (r6 != 0) goto L_0x068e
            goto L_0x06a6
        L_0x068e:
            com.inmobi.media.be r6 = new com.inmobi.media.be     // Catch:{ JSONException -> 0x07cd }
            r8 = r6
            r9 = r16
            r11 = r1
            r1 = 0
            r12 = r18
            r5 = r13
            r18 = 2
            r13 = r2
            r14 = r42
            r2 = r15
            r15 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x07cd }
            r1 = r6
            r15 = 0
            r6 = r2
            goto L_0x06bb
        L_0x06a6:
            r5 = r13
            r6 = r15
            r15 = 0
            r18 = 2
            com.inmobi.media.be r19 = new com.inmobi.media.be     // Catch:{ JSONException -> 0x07cd }
            r8 = r19
            r9 = r16
            r11 = r1
            r12 = r2
            r13 = r42
            r14 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x07cd }
            r1 = r19
        L_0x06bb:
            r1.f4527g = r6     // Catch:{ JSONException -> 0x07cd }
            if (r3 == 0) goto L_0x06c2
            r1.mo27942b(r3)     // Catch:{ JSONException -> 0x07cd }
        L_0x06c2:
            m4497a(r1, r7)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r2 = "assetValue"
            org.json.JSONArray r2 = r7.getJSONArray(r2)     // Catch:{ JSONException -> 0x07cd }
            r3 = 0
        L_0x06cc:
            int r4 = r2.length()     // Catch:{ JSONException -> 0x07cd }
            if (r3 >= r4) goto L_0x07ca
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x07cd }
            r4.<init>()     // Catch:{ JSONException -> 0x07cd }
            r4.append(r6)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r7 = ".assetValue["
            r4.append(r7)     // Catch:{ JSONException -> 0x07cd }
            r4.append(r3)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r7 = "]"
            r4.append(r7)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x07cd }
            org.json.JSONObject r7 = r2.getJSONObject(r3)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r8 = m4513f(r7)     // Catch:{ JSONException -> 0x07cd }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r8 = r8.toLowerCase(r9)     // Catch:{ JSONException -> 0x07cd }
            java.lang.String r8 = r8.trim()     // Catch:{ JSONException -> 0x07cd }
            int r9 = r8.hashCode()     // Catch:{ JSONException -> 0x07cd }
            switch(r9) {
                case -938102371: goto L_0x0763;
                case -410956671: goto L_0x0759;
                case 98832: goto L_0x074f;
                case 102340: goto L_0x0744;
                case 3226745: goto L_0x073a;
                case 3556653: goto L_0x0730;
                case 100313435: goto L_0x0726;
                case 110364485: goto L_0x071b;
                case 112202875: goto L_0x0711;
                case 1224424441: goto L_0x0706;
                default: goto L_0x0704;
            }     // Catch:{ JSONException -> 0x07cd }
        L_0x0704:
            goto L_0x076d
        L_0x0706:
            java.lang.String r9 = "webview"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 9
            goto L_0x076e
        L_0x0711:
            java.lang.String r9 = "video"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 4
            goto L_0x076e
        L_0x071b:
            java.lang.String r9 = "timer"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 8
            goto L_0x076e
        L_0x0726:
            java.lang.String r9 = "image"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 3
            goto L_0x076e
        L_0x0730:
            java.lang.String r9 = "text"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 5
            goto L_0x076e
        L_0x073a:
            java.lang.String r9 = "icon"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 2
            goto L_0x076e
        L_0x0744:
            java.lang.String r9 = "gif"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 10
            goto L_0x076e
        L_0x074f:
            java.lang.String r9 = "cta"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 6
            goto L_0x076e
        L_0x0759:
            java.lang.String r9 = "container"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 1
            goto L_0x076e
        L_0x0763:
            java.lang.String r9 = "rating"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x07cd }
            if (r8 == 0) goto L_0x076d
            r9 = 7
            goto L_0x076e
        L_0x076d:
            r9 = -1
        L_0x076e:
            switch(r9) {
                case 2: goto L_0x0790;
                case 3: goto L_0x078c;
                case 4: goto L_0x0788;
                case 5: goto L_0x0785;
                case 6: goto L_0x0782;
                case 7: goto L_0x077f;
                case 8: goto L_0x077c;
                case 9: goto L_0x0779;
                case 10: goto L_0x0774;
                default: goto L_0x0771;
            }     // Catch:{ JSONException -> 0x07cd }
        L_0x0771:
            java.lang.String r13 = "CONTAINER"
            goto L_0x0776
        L_0x0774:
            java.lang.String r13 = "GIF"
        L_0x0776:
            r8 = r41
            goto L_0x0793
        L_0x0779:
            java.lang.String r13 = "WEBVIEW"
            goto L_0x0776
        L_0x077c:
            java.lang.String r13 = "TIMER"
            goto L_0x0776
        L_0x077f:
            java.lang.String r13 = "RATING"
            goto L_0x0776
        L_0x0782:
            java.lang.String r13 = "CTA"
            goto L_0x0776
        L_0x0785:
            java.lang.String r13 = "TEXT"
            goto L_0x0776
        L_0x0788:
            r8 = r41
            r13 = r5
            goto L_0x0793
        L_0x078c:
            r8 = r41
            r13 = r0
            goto L_0x0793
        L_0x0790:
            java.lang.String r13 = "ICON"
            goto L_0x0776
        L_0x0793:
            com.inmobi.media.bc r7 = r8.m4491a(r7, r13, r4)     // Catch:{ JSONException -> 0x07c8 }
            if (r7 == 0) goto L_0x07c4
            r7.f4527g = r4     // Catch:{ JSONException -> 0x07c8 }
            r7.f4540t = r1     // Catch:{ JSONException -> 0x07c8 }
            int r4 = r1.f4559C     // Catch:{ JSONException -> 0x07c8 }
            r9 = 16
            if (r4 >= r9) goto L_0x07c4
            int r4 = r1.f4559C     // Catch:{ JSONException -> 0x07c8 }
            com.inmobi.media.bc[] r9 = r1.f4558B     // Catch:{ JSONException -> 0x07c8 }
            int r9 = r9.length     // Catch:{ JSONException -> 0x07c8 }
            if (r4 != r9) goto L_0x07ba
            com.inmobi.media.bc[] r4 = r1.f4558B     // Catch:{ JSONException -> 0x07c8 }
            int r4 = r4.length     // Catch:{ JSONException -> 0x07c8 }
            int r4 = r4 * 2
            com.inmobi.media.bc[] r4 = new com.inmobi.media.C2214bc[r4]     // Catch:{ JSONException -> 0x07c8 }
            com.inmobi.media.bc[] r9 = r1.f4558B     // Catch:{ JSONException -> 0x07c8 }
            int r10 = r1.f4559C     // Catch:{ JSONException -> 0x07c8 }
            java.lang.System.arraycopy(r9, r15, r4, r15, r10)     // Catch:{ JSONException -> 0x07c8 }
            r1.f4558B = r4     // Catch:{ JSONException -> 0x07c8 }
        L_0x07ba:
            com.inmobi.media.bc[] r4 = r1.f4558B     // Catch:{ JSONException -> 0x07c8 }
            int r9 = r1.f4559C     // Catch:{ JSONException -> 0x07c8 }
            int r10 = r9 + 1
            r1.f4559C = r10     // Catch:{ JSONException -> 0x07c8 }
            r4[r9] = r7     // Catch:{ JSONException -> 0x07c8 }
        L_0x07c4:
            int r3 = r3 + 1
            goto L_0x06cc
        L_0x07c8:
            r0 = move-exception
            goto L_0x07dd
        L_0x07ca:
            r8 = r41
            goto L_0x07eb
        L_0x07cd:
            r0 = move-exception
            r8 = r41
            goto L_0x07dd
        L_0x07d1:
            r0 = move-exception
            r8 = r7
            r39 = r9
            r40 = r11
            r16 = r12
            r28 = r19
            r27 = r20
        L_0x07dd:
            com.inmobi.media.fd r1 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r2 = new com.inmobi.media.fz
            r2.<init>(r0)
            r1.mo28382a(r2)
        L_0x07e9:
            r1 = r21
        L_0x07eb:
            if (r1 == 0) goto L_0x0845
            r2 = r40
            r1.f4534n = r2
            r2 = r27
            r1.f4535o = r2
            r2 = r39
            r1.f4536p = r2
            r2 = r28
            r1.f4537q = r2
            if (r2 == 0) goto L_0x080d
            int r0 = r2.length()
            if (r0 == 0) goto L_0x080d
            java.util.Map<java.lang.String, java.lang.String> r0 = r8.f4580r
            r3 = r16
            r0.put(r3, r2)
            goto L_0x080f
        L_0x080d:
            r3 = r16
        L_0x080f:
            int r0 = r3.length()
            if (r0 == 0) goto L_0x0822
            java.util.Map<java.lang.String, com.inmobi.media.bc> r0 = r8.f4579q
            boolean r0 = r0.containsKey(r3)
            if (r0 != 0) goto L_0x0822
            java.util.Map<java.lang.String, com.inmobi.media.bc> r0 = r8.f4579q
            r0.put(r3, r1)
        L_0x0822:
            java.util.Map<java.lang.String, java.util.List<com.inmobi.media.bc>> r0 = r8.f4578p
            r2 = r43
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0838
            java.util.Map<java.lang.String, java.util.List<com.inmobi.media.bc>> r0 = r8.f4578p
            java.lang.Object r0 = r0.get(r2)
            java.util.List r0 = (java.util.List) r0
            r0.add(r1)
            goto L_0x0845
        L_0x0838:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r1)
            java.util.Map<java.lang.String, java.util.List<com.inmobi.media.bc>> r3 = r8.f4578p
            r3.put(r2, r0)
        L_0x0845:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4491a(org.json.JSONObject, java.lang.String, java.lang.String):com.inmobi.media.bc");
    }

    /* renamed from: a */
    private static void m4497a(@NonNull C2214bc bcVar, @NonNull JSONObject jSONObject) throws JSONException {
        String str;
        boolean z;
        boolean z2 = true;
        String str2 = "";
        if (m4529p(jSONObject)) {
            String str3 = "assetOnclick";
            String str4 = "itemUrl";
            if (!jSONObject.getJSONObject(str3).isNull(str4)) {
                str = jSONObject.getJSONObject(str3).getString(str4);
                z = true;
            } else {
                str = str2;
                z = false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
            String str5 = NativeProtocol.WEB_DIALOG_ACTION;
            if (!jSONObject2.isNull(str5)) {
                str2 = jSONObject.getJSONObject(str3).getString(str5);
            } else {
                z2 = z;
            }
        } else {
            str = str2;
            z2 = false;
        }
        bcVar.mo27939a(str);
        bcVar.f4530j = str2;
        bcVar.f4528h = z2;
    }

    @Nullable
    /* renamed from: b */
    public final C2214bc mo27959b(String str) {
        if (!(str == null || str.length() == 0)) {
            if (this.f4579q.get(str) != null) {
                return (C2214bc) this.f4579q.get(str);
            }
            C2220bg bgVar = this.f4569f;
            if (bgVar != null) {
                return (C2214bc) bgVar.f4579q.get(str);
            }
        }
        return null;
    }

    /* renamed from: e */
    public final List<String> mo27964e() {
        return new ArrayList(this.f4578p.keySet());
    }

    /* renamed from: c */
    public final List<C2214bc> mo27962c(String str) {
        if (this.f4578p.containsKey(str)) {
            return (List) this.f4578p.get(str);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    private static boolean m4501a(JSONObject jSONObject, String str) {
        String str2 = ViewHierarchyConstants.TEXT_KEY;
        String str3 = "geometry";
        if (jSONObject.isNull(str3)) {
            return false;
        }
        try {
            if (!m4500a(jSONObject.getJSONArray(str3))) {
                return false;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1919329183:
                    if (str.equals("CONTAINER")) {
                        c = 1;
                        break;
                    }
                    break;
                case 67056:
                    if (str.equals("CTA")) {
                        c = 9;
                        break;
                    }
                    break;
                case 70564:
                    if (str.equals("GIF")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2241657:
                    if (str.equals("ICON")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2571565:
                    if (str.equals("TEXT")) {
                        c = 8;
                        break;
                    }
                    break;
                case 69775675:
                    if (str.equals(ShareConstants.IMAGE_URL)) {
                        c = 3;
                        break;
                    }
                    break;
                case 79826725:
                    if (str.equals("TIMER")) {
                        c = 5;
                        break;
                    }
                    break;
                case 81665115:
                    if (str.equals(ShareConstants.VIDEO_URL)) {
                        c = 4;
                        break;
                    }
                    break;
                case 1942407129:
                    if (str.equals("WEBVIEW")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    return true;
                case 8:
                case 9:
                    if (jSONObject.isNull(str2)) {
                        return false;
                    }
                    try {
                        if (((int) Double.parseDouble(jSONObject.getJSONObject(str2).getString("size"))) > 0) {
                            return true;
                        }
                        return false;
                    } catch (NumberFormatException e) {
                        C2463fd.m5161a().mo28382a(new C2495fz(e));
                        return false;
                    }
                default:
                    return false;
            }
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return false;
        } catch (JSONException e2) {
            C2463fd.m5161a().mo28382a(new C2495fz(e2));
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m4500a(JSONArray jSONArray) {
        try {
            int i = jSONArray.getInt(2);
            int i2 = jSONArray.getInt(3);
            if (i <= 0 || i2 <= 0) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (android.webkit.URLUtil.isValidUrl(r1) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r1.startsWith(r5) == false) goto L_0x0043;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.inmobi.media.C2234bo m4494a(int r8, java.lang.String r9, org.json.JSONObject r10) throws org.json.JSONException {
        /*
            java.lang.String r0 = "params"
            java.lang.String r1 = "url"
            boolean r2 = r10.isNull(r1)
            if (r2 == 0) goto L_0x000d
            java.lang.String r1 = ""
            goto L_0x0015
        L_0x000d:
            java.lang.String r1 = r10.getString(r1)
            java.lang.String r1 = r1.trim()
        L_0x0015:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "VideoImpression"
            boolean r3 = r3.equals(r9)
            r4 = 0
            if (r3 == 0) goto L_0x0080
            java.lang.String r3 = "events"
            org.json.JSONArray r3 = r10.optJSONArray(r3)
            int r5 = r1.length()
            if (r5 == 0) goto L_0x0043
            java.lang.String r5 = "http"
            boolean r6 = r1.startsWith(r5)
            if (r6 == 0) goto L_0x003d
            boolean r6 = android.webkit.URLUtil.isValidUrl(r1)
            if (r6 == 0) goto L_0x0043
        L_0x003d:
            boolean r5 = r1.startsWith(r5)
            if (r5 != 0) goto L_0x0046
        L_0x0043:
            if (r3 != 0) goto L_0x0046
            return r4
        L_0x0046:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r3 == 0) goto L_0x007a
            r5 = 0
        L_0x004e:
            int r6 = r3.length()
            if (r5 >= r6) goto L_0x007a
            java.lang.String r6 = r3.getString(r5)
            java.lang.String r6 = com.inmobi.media.C2234bo.m4553a(r6)
            java.lang.String r7 = "creativeView"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L_0x0074
            java.lang.String r7 = "start"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L_0x0074
            java.lang.String r7 = "Impression"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x0077
        L_0x0074:
            r4.add(r6)
        L_0x0077:
            int r5 = r5 + 1
            goto L_0x004e
        L_0x007a:
            java.lang.String r3 = "referencedEvents"
            r2.put(r3, r4)
            goto L_0x008d
        L_0x0080:
            int r3 = r1.length()
            if (r3 == 0) goto L_0x00ce
            boolean r3 = android.webkit.URLUtil.isValidUrl(r1)
            if (r3 != 0) goto L_0x008d
            goto L_0x00ce
        L_0x008d:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            boolean r4 = r10.isNull(r0)     // Catch:{ JSONException -> 0x00b4 }
            if (r4 != 0) goto L_0x00c1
            org.json.JSONObject r10 = r10.getJSONObject(r0)     // Catch:{ JSONException -> 0x00b4 }
            java.util.Iterator r0 = r10.keys()     // Catch:{ JSONException -> 0x00b4 }
        L_0x00a0:
            boolean r4 = r0.hasNext()     // Catch:{ JSONException -> 0x00b4 }
            if (r4 == 0) goto L_0x00c1
            java.lang.Object r4 = r0.next()     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x00b4 }
            java.lang.String r5 = r10.getString(r4)     // Catch:{ JSONException -> 0x00b4 }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x00b4 }
            goto L_0x00a0
        L_0x00b4:
            r10 = move-exception
            com.inmobi.media.fd r0 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r4 = new com.inmobi.media.fz
            r4.<init>(r10)
            r0.mo28382a(r4)
        L_0x00c1:
            com.inmobi.media.bo r10 = new com.inmobi.media.bo
            r10.<init>(r1, r8, r9, r3)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>(r2)
            r10.f4633f = r8
            return r10
        L_0x00ce:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4494a(int, java.lang.String, org.json.JSONObject):com.inmobi.media.bo");
    }

    /* renamed from: a */
    private static List<C2234bo> m4496a(JSONObject jSONObject) {
        String str = "url";
        String str2 = "macros";
        LinkedList linkedList = new LinkedList();
        try {
            HashMap hashMap = new HashMap();
            if (!jSONObject.isNull(str2)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject2.getString(str3));
                }
            }
            JSONArray jSONArray = jSONObject.getJSONArray("adVerifications");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                if (!jSONObject3.isNull(str)) {
                    C2338dn dnVar = new C2338dn(jSONObject3.optString("vendor"), jSONObject3.optString("verificationParams"), jSONObject3.getString(str), "OMID_VIEWABILITY", hashMap);
                    linkedList.add(dnVar);
                }
            }
            if (linkedList.isEmpty()) {
                linkedList.add(new C2234bo("", 0, "OMID_VIEWABILITY", hashMap));
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
        return linkedList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0158, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0159, code lost:
        if (r5 == 1) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x015b, code lost:
        if (r5 == 2) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x015d, code lost:
        if (r5 == 3) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0160, code lost:
        if (r5 == 4) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0162, code lost:
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0164, code lost:
        r5 = "TRACKER_EVENT_TYPE_DOWNLOADER_ERROR";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0167, code lost:
        r5 = "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADED";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x016a, code lost:
        r5 = "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADING";
     */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0189 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b A[Catch:{ JSONException -> 0x018f }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.inmobi.media.C2234bo> m4504b(@androidx.annotation.NonNull org.json.JSONObject r17) {
        /*
            r0 = r17
            java.lang.String r1 = "uiEvent"
            java.lang.String r2 = "trackerType"
            java.lang.String r3 = "trackers"
            boolean r4 = r0.isNull(r3)
            if (r4 == 0) goto L_0x0010
            r0 = 0
            return r0
        L_0x0010:
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            org.json.JSONArray r0 = r0.getJSONArray(r3)     // Catch:{ JSONException -> 0x018f }
            int r3 = r0.length()     // Catch:{ JSONException -> 0x018f }
            if (r3 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r5 = 0
            r6 = 0
        L_0x0022:
            if (r6 >= r3) goto L_0x018e
            org.json.JSONObject r7 = r0.getJSONObject(r6)     // Catch:{ JSONException -> 0x018f }
            boolean r8 = r7.isNull(r2)     // Catch:{ JSONException -> 0x018f }
            if (r8 != 0) goto L_0x0189
            java.lang.String r8 = r7.getString(r2)     // Catch:{ JSONException -> 0x018f }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ JSONException -> 0x018f }
            java.lang.String r8 = r8.toUpperCase(r9)     // Catch:{ JSONException -> 0x018f }
            java.lang.String r8 = r8.trim()     // Catch:{ JSONException -> 0x018f }
            int r9 = r8.hashCode()     // Catch:{ JSONException -> 0x018f }
            r10 = -1430070305(0xffffffffaac2dbdf, float:-3.461389E-13)
            r12 = 3
            r13 = 2
            r14 = 1
            if (r9 == r10) goto L_0x0067
            r10 = -158113182(0xfffffffff6936262, float:-1.4946545E33)
            if (r9 == r10) goto L_0x005d
            r10 = 1110926088(0x42376308, float:45.84671)
            if (r9 == r10) goto L_0x0053
            goto L_0x0071
        L_0x0053:
            java.lang.String r9 = "URL_WEBVIEW_PING"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x018f }
            if (r8 == 0) goto L_0x0071
            r8 = 2
            goto L_0x0072
        L_0x005d:
            java.lang.String r9 = "URL_PING"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x018f }
            if (r8 == 0) goto L_0x0071
            r8 = 1
            goto L_0x0072
        L_0x0067:
            java.lang.String r9 = "HTML_SCRIPT"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x018f }
            if (r8 == 0) goto L_0x0071
            r8 = 3
            goto L_0x0072
        L_0x0071:
            r8 = -1
        L_0x0072:
            java.lang.String r9 = "url_ping"
            java.lang.String r10 = "unknown"
            if (r8 == r14) goto L_0x0084
            if (r8 == r13) goto L_0x0081
            if (r8 == r12) goto L_0x007e
            r8 = r10
            goto L_0x0085
        L_0x007e:
            java.lang.String r8 = "html_script"
            goto L_0x0085
        L_0x0081:
            java.lang.String r8 = "webview_ping"
            goto L_0x0085
        L_0x0084:
            r8 = r9
        L_0x0085:
            boolean r8 = r9.equals(r8)     // Catch:{ JSONException -> 0x018f }
            if (r8 == 0) goto L_0x0189
            java.lang.String r8 = "eventId"
            int r8 = r7.optInt(r8, r5)     // Catch:{ JSONException -> 0x018f }
            boolean r9 = r7.isNull(r1)     // Catch:{ JSONException -> 0x018f }
            if (r9 != 0) goto L_0x0189
            java.lang.String r9 = r7.getString(r1)     // Catch:{ JSONException -> 0x018f }
            java.util.Locale r15 = java.util.Locale.US     // Catch:{ JSONException -> 0x018f }
            java.lang.String r15 = r9.toUpperCase(r15)     // Catch:{ JSONException -> 0x018f }
            java.lang.String r15 = r15.trim()     // Catch:{ JSONException -> 0x018f }
            int r16 = r15.hashCode()     // Catch:{ JSONException -> 0x018f }
            java.lang.String r11 = "OMID_VIEWABILITY"
            switch(r16) {
                case -1881262698: goto L_0x00f4;
                case -825499301: goto L_0x00e9;
                case 2342118: goto L_0x00df;
                case 2634405: goto L_0x00d5;
                case 64212328: goto L_0x00cb;
                case 368426751: goto L_0x00c3;
                case 1963885793: goto L_0x00b9;
                case 2008409463: goto L_0x00af;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            goto L_0x00fe
        L_0x00af:
            java.lang.String r5 = "CLIENT_FILL"
            boolean r5 = r15.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x00fe
            r5 = 2
            goto L_0x00ff
        L_0x00b9:
            java.lang.String r5 = "VIDEO_VIEWABILITY"
            boolean r5 = r15.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x00fe
            r5 = 6
            goto L_0x00ff
        L_0x00c3:
            boolean r5 = r15.equals(r11)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x00fe
            r5 = 7
            goto L_0x00ff
        L_0x00cb:
            java.lang.String r5 = "CLICK"
            boolean r5 = r15.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x00fe
            r5 = 5
            goto L_0x00ff
        L_0x00d5:
            java.lang.String r5 = "VIEW"
            boolean r5 = r15.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x00fe
            r5 = 4
            goto L_0x00ff
        L_0x00df:
            java.lang.String r5 = "LOAD"
            boolean r5 = r15.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x00fe
            r5 = 1
            goto L_0x00ff
        L_0x00e9:
            java.lang.String r5 = "FALLBACK_URL_CLICK"
            boolean r5 = r15.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x00fe
            r5 = 8
            goto L_0x00ff
        L_0x00f4:
            java.lang.String r5 = "RENDER"
            boolean r5 = r15.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x00fe
            r5 = 3
            goto L_0x00ff
        L_0x00fe:
            r5 = -1
        L_0x00ff:
            java.lang.String r15 = "TRACKER_EVENT_TYPE_FALLBACK_URL"
            switch(r5) {
                case 1: goto L_0x011d;
                case 2: goto L_0x011a;
                case 3: goto L_0x0117;
                case 4: goto L_0x0114;
                case 5: goto L_0x0111;
                case 6: goto L_0x010d;
                case 7: goto L_0x010a;
                case 8: goto L_0x0107;
                default: goto L_0x0104;
            }
        L_0x0104:
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ JSONException -> 0x018f }
            goto L_0x0120
        L_0x0107:
            r5 = r15
            goto L_0x016c
        L_0x010a:
            r5 = r11
            goto L_0x016c
        L_0x010d:
            java.lang.String r5 = "VideoImpression"
            goto L_0x016c
        L_0x0111:
            java.lang.String r5 = "click"
            goto L_0x016c
        L_0x0114:
            java.lang.String r5 = "page_view"
            goto L_0x016c
        L_0x0117:
            java.lang.String r5 = "Impression"
            goto L_0x016c
        L_0x011a:
            java.lang.String r5 = "client_fill"
            goto L_0x016c
        L_0x011d:
            java.lang.String r5 = "load"
            goto L_0x016c
        L_0x0120:
            java.lang.String r5 = r9.toUpperCase(r5)     // Catch:{ JSONException -> 0x018f }
            java.lang.String r5 = r5.trim()     // Catch:{ JSONException -> 0x018f }
            int r9 = r5.hashCode()     // Catch:{ JSONException -> 0x018f }
            switch(r9) {
                case -1836567951: goto L_0x014e;
                case -1099027408: goto L_0x0144;
                case 1331888222: goto L_0x013a;
                case 1346121898: goto L_0x0130;
                default: goto L_0x012f;
            }     // Catch:{ JSONException -> 0x018f }
        L_0x012f:
            goto L_0x0158
        L_0x0130:
            java.lang.String r9 = "DOWNLOADER_INITIALIZED"
            boolean r5 = r5.equals(r9)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x0158
            r5 = 1
            goto L_0x0159
        L_0x013a:
            java.lang.String r9 = "DOWNLOADER_ERROR"
            boolean r5 = r5.equals(r9)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x0158
            r5 = 4
            goto L_0x0159
        L_0x0144:
            java.lang.String r9 = "DOWNLOADER_DOWNLOADING"
            boolean r5 = r5.equals(r9)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x0158
            r5 = 2
            goto L_0x0159
        L_0x014e:
            java.lang.String r9 = "DOWNLOADER_DOWNLOADED"
            boolean r5 = r5.equals(r9)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x0158
            r5 = 3
            goto L_0x0159
        L_0x0158:
            r5 = -1
        L_0x0159:
            if (r5 == r14) goto L_0x0107
            if (r5 == r13) goto L_0x016a
            if (r5 == r12) goto L_0x0167
            r9 = 4
            if (r5 == r9) goto L_0x0164
            r5 = r10
            goto L_0x016c
        L_0x0164:
            java.lang.String r5 = "TRACKER_EVENT_TYPE_DOWNLOADER_ERROR"
            goto L_0x016c
        L_0x0167:
            java.lang.String r5 = "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADED"
            goto L_0x016c
        L_0x016a:
            java.lang.String r5 = "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADING"
        L_0x016c:
            boolean r9 = r10.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r9 != 0) goto L_0x0189
            boolean r9 = r11.equals(r5)     // Catch:{ JSONException -> 0x018f }
            if (r9 != 0) goto L_0x0182
            com.inmobi.media.bo r5 = m4494a(r8, r5, r7)     // Catch:{ JSONException -> 0x018f }
            if (r5 == 0) goto L_0x0189
            r4.add(r5)     // Catch:{ JSONException -> 0x018f }
            goto L_0x0189
        L_0x0182:
            java.util.List r5 = m4496a(r7)     // Catch:{ JSONException -> 0x018f }
            r4.addAll(r5)     // Catch:{ JSONException -> 0x018f }
        L_0x0189:
            int r6 = r6 + 1
            r5 = 0
            goto L_0x0022
        L_0x018e:
            return r4
        L_0x018f:
            r0 = move-exception
            com.inmobi.media.fd r1 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r2 = new com.inmobi.media.fz
            r2.<init>(r0)
            r1.mo28382a(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4504b(org.json.JSONObject):java.util.List");
    }

    @Nullable
    /* renamed from: a */
    private C2297cr m4495a(@NonNull JSONObject jSONObject, @NonNull String str, C2214bc bcVar) {
        if (m4513f(jSONObject).equalsIgnoreCase(ShareConstants.VIDEO_URL)) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        if (bcVar instanceof C2235bp) {
                            return (C2297cr) bcVar.f4525e;
                        }
                        return new C2290cn(this.f4581s.f5183j).mo28131a(str);
                    }
                }
                return null;
            } catch (JSONException e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
        return null;
    }

    /* renamed from: c */
    private static String m4506c(@NonNull JSONObject jSONObject) {
        String str = "assetValue";
        try {
            if ((m4513f(jSONObject).equalsIgnoreCase("ICON") || m4513f(jSONObject).equalsIgnoreCase(ShareConstants.IMAGE_URL) || m4513f(jSONObject).equalsIgnoreCase("GIF")) && jSONObject.getJSONArray(str).getString(0).length() != 0) {
                return jSONObject.getJSONArray(str).getString(0);
            }
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
        return "";
    }

    /* renamed from: d */
    private static String m4508d(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getString("assetId");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return Integer.toString(jSONObject.hashCode());
        }
    }

    /* renamed from: e */
    private static String m4510e(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getString("assetName");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return "";
        }
    }

    /* renamed from: f */
    private static String m4513f(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getString("assetType");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return "";
        }
    }

    /* renamed from: g */
    private static String m4515g(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getString("valueType");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return "";
        }
    }

    /* renamed from: h */
    private static String m4518h(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getString("dataType");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return "";
        }
    }

    @NonNull
    /* renamed from: i */
    private JSONObject m4520i(@NonNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String str = "assetStyleRef";
        String str2 = "assetStyle";
        try {
            if (jSONObject.isNull(str2)) {
                jSONObject2 = null;
            } else {
                jSONObject2 = jSONObject.getJSONObject(str2);
            }
            if (jSONObject2 == null) {
                if (jSONObject.isNull(str)) {
                    return new JSONObject();
                }
                String string = jSONObject.getString(str);
                if (this.f4577o == null) {
                    jSONObject3 = new JSONObject();
                } else {
                    jSONObject3 = this.f4577o.getJSONObject(string);
                }
                jSONObject2 = jSONObject3;
            }
            return jSONObject2;
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return new JSONObject();
        }
    }

    /* renamed from: j */
    private Point m4522j(@NonNull JSONObject jSONObject) {
        String str = "geometry";
        Point point = new Point();
        try {
            JSONObject i = m4520i(jSONObject);
            if (i.isNull(str)) {
                return point;
            }
            JSONArray jSONArray = i.getJSONArray(str);
            point.x = C2528gq.m5392a(jSONArray.getInt(0));
            point.y = C2528gq.m5392a(jSONArray.getInt(1));
            return point;
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    /* renamed from: a */
    private Point m4489a(@NonNull JSONObject jSONObject, @NonNull Point point) {
        String str = "finalGeometry";
        try {
            JSONObject i = m4520i(jSONObject);
            if (i.isNull(str)) {
                return point;
            }
            Point point2 = new Point();
            JSONArray jSONArray = i.getJSONArray(str);
            point2.x = C2528gq.m5392a(jSONArray.getInt(0));
            point2.y = C2528gq.m5392a(jSONArray.getInt(1));
            point = point2;
            return point;
        } catch (JSONException unused) {
        }
    }

    /* renamed from: k */
    private Point m4524k(@NonNull JSONObject jSONObject) {
        String str = "geometry";
        Point point = new Point();
        try {
            JSONObject i = m4520i(jSONObject);
            if (i.isNull(str)) {
                return point;
            }
            JSONArray jSONArray = i.getJSONArray(str);
            point.x = C2528gq.m5392a(jSONArray.getInt(2));
            point.y = C2528gq.m5392a(jSONArray.getInt(3));
            return point;
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    /* renamed from: b */
    private Point m4502b(@NonNull JSONObject jSONObject, @NonNull Point point) {
        String str = "finalGeometry";
        try {
            JSONObject i = m4520i(jSONObject);
            if (i.isNull(str)) {
                return point;
            }
            Point point2 = new Point();
            JSONArray jSONArray = i.getJSONArray(str);
            point2.x = C2528gq.m5392a(jSONArray.getInt(2));
            point2.y = C2528gq.m5392a(jSONArray.getInt(3));
            point = point2;
            return point;
        } catch (JSONException unused) {
        }
    }

    /* renamed from: l */
    private static int m4525l(@NonNull JSONObject jSONObject) {
        String str = "type";
        try {
            JSONObject n = m4527n(jSONObject);
            if (n.isNull(str)) {
                return 2;
            }
            String lowerCase = n.getString(str).trim().toLowerCase(Locale.US);
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != -921832806) {
                if (hashCode != -284840886) {
                    if (hashCode == 1728122231) {
                        if (lowerCase.equals(Constants.PATH_TYPE_ABSOLUTE)) {
                            c = 2;
                        }
                    }
                } else if (lowerCase.equals("unknown")) {
                    c = 1;
                }
            } else if (lowerCase.equals("percentage")) {
                c = 3;
            }
            if (c != 2) {
                return c != 3 ? 1 : 4;
            }
            return 3;
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return 2;
        }
    }

    /* renamed from: a */
    private static int m4488a(@NonNull JSONObject jSONObject, boolean z) {
        try {
            JSONObject n = m4527n(jSONObject);
            String str = "delay";
            String str2 = "hideAfterDelay";
            if (n.isNull(z ? str : str2)) {
                return -1;
            }
            if (!z) {
                str = str2;
            }
            int i = n.getInt(str);
            if (3 == m4525l(jSONObject)) {
                return i;
            }
            if (4 == m4525l(jSONObject)) {
                if (i == 0) {
                    return i;
                }
                if (i > 0 && i <= 100) {
                    int[] iArr = {25, 50, 75, 100};
                    double d = Double.MAX_VALUE;
                    int i2 = -1;
                    for (int i3 = 0; i3 < 4; i3++) {
                        int i4 = i - iArr[i3];
                        double d2 = (double) (i4 * i4);
                        if (d2 < d) {
                            i2 = i3;
                            d = d2;
                        }
                    }
                    return iArr[i2];
                }
            }
            return -1;
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return -1;
        }
    }

    /* renamed from: m */
    private static String m4526m(@NonNull JSONObject jSONObject) {
        String str = "";
        String str2 = "reference";
        try {
            JSONObject n = m4527n(jSONObject);
            if (n.isNull(str2)) {
                return str;
            }
            return n.getString(str2);
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return str;
        }
    }

    /* renamed from: n */
    private static JSONObject m4527n(@NonNull JSONObject jSONObject) {
        String str = "display";
        if (jSONObject.isNull(str)) {
            return new JSONObject();
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return new JSONObject();
        }
    }

    /* renamed from: o */
    private static JSONArray m4528o(@NonNull JSONObject jSONObject) {
        try {
            return jSONObject.getJSONArray("assetValue");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return new JSONArray();
        }
    }

    /* renamed from: p */
    private static boolean m4529p(@NonNull JSONObject jSONObject) {
        return !jSONObject.isNull("assetOnclick");
    }

    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m4507d(@androidx.annotation.NonNull java.lang.String r5) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = r5.toUpperCase(r0)
            java.lang.String r5 = r5.trim()
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r0) {
                case -2084521848: goto L_0x0034;
                case -1038134325: goto L_0x002a;
                case 69805756: goto L_0x0020;
                case 1411860198: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x003e
        L_0x0016:
            java.lang.String r0 = "DEEPLINK"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 3
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "INAPP"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 2
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "EXTERNAL"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "DOWNLOAD"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 4
            goto L_0x003f
        L_0x003e:
            r5 = -1
        L_0x003f:
            if (r5 == r4) goto L_0x0048
            if (r5 == r3) goto L_0x0047
            if (r5 == r2) goto L_0x0046
            return r4
        L_0x0046:
            return r2
        L_0x0047:
            return r3
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4507d(java.lang.String):int");
    }

    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4509e(@androidx.annotation.NonNull java.lang.String r10) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r10 = r10.toLowerCase(r0)
            java.lang.String r10 = r10.trim()
            int r0 = r10.hashCode()
            java.lang.String r1 = "none"
            java.lang.String r2 = "bold"
            java.lang.String r3 = "strike"
            java.lang.String r4 = "underline"
            java.lang.String r5 = "italic"
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            switch(r0) {
                case -1178781136: goto L_0x0040;
                case -1026963764: goto L_0x0038;
                case -891985998: goto L_0x0030;
                case 3029637: goto L_0x0028;
                case 3387192: goto L_0x0020;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0048
        L_0x0020:
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0048
            r10 = 1
            goto L_0x0049
        L_0x0028:
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0048
            r10 = 2
            goto L_0x0049
        L_0x0030:
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L_0x0048
            r10 = 4
            goto L_0x0049
        L_0x0038:
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x0048
            r10 = 5
            goto L_0x0049
        L_0x0040:
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x0048
            r10 = 3
            goto L_0x0049
        L_0x0048:
            r10 = -1
        L_0x0049:
            if (r10 == r9) goto L_0x0055
            if (r10 == r8) goto L_0x0054
            if (r10 == r7) goto L_0x0053
            if (r10 == r6) goto L_0x0052
            return r1
        L_0x0052:
            return r4
        L_0x0053:
            return r3
        L_0x0054:
            return r5
        L_0x0055:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4509e(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[RETURN] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4512f(@androidx.annotation.NonNull java.lang.String r5) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r5 = r5.trim()
            int r0 = r5.hashCode()
            r1 = 3321844(0x32aff4, float:4.654895E-39)
            java.lang.String r2 = "none"
            java.lang.String r3 = "line"
            r4 = 2
            if (r0 == r1) goto L_0x0026
            r1 = 3387192(0x33af38, float:4.746467E-39)
            if (r0 == r1) goto L_0x001e
            goto L_0x002e
        L_0x001e:
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x002e
            r5 = 1
            goto L_0x002f
        L_0x0026:
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x002e
            r5 = 2
            goto L_0x002f
        L_0x002e:
            r5 = -1
        L_0x002f:
            if (r5 == r4) goto L_0x0032
            return r2
        L_0x0032:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4512f(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[RETURN] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4514g(@androidx.annotation.NonNull java.lang.String r5) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r5 = r5.trim()
            int r0 = r5.hashCode()
            r1 = -1349116587(0xffffffffaf961d55, float:-2.7305683E-10)
            java.lang.String r2 = "straight"
            java.lang.String r3 = "curved"
            r4 = 2
            if (r0 == r1) goto L_0x0026
            r1 = 1787472634(0x6a8aaafa, float:8.381959E25)
            if (r0 == r1) goto L_0x001e
            goto L_0x002e
        L_0x001e:
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x002e
            r5 = 1
            goto L_0x002f
        L_0x0026:
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x002e
            r5 = 2
            goto L_0x002f
        L_0x002e:
            r5 = -1
        L_0x002f:
            if (r5 == r4) goto L_0x0032
            return r2
        L_0x0032:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4514g(java.lang.String):java.lang.String");
    }

    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4517h(@androidx.annotation.NonNull java.lang.String r8) {
        /*
            java.lang.String r8 = r8.trim()
            int r0 = r8.hashCode()
            java.lang.String r1 = "aspectFill"
            java.lang.String r2 = "fill"
            java.lang.String r3 = "aspectFit"
            java.lang.String r4 = "unspecified"
            r5 = 4
            r6 = 3
            r7 = 2
            switch(r0) {
                case -1626174665: goto L_0x002f;
                case -1362001767: goto L_0x0027;
                case 3143043: goto L_0x001f;
                case 727618043: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0037
        L_0x0017:
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0037
            r8 = 3
            goto L_0x0038
        L_0x001f:
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0037
            r8 = 2
            goto L_0x0038
        L_0x0027:
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0037
            r8 = 4
            goto L_0x0038
        L_0x002f:
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0037
            r8 = 1
            goto L_0x0038
        L_0x0037:
            r8 = -1
        L_0x0038:
            if (r8 == r7) goto L_0x0041
            if (r8 == r6) goto L_0x0040
            if (r8 == r5) goto L_0x003f
            return r4
        L_0x003f:
            return r3
        L_0x0040:
            return r1
        L_0x0041:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4517h(java.lang.String):java.lang.String");
    }

    /* renamed from: q */
    private C2229a m4530q(JSONObject jSONObject) {
        C2229a aVar = new C2229a(jSONObject.optLong(Constants.PATH_TYPE_ABSOLUTE), jSONObject.optLong("percentage"), jSONObject.optString("reference"), this);
        return aVar;
    }

    /* renamed from: r */
    private C2229a m4531r(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C2229a aVar = new C2229a(jSONObject.optLong(Constants.PATH_TYPE_ABSOLUTE), jSONObject.optLong("percentage"), jSONObject.optString("reference"), this);
        return aVar;
    }

    /* renamed from: a */
    private C2215bd m4492a(@NonNull Point point, @NonNull Point point2, @NonNull Point point3, @NonNull Point point4, @NonNull JSONObject jSONObject) throws JSONException {
        String str;
        Point point5 = point;
        Point point6 = point2;
        Point point7 = point3;
        Point point8 = point4;
        JSONObject jSONObject2 = jSONObject;
        String str2 = "border";
        String str3 = "none";
        String str4 = "#ff000000";
        String str5 = "straight";
        if (!jSONObject2.isNull(str2)) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str2);
            String str6 = "style";
            if (!jSONObject3.isNull(str6)) {
                str3 = m4512f(jSONObject3.getString(str6));
                String str7 = "corner";
                if (!jSONObject3.isNull(str7)) {
                    str5 = m4514g(jSONObject3.getString(str7));
                }
                String str8 = "color";
                if (!jSONObject3.isNull(str8)) {
                    str4 = jSONObject3.getString(str8).trim();
                }
            }
        }
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = String.BACKGROUND_COLOR;
        if (jSONObject2.isNull(str12)) {
            str = "#00000000";
        } else {
            str = jSONObject2.getString(str12).trim();
        }
        String str13 = str;
        String str14 = "contentMode";
        C2215bd bdVar = new C2215bd(point5.x, point5.y, point6.x, point6.y, point7.x, point7.y, point8.x, point8.y, !jSONObject2.isNull(str14) ? m4517h(jSONObject2.getString(str14)) : "fill", str9, str11, str10, str13, m4532s(jSONObject2));
        return bdVar;
    }

    /* renamed from: s */
    private C2228bl m4532s(JSONObject jSONObject) throws JSONException {
        String str = "startOffset";
        C2229a aVar = null;
        C2229a r = !jSONObject.isNull(str) ? m4531r(jSONObject.optJSONObject(str)) : null;
        String str2 = "timerDuration";
        if (!jSONObject.isNull(str2)) {
            aVar = m4531r(jSONObject.optJSONObject(str2));
        }
        return new C2228bl(r, aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0138  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.inmobi.media.C2226bk.C2227a m4503b(@androidx.annotation.NonNull android.graphics.Point r32, @androidx.annotation.NonNull android.graphics.Point r33, @androidx.annotation.NonNull android.graphics.Point r34, @androidx.annotation.NonNull android.graphics.Point r35, @androidx.annotation.NonNull org.json.JSONObject r36) throws org.json.JSONException {
        /*
            r31 = this;
            r0 = r32
            r1 = r33
            r2 = r34
            r3 = r35
            r4 = r36
            java.lang.String r5 = "border"
            boolean r6 = r4.isNull(r5)
            java.lang.String r7 = "straight"
            java.lang.String r8 = "color"
            java.lang.String r9 = "#ff000000"
            java.lang.String r10 = "none"
            java.lang.String r11 = "style"
            if (r6 == 0) goto L_0x0023
        L_0x001c:
            r22 = r7
            r23 = r9
            r21 = r10
            goto L_0x0062
        L_0x0023:
            org.json.JSONObject r5 = r4.getJSONObject(r5)
            boolean r6 = r5.isNull(r11)
            if (r6 == 0) goto L_0x002e
            goto L_0x001c
        L_0x002e:
            java.lang.String r6 = r5.getString(r11)
            java.lang.String r6 = m4512f(r6)
            java.lang.String r12 = "corner"
            boolean r13 = r5.isNull(r12)
            if (r13 == 0) goto L_0x003f
            goto L_0x0047
        L_0x003f:
            java.lang.String r7 = r5.getString(r12)
            java.lang.String r7 = m4514g(r7)
        L_0x0047:
            boolean r12 = r5.isNull(r8)
            if (r12 == 0) goto L_0x0054
            r21 = r6
            r22 = r7
            r23 = r9
            goto L_0x0062
        L_0x0054:
            java.lang.String r5 = r5.getString(r8)
            java.lang.String r5 = r5.trim()
            r23 = r5
            r21 = r6
            r22 = r7
        L_0x0062:
            java.lang.String r5 = "backgroundColor"
            boolean r6 = r4.isNull(r5)
            if (r6 == 0) goto L_0x006d
            java.lang.String r5 = "#00000000"
            goto L_0x0075
        L_0x006d:
            java.lang.String r5 = r4.getString(r5)
            java.lang.String r5 = r5.trim()
        L_0x0075:
            r24 = r5
            java.lang.String r5 = "text"
            org.json.JSONObject r5 = r4.getJSONObject(r5)
            java.lang.String r6 = "size"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ NumberFormatException -> 0x0163 }
            double r6 = java.lang.Double.parseDouble(r6)     // Catch:{ NumberFormatException -> 0x0163 }
            int r6 = (int) r6
            java.lang.String r7 = "length"
            boolean r12 = r5.isNull(r7)
            if (r12 == 0) goto L_0x0097
            r7 = 2147483647(0x7fffffff, float:NaN)
            r27 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x00a1
        L_0x0097:
            java.lang.String r7 = r5.getString(r7)
            int r7 = java.lang.Integer.parseInt(r7)
            r27 = r7
        L_0x00a1:
            boolean r7 = r5.isNull(r8)
            if (r7 == 0) goto L_0x00a8
            goto L_0x00b0
        L_0x00a8:
            java.lang.String r7 = r5.getString(r8)
            java.lang.String r9 = r7.trim()
        L_0x00b0:
            r28 = r9
            boolean r7 = r5.isNull(r11)
            r8 = 0
            r9 = 1
            if (r7 == 0) goto L_0x00c1
            java.lang.String[] r7 = new java.lang.String[r9]
            r7[r8] = r10
        L_0x00be:
            r29 = r7
            goto L_0x00e8
        L_0x00c1:
            org.json.JSONArray r7 = r5.getJSONArray(r11)
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00d0
            java.lang.String[] r7 = new java.lang.String[r9]
            r7[r8] = r10
            goto L_0x00be
        L_0x00d0:
            java.lang.String[] r10 = new java.lang.String[r7]
            r12 = 0
        L_0x00d3:
            if (r12 >= r7) goto L_0x00e6
            org.json.JSONArray r13 = r5.getJSONArray(r11)
            java.lang.String r13 = r13.getString(r12)
            java.lang.String r13 = m4509e(r13)
            r10[r12] = r13
            int r12 = r12 + 1
            goto L_0x00d3
        L_0x00e6:
            r29 = r10
        L_0x00e8:
            java.lang.String r7 = "align"
            boolean r10 = r5.isNull(r7)
            if (r10 != 0) goto L_0x0138
            java.lang.String r5 = r5.getString(r7)
            java.lang.String r5 = r5.trim()
            r7 = -1
            int r10 = r5.hashCode()
            r11 = -1364013605(0xffffffffaeb2cddb, float:-8.13107E-11)
            r12 = 3
            r13 = 2
            if (r10 == r11) goto L_0x0123
            r11 = 3317767(0x32a007, float:4.649182E-39)
            if (r10 == r11) goto L_0x0119
            r11 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r10 == r11) goto L_0x010f
            goto L_0x012c
        L_0x010f:
            java.lang.String r10 = "right"
            boolean r5 = r5.equals(r10)
            if (r5 == 0) goto L_0x012c
            r7 = 2
            goto L_0x012c
        L_0x0119:
            java.lang.String r10 = "left"
            boolean r5 = r5.equals(r10)
            if (r5 == 0) goto L_0x012c
            r7 = 1
            goto L_0x012c
        L_0x0123:
            java.lang.String r10 = "centre"
            boolean r5 = r5.equals(r10)
            if (r5 == 0) goto L_0x012c
            r7 = 3
        L_0x012c:
            if (r7 == r13) goto L_0x0132
            if (r7 == r12) goto L_0x0133
            r13 = 0
            goto L_0x0133
        L_0x0132:
            r13 = 1
        L_0x0133:
            r5 = r31
            r26 = r13
            goto L_0x013c
        L_0x0138:
            r26 = 0
            r5 = r31
        L_0x013c:
            com.inmobi.media.bl r30 = r5.m4532s(r4)
            com.inmobi.media.bk$a r4 = new com.inmobi.media.bk$a
            r12 = r4
            int r13 = r0.x
            int r14 = r0.y
            int r15 = r1.x
            int r0 = r1.y
            r16 = r0
            int r0 = r2.x
            r17 = r0
            int r0 = r2.y
            r18 = r0
            int r0 = r3.x
            r19 = r0
            int r0 = r3.y
            r20 = r0
            r25 = r6
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return r4
        L_0x0163:
            r0 = move-exception
            r5 = r31
            org.json.JSONException r1 = new org.json.JSONException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2)
            com.inmobi.media.fd r2 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r3 = new com.inmobi.media.fz
            r3.<init>(r0)
            r2.mo28382a(r3)
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4503b(android.graphics.Point, android.graphics.Point, android.graphics.Point, android.graphics.Point, org.json.JSONObject):com.inmobi.media.bk$a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00aa  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.inmobi.media.C2226bk.C2227a m4505c(@androidx.annotation.NonNull android.graphics.Point r30, @androidx.annotation.NonNull android.graphics.Point r31, @androidx.annotation.NonNull android.graphics.Point r32, @androidx.annotation.NonNull android.graphics.Point r33, @androidx.annotation.NonNull org.json.JSONObject r34) throws org.json.JSONException {
        /*
            r29 = this;
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            java.lang.String r5 = "border"
            boolean r6 = r4.isNull(r5)
            java.lang.String r7 = "straight"
            java.lang.String r8 = "color"
            java.lang.String r9 = "#ff000000"
            java.lang.String r10 = "none"
            java.lang.String r11 = "style"
            if (r6 == 0) goto L_0x0023
        L_0x001c:
            r22 = r7
            r23 = r9
            r21 = r10
            goto L_0x0062
        L_0x0023:
            org.json.JSONObject r5 = r4.getJSONObject(r5)
            boolean r6 = r5.isNull(r11)
            if (r6 == 0) goto L_0x002e
            goto L_0x001c
        L_0x002e:
            java.lang.String r6 = r5.getString(r11)
            java.lang.String r6 = m4512f(r6)
            java.lang.String r12 = "corner"
            boolean r13 = r5.isNull(r12)
            if (r13 == 0) goto L_0x003f
            goto L_0x0047
        L_0x003f:
            java.lang.String r7 = r5.getString(r12)
            java.lang.String r7 = m4514g(r7)
        L_0x0047:
            boolean r12 = r5.isNull(r8)
            if (r12 == 0) goto L_0x0054
            r21 = r6
            r22 = r7
            r23 = r9
            goto L_0x0062
        L_0x0054:
            java.lang.String r5 = r5.getString(r8)
            java.lang.String r5 = r5.trim()
            r23 = r5
            r21 = r6
            r22 = r7
        L_0x0062:
            java.lang.String r5 = "backgroundColor"
            boolean r6 = r4.isNull(r5)
            if (r6 == 0) goto L_0x006d
            java.lang.String r5 = "#00000000"
            goto L_0x0075
        L_0x006d:
            java.lang.String r5 = r4.getString(r5)
            java.lang.String r5 = r5.trim()
        L_0x0075:
            r24 = r5
            java.lang.String r5 = "text"
            org.json.JSONObject r5 = r4.getJSONObject(r5)
            java.lang.String r6 = "size"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ NumberFormatException -> 0x00f9 }
            double r6 = java.lang.Double.parseDouble(r6)     // Catch:{ NumberFormatException -> 0x00f9 }
            int r6 = (int) r6
            boolean r7 = r5.isNull(r8)
            if (r7 == 0) goto L_0x008f
            goto L_0x0097
        L_0x008f:
            java.lang.String r7 = r5.getString(r8)
            java.lang.String r9 = r7.trim()
        L_0x0097:
            r26 = r9
            boolean r7 = r5.isNull(r11)
            r8 = 0
            r9 = 1
            if (r7 == 0) goto L_0x00aa
            java.lang.String[] r5 = new java.lang.String[r9]
            r5[r8] = r10
        L_0x00a5:
            r27 = r5
            r5 = r29
            goto L_0x00d2
        L_0x00aa:
            org.json.JSONArray r7 = r5.getJSONArray(r11)
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00b9
            java.lang.String[] r5 = new java.lang.String[r9]
            r5[r8] = r10
            goto L_0x00a5
        L_0x00b9:
            java.lang.String[] r9 = new java.lang.String[r7]
        L_0x00bb:
            if (r8 >= r7) goto L_0x00ce
            org.json.JSONArray r10 = r5.getJSONArray(r11)
            java.lang.String r10 = r10.getString(r8)
            java.lang.String r10 = m4509e(r10)
            r9[r8] = r10
            int r8 = r8 + 1
            goto L_0x00bb
        L_0x00ce:
            r5 = r29
            r27 = r9
        L_0x00d2:
            com.inmobi.media.bl r28 = r5.m4532s(r4)
            com.inmobi.media.bf$a r4 = new com.inmobi.media.bf$a
            r12 = r4
            int r13 = r0.x
            int r14 = r0.y
            int r15 = r1.x
            int r0 = r1.y
            r16 = r0
            int r0 = r2.x
            r17 = r0
            int r0 = r2.y
            r18 = r0
            int r0 = r3.x
            r19 = r0
            int r0 = r3.y
            r20 = r0
            r25 = r6
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return r4
        L_0x00f9:
            r0 = move-exception
            r5 = r29
            org.json.JSONException r1 = new org.json.JSONException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2)
            com.inmobi.media.fd r2 = com.inmobi.media.C2463fd.m5161a()
            com.inmobi.media.fz r3 = new com.inmobi.media.fz
            r3.<init>(r0)
            r2.mo28382a(r3)
            throw r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2220bg.m4505c(android.graphics.Point, android.graphics.Point, android.graphics.Point, android.graphics.Point, org.json.JSONObject):com.inmobi.media.bk$a");
    }

    /* renamed from: a */
    private static boolean m4499a(@NonNull C2216be beVar) {
        return "card_scrollable".equalsIgnoreCase(beVar.f4524d);
    }

    /* renamed from: a */
    private static void m4498a(C2235bp bpVar) {
        bpVar.f4544x = 8;
        HashMap hashMap = new HashMap();
        hashMap.put("[ERRORCODE]", "601");
        bpVar.mo27940a("error", (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private static C2214bc m4490a(@NonNull C2220bg bgVar, @NonNull C2214bc bcVar) {
        do {
            String str = (String) bcVar.f4525e;
            if (str == null || str.length() == 0) {
                return null;
            }
            String[] split = str.split("\\|");
            C2214bc b = bgVar.mo27959b(split[0]);
            if (b == null) {
                bgVar = bgVar.f4569f;
            } else if (b.equals(bcVar)) {
                return null;
            } else {
                if (1 == split.length) {
                    b.f4533m = 1;
                    return b;
                }
                b.f4533m = m4487a(split[1]);
                return b;
            }
        } while (bgVar != null);
        return null;
    }
}
