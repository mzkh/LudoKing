package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdjn extends zzdqw<zzdjn, zza> implements zzdsi {
    private static volatile zzdsp<zzdjn> zzdv;
    /* access modifiers changed from: private */
    public static final zzdjn zzgxm;
    private String zzgxj = "";
    private zzdpm zzgxk = zzdpm.zzhgb;
    private int zzgxl;

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdjn, zza> implements zzdsi {
        private zza() {
            super(zzdjn.zzgxm);
        }

        public final zza zzgw(String str) {
            zzazn();
            ((zzdjn) this.zzhkp).zzgv(str);
            return this;
        }

        public final zza zzbo(zzdpm zzdpm) {
            zzazn();
            ((zzdjn) this.zzhkp).zzbn(zzdpm);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzazn();
            ((zzdjn) this.zzhkp).zza(zzb);
            return this;
        }

        /* synthetic */ zza(zzdjo zzdjo) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public enum zzb implements zzdra {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzdqz<zzb> zzeg = null;
        private final int value;

        public final int zzab() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zzb zzen(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzab());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        private zzb(int i) {
            this.value = i;
        }

        static {
            zzeg = new zzdjp();
        }
    }

    private zzdjn() {
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

    public final zzdpm zzatv() {
        return this.zzgxk;
    }

    /* access modifiers changed from: private */
    public final void zzbn(zzdpm zzdpm) {
        if (zzdpm != null) {
            this.zzgxk = zzdpm;
            return;
        }
        throw new NullPointerException();
    }

    public final zzb zzatw() {
        zzb zzen = zzb.zzen(this.zzgxl);
        return zzen == null ? zzb.UNRECOGNIZED : zzen;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            this.zzgxl = zzb2.zzab();
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzatx() {
        return (zza) zzgxm.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdjo.zzdi[i - 1]) {
            case 1:
                return new zzdjn();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgxm, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzgxj", "zzgxk", "zzgxl"});
            case 4:
                return zzgxm;
            case 5:
                zzdsp<zzdjn> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdjn.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgxm);
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

    public static zzdjn zzaty() {
        return zzgxm;
    }

    static {
        zzdjn zzdjn = new zzdjn();
        zzgxm = zzdjn;
        zzdqw.zza(zzdjn.class, zzdjn);
    }
}
