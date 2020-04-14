package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdha extends zzdqw<zzdha, zza> implements zzdsi {
    private static volatile zzdsp<zzdha> zzdv;
    /* access modifiers changed from: private */
    public static final zzdha zzgum;
    private int zzgud;
    private zzdhb zzguk;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdha, zza> implements zzdsi {
        private zza() {
            super(zzdha.zzgum);
        }

        /* synthetic */ zza(zzdgz zzdgz) {
            this();
        }
    }

    private zzdha() {
    }

    public final zzdhb zzaqt() {
        zzdhb zzdhb = this.zzguk;
        return zzdhb == null ? zzdhb.zzara() : zzdhb;
    }

    public final int getKeySize() {
        return this.zzgud;
    }

    public static zzdha zzac(zzdpm zzdpm) throws zzdrg {
        return (zzdha) zzdqw.zza(zzgum, zzdpm);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgz.zzdi[i - 1]) {
            case 1:
                return new zzdha();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgum, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzguk", "zzgud"});
            case 4:
                return zzgum;
            case 5:
                zzdsp<zzdha> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdha.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgum);
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

    public static zzdha zzaqx() {
        return zzgum;
    }

    static {
        zzdha zzdha = new zzdha();
        zzgum = zzdha;
        zzdqw.zza(zzdha.class, zzdha);
    }
}
