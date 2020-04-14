package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzczl extends zzdqw<zzczl, zza> implements zzdsi {
    private static volatile zzdsp<zzczl> zzdv;
    /* access modifiers changed from: private */
    public static final zzczl zzgoa;
    private int zzdj;
    private String zzdk;
    private int zzgnx;
    private String zzgny;
    private zzczh zzgnz;

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzczl, zza> implements zzdsi {
        private zza() {
            super(zzczl.zzgoa);
        }

        public final zza zzb(zzb zzb) {
            zzazn();
            ((zzczl) this.zzhkp).zza(zzb);
            return this;
        }

        public final zza zzgo(String str) {
            zzazn();
            ((zzczl) this.zzhkp).zzm(str);
            return this;
        }

        public final zza zzb(com.google.android.gms.internal.ads.zzczh.zzb zzb) {
            zzazn();
            ((zzczl) this.zzhkp).zza(zzb);
            return this;
        }

        /* synthetic */ zza(zzczm zzczm) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public enum zzb implements zzdra {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        
        private static final zzdqz<zzb> zzeg = null;
        private final int value;

        public final int zzab() {
            return this.value;
        }

        public static zzb zzdm(int i) {
            if (i == 0) {
                return EVENT_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return BLOCKED_IMPRESSION;
        }

        public static zzdrc zzac() {
            return zzczp.zzep;
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

        private zzb(int i) {
            this.value = i;
        }

        static {
            zzeg = new zzczn();
        }
    }

    private zzczl() {
        String str = "";
        this.zzdk = str;
        this.zzgny = str;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        if (zzb2 != null) {
            this.zzdj |= 1;
            this.zzgnx = zzb2.zzab();
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzm(String str) {
        if (str != null) {
            this.zzdj |= 2;
            this.zzdk = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zza(com.google.android.gms.internal.ads.zzczh.zzb zzb2) {
        this.zzgnz = (zzczh) ((zzdqw) zzb2.zzazr());
        this.zzdj |= 8;
    }

    public static zza zzanz() {
        return (zza) zzgoa.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzczm.zzdi[i - 1]) {
            case 1:
                return new zzczl();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgoa, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003", new Object[]{"zzdj", "zzgnx", zzb.zzac(), "zzdk", "zzgny", "zzgnz"});
            case 4:
                return zzgoa;
            case 5:
                zzdsp<zzczl> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzczl.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgoa);
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
        zzczl zzczl = new zzczl();
        zzgoa = zzczl;
        zzdqw.zza(zzczl.class, zzczl);
    }
}
