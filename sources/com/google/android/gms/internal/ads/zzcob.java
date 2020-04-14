package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcob implements zzcru<zzcrr<Bundle>> {
    private final Set<String> zzgef;

    zzcob(Set<String> set) {
        this.zzgef = set;
    }

    public final zzddi<zzcrr<Bundle>> zzalv() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zzgef) {
            arrayList.add(add);
        }
        return zzdcy.zzah(new zzcoe(arrayList));
    }
}
