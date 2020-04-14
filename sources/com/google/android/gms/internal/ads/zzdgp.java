package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdgp extends zzdqw<zzdgp, zza> implements zzdsi {
    private static volatile zzdsp<zzdgp> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgp zzgtz;
    private zzdha zzgtx;
    private zzdjj zzgty;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdgp, zza> implements zzdsi {
        private zza() {
            super(zzdgp.zzgtz);
        }

        /* synthetic */ zza(zzdgq zzdgq) {
            this();
        }
    }

    private zzdgp() {
    }

    public final zzdha zzaqf() {
        zzdha zzdha = this.zzgtx;
        return zzdha == null ? zzdha.zzaqx() : zzdha;
    }

    public final zzdjj zzaqg() {
        zzdjj zzdjj = this.zzgty;
        return zzdjj == null ? zzdjj.zzato() : zzdjj;
    }

    public static zzdgp zzv(zzdpm zzdpm) throws zzdrg {
        return (zzdgp) zzdqw.zza(zzgtz, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgq.zzdi[i - 1]) {
            case 1:
                return new zzdgp();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgtz, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzgtx", "zzgty"});
            case 4:
                return zzgtz;
            case 5:
                zzdsp<zzdgp> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdgp.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgtz);
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
        zzdgp zzdgp = new zzdgp();
        zzgtz = zzdgp;
        zzdqw.zza(zzdgp.class, zzdgp);
    }
}
