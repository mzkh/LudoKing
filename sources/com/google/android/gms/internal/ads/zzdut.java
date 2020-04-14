package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdut {

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends zzdqw<zza, zzb> implements zzdsi {
        private static volatile zzdsp<zza> zzdv;
        /* access modifiers changed from: private */
        public static final zza zzhsa;
        private int zzdj;
        private int zzhrt;
        private C3505zza zzhru;
        private zzdpm zzhrv = zzdpm.zzhgb;
        private zzdpm zzhrw = zzdpm.zzhgb;
        private boolean zzhrx;
        private boolean zzhry;
        private byte zzhrz = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzdut$zza$zza reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class C3505zza extends zzdqw<C3505zza, C3506zza> implements zzdsi {
            private static volatile zzdsp<C3505zza> zzdv;
            /* access modifiers changed from: private */
            public static final C3505zza zzhsf;
            private int zzdj;
            private String zzhsb;
            private String zzhsc;
            private String zzhsd;
            private int zzhse;

            /* renamed from: com.google.android.gms.internal.ads.zzdut$zza$zza$zza reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class C3506zza extends com.google.android.gms.internal.ads.zzdqw.zza<C3505zza, C3506zza> implements zzdsi {
                private C3506zza() {
                    super(C3505zza.zzhsf);
                }

                /* synthetic */ C3506zza(zzduv zzduv) {
                    this();
                }
            }

            private C3505zza() {
                String str = "";
                this.zzhsb = str;
                this.zzhsc = str;
                this.zzhsd = str;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzduv.zzdi[i - 1]) {
                    case 1:
                        return new C3505zza();
                    case 2:
                        return new C3506zza(null);
                    case 3:
                        return zza((zzdsg) zzhsf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzdj", "zzhsb", "zzhsc", "zzhsd", "zzhse"});
                    case 4:
                        return zzhsf;
                    case 5:
                        zzdsp<C3505zza> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (C3505zza.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhsf);
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
                C3505zza zza = new C3505zza();
                zzhsf = zza;
                zzdqw.zza(C3505zza.class, zza);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zza, zzb> implements zzdsi {
            private zzb() {
                super(zza.zzhsa);
            }

            /* synthetic */ zzb(zzduv zzduv) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum zzc implements zzdra {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzdqz<zzc> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zzc zzhg(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            public static zzdrc zzac() {
                return zzduw.zzep;
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
                zzeg = new zzdux();
            }
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzduv.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza((zzdsg) zzhsa, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzdj", "zzhrt", zzc.zzac(), "zzhru", "zzhrv", "zzhrw", "zzhrx", "zzhry"});
                case 4:
                    return zzhsa;
                case 5:
                    zzdsp<zza> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zza.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhsa);
                                zzdv = zzdsp;
                            }
                        }
                    }
                    return zzdsp;
                case 6:
                    return Byte.valueOf(this.zzhrz);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzhrz = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzhsa = zza;
            zzdqw.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzb extends zzdqw<zzb, zza> implements zzdsi {
        private static volatile zzdsp<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzhtb;
        private int zzbus;
        private int zzdj;
        private zzdpm zzhrv;
        private byte zzhrz = 2;
        private String zzhsc;
        private int zzhsm;
        private String zzhsn;
        private String zzhso;
        private C3507zzb zzhsp;
        private zzdrd<zzh> zzhsq;
        private String zzhsr;
        private zzf zzhss;
        private boolean zzhst;
        private zzdrd<String> zzhsu;
        private String zzhsv;
        private boolean zzhsw;
        private boolean zzhsx;
        private zzi zzhsy;
        private zzdrd<String> zzhsz;
        private zzdrd<String> zzhta;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzb, zza> implements zzdsi {
            private zza() {
                super(zzb.zzhtb);
            }

            /* synthetic */ zza(zzduv zzduv) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzdut$zzb$zzb reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class C3507zzb extends zzdqw<C3507zzb, zza> implements zzdsi {
            private static volatile zzdsp<C3507zzb> zzdv;
            /* access modifiers changed from: private */
            public static final C3507zzb zzhtd;
            private int zzdj;
            private String zzhtc = "";

            /* renamed from: com.google.android.gms.internal.ads.zzdut$zzb$zzb$zza */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<C3507zzb, zza> implements zzdsi {
                private zza() {
                    super(C3507zzb.zzhtd);
                }

                public final zza zzhn(String str) {
                    zzazn();
                    ((C3507zzb) this.zzhkp).zzho(str);
                    return this;
                }

                /* synthetic */ zza(zzduv zzduv) {
                    this();
                }
            }

            private C3507zzb() {
            }

            /* access modifiers changed from: private */
            public final void zzho(String str) {
                if (str != null) {
                    this.zzdj |= 1;
                    this.zzhtc = str;
                    return;
                }
                throw new NullPointerException();
            }

            public static zza zzbcn() {
                return (zza) zzhtd.zzazt();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzduv.zzdi[i - 1]) {
                    case 1:
                        return new C3507zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza((zzdsg) zzhtd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdj", "zzhtc"});
                    case 4:
                        return zzhtd;
                    case 5:
                        zzdsp<C3507zzb> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (C3507zzb.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhtd);
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
                C3507zzb zzb = new C3507zzb();
                zzhtd = zzb;
                zzdqw.zza(C3507zzb.class, zzb);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzc extends zzdqw<zzc, zza> implements zzdsi {
            private static volatile zzdsp<zzc> zzdv;
            /* access modifiers changed from: private */
            public static final zzc zzhtf;
            private int zzdj;
            private zzdpm zzgxk = zzdpm.zzhgb;
            private byte zzhrz = 2;
            private zzdpm zzhte = zzdpm.zzhgb;

            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzc, zza> implements zzdsi {
                private zza() {
                    super(zzc.zzhtf);
                }

                public final zza zzdd(zzdpm zzdpm) {
                    zzazn();
                    ((zzc) this.zzhkp).zzdf(zzdpm);
                    return this;
                }

                public final zza zzde(zzdpm zzdpm) {
                    zzazn();
                    ((zzc) this.zzhkp).zzbn(zzdpm);
                    return this;
                }

                /* synthetic */ zza(zzduv zzduv) {
                    this();
                }
            }

            private zzc() {
            }

            /* access modifiers changed from: private */
            public final void zzdf(zzdpm zzdpm) {
                if (zzdpm != null) {
                    this.zzdj |= 1;
                    this.zzhte = zzdpm;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzbn(zzdpm zzdpm) {
                if (zzdpm != null) {
                    this.zzdj |= 2;
                    this.zzgxk = zzdpm;
                    return;
                }
                throw new NullPointerException();
            }

            public static zza zzbcp() {
                return (zza) zzhtf.zzazt();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzduv.zzdi[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza((zzdsg) zzhtf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzdj", "zzhte", "zzgxk"});
                    case 4:
                        return zzhtf;
                    case 5:
                        zzdsp<zzc> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zzc.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhtf);
                                    zzdv = zzdsp;
                                }
                            }
                        }
                        return zzdsp;
                    case 6:
                        return Byte.valueOf(this.zzhrz);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhrz = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzc zzc = new zzc();
                zzhtf = zzc;
                zzdqw.zza(zzc.class, zzc);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzd extends zzdqw<zzd, zza> implements zzdsi {
            private static volatile zzdsp<zzd> zzdv;
            /* access modifiers changed from: private */
            public static final zzd zzhtl;
            private int zzdj;
            private byte zzhrz = 2;
            private C3508zzb zzhtg;
            private zzdrd<zzc> zzhth = zzazw();
            private zzdpm zzhti = zzdpm.zzhgb;
            private zzdpm zzhtj = zzdpm.zzhgb;
            private int zzhtk;

            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzd, zza> implements zzdsi {
                private zza() {
                    super(zzd.zzhtl);
                }

                /* synthetic */ zza(zzduv zzduv) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdut$zzb$zzd$zzb reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class C3508zzb extends zzdqw<C3508zzb, zza> implements zzdsi {
                private static volatile zzdsp<C3508zzb> zzdv;
                /* access modifiers changed from: private */
                public static final C3508zzb zzhtp;
                private int zzdj;
                private zzdpm zzhtm = zzdpm.zzhgb;
                private zzdpm zzhtn = zzdpm.zzhgb;
                private zzdpm zzhto = zzdpm.zzhgb;

                /* renamed from: com.google.android.gms.internal.ads.zzdut$zzb$zzd$zzb$zza */
                /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
                public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<C3508zzb, zza> implements zzdsi {
                    private zza() {
                        super(C3508zzb.zzhtp);
                    }

                    /* synthetic */ zza(zzduv zzduv) {
                        this();
                    }
                }

                private C3508zzb() {
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzduv.zzdi[i - 1]) {
                        case 1:
                            return new C3508zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zza((zzdsg) zzhtp, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhtm", "zzhtn", "zzhto"});
                        case 4:
                            return zzhtp;
                        case 5:
                            zzdsp<C3508zzb> zzdsp = zzdv;
                            if (zzdsp == null) {
                                synchronized (C3508zzb.class) {
                                    zzdsp = zzdv;
                                    if (zzdsp == null) {
                                        zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhtp);
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
                    C3508zzb zzb = new C3508zzb();
                    zzhtp = zzb;
                    zzdqw.zza(C3508zzb.class, zzb);
                }
            }

            private zzd() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzduv.zzdi[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza((zzdsg) zzhtl, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzdj", "zzhtg", "zzhth", zzc.class, "zzhti", "zzhtj", "zzhtk"});
                    case 4:
                        return zzhtl;
                    case 5:
                        zzdsp<zzd> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zzd.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhtl);
                                    zzdv = zzdsp;
                                }
                            }
                        }
                        return zzdsp;
                    case 6:
                        return Byte.valueOf(this.zzhrz);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhrz = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzd zzd = new zzd();
                zzhtl = zzd;
                zzdqw.zza(zzd.class, zzd);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zze extends zzdqw<zze, zza> implements zzdsi {
            private static volatile zzdsp<zze> zzdv;
            /* access modifiers changed from: private */
            public static final zze zzhts;
            private int zzdj;
            private byte zzhrz = 2;
            private zzdrd<zzc> zzhth = zzazw();
            private zzdpm zzhti = zzdpm.zzhgb;
            private zzdpm zzhtj = zzdpm.zzhgb;
            private int zzhtk;
            private C3509zzb zzhtq;
            private zzdpm zzhtr = zzdpm.zzhgb;

            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zze, zza> implements zzdsi {
                private zza() {
                    super(zze.zzhts);
                }

                /* synthetic */ zza(zzduv zzduv) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdut$zzb$zze$zzb reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class C3509zzb extends zzdqw<C3509zzb, zza> implements zzdsi {
                private static volatile zzdsp<C3509zzb> zzdv;
                /* access modifiers changed from: private */
                public static final C3509zzb zzhtv;
                private int zzdj;
                private zzdpm zzhto = zzdpm.zzhgb;
                private int zzhtt;
                private zzdpm zzhtu = zzdpm.zzhgb;

                /* renamed from: com.google.android.gms.internal.ads.zzdut$zzb$zze$zzb$zza */
                /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
                public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<C3509zzb, zza> implements zzdsi {
                    private zza() {
                        super(C3509zzb.zzhtv);
                    }

                    /* synthetic */ zza(zzduv zzduv) {
                        this();
                    }
                }

                private C3509zzb() {
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzduv.zzdi[i - 1]) {
                        case 1:
                            return new C3509zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zza((zzdsg) zzhtv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzhtt", "zzhtu", "zzhto"});
                        case 4:
                            return zzhtv;
                        case 5:
                            zzdsp<C3509zzb> zzdsp = zzdv;
                            if (zzdsp == null) {
                                synchronized (C3509zzb.class) {
                                    zzdsp = zzdv;
                                    if (zzdsp == null) {
                                        zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhtv);
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
                    C3509zzb zzb = new C3509zzb();
                    zzhtv = zzb;
                    zzdqw.zza(C3509zzb.class, zzb);
                }
            }

            private zze() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzduv.zzdi[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza((zzdsg) zzhts, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzdj", "zzhtq", "zzhth", zzc.class, "zzhti", "zzhtj", "zzhtk", "zzhtr"});
                    case 4:
                        return zzhts;
                    case 5:
                        zzdsp<zze> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zze.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhts);
                                    zzdv = zzdsp;
                                }
                            }
                        }
                        return zzdsp;
                    case 6:
                        return Byte.valueOf(this.zzhrz);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhrz = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zze zze = new zze();
                zzhts = zze;
                zzdqw.zza(zze.class, zze);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzf extends zzdqw<zzf, zza> implements zzdsi {
            private static volatile zzdsp<zzf> zzdv;
            /* access modifiers changed from: private */
            public static final zzf zzhty;
            private int zzbus;
            private int zzdj;
            private String zzhtw = "";
            private zzdpm zzhtx = zzdpm.zzhgb;

            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzf, zza> implements zzdsi {
                private zza() {
                    super(zzf.zzhty);
                }

                /* synthetic */ zza(zzduv zzduv) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdut$zzb$zzf$zzb reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public enum C3510zzb implements zzdra {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzdqz<C3510zzb> zzeg = null;
                private final int value;

                public final int zzab() {
                    return this.value;
                }

                public static C3510zzb zzhh(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                public static zzdrc zzac() {
                    return zzduz.zzep;
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

                private C3510zzb(int i) {
                    this.value = i;
                }

                static {
                    zzeg = new zzduy();
                }
            }

            private zzf() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzduv.zzdi[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza((zzdsg) zzhty, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzdj", "zzbus", C3510zzb.zzac(), "zzhtw", "zzhtx"});
                    case 4:
                        return zzhty;
                    case 5:
                        zzdsp<zzf> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zzf.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhty);
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
                zzhty = zzf;
                zzdqw.zza(zzf.class, zzf);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public enum zzg implements zzdra {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzdqz<zzg> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zzg zzhi(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzdrc zzac() {
                return zzdva.zzep;
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

            private zzg(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzdvb();
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzh extends zzdqw<zzh, C3511zzb> implements zzdsi {
            private static volatile zzdsp<zzh> zzdv;
            /* access modifiers changed from: private */
            public static final zzh zzhva;
            private int zzdj;
            private byte zzhrz = 2;
            private String zzhsc;
            private int zzhus;
            private zzd zzhut;
            private zze zzhuu;
            private int zzhuv;
            private zzdrb zzhuw;
            private String zzhux;
            private int zzhuy;
            private zzdrd<String> zzhuz;

            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public enum zza implements zzdra {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzdqz<zza> zzeg = null;
                private final int value;

                public final int zzab() {
                    return this.value;
                }

                public static zza zzhj(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                }

                public static zzdrc zzac() {
                    return zzdvc.zzep;
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
                    zzeg = new zzdvd();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdut$zzb$zzh$zzb reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class C3511zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zzh, C3511zzb> implements zzdsi {
                private C3511zzb() {
                    super(zzh.zzhva);
                }

                /* synthetic */ C3511zzb(zzduv zzduv) {
                    this();
                }
            }

            private zzh() {
                String str = "";
                this.zzhsc = str;
                this.zzhuw = zzazv();
                this.zzhux = str;
                this.zzhuz = zzdqw.zzazw();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzduv.zzdi[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C3511zzb(null);
                    case 3:
                        return zza((zzdsg) zzhva, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzdj", "zzhus", "zzhsc", "zzhut", "zzhuu", "zzhuv", "zzhuw", "zzhux", "zzhuy", zza.zzac(), "zzhuz"});
                    case 4:
                        return zzhva;
                    case 5:
                        zzdsp<zzh> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zzh.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhva);
                                    zzdv = zzdsp;
                                }
                            }
                        }
                        return zzdsp;
                    case 6:
                        return Byte.valueOf(this.zzhrz);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzhrz = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzh zzh = new zzh();
                zzhva = zzh;
                zzdqw.zza(zzh.class, zzh);
            }
        }

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zzi extends zzdqw<zzi, zza> implements zzdsi {
            private static volatile zzdsp<zzi> zzdv;
            /* access modifiers changed from: private */
            public static final zzi zzhve;
            private int zzdj;
            private String zzhvb = "";
            private long zzhvc;
            private boolean zzhvd;

            /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
            public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzi, zza> implements zzdsi {
                private zza() {
                    super(zzi.zzhve);
                }

                public final zza zzhq(String str) {
                    zzazn();
                    ((zzi) this.zzhkp).zzhp(str);
                    return this;
                }

                public final zza zzfo(long j) {
                    zzazn();
                    ((zzi) this.zzhkp).zzfn(j);
                    return this;
                }

                public final zza zzbm(boolean z) {
                    zzazn();
                    ((zzi) this.zzhkp).zzbl(z);
                    return this;
                }

                /* synthetic */ zza(zzduv zzduv) {
                    this();
                }
            }

            private zzi() {
            }

            /* access modifiers changed from: private */
            public final void zzhp(String str) {
                if (str != null) {
                    this.zzdj |= 1;
                    this.zzhvb = str;
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzfn(long j) {
                this.zzdj |= 2;
                this.zzhvc = j;
            }

            /* access modifiers changed from: private */
            public final void zzbl(boolean z) {
                this.zzdj |= 4;
                this.zzhvd = z;
            }

            public static zza zzbcx() {
                return (zza) zzhve.zzazt();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzduv.zzdi[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza((zzdsg) zzhve, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzdj", "zzhvb", "zzhvc", "zzhvd"});
                    case 4:
                        return zzhve;
                    case 5:
                        zzdsp<zzi> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zzi.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhve);
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
                zzhve = zzi;
                zzdqw.zza(zzi.class, zzi);
            }
        }

        private zzb() {
            String str = "";
            this.zzhsc = str;
            this.zzhsn = str;
            this.zzhso = str;
            this.zzhsq = zzazw();
            this.zzhsr = str;
            this.zzhsu = zzdqw.zzazw();
            this.zzhsv = str;
            this.zzhrv = zzdpm.zzhgb;
            this.zzhsz = zzdqw.zzazw();
            this.zzhta = zzdqw.zzazw();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzduv.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzhtb, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzdj", "zzhsc", "zzhsn", "zzhso", "zzhsq", zzh.class, "zzhst", "zzhsu", "zzhsv", "zzhsw", "zzhsx", "zzbus", zzg.zzac(), "zzhsm", zzc.zzac(), "zzhsp", "zzhsr", "zzhss", "zzhrv", "zzhsy", "zzhsz", "zzhta"});
                case 4:
                    return zzhtb;
                case 5:
                    zzdsp<zzb> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzb.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhtb);
                                zzdv = zzdsp;
                            }
                        }
                    }
                    return zzdsp;
                case 6:
                    return Byte.valueOf(this.zzhrz);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzhrz = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzhtb = zzb;
            zzdqw.zza(zzb.class, zzb);
        }
    }
}
