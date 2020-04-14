package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdkb extends zzdqw<zzdkb, zza> implements zzdsi {
    private static volatile zzdsp<zzdkb> zzdv;
    /* access modifiers changed from: private */
    public static final zzdkb zzgys;
    private int zzgtt;
    private zzdkc zzgyr;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdkb, zza> implements zzdsi {
        private zza() {
            super(zzdkb.zzgys);
        }

        public final zza zzex(int i) {
            zzazn();
            ((zzdkb) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzb(zzdkc zzdkc) {
            zzazn();
            ((zzdkb) this.zzhkp).zza(zzdkc);
            return this;
        }

        /* synthetic */ zza(zzdka zzdka) {
            this();
        }
    }

    private zzdkb() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
    }

    public final zzdkc zzauw() {
        zzdkc zzdkc = this.zzgyr;
        return zzdkc == null ? zzdkc.zzava() : zzdkc;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdkc zzdkc) {
        if (zzdkc != null) {
            this.zzgyr = zzdkc;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdkb zzbp(zzdpm zzdpm) throws zzdrg {
        return (zzdkb) zzdqw.zza(zzgys, zzdpm);
    }

    public static zza zzaux() {
        return (zza) zzgys.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdka.zzdi[i - 1]) {
            case 1:
                return new zzdkb();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgys, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzgtt", "zzgyr"});
            case 4:
                return zzgys;
            case 5:
                zzdsp<zzdkb> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdkb.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgys);
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
        zzdkb zzdkb = new zzdkb();
        zzgys = zzdkb;
        zzdqw.zza(zzdkb.class, zzdkb);
    }
}
