package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zznj extends zznk {
    private final int responseCode;
    private final Map<String, List<String>> zzbfl;

    public zznj(int i, Map<String, List<String>> map, zznf zznf) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i);
        super(sb.toString(), zznf, 1);
        this.responseCode = i;
        this.zzbfl = map;
    }
}
