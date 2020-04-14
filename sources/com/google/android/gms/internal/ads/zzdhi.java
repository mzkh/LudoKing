package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdhi extends zzdqw<zzdhi, zza> implements zzdsi {
    private static volatile zzdsp<zzdhi> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhi zzgus;
    private int zzgun;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdhi, zza> implements zzdsi {
        private zza() {
            super(zzdhi.zzgus);
        }

        /* synthetic */ zza(zzdhh zzdhh) {
            this();
        }
    }

    private zzdhi() {
    }

    public final int zzaqz() {
        return this.zzgun;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhh.zzdi[i - 1]) {
            case 1:
                return new zzdhi();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgus, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgun"});
            case 4:
                return zzgus;
            case 5:
                zzdsp<zzdhi> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdhi.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgus);
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

    public static zzdhi zzarg() {
        return zzgus;
    }

    static {
        zzdhi zzdhi = new zzdhi();
        zzgus = zzdhi;
        zzdqw.zza(zzdhi.class, zzdhi);
    }
}
