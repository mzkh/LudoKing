package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdit extends zzdqw<zzdit, zza> implements zzdsi {
    private static volatile zzdsp<zzdit> zzdv;
    /* access modifiers changed from: private */
    public static final zzdit zzgwi;
    private int zzgtt;
    private zzdpm zzgvq = zzdpm.zzhgb;
    private zzdpm zzgvr = zzdpm.zzhgb;
    private zzdip zzgwa;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdit, zza> implements zzdsi {
        private zza() {
            super(zzdit.zzgwi);
        }

        public final zza zzeh(int i) {
            zzazn();
            ((zzdit) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzc(zzdip zzdip) {
            zzazn();
            ((zzdit) this.zzhkp).zzb(zzdip);
            return this;
        }

        public final zza zzbd(zzdpm zzdpm) {
            zzazn();
            ((zzdit) this.zzhkp).zzau(zzdpm);
            return this;
        }

        public final zza zzbe(zzdpm zzdpm) {
            zzazn();
            ((zzdit) this.zzhkp).zzav(zzdpm);
            return this;
        }

        /* synthetic */ zza(zzdiu zzdiu) {
            this();
        }
    }

    private zzdit() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
    }

    public final zzdip zzaso() {
        zzdip zzdip = this.zzgwa;
        return zzdip == null ? zzdip.zzast() : zzdip;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdip zzdip) {
        if (zzdip != null) {
            this.zzgwa = zzdip;
            return;
        }
        throw new NullPointerException();
    }

    public final zzdpm zzasg() {
        return this.zzgvq;
    }

    /* access modifiers changed from: private */
    public final void zzau(zzdpm zzdpm) {
        if (zzdpm != null) {
            this.zzgvq = zzdpm;
            return;
        }
        throw new NullPointerException();
    }

    public final zzdpm zzash() {
        return this.zzgvr;
    }

    /* access modifiers changed from: private */
    public final void zzav(zzdpm zzdpm) {
        if (zzdpm != null) {
            this.zzgvr = zzdpm;
            return;
        }
        throw new NullPointerException();
    }

    public static zzdit zzbb(zzdpm zzdpm) throws zzdrg {
        return (zzdit) zzdqw.zza(zzgwi, zzdpm);
    }

    public static zza zzasy() {
        return (zza) zzgwi.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdiu.zzdi[i - 1]) {
            case 1:
                return new zzdit();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgwi, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzgtt", "zzgwa", "zzgvq", "zzgvr"});
            case 4:
                return zzgwi;
            case 5:
                zzdsp<zzdit> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdit.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgwi);
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

    public static zzdit zzasz() {
        return zzgwi;
    }

    static {
        zzdit zzdit = new zzdit();
        zzgwi = zzdit;
        zzdqw.zza(zzdit.class, zzdit);
    }
}
