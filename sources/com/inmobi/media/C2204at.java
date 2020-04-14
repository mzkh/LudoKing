package com.inmobi.media;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.at */
/* compiled from: NativeVideoAd */
public class C2204at extends C2153ac {

    /* renamed from: e */
    private static final String f4499e = "at";

    /* renamed from: b */
    public final String f4500b;

    /* renamed from: c */
    public final String f4501c;

    /* renamed from: d */
    public final String f4502d;

    /* renamed from: f */
    private final String f4503f;

    /* renamed from: g */
    private final String f4504g;

    C2204at(C2153ac acVar, String str, String str2, String str3, String str4, String str5, String str6) {
        super(acVar, str);
        this.f4500b = str2;
        this.f4501c = str3;
        this.f4502d = str4;
        this.f4503f = str5;
        this.f4504g = str6;
    }

    @NonNull
    /* renamed from: w */
    public final List<C2234bo> mo27931w() {
        ArrayList arrayList = new ArrayList();
        String str = this.f4503f;
        if (!(str == null || str.length() == 0)) {
            try {
                JSONArray jSONArray = new JSONArray(this.f4503f);
                if (jSONArray.length() == 0) {
                    return arrayList;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    C2234bo a = C2338dn.m4842a(new JSONObject(jSONArray.getString(i)));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: x */
    public final List<C2284ck> mo27932x() {
        ArrayList arrayList = new ArrayList();
        String str = this.f4504g;
        if (!(str == null || str.length() == 0)) {
            try {
                JSONArray jSONArray = new JSONArray(this.f4504g);
                if (jSONArray.length() == 0) {
                    return arrayList;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    C2284ck a = C2284ck.m4630a(new JSONObject(jSONArray.getString(i)));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
        return arrayList;
    }
}
