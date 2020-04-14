package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzczh extends zzdqw<zzczh, zzb> implements zzdsi {
    private static volatile zzdsp<zzczh> zzdv;
    private static final zzdre<Integer, zza> zzgnp = new zzczg();
    /* access modifiers changed from: private */
    public static final zzczh zzgnt;
    private int zzdj;
    private zzdrb zzgno = zzazv();
    private String zzgnq;
    private String zzgnr;
    private String zzgns;

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public enum zza implements zzdra {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzdqz<zza> zzeg = null;
        private final int value;

        public final int zzab() {
            return this.value;
        }

        public static zza zzdl(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
        }

        public static zzdrc zzac() {
            return zzczj.zzep;
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
            zzeg = new zzczk();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zzczh, zzb> implements zzdsi {
        private zzb() {
            super(zzczh.zzgnt);
        }

        public final zzb zzb(zza zza) {
            zzazn();
            ((zzczh) this.zzhkp).zza(zza);
            return this;
        }

        public final zzb zzgn(String str) {
            zzazn();
            ((zzczh) this.zzhkp).zzgm(str);
            return this;
        }

        /* synthetic */ zzb(zzczg zzczg) {
            this();
        }
    }

    private zzczh() {
        String str = "";
        this.zzgnq = str;
        this.zzgnr = str;
        this.zzgns = str;
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        if (zza2 != null) {
            if (!this.zzgno.zzaxi()) {
                this.zzgno = zzdqw.zza(this.zzgno);
            }
            this.zzgno.zzgp(zza2.zzab());
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void zzgm(String str) {
        if (str != null) {
            this.zzdj |= 1;
            this.zzgnq = str;
            return;
        }
        throw new NullPointerException();
    }

    public static zzb zzanx() {
        return (zzb) zzgnt.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzczi.zzdi[i - 1]) {
            case 1:
                return new zzczh();
            case 2:
                return new zzb(null);
            case 3:
                return zza((zzdsg) zzgnt, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002", new Object[]{"zzdj", "zzgno", zza.zzac(), "zzgnq", "zzgnr", "zzgns"});
            case 4:
                return zzgnt;
            case 5:
                zzdsp<zzczh> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzczh.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgnt);
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
        zzczh zzczh = new zzczh();
        zzgnt = zzczh;
        zzdqw.zza(zzczh.class, zzczh);
    }
}
