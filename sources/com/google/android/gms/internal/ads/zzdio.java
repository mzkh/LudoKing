package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdio extends zzdqw<zzdio, zza> implements zzdsi {
    private static volatile zzdsp<zzdio> zzdv;
    /* access modifiers changed from: private */
    public static final zzdio zzgwb;
    private zzdip zzgwa;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdio, zza> implements zzdsi {
        private zza() {
            super(zzdio.zzgwb);
        }

        /* synthetic */ zza(zzdin zzdin) {
            this();
        }
    }

    private zzdio() {
    }

    public final zzdip zzaso() {
        zzdip zzdip = this.zzgwa;
        return zzdip == null ? zzdip.zzast() : zzdip;
    }

    public static zzdio zzaz(zzdpm zzdpm) throws zzdrg {
        return (zzdio) zzdqw.zza(zzgwb, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdin.zzdi[i - 1]) {
            case 1:
                return new zzdio();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgwb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzgwa"});
            case 4:
                return zzgwb;
            case 5:
                zzdsp<zzdio> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdio.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgwb);
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
        zzdio zzdio = new zzdio();
        zzgwb = zzdio;
        zzdqw.zza(zzdio.class, zzdio);
    }
}
