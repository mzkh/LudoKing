package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
abstract class zzdrq {
    private static final zzdrq zzhml = new zzdrs();
    private static final zzdrq zzhmm = new zzdrr();

    private zzdrq() {
    }

    /* access modifiers changed from: 0000 */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: 0000 */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zzb(Object obj, long j);

    static zzdrq zzbap() {
        return zzhml;
    }

    static zzdrq zzbaq() {
        return zzhmm;
    }
}
