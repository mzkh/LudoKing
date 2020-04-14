package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdji extends zzdqw<zzdji, zza> implements zzdsi {
    private static volatile zzdsp<zzdji> zzdv;
    /* access modifiers changed from: private */
    public static final zzdji zzgxe;
    private int zzgtt;
    private zzdpm zzgub = zzdpm.zzhgb;
    private zzdjm zzgxd;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdji, zza> implements zzdsi {
        private zza() {
            super(zzdji.zzgxe);
        }

        public final zza zzem(int i) {
            zzazn();
            ((zzdji) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzc(zzdjm zzdjm) {
            zzazn();
            ((zzdji) this.zzhkp).zzb(zzdjm);
            return this;
        }

        public final zza zzbm(zzdpm zzdpm) {
            zzazn();
            ((zzdji) this.zzhkp).zzw(zzdpm);
            return this;
        }

        /* synthetic */ zza(zzdjh zzdjh) {
            this();
        }
    }

    private zzdji() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
    }

    public final zzdjm zzatk() {
        zzdjm zzdjm = this.zzgxd;
        return zzdjm == null ? zzdjm.zzats() : zzdjm;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdjm zzdjm) {
        if (zzdjm != null) {
            this.zzgxd = zzdjm;
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

    public static zzdji zzbk(zzdpm zzdpm) throws zzdrg {
        return (zzdji) zzdqw.zza(zzgxe, zzdpm);
    }

    public static zza zzatl() {
        return (zza) zzgxe.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdjh.zzdi[i - 1]) {
            case 1:
                return new zzdji();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgxe, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgtt", "zzgxd", "zzgub"});
            case 4:
                return zzgxe;
            case 5:
                zzdsp<zzdji> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdji.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgxe);
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

    public static zzdji zzatm() {
        return zzgxe;
    }

    static {
        zzdji zzdji = new zzdji();
        zzgxe = zzdji;
        zzdqw.zza(zzdji.class, zzdji);
    }
}
