package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzna {
    public final zzmk zzbee;
    public final zzmv zzbef;
    public final Object zzbeg;
    public final zzgz[] zzbeh;

    public zzna(zzmk zzmk, zzmv zzmv, Object obj, zzgz[] zzgzArr) {
        this.zzbee = zzmk;
        this.zzbef = zzmv;
        this.zzbeg = obj;
        this.zzbeh = zzgzArr;
    }

    public final boolean zza(zzna zzna, int i) {
        if (zzna != null && zzof.zza(this.zzbef.zzax(i), zzna.zzbef.zzax(i)) && zzof.zza(this.zzbeh[i], zzna.zzbeh[i])) {
            return true;
        }
        return false;
    }
}
