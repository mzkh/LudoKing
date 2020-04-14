package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzd;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdrt implements zzdsy {
    private static final zzdsd zzhmp = new zzdrw();
    private final zzdsd zzhmo;

    public zzdrt() {
        this(new zzdrv(zzdqu.zzazl(), zzbar()));
    }

    private zzdrt(zzdsd zzdsd) {
        this.zzhmo = (zzdsd) zzdqx.zza(zzdsd, "messageInfoFactory");
    }

    public final <T> zzdsv<T> zzg(Class<T> cls) {
        zzdsx.zzi(cls);
        zzdse zzd = this.zzhmo.zzd(cls);
        if (zzd.zzbaz()) {
            if (zzdqw.class.isAssignableFrom(cls)) {
                return zzdsm.zza(zzdsx.zzbbl(), zzdqn.zzazf(), zzd.zzbba());
            }
            return zzdsm.zza(zzdsx.zzbbj(), zzdqn.zzazg(), zzd.zzbba());
        } else if (zzdqw.class.isAssignableFrom(cls)) {
            if (zza(zzd)) {
                return zzdsk.zza(cls, zzd, zzdsq.zzbbd(), zzdrq.zzbaq(), zzdsx.zzbbl(), zzdqn.zzazf(), zzdsb.zzbaw());
            }
            return zzdsk.zza(cls, zzd, zzdsq.zzbbd(), zzdrq.zzbaq(), zzdsx.zzbbl(), null, zzdsb.zzbaw());
        } else if (zza(zzd)) {
            return zzdsk.zza(cls, zzd, zzdsq.zzbbc(), zzdrq.zzbap(), zzdsx.zzbbj(), zzdqn.zzazg(), zzdsb.zzbav());
        } else {
            return zzdsk.zza(cls, zzd, zzdsq.zzbbc(), zzdrq.zzbap(), zzdsx.zzbbk(), null, zzdsb.zzbav());
        }
    }

    private static boolean zza(zzdse zzdse) {
        return zzdse.zzbay() == zzd.zzhld;
    }

    private static zzdsd zzbar() {
        try {
            return (zzdsd) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzhmp;
        }
    }
}
