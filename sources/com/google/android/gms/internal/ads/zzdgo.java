package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdgo extends zzdqw<zzdgo, zza> implements zzdsi {
    private static volatile zzdsp<zzdgo> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgo zzgtw;
    private int zzgtt;
    private zzdgx zzgtu;
    private zzdji zzgtv;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdgo, zza> implements zzdsi {
        private zza() {
            super(zzdgo.zzgtw);
        }

        public final zza zzdu(int i) {
            zzazn();
            ((zzdgo) this.zzhkp).setVersion(i);
            return this;
        }

        public final zza zzb(zzdgx zzdgx) {
            zzazn();
            ((zzdgo) this.zzhkp).zza(zzdgx);
            return this;
        }

        public final zza zzb(zzdji zzdji) {
            zzazn();
            ((zzdgo) this.zzhkp).zza(zzdji);
            return this;
        }

        /* synthetic */ zza(zzdgn zzdgn) {
            this();
        }
    }

    private zzdgo() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
    }

    public final zzdgx zzaqb() {
        zzdgx zzdgx = this.zzgtu;
        return zzdgx == null ? zzdgx.zzaqv() : zzdgx;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdgx zzdgx) {
        if (zzdgx != null) {
            this.zzgtu = zzdgx;
            return;
        }
        throw new NullPointerException();
    }

    public final zzdji zzaqc() {
        zzdji zzdji = this.zzgtv;
        return zzdji == null ? zzdji.zzatm() : zzdji;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdji zzdji) {
        if (zzdji != null) {
            this.zzgtv = zzdji;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdgo zzu(zzdpm zzdpm) throws zzdrg {
        return (zzdgo) zzdqw.zza(zzgtw, zzdpm);
    }

    public static zza zzaqd() {
        return (zza) zzgtw.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgn.zzdi[i - 1]) {
            case 1:
                return new zzdgo();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgtw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzgtt", "zzgtu", "zzgtv"});
            case 4:
                return zzgtw;
            case 5:
                zzdsp<zzdgo> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdgo.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgtw);
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
        zzdgo zzdgo = new zzdgo();
        zzgtw = zzdgo;
        zzdqw.zza(zzdgo.class, zzdgo);
    }
}
