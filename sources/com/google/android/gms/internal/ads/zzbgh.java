package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbgh implements zzdwb<zzczf> {
    private final zzdwo<Context> zzejy;

    public zzbgh(zzdwo<Context> zzdwo) {
        this.zzejy = zzdwo;
    }

    public final /* synthetic */ Object get() {
        return (zzczf) zzdwh.zza(new zzczf((Context) this.zzejy.get(), zzq.zzkx().zzwd()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
