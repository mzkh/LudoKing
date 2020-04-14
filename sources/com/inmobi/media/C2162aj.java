package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.aj */
/* compiled from: AdSet */
public final class C2162aj {

    /* renamed from: a */
    private static final String f4385a = "aj";
    @NonNull

    /* renamed from: b */
    private final String f4386b;
    @NonNull

    /* renamed from: c */
    private final String f4387c;

    /* renamed from: d */
    private boolean f4388d;

    /* renamed from: e */
    private final long f4389e;

    /* renamed from: f */
    private final String f4390f;
    @NonNull

    /* renamed from: g */
    private final String f4391g;
    @NonNull

    /* renamed from: h */
    private LinkedList<C2153ac> f4392h = new LinkedList<>();

    /* renamed from: i */
    private long f4393i = System.currentTimeMillis();

    /* renamed from: j */
    private final long f4394j;

    /* renamed from: k */
    private String f4395k;

    /* renamed from: l */
    private final String f4396l;
    @Nullable

    /* renamed from: m */
    private JSONObject f4397m;

    /* renamed from: n */
    private boolean f4398n;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e A[Catch:{ JSONException -> 0x0091 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f A[Catch:{ JSONException -> 0x0091 }] */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.inmobi.media.C2162aj m4325a(org.json.JSONObject r17, long r18, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.inmobi.media.C2276cf r24) {
        /*
            r0 = r17
            r1 = 0
            java.lang.String r2 = "adSetId"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r3 = "adSetAuctionMeta"
            java.lang.String r13 = r0.optString(r3, r1)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r3 = "expiry"
            r4 = -1
            long r6 = r0.optLong(r3, r4)     // Catch:{ JSONException -> 0x0091 }
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x002a
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x0022
            goto L_0x002a
        L_0x0022:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ JSONException -> 0x0091 }
            long r3 = r3.toMillis(r6)     // Catch:{ JSONException -> 0x0091 }
            r15 = r3
            goto L_0x002b
        L_0x002a:
            r15 = r4
        L_0x002b:
            java.lang.String r3 = "ads"
            org.json.JSONArray r14 = r0.getJSONArray(r3)     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r3 = "isAuctionClosed"
            r4 = 1
            boolean r6 = r0.optBoolean(r3, r4)     // Catch:{ JSONException -> 0x0091 }
            int r0 = r14.length()     // Catch:{ JSONException -> 0x0091 }
            if (r0 != 0) goto L_0x003f
            return r1
        L_0x003f:
            com.inmobi.media.aj r0 = new com.inmobi.media.aj     // Catch:{ JSONException -> 0x0091 }
            r3 = r0
            r4 = r2
            r5 = r22
            r7 = r18
            r9 = r20
            r10 = r15
            r12 = r21
            r17 = r14
            r14 = r23
            r3.<init>(r4, r5, r6, r7, r9, r10, r12, r13, r14)     // Catch:{ JSONException -> 0x0091 }
            r9 = 0
            r10 = 0
        L_0x0055:
            int r3 = r17.length()     // Catch:{ JSONException -> 0x0091 }
            if (r10 >= r3) goto L_0x0077
            r11 = r17
            org.json.JSONObject r3 = r11.getJSONObject(r10)     // Catch:{ JSONException -> 0x0091 }
            r4 = r20
            r5 = r2
            r6 = r24
            r7 = r15
            com.inmobi.media.ac r3 = com.inmobi.media.C2158ag.m4281a(r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x0091 }
            if (r3 == 0) goto L_0x0072
            java.util.LinkedList<com.inmobi.media.ac> r4 = r0.f4392h     // Catch:{ JSONException -> 0x0091 }
            r4.add(r3)     // Catch:{ JSONException -> 0x0091 }
        L_0x0072:
            int r10 = r10 + 1
            r17 = r11
            goto L_0x0055
        L_0x0077:
            java.util.LinkedList<com.inmobi.media.ac> r2 = r0.f4392h     // Catch:{ JSONException -> 0x0091 }
            boolean r2 = r2.isEmpty()     // Catch:{ JSONException -> 0x0091 }
            if (r2 != 0) goto L_0x008d
            java.util.LinkedList<com.inmobi.media.ac> r3 = r0.f4392h     // Catch:{ JSONException -> 0x0091 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ JSONException -> 0x0091 }
            com.inmobi.media.ac r3 = (com.inmobi.media.C2153ac) r3     // Catch:{ JSONException -> 0x0091 }
            boolean r3 = r3.mo27822m()     // Catch:{ JSONException -> 0x0091 }
            r0.f4398n = r3     // Catch:{ JSONException -> 0x0091 }
        L_0x008d:
            if (r2 == 0) goto L_0x0090
            return r1
        L_0x0090:
            return r0
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C2162aj.m4325a(org.json.JSONObject, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.inmobi.media.cf):com.inmobi.media.aj");
    }

    @VisibleForTesting
    private C2162aj(@NonNull String str, @NonNull String str2, boolean z, long j, String str3, long j2, @NonNull String str4, String str5, String str6) {
        this.f4386b = str;
        this.f4387c = str2;
        this.f4388d = z;
        this.f4389e = j;
        this.f4390f = str3;
        this.f4391g = str4;
        this.f4394j = j2;
        this.f4395k = str5;
        this.f4396l = str6;
    }

    @NonNull
    /* renamed from: a */
    public final LinkedList<C2153ac> mo27871a() {
        return this.f4392h;
    }

    /* renamed from: b */
    public final boolean mo27875b() {
        return this.f4388d;
    }

    @NonNull
    /* renamed from: c */
    public final String mo27876c() {
        return this.f4386b;
    }

    /* renamed from: d */
    public final String mo27877d() {
        return this.f4390f;
    }

    /* renamed from: e */
    public final String mo27878e() {
        return this.f4395k;
    }

    @NonNull
    /* renamed from: f */
    public final String mo27879f() {
        return this.f4387c;
    }

    /* renamed from: g */
    public final String mo27880g() {
        return this.f4396l;
    }

    /* renamed from: h */
    public final long mo27881h() {
        return this.f4389e;
    }

    /* renamed from: i */
    public final boolean mo27882i() {
        return this.f4398n;
    }

    @Nullable
    /* renamed from: j */
    public final C2153ac mo27883j() {
        try {
            if (!this.f4392h.isEmpty()) {
                this.f4392h.removeFirst();
            }
        } catch (Exception unused) {
        }
        return mo27884k();
    }

    @Nullable
    /* renamed from: k */
    public final C2153ac mo27884k() {
        try {
            if (this.f4392h.isEmpty()) {
                return null;
            }
            return (C2153ac) this.f4392h.getFirst();
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: a */
    private C2153ac m4324a(@NonNull String str) {
        Iterator it = this.f4392h.iterator();
        while (it.hasNext()) {
            C2153ac acVar = (C2153ac) it.next();
            if (str.equals(acVar.mo27815f())) {
                return acVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo27874a(@NonNull JSONObject jSONObject, @NonNull C2426eq eqVar) throws JSONException {
        if (!this.f4388d) {
            String string = jSONObject.getString("requestId");
            JSONArray jSONArray = jSONObject.getJSONArray("ads");
            if (this.f4387c.equals(string)) {
                int length = jSONArray.length();
                if (length != 0) {
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String string2 = jSONObject2.getString("impressionId");
                        this.f4397m = jSONObject2.optJSONObject("macros");
                        C2153ac a = m4324a(string2);
                        if (a != null) {
                            a.mo27809a(this.f4397m);
                            C2153ac a2 = C2158ag.m4279a(a, eqVar);
                            if (a2 != null) {
                                JSONObject jSONObject3 = this.f4397m;
                                if (jSONObject3 != null) {
                                    String str = "${advPrice}";
                                    String str2 = "transaction";
                                    if (jSONObject3.has(str)) {
                                        String string3 = this.f4397m.getString(str);
                                        try {
                                            JSONObject jSONObject4 = new JSONObject(a2.f4319a);
                                            JSONObject optJSONObject = jSONObject4.optJSONObject(str2);
                                            if (optJSONObject != null) {
                                                optJSONObject.put("buyerPrice", Double.parseDouble(string3));
                                                jSONObject4.put(str2, optJSONObject);
                                                a2.f4319a = jSONObject4.toString();
                                            }
                                        } catch (Exception e) {
                                            C2463fd.m5161a().mo28382a(new C2495fz(e));
                                        }
                                    }
                                    String str3 = "${ctxhash}";
                                    if (this.f4397m.has(str3)) {
                                        String string4 = this.f4397m.getString(str3);
                                        try {
                                            JSONObject jSONObject5 = new JSONObject(a2.f4319a);
                                            JSONObject optJSONObject2 = jSONObject5.optJSONObject(str2);
                                            if (optJSONObject2 != null) {
                                                optJSONObject2.put("ctxHash", string4);
                                                jSONObject5.put(str2, optJSONObject2);
                                                a2.f4319a = jSONObject5.toString();
                                            }
                                        } catch (JSONException e2) {
                                            C2463fd.m5161a().mo28382a(new C2495fz(e2));
                                        }
                                    }
                                }
                                linkedList.add(a2);
                            }
                        }
                    }
                    this.f4392h.clear();
                    this.f4392h.addAll(linkedList);
                    if (!this.f4392h.isEmpty()) {
                        this.f4388d = true;
                        return;
                    }
                    throw new IllegalArgumentException("No matching ads to render");
                }
                throw new IllegalArgumentException("UAS response supplied doesn't have any ads");
            }
            throw new IllegalArgumentException("UAS response supplied was of a different requestId");
        }
        throw new IllegalStateException("Auction was already closed. Can't process UAS response");
    }

    @Nullable
    /* renamed from: l */
    public final JSONObject mo27885l() {
        return this.f4397m;
    }

    /* renamed from: a */
    public final void mo27873a(@NonNull C2426eq eqVar, C2295cp cpVar) {
        C2153ac k = mo27884k();
        if (k != null) {
            C2291co a = C2291co.m4660a();
            a.f4830a.execute(new Runnable(k, eqVar, cpVar) {

                /* renamed from: a */
                final /* synthetic */ C2153ac f4832a;

                /* renamed from: b */
                final /* synthetic */ C2426eq f4833b;

                /* renamed from: c */
                final /* synthetic */ C2295cp f4834c;

                {
                    this.f4832a = r2;
                    this.f4833b = r3;
                    this.f4834c = r4;
                }

                public final void run() {
                    C2291co.m4662a(C2291co.this, this.f4832a, this.f4833b, this.f4834c);
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo27872a(C2153ac acVar) {
        try {
            if (mo27884k() != null) {
                this.f4392h.removeFirst();
            }
        } catch (Exception unused) {
        }
        this.f4392h.addFirst(acVar);
    }
}
