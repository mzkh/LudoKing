package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdkg extends zzdqw<zzdkg, zza> implements zzdsi {
    private static volatile zzdsp<zzdkg> zzdv;
    /* access modifiers changed from: private */
    public static final zzdkg zzgyz;
    private String zzgyx = "";
    private zzdjt zzgyy;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdkg, zza> implements zzdsi {
        private zza() {
            super(zzdkg.zzgyz);
        }

        /* synthetic */ zza(zzdkh zzdkh) {
            this();
        }
    }

    private zzdkg() {
    }

    public final String zzavf() {
        return this.zzgyx;
    }

    public final zzdjt zzavg() {
        zzdjt zzdjt = this.zzgyy;
        return zzdjt == null ? zzdjt.zzaua() : zzdjt;
    }

    public static zzdkg zzbs(zzdpm zzdpm) throws zzdrg {
        return (zzdkg) zzdqw.zza(zzgyz, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdkh.zzdi[i - 1]) {
            case 1:
                return new zzdkg();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgyz, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzgyx", "zzgyy"});
            case 4:
                return zzgyz;
            case 5:
                zzdsp<zzdkg> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdkg.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgyz);
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

    public static zzdkg zzavh() {
        return zzgyz;
    }

    static {
        zzdkg zzdkg = new zzdkg();
        zzgyz = zzdkg;
        zzdqw.zza(zzdkg.class, zzdkg);
    }
}
