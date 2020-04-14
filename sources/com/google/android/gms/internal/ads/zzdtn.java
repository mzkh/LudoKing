package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
abstract class zzdtn<T, B> {
    zzdtn() {
    }

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, zzdpm zzdpm);

    /* access modifiers changed from: 0000 */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zza(T t, zzduk zzduk) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract boolean zza(zzdsw zzdsw);

    /* access modifiers changed from: 0000 */
    public abstract void zzak(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract T zzaq(B b);

    /* access modifiers changed from: 0000 */
    public abstract int zzau(T t);

    /* access modifiers changed from: 0000 */
    public abstract T zzay(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract B zzaz(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: 0000 */
    public abstract int zzba(T t);

    /* access modifiers changed from: 0000 */
    public abstract B zzbbw();

    /* access modifiers changed from: 0000 */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: 0000 */
    public abstract void zzc(T t, zzduk zzduk) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zzh(Object obj, T t);

    /* access modifiers changed from: 0000 */
    public abstract void zzi(Object obj, B b);

    /* access modifiers changed from: 0000 */
    public abstract T zzj(T t, T t2);

    /* access modifiers changed from: 0000 */
    public final boolean zza(B b, zzdsw zzdsw) throws IOException {
        int tag = zzdsw.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b, i, zzdsw.zzaxw());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzdsw.zzaxy());
            return true;
        } else if (i2 == 2) {
            zza(b, i, zzdsw.zzayc());
            return true;
        } else if (i2 == 3) {
            Object zzbbw = zzbbw();
            int i3 = 4 | (i << 3);
            while (zzdsw.zzays() != Integer.MAX_VALUE) {
                if (!zza((B) zzbbw, zzdsw)) {
                    break;
                }
            }
            if (i3 == zzdsw.getTag()) {
                zza(b, i, (T) zzaq(zzbbw));
                return true;
            }
            throw zzdrg.zzbag();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzc(b, i, zzdsw.zzaxz());
                return true;
            }
            throw zzdrg.zzbah();
        }
    }
}
