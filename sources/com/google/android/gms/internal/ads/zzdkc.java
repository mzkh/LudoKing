package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdkc extends zzdqw<zzdkc, zza> implements zzdsi {
    private static volatile zzdsp<zzdkc> zzdv;
    /* access modifiers changed from: private */
    public static final zzdkc zzgyu;
    private String zzgyt = "";

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdkc, zza> implements zzdsi {
        private zza() {
            super(zzdkc.zzgyu);
        }

        /* synthetic */ zza(zzdkd zzdkd) {
            this();
        }
    }

    private zzdkc() {
    }

    public final String zzauz() {
        return this.zzgyt;
    }

    public static zzdkc zzbq(zzdpm zzdpm) throws zzdrg {
        return (zzdkc) zzdqw.zza(zzgyu, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdkd.zzdi[i - 1]) {
            case 1:
                return new zzdkc();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgyu, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzgyt"});
            case 4:
                return zzgyu;
            case 5:
                zzdsp<zzdkc> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdkc.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgyu);
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

    public static zzdkc zzava() {
        return zzgyu;
    }

    static {
        zzdkc zzdkc = new zzdkc();
        zzgyu = zzdkc;
        zzdqw.zza(zzdkc.class, zzdkc);
    }
}
