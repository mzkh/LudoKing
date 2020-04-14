package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdrr extends zzdrq {
    private zzdrr() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        zzdrd zzc = zzc(obj, j);
        if (zzc.zzaxi()) {
            return zzc;
        }
        int size = zzc.size();
        zzdrd zzfl = zzc.zzfl(size == 0 ? 10 : size << 1);
        zzdtt.zza(obj, j, (Object) zzfl);
        return zzfl;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzaxj();
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzdrd zzc = zzc(obj, j);
        zzdrd zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzaxi()) {
                zzc = zzc.zzfl(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzdtt.zza(obj, j, (Object) zzc2);
    }

    private static <E> zzdrd<E> zzc(Object obj, long j) {
        return (zzdrd) zzdtt.zzp(obj, j);
    }
}
