package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdis extends zzdqw<zzdis, zza> implements zzdsi {
    private static volatile zzdsp<zzdis> zzdv;
    /* access modifiers changed from: private */
    public static final zzdis zzgwh;
    private int zzgtt;
    private zzdpm zzgub = zzdpm.zzhgb;
    private zzdit zzgwg;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdis, zza> implements zzdsi {
        private zza() {
            super(zzdis.zzgwh);
        }

        public final zza zzeg(int i) {
            zzazn();
            ((zzdis) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzb(zzdit zzdit) {
            zzazn();
            ((zzdis) this.zzhkp).zza(zzdit);
            return this;
        }

        public final zza zzbc(zzdpm zzdpm) {
            zzazn();
            ((zzdis) this.zzhkp).zzw(zzdpm);
            return this;
        }

        /* synthetic */ zza(zzdir zzdir) {
            this();
        }
    }

    private zzdis() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
    }

    public final zzdit zzasv() {
        zzdit zzdit = this.zzgwg;
        return zzdit == null ? zzdit.zzasz() : zzdit;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdit zzdit) {
        if (zzdit != null) {
            this.zzgwg = zzdit;
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

    public static zzdis zzba(zzdpm zzdpm) throws zzdrg {
        return (zzdis) zzdqw.zza(zzgwh, zzdpm);
    }

    public static zza zzasw() {
        return (zza) zzgwh.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdir.zzdi[i - 1]) {
            case 1:
                return new zzdis();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgwh, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgtt", "zzgwg", "zzgub"});
            case 4:
                return zzgwh;
            case 5:
                zzdsp<zzdis> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdis.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgwh);
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
        zzdis zzdis = new zzdis();
        zzgwh = zzdis;
        zzdqw.zza(zzdis.class, zzdis);
    }
}
