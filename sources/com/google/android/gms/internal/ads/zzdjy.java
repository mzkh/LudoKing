package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdjy extends zzdqw<zzdjy, zza> implements zzdsi {
    private static volatile zzdsp<zzdjy> zzdv;
    /* access modifiers changed from: private */
    public static final zzdjy zzgyp;
    private int zzgyh;
    private zzdrd<zzb> zzgyo = zzazw();

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdjy, zza> implements zzdsi {
        private zza() {
            super(zzdjy.zzgyp);
        }

        public final zza zzev(int i) {
            zzazn();
            ((zzdjy) this.zzhkp).zzer(i);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzazn();
            ((zzdjy) this.zzhkp).zza(zzb);
            return this;
        }

        /* synthetic */ zza(zzdjz zzdjz) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzb extends zzdqw<zzb, zza> implements zzdsi {
        private static volatile zzdsp<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzgyq;
        private String zzgxj = "";
        private int zzgya;
        private int zzgyl;
        private int zzgym;

        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzb, zza> implements zzdsi {
            private zza() {
                super(zzb.zzgyq);
            }

            public final zza zzhc(String str) {
                zzazn();
                ((zzb) this.zzhkp).zzgv(str);
                return this;
            }

            public final zza zzc(zzdjr zzdjr) {
                zzazn();
                ((zzb) this.zzhkp).zza(zzdjr);
                return this;
            }

            public final zza zzew(int i) {
                zzazn();
                ((zzb) this.zzhkp).zzes(i);
                return this;
            }

            public final zza zzc(zzdkj zzdkj) {
                zzazn();
                ((zzb) this.zzhkp).zza(zzdkj);
                return this;
            }

            /* synthetic */ zza(zzdjz zzdjz) {
                this();
            }
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zzgv(String str) {
            if (str != null) {
                this.zzgxj = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzdjr zzdjr) {
            if (zzdjr != null) {
                this.zzgyl = zzdjr.zzab();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzes(int i) {
            this.zzgym = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzdkj zzdkj) {
            if (zzdkj != null) {
                this.zzgya = zzdkj.zzab();
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzauu() {
            return (zza) zzgyq.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdjz.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzgyq, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgxj", "zzgyl", "zzgym", "zzgya"});
                case 4:
                    return zzgyq;
                case 5:
                    zzdsp<zzb> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzb.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new zzc<>(zzgyq);
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
            zzgyq = zzb;
            zzdqw.zza(zzb.class, zzb);
        }
    }

    private zzdjy() {
    }

    /* access modifiers changed from: private */
    public final void zzer(int i) {
        this.zzgyh = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            if (!this.zzgyo.zzaxi()) {
                this.zzgyo = zzdqw.zza(this.zzgyo);
            }
            this.zzgyo.add(zzb2);
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzaus() {
        return (zza) zzgyp.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdjz.zzdi[i - 1]) {
            case 1:
                return new zzdjy();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgyp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzgyh", "zzgyo", zzb.class});
            case 4:
                return zzgyp;
            case 5:
                zzdsp<zzdjy> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdjy.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgyp);
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
        zzdjy zzdjy = new zzdjy();
        zzgyp = zzdjy;
        zzdqw.zza(zzdjy.class, zzdjy);
    }
}
