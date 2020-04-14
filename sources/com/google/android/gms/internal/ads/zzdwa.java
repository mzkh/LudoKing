package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdwa {
    private static int zzhn(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <T> List<T> zzhk(int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i);
    }

    static <T> HashSet<T> zzhl(int i) {
        return new HashSet<>(zzhn(i));
    }

    public static <K, V> LinkedHashMap<K, V> zzhm(int i) {
        return new LinkedHashMap<>(zzhn(i));
    }
}
