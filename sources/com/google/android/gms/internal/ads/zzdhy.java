package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdhy extends zzdqw<zzdhy, zza> implements zzdsi {
    private static volatile zzdsp<zzdhy> zzdv;
    /* access modifiers changed from: private */
    public static final zzdhy zzgvb;
    private int zzgtt;
    private zzdpm zzgub = zzdpm.zzhgb;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdhy, zza> implements zzdsi {
        private zza() {
            super(zzdhy.zzgvb);
        }

        public final zza zzec(int i) {
            zzazn();
            ((zzdhy) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzaq(zzdpm zzdpm) {
            zzazn();
            ((zzdhy) this.zzhkp).zzw(zzdpm);
            return this;
        }

        /* synthetic */ zza(zzdhx zzdhx) {
            this();
        }
    }

    private zzdhy() {
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

    public static zzdhy zzap(zzdpm zzdpm) throws zzdrg {
        return (zzdhy) zzdqw.zza(zzgvb, zzdpm);
    }

    public static zza zzaru() {
        return (zza) zzgvb.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdhx.zzdi[i - 1]) {
            case 1:
                return new zzdhy();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgvb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzgtt", "zzgub"});
            case 4:
                return zzgvb;
            case 5:
                zzdsp<zzdhy> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdhy.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgvb);
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
        zzdhy zzdhy = new zzdhy();
        zzgvb = zzdhy;
        zzdqw.zza(zzdhy.class, zzdhy);
    }
}
