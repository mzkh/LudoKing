package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdwk<T> implements zzdwb<Set<T>> {
    private static final zzdwb<Set<Object>> zzhxs = zzdwe.zzbb(Collections.emptySet());
    private final List<zzdwo<T>> zzhxt;
    private final List<zzdwo<Collection<T>>> zzhxu;

    public static <T> zzdwm<T> zzaq(int i, int i2) {
        return new zzdwm<>(i, i2);
    }

    private zzdwk(List<zzdwo<T>> list, List<zzdwo<Collection<T>>> list2) {
        this.zzhxt = list;
        this.zzhxu = list2;
    }

    public final /* synthetic */ Object get() {
        int size = this.zzhxt.size();
        ArrayList arrayList = new ArrayList(this.zzhxu.size());
        int size2 = this.zzhxu.size();
        int i = size;
        for (int i2 = 0; i2 < size2; i2++) {
            Collection collection = (Collection) ((zzdwo) this.zzhxu.get(i2)).get();
            i += collection.size();
            arrayList.add(collection);
        }
        HashSet zzhl = zzdwa.zzhl(i);
        int size3 = this.zzhxt.size();
        for (int i3 = 0; i3 < size3; i3++) {
            zzhl.add(zzdwh.checkNotNull(((zzdwo) this.zzhxt.get(i3)).get()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object checkNotNull : (Collection) arrayList.get(i4)) {
                zzhl.add(zzdwh.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(zzhl);
    }
}
