package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdjc extends zzdqw<zzdjc, zza> implements zzdsi {
    private static volatile zzdsp<zzdjc> zzdv;
    /* access modifiers changed from: private */
    public static final zzdjc zzgwv;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdjc, zza> implements zzdsi {
        private zza() {
            super(zzdjc.zzgwv);
        }

        /* synthetic */ zza(zzdje zzdje) {
            this();
        }
    }

    private zzdjc() {
    }

    public static zzdjc zzbj(zzdpm zzdpm) throws zzdrg {
        return (zzdjc) zzdqw.zza(zzgwv, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdje.zzdi[i - 1]) {
            case 1:
                return new zzdjc();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgwv, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzgwv;
            case 5:
                zzdsp<zzdjc> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdjc.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgwv);
                            zzdv = zzdsp;
                        }
                    }
                }
                return zzdsp;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzdjc zzdjc = new zzdjc();
        zzgwv = zzdjc;
        zzdqw.zza(zzdjc.class, zzdjc);
    }
}
