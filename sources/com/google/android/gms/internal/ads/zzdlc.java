package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdlc extends zzdqw<zzdlc, zza> implements zzdsi {
    private static volatile zzdsp<zzdlc> zzdv;
    /* access modifiers changed from: private */
    public static final zzdlc zzhaj;
    private int zzgtt;
    private zzdpm zzgub = zzdpm.zzhgb;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdlc, zza> implements zzdsi {
        private zza() {
            super(zzdlc.zzhaj);
        }

        public final zza zzfe(int i) {
            zzazn();
            ((zzdlc) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzcy(zzdpm zzdpm) {
            zzazn();
            ((zzdlc) this.zzhkp).zzw(zzdpm);
            return this;
        }

        /* synthetic */ zza(zzdld zzdld) {
            this();
        }
    }

    private zzdlc() {
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

    public static zzdlc zzcv(zzdpm zzdpm) throws zzdrg {
        return (zzdlc) zzdqw.zza(zzhaj, zzdpm);
    }

    public static zza zzaws() {
        return (zza) zzhaj.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdld.zzdi[i - 1]) {
            case 1:
                return new zzdlc();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzhaj, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzgtt", "zzgub"});
            case 4:
                return zzhaj;
            case 5:
                zzdsp<zzdlc> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdlc.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzhaj);
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
        zzdlc zzdlc = new zzdlc();
        zzhaj = zzdlc;
        zzdqw.zza(zzdlc.class, zzdlc);
    }
}
