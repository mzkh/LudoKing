package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbgg implements zzdwb<zzavy> {
    private final zzdwo<Context> zzejy;

    public zzbgg(zzdwo<Context> zzdwo) {
        this.zzejy = zzdwo;
    }

    public final /* synthetic */ Object get() {
        return (zzavy) zzdwh.zza(new zzavy((Context) this.zzejy.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
