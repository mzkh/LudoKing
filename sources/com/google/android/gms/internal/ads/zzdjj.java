package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdjj extends zzdqw<zzdjj, zza> implements zzdsi {
    private static volatile zzdsp<zzdjj> zzdv;
    /* access modifiers changed from: private */
    public static final zzdjj zzgxf;
    private int zzgud;
    private zzdjm zzgxd;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdjj, zza> implements zzdsi {
        private zza() {
            super(zzdjj.zzgxf);
        }

        /* synthetic */ zza(zzdjk zzdjk) {
            this();
        }
    }

    private zzdjj() {
    }

    public final zzdjm zzatk() {
        zzdjm zzdjm = this.zzgxd;
        return zzdjm == null ? zzdjm.zzats() : zzdjm;
    }

    public final int getKeySize() {
        return this.zzgud;
    }

    public static zzdjj zzbl(zzdpm zzdpm) throws zzdrg {
        return (zzdjj) zzdqw.zza(zzgxf, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdjk.zzdi[i - 1]) {
            case 1:
                return new zzdjj();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgxf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgxd", "zzgud"});
            case 4:
                return zzgxf;
            case 5:
                zzdsp<zzdjj> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdjj.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgxf);
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

    public static zzdjj zzato() {
        return zzgxf;
    }

    static {
        zzdjj zzdjj = new zzdjj();
        zzgxf = zzdjj;
        zzdqw.zza(zzdjj.class, zzdjj);
    }
}
