package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ck */
/* compiled from: VastCompanionAd */
public class C2284ck {

    /* renamed from: f */
    static final ArrayList<String> f4794f = new ArrayList<>(Arrays.asList(new String[]{"image/jpeg", "image/png"}));
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final String f4795h = "ck";

    /* renamed from: a */
    int f4796a;

    /* renamed from: b */
    int f4797b;

    /* renamed from: c */
    List<C2285a> f4798c = new ArrayList();

    /* renamed from: d */
    public List<C2234bo> f4799d = new ArrayList();

    /* renamed from: e */
    public String f4800e;

    /* renamed from: g */
    public boolean f4801g;
    @Nullable

    /* renamed from: i */
    private String f4802i;

    /* renamed from: com.inmobi.media.ck$a */
    /* compiled from: VastCompanionAd */
    public static final class C2285a {

        /* renamed from: a */
        public int f4803a;

        /* renamed from: b */
        public String f4804b;

        C2285a(int i, String str) {
            this.f4803a = i;
            this.f4804b = str;
        }

        /* renamed from: a */
        static C2285a m4636a(JSONObject jSONObject) {
            try {
                String string = jSONObject.getString("type");
                int i = 0;
                if (string != null) {
                    if (string.trim().length() != 0) {
                        String lowerCase = string.toLowerCase(Locale.US);
                        char c = 65535;
                        switch (lowerCase.hashCode()) {
                            case -1191214428:
                                if (lowerCase.equals("iframe")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -892481938:
                                if (lowerCase.equals("static")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -284840886:
                                if (lowerCase.equals("unknown")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 3213227:
                                if (lowerCase.equals(String.HTML)) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        if (c == 2) {
                            i = 1;
                        } else if (c == 3) {
                            i = 2;
                        } else if (c == 4) {
                            i = 3;
                        }
                    }
                }
                return new C2285a(i, jSONObject.getString("content"));
            } catch (JSONException e) {
                C2284ck.f4795h;
                C2463fd.m5161a().mo28382a(new C2495fz(e));
                return null;
            }
        }

        public final String toString() {
            JSONObject jSONObject = new JSONObject();
            String str = "type";
            try {
                int i = this.f4803a;
                String str2 = i != 1 ? i != 2 ? i != 3 ? "unknown" : "iframe" : String.HTML : "static";
                jSONObject.put(str, str2);
                jSONObject.put("content", this.f4804b);
                return jSONObject.toString();
            } catch (JSONException e) {
                C2284ck.f4795h;
                C2463fd.m5161a().mo28382a(new C2495fz(e));
                return "";
            }
        }
    }

    public C2284ck(int i, int i2, String str, @Nullable String str2) {
        this.f4802i = str2;
        this.f4796a = i;
        this.f4797b = i2;
        this.f4800e = str;
    }

    @NonNull
    /* renamed from: a */
    public final List<C2285a> mo28121a(int i) {
        ArrayList arrayList = new ArrayList();
        for (C2285a aVar : this.f4798c) {
            if (aVar.f4803a == i) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo28124a(@NonNull C2285a aVar) {
        this.f4798c.add(aVar);
    }

    @NonNull
    /* renamed from: a */
    public final List<C2234bo> mo28122a(String str) {
        ArrayList arrayList = new ArrayList();
        for (C2234bo boVar : this.f4799d) {
            if (boVar.f4631d.equals(str)) {
                arrayList.add(boVar);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo28123a(@NonNull C2234bo boVar) {
        this.f4799d.add(boVar);
    }

    @Nullable
    /* renamed from: a */
    public static C2284ck m4630a(JSONObject jSONObject) {
        String str = "clickThroughUrl";
        try {
            C2284ck ckVar = new C2284ck(jSONObject.getInt("width"), jSONObject.getInt("height"), jSONObject.has(str) ? jSONObject.getString(str) : null, jSONObject.optString("id", null));
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.getString("trackers"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    C2234bo a = C2338dn.m4842a(new JSONObject(jSONArray.getString(i)));
                    if (a != null) {
                        ckVar.mo28123a(a);
                    }
                }
            } catch (JSONException e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
            try {
                JSONArray jSONArray2 = new JSONArray(jSONObject.getString("resources"));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    C2285a a2 = C2285a.m4636a(new JSONObject(jSONArray2.getString(i2)));
                    if (a2 != null) {
                        ckVar.mo28124a(a2);
                    }
                }
            } catch (JSONException e2) {
                C2463fd.m5161a().mo28382a(new C2495fz(e2));
            }
            return ckVar;
        } catch (JSONException e3) {
            C2463fd.m5161a().mo28382a(new C2495fz(e3));
            return null;
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f4802i != null) {
                jSONObject.put("id", this.f4802i);
            }
            jSONObject.put("width", this.f4796a);
            jSONObject.put("height", this.f4797b);
            jSONObject.put("clickThroughUrl", this.f4800e);
            JSONArray jSONArray = new JSONArray();
            for (C2285a aVar : this.f4798c) {
                jSONArray.put(aVar.toString());
            }
            jSONObject.put("resources", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (C2234bo boVar : this.f4799d) {
                jSONArray2.put(boVar.toString());
            }
            jSONObject.put("trackers", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e) {
            C2463fd.m5161a().mo28382a(new C2495fz(e));
            return "";
        }
    }
}
