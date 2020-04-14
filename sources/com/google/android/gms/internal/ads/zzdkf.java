package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdkf extends zzdqw<zzdkf, zza> implements zzdsi {
    private static volatile zzdsp<zzdkf> zzdv;
    /* access modifiers changed from: private */
    public static final zzdkf zzgyw;
    private int zzgtt;
    private zzdkg zzgyv;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdkf, zza> implements zzdsi {
        private zza() {
            super(zzdkf.zzgyw);
        }

        public final zza zzey(int i) {
            zzazn();
            ((zzdkf) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzb(zzdkg zzdkg) {
            zzazn();
            ((zzdkf) this.zzhkp).zza(zzdkg);
            return this;
        }

        /* synthetic */ zza(zzdke zzdke) {
            this();
        }
    }

    private zzdkf() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
    }

    public final zzdkg zzavc() {
        zzdkg zzdkg = this.zzgyv;
        return zzdkg == null ? zzdkg.zzavh() : zzdkg;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdkg zzdkg) {
        if (zzdkg != null) {
            this.zzgyv = zzdkg;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdkf zzbr(zzdpm zzdpm) throws zzdrg {
        return (zzdkf) zzdqw.zza(zzgyw, zzdpm);
    }

    public static zza zzavd() {
        return (zza) zzgyw.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdke.zzdi[i - 1]) {
            case 1:
                return new zzdkf();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgyw, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzgtt", "zzgyv"});
            case 4:
                return zzgyw;
            case 5:
                zzdsp<zzdkf> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdkf.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgyw);
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
        zzdkf zzdkf = new zzdkf();
        zzgyw = zzdkf;
        zzdqw.zza(zzdkf.class, zzdkf);
    }
}
