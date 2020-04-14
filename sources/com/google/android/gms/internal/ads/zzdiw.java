package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdiw extends zzdqw<zzdiw, zza> implements zzdsi {
    private static volatile zzdsp<zzdiw> zzdv;
    /* access modifiers changed from: private */
    public static final zzdiw zzgwl;
    private int zzguh;
    private int zzgwj;
    private zzdpm zzgwk = zzdpm.zzhgb;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdiw, zza> implements zzdsi {
        private zza() {
            super(zzdiw.zzgwl);
        }

        /* synthetic */ zza(zzdiv zzdiv) {
            this();
        }
    }

    private zzdiw() {
    }

    public final zzdjb zzatb() {
        zzdjb zzej = zzdjb.zzej(this.zzgwj);
        return zzej == null ? zzdjb.UNRECOGNIZED : zzej;
    }

    public final zzdjg zzaqp() {
        zzdjg zzel = zzdjg.zzel(this.zzguh);
        return zzel == null ? zzdjg.UNRECOGNIZED : zzel;
    }

    public final zzdpm zzatc() {
        return this.zzgwk;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdiv.zzdi[i - 1]) {
            case 1:
                return new zzdiw();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgwl, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzgwj", "zzguh", "zzgwk"});
            case 4:
                return zzgwl;
            case 5:
                zzdsp<zzdiw> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdiw.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgwl);
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

    public static zzdiw zzatd() {
        return zzgwl;
    }

    static {
        zzdiw zzdiw = new zzdiw();
        zzgwl = zzdiw;
        zzdqw.zza(zzdiw.class, zzdiw);
    }
}
