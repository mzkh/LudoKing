package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbmn implements zzdwb<Context> {
    private final zzdwo<Context> zzfgo;
    private final zzbmk zzfgv;

    private zzbmn(zzbmk zzbmk, zzdwo<Context> zzdwo) {
        this.zzfgv = zzbmk;
        this.zzfgo = zzdwo;
    }

    public static zzbmn zza(zzbmk zzbmk, zzdwo<Context> zzdwo) {
        return new zzbmn(zzbmk, zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (Context) zzdwh.zza(this.zzfgv.zzbx((Context) this.zzfgo.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
