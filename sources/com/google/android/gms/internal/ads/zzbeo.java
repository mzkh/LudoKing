package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbeo implements zzdwb<Context> {
    private final zzbel zzejv;

    public zzbeo(zzbel zzbel) {
        this.zzejv = zzbel;
    }

    public static Context zza(zzbel zzbel) {
        return (Context) zzdwh.zza(zzbel.zzabp(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzejv);
    }
}
