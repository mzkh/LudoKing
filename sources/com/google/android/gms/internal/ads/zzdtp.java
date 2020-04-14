package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdtp extends zzdtn<zzdtq, zzdtq> {
    zzdtp() {
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzdsw zzdsw) {
        return false;
    }

    private static void zza(Object obj, zzdtq zzdtq) {
        ((zzdqw) obj).zzhkr = zzdtq;
    }

    /* access modifiers changed from: 0000 */
    public final void zzak(Object obj) {
        ((zzdqw) obj).zzhkr.zzaxj();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int zzau(Object obj) {
        return ((zzdtq) obj).zzazu();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ int zzba(Object obj) {
        return ((zzdtq) obj).zzbbz();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzj(Object obj, Object obj2) {
        zzdtq zzdtq = (zzdtq) obj;
        zzdtq zzdtq2 = (zzdtq) obj2;
        if (zzdtq2.equals(zzdtq.zzbbx())) {
            return zzdtq;
        }
        return zzdtq.zza(zzdtq, zzdtq2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(Object obj, zzduk zzduk) throws IOException {
        ((zzdtq) obj).zza(zzduk);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, zzduk zzduk) throws IOException {
        ((zzdtq) obj).zzb(zzduk);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzi(Object obj, Object obj2) {
        zza(obj, (zzdtq) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzaz(Object obj) {
        zzdtq zzdtq = ((zzdqw) obj).zzhkr;
        if (zzdtq != zzdtq.zzbbx()) {
            return zzdtq;
        }
        zzdtq zzbby = zzdtq.zzbby();
        zza(obj, zzbby);
        return zzbby;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzay(Object obj) {
        return ((zzdqw) obj).zzhkr;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        zza(obj, (zzdtq) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzaq(Object obj) {
        zzdtq zzdtq = (zzdtq) obj;
        zzdtq.zzaxj();
        return zzdtq;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Object zzbbw() {
        return zzdtq.zzbby();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzdtq) obj).zzc((i << 3) | 3, (zzdtq) obj2);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, zzdpm zzdpm) {
        ((zzdtq) obj).zzc((i << 3) | 2, zzdpm);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzdtq) obj).zzc((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzdtq) obj).zzc((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzdtq) obj).zzc(i << 3, Long.valueOf(j));
    }
}
