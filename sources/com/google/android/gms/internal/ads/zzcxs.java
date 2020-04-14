package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public abstract class zzcxs<E> {
    /* access modifiers changed from: private */
    public static final zzddi<?> zzglo = zzdcy.zzah(null);
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzfcx;
    /* access modifiers changed from: private */
    public final zzddl zzfoa;
    /* access modifiers changed from: private */
    public final zzcye<E> zzglp;

    public zzcxs(zzddl zzddl, ScheduledExecutorService scheduledExecutorService, zzcye<E> zzcye) {
        this.zzfoa = zzddl;
        this.zzfcx = scheduledExecutorService;
        this.zzglp = zzcye;
    }

    /* access modifiers changed from: protected */
    public abstract String zzv(E e);

    public final zzcxw zzu(E e) {
        return new zzcxw(this, e);
    }

    public final <I> zzcxy<I> zza(E e, zzddi<I> zzddi) {
        zzcxy zzcxy = new zzcxy(this, e, null, zzddi, Collections.singletonList(zzddi), zzddi, null);
        return zzcxy;
    }

    public final zzcxu zza(E e, zzddi<?>... zzddiArr) {
        return new zzcxu(this, e, Arrays.asList(zzddiArr));
    }
}
