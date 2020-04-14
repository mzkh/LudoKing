package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdik extends zzdqw<zzdik, zza> implements zzdsi {
    private static volatile zzdsp<zzdik> zzdv;
    /* access modifiers changed from: private */
    public static final zzdik zzgvz;
    private zzdjt zzgvy;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdik, zza> implements zzdsi {
        private zza() {
            super(zzdik.zzgvz);
        }

        /* synthetic */ zza(zzdim zzdim) {
            this();
        }
    }

    private zzdik() {
    }

    public final zzdjt zzasl() {
        zzdjt zzdjt = this.zzgvy;
        return zzdjt == null ? zzdjt.zzaua() : zzdjt;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdim.zzdi[i - 1]) {
            case 1:
                return new zzdik();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgvz, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzgvy"});
            case 4:
                return zzgvz;
            case 5:
                zzdsp<zzdik> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdik.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgvz);
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

    public static zzdik zzasm() {
        return zzgvz;
    }

    static {
        zzdik zzdik = new zzdik();
        zzgvz = zzdik;
        zzdqw.zza(zzdik.class, zzdik);
    }
}
