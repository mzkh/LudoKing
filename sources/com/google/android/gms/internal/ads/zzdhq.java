package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdhq extends zzdqw<zzdhq, zza> implements zzdsi {
    private static volatile zzdsp<zzdhq> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhq zzgux;
    private int zzgtt;
    private zzdpm zzgub = zzdpm.zzhgb;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdhq, zza> implements zzdsi {
        private zza() {
            super(zzdhq.zzgux);
        }

        public final zza zzdz(int i) {
            zzazn();
            ((zzdhq) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzal(zzdpm zzdpm) {
            zzazn();
            ((zzdhq) this.zzhkp).zzw(zzdpm);
            return this;
        }

        /* synthetic */ zza(zzdhp zzdhp) {
            this();
        }
    }

    private zzdhq() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
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

    public static zzdhq zzaj(zzdpm zzdpm) throws zzdrg {
        return (zzdhq) zzdqw.zza(zzgux, zzdpm);
    }

    public static zza zzaro() {
        return (zza) zzgux.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhp.zzdi[i - 1]) {
            case 1:
                return new zzdhq();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgux, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzgtt", "zzgub"});
            case 4:
                return zzgux;
            case 5:
                zzdsp<zzdhq> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdhq.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgux);
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
        zzdhq zzdhq = new zzdhq();
        zzgux = zzdhq;
        zzdqw.zza(zzdhq.class, zzdhq);
    }
}
