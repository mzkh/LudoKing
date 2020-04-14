package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdjm extends zzdqw<zzdjm, zza> implements zzdsi {
    private static volatile zzdsp<zzdjm> zzdv;
    /* access modifiers changed from: private */
    public static final zzdjm zzgxi;
    private int zzgxg;
    private int zzgxh;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdjm, zza> implements zzdsi {
        private zza() {
            super(zzdjm.zzgxi);
        }

        /* synthetic */ zza(zzdjl zzdjl) {
            this();
        }
    }

    private zzdjm() {
    }

    public final zzdjg zzatq() {
        zzdjg zzel = zzdjg.zzel(this.zzgxg);
        return zzel == null ? zzdjg.UNRECOGNIZED : zzel;
    }

    public final int zzatr() {
        return this.zzgxh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdjl.zzdi[i - 1]) {
            case 1:
                return new zzdjm();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgxi, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzgxg", "zzgxh"});
            case 4:
                return zzgxi;
            case 5:
                zzdsp<zzdjm> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdjm.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgxi);
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

    public static zzdjm zzats() {
        return zzgxi;
    }

    static {
        zzdjm zzdjm = new zzdjm();
        zzgxi = zzdjm;
        zzdqw.zza(zzdjm.class, zzdjm);
    }
}
