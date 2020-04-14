package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdhb extends zzdqw<zzdhb, zza> implements zzdsi {
    private static volatile zzdsp<zzdhb> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhb zzguo;
    private int zzgun;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdhb, zza> implements zzdsi {
        private zza() {
            super(zzdhb.zzguo);
        }

        /* synthetic */ zza(zzdhc zzdhc) {
            this();
        }
    }

    private zzdhb() {
    }

    public final int zzaqz() {
        return this.zzgun;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhc.zzdi[i - 1]) {
            case 1:
                return new zzdhb();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzguo, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgun"});
            case 4:
                return zzguo;
            case 5:
                zzdsp<zzdhb> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdhb.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzguo);
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

    public static zzdhb zzara() {
        return zzguo;
    }

    static {
        zzdhb zzdhb = new zzdhb();
        zzguo = zzdhb;
        zzdqw.zza(zzdhb.class, zzdhb);
    }
}
