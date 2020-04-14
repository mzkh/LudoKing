package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbud implements zzdwb<zzbqv> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcvr> zzfes;

    public zzbud(zzdwo<Context> zzdwo, zzdwo<zzcvr> zzdwo2) {
        this.zzejy = zzdwo;
        this.zzfes = zzdwo2;
    }

    public final /* synthetic */ Object get() {
        return (zzbqv) zzdwh.zza(new zzbqv((Context) this.zzejy.get(), new HashSet(), (zzcvr) this.zzfes.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
