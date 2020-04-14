package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbnl extends zzbpm<zzbnm> {
    public zzbnl(Set<zzbqs<zzbnm>> set) {
        super(set);
    }

    public final void zzbu(Context context) {
        zza((zzbpo<ListenerT>) new zzbno<ListenerT>(context));
    }

    public final void zzbv(Context context) {
        zza((zzbpo<ListenerT>) new zzbnn<ListenerT>(context));
    }

    public final void zzbw(Context context) {
        zza((zzbpo<ListenerT>) new zzbnq<ListenerT>(context));
    }

    public final void zza(zzbri zzbri, Executor executor) {
        zza(zzbqs.zzb(new zzbnp(this, zzbri), executor));
    }
}
