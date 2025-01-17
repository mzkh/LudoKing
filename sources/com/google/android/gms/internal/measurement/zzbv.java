package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbk.zza;
import com.google.android.gms.internal.measurement.zzbk.zzd;
import java.io.IOException;

public final class zzbv extends zziq<zzbv> {
    private static volatile zzbv[] zzze;
    public Integer zzzf;
    public zzd[] zzzg;
    public zza[] zzzh;
    private Boolean zzzi;
    private Boolean zzzj;

    public static zzbv[] zzqx() {
        if (zzze == null) {
            synchronized (zziu.zzaov) {
                if (zzze == null) {
                    zzze = new zzbv[0];
                }
            }
        }
        return zzze;
    }

    public zzbv() {
        this.zzzf = null;
        this.zzzg = new zzd[0];
        this.zzzh = new zza[0];
        this.zzzi = null;
        this.zzzj = null;
        this.zzaoo = null;
        this.zzaow = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbv)) {
            return false;
        }
        zzbv zzbv = (zzbv) obj;
        Integer num = this.zzzf;
        if (num == null) {
            if (zzbv.zzzf != null) {
                return false;
            }
        } else if (!num.equals(zzbv.zzzf)) {
            return false;
        }
        if (!zziu.equals(this.zzzg, zzbv.zzzg) || !zziu.equals(this.zzzh, zzbv.zzzh)) {
            return false;
        }
        Boolean bool = this.zzzi;
        if (bool == null) {
            if (zzbv.zzzi != null) {
                return false;
            }
        } else if (!bool.equals(zzbv.zzzi)) {
            return false;
        }
        Boolean bool2 = this.zzzj;
        if (bool2 == null) {
            if (zzbv.zzzj != null) {
                return false;
            }
        } else if (!bool2.equals(zzbv.zzzj)) {
            return false;
        }
        if (this.zzaoo == null || this.zzaoo.isEmpty()) {
            return zzbv.zzaoo == null || zzbv.zzaoo.isEmpty();
        }
        return this.zzaoo.equals(zzbv.zzaoo);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzzf;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zziu.hashCode(this.zzzg)) * 31) + zziu.hashCode(this.zzzh)) * 31;
        Boolean bool = this.zzzi;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzzj;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        if (this.zzaoo != null && !this.zzaoo.isEmpty()) {
            i = this.zzaoo.hashCode();
        }
        return hashCode4 + i;
    }

    public final void zza(zzio zzio) throws IOException {
        Integer num = this.zzzf;
        if (num != null) {
            zzio.zzc(1, num.intValue());
        }
        zzd[] zzdArr = this.zzzg;
        int i = 0;
        if (zzdArr != null && zzdArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzd[] zzdArr2 = this.zzzg;
                if (i2 >= zzdArr2.length) {
                    break;
                }
                zzd zzd = zzdArr2[i2];
                if (zzd != null) {
                    zzio.zze(2, zzd);
                }
                i2++;
            }
        }
        zza[] zzaArr = this.zzzh;
        if (zzaArr != null && zzaArr.length > 0) {
            while (true) {
                zza[] zzaArr2 = this.zzzh;
                if (i >= zzaArr2.length) {
                    break;
                }
                zza zza = zzaArr2[i];
                if (zza != null) {
                    zzio.zze(3, zza);
                }
                i++;
            }
        }
        Boolean bool = this.zzzi;
        if (bool != null) {
            zzio.zzb(4, bool.booleanValue());
        }
        Boolean bool2 = this.zzzj;
        if (bool2 != null) {
            zzio.zzb(5, bool2.booleanValue());
        }
        super.zza(zzio);
    }

    /* access modifiers changed from: protected */
    public final int zzqy() {
        int zzqy = super.zzqy();
        Integer num = this.zzzf;
        if (num != null) {
            zzqy += zzio.zzg(1, num.intValue());
        }
        zzd[] zzdArr = this.zzzg;
        int i = 0;
        if (zzdArr != null && zzdArr.length > 0) {
            int i2 = zzqy;
            int i3 = 0;
            while (true) {
                zzd[] zzdArr2 = this.zzzg;
                if (i3 >= zzdArr2.length) {
                    break;
                }
                zzd zzd = zzdArr2[i3];
                if (zzd != null) {
                    i2 += zzee.zzc(2, (zzgi) zzd);
                }
                i3++;
            }
            zzqy = i2;
        }
        zza[] zzaArr = this.zzzh;
        if (zzaArr != null && zzaArr.length > 0) {
            while (true) {
                zza[] zzaArr2 = this.zzzh;
                if (i >= zzaArr2.length) {
                    break;
                }
                zza zza = zzaArr2[i];
                if (zza != null) {
                    zzqy += zzee.zzc(3, (zzgi) zza);
                }
                i++;
            }
        }
        Boolean bool = this.zzzi;
        if (bool != null) {
            bool.booleanValue();
            zzqy += zzio.zzbi(4) + 1;
        }
        Boolean bool2 = this.zzzj;
        if (bool2 == null) {
            return zzqy;
        }
        bool2.booleanValue();
        return zzqy + zzio.zzbi(5) + 1;
    }

    public final /* synthetic */ zziw zza(zzil zzil) throws IOException {
        while (true) {
            int zzsg = zzil.zzsg();
            if (zzsg == 0) {
                return this;
            }
            if (zzsg == 8) {
                this.zzzf = Integer.valueOf(zzil.zzta());
            } else if (zzsg == 18) {
                int zzb = zzix.zzb(zzil, 18);
                zzd[] zzdArr = this.zzzg;
                int length = zzdArr == null ? 0 : zzdArr.length;
                zzd[] zzdArr2 = new zzd[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzzg, 0, zzdArr2, 0, length);
                }
                while (length < zzdArr2.length - 1) {
                    zzdArr2[length] = (zzd) zzil.zza(zzd.zzkj());
                    zzil.zzsg();
                    length++;
                }
                zzdArr2[length] = (zzd) zzil.zza(zzd.zzkj());
                this.zzzg = zzdArr2;
            } else if (zzsg == 26) {
                int zzb2 = zzix.zzb(zzil, 26);
                zza[] zzaArr = this.zzzh;
                int length2 = zzaArr == null ? 0 : zzaArr.length;
                zza[] zzaArr2 = new zza[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzzh, 0, zzaArr2, 0, length2);
                }
                while (length2 < zzaArr2.length - 1) {
                    zzaArr2[length2] = (zza) zzil.zza(zza.zzkj());
                    zzil.zzsg();
                    length2++;
                }
                zzaArr2[length2] = (zza) zzil.zza(zza.zzkj());
                this.zzzh = zzaArr2;
            } else if (zzsg == 32) {
                this.zzzi = Boolean.valueOf(zzil.zzsm());
            } else if (zzsg == 40) {
                this.zzzj = Boolean.valueOf(zzil.zzsm());
            } else if (!super.zza(zzil, zzsg)) {
                return this;
            }
        }
    }
}
