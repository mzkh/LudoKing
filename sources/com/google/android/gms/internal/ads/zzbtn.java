package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbtn implements zzdwb<Set<String>> {
    private final zzdwo<zzbuy> zzfdw;

    public zzbtn(zzdwo<zzbuy> zzdwo) {
        this.zzfdw = zzdwo;
    }

    public final /* synthetic */ Object get() {
        Set set;
        if (((zzbuy) this.zzfdw.get()).zzaih() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzdwh.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
