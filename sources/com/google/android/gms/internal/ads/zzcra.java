package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcra implements zzdwb<zzcqy> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<String> zzelu;

    private zzcra(zzdwo<Context> zzdwo, zzdwo<String> zzdwo2) {
        this.zzejy = zzdwo;
        this.zzelu = zzdwo2;
    }

    public static zzcra zzas(zzdwo<Context> zzdwo, zzdwo<String> zzdwo2) {
        return new zzcra(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcqy((Context) this.zzejy.get(), (String) this.zzelu.get());
    }
}
