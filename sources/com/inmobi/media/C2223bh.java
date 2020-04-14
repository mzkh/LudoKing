package com.inmobi.media;

import android.os.Build.VERSION;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bh */
/* compiled from: NativeGifAsset */
public class C2223bh extends C2214bc {

    /* renamed from: A */
    private static final String f4596A = "bh";

    /* renamed from: z */
    public C2353dw f4597z;

    C2223bh(String str, String str2, C2215bd bdVar, String str3, int i, JSONObject jSONObject) {
        this(str, str2, bdVar, str3, new LinkedList(), i, jSONObject);
    }

    C2223bh(String str, String str2, C2215bd bdVar, String str3, List<C2234bo> list, int i, JSONObject jSONObject) {
        super(str, str2, "GIF", bdVar, list);
        C2169am.m4358a();
        C2154ad b = C2169am.m4361b(str3);
        this.f4525e = b == null ? null : b.f4337e;
        if (b != null) {
            try {
                String str4 = b.f4337e;
                this.f4597z = VERSION.SDK_INT < 28 ? new C2355dx(str4) : new C2347du(str4);
            } catch (Exception e) {
                this.f4597z = null;
                C2463fd.m5161a().mo28382a(new C2495fz(e));
            }
        }
        if (jSONObject != null) {
            this.f4529i = i;
            this.f4526f = jSONObject;
        }
    }
}
