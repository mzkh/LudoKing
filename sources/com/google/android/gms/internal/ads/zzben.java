package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzben implements zzdwb<WeakReference<Context>> {
    private final zzbel zzejv;

    public zzben(zzbel zzbel) {
        this.zzejv = zzbel;
    }

    public final /* synthetic */ Object get() {
        return (WeakReference) zzdwh.zza(this.zzejv.zzabq(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
