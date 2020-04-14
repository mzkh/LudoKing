package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdhr extends zzdqw<zzdhr, zza> implements zzdsi {
    private static volatile zzdsp<zzdhr> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhr zzguy;
    private int zzgud;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdhr, zza> implements zzdsi {
        private zza() {
            super(zzdhr.zzguy);
        }

        /* synthetic */ zza(zzdhs zzdhs) {
            this();
        }
    }

    private zzdhr() {
    }

    public final int getKeySize() {
        return this.zzgud;
    }

    public static zzdhr zzak(zzdpm zzdpm) throws zzdrg {
        return (zzdhr) zzdqw.zza(zzguy, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhs.zzdi[i - 1]) {
            case 1:
                return new zzdhr();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzguy, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\u000b", new Object[]{"zzgud"});
            case 4:
                return zzguy;
            case 5:
                zzdsp<zzdhr> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdhr.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzguy);
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
        zzdhr zzdhr = new zzdhr();
        zzguy = zzdhr;
        zzdqw.zza(zzdhr.class, zzdhr);
    }
}
