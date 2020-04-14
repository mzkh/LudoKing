package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdrv implements zzdsd {
    private zzdsd[] zzhms;

    zzdrv(zzdsd... zzdsdArr) {
        this.zzhms = zzdsdArr;
    }

    public final boolean zzc(Class<?> cls) {
        for (zzdsd zzc : this.zzhms) {
            if (zzc.zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzdse zzd(Class<?> cls) {
        zzdsd[] zzdsdArr;
        for (zzdsd zzdsd : this.zzhms) {
            if (zzdsd.zzc(cls)) {
                return zzdsd.zzd(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
