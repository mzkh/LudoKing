package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcod implements zzdwb<zzcob> {
    private final zzdwo<Set<String>> zzgeh;

    private zzcod(zzdwo<Set<String>> zzdwo) {
        this.zzgeh = zzdwo;
    }

    public static zzcod zzai(zzdwo<Set<String>> zzdwo) {
        return new zzcod(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzcob((Set) this.zzgeh.get());
    }
}
