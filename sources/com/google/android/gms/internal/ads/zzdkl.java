package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqw.zzc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdkl extends zzdqw<zzdkl, zza> implements zzdsi {
    private static volatile zzdsp<zzdkl> zzdv;
    /* access modifiers changed from: private */
    public static final zzdkl zzgzj;
    private String zzgzh = "";
    private zzdrd<zzdju> zzgzi = zzazw();

    /* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
    public static final class zza extends com.google.android.gms.internal.ads.zzdqw.zza<zzdkl, zza> implements zzdsi {
        private zza() {
            super(zzdkl.zzgzj);
        }

        public final zza zzhe(String str) {
            zzazn();
            ((zzdkl) this.zzhkp).zzhd(str);
            return this;
        }

        public final zza zzb(zzdju zzdju) {
            zzazn();
            ((zzdkl) this.zzhkp).zza(zzdju);
            return this;
        }

        /* synthetic */ zza(zzdkk zzdkk) {
            this();
        }
    }

    private zzdkl() {
    }

    /* access modifiers changed from: private */
    public final void zzhd(String str) {
        if (str != null) {
            this.zzgzh = str;
            return;
        }
        throw new NullPointerException();
    }

    public final List<zzdju> zzavj() {
        return this.zzgzi;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdju zzdju) {
        if (zzdju != null) {
            if (!this.zzgzi.zzaxi()) {
                this.zzgzi = zzdqw.zza(this.zzgzi);
            }
            this.zzgzi.add(zzdju);
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzavk() {
        return (zza) zzgzj.zzazt();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdkk.zzdi[i - 1]) {
            case 1:
                return new zzdkl();
            case 2:
                return new zza(null);
            case 3:
                return zza((zzdsg) zzgzj, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzgzh", "zzgzi", zzdju.class});
            case 4:
                return zzgzj;
            case 5:
                zzdsp<zzdkl> zzdsp = zzdv;
                if (zzdsp == null) {
                    synchronized (zzdkl.class) {
                        zzdsp = zzdv;
                        if (zzdsp == null) {
                            zzdsp = new zzc<>(zzgzj);
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
        zzdkl zzdkl = new zzdkl();
        zzgzj = zzdkl;
        zzdqw.zza(zzdkl.class, zzdkl);
    }
}
