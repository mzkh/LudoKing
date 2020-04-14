package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcnt implements zzcru<Object> {
    private final Executor executor;
    private final zzddi<String> zzgdz;

    public zzcnt(zzddi<String> zzddi, Executor executor2) {
        this.zzgdz = zzddi;
        this.executor = executor2;
    }

    public final zzddi<Object> zzalv() {
        return zzdcy.zzb(this.zzgdz, zzcnw.zzbkv, this.executor);
    }
}
