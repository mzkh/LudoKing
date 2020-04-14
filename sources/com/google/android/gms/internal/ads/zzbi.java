package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzbi {

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zza extends zzdqw<zza, C3499zza> implements zzdsi {
        /* access modifiers changed from: private */
        public static final zza zzdu;
        private static volatile zzdsp<zza> zzdv;
        private int zzdj;
        private String zzdk;
        private long zzdl;
        private String zzdm;
        private String zzdn;
        private String zzdo;
        private long zzdp;
        private long zzdq;
        private String zzdr;
        private long zzds;
        private String zzdt;

        /* renamed from: com.google.android.gms.internal.ads.zzbi$zza$zza reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class C3499zza extends com.google.android.gms.internal.ads.zzdqw.zza<zza, C3499zza> implements zzdsi {
            private C3499zza() {
                super(zza.zzdu);
            }

            public final C3499zza zzi(String str) {
                zzazn();
                ((zza) this.zzhkp).zzm(str);
                return this;
            }

            public final C3499zza zzc(long j) {
                zzazn();
                ((zza) this.zzhkp).zzd(j);
                return this;
            }

            public final C3499zza zzj(String str) {
                zzazn();
                ((zza) this.zzhkp).zzn(str);
                return this;
            }

            public final C3499zza zzk(String str) {
                zzazn();
                ((zza) this.zzhkp).zzo(str);
                return this;
            }

            public final C3499zza zzl(String str) {
                zzazn();
                ((zza) this.zzhkp).zzp(str);
                return this;
            }

            /* synthetic */ C3499zza(zzbh zzbh) {
                this();
            }
        }

        private zza() {
            String str = "";
            this.zzdk = str;
            this.zzdm = str;
            this.zzdn = str;
            this.zzdo = str;
            this.zzdr = str;
            this.zzdt = str;
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            if (str != null) {
                this.zzdj |= 1;
                this.zzdk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzdj |= 2;
            this.zzdl = j;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            if (str != null) {
                this.zzdj |= 4;
                this.zzdm = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            if (str != null) {
                this.zzdj |= 8;
                this.zzdn = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzp(String str) {
            if (str != null) {
                this.zzdj |= 16;
                this.zzdo = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C3499zza zzr() {
            return (C3499zza) zzdu.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbh.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3499zza(null);
                case 3:
                    return zza((zzdsg) zzdu, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\b\u0007\t\u0002\b\n\b\t", new Object[]{"zzdj", "zzdk", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzdr", "zzds", "zzdt"});
                case 4:
                    return zzdu;
                case 5:
                    zzdsp<zza> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zza.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new zzc<>(zzdu);
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
            zzdu = zza;
            zzdqw.zza(zza.class, zza);
        }
    }
}
