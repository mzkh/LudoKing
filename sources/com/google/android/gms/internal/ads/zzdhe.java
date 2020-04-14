package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdhe extends zzdqw<zzdhe, zza> implements zzdsi {
    private static volatile zzdsp<zzdhe> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhe zzguq;
    private int zzgtt;
    private zzdpm zzgub = zzdpm.zzhgb;
    private zzdhi zzgup;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdhe, zza> implements zzdsi {
        private zza() {
            super(zzdhe.zzguq);
        }

        public final zza zzdx(int i) {
            zzazn();
            ((zzdhe) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzb(zzdhi zzdhi) {
            zzazn();
            ((zzdhe) this.zzhkp).zza(zzdhi);
            return this;
        }

        public final zza zzaf(zzdpm zzdpm) {
            zzazn();
            ((zzdhe) this.zzhkp).zzw(zzdpm);
            return this;
        }

        /* synthetic */ zza(zzdhd zzdhd) {
            this();
        }
    }

    private zzdhe() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
    }

    public final zzdhi zzarc() {
        zzdhi zzdhi = this.zzgup;
        return zzdhi == null ? zzdhi.zzarg() : zzdhi;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdhi zzdhi) {
        if (zzdhi != null) {
            this.zzgup = zzdhi;
            return;
        }
        throw new NullPointerException();
    }

    public final zzdpm zzaqj() {
        return this.zzgub;
    }

    /* access modifiers changed from: private */
    public final void zzw(zzdpm zzdpm) {
        if (zzdpm != null) {
            this.zzgub = zzdpm;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdhe zzad(zzdpm zzdpm) throws zzdrg {
        return (zzdhe) zzdqw.zza(zzguq, zzdpm);
    }

    public static zza zzard() {
        return (zza) zzguq.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhd.zzdi[i - 1]) {
            case 1:
                return new zzdhe();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzguq, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgtt", "zzgup", "zzgub"});
            case 4:
                return zzguq;
            case 5:
                zzdsp<zzdhe> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdhe.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzguq);
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
        zzdhe zzdhe = new zzdhe();
        zzguq = zzdhe;
        zzdqw.zza(zzdhe.class, zzdhe);
    }
}
