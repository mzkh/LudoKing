package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzbk {

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zza extends zzdqw<zza, C3500zza> implements zzdsi {
        private static volatile zzdsp<zza> zzdv;
        /* access modifiers changed from: private */
        public static final zza zzdy;
        private int zzdj;
        private zzb zzdw;
        private zzc zzdx;

        /* renamed from: com.google.android.gms.internal.ads.zzbk$zza$zza reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class C3500zza extends com.google.android.gms.internal.ads.zzdqw.zza<zza, C3500zza> implements zzdsi {
            private C3500zza() {
                super(zza.zzdy);
            }

            /* synthetic */ C3500zza(zzbj zzbj) {
                this();
            }
        }

        private zza() {
        }

        public final boolean zzt() {
            return (this.zzdj & 1) != 0;
        }

        public final zzb zzu() {
            zzb zzb = this.zzdw;
            return zzb == null ? zzb.zzz() : zzb;
        }

        public final boolean zzv() {
            return (this.zzdj & 2) != 0;
        }

        public final zzc zzw() {
            zzc zzc = this.zzdx;
            return zzc == null ? zzc.zzaf() : zzc;
        }

        public static zza zza(byte[] bArr, zzdqj zzdqj) throws zzdrg {
            return (zza) zzdqw.zza(zzdy, bArr, zzdqj);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbj.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3500zza(null);
                case 3:
                    return zza((zzdsg) zzdy, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzdw", "zzdx"});
                case 4:
                    return zzdy;
                case 5:
                    zzdsp<zza> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zza.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzdy);
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
            zza zza = new zza();
            zzdy = zza;
            zzdqw.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zzb extends zzdqw<zzb, zza> implements zzdsi {
        private static volatile zzdsp<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzea;
        private int zzdj;
        private int zzdz = 2;

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzb, zza> implements zzdsi {
            private zza() {
                super(zzb.zzea);
            }

            /* synthetic */ zza(zzbj zzbj) {
                this();
            }
        }

        private zzb() {
        }

        public final zzbm zzy() {
            zzbm zze = zzbm.zze(this.zzdz);
            return zze == null ? zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD : zze;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbj.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzea, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b\f\u0000", new Object[]{"zzdj", "zzdz", zzbm.zzac()});
                case 4:
                    return zzea;
                case 5:
                    zzdsp<zzb> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzb.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzea);
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

        public static zzb zzz() {
            return zzea;
        }

        static {
            zzb zzb = new zzb();
            zzea = zzb;
            zzdqw.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zzc extends zzdqw<zzc, zza> implements zzdsi {
        private static volatile zzdsp<zzc> zzdv;
        /* access modifiers changed from: private */
        public static final zzc zzeo;
        private int zzdj;
        private String zzei;
        private String zzej;
        private String zzek;
        private String zzel;
        private String zzem;
        private String zzen;

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzc, zza> implements zzdsi {
            private zza() {
                super(zzc.zzeo);
            }

            /* synthetic */ zza(zzbj zzbj) {
                this();
            }
        }

        private zzc() {
            String str = "";
            this.zzei = str;
            this.zzej = str;
            this.zzek = str;
            this.zzel = str;
            this.zzem = str;
            this.zzen = str;
        }

        public final String zzad() {
            return this.zzei;
        }

        public final String zzae() {
            return this.zzen;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbj.zzdi[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzeo, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005", new Object[]{"zzdj", "zzei", "zzej", "zzek", "zzel", "zzem", "zzen"});
                case 4:
                    return zzeo;
                case 5:
                    zzdsp<zzc> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzc.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzeo);
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

        public static zzc zzaf() {
            return zzeo;
        }

        static {
            zzc zzc = new zzc();
            zzeo = zzc;
            zzdqw.zza(zzc.class, zzc);
        }
    }
}
