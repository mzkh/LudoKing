package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzsp {

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends zzdqw<zza, zzb> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zza zzbui;
        private static volatile zzdsp<zza> zzdv;
        private zzdrd<C3513zza> zzbuh = zzazw();

        /* renamed from: com.google.android.gms.internal.ads.zzsp$zza$zza reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class C3513zza extends zzdqw<C3513zza, C3514zza> implements zzdsi {
            /* access modifiers changed from: private */
            public static final C3513zza zzbug;
            private static volatile zzdsp<C3513zza> zzdv;
            private int zzbud;
            private zzd zzbue;
            private zze zzbuf;
            private int zzdj;

            /* renamed from: com.google.android.gms.internal.ads.zzsp$zza$zza$zza reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class C3514zza extends com.google.android.gms.internal.ads.zzdqw.zza<C3513zza, C3514zza> implements zzdsi {
                private C3514zza() {
                    super(C3513zza.zzbug);
                }

                /* synthetic */ C3514zza(zzso zzso) {
                    this();
                }
            }

            private C3513zza() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzso.zzdi[i - 1]) {
                    case 1:
                        return new C3513zza();
                    case 2:
                        return new C3514zza(null);
                    case 3:
                        return zza((zzdsg) zzbug, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzbud", zzc.zzac(), "zzbue", "zzbuf"});
                    case 4:
                        return zzbug;
                    case 5:
                        zzdsp<C3513zza> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (C3513zza.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbug);
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
                C3513zza zza = new C3513zza();
                zzbug = zza;
                zzdqw.zza(C3513zza.class, zza);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zza, zzb> implements zzdsi {
            private zzb() {
                super(zza.zzbui);
            }

            /* synthetic */ zzb(zzso zzso) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum zzc implements zzdra {
            UNSPECIFIED(0),
            IN_MEMORY(1);
            
            private static final zzdqz<zzc> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zzc zzbr(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return IN_MEMORY;
            }

            public static zzdrc zzac() {
                return zzsr.zzep;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName());
                sb.append('@');
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=");
                sb.append(this.value);
                sb.append(" name=");
                sb.append(name());
                sb.append('>');
                return sb.toString();
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzsq();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzd extends zzdqw<zzd, C3515zza> implements zzdsi {
            /* access modifiers changed from: private */
            public static final zzd zzbuo;
            private static volatile zzdsp<zzd> zzdv;
            private boolean zzbum;
            private int zzbun;
            private int zzdj;

            /* renamed from: com.google.android.gms.internal.ads.zzsp$zza$zzd$zza reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class C3515zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzd, C3515zza> implements zzdsi {
                private C3515zza() {
                    super(zzd.zzbuo);
                }

                /* synthetic */ C3515zza(zzso zzso) {
                    this();
                }
            }

            private zzd() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzso.zzdi[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C3515zza(null);
                    case 3:
                        return zza((zzdsg) zzbuo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u000b\u0001", new Object[]{"zzdj", "zzbum", "zzbun"});
                    case 4:
                        return zzbuo;
                    case 5:
                        zzdsp<zzd> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zzd.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbuo);
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
                zzd zzd = new zzd();
                zzbuo = zzd;
                zzdqw.zza(zzd.class, zzd);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zze extends zzdqw<zze, C3516zza> implements zzdsi {
            /* access modifiers changed from: private */
            public static final zze zzbur;
            private static volatile zzdsp<zze> zzdv;
            private int zzbun;
            private boolean zzbup;
            private boolean zzbuq;
            private int zzdj;

            /* renamed from: com.google.android.gms.internal.ads.zzsp$zza$zze$zza reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class C3516zza extends com.google.android.gms.internal.ads.zzdqw.zza<zze, C3516zza> implements zzdsi {
                private C3516zza() {
                    super(zze.zzbur);
                }

                /* synthetic */ C3516zza(zzso zzso) {
                    this();
                }
            }

            private zze() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzso.zzdi[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C3516zza(null);
                    case 3:
                        return zza((zzdsg) zzbur, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001\u0003\u000b\u0002", new Object[]{"zzdj", "zzbup", "zzbuq", "zzbun"});
                    case 4:
                        return zzbur;
                    case 5:
                        zzdsp<zze> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zze.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbur);
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
                zze zze = new zze();
                zzbur = zze;
                zzdqw.zza(zze.class, zze);
            }
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza((zzdsg) zzbui, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbuh", C3513zza.class});
                case 4:
                    return zzbui;
                case 5:
                    zzdsp<zza> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zza.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbui);
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
            zzbui = zza;
            zzdqw.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzb extends zzdqw<zzb, C3517zzb> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzb zzbuu;
        private static volatile zzdsp<zzb> zzdv;
        private int zzbus;
        private zzm zzbut;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum zza implements zzdra {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);
            
            private static final zzdqz<zza> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zza zzbs(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
            }

            public static zzdrc zzac() {
                return zzst.zzep;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName());
                sb.append('@');
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=");
                sb.append(this.value);
                sb.append(" name=");
                sb.append(name());
                sb.append('>');
                return sb.toString();
            }

            private zza(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzss();
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzsp$zzb$zzb reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class C3517zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zzb, C3517zzb> implements zzdsi {
            private C3517zzb() {
                super(zzb.zzbuu);
            }

            /* synthetic */ C3517zzb(zzso zzso) {
                this();
            }
        }

        private zzb() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C3517zzb(null);
                case 3:
                    return zza((zzdsg) zzbuu, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzbus", zza.zzac(), "zzbut"});
                case 4:
                    return zzbuu;
                case 5:
                    zzdsp<zzb> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzb.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbuu);
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
            zzb zzb = new zzb();
            zzbuu = zzb;
            zzdqw.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzc extends zzdqw<zzc, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzc zzbvk;
        private static volatile zzdsp<zzc> zzdv;
        private String zzbvh = "";
        private zzdrd<zzb> zzbvi = zzazw();
        private int zzbvj;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzc, zza> implements zzdsi {
            private zza() {
                super(zzc.zzbvk);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzc() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbvk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001", new Object[]{"zzdj", "zzbvh", "zzbvi", zzb.class, "zzbvj", zzsv.zzac()});
                case 4:
                    return zzbvk;
                case 5:
                    zzdsp<zzc> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzc.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbvk);
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
            zzc zzc = new zzc();
            zzbvk = zzc;
            zzdqw.zza(zzc.class, zzc);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzd extends zzdqw<zzd, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzd zzbvr;
        private static volatile zzdsp<zzd> zzdv;
        private int zzbvl;
        private zzo zzbvm;
        private zzo zzbvn;
        private zzo zzbvo;
        private zzdrd<zzo> zzbvp = zzazw();
        private int zzbvq;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzd, zza> implements zzdsi {
            private zza() {
                super(zzd.zzbvr);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzd() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbvr, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b\u0006\u0004\u0004", new Object[]{"zzdj", "zzbvl", "zzbvm", "zzbvn", "zzbvo", "zzbvp", zzo.class, "zzbvq"});
                case 4:
                    return zzbvr;
                case 5:
                    zzdsp<zzd> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzd.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbvr);
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
            zzd zzd = new zzd();
            zzbvr = zzd;
            zzdqw.zza(zzd.class, zzd);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zze extends zzdqw<zze, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zze zzbwa;
        private static volatile zzdsp<zze> zzdv;
        private String zzbvw = "";
        private int zzbvx;
        private zzdrb zzbvy = zzazv();
        private zzo zzbvz;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zze, zza> implements zzdsi {
            private zza() {
                super(zze.zzbwa);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zze() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbwa, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0016\u0004\t\u0002", new Object[]{"zzdj", "zzbvw", "zzbvx", zzsv.zzac(), "zzbvy", "zzbvz"});
                case 4:
                    return zzbwa;
                case 5:
                    zzdsp<zze> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zze.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbwa);
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
            zze zze = new zze();
            zzbwa = zze;
            zzdqw.zza(zze.class, zze);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzf extends zzdqw<zzf, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzf zzbwc;
        private static volatile zzdsp<zzf> zzdv;
        private zzdrb zzbvy = zzazv();
        private int zzbwb;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzf, zza> implements zzdsi {
            private zza() {
                super(zzf.zzbwc);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzf() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbwc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzdj", "zzbwb", zzsv.zzac(), "zzbvy"});
                case 4:
                    return zzbwc;
                case 5:
                    zzdsp<zzf> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzf.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbwc);
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
            zzf zzf = new zzf();
            zzbwc = zzf;
            zzdqw.zza(zzf.class, zzf);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzg extends zzdqw<zzg, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzg zzbwf;
        private static volatile zzdsp<zzg> zzdv;
        private zzo zzbvz;
        private int zzbwb;
        private zze zzbwd;
        private zzdrd<zzn> zzbwe = zzazw();
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzg, zza> implements zzdsi {
            private zza() {
                super(zzg.zzbwf);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzg() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbwf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\t\u0002", new Object[]{"zzdj", "zzbwd", "zzbwe", zzn.class, "zzbwb", zzsv.zzac(), "zzbvz"});
                case 4:
                    return zzbwf;
                case 5:
                    zzdsp<zzg> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzg.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbwf);
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
            zzg zzg = new zzg();
            zzbwf = zzg;
            zzdqw.zza(zzg.class, zzg);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzh extends zzdqw<zzh, zzb> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzh zzbwh;
        private static volatile zzdsp<zzh> zzdv;
        private int zzbus;
        private int zzbwg;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum zza implements zzdra {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);
            
            private static final zzdqz<zza> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zza zzbu(int i) {
                if (i == 0) {
                    return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return TWO_G;
                }
                if (i == 2) {
                    return THREE_G;
                }
                if (i != 4) {
                    return null;
                }
                return LTE;
            }

            public static zzdrc zzac() {
                return zzsx.zzep;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName());
                sb.append('@');
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=");
                sb.append(this.value);
                sb.append(" name=");
                sb.append(name());
                sb.append('>');
                return sb.toString();
            }

            private zza(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzsy();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zzh, zzb> implements zzdsi {
            private zzb() {
                super(zzh.zzbwh);
            }

            public final zzb zzb(zzc zzc) {
                zzazn();
                ((zzh) this.zzhkp).zza(zzc);
                return this;
            }

            public final zzb zzb(zza zza) {
                zzazn();
                ((zzh) this.zzhkp).zza(zza);
                return this;
            }

            /* synthetic */ zzb(zzso zzso) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum zzc implements zzdra {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);
            
            private static final zzdqz<zzc> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zzc zzbv(int i) {
                if (i == 0) {
                    return NETWORKTYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return CELL;
                }
                if (i != 2) {
                    return null;
                }
                return WIFI;
            }

            public static zzdrc zzac() {
                return zzta.zzep;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName());
                sb.append('@');
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=");
                sb.append(this.value);
                sb.append(" name=");
                sb.append(name());
                sb.append('>');
                return sb.toString();
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzsz();
            }
        }

        private zzh() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            if (zzc2 != null) {
                this.zzdj |= 1;
                this.zzbus = zzc2.zzab();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            if (zza2 != null) {
                this.zzdj |= 2;
                this.zzbwg = zza2.zzab();
                return;
            }
            throw new NullPointerException();
        }

        public static zzb zzna() {
            return (zzb) zzbwh.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza((zzdsg) zzbwh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzdj", "zzbus", zzc.zzac(), "zzbwg", zza.zzac()});
                case 4:
                    return zzbwh;
                case 5:
                    zzdsp<zzh> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzh.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbwh);
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
            zzh zzh = new zzh();
            zzbwh = zzh;
            zzdqw.zza(zzh.class, zzh);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzi extends zzdqw<zzi, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzi zzbwt;
        private static volatile zzdsp<zzi> zzdv;
        private int zzbwr;
        private zzo zzbws;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzi, zza> implements zzdsi {
            private zza() {
                super(zzi.zzbwt);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzi() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbwt, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzbwr", zzsv.zzac(), "zzbws"});
                case 4:
                    return zzbwt;
                case 5:
                    zzdsp<zzi> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzi.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbwt);
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
            zzi zzi = new zzi();
            zzbwt = zzi;
            zzdqw.zza(zzi.class, zzi);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzj extends zzdqw<zzj, zzb> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzj zzbwz;
        private static volatile zzdsp<zzj> zzdv;
        private zzdrd<zza> zzbuh = zzazw();
        private int zzbwu;
        private int zzbwv;
        private long zzbww;
        private String zzbwx;
        private long zzbwy;
        private int zzdj;
        private String zzdk;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends zzdqw<zza, C3518zza> implements zzdsi {
            private static final zzdre<Integer, zza> zzbxf = new zztb();
            /* access modifiers changed from: private */
            public static final zza zzbxn;
            private static volatile zzdsp<zza> zzdv;
            private long zzbxa;
            private int zzbxb;
            private long zzbxc;
            private long zzbxd;
            private zzdrb zzbxe = zzazv();
            private zzh zzbxg;
            private int zzbxh;
            private int zzbxi;
            private int zzbxj;
            private int zzbxk;
            private int zzbxl;
            private int zzbxm;
            private int zzdj;

            /* renamed from: com.google.android.gms.internal.ads.zzsp$zzj$zza$zza reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class C3518zza extends com.google.android.gms.internal.ads.zzdqw.zza<zza, C3518zza> implements zzdsi {
                private C3518zza() {
                    super(zza.zzbxn);
                }

                public final C3518zza zzeo(long j) {
                    zzazn();
                    ((zza) this.zzhkp).setTimestamp(j);
                    return this;
                }

                public final C3518zza zzf(zzsv zzsv) {
                    zzazn();
                    ((zza) this.zzhkp).zza(zzsv);
                    return this;
                }

                public final C3518zza zzep(long j) {
                    zzazn();
                    ((zza) this.zzhkp).zzek(j);
                    return this;
                }

                public final C3518zza zzeq(long j) {
                    zzazn();
                    ((zza) this.zzhkp).zzel(j);
                    return this;
                }

                public final C3518zza zzd(Iterable<? extends zza> iterable) {
                    zzazn();
                    ((zza) this.zzhkp).zzb(iterable);
                    return this;
                }

                public final C3518zza zzb(zzh zzh) {
                    zzazn();
                    ((zza) this.zzhkp).zza(zzh);
                    return this;
                }

                public final C3518zza zzg(zzsv zzsv) {
                    zzazn();
                    ((zza) this.zzhkp).zzb(zzsv);
                    return this;
                }

                public final C3518zza zzh(zzsv zzsv) {
                    zzazn();
                    ((zza) this.zzhkp).zzc(zzsv);
                    return this;
                }

                public final C3518zza zzi(zzsv zzsv) {
                    zzazn();
                    ((zza) this.zzhkp).zzd(zzsv);
                    return this;
                }

                public final C3518zza zzcb(int i) {
                    zzazn();
                    ((zza) this.zzhkp).zzby(i);
                    return this;
                }

                public final C3518zza zzj(zzsv zzsv) {
                    zzazn();
                    ((zza) this.zzhkp).zze(zzsv);
                    return this;
                }

                public final C3518zza zzb(zzc zzc) {
                    zzazn();
                    ((zza) this.zzhkp).zza(zzc);
                    return this;
                }

                /* synthetic */ C3518zza(zzso zzso) {
                    this();
                }
            }

            private zza() {
            }

            public final long getTimestamp() {
                return this.zzbxa;
            }

            /* access modifiers changed from: private */
            public final void setTimestamp(long j) {
                this.zzdj |= 1;
                this.zzbxa = j;
            }

            public final zzsv zznf() {
                zzsv zzbt = zzsv.zzbt(this.zzbxb);
                return zzbt == null ? zzsv.ENUM_FALSE : zzbt;
            }

            /* access modifiers changed from: private */
            public final void zza(zzsv zzsv) {
                if (zzsv != null) {
                    this.zzdj |= 2;
                    this.zzbxb = zzsv.zzab();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzek(long j) {
                this.zzdj |= 4;
                this.zzbxc = j;
            }

            /* access modifiers changed from: private */
            public final void zzel(long j) {
                this.zzdj |= 8;
                this.zzbxd = j;
            }

            /* access modifiers changed from: private */
            public final void zzb(Iterable<? extends zza> iterable) {
                if (!this.zzbxe.zzaxi()) {
                    this.zzbxe = zzdqw.zza(this.zzbxe);
                }
                for (zza zzab : iterable) {
                    this.zzbxe.zzgp(zzab.zzab());
                }
            }

            /* access modifiers changed from: private */
            public final void zza(zzh zzh) {
                if (zzh != null) {
                    this.zzbxg = zzh;
                    this.zzdj |= 16;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzb(zzsv zzsv) {
                if (zzsv != null) {
                    this.zzdj |= 32;
                    this.zzbxh = zzsv.zzab();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzc(zzsv zzsv) {
                if (zzsv != null) {
                    this.zzdj |= 64;
                    this.zzbxi = zzsv.zzab();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzd(zzsv zzsv) {
                if (zzsv != null) {
                    this.zzdj |= 128;
                    this.zzbxj = zzsv.zzab();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzby(int i) {
                this.zzdj |= 256;
                this.zzbxk = i;
            }

            /* access modifiers changed from: private */
            public final void zze(zzsv zzsv) {
                if (zzsv != null) {
                    this.zzdj |= 512;
                    this.zzbxl = zzsv.zzab();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zza(zzc zzc) {
                if (zzc != null) {
                    this.zzdj |= 1024;
                    this.zzbxm = zzc.zzab();
                    return;
                }
                throw new NullPointerException();
            }

            public static zza zzg(byte[] bArr) throws zzdrg {
                return (zza) zzdqw.zza(zzbxn, bArr);
            }

            public static C3518zza zzng() {
                return (C3518zza) zzbxn.zzazt();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzso.zzdi[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C3518zza(null);
                    case 3:
                        return zza((zzdsg) zzbxn, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\u0002\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u001e\u0006\t\u0004\u0007\f\u0005\b\f\u0006\t\f\u0007\n\u0004\b\u000b\f\t\f\f\n", new Object[]{"zzdj", "zzbxa", "zzbxb", zzsv.zzac(), "zzbxc", "zzbxd", "zzbxe", zza.zzac(), "zzbxg", "zzbxh", zzsv.zzac(), "zzbxi", zzsv.zzac(), "zzbxj", zzsv.zzac(), "zzbxk", "zzbxl", zzsv.zzac(), "zzbxm", zzc.zzac()});
                    case 4:
                        return zzbxn;
                    case 5:
                        zzdsp<zza> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zza.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbxn);
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
                zzbxn = zza;
                zzdqw.zza(zza.class, zza);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zzj, zzb> implements zzdsi {
            private zzb() {
                super(zzj.zzbwz);
            }

            public final zzb zzc(Iterable<? extends zza> iterable) {
                zzazn();
                ((zzj) this.zzhkp).zza(iterable);
                return this;
            }

            public final zzb zzbz(int i) {
                zzazn();
                ((zzj) this.zzhkp).zzbw(i);
                return this;
            }

            public final zzb zzca(int i) {
                zzazn();
                ((zzj) this.zzhkp).zzbx(i);
                return this;
            }

            public final zzb zzem(long j) {
                zzazn();
                ((zzj) this.zzhkp).zzei(j);
                return this;
            }

            public final zzb zzbv(String str) {
                zzazn();
                ((zzj) this.zzhkp).zzm(str);
                return this;
            }

            public final zzb zzbw(String str) {
                zzazn();
                ((zzj) this.zzhkp).zzbu(str);
                return this;
            }

            public final zzb zzen(long j) {
                zzazn();
                ((zzj) this.zzhkp).zzej(j);
                return this;
            }

            /* synthetic */ zzb(zzso zzso) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum zzc implements zzdra {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);
            
            private static final zzdqz<zzc> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zzc zzcc(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i == 1) {
                    return CONNECTING;
                }
                if (i == 2) {
                    return CONNECTED;
                }
                if (i == 3) {
                    return DISCONNECTING;
                }
                if (i == 4) {
                    return DISCONNECTED;
                }
                if (i != 5) {
                    return null;
                }
                return SUSPENDED;
            }

            public static zzdrc zzac() {
                return zztd.zzep;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName());
                sb.append('@');
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=");
                sb.append(this.value);
                sb.append(" name=");
                sb.append(name());
                sb.append('>');
                return sb.toString();
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zzeg = new zztc();
            }
        }

        private zzj() {
            String str = "";
            this.zzdk = str;
            this.zzbwx = str;
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zza> iterable) {
            if (!this.zzbuh.zzaxi()) {
                this.zzbuh = zzdqw.zza(this.zzbuh);
            }
            zzdpf.zza(iterable, this.zzbuh);
        }

        /* access modifiers changed from: private */
        public final void zzbw(int i) {
            this.zzdj |= 1;
            this.zzbwu = i;
        }

        /* access modifiers changed from: private */
        public final void zzbx(int i) {
            this.zzdj |= 2;
            this.zzbwv = i;
        }

        /* access modifiers changed from: private */
        public final void zzei(long j) {
            this.zzdj |= 4;
            this.zzbww = j;
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            if (str != null) {
                this.zzdj |= 8;
                this.zzdk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzbu(String str) {
            if (str != null) {
                this.zzdj |= 16;
                this.zzbwx = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzej(long j) {
            this.zzdj |= 32;
            this.zzbwy = j;
        }

        public static zzb zznd() {
            return (zzb) zzbwz.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza((zzdsg) zzbwz, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0000\u0003\u0004\u0001\u0004\u0002\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005", new Object[]{"zzdj", "zzbuh", zza.class, "zzbwu", "zzbwv", "zzbww", "zzdk", "zzbwx", "zzbwy"});
                case 4:
                    return zzbwz;
                case 5:
                    zzdsp<zzj> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzj.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbwz);
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
            zzj zzj = new zzj();
            zzbwz = zzj;
            zzdqw.zza(zzj.class, zzj);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzk extends zzdqw<zzk, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzk zzbyg;
        private static volatile zzdsp<zzk> zzdv;
        private int zzbxv = 1000;
        private int zzbxw = 1000;
        private int zzbxx;
        private int zzbxy;
        private int zzbxz;
        private int zzbya;
        private int zzbyb;
        private int zzbyc;
        private int zzbyd;
        private int zzbye;
        private zzl zzbyf;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzk, zza> implements zzdsi {
            private zza() {
                super(zzk.zzbyg);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzk() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbyg, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u0004\b\n\u0004\t\u000b\t\n", new Object[]{"zzdj", "zzbxv", zzsv.zzac(), "zzbxw", zzsv.zzac(), "zzbxx", "zzbxy", "zzbxz", "zzbya", "zzbyb", "zzbyc", "zzbyd", "zzbye", "zzbyf"});
                case 4:
                    return zzbyg;
                case 5:
                    zzdsp<zzk> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzk.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbyg);
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
            zzk zzk = new zzk();
            zzbyg = zzk;
            zzdqw.zza(zzk.class, zzk);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzl extends zzdqw<zzl, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzl zzbyj;
        private static volatile zzdsp<zzl> zzdv;
        private int zzbyh;
        private int zzbyi;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzl, zza> implements zzdsi {
            private zza() {
                super(zzl.zzbyj);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzl() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbyj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzbyh", "zzbyi"});
                case 4:
                    return zzbyj;
                case 5:
                    zzdsp<zzl> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzl.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbyj);
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
            zzl zzl = new zzl();
            zzbyj = zzl;
            zzdqw.zza(zzl.class, zzl);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzm extends zzdqw<zzm, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzm zzbym;
        private static volatile zzdsp<zzm> zzdv;
        private int zzbyk;
        private int zzbyl;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzm, zza> implements zzdsi {
            private zza() {
                super(zzm.zzbym);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzm() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbym, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzbyk", "zzbyl"});
                case 4:
                    return zzbym;
                case 5:
                    zzdsp<zzm> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzm.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbym);
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
            zzm zzm = new zzm();
            zzbym = zzm;
            zzdqw.zza(zzm.class, zzm);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzn extends zzdqw<zzn, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzn zzbyn;
        private static volatile zzdsp<zzn> zzdv;
        private String zzbvw = "";
        private int zzbvx;
        private zzo zzbvz;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzn, zza> implements zzdsi {
            private zza() {
                super(zzn.zzbyn);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzn() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbyn, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzbvw", "zzbvx", zzsv.zzac(), "zzbvz"});
                case 4:
                    return zzbyn;
                case 5:
                    zzdsp<zzn> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzn.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbyn);
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
            zzn zzn = new zzn();
            zzbyn = zzn;
            zzdqw.zza(zzn.class, zzn);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzo extends zzdqw<zzo, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzo zzbyq;
        private static volatile zzdsp<zzo> zzdv;
        private int zzbyo;
        private int zzbyp;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzo, zza> implements zzdsi {
            private zza() {
                super(zzo.zzbyq);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzo() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbyq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzbyo", "zzbyp"});
                case 4:
                    return zzbyq;
                case 5:
                    zzdsp<zzo> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzo.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbyq);
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
            zzo zzo = new zzo();
            zzbyq = zzo;
            zzdqw.zza(zzo.class, zzo);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzp extends zzdqw<zzp, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzp zzbyt;
        private static volatile zzdsp<zzp> zzdv;
        private int zzbwb = 1000;
        private zzq zzbyr;
        private zzo zzbys;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzp, zza> implements zzdsi {
            private zza() {
                super(zzp.zzbyt);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzp() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbyt, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzbwb", zzsv.zzac(), "zzbyr", "zzbys"});
                case 4:
                    return zzbyt;
                case 5:
                    zzdsp<zzp> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzp.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbyt);
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
            zzp zzp = new zzp();
            zzbyt = zzp;
            zzdqw.zza(zzp.class, zzp);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzq extends zzdqw<zzq, zzb> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzq zzbyv;
        private static volatile zzdsp<zzq> zzdv;
        private int zzbyu;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum zza implements zzdra {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);
            
            private static final zzdqz<zza> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zza zzcd(int i) {
                if (i == 0) {
                    return VIDEO_ERROR_CODE_UNSPECIFIED;
                }
                if (i == 1) {
                    return OPENGL_RENDERING_FAILED;
                }
                if (i == 2) {
                    return CACHE_LOAD_FAILED;
                }
                if (i != 3) {
                    return null;
                }
                return ANDROID_TARGET_API_TOO_LOW;
            }

            public static zzdrc zzac() {
                return zzte.zzep;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName());
                sb.append('@');
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=");
                sb.append(this.value);
                sb.append(" name=");
                sb.append(name());
                sb.append('>');
                return sb.toString();
            }

            private zza(int i) {
                this.value = i;
            }

            static {
                zzeg = new zztf();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zzq, zzb> implements zzdsi {
            private zzb() {
                super(zzq.zzbyv);
            }

            /* synthetic */ zzb(zzso zzso) {
                this();
            }
        }

        private zzq() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza((zzdsg) zzbyv, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzdj", "zzbyu", zza.zzac()});
                case 4:
                    return zzbyv;
                case 5:
                    zzdsp<zzq> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzq.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbyv);
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
            zzq zzq = new zzq();
            zzbyv = zzq;
            zzdqw.zza(zzq.class, zzq);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzr extends zzdqw<zzr, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzr zzbze;
        private static volatile zzdsp<zzr> zzdv;
        private int zzbwb = 1000;
        private zzq zzbyr;
        private int zzbzb;
        private int zzbzc;
        private int zzbzd;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzr, zza> implements zzdsi {
            private zza() {
                super(zzr.zzbze);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzr() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbze, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"zzdj", "zzbwb", zzsv.zzac(), "zzbyr", "zzbzb", "zzbzc", "zzbzd"});
                case 4:
                    return zzbze;
                case 5:
                    zzdsp<zzr> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzr.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbze);
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
            zzr zzr = new zzr();
            zzbze = zzr;
            zzdqw.zza(zzr.class, zzr);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzs extends zzdqw<zzs, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzs zzbzf;
        private static volatile zzdsp<zzs> zzdv;
        private int zzbwb = 1000;
        private zzq zzbyr;
        private zzo zzbys;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzs, zza> implements zzdsi {
            private zza() {
                super(zzs.zzbzf);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzs() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbzf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzbwb", zzsv.zzac(), "zzbyr", "zzbys"});
                case 4:
                    return zzbzf;
                case 5:
                    zzdsp<zzs> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzs.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbzf);
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
            zzs zzs = new zzs();
            zzbzf = zzs;
            zzdqw.zza(zzs.class, zzs);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzt extends zzdqw<zzt, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzt zzbzh;
        private static volatile zzdsp<zzt> zzdv;
        private int zzbwb = 1000;
        private zzq zzbyr;
        private int zzbzb;
        private int zzbzc;
        private int zzbzd;
        private long zzbzg;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzt, zza> implements zzdsi {
            private zza() {
                super(zzt.zzbzh);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzt() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbzh, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0003\u0005", new Object[]{"zzdj", "zzbwb", zzsv.zzac(), "zzbyr", "zzbzb", "zzbzc", "zzbzd", "zzbzg"});
                case 4:
                    return zzbzh;
                case 5:
                    zzdsp<zzt> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzt.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbzh);
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
            zzt zzt = new zzt();
            zzbzh = zzt;
            zzdqw.zza(zzt.class, zzt);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzu extends zzdqw<zzu, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzu zzbzi;
        private static volatile zzdsp<zzu> zzdv;
        private int zzbwb = 1000;
        private zzq zzbyr;
        private zzo zzbys;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzu, zza> implements zzdsi {
            private zza() {
                super(zzu.zzbzi);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzu() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbzi, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdj", "zzbwb", zzsv.zzac(), "zzbyr", "zzbys"});
                case 4:
                    return zzbzi;
                case 5:
                    zzdsp<zzu> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzu.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbzi);
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
            zzu zzu = new zzu();
            zzbzi = zzu;
            zzdqw.zza(zzu.class, zzu);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzv extends zzdqw<zzv, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzv zzbzj;
        private static volatile zzdsp<zzv> zzdv;
        private int zzbwb = 1000;
        private zzq zzbyr;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzv, zza> implements zzdsi {
            private zza() {
                super(zzv.zzbzj);
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzv() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbzj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzbwb", zzsv.zzac(), "zzbyr"});
                case 4:
                    return zzbzj;
                case 5:
                    zzdsp<zzv> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzv.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbzj);
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
            zzv zzv = new zzv();
            zzbzj = zzv;
            zzdqw.zza(zzv.class, zzv);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzw extends zzdqw<zzw, zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zzw zzbzm;
        private static volatile zzdsp<zzw> zzdv;
        private boolean zzbzk;
        private int zzbzl;
        private int zzdj;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzw, zza> implements zzdsi {
            private zza() {
                super(zzw.zzbzm);
            }

            public final boolean zznu() {
                return ((zzw) this.zzhkp).zznu();
            }

            public final zza zzp(boolean z) {
                zzazn();
                ((zzw) this.zzhkp).zzq(z);
                return this;
            }

            public final zza zzce(int i) {
                zzazn();
                ((zzw) this.zzhkp).zzcf(i);
                return this;
            }

            /* synthetic */ zza(zzso zzso) {
                this();
            }
        }

        private zzw() {
        }

        public final boolean zznu() {
            return this.zzbzk;
        }

        /* access modifiers changed from: private */
        public final void zzq(boolean z) {
            this.zzdj |= 1;
            this.zzbzk = z;
        }

        /* access modifiers changed from: private */
        public final void zzcf(int i) {
            this.zzdj |= 2;
            this.zzbzl = i;
        }

        public static zza zznv() {
            return (zza) zzbzm.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzso.zzdi[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzbzm, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0004\u0001", new Object[]{"zzdj", "zzbzk", "zzbzl"});
                case 4:
                    return zzbzm;
                case 5:
                    zzdsp<zzw> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzw.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzbzm);
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
            zzw zzw = new zzw();
            zzbzm = zzw;
            zzdqw.zza(zzw.class, zzw);
        }
    }
}
