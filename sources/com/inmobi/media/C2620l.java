package com.inmobi.media;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.iab.omid.library.inmobi.adsession.VerificationScriptResource;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.media.C2163ak.C2168a;
import com.inmobi.media.C2344ds.C2345a;
import com.inmobi.media.C2438es.C2441c;
import com.inmobi.media.C2542h.C2551b;
import com.inmobi.media.C2542h.C2552c;
import com.inmobi.media.C2600j.C2618a;
import com.inmobi.unification.sdk.model.ASRequestParams;
import com.squareup.picasso.Picasso;
import com.tapjoy.TJAdUnitConstants.String;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.l */
/* compiled from: AdUnit */
public abstract class C2620l implements C2168a, C2207aw, C2279ch, C2295cp, C2441c, C2618a, C2649p {

    /* renamed from: a */
    static final String f5846a = "l";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f5847A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public C2600j f5848B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public String f5849C;

    /* renamed from: D */
    private boolean f5850D;
    @Nullable

    /* renamed from: E */
    private ASRequestParams f5851E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C2280ci f5852F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C2618a f5853G = new C2618a() {
        /* renamed from: a */
        public final void mo28525a() {
        }

        /* renamed from: a */
        public final void mo28527a(C2600j jVar, @NonNull HashMap<Object, Object> hashMap) {
        }

        /* renamed from: a */
        public final void mo28528a(String str, Map<String, Object> map) {
        }

        /* renamed from: b */
        public final void mo28529b() {
        }

        /* renamed from: b */
        public final void mo28531b(C2600j jVar, @NonNull HashMap<Object, Object> hashMap) {
        }

        /* renamed from: d */
        public final void mo28534d(C2600j jVar) {
        }

        /* renamed from: e */
        public final void mo28535e(C2600j jVar) {
        }

        /* renamed from: f */
        public final void mo28536f(C2600j jVar) {
        }

        /* renamed from: g */
        public final void mo28537g(C2600j jVar) {
        }

        /* renamed from: i */
        public final void mo28539i(C2600j jVar) {
        }

        /* renamed from: j */
        public final void mo28540j(C2600j jVar) {
        }

        /* renamed from: a */
        public final void mo28526a(C2600j jVar) {
            if (2 == C2620l.this.mo28770f()) {
                C2620l.this.mo28763c(2);
                C2620l.this.f5847A = true;
                C2620l.this.mo28732L();
            }
        }

        /* renamed from: b */
        public final void mo28530b(C2600j jVar) {
            C2620l.this.mo28763c(2);
            C2620l.this.mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
        }

        /* renamed from: c */
        public final void mo28533c(C2600j jVar) {
            if (2 == C2620l.this.mo28770f()) {
                C2620l.this.mo28734N();
            }
        }

        /* renamed from: h */
        public final void mo28538h(C2600j jVar) {
            if (2 == C2620l.this.mo28770f()) {
                C2620l.this.mo28763c(2);
                C2620l.this.mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
            }
        }

        /* renamed from: c */
        public final C2591hu mo28532c() {
            return C2620l.this.f5872t;
        }
    };

    /* renamed from: b */
    int f5854b;

    /* renamed from: c */
    C2426eq f5855c;

    /* renamed from: d */
    String f5856d;

    /* renamed from: e */
    long f5857e;

    /* renamed from: f */
    long f5858f = 0;

    /* renamed from: g */
    public C2542h f5859g;

    /* renamed from: h */
    ExecutorService f5860h;

    /* renamed from: i */
    int f5861i;

    /* renamed from: j */
    public Handler f5862j;

    /* renamed from: k */
    boolean f5863k;

    /* renamed from: l */
    boolean f5864l;

    /* renamed from: m */
    boolean f5865m = false;
    @Nullable

    /* renamed from: n */
    C2212ba f5866n;
    /* access modifiers changed from: 0000 */

    /* renamed from: o */
    public C2159ai f5867o;
    @Nullable

    /* renamed from: p */
    C2162aj f5868p;

    /* renamed from: q */
    boolean f5869q = false;

    /* renamed from: r */
    private WeakReference<Context> f5870r;

    /* renamed from: s */
    private String f5871s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C2591hu f5872t;

    /* renamed from: u */
    private JSONObject f5873u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f5874v;
    @Nullable

    /* renamed from: w */
    private C2163ak f5875w;

    /* renamed from: x */
    private WeakReference<C2636a> f5876x;
    @Nullable

    /* renamed from: y */
    private C2600j f5877y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public Set<C2298cs> f5878z;

    /* renamed from: com.inmobi.media.l$a */
    /* compiled from: AdUnit */
    public static abstract class C2636a {
        /* renamed from: a */
        public void mo28805a() {
        }

        /* renamed from: a */
        public void mo28806a(@NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
        }

        /* renamed from: a */
        public void mo28807a(@NonNull C2159ai aiVar, @NonNull C2162aj ajVar) {
        }

        /* renamed from: a */
        public void mo27778a(C2620l lVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
        }

        /* renamed from: a */
        public void mo27779a(@NonNull C2620l lVar, boolean z, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
        }

        /* renamed from: a */
        public void mo27780a(@NonNull Map<Object, Object> map) {
        }

        /* renamed from: a */
        public void mo28808a(boolean z) {
        }

        /* renamed from: a */
        public void mo27781a(byte[] bArr) {
        }

        /* renamed from: b */
        public void mo27783b() {
        }

        /* renamed from: b */
        public void mo27784b(InMobiAdRequestStatus inMobiAdRequestStatus) {
        }

        /* renamed from: b */
        public void mo27785b(C2620l lVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
        }

        /* renamed from: b */
        public void mo27787b(@NonNull Map<Object, Object> map) {
        }

        /* renamed from: c */
        public void mo28809c() {
        }

        /* renamed from: d */
        public void mo27791d() {
        }

        /* renamed from: e */
        public void mo27792e() {
        }

        /* renamed from: f */
        public void mo27793f() {
        }

        /* renamed from: g */
        public void mo27794g() {
        }

        /* renamed from: h */
        public void mo28810h() {
        }

        /* renamed from: i */
        public void mo28811i() {
        }

        /* renamed from: j */
        public boolean mo28812j() {
            return true;
        }

        /* renamed from: k */
        public void mo28813k() {
        }

        /* renamed from: l */
        public void mo28814l() {
        }

        /* renamed from: m */
        public void mo28815m() {
        }

        /* renamed from: n */
        public void mo28816n() {
        }
    }

    /* renamed from: com.inmobi.media.l$b */
    /* compiled from: AdUnit */
    public static class C2637b {
        @NonNull
        /* renamed from: a */
        public static HashMap<String, String> m5955a(@NonNull String str, @NonNull String str2, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) {
            HashMap<String, String> hashMap = new HashMap<>();
            int i = 0;
            if (jSONArray != null) {
                try {
                    int length = jSONArray.length();
                    int i2 = 0;
                    while (i2 < length) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        int i3 = i2 + 1;
                        sb.append(i3);
                        hashMap.put(sb.toString(), jSONArray.getString(i2));
                        i2 = i3;
                    }
                } catch (Exception e) {
                    String str3 = C2620l.f5846a;
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
            if (jSONArray2 != null) {
                int length2 = jSONArray2.length();
                while (i < length2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    int i4 = i + 1;
                    sb2.append(i4);
                    hashMap.put(sb2.toString(), jSONArray2.getString(i));
                    i = i4;
                }
            }
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    hashMap.put(str4, jSONObject.optString(str4));
                }
            }
            return hashMap;
        }

