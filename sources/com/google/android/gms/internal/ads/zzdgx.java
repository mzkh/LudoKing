package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdgx extends zzdqw<zzdgx, zza> implements zzdsi {
    private static volatile zzdsp<zzdgx> zzdv;
    /* access modifiers changed from: private */
    public static final zzdgx zzgul;
    private int zzgtt;
    private zzdpm zzgub = zzdpm.zzhgb;
    private zzdhb zzguk;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdgx, zza> implements zzdsi {
        private zza() {
            super(zzdgx.zzgul);
        }

        public final zza zzdw(int i) {
            zzazn();
            ((zzdgx) this.zzhkp).setVersion(0);
            return this;
        }

        public final zza zzc(zzdhb zzdhb) {
            zzazn();
            ((zzdgx) this.zzhkp).zzb(zzdhb);
            return this;
        }

        public final zza zzab(zzdpm zzdpm) {
            zzazn();
            ((zzdgx) this.zzhkp).zzw(zzdpm);
            return this;
        }

        /* synthetic */ zza(zzdgy zzdgy) {
            this();
        }
    }

    private zzdgx() {
    }

    public final int getVersion() {
        return this.zzgtt;
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzgtt = i;
    }

    public final zzdhb zzaqt() {
        zzdhb zzdhb = this.zzguk;
        return zzdhb == null ? zzdhb.zzara() : zzdhb;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzdhb zzdhb) {
        if (zzdhb != null) {
            this.zzguk = zzdhb;
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

    public static zzdgx zzaa(zzdpm zzdpm) throws zzdrg {
        return (zzdgx) zzdqw.zza(zzgul, zzdpm);
    }

    public static zza zzaqu() {
        return (zza) zzgul.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdgy.zzdi[i - 1]) {
            case 1:
                return new zzdgx();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgul, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzgtt", "zzguk", "zzgub"});
            case 4:
                return zzgul;
            case 5:
                zzdsp<zzdgx> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdgx.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgul);
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

    public static zzdgx zzaqv() {
        return zzgul;
    }

    static {
        zzdgx zzdgx = new zzdgx();
        zzgul = zzdgx;
        zzdqw.zza(zzdgx.class, zzdgx);
    }
}
