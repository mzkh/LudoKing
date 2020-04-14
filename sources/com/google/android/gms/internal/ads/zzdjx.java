package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdjx extends zzdqw<zzdjx, zzb> implements zzdsi {
    private static volatile zzdsp<zzdjx> zzdv;
    /* access modifiers changed from: private */
    public static final zzdjx zzgyj;
    private int zzgyh;
    private zzdrd<zza> zzgyi = zzazw();

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends zzdqw<zza, C3504zza> implements zzdsi {
        private static volatile zzdsp<zza> zzdv;
        /* access modifiers changed from: private */
        public static final zza zzgyn;
        private int zzgya;
        private zzdjn zzgyk;
        private int zzgyl;
        private int zzgym;

        /* renamed from: com.google.android.gms.internal.ads.zzdjx$zza$zza reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
        public static final class C3504zza extends com.google.android.gms.internal.ads.zzdqw.zza<zza, C3504zza> implements zzdsi {
            private C3504zza() {
                super(zza.zzgyn);
            }

            public final C3504zza zzb(zzdjn zzdjn) {
                zzazn();
                ((zza) this.zzhkp).zza(zzdjn);
                return this;
            }

            public final C3504zza zzb(zzdjr zzdjr) {
                zzazn();
                ((zza) this.zzhkp).zza(zzdjr);
                return this;
            }

            public final C3504zza zzeu(int i) {
                zzazn();
                ((zza) this.zzhkp).zzes(i);
                return this;
            }

            public final C3504zza zzb(zzdkj zzdkj) {
                zzazn();
                ((zza) this.zzhkp).zza(zzdkj);
                return this;
            }

            /* synthetic */ C3504zza(zzdjw zzdjw) {
                this();
            }
        }

        private zza() {
        }

        public final boolean zzaun() {
            return this.zzgyk != null;
        }

        public final zzdjn zzauo() {
            zzdjn zzdjn = this.zzgyk;
            return zzdjn == null ? zzdjn.zzaty() : zzdjn;
        }

        /* access modifiers changed from: private */
        public final void zza(zzdjn zzdjn) {
            if (zzdjn != null) {
                this.zzgyk = zzdjn;
                return;
            }
            throw new NullPointerException();
        }

        public final zzdjr zzaps() {
            zzdjr zzeo = zzdjr.zzeo(this.zzgyl);
            return zzeo == null ? zzdjr.UNRECOGNIZED : zzeo;
        }

        /* access modifiers changed from: private */
        public final void zza(zzdjr zzdjr) {
            if (zzdjr != null) {
                this.zzgyl = zzdjr.zzab();
                return;
            }
            throw new NullPointerException();
        }

        public final int zzaup() {
            return this.zzgym;
        }

        /* access modifiers changed from: private */
        public final void zzes(int i) {
            this.zzgym = i;
        }

        public final zzdkj zzapt() {
            zzdkj zzez = zzdkj.zzez(this.zzgya);
            return zzez == null ? zzdkj.UNRECOGNIZED : zzez;
        }

        /* access modifiers changed from: private */
        public final void zza(zzdkj zzdkj) {
            if (zzdkj != null) {
                this.zzgya = zzdkj.zzab();
                return;
            }
            throw new NullPointerException();
        }

        public static C3504zza zzauq() {
            return (C3504zza) zzgyn.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdjw.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3504zza(null);
                case 3:
                    return zza((zzdsg) zzgyn, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgyk", "zzgyl", "zzgym", "zzgya"});
                case 4:
                    return zzgyn;
                case 5:
                    zzdsp<zza> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zza.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new zzc<>(zzgyn);
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
            zzgyn = zza;
            zzdqw.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zzdjx, zzb> implements zzdsi {
        private zzb() {
            super(zzdjx.zzgyj);
        }

        public final zzb zzet(int i) {
            zzazn();
            ((zzdjx) this.zzhkp).zzer(i);
            return this;
        }

        public final zzb zzb(zza zza) {
            zzazn();
            ((zzdjx) this.zzhkp).zza(zza);
            return this;
        }

        /* synthetic */ zzb(zzdjw zzdjw) {
            this();
        }
    }

    private zzdjx() {
    }

    public final int zzaui() {
        return this.zzgyh;
    }

    /* access modifiers changed from: private */
    public final void zzer(int i) {
        this.zzgyh = i;
    }

    public final List<zza> zzauj() {
        return this.zzgyi;
    }

    public final int zzauk() {
        return this.zzgyi.size();
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        if (zza2 != null) {
            if (!this.zzgyi.zzaxi()) {
                this.zzgyi = zzdqw.zza(this.zzgyi);
            }
            this.zzgyi.add(zza2);
            return;
        }
        throw new NullPointerException();
    }

    public static zzdjx zzm(byte[] bArr) throws zzdrg {
        return (zzdjx) zzdqw.zza(zzgyj, bArr);
    }

    public static zzb zzaul() {
        return (zzb) zzgyj.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdjw.zzdi[i - 1]) {
            case 1:
                return new zzdjx();
            case 2:
                return new zzb(null);
            case 3:
                return zza((zzdsg) zzgyj, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzgyh", "zzgyi", zza.class});
            case 4:
                return zzgyj;
            case 5:
                zzdsp<zzdjx> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdjx.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgyj);
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
        zzdjx zzdjx = new zzdjx();
        zzgyj = zzdjx;
        zzdqw.zza(zzdjx.class, zzdjx);
    }
}
