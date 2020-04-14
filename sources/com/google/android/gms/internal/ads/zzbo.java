package com.google.android.gms.internal.ads;

import com.google.android.gms.drive.DriveFile;

/* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
public final class zzbo {

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zza extends zzdqw<zza, zzb> implements zzdsi {
        private static volatile zzdsp<zza> zzdv;
        /* access modifiers changed from: private */
        public static final zza zzhk;
        private int zzdj;
        private String zzdt;
        private String zzei;
        private String zzek;
        private String zzel;
        private String zzem;
        private int zzeq;
        private int zzer;
        private String zzes;
        private long zzet;
        private long zzeu;
        private long zzev;
        private long zzew;
        private long zzex;
        private long zzey;
        private long zzez;
        private long zzfa;
        private long zzfb;
        private long zzfc;
        private String zzfd;
        private long zzfe;
        private long zzff;
        private long zzfg;
        private long zzfh;
        private long zzfi;
        private long zzfj;
        private long zzfk;
        private long zzfl;
        private long zzfm;
        private String zzfn;
        private long zzfo;
        private long zzfp;
        private long zzfq;
        private long zzfr;
        private long zzfs = -1;
        private long zzft = -1;
        private zzb zzfu;
        private long zzfv = -1;
        private long zzfw = -1;
        private long zzfx = -1;
        private long zzfy = -1;
        private long zzfz = -1;
        private long zzga = -1;
        private long zzgb;
        private int zzgc;
        private int zzgd;
        private long zzge;
        private long zzgf;
        private long zzgg;
        private long zzgh;
        private long zzgi;
        private int zzgj;
        private zze zzgk;
        private zzdrd<zze> zzgl;
        private zzf zzgm;
        private long zzgn;
        private long zzgo;
        private long zzgp;
        private long zzgq;
        private long zzgr;
        private long zzgs;
        private long zzgt;
        private long zzgu;
        private String zzgv;
        private long zzgw;
        private int zzgx;
        private int zzgy;
        private int zzgz;
        private zzf zzha;
        private long zzhb;
        private int zzhc;
        private long zzhd;
        private String zzhe;
        private int zzhf;
        private boolean zzhg;
        private String zzhh;
        private long zzhi;
        private zze zzhj;

        /* renamed from: com.google.android.gms.internal.ads.zzbo$zza$zza reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public enum C3501zza implements zzdra {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3),
            DEBUGGER_STATE_ENVVAR(4),
            DEBUGGER_STATE_MACHPORT(5),
            DEBUGGER_STATE_ENVVAR_MACHPORT(6);
            
            private static final zzdqz<C3501zza> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static C3501zza zzg(int i) {
                switch (i) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    case 4:
                        return DEBUGGER_STATE_ENVVAR;
                    case 5:
                        return DEBUGGER_STATE_MACHPORT;
                    case 6:
                        return DEBUGGER_STATE_ENVVAR_MACHPORT;
                    default:
                        return null;
                }
            }

            public static zzdrc zzac() {
                return zzbq.zzep;
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

            private C3501zza(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzbr();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zzb extends com.google.android.gms.internal.ads.zzdqw.zza<zza, zzb> implements zzdsi {
            private zzb() {
                super(zza.zzhk);
            }

            public final zzb zzz(String str) {
                zzazn();
                ((zza) this.zzhkp).zzq(str);
                return this;
            }

            public final zzb zzaa(String str) {
                zzazn();
                ((zza) this.zzhkp).zzr(str);
                return this;
            }

            public final zzb zzal(long j) {
                zzazn();
                ((zza) this.zzhkp).zze(j);
                return this;
            }

            public final zzb zzam(long j) {
                zzazn();
                ((zza) this.zzhkp).zzf(j);
                return this;
            }

            public final zzb zzan(long j) {
                zzazn();
                ((zza) this.zzhkp).zzg(j);
                return this;
            }

            public final zzb zzao(long j) {
                zzazn();
                ((zza) this.zzhkp).zzh(j);
                return this;
            }

            public final zzb zzap(long j) {
                zzazn();
                ((zza) this.zzhkp).zzi(j);
                return this;
            }

            public final zzb zzaq(long j) {
                zzazn();
                ((zza) this.zzhkp).zzj(j);
                return this;
            }

            public final zzb zzar(long j) {
                zzazn();
                ((zza) this.zzhkp).zzk(j);
                return this;
            }

            public final zzb zzas(long j) {
                zzazn();
                ((zza) this.zzhkp).zzl(j);
                return this;
            }

            public final zzb zzat(long j) {
                zzazn();
                ((zza) this.zzhkp).zzm(j);
                return this;
            }

            public final zzb zzau(long j) {
                zzazn();
                ((zza) this.zzhkp).zzn(j);
                return this;
            }

            public final zzb zzav(long j) {
                zzazn();
                ((zza) this.zzhkp).zzo(j);
                return this;
            }

            public final zzb zzaw(long j) {
                zzazn();
                ((zza) this.zzhkp).zzp(j);
                return this;
            }

            public final zzb zzab(String str) {
                zzazn();
                ((zza) this.zzhkp).zzs(str);
                return this;
            }

            public final zzb zzac(String str) {
                zzazn();
                ((zza) this.zzhkp).zzt(str);
                return this;
            }

            public final zzb zzax(long j) {
                zzazn();
                ((zza) this.zzhkp).zzq(j);
                return this;
            }

            public final zzb zzay(long j) {
                zzazn();
                ((zza) this.zzhkp).zzr(j);
                return this;
            }

            public final zzb zzaz(long j) {
                zzazn();
                ((zza) this.zzhkp).zzs(j);
                return this;
            }

            public final zzb zzad(String str) {
                zzazn();
                ((zza) this.zzhkp).zzu(str);
                return this;
            }

            public final zzb zzba(long j) {
                zzazn();
                ((zza) this.zzhkp).zzt(j);
                return this;
            }

            @Deprecated
            public final zzb zzbb(long j) {
                zzazn();
                ((zza) this.zzhkp).zzu(j);
                return this;
            }

            public final zzb zzbc(long j) {
                zzazn();
                ((zza) this.zzhkp).zzv(j);
                return this;
            }

            public final zzb zzbd(long j) {
                zzazn();
                ((zza) this.zzhkp).zzw(j);
                return this;
            }

            public final zzb zzbe(long j) {
                zzazn();
                ((zza) this.zzhkp).zzx(j);
                return this;
            }

            public final zzb zzbf(long j) {
                zzazn();
                ((zza) this.zzhkp).zzy(j);
                return this;
            }

            public final zzb zzbg(long j) {
                zzazn();
                ((zza) this.zzhkp).zzz(j);
                return this;
            }

            public final zzb zzbh(long j) {
                zzazn();
                ((zza) this.zzhkp).zzaa(j);
                return this;
            }

            public final zzb zzbi(long j) {
                zzazn();
                ((zza) this.zzhkp).zzab(j);
                return this;
            }

            public final zzb zzae(String str) {
                zzazn();
                ((zza) this.zzhkp).zzv(str);
                return this;
            }

            public final zzb zzaf(String str) {
                zzazn();
                ((zza) this.zzhkp).zzw(str);
                return this;
            }

            public final zzb zze(zzbz zzbz) {
                zzazn();
                ((zza) this.zzhkp).zza(zzbz);
                return this;
            }

            public final zzb zzf(zzbz zzbz) {
                zzazn();
                ((zza) this.zzhkp).zzb(zzbz);
                return this;
            }

            public final zzb zzbj(long j) {
                zzazn();
                ((zza) this.zzhkp).zzac(j);
                return this;
            }

            public final zzb zzbk(long j) {
                zzazn();
                ((zza) this.zzhkp).zzad(j);
                return this;
            }

            public final zzb zzbl(long j) {
                zzazn();
                ((zza) this.zzhkp).zzae(j);
                return this;
            }

            public final zzb zzg(zzbz zzbz) {
                zzazn();
                ((zza) this.zzhkp).zzc(zzbz);
                return this;
            }

            public final zzb zzc(zze zze) {
                zzazn();
                ((zza) this.zzhkp).zza(zze);
                return this;
            }

            public final zzb zzd(zze zze) {
                zzazn();
                ((zza) this.zzhkp).zzb(zze);
                return this;
            }

            public final zzb zzan() {
                zzazn();
                ((zza) this.zzhkp).zzai();
                return this;
            }

            public final zzb zzb(zzf zzf) {
                zzazn();
                ((zza) this.zzhkp).zza(zzf);
                return this;
            }

            public final zzb zzbm(long j) {
                zzazn();
                ((zza) this.zzhkp).zzaf(j);
                return this;
            }

            public final zzb zzbn(long j) {
                zzazn();
                ((zza) this.zzhkp).zzag(j);
                return this;
            }

            public final zzb zzbo(long j) {
                zzazn();
                ((zza) this.zzhkp).zzah(j);
                return this;
            }

            public final zzb zzbp(long j) {
                zzazn();
                ((zza) this.zzhkp).zzai(j);
                return this;
            }

            public final zzb zzbq(long j) {
                zzazn();
                ((zza) this.zzhkp).zzaj(j);
                return this;
            }

            public final zzb zzag(String str) {
                zzazn();
                ((zza) this.zzhkp).zzx(str);
                return this;
            }

            public final zzb zzb(zzf zzf) {
                zzazn();
                ((zza) this.zzhkp).zza(zzf);
                return this;
            }

            public final zzb zzh(zzbz zzbz) {
                zzazn();
                ((zza) this.zzhkp).zzd(zzbz);
                return this;
            }

            public final zzb zzah(String str) {
                zzazn();
                ((zza) this.zzhkp).zzy(str);
                return this;
            }

            public final zzb zzb(zzc zzc) {
                zzazn();
                ((zza) this.zzhkp).zza(zzc);
                return this;
            }

            public final zzb zzb(boolean z) {
                zzazn();
                ((zza) this.zzhkp).zza(z);
                return this;
            }

            public final zzb zzbr(long j) {
                zzazn();
                ((zza) this.zzhkp).zzak(j);
                return this;
            }

            /* synthetic */ zzb(zzbp zzbp) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public enum zzc implements zzdra {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6);
            
            private static final zzdqz<zzc> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
            }

            public static zzc zzh(int i) {
                switch (i) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    default:
                        return null;
                }
            }

            public static zzdrc zzac() {
                return zzbt.zzep;
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
                zzeg = new zzbs();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public enum zzd implements zzdra {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(512),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(2048),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(32768),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);
            
            private static final zzdqz<zzd> zzeg = null;
            private final int value;

            public final int zzab() {
                return this.value;
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

            private zzd(int i) {
                this.value = i;
            }

            static {
                zzeg = new zzbu();
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zze extends zzdqw<zze, C3502zza> implements zzdsi {
            private static volatile zzdsp<zze> zzdv;
            /* access modifiers changed from: private */
            public static final zze zzju;
            private int zzdj;
            private long zzfe = -1;
            private long zzff = -1;
            private long zzjb = -1;
            private long zzjc = -1;
            private long zzjd = -1;
            private long zzje = -1;
            private int zzjf = 1000;
            private long zzjg = -1;
            private long zzjh = -1;
            private long zzji = -1;
            private int zzjj = 1000;
            private long zzjk = -1;
            private long zzjl = -1;
            private long zzjm = -1;
            private long zzjn = -1;
            private long zzjo;
            private long zzjp;
            private long zzjq = -1;
            private long zzjr = -1;
            private long zzjs = -1;
            private long zzjt = -1;

            /* renamed from: com.google.android.gms.internal.ads.zzbo$zza$zze$zza reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
            public static final class C3502zza extends com.google.android.gms.internal.ads.zzdqw.zza<zze, C3502zza> implements zzdsi {
                private C3502zza() {
                    super(zze.zzju);
                }

                public final C3502zza zzcl(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzj(j);
                    return this;
                }

                public final C3502zza zzcm(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzk(j);
                    return this;
                }

                public final C3502zza zzcn(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzbs(j);
                    return this;
                }

                public final C3502zza zzco(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzbt(j);
                    return this;
                }

                public final C3502zza zzat() {
                    zzazn();
                    ((zze) this.zzhkp).zzao();
                    return this;
                }

                public final C3502zza zzcp(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzbu(j);
                    return this;
                }

                public final C3502zza zzcq(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzbv(j);
                    return this;
                }

                public final C3502zza zzk(zzbz zzbz) {
                    zzazn();
                    ((zze) this.zzhkp).zzi(zzbz);
                    return this;
                }

                public final C3502zza zzcr(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzbw(j);
                    return this;
                }

                public final C3502zza zzcs(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzbx(j);
                    return this;
                }

                public final C3502zza zzct(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzby(j);
                    return this;
                }

                public final C3502zza zzl(zzbz zzbz) {
                    zzazn();
                    ((zze) this.zzhkp).zzj(zzbz);
                    return this;
                }

                public final C3502zza zzcu(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzbz(j);
                    return this;
                }

                public final C3502zza zzcv(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzca(j);
                    return this;
                }

                public final C3502zza zzcw(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzcb(j);
                    return this;
                }

                public final C3502zza zzcx(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzcc(j);
                    return this;
                }

                public final C3502zza zzcy(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzcd(j);
                    return this;
                }

                public final C3502zza zzcz(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzce(j);
                    return this;
                }

                public final C3502zza zzda(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzcf(j);
                    return this;
                }

                public final C3502zza zzdb(long j) {
                    zzazn();
                    ((zze) this.zzhkp).zzcg(j);
                    return this;
                }

                /* synthetic */ C3502zza(zzbp zzbp) {
                    this();
                }
            }

            private zze() {
            }

            /* access modifiers changed from: private */
            public final void zzj(long j) {
                this.zzdj |= 1;
                this.zzfe = j;
            }

            /* access modifiers changed from: private */
            public final void zzk(long j) {
                this.zzdj |= 2;
                this.zzff = j;
            }

            /* access modifiers changed from: private */
            public final void zzbs(long j) {
                this.zzdj |= 4;
                this.zzjb = j;
            }

            /* access modifiers changed from: private */
            public final void zzbt(long j) {
                this.zzdj |= 8;
                this.zzjc = j;
            }

            /* access modifiers changed from: private */
            public final void zzao() {
                this.zzdj &= -9;
                this.zzjc = -1;
            }

            /* access modifiers changed from: private */
            public final void zzbu(long j) {
                this.zzdj |= 16;
                this.zzjd = j;
            }

            /* access modifiers changed from: private */
            public final void zzbv(long j) {
                this.zzdj |= 32;
                this.zzje = j;
            }

            /* access modifiers changed from: private */
            public final void zzi(zzbz zzbz) {
                if (zzbz != null) {
                    this.zzdj |= 64;
                    this.zzjf = zzbz.zzab();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzbw(long j) {
                this.zzdj |= 128;
                this.zzjg = j;
            }

            /* access modifiers changed from: private */
            public final void zzbx(long j) {
                this.zzdj |= 256;
                this.zzjh = j;
            }

            /* access modifiers changed from: private */
            public final void zzby(long j) {
                this.zzdj |= 512;
                this.zzji = j;
            }

            /* access modifiers changed from: private */
            public final void zzj(zzbz zzbz) {
                if (zzbz != null) {
                    this.zzdj |= 1024;
                    this.zzjj = zzbz.zzab();
                    return;
                }
                throw new NullPointerException();
            }

            /* access modifiers changed from: private */
            public final void zzbz(long j) {
                this.zzdj |= 2048;
                this.zzjk = j;
            }

            /* access modifiers changed from: private */
            public final void zzca(long j) {
                this.zzdj |= 4096;
                this.zzjl = j;
            }

            /* access modifiers changed from: private */
            public final void zzcb(long j) {
                this.zzdj |= 8192;
                this.zzjm = j;
            }

            /* access modifiers changed from: private */
            public final void zzcc(long j) {
                this.zzdj |= 16384;
                this.zzjn = j;
            }

            /* access modifiers changed from: private */
            public final void zzcd(long j) {
                this.zzdj |= 32768;
                this.zzjo = j;
            }

            /* access modifiers changed from: private */
            public final void zzce(long j) {
                this.zzdj |= 65536;
                this.zzjp = j;
            }

            /* access modifiers changed from: private */
            public final void zzcf(long j) {
                this.zzdj |= 131072;
                this.zzjq = j;
            }

            /* access modifiers changed from: private */
            public final void zzcg(long j) {
                this.zzdj |= 262144;
                this.zzjr = j;
            }

            public static C3502zza zzap() {
                return (C3502zza) zzju.zzazt();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbp.zzdi[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C3502zza(null);
                    case 3:
                        return zza((zzdsg) zzju, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\f\u0006\b\u0002\u0007\t\u0002\b\n\u0002\t\u000b\f\n\f\u0002\u000b\r\u0002\f\u000e\u0002\r\u000f\u0002\u000e\u0010\u0002\u000f\u0011\u0002\u0010\u0012\u0002\u0011\u0013\u0002\u0012\u0014\u0002\u0013\u0015\u0002\u0014", new Object[]{"zzdj", "zzfe", "zzff", "zzjb", "zzjc", "zzjd", "zzje", "zzjf", zzbz.zzac(), "zzjg", "zzjh", "zzji", "zzjj", zzbz.zzac(), "zzjk", "zzjl", "zzjm", "zzjn", "zzjo", "zzjp", "zzjq", "zzjr", "zzjs", "zzjt"});
                    case 4:
                        return zzju;
                    case 5:
                        zzdsp<zze> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zze.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzju);
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
                zzju = zze;
                zzdqw.zza(zze.class, zze);
            }
        }

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zzf extends zzdqw<zzf, C3503zza> implements zzdsi {
            private static volatile zzdsp<zzf> zzdv;
            /* access modifiers changed from: private */
            public static final zzf zzjz;
            private int zzdj;
            private long zzgh = -1;
            private long zzgi = -1;
            private long zzjv = -1;
            private long zzjw = -1;
            private long zzjx = -1;
            private long zzjy = -1;

            /* renamed from: com.google.android.gms.internal.ads.zzbo$zza$zzf$zza reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
            public static final class C3503zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzf, C3503zza> implements zzdsi {
                private C3503zza() {
                    super(zzf.zzjz);
                }

                public final C3503zza zzdc(long j) {
                    zzazn();
                    ((zzf) this.zzhkp).zzch(j);
                    return this;
                }

                public final C3503zza zzdd(long j) {
                    zzazn();
                    ((zzf) this.zzhkp).zzci(j);
                    return this;
                }

                public final C3503zza zzde(long j) {
                    zzazn();
                    ((zzf) this.zzhkp).zzcj(j);
                    return this;
                }

                public final C3503zza zzdf(long j) {
                    zzazn();
                    ((zzf) this.zzhkp).zzck(j);
                    return this;
                }

                /* synthetic */ C3503zza(zzbp zzbp) {
                    this();
                }
            }

            private zzf() {
            }

            /* access modifiers changed from: private */
            public final void zzch(long j) {
                this.zzdj |= 4;
                this.zzjv = j;
            }

            /* access modifiers changed from: private */
            public final void zzci(long j) {
                this.zzdj |= 8;
                this.zzjw = j;
            }

            /* access modifiers changed from: private */
            public final void zzcj(long j) {
                this.zzdj |= 16;
                this.zzjx = j;
            }

            /* access modifiers changed from: private */
            public final void zzck(long j) {
                this.zzdj |= 32;
                this.zzjy = j;
            }

            public static C3503zza zzar() {
                return (C3503zza) zzjz.zzazt();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbp.zzdi[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C3503zza(null);
                    case 3:
                        return zza((zzdsg) zzjz, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005", new Object[]{"zzdj", "zzgh", "zzgi", "zzjv", "zzjw", "zzjx", "zzjy"});
                    case 4:
                        return zzjz;
                    case 5:
                        zzdsp<zzf> zzdsp = zzdv;
                        if (zzdsp == null) {
                            synchronized (zzf.class) {
                                zzdsp = zzdv;
                                if (zzdsp == null) {
                                    zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzjz);
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
                zzjz = zzf;
                zzdqw.zza(zzf.class, zzf);
            }
        }

        private zza() {
            String str = "";
            this.zzes = str;
            this.zzdt = str;
            this.zzfd = str;
            this.zzei = str;
            this.zzfn = str;
            this.zzek = str;
            String str2 = "D";
            this.zzel = str2;
            this.zzem = str2;
            this.zzgb = -1;
            this.zzgc = 1000;
            this.zzgd = 1000;
            this.zzge = -1;
            this.zzgf = -1;
            this.zzgg = -1;
            this.zzgh = -1;
            this.zzgi = -1;
            this.zzgj = 1000;
            this.zzgl = zzazw();
            this.zzgn = -1;
            this.zzgo = -1;
            this.zzgp = -1;
            this.zzgq = -1;
            this.zzgr = -1;
            this.zzgs = -1;
            this.zzgt = -1;
            this.zzgu = -1;
            this.zzgv = str2;
            this.zzgw = -1;
            this.zzhb = -1;
            this.zzhc = 1000;
            this.zzhe = str;
            this.zzhf = 2;
            this.zzhh = str;
        }

        /* access modifiers changed from: private */
        public final void zzq(String str) {
            if (str != null) {
                this.zzdj |= 1;
                this.zzes = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzr(String str) {
            if (str != null) {
                this.zzdj |= 2;
                this.zzdt = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zze(long j) {
            this.zzdj |= 4;
            this.zzet = j;
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzdj |= 16;
            this.zzev = j;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzdj |= 32;
            this.zzew = j;
        }

        /* access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzdj |= 1024;
            this.zzfb = j;
        }

        /* access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzdj |= 2048;
            this.zzfc = j;
        }

        /* access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzdj |= 8192;
            this.zzfe = j;
        }

        /* access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzdj |= 16384;
            this.zzff = j;
        }

        /* access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzdj |= 32768;
            this.zzfg = j;
        }

        /* access modifiers changed from: private */
        public final void zzm(long j) {
            this.zzdj |= 65536;
            this.zzfh = j;
        }

        /* access modifiers changed from: private */
        public final void zzn(long j) {
            this.zzdj |= 524288;
            this.zzfk = j;
        }

        /* access modifiers changed from: private */
        public final void zzo(long j) {
            this.zzdj |= 1048576;
            this.zzfl = j;
        }

        /* access modifiers changed from: private */
        public final void zzp(long j) {
            this.zzdj |= 2097152;
            this.zzfm = j;
        }

        public final boolean zzah() {
            return (this.zzdj & 4194304) != 0;
        }

        public final String zzad() {
            return this.zzei;
        }

        /* access modifiers changed from: private */
        public final void zzs(String str) {
            if (str != null) {
                this.zzdj |= 4194304;
                this.zzei = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzt(String str) {
            if (str != null) {
                this.zzdj |= 8388608;
                this.zzfn = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzq(long j) {
            this.zzdj |= 16777216;
            this.zzfo = j;
        }

        /* access modifiers changed from: private */
        public final void zzr(long j) {
            this.zzdj |= 33554432;
            this.zzfp = j;
        }

        /* access modifiers changed from: private */
        public final void zzs(long j) {
            this.zzdj |= 67108864;
            this.zzfq = j;
        }

        /* access modifiers changed from: private */
        public final void zzu(String str) {
            if (str != null) {
                this.zzdj |= 134217728;
                this.zzek = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzt(long j) {
            this.zzdj |= DriveFile.MODE_READ_ONLY;
            this.zzfr = j;
        }

        /* access modifiers changed from: private */
        public final void zzu(long j) {
            this.zzdj |= DriveFile.MODE_WRITE_ONLY;
            this.zzfs = j;
        }

        /* access modifiers changed from: private */
        public final void zzv(long j) {
            this.zzdj |= 1073741824;
            this.zzft = j;
        }

        /* access modifiers changed from: private */
        public final void zzw(long j) {
            this.zzeq |= 1;
            this.zzfv = j;
        }

        /* access modifiers changed from: private */
        public final void zzx(long j) {
            this.zzeq |= 2;
            this.zzfw = j;
        }

        /* access modifiers changed from: private */
        public final void zzy(long j) {
            this.zzeq |= 4;
            this.zzfx = j;
        }

        /* access modifiers changed from: private */
        public final void zzz(long j) {
            this.zzeq |= 8;
            this.zzfy = j;
        }

        /* access modifiers changed from: private */
        public final void zzaa(long j) {
            this.zzeq |= 16;
            this.zzfz = j;
        }

        /* access modifiers changed from: private */
        public final void zzab(long j) {
            this.zzeq |= 32;
            this.zzga = j;
        }

        /* access modifiers changed from: private */
        public final void zzv(String str) {
            if (str != null) {
                this.zzeq |= 64;
                this.zzel = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzw(String str) {
            if (str != null) {
                this.zzeq |= 128;
                this.zzem = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzbz zzbz) {
            if (zzbz != null) {
                this.zzeq |= 512;
                this.zzgc = zzbz.zzab();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(zzbz zzbz) {
            if (zzbz != null) {
                this.zzeq |= 1024;
                this.zzgd = zzbz.zzab();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzac(long j) {
            this.zzeq |= 2048;
            this.zzge = j;
        }

        /* access modifiers changed from: private */
        public final void zzad(long j) {
            this.zzeq |= 4096;
            this.zzgf = j;
        }

        /* access modifiers changed from: private */
        public final void zzae(long j) {
            this.zzeq |= 8192;
            this.zzgg = j;
        }

        /* access modifiers changed from: private */
        public final void zzc(zzbz zzbz) {
            if (zzbz != null) {
                this.zzeq |= 65536;
                this.zzgj = zzbz.zzab();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze2) {
            if (zze2 != null) {
                this.zzgk = zze2;
                this.zzeq |= 131072;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(zze zze2) {
            if (zze2 != null) {
                if (!this.zzgl.zzaxi()) {
                    this.zzgl = zzdqw.zza(this.zzgl);
                }
                this.zzgl.add(zze2);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzai() {
            this.zzgl = zzazw();
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf2) {
            if (zzf2 != null) {
                this.zzgm = zzf2;
                this.zzeq |= 262144;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzaf(long j) {
            this.zzeq |= 1048576;
            this.zzgo = j;
        }

        /* access modifiers changed from: private */
        public final void zzag(long j) {
            this.zzeq |= 2097152;
            this.zzgp = j;
        }

        /* access modifiers changed from: private */
        public final void zzah(long j) {
            this.zzeq |= 4194304;
            this.zzgq = j;
        }

        /* access modifiers changed from: private */
        public final void zzai(long j) {
            this.zzeq |= 33554432;
            this.zzgt = j;
        }

        /* access modifiers changed from: private */
        public final void zzaj(long j) {
            this.zzeq |= 67108864;
            this.zzgu = j;
        }

        /* access modifiers changed from: private */
        public final void zzx(String str) {
            if (str != null) {
                this.zzeq |= 134217728;
                this.zzgv = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf2) {
            if (zzf2 != null) {
                this.zzha = zzf2;
                this.zzer |= 1;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzd(zzbz zzbz) {
            if (zzbz != null) {
                this.zzer |= 4;
                this.zzhc = zzbz.zzab();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzy(String str) {
            if (str != null) {
                this.zzer |= 16;
                this.zzhe = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            if (zzc2 != null) {
                this.zzer |= 32;
                this.zzhf = zzc2.zzab();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzer |= 64;
            this.zzhg = z;
        }

        /* access modifiers changed from: private */
        public final void zzak(long j) {
            this.zzer |= 256;
            this.zzhi = j;
        }

        public final boolean zzaj() {
            return (this.zzer & 512) != 0;
        }

        public final zze zzak() {
            zze zze2 = this.zzhj;
            return zze2 == null ? zze.zzbf() : zze2;
        }

        public static zza zzb(byte[] bArr, zzdqj zzdqj) throws zzdrg {
            return (zza) zzdqw.zza(zzhk, bArr, zzdqj);
        }

        public static zzb zzal() {
            return (zzb) zzhk.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zzdi[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(null);
                case 3:
                    return zza((zzdsg) zzhk, "\u0001K\u0000\u0003\u0001ÉK\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\u0002\u0007\t\u0002\b\n\u0002\t\u000b\u0002\n\f\u0002\u000b\r\b\f\u000e\u0002\r\u000f\u0002\u000e\u0010\u0002\u000f\u0011\u0002\u0010\u0012\u0002\u0011\u0013\u0002\u0012\u0014\u0002\u0013\u0015\u0002C\u0016\u0002\u0014\u0017\u0002\u0015\u0018\bD\u0019\u0002H\u001a\fE\u001b\b\u0016\u001c\u0007F\u001d\b\u0017\u001e\bG\u001f\u0002\u0018 \u0002\u0019!\u0002\u001a\"\b\u001b#\u0002\u001c$\u0002\u001d%\u0002\u001e&\t\u001f'\u0002 (\u0002!)\u0002\"*\u0002#+\u001b,\u0002$-\u0002%.\b&/\b'0\f)1\f*2\t13\u0002+4\u0002,5\u0002-6\u0002.7\u0002/8\f09\t2:\u00023;\u00024<\u00025=\u00026>\u00029?\u0002:@\u0002<A\f=B\f>C\b;D\f?E\t@F\u0002AG\u00027H\u00028I\fBJ\u0002(É\tI", new Object[]{"zzdj", "zzeq", "zzer", "zzes", "zzdt", "zzet", "zzeu", "zzev", "zzew", "zzex", "zzey", "zzez", "zzfa", "zzfb", "zzfc", "zzfd", "zzfe", "zzff", "zzfg", "zzfh", "zzfi", "zzfj", "zzfk", "zzhd", "zzfl", "zzfm", "zzhe", "zzhi", "zzhf", zzc.zzac(), "zzei", "zzhg", "zzfn", "zzhh", "zzfo", "zzfp", "zzfq", "zzek", "zzfr", "zzfs", "zzft", "zzfu", "zzfv", "zzfw", "zzfx", "zzfy", "zzgl", zze.class, "zzfz", "zzga", "zzel", "zzem", "zzgc", zzbz.zzac(), "zzgd", zzbz.zzac(), "zzgk", "zzge", "zzgf", "zzgg", "zzgh", "zzgi", "zzgj", zzbz.zzac(), "zzgm", "zzgn", "zzgo", "zzgp", "zzgq", "zzgt", "zzgu", "zzgw", "zzgx", zzbv.zzac(), "zzgy", zzca.zzac(), "zzgv", "zzgz", C3501zza.zzac(), "zzha", "zzhb", "zzgr", "zzgs", "zzhc", zzbz.zzac(), "zzgb", "zzhj"});
                case 4:
                    return zzhk;
                case 5:
                    zzdsp<zza> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zza.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzhk);
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
            zzhk = zza;
            zzdqw.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zzb extends zzdqw<zzb, zza> implements zzdsi {
        private static volatile zzdsp<zzb> zzdv;
        /* access modifiers changed from: private */
        public static final zzb zzkf;
        private int zzdj;
        private long zzka;
        private int zzkb;
        private boolean zzkc;
        private zzdrb zzkd = zzazv();
        private long zzke;

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzb, zza> implements zzdsi {
            private zza() {
                super(zzb.zzkf);
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        private zzb() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zzdi[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzkf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u0002\u0000\u0002\u0004\u0001\u0003\u0007\u0002\u0004\u0016\u0005\u0003\u0003", new Object[]{"zzdj", "zzka", "zzkb", "zzkc", "zzkd", "zzke"});
                case 4:
                    return zzkf;
                case 5:
                    zzdsp<zzb> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzb.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzkf);
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
            zzkf = zzb;
            zzdqw.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zzc extends zzdqw<zzc, zza> implements zzdsi {
        private static volatile zzdsp<zzc> zzdv;
        /* access modifiers changed from: private */
        public static final zzc zzki;
        private int zzdj;
        private zzdpm zzkg = zzdpm.zzhgb;
        private zzdpm zzkh = zzdpm.zzhgb;

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzc, zza> implements zzdsi {
            private zza() {
                super(zzc.zzki);
            }

            public final zza zzg(zzdpm zzdpm) {
                zzazn();
                ((zzc) this.zzhkp).zza(zzdpm);
                return this;
            }

            public final zza zzh(zzdpm zzdpm) {
                zzazn();
                ((zzc) this.zzhkp).zzb(zzdpm);
                return this;
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        private zzc() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzdpm zzdpm) {
            if (zzdpm != null) {
                this.zzdj |= 1;
                this.zzkg = zzdpm;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(zzdpm zzdpm) {
            if (zzdpm != null) {
                this.zzdj |= 2;
                this.zzkh = zzdpm;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzav() {
            return (zza) zzki.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zzdi[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzki, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001", new Object[]{"zzdj", "zzkg", "zzkh"});
                case 4:
                    return zzki;
                case 5:
                    zzdsp<zzc> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzc.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzki);
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
            zzki = zzc;
            zzdqw.zza(zzc.class, zzc);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zzd extends zzdqw<zzd, zza> implements zzdsi {
        private static volatile zzdsp<zzd> zzdv;
        /* access modifiers changed from: private */
        public static final zzd zzkn;
        private int zzdj;
        private zzdpm zzkj = zzdpm.zzhgb;
        private zzdpm zzkk = zzdpm.zzhgb;
        private zzdpm zzkl = zzdpm.zzhgb;
        private zzdpm zzkm = zzdpm.zzhgb;

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzd, zza> implements zzdsi {
            private zza() {
                super(zzd.zzkn);
            }

            public final zza zzi(zzdpm zzdpm) {
                zzazn();
                ((zzd) this.zzhkp).zzc(zzdpm);
                return this;
            }

            public final zza zzj(zzdpm zzdpm) {
                zzazn();
                ((zzd) this.zzhkp).zzd(zzdpm);
                return this;
            }

            public final zza zzk(zzdpm zzdpm) {
                zzazn();
                ((zzd) this.zzhkp).zze(zzdpm);
                return this;
            }

            public final zza zzl(zzdpm zzdpm) {
                zzazn();
                ((zzd) this.zzhkp).zzf(zzdpm);
                return this;
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        private zzd() {
        }

        public final zzdpm zzax() {
            return this.zzkj;
        }

        /* access modifiers changed from: private */
        public final void zzc(zzdpm zzdpm) {
            if (zzdpm != null) {
                this.zzdj |= 1;
                this.zzkj = zzdpm;
                return;
            }
            throw new NullPointerException();
        }

        public final zzdpm zzay() {
            return this.zzkk;
        }

        /* access modifiers changed from: private */
        public final void zzd(zzdpm zzdpm) {
            if (zzdpm != null) {
                this.zzdj |= 2;
                this.zzkk = zzdpm;
                return;
            }
            throw new NullPointerException();
        }

        public final zzdpm zzaz() {
            return this.zzkl;
        }

        /* access modifiers changed from: private */
        public final void zze(zzdpm zzdpm) {
            if (zzdpm != null) {
                this.zzdj |= 4;
                this.zzkl = zzdpm;
                return;
            }
            throw new NullPointerException();
        }

        public final zzdpm zzba() {
            return this.zzkm;
        }

        /* access modifiers changed from: private */
        public final void zzf(zzdpm zzdpm) {
            if (zzdpm != null) {
                this.zzdj |= 8;
                this.zzkm = zzdpm;
                return;
            }
            throw new NullPointerException();
        }

        public static zzd zzc(byte[] bArr, zzdqj zzdqj) throws zzdrg {
            return (zzd) zzdqw.zza(zzkn, bArr, zzdqj);
        }

        public static zza zzbb() {
            return (zza) zzkn.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zzdi[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzkn, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002\u0004\n\u0003", new Object[]{"zzdj", "zzkj", "zzkk", "zzkl", "zzkm"});
                case 4:
                    return zzkn;
                case 5:
                    zzdsp<zzd> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzd.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzkn);
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
            zzkn = zzd;
            zzdqw.zza(zzd.class, zzd);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zze extends zzdqw<zze, zza> implements zzdsi {
        private static volatile zzdsp<zze> zzdv;
        /* access modifiers changed from: private */
        public static final zze zzlf;
        private int zzdj;
        private long zzka;
        private String zzld = "";
        private zzdpm zzle = zzdpm.zzhgb;

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zze, zza> implements zzdsi {
            private zza() {
                super(zze.zzlf);
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        private zze() {
        }

        public final boolean zzbd() {
            return (this.zzdj & 1) != 0;
        }

        public final long zzbe() {
            return this.zzka;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zzdi[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzlf, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0003\b\u0001\u0004\n\u0002", new Object[]{"zzdj", "zzka", "zzld", "zzle"});
                case 4:
                    return zzlf;
                case 5:
                    zzdsp<zze> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zze.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzlf);
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

        public static zze zzbf() {
            return zzlf;
        }

        static {
            zze zze = new zze();
            zzlf = zze;
            zzdqw.zza(zze.class, zze);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zzf extends zzdqw<zzf, zza> implements zzdsi {
        private static volatile zzdsp<zzf> zzdv;
        /* access modifiers changed from: private */
        public static final zzf zzlg;
        private int zzdj;
        private String zzen = "";

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzf, zza> implements zzdsi {
            private zza() {
                super(zzf.zzlg);
            }

            public final zza zzai(String str) {
                zzazn();
                ((zzf) this.zzhkp).zzaj(str);
                return this;
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        private zzf() {
        }

        /* access modifiers changed from: private */
        public final void zzaj(String str) {
            if (str != null) {
                this.zzdj |= 1;
                this.zzen = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzbh() {
            return (zza) zzlg.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zzdi[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzlg, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdj", "zzen"});
                case 4:
                    return zzlg;
                case 5:
                    zzdsp<zzf> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzf.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzlg);
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
            zzlg = zzf;
            zzdqw.zza(zzf.class, zzf);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
    public static final class zzg extends zzdqw<zzg, zza> implements zzdsi {
        private static volatile zzdsp<zzg> zzdv;
        /* access modifiers changed from: private */
        public static final zzg zzli;
        private int zzdj;
        private int zzgx = 1;
        private int zzgy = 1;
        private zzdpm zzkk = zzdpm.zzhgb;
        private zzdrd<zzdpm> zzlh = zzazw();

        /* compiled from: com.google.android.gms:play-services-gass@@18.2.0 */
        public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzg, zza> implements zzdsi {
            private zza() {
                super(zzg.zzli);
            }

            public final zza zzm(zzdpm zzdpm) {
                zzazn();
                ((zzg) this.zzhkp).zzo(zzdpm);
                return this;
            }

            public final zza zzn(zzdpm zzdpm) {
                zzazn();
                ((zzg) this.zzhkp).zzd(zzdpm);
                return this;
            }

            public final zza zza(zzbv zzbv) {
                zzazn();
                ((zzg) this.zzhkp).zzb(zzbv);
                return this;
            }

            /* synthetic */ zza(zzbp zzbp) {
                this();
            }
        }

        private zzg() {
        }

        /* access modifiers changed from: private */
        public final void zzo(zzdpm zzdpm) {
            if (zzdpm != null) {
                if (!this.zzlh.zzaxi()) {
                    this.zzlh = zzdqw.zza(this.zzlh);
                }
                this.zzlh.add(zzdpm);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzd(zzdpm zzdpm) {
            if (zzdpm != null) {
                this.zzdj |= 1;
                this.zzkk = zzdpm;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(zzbv zzbv) {
            if (zzbv != null) {
                this.zzdj |= 4;
                this.zzgx = zzbv.zzab();
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzbj() {
            return (zza) zzli.zzazt();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zzdi[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(null);
                case 3:
                    return zza((zzdsg) zzli, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002\n\u0000\u0003\f\u0001\u0004\f\u0002", new Object[]{"zzdj", "zzlh", "zzkk", "zzgy", zzca.zzac(), "zzgx", zzbv.zzac()});
                case 4:
                    return zzli;
                case 5:
                    zzdsp<zzg> zzdsp = zzdv;
                    if (zzdsp == null) {
                        synchronized (zzg.class) {
                            zzdsp = zzdv;
                            if (zzdsp == null) {
                                zzdsp = new com.google.android.gms.internal.ads.zzdqw.zzc<>(zzli);
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
            zzli = zzg;
            zzdqw.zza(zzg.class, zzg);
        }
    }
}
