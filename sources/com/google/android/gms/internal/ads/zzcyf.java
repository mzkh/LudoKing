package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcyf extends zzbpm<zzcym> implements zzcye<zzcyd> {
    zzcyf(Set<zzbqs<zzcym>> set) {
        super(set);
    }

    public final void zza(zzcxp<zzcyd, ?> zzcxp) {
        zza((zzbpo<ListenerT>) new zzcyi<ListenerT>(zzcxp));
    }

    public final void zzb(zzcxp<zzcyd, ?> zzcxp) {
        zza((zzbpo<ListenerT>) new zzcyh<ListenerT>(zzcxp));
    }

    public final void zza(zzcxp<zzcyd, ?> zzcxp, Throwable th) {
        zza((zzbpo<ListenerT>) new zzcyk<ListenerT>(zzcxp, th));
    }

    public final void zzc(zzcxp<zzcyd, ?> zzcxp) {
        zza((zzbpo<ListenerT>) new zzcyj<ListenerT>(zzcxp));
    }
}
