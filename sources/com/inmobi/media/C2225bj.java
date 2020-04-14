package com.inmobi.media;

import com.facebook.share.internal.ShareConstants;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bj */
/* compiled from: NativeImageAsset */
public final class C2225bj extends C2214bc {
    public C2225bj(String str, String str2, C2215bd bdVar, String str3, int i, JSONObject jSONObject) {
        this(str, str2, bdVar, str3, new LinkedList(), i, jSONObject);
    }

    public C2225bj(String str, String str2, C2215bd bdVar, String str3, List<C2234bo> list, int i, JSONObject jSONObject) {
        super(str, str2, ShareConstants.IMAGE_URL, bdVar, list);
        this.f4525e = str3;
        if (jSONObject != null) {
            this.f4529i = i;
            this.f4526f = jSONObject;
        }
    }
}
