package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdjt extends zzdqw<zzdjt, zza> implements zzdsi {
    private static volatile zzdsp<zzdjt> zzdv;
    /* access modifiers changed from: private */
    public static final zzdjt zzgyb;
    private String zzgxj = "";
    private zzdpm zzgxk = zzdpm.zzhgb;
    private int zzgya;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdjt, zza> implements zzdsi {
        private zza() {
            super(zzdjt.zzgyb);
        }

        /* synthetic */ zza(zzdjs zzdjs) {
            this();
        }
    }

    private zzdjt() {
    }

    public final String zzatu() {
        return this.zzgxj;
    }

    public final zzdpm zzatv() {
        return this.zzgxk;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdjs.zzdi[i - 1]) {
            case 1:
                return new zzdjt();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgyb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgxj", "zzgxk", "zzgya"});
            case 4:
                return zzgyb;
            case 5:
                zzdsp<zzdjt> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdjt.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgyb);
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

    public static zzdjt zzaua() {
        return zzgyb;
    }

    static {
        zzdjt zzdjt = new zzdjt();
        zzgyb = zzdjt;
        zzdqw.zza(zzdjt.class, zzdjt);
    }
}
