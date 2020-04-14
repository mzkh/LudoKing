package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdhf extends zzdqw<zzdhf, zza> implements zzdsi {
    private static volatile zzdsp<zzdhf> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhf zzgur;
    private int zzgud;
    private zzdhi zzgup;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdhf, zza> implements zzdsi {
        private zza() {
            super(zzdhf.zzgur);
        }

        /* synthetic */ zza(zzdhg zzdhg) {
            this();
        }
    }

    private zzdhf() {
    }

    public final zzdhi zzarc() {
        zzdhi zzdhi = this.zzgup;
        return zzdhi == null ? zzdhi.zzarg() : zzdhi;
    }

    public final int getKeySize() {
        return this.zzgud;
    }

    public static zzdhf zzae(zzdpm zzdpm) throws zzdrg {
        return (zzdhf) zzdqw.zza(zzgur, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhg.zzdi[i - 1]) {
            case 1:
                return new zzdhf();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgur, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgup", "zzgud"});
            case 4:
                return zzgur;
            case 5:
                zzdsp<zzdhf> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdhf.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgur);
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
        zzdhf zzdhf = new zzdhf();
        zzgur = zzdhf;
        zzdqw.zza(zzdhf.class, zzdhf);
    }
}
