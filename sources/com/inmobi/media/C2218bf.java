package com.inmobi.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.inmobi.media.C2226bk.C2227a;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bf */
/* compiled from: NativeCtaAsset */
public final class C2218bf extends C2226bk {

    /* renamed from: com.inmobi.media.bf$a */
    /* compiled from: NativeCtaAsset */
    public static class C2219a extends C2227a {
        C2219a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, @NonNull String str3, @NonNull String str4, int i9, String str5, String[] strArr, @Nullable C2228bl blVar) {
            String[] strArr2 = strArr;
            super(i, i2, i3, i4, i5, i6, i7, i8, str, str2, str3, str4, blVar);
            this.f4598l = i9;
            this.f4600n = Integer.MAX_VALUE;
            this.f4599m = str5.length() == 0 ? "#ff000000" : str5;
            int min = Math.min(strArr2.length, 1);
            this.f4601o = new String[min];
            System.arraycopy(strArr2, 0, this.f4601o, 0, min);
        }
    }

    C2218bf(String str, String str2, C2215bd bdVar, String str3, int i, JSONObject jSONObject) {
        this(str, str2, bdVar, str3, new LinkedList(), i, jSONObject);
    }

    C2218bf(String str, String str2, C2215bd bdVar, String str3, List<C2234bo> list, int i, JSONObject jSONObject) {
        super(str, str2, "CTA", bdVar, str3);
        mo27941a(list);
        if (jSONObject != null) {
            this.f4529i = i;
            this.f4526f = jSONObject;
        }
    }
}
