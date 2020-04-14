package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzd;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdqu implements zzdsd {
    private static final zzdqu zzhkm = new zzdqu();

    private zzdqu() {
    }

    public static zzdqu zzazl() {
        return zzhkm;
    }

    public final boolean zzc(Class<?> cls) {
        return zzdqw.class.isAssignableFrom(cls);
    }

    public final zzdse zzd(Class<?> cls) {
        if (!zzdqw.class.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (zzdse) zzdqw.zzf(cls.asSubclass(zzdqw.class)).zza(zzd.zzhkx, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}
