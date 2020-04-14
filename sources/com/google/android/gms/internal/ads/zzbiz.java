package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbiz implements zzdwb<View> {
    private final zzbiv zzfec;

    public zzbiz(zzbiv zzbiv) {
        this.zzfec = zzbiv;
    }

    public static View zzb(zzbiv zzbiv) {
        return (View) zzdwh.zza(zzbiv.zzaeu(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfec);
    }
}
