package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdju extends zzdqw<zzdju, zza> implements zzdsi {
    private static volatile zzdsp<zzdju> zzdv;
    /* access modifiers changed from: private */
    public static final zzdju zzgyg;
    private String zzgxj;
    private String zzgyc;
    private int zzgyd;
    private boolean zzgye;
    private String zzgyf;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdju, zza> implements zzdsi {
        private zza() {
            super(zzdju.zzgyg);
        }

        public final zza zzgz(String str) {
            zzazn();
            ((zzdju) this.zzhkp).zzgx(str);
            return this;
        }

        public final zza zzha(String str) {
            zzazn();
            ((zzdju) this.zzhkp).zzgv(str);
            return this;
        }

        public final zza zzeq(int i) {
            zzazn();
            ((zzdju) this.zzhkp).zzep(0);
            return this;
        }

        public final zza zzbg(boolean z) {
            zzazn();
            ((zzdju) this.zzhkp).zzbf(true);
            return this;
        }

        public final zza zzhb(String str) {
            zzazn();
            ((zzdju) this.zzhkp).zzgy(str);
            return this;
        }

        /* synthetic */ zza(zzdjv zzdjv) {
            this();
        }
    }

    private zzdju() {
        String str = "";
        this.zzgyc = str;
        this.zzgxj = str;
        this.zzgyf = str;
    }

    public final String zzauc() {
        return this.zzgyc;
    }

    /* access modifiers changed from: private */
    public final void zzgx(String str) {
        if (str != null) {
            this.zzgyc = str;
            return;
        }
        throw new NullPointerException();
    }

    public final String zzatu() {
        return this.zzgxj;
    }

    /* access modifiers changed from: private */
    public final void zzgv(String str) {
        if (str != null) {
            this.zzgxj = str;
            return;
        }
        throw new NullPointerException();
    }

    public final int zzaud() {
        return this.zzgyd;
    }

    /* access modifiers changed from: private */
    public final void zzep(int i) {
        this.zzgyd = i;
    }

    public final boolean zzaue() {
        return this.zzgye;
    }

    /* access modifiers changed from: private */
    public final void zzbf(boolean z) {
        this.zzgye = z;
    }

    public final String zzauf() {
        return this.zzgyf;
    }

    /* access modifiers changed from: private */
    public final void zzgy(String str) {
        if (str != null) {
            this.zzgyf = str;
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzaug() {
        return (zza) zzgyg.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdjv.zzdi[i - 1]) {
            case 1:
                return new zzdju();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgyg, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzgyc", "zzgxj", "zzgyd", "zzgye", "zzgyf"});
            case 4:
                return zzgyg;
            case 5:
                zzdsp<zzdju> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdju.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgyg);
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
        zzdju zzdju = new zzdju();
        zzgyg = zzdju;
        zzdqw.zza(zzdju.class, zzdju);
    }
}