        @Nullable
        /* renamed from: a */
        static Map<String, Object> m5956a(@NonNull JSONArray jSONArray) {
            JSONObject jSONObject;
            String str = "zMoatExtras";
            String str2 = "clientSlicers";
            String str3 = "clientLevels";
            String str4 = "partnerCode";
            String str5 = "instrumentVideo";
            String str6 = String.ENABLED;
            String str7 = "moat";
            try {
                int length = jSONArray.length();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        jSONObject = null;
                        break;
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.has(str7)) {
                        jSONObject = jSONObject2.getJSONObject(str7);
                        break;
                    }
                    i++;
                }
                if (jSONObject == null) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(str6, Boolean.valueOf(jSONObject.getBoolean(str6)));
                hashMap.put(str5, Boolean.valueOf(jSONObject.optBoolean(str5, false)));
                hashMap.put(str4, jSONObject.optString(str4, null));
                hashMap.put(str3, jSONObject.optJSONArray(str3));
                hashMap.put(str2, jSONObject.optJSONArray(str2));
                hashMap.put(str, jSONObject.optJSONObject(str));
                return hashMap;
            } catch (JSONException e) {
                String str8 = C2620l.f5846a;
                C2463fd.m5161a().mo28382a(new C2495fz(e));
                return null;
            }
        }
    }

    /* renamed from: com.inmobi.media.l$c */
    /* compiled from: AdUnit */
    public static class C2638c {
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static java.util.Map<java.lang.String, java.lang.Object> m5957a(java.lang.String r7, java.lang.String r8, boolean r9, org.json.JSONObject r10) {
            /*
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                int r1 = r7.hashCode()
                r2 = 112202875(0x6b0147b, float:6.6233935E-35)
                java.lang.String r3 = "nonvideo"
                java.lang.String r4 = "video"
                r5 = 2
                r6 = 1
                if (r1 == r2) goto L_0x0022
                r2 = 1425678798(0x54fa21ce, float:8.5944718E12)
                if (r1 == r2) goto L_0x001a
                goto L_0x002a
            L_0x001a:
                boolean r7 = r7.equals(r3)
                if (r7 == 0) goto L_0x002a
                r7 = 1
                goto L_0x002b
            L_0x0022:
                boolean r7 = r7.equals(r4)
                if (r7 == 0) goto L_0x002a
                r7 = 2
                goto L_0x002b
            L_0x002a:
                r7 = -1
            L_0x002b:
                if (r7 == r6) goto L_0x0033
                if (r7 == r5) goto L_0x0032
                java.lang.String r3 = "unknown"
                goto L_0x0033
            L_0x0032:
                r3 = r4
            L_0x0033:
                java.lang.String r7 = "creativeType"
                r0.put(r7, r3)
                java.lang.String r7 = "customReferenceData"
                r0.put(r7, r8)
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                if (r10 == 0) goto L_0x005c
                java.util.Iterator r8 = r10.keys()
            L_0x0048:
                boolean r1 = r8.hasNext()
                if (r1 == 0) goto L_0x005c
                java.lang.Object r1 = r8.next()
                java.lang.String r1 = (java.lang.String) r1
                java.lang.String r2 = r10.optString(r1)
                r7.put(r1, r2)
                goto L_0x0048
            L_0x005c:
                java.lang.String r8 = "macros"
                r0.put(r8, r7)
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r9)
                java.lang.String r8 = "isolateVerificationScripts"
                r0.put(r8, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2620l.C2638c.m5957a(java.lang.String, java.lang.String, boolean, org.json.JSONObject):java.util.Map");
        }
    }

    /* access modifiers changed from: protected */
    @UiThread
    /* renamed from: D */
    public void mo28724D() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: M */
    public void mo28733M() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: N */
    public void mo28734N() {
    }

    @UiThread
    /* renamed from: P */
    public abstract void mo28736P();

    /* access modifiers changed from: protected */
    @UiThread
    /* renamed from: b */
    public void mo28760b(@NonNull C2159ai aiVar, boolean z) {
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: c */
    public void mo28765c(C2636a aVar) {
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: d */
    public void mo28768d(C2636a aVar) {
    }

    /* renamed from: g */
    public abstract String mo28771g();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract int mo28772h();

    /* renamed from: j */
    public void mo28540j(C2600j jVar) {
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: u */
    public Integer mo28786u() {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004f, code lost:
        if (r4 != null) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2620l(@androidx.annotation.NonNull android.content.Context r3, @androidx.annotation.NonNull com.inmobi.media.C2159ai r4, @androidx.annotation.Nullable com.inmobi.media.C2620l.C2636a r5) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f5858f = r0
            r0 = 0
            r2.f5865m = r0
            r2.f5869q = r0
            com.inmobi.media.l$2 r1 = new com.inmobi.media.l$2
            r1.<init>()
            r2.f5853G = r1
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r3)
            r2.f5870r = r1
            r2.f5867o = r4
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            r3.<init>(r5)
            r2.f5876x = r3
            java.lang.String r3 = com.inmobi.media.C2505gd.m5306f()
            java.lang.String r4 = "ads"
            com.inmobi.media.er r4 = com.inmobi.media.C2438es.m5087a(r4, r3, r2)
            com.inmobi.media.eq r4 = (com.inmobi.media.C2426eq) r4
            r2.f5855c = r4
            r4 = 0
            java.lang.String r5 = "pk"
            com.inmobi.media.C2438es.m5087a(r5, r3, r4)
            com.inmobi.media.ai r3 = r2.f5867o
            java.lang.String r3 = r3.mo27841a()
            java.lang.String r5 = "AerServ"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0052
            com.inmobi.media.hq r3 = com.inmobi.media.C2579hs.m5621b()
            if (r3 == 0) goto L_0x004f
            com.inmobi.media.hu r4 = r3.mo28577f()
        L_0x004f:
            if (r4 == 0) goto L_0x0052
            goto L_0x0056
        L_0x0052:
            com.inmobi.media.eq r3 = r2.f5855c
            com.inmobi.media.hu r4 = r3.f5185l
        L_0x0056:
            r2.f5872t = r4
            r2.f5854b = r0
            com.inmobi.media.ak r3 = new com.inmobi.media.ak
            com.inmobi.media.bs r4 = r2.mo28721A()
            r3.<init>(r2, r4, r2)
            r2.f5875w = r3
            java.util.concurrent.ExecutorService r3 = java.util.concurrent.Executors.newSingleThreadExecutor()
            r2.f5860h = r3
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            r2.f5878z = r3
            r3 = -1
            r2.f5861i = r3
            android.os.Handler r3 = new android.os.Handler
            android.os.Looper r4 = android.os.Looper.getMainLooper()
            r3.<init>(r4)
            r2.f5862j = r3
            r2.f5863k = r0
            java.lang.String r3 = ""
            r2.f5849C = r3
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r2.f5873u = r3
            r2.f5874v = r0
            com.inmobi.media.ci r3 = new com.inmobi.media.ci
            r3.<init>(r2)
            r2.f5852F = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2620l.<init>(android.content.Context, com.inmobi.media.ai, com.inmobi.media.l$a):void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28741a(@NonNull Context context, @NonNull C2159ai aiVar, @Nullable C2636a aVar) {
        mo28740a(context);
        mo28746a(aVar);
        this.f5867o = aiVar;
    }

    /* renamed from: a */
    public void mo27896a(C2436er erVar) {
        this.f5855c = (C2426eq) erVar;
    }

    @Nullable
    /* renamed from: d */
    public final Context mo28767d() {
        WeakReference<Context> weakReference = this.f5870r;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    /* renamed from: a */
    public void mo28740a(Context context) {
        this.f5870r = new WeakReference<>(context);
    }

    /* renamed from: e */
    public final C2159ai mo28769e() {
        return this.f5867o;
    }

    @UiThread
    /* renamed from: f */
    public final int mo28770f() {
        return this.f5854b;
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: i */
    public Map<String, String> mo28773i() {
        return new HashMap();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public final String mo28774j() {
        C2153ac r = mo28783r();
        if (r == null) {
            return "unknown";
        }
        return r.mo27819j();
    }

    @VisibleForTesting
    @Nullable
    /* renamed from: T */
    private String mo28818T() {
        C2153ac r = mo28783r();
        if (r == null) {
            return null;
        }
        return r.mo27815f();
    }

    /* renamed from: k */
    public final C2426eq mo28775k() {
        return this.f5855c;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: l */
    public final C2636a mo28777l() {
        C2636a aVar = (C2636a) this.f5876x.get();
        if (aVar == null) {
            C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
        }
        return aVar;
    }

    /* renamed from: a */
    public final void mo28746a(C2636a aVar) {
        this.f5876x = new WeakReference<>(aVar);
    }

    /* renamed from: m */
    public String mo28778m() {
        return this.f5849C;
    }

    /* renamed from: n */
    public final boolean mo28779n() {
        C2153ac r = mo28783r();
        return r != null && r.mo27810a(this.f5855c.mo28339a(mo28771g()).f5195a);
    }

    @NonNull
    /* renamed from: o */
    public final C2163ak mo28780o() {
        if (this.f5875w == null) {
            this.f5875w = new C2163ak(this, mo28721A(), this);
        }
        return this.f5875w;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042  */
    @androidx.annotation.Nullable
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.inmobi.media.C2452f mo28781p() {
        /*
            r6 = this;
            int r0 = r6.mo28770f()
            java.lang.String r1 = r6.mo28774j()
            int r2 = r1.hashCode()
            r3 = -1084172778(0xffffffffbf60d616, float:-0.8782667)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L_0x0023
            r3 = 3213227(0x3107ab, float:4.50269E-39)
            if (r2 == r3) goto L_0x0019
            goto L_0x002d
        L_0x0019:
            java.lang.String r2 = "html"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x0023:
            java.lang.String r2 = "inmobiJson"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x002d
            r1 = 2
            goto L_0x002e
        L_0x002d:
            r1 = -1
        L_0x002e:
            r2 = 3
            r3 = 0
            if (r1 == r5) goto L_0x0042
            if (r1 == r4) goto L_0x0035
            return r3
        L_0x0035:
            if (r0 == 0) goto L_0x0041
            if (r5 == r0) goto L_0x0041
            if (r2 == r0) goto L_0x0041
            if (r4 != r0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            com.inmobi.media.h r0 = r6.f5859g
            return r0
        L_0x0041:
            return r3
        L_0x0042:
            if (r0 == 0) goto L_0x004e
            if (r5 == r0) goto L_0x004e
            if (r2 != r0) goto L_0x0049
            goto L_0x004e
        L_0x0049:
            com.inmobi.media.j r0 = r6.mo28782q()
            return r0
        L_0x004e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2620l.mo28781p():com.inmobi.media.f");
    }

    @Nullable
    /* renamed from: q */
    public C2600j mo28782q() {
        return this.f5877y;
    }

    @Nullable
    /* renamed from: r */
    public C2153ac mo28783r() {
        C2162aj ajVar = this.f5868p;
        if (ajVar == null) {
            return null;
        }
        return ajVar.mo27884k();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo28756a(@NonNull C2153ac acVar) {
        boolean z;
        JSONObject jSONObject;
        boolean z2;
        JSONObject jSONObject2;
        String str = "creativeType";
        String str2 = "omidEnabled";
        String str3 = "omsdkInfo";
        String str4 = "metaInfo";
        String str5 = "tracking";
        String str6 = "viewability";
        String str7 = "unknown";
        try {
            JSONObject jSONObject3 = new JSONObject(acVar.mo27811b());
            String j = acVar.mo27819j();
            this.f5874v = jSONObject3.optBoolean("allowAutoRedirection", false);
            this.f5873u = acVar.mo27816g();
            if (str7.equals(j)) {
                return false;
            }
            this.f5856d = acVar.mo27821l();
            if (this.f5856d == null || this.f5856d.length() == 0) {
                jSONObject = jSONObject3;
                z2 = false;
            } else {
                jSONObject = jSONObject3;
                this.f5856d = this.f5856d.replace("@__imm_aft@", String.valueOf(System.currentTimeMillis() - this.f5857e));
                z2 = true;
            }
            if ("mediationJson".equals(j)) {
                return z2;
            }
            this.f5849C = acVar.mo27831v();
            final Context c = C2505gd.m5298c();
            if (c == null) {
                return z2;
            }
            if (this.f5878z.isEmpty()) {
                if (this.f5855c.f5182i.f5241k) {
                    jSONObject2 = jSONObject;
                    if (jSONObject2.has(str6)) {
                        Map<String, Object> a = C2637b.m5956a(jSONObject2.getJSONArray(str6));
                        if (a != null && ((Boolean) a.get(String.ENABLED)).booleanValue()) {
                            Application d = C2505gd.m5301d();
                            if (d != null) {
                                C2330dg.m4799a(d);
                                C2298cs csVar = new C2298cs(1);
                                csVar.f4852b = a;
                                this.f5878z.add(csVar);
                            }
                        }
                    }
                } else {
                    jSONObject2 = jSONObject;
                }
                if (this.f5855c.f5182i.f5242l.f5211f && jSONObject2.has(str4)) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject(str4);
                    if (jSONObject4.has(str3)) {
                        JSONObject jSONObject5 = jSONObject4.getJSONObject(str3);
                        if (jSONObject5.has(str2) && jSONObject5.getBoolean(str2)) {
                            if (jSONObject4.has(str)) {
                                str7 = jSONObject4.getString(str);
                            }
                            this.f5862j.post(new Runnable() {
                                public final void run() {
                                    C2345a.f4975a.mo28198a(c.getApplicationContext(), C2620l.this.f5855c);
                                }
                            });
                            C2298cs csVar2 = new C2298cs(3);
                            csVar2.f4852b = C2638c.m5957a(str7, jSONObject5.optString("customReferenceData"), jSONObject5.optBoolean("isolateVerificationScripts"), jSONObject5.optJSONObject("macros"));
                            this.f5878z.add(csVar2);
                        }
                    }
                }
                if (jSONObject2.has(str5) && AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB.equals(jSONObject2.getString(str5))) {
                    z = false;
                    try {
                        this.f5861i = 0;
                    } catch (JSONException e) {
                        e = e;
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        C2463fd.m5161a().mo28382a(new C2495fz(e));
                        return z;
                    }
                }
            }
            z = z2;
            return z;
        } catch (JSONException e3) {
            e = e3;
            z = false;
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return z;
        } catch (IllegalArgumentException e4) {
            e = e4;
            z = false;
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return z;
        }
    }

    /* renamed from: s */
    public JSONObject mo28784s() {
        return this.f5873u;
    }

    /* access modifiers changed from: protected */
    @UiThread
    /* renamed from: b */
    public void mo28761b(@NonNull C2162aj ajVar) {
        if (mo28770f() == 1) {
            this.f5868p = ajVar;
            C2153ac k = ajVar.mo27884k();
            if (k == null) {
                mo28754a(false);
                return;
            }
            this.f5860h.submit(new C2673y(this, k, false, null));
        }
    }

    @UiThread
    /* renamed from: a */
    public final void mo28743a(InMobiAdRequestStatus inMobiAdRequestStatus, boolean z) {
        if (mo28770f() == 1 && z) {
            this.f5854b = 3;
        }
        C2636a l = mo28777l();
        if (l != null) {
            l.mo27778a(this, inMobiAdRequestStatus);
        }
        mo28729I();
    }

    /* renamed from: a */
    public void mo28748a(String str) {
        this.f5871s = str;
    }

    /* renamed from: b */
    public void mo28762b(String str) {
        this.f5867o.mo27844b(str);
    }

    /* renamed from: a */
    public void mo28752a(Map<String, String> map) {
        this.f5867o.mo27845b(map);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public boolean mo28787v() {
        try {
            RecyclerView.class.getName();
            Picasso.class.getName();
            CustomTabsClient.class.getName();
            return false;
        } catch (NoClassDefFoundError unused) {
            return true;
        }
    }

    /* renamed from: a */
    public void mo28753a(@NonNull JSONObject jSONObject) {
        this.f5860h.submit(new C2639m(this, jSONObject));
    }

    @UiThread
    /* renamed from: w */
    public void mo28788w() {
        this.f5858f = SystemClock.elapsedRealtime();
        if (!C2515gi.m5353a()) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.NETWORK_UNREACHABLE), true);
        } else if (this.f5850D) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.LOAD_CALLED_AFTER_GET_SIGNALS), false);
        } else {
            mo28819U();
        }
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: c */
    public final void mo28764c(@Nullable C2162aj ajVar) {
        if (ajVar == null) {
            mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
        } else {
            mo28745a(ajVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* renamed from: x */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo28789x() {
        /*
            r7 = this;
            com.inmobi.media.l$a r0 = r7.mo28777l()
            long r1 = java.lang.System.currentTimeMillis()
            boolean r3 = com.inmobi.media.C2515gi.m5353a()
            r4 = 10
            r5 = 1
            if (r3 != 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            com.inmobi.ads.InMobiAdRequestStatus r3 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r6 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE
            r3.<init>(r6)
            r0.mo27784b(r3)
        L_0x001d:
            r0 = 1
            goto L_0x005e
        L_0x001f:
            int r3 = r7.f5854b
            if (r3 == r5) goto L_0x0051
            r6 = 2
            if (r3 == r6) goto L_0x0051
            r6 = 4
            if (r3 == r6) goto L_0x0051
            if (r3 == r4) goto L_0x0044
            r6 = 6
            if (r3 == r6) goto L_0x0037
            r6 = 7
            if (r3 == r6) goto L_0x0037
            r6 = 8
            if (r3 == r6) goto L_0x0037
            r0 = 0
            goto L_0x005e
        L_0x0037:
            if (r0 == 0) goto L_0x001d
            com.inmobi.ads.InMobiAdRequestStatus r3 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r6 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.AD_ACTIVE
            r3.<init>(r6)
            r0.mo27784b(r3)
            goto L_0x001d
        L_0x0044:
            if (r0 == 0) goto L_0x001d
            com.inmobi.ads.InMobiAdRequestStatus r3 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r6 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.FETCHING_SIGNALS_STATE_ERROR
            r3.<init>(r6)
            r0.mo27784b(r3)
            goto L_0x001d
        L_0x0051:
            if (r0 == 0) goto L_0x001d
            com.inmobi.ads.InMobiAdRequestStatus r3 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r6 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.GET_SIGNALS_CALLED_WHILE_LOADING
            r3.<init>(r6)
            r0.mo27784b(r3)
            goto L_0x001d
        L_0x005e:
            if (r0 == 0) goto L_0x0061
            return
        L_0x0061:
            r7.f5850D = r5
            r7.f5854b = r4
            com.inmobi.media.ai r0 = r7.f5867o
            java.util.Map r0 = r0.mo27846c()
            java.lang.String r0 = com.inmobi.media.C2159ai.m4292a(r0)
            com.inmobi.media.ba r3 = r7.f5866n
            if (r3 != 0) goto L_0x007b
            com.inmobi.media.ba r3 = new com.inmobi.media.ba
            r3.<init>(r7, r0)
            r7.f5866n = r3
            goto L_0x007d
        L_0x007b:
            r3.f4515b = r0
        L_0x007d:
            java.util.concurrent.ExecutorService r0 = r7.f5860h
            com.inmobi.media.q r3 = new com.inmobi.media.q
            r3.<init>(r7, r1)
            r0.submit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2620l.mo28789x():void");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final int mo28757b(C2636a aVar) {
        HashMap hashMap;
        C2296cq cqVar;
        final WeakReference weakReference = new WeakReference(aVar);
        try {
            int h = mo28772h();
            JSONObject jSONObject = new JSONObject(this.f5856d);
            C2426eq k = mo28775k();
            if (this.f5868p == null) {
                hashMap = null;
            } else {
                hashMap = C2515gi.m5349a(this.f5868p.mo27885l());
            }
            C2153ac r = mo28783r();
            if (r != null) {
                if (r instanceof C2204at) {
                    C2204at atVar = (C2204at) r;
                    C2169am.m4358a();
                    C2154ad b = C2169am.m4361b(atVar.f4500b);
                    if (b == null || !b.mo27832a()) {
                        throw new IllegalStateException("Asset not available in cache");
                    }
                    cqVar = new C2296cq(b.f4337e, atVar.f4501c, atVar.f4502d, atVar.mo27931w(), atVar.mo27932x(), mo28775k().f5183j);
                } else {
                    cqVar = null;
                }
                C2220bg bgVar = new C2220bg(h, jSONObject, k, hashMap, cqVar);
                if (!bgVar.mo27963d() || mo28767d() == null || mo28818T() == null) {
                    return 21;
                }
                C2542h a = C2551b.m5532a(mo28767d(), mo28772h(), bgVar, mo28818T(), this.f5878z, mo28775k(), this.f5867o.mo27849e(), this.f5874v, this.f5849C);
                a.mo28491a((C2552c) new C2552c() {
                    /* renamed from: a */
                    public final void mo28542a() {
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo28809c();
                            } else {
                                C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }

                    /* renamed from: b */
                    public final void mo28545b() {
                        C2620l.this.mo28763c(4);
                        if (!C2620l.this.f5865m) {
                            C2620l.this.f5862j.post(new Runnable() {
                                public final void run() {
                                    C2620l.this.mo28765c((C2636a) weakReference.get());
                                }
                            });
                        }
                    }

                    /* renamed from: c */
                    public final void mo28546c() {
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo27791d();
                            } else {
                                C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }

                    /* renamed from: d */
                    public final void mo28547d() {
                        StringBuilder sb = new StringBuilder("Successfully impressed ad for placement id: ");
                        sb.append(C2620l.this.f5867o.toString());
                        String str = "InMobi";
                        C2514gh.m5342a(2, str, sb.toString());
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo28810h();
                            } else {
                                C2514gh.m5342a(2, str, "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }

                    /* renamed from: e */
                    public final void mo28548e() {
                        StringBuilder sb = new StringBuilder("Ad interaction for placement id: ");
                        sb.append(C2620l.this.f5867o.toString());
                        String str = "InMobi";
                        C2514gh.m5342a(2, str, sb.toString());
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo27780a((Map<Object, Object>) new HashMap<Object,Object>());
                            } else {
                                C2514gh.m5342a(2, str, "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }

                    /* renamed from: f */
                    public final void mo28549f() {
                        if (!C2620l.this.f5865m) {
                            StringBuilder sb = new StringBuilder("Ad dismissed for placement id: ");
                            sb.append(C2620l.this.f5867o.toString());
                            C2514gh.m5342a(2, "InMobi", sb.toString());
                            C2620l.this.f5862j.post(new Runnable() {
                                public final void run() {
                                    C2620l.this.mo28768d((C2636a) weakReference.get());
                                }
                            });
                        }
                    }

                    /* renamed from: a */
                    public final void mo28543a(Map<String, String> map) {
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo27787b((Map<Object, Object>) new HashMap<Object,Object>(map));
                            } else {
                                C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }

                    /* renamed from: g */
                    public final void mo28550g() {
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo27794g();
                            } else {
                                C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }

                    /* renamed from: h */
                    public final void mo28551h() {
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo28811i();
                            } else {
                                C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }

                    /* renamed from: i */
                    public final void mo28552i() {
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo28813k();
                            } else {
                                C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }

                    /* renamed from: a */
                    public final void mo28544a(boolean z) {
                        if (!C2620l.this.f5865m) {
                            C2636a aVar = (C2636a) weakReference.get();
                            if (aVar != null) {
                                aVar.mo28808a(z);
                            } else {
                                C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
                            }
                        }
                    }
                });
                this.f5859g = a;
                return 0;
            }
            throw new IllegalStateException("No ad");
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return 13;
        } catch (IllegalStateException unused) {
            return 13;
        } catch (Exception e2) {
            C2463fd.m5161a().mo28382a(new C2495fz(e2));
            return 13;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public final void mo28790y() {
        C2452f p = mo28781p();
        if (p != null) {
            p.mo28358a(2, null);
        }
    }

    /* renamed from: a */
    public void mo28747a(@NonNull ASRequestParams aSRequestParams) {
        this.f5851E = aSRequestParams;
    }

    /* renamed from: z */
    public C2239bs mo28791z() {
        C2239bs A = mo28721A();
        A.f4658g = true;
        return A;
    }

    @NonNull
    /* renamed from: A */
    public C2239bs mo28721A() {
        String str = this.f5855c.f5174a;
        C2540gy gyVar = new C2540gy(this.f5855c.f5243m.f5245a);
        C2169am.m4358a();
        C2239bs bsVar = new C2239bs(str, gyVar, C2169am.m4366e(), this.f5867o);
        bsVar.f4655d = this.f5871s;
        bsVar.f4654c = mo28771g();
        bsVar.f4653b = "unifiedSdkJson";
        bsVar.f4656e = mo28773i();
        bsVar.f5441m = this.f5855c.f5177d * 1000;
        bsVar.f5442n = this.f5855c.f5177d * 1000;
        bsVar.f5448t = this.f5855c.f5180g.f5225m && C2505gd.m5305e();
        bsVar.f4659h = this.f5851E;
        return bsVar;
    }

    @UiThread
    /* renamed from: B */
    public void mo28722B() {
        if (!this.f5865m) {
            this.f5865m = true;
            this.f5878z.clear();
            mo28723C();
            this.f5854b = 0;
            this.f5847A = false;
            this.f5848B = null;
            this.f5863k = false;
            this.f5864l = false;
            this.f5849C = "";
            this.f5873u = new JSONObject();
            this.f5874v = false;
            this.f5850D = false;
            this.f5868p = null;
        }
    }

    /* access modifiers changed from: 0000 */
    @CallSuper
    @UiThread
    /* renamed from: C */
    public void mo28723C() {
        C2542h hVar = this.f5859g;
        if (hVar != null) {
            hVar.destroy();
            this.f5859g = null;
        }
        C2600j jVar = this.f5877y;
        if (jVar != null) {
            jVar.f5816v = false;
            jVar.destroy();
            this.f5877y = null;
        }
    }

    /* access modifiers changed from: protected */
    @UiThread
    /* renamed from: E */
    public void mo28725E() {
        mo28729I();
    }

    /* access modifiers changed from: protected */
    @UiThread
    /* renamed from: F */
    public void mo28726F() {
        if (2 == mo28770f() || 4 == mo28770f()) {
            mo28763c(2);
            this.f5854b = 3;
            mo28729I();
            if (mo28777l() != null) {
                mo28777l().mo27778a(this, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: G */
    public boolean mo28727G() {
        return mo28770f() == 2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: H */
    public final void mo28728H() {
        HashMap hashMap = new HashMap();
        hashMap.put("adType", mo28771g());
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f5858f));
        hashMap.put("networkType", C2527gp.m5390b());
        mo28766c("AdLoadSuccessful", hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: I */
    public final void mo28729I() {
        HashMap hashMap = new HashMap();
        hashMap.put("networkType", C2527gp.m5390b());
        hashMap.put("adType", mo28771g());
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f5858f));
        mo28766c("AdLoadFailed", hashMap);
    }

    /* renamed from: a */
    public void mo28528a(String str, Map<String, Object> map) {
        mo28766c(str, map);
    }

    /* renamed from: b */
    public final void mo27935b(String str, Map<String, Object> map) {
        mo28766c(str, map);
    }

    /* renamed from: c */
    public void mo28766c(String str, Map<String, Object> map) {
        C2497ga.m5260a().mo28447a(str, map);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo28759b(@NonNull C2153ac acVar) {
        HashMap a;
        VerificationScriptResource verificationScriptResource;
        Context d = mo28767d();
        if (mo28775k().f5182i.f5242l.f5211f && C2345a.f4975a.mo28199a()) {
            boolean z = acVar instanceof C2204at;
            for (C2298cs csVar : this.f5878z) {
                if (3 == csVar.f4851a) {
                    String str = "creativeType";
                    if ("video" != csVar.f4852b.get(str) || !z) {
                        m5800a(d, csVar);
                    } else {
                        C2204at atVar = (C2204at) acVar;
                        try {
                            C2296cq cqVar = new C2296cq(atVar.f4500b, atVar.f4501c, atVar.f4502d, atVar.mo27931w(), atVar.mo27932x(), mo28775k().f5183j);
                            int h = mo28772h();
                            JSONObject jSONObject = new JSONObject(this.f5856d);
                            C2426eq k = mo28775k();
                            if (this.f5868p == null) {
                                a = null;
                            } else {
                                a = C2515gi.m5349a(this.f5868p.mo27885l());
                            }
                            C2220bg bgVar = new C2220bg(h, jSONObject, k, a, cqVar);
                            C2235bp bpVar = (C2235bp) bgVar.mo27962c(ShareConstants.VIDEO_URL).get(0);
                            if (d != null) {
                                ArrayList arrayList = new ArrayList();
                                for (C2234bo boVar : bpVar.f4541u) {
                                    if ("OMID_VIEWABILITY".equals(boVar.f4631d) && (boVar instanceof C2338dn)) {
                                        C2338dn dnVar = (C2338dn) boVar;
                                        Map map = (Map) csVar.mo28143a("macros", Map.class);
                                        String d2 = m5804d(dnVar.f4956g, map);
                                        String str2 = dnVar.f4957h;
                                        String d3 = m5804d(dnVar.f4629b, map);
                                        if (!TextUtils.isEmpty(d2) && !TextUtils.isEmpty(str2)) {
                                            verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(str2, new URL(d3), d2);
                                        } else if (!TextUtils.isEmpty(str2)) {
                                            verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(str2, new URL(d3));
                                        } else {
                                            verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(new URL(d3));
                                        }
                                        arrayList.add(verificationScriptResource);
                                    }
                                }
                                if (arrayList.size() != 0) {
                                    C2214bc a2 = m5798a(bgVar);
                                    String str3 = "videoSkipOffset";
                                    String str4 = "videoSkippable";
                                    if (a2 != null) {
                                        csVar.f4852b.put(str4, Boolean.TRUE);
                                        csVar.f4852b.put(str3, Integer.valueOf(a2.f4535o));
                                    } else {
                                        csVar.f4852b.put(str4, Boolean.FALSE);
                                        csVar.f4852b.put(str3, Integer.valueOf(0));
                                    }
                                    csVar.f4852b.put("videoAutoPlay", bpVar.f4542v.get("shouldAutoPlay"));
                                    csVar.f4852b.put("omidAdSession", C2343dr.m4865a((List<VerificationScriptResource>) arrayList, (String) csVar.f4852b.get(str)));
                                    csVar.f4852b.put("deferred", Boolean.TRUE);
                                }
                            }
                        } catch (Exception e) {
                            C2463fd.m5161a().mo28382a(new C2495fz(e));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m5800a(Context context, C2298cs csVar) {
        HashMap a;
        VerificationScriptResource verificationScriptResource;
        try {
            int h = mo28772h();
            JSONObject jSONObject = new JSONObject(this.f5856d);
            C2426eq k = mo28775k();
            if (this.f5868p == null) {
                a = null;
            } else {
                a = C2515gi.m5349a(this.f5868p.mo27885l());
            }
            C2220bg bgVar = new C2220bg(h, jSONObject, k, a, (C2296cq) null);
            C2214bc bcVar = (C2214bc) bgVar.mo27962c("CONTAINER").get(0);
            if (context != null) {
                ArrayList arrayList = new ArrayList();
                for (C2234bo boVar : bcVar.f4541u) {
                    if ("OMID_VIEWABILITY".equals(boVar.f4631d) && (boVar instanceof C2338dn)) {
                        C2338dn dnVar = (C2338dn) boVar;
                        Map map = (Map) csVar.mo28143a("macros", Map.class);
                        String d = m5804d(dnVar.f4956g, map);
                        String str = dnVar.f4957h;
                        String d2 = m5804d(dnVar.f4629b, map);
                        if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(str)) {
                            verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(str, new URL(d2), d);
                        } else if (!TextUtils.isEmpty(str)) {
                            verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(str, new URL(d2));
                        } else {
                            verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(new URL(d2));
                        }
                        arrayList.add(verificationScriptResource);
                    }
                }
                if (arrayList.size() != 0) {
                    csVar.f4852b.put("omidAdSession", C2342dq.m4856a((List<VerificationScriptResource>) arrayList, (String) csVar.f4852b.get("creativeType")));
                    csVar.f4852b.put("deferred", Boolean.TRUE);
                }
            }
        } catch (Exception e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
        }
    }

    /* renamed from: a */
    private static C2214bc m5798a(C2220bg bgVar) {
        for (String c : bgVar.mo27964e()) {
            C2214bc bcVar = (C2214bc) bgVar.mo27962c(c).get(0);
            if (bcVar.f4532l == 2) {
                return bcVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public final void mo28776k(C2600j jVar) {
        if (mo28775k().f5182i.f5242l.f5211f && C2345a.f4975a.mo28199a()) {
            for (C2298cs csVar : this.f5878z) {
                if (3 == csVar.f4851a) {
                    try {
                        C2336dl a = C2341dp.m4847a((String) csVar.mo28143a("creativeType", String.class), jVar, (String) csVar.mo28143a("customReferenceData", String.class), ((Boolean) csVar.mo28143a("isolateVerificationScripts", Boolean.class)).booleanValue());
                        if (a != null) {
                            csVar.f4852b.put("omidAdSession", a);
                            csVar.f4852b.put("deferred", Boolean.TRUE);
                        }
                    } catch (Exception e) {
                        C2463fd.m5161a().mo28382a(new C2495fz(e));
                    }
                }
            }
        }
    }

    @Nullable
    /* renamed from: d */
    private static String m5804d(String str, Map map) {
        if (!(map == null || str == null)) {
            for (Object next : map.keySet()) {
                str = str.replace(next.toString(), map.get(next).toString());
            }
        }
        return str;
    }

    /* renamed from: J */
    public C2600j mo28730J() {
        return this.f5848B;
    }

    /* renamed from: a */
    public void mo28749a(final String str, final String str2) {
        this.f5860h.execute(new Runnable() {
            public final void run() {
                C2153ac r = C2620l.this.mo28783r();
                if (r == null || str == null || !r.mo27815f().equals(str2)) {
                    String str = C2620l.f5846a;
                    return;
                }
                C2620l.m5801a(C2620l.this, r, str);
                String str2 = C2620l.f5846a;
            }
        });
    }

    /* renamed from: a */
    public void mo28750a(String str, String str2, @NonNull C2496g gVar, String str3) {
        ExecutorService executorService = this.f5860h;
        final String str4 = str3;
        final C2496g gVar2 = gVar;
        final String str5 = str;
        final String str6 = str2;
        C262311 r1 = new Runnable() {
            public final void run() {
                try {
                    C2153ac r = C2620l.this.mo28783r();
                    if (r == null || !r.mo27815f().equals(str4)) {
                        String str = C2620l.f5846a;
                        gVar2.mo28445a(str5, str6, "");
                        return;
                    }
                    gVar2.mo28445a(str5, str6, r.mo27812c());
                    String str2 = C2620l.f5846a;
                } catch (Exception e) {
                    String str3 = C2620l.f5846a;
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
        };
        executorService.execute(r1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: K */
    public final void mo28731K() {
        this.f5860h.execute(new Runnable() {
            public final void run() {
                HashMap a;
                try {
                    int h = C2620l.this.mo28772h();
                    JSONObject jSONObject = new JSONObject(C2620l.this.f5856d);
                    C2426eq k = C2620l.this.mo28775k();
                    if (C2620l.this.f5868p == null) {
                        a = null;
                    } else {
                        a = C2515gi.m5349a(C2620l.this.f5868p.mo27885l());
                    }
                    final C2220bg bgVar = new C2220bg(h, jSONObject, k, a, (C2296cq) null);
                    C2620l.this.f5862j.post(new Runnable() {
                        public final void run() {
                            try {
                                C2237bq bqVar = bgVar.f4574k;
                                if (!(bqVar == null || C2620l.this.mo28767d() == null)) {
                                    C2620l lVar = C2620l.this;
                                    Context d = C2620l.this.mo28767d();
                                    int h = C2620l.this.mo28772h();
                                    Set b = C2620l.this.f5878z;
                                    C2620l lVar2 = C2620l.this;
                                    lVar.f5848B = new C2600j(d, h, b, lVar2.f5868p == null ? null : lVar2.f5868p.mo27876c());
                                    C2620l.this.f5848B.mo28623a(C2620l.this.f5853G, C2620l.this.mo28775k(), C2620l.this.mo28821W(), false);
                                    C2620l.this.f5848B.f5802h = true;
                                    C2620l.this.f5848B.setBlobProvider(C2620l.this);
                                    C2620l.this.f5848B.setIsPreload(true);
                                    C2620l.this.f5848B.setPlacementId(C2620l.this.f5867o.mo27849e());
                                    C2620l.this.f5848B.setCreativeId(C2620l.this.f5849C);
                                    C2620l.this.f5848B.setAllowAutoRedirection(C2620l.this.f5874v);
                                    C2620l.this.f5848B.setShouldFireRenderBeacon(false);
                                    if (C2620l.this.f5861i == 0) {
                                        C2620l.this.mo28776k(C2620l.this.f5848B);
                                    }
                                    if ("URL".equals(bqVar.f4645z)) {
                                        C2620l.this.f5848B.mo28630c((String) bqVar.f4525e);
                                    } else {
                                        C2620l.this.f5848B.mo28627b((String) bqVar.f4525e);
                                    }
                                }
                                C2620l.this.mo28758b(2);
                            } catch (Exception e) {
                                String str = C2620l.f5846a;
                                C2620l.this.f5854b = 3;
                                C2620l.this.mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
                                C2463fd.m5161a().mo28382a(new C2495fz(e));
                            }
                        }
                    });
                } catch (Exception e) {
                    String str = C2620l.f5846a;
                    C2620l lVar = C2620l.this;
                    lVar.f5854b = 3;
                    lVar.mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: L */
    public final void mo28732L() {
        if (this.f5863k && this.f5864l && this.f5847A) {
            mo28733M();
        }
    }

    @UiThread
    /* renamed from: a */
    public void mo28742a(@NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
        C2162aj ajVar = this.f5868p;
        C2153ac j = ajVar == null ? null : ajVar.mo27883j();
        if (j == null) {
            C2636a l = mo28777l();
            if (l != null) {
                l.mo27779a(this, false, inMobiAdRequestStatus);
            }
            return;
        }
        this.f5860h.submit(new C2673y(this, j, true, inMobiAdRequestStatus));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: O */
    public final boolean mo28735O() {
        C2153ac r = mo28783r();
        if (r != null && 5 == mo28770f() && !mo28779n()) {
            C2636a l = mo28777l();
            if (l != null) {
                l.mo27783b();
            }
            return true;
        } else if (r != null && 2 == mo28770f() && !mo28779n()) {
            return false;
        } else {
            mo28743a(new InMobiAdRequestStatus(StatusCode.AD_NO_LONGER_AVAILABLE), true);
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: Q */
    public final void mo28737Q() throws IllegalStateException {
        C2153ac V = mo28820V();
        if (V != null) {
            V.mo27815f();
            String j = V.mo27819j();
            char c = 65535;
            int hashCode = j.hashCode();
            if (hashCode != -1470802432) {
                if (hashCode != -1084172778) {
                    if (hashCode == 3213227 && j.equals(String.HTML)) {
                        c = 2;
                    }
                } else if (j.equals("inmobiJson")) {
                    c = 3;
                }
            } else if (j.equals("mediationJson")) {
                c = 1;
            }
            if (c == 2) {
                return;
            }
            if (c == 3) {
                C2162aj ajVar = this.f5868p;
                if (ajVar != null) {
                    ajVar.mo27873a(this.f5855c, (C2295cp) this);
                }
                return;
            }
            V.mo27819j();
            StringBuilder sb = new StringBuilder("Can not handle fallback for markup type: ");
            sb.append(V.mo27819j());
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Unable to get topAd");
    }

    @Nullable
    /* renamed from: V */
    private C2153ac mo28820V() {
        C2153ac r = mo28783r();
        if (r != null && !mo28779n()) {
            return r;
        }
        return null;
    }

    @UiThread
    /* renamed from: a */
    public void mo28134a(C2153ac acVar, boolean z) {
        C2153ac V = mo28820V();
        if (V != null) {
            V.mo27815f();
            String j = V.mo27819j();
            char c = 65535;
            int hashCode = j.hashCode();
            if (hashCode != -1470802432) {
                if (hashCode != -1084172778) {
                    if (hashCode == 3213227 && j.equals(String.HTML)) {
                        c = 2;
                    }
                } else if (j.equals("inmobiJson")) {
                    c = 3;
                }
            } else if (j.equals("mediationJson")) {
                c = 1;
            }
            if (c == 2) {
                return;
            }
            if (c == 3) {
                if (mo28770f() == 2) {
                    C2162aj ajVar = this.f5868p;
                    if (ajVar != null) {
                        ajVar.mo27872a(acVar);
                        C2163ak o = mo28780o();
                        String f = this.f5868p.mo27879f();
                        if (acVar != null) {
                            Set i = acVar.mo27818i();
                            if (i.size() == 0) {
                                o.f4400a.mo27892a(o.f4401b.f4652a, true);
                                return;
                            }
                            C2156ae aeVar = new C2156ae(UUID.randomUUID().toString(), f, i, o.f4403d);
                            C2172ao a = C2172ao.m4371a();
                            a.f4415a.execute(new Runnable(aeVar, acVar.mo27807a()) {

                                /* renamed from: a */
                                final /* synthetic */ C2156ae f4432a;

                                /* renamed from: b */
                                final /* synthetic */ String f4433b;

                                {
                                    this.f4432a = r2;
                                    this.f4433b = r3;
                                }

                                public final void run() {
                                    C2172ao.this.m4375a(this.f4432a);
                                    C2172ao.f4413b;
                                    this.f4432a.f4354b.size();
                                    ArrayList arrayList = new ArrayList();
                                    ArrayList<String> arrayList2 = new ArrayList<>();
                                    for (C2206av avVar : this.f4432a.f4354b) {
                                        if (avVar.f4510b.trim().length() <= 0 || avVar.f4509a != 2) {
                                            arrayList2.add(avVar.f4510b);
                                        } else {
                                            arrayList.add(avVar.f4510b);
                                        }
                                    }
                                    C2172ao.m4380a(C2172ao.this, (List) arrayList, this.f4433b);
                                    C2172ao.this.m4398f();
                                    C2172ao.this.m4401g();
                                    for (String b : arrayList2) {
                                        C2172ao.m4387b(C2172ao.this, b);
                                    }
                                }
                            });
                        }
                    }
                }
                return;
            }
            V.mo27819j();
            StringBuilder sb = new StringBuilder("Can not handle fallback for markup type: ");
            sb.append(V.mo27819j());
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public boolean mo28821W() {
        C2153ac r = mo28783r();
        return r != null && r.mo27829t();
    }

    /* renamed from: a */
    public void mo28525a() {
        mo28763c(4);
        C2636a l = mo28777l();
        if (l != null) {
            l.mo28816n();
            l.mo28810h();
        }
    }

    @CallSuper
    /* renamed from: b */
    public void mo28529b() {
        this.f5862j.post(new Runnable() {
            public final void run() {
                if (C2620l.this.mo28770f() == 7 || C2620l.this.mo28770f() == 8) {
                    C2636a l = C2620l.this.mo28777l();
                    if (l != null) {
                        l.mo28815m();
                    }
                }
            }
        });
    }

    @UiThread
    /* renamed from: a */
    public void mo28116a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 4) {
                        C2636a l = mo28777l();
                        if (l != null) {
                            l.mo28814l();
                            return;
                        }
                    }
                } else if (mo28727G()) {
                    try {
                        C2600j J = mo28730J();
                        if (J != null) {
                            J.stopLoading();
                            return;
                        }
                        C2452f p = mo28781p();
                        if (p instanceof C2600j) {
                            ((C2600j) p).stopLoading();
                        }
                        this.f5854b = 3;
                        mo28729I();
                        if (mo28777l() != null) {
                            mo28777l().mo27778a(this, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                        }
                    } catch (Exception e) {
                        C2463fd.m5161a().mo28382a(new C2495fz(e));
                    }
                }
            } else if (4 == mo28770f() || 2 == mo28770f()) {
                this.f5854b = 3;
                C2636a l2 = mo28777l();
                if (l2 != null) {
                    l2.mo27785b(this, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                }
                mo28729I();
                return;
            }
            return;
        }
        mo28744a(this.f5867o, new InMobiAdRequestStatus(StatusCode.REQUEST_TIMED_OUT));
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"SwitchIntDef"})
    /* renamed from: b */
    public final void mo28758b(int i) {
        int i2;
        if (i == 0) {
            i2 = this.f5872t.mo28592f();
        } else if (i == 1) {
            i2 = this.f5872t.mo28595i();
        } else if (i == 2) {
            i2 = this.f5872t.mo28598l();
        } else if (i == 4) {
            i2 = this.f5872t.mo28596j();
        } else {
            return;
        }
        this.f5852F.mo28118a(i, (long) i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo28763c(final int i) {
        this.f5860h.execute(new Runnable() {
            public final void run() {
                C2620l.this.f5852F.mo28117a(i);
            }
        });
    }

    /* renamed from: c */
    public C2591hu mo28532c() {
        return this.f5872t;
    }

    /* renamed from: R */
    public boolean mo28738R() {
        return this.f5869q;
    }

    /* renamed from: S */
    public void mo28739S() {
        this.f5869q = false;
    }

    @UiThread
    /* renamed from: a */
    public void mo27892a(@NonNull C2159ai aiVar, boolean z) {
        if (!this.f5865m && mo28767d() != null) {
            mo28760b(aiVar, z);
        }
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public final void mo28745a(@NonNull C2162aj ajVar) {
        if (!this.f5865m && mo28767d() != null) {
            mo28763c(0);
            mo28761b(ajVar);
        }
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: a */
    public void mo28754a(boolean z) {
        if (z) {
            this.f5854b = 2;
            return;
        }
        mo28729I();
        mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), true);
    }

    /* renamed from: a */
    public void mo28744a(@NonNull C2159ai aiVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
        if (!this.f5865m && mo28767d() != null) {
            mo28763c(0);
            try {
                if (this.f5867o.equals(aiVar) && mo28770f() == 1) {
                    StringBuilder sb = new StringBuilder("Failed to fetch ad for placement id: ");
                    sb.append(this.f5867o.toString());
                    sb.append(", reason phrase available in onAdLoadFailed callback.");
                    C2514gh.m5342a(2, "InMobi", sb.toString());
                    inMobiAdRequestStatus.getMessage();
                    this.f5854b = 3;
                    mo28729I();
                    C2636a l = mo28777l();
                    if (l != null) {
                        l.mo28806a(inMobiAdRequestStatus);
                    }
                }
            } catch (Exception e) {
                C2514gh.m5342a(1, "[InMobi]", "Unable to load Ad; SDK encountered an unexpected error");
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @UiThread
    /* renamed from: t */
    public final void mo28785t() {
        try {
            Context d = mo28767d();
            if (d != null) {
                try {
                    if (this.f5877y == null || this.f5877y.f5811q.get()) {
                        this.f5877y = new C2600j(d, mo28772h(), this.f5878z, mo28818T());
                        if (this.f5867o.mo27855i().equals("banner")) {
                            this.f5877y.setAdSize(this.f5867o.mo27856j());
                        }
                        this.f5877y.mo28623a((C2618a) this, mo28775k(), mo28821W(), true);
                        this.f5877y.setCreativeId(this.f5849C);
                        this.f5877y.setPlacementId(this.f5867o.mo27849e());
                        this.f5877y.setAllowAutoRedirection(this.f5874v);
                    }
                } catch (Exception e) {
                    mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
                    C2463fd.m5161a().mo28382a(new C2495fz(e));
                }
            }
            if (this.f5877y != null) {
                this.f5877y.mo28627b(this.f5856d);
            }
            mo28758b(2);
            mo28776k(this.f5877y);
        } catch (Exception e2) {
            mo28763c(2);
            C2514gh.m5342a(1, "InMobi", "Unable to load ad; SDK encountered an internal error");
            C2463fd.m5161a().mo28382a(new C2495fz(e2));
            mo28743a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR), false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    @androidx.annotation.UiThread
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo28755a(@androidx.annotation.Nullable byte[] r5) {
        /*
            r4 = this;
            boolean r0 = com.inmobi.media.C2515gi.m5353a()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0014
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r1 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE
            r0.<init>(r1)
            r4.mo28743a(r0, r2)
        L_0x0012:
            r1 = 1
            goto L_0x006a
        L_0x0014:
            boolean r0 = com.inmobi.media.C2532gs.m5406e()
            if (r0 != 0) goto L_0x0028
            r4.mo28722B()
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.GDPR_COMPLIANCE_ENFORCED
            r0.<init>(r3)
            r4.mo28743a(r0, r1)
            goto L_0x0012
        L_0x0028:
            int r0 = r4.f5854b
            if (r0 == r2) goto L_0x005f
            r3 = 6
            if (r0 == r3) goto L_0x0054
            r3 = 7
            if (r0 == r3) goto L_0x0054
            r3 = 8
            if (r0 == r3) goto L_0x0054
            r3 = 10
            if (r0 == r3) goto L_0x0049
            r3 = 11
            if (r0 == r3) goto L_0x006a
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.GET_SIGNALS_NOT_CALLED_FOR_LOAD_WITH_RESPONSE
            r0.<init>(r3)
            r4.mo28743a(r0, r1)
            goto L_0x0012
        L_0x0049:
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.FETCHING_SIGNALS_STATE_ERROR
            r0.<init>(r3)
            r4.mo28743a(r0, r1)
            goto L_0x0012
        L_0x0054:
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.AD_ACTIVE
            r0.<init>(r3)
            r4.mo28743a(r0, r1)
            goto L_0x0012
        L_0x005f:
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r3 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.LOAD_WITH_RESPONSE_CALLED_WHILE_LOADING
            r0.<init>(r3)
            r4.mo28743a(r0, r1)
            goto L_0x0012
        L_0x006a:
            if (r1 == 0) goto L_0x006d
            return
        L_0x006d:
            if (r5 == 0) goto L_0x008f
            int r0 = r5.length
            if (r0 != 0) goto L_0x0073
            goto L_0x008f
        L_0x0073:
            com.inmobi.media.ba r0 = r4.f5866n
            if (r0 != 0) goto L_0x0082
            com.inmobi.ads.InMobiAdRequestStatus r5 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r0 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR
            r5.<init>(r0)
            r4.mo28743a(r5, r2)
            return
        L_0x0082:
            r4.f5854b = r2
            java.util.concurrent.ExecutorService r1 = r4.f5860h
            com.inmobi.media.u r2 = new com.inmobi.media.u
            r2.<init>(r0, r5)
            r1.submit(r2)
            return
        L_0x008f:
            com.inmobi.ads.InMobiAdRequestStatus r5 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r0 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INVALID_RESPONSE_IN_LOAD
            r5.<init>(r0)
            r4.mo28743a(r5, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2620l.mo28755a(byte[]):void");
    }

    @UiThread
    /* renamed from: U */
    private int mo28819U() {
        try {
            this.f5854b = 1;
            Context d = mo28767d();
            if (d != null) {
                C2568hj a = C2568hj.m5581a();
                if (a.f5661b && C2568hj.m5584f().f5317a) {
                    if (a.f5660a == null) {
                        a.f5660a = new C2558hf(d);
                    }
                    a.f5660a.mo28553a(C2568hj.m5584f());
                }
            }
            C2538gx.m5429a().mo28480c();
            this.f5860h.submit(new C2619k(this, mo28721A()));
            return 0;
        } catch (Exception e) {
            C2514gh.m5342a(1, "InMobi", "Unable to load ad; SDK encountered an unexpected error");
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return -2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28751a(WeakReference<C2636a> weakReference) {
        this.f5854b = 3;
        mo28729I();
        if (!this.f5865m) {
            C2636a aVar = (C2636a) weakReference.get();
            if (aVar != null) {
                if ("int".equals(mo28771g())) {
                    aVar.mo28809c();
                } else {
                    aVar.mo27778a(this, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                }
            } else {
                C2514gh.m5342a(2, "InMobi", "Listener was garbage collected. Unable to give callback");
            }
        }
    }

    /* renamed from: a */
    public final void mo28526a(C2600j jVar) {
        if (!this.f5865m && mo28767d() != null) {
            this.f5862j.post(new Runnable() {
                public final void run() {
                    C2620l.this.mo28724D();
                }
            });
        }
    }

    /* renamed from: b */
    public final void mo28530b(C2600j jVar) {
        if (!this.f5865m && mo28767d() != null) {
            this.f5862j.post(new Runnable() {
                public final void run() {
                    C2620l.this.mo28725E();
                }
            });
        }
    }

    /* renamed from: c */
    public void mo28533c(C2600j jVar) {
        if (this.f5865m || mo28767d() == null) {
        }
    }

    /* renamed from: d */
    public void mo28534d(C2600j jVar) {
        if (this.f5865m || mo28767d() == null) {
        }
    }

    /* renamed from: e */
    public void mo28535e(C2600j jVar) {
        if (!this.f5865m && mo28767d() != null) {
            this.f5862j.post(new Runnable() {
                public final void run() {
                    if (7 == C2620l.this.mo28770f()) {
                        C2620l lVar = C2620l.this;
                        lVar.f5854b = 3;
                        if (lVar.mo28777l() != null) {
                            C2620l.this.mo28777l().mo28809c();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: f */
    public void mo28536f(C2600j jVar) {
        if (this.f5865m || mo28767d() == null) {
        }
    }

    /* renamed from: g */
    public void mo28537g(C2600j jVar) {
        if (this.f5865m || mo28767d() == null) {
        }
    }

    /* renamed from: h */
    public void mo28538h(final C2600j jVar) {
        if (!this.f5865m && mo28767d() != null) {
            try {
                this.f5862j.post(new Runnable() {
                    public final void run() {
                        C2620l.this.mo28726F();
                    }
                });
            } catch (Exception unused) {
                C2514gh.m5342a(1, "InMobi", "Unable to load ad; SDK encountered an internal error");
            }
        }
    }

    /* renamed from: a */
    public void mo28527a(C2600j jVar, @NonNull HashMap<Object, Object> hashMap) {
        if (!this.f5865m && mo28767d() != null && mo28777l() != null) {
            mo28777l().mo27787b((Map<Object, Object>) hashMap);
        }
    }

    /* renamed from: b */
    public void mo28531b(C2600j jVar, @NonNull HashMap<Object, Object> hashMap) {
        if (!this.f5865m && mo28767d() != null && mo28777l() != null) {
            mo28777l().mo27780a((Map<Object, Object>) hashMap);
        }
    }

    /* renamed from: i */
    public void mo28539i(C2600j jVar) {
        if (!this.f5865m && mo28767d() != null && mo28777l() != null) {
            mo28777l().mo27794g();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5801a(C2620l lVar, C2153ac acVar, String str) {
        acVar.mo27808a(str);
        C2162aj ajVar = lVar.f5868p;
        if (ajVar != null) {
            ajVar.mo27872a(acVar);
        }
    }
}
