package com.google.android.gms.internal.drive;

import java.io.IOException;

public final class zzhm extends zzir<zzhm> {
    public int versionCode;
    public long zze;
    public long zzf;
    public long zzg;

    public zzhm() {
        this.versionCode = 1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzmw = null;
        this.zznf = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhm)) {
            return false;
        }
        zzhm zzhm = (zzhm) obj;
        if (this.versionCode == zzhm.versionCode && this.zze == zzhm.zze && this.zzf == zzhm.zzf && this.zzg == zzhm.zzg) {
            return (this.zzmw == null || this.zzmw.isEmpty()) ? zzhm.zzmw == null || zzhm.zzmw.isEmpty() : this.zzmw.equals(zzhm.zzmw);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31;
        long j = this.zze;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.zzf;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.zzg;
        return ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((this.zzmw == null || this.zzmw.isEmpty()) ? 0 : this.zzmw.hashCode());
    }

    public final /* synthetic */ zzix zza(zzio zzio) throws IOException {
        while (true) {
            int zzbd = zzio.zzbd();
            if (zzbd == 0) {
                return this;
            }
            if (zzbd == 8) {
                this.versionCode = zzio.zzbe();
            } else if (zzbd == 16) {
                long zzbf = zzio.zzbf();
                this.zze = (-(zzbf & 1)) ^ (zzbf >>> 1);
            } else if (zzbd == 24) {
                long zzbf2 = zzio.zzbf();
                this.zzf = (-(zzbf2 & 1)) ^ (zzbf2 >>> 1);
            } else if (zzbd == 32) {
                long zzbf3 = zzio.zzbf();
                this.zzg = (-(zzbf3 & 1)) ^ (zzbf3 >>> 1);
            } else if (!super.zza(zzio, zzbd)) {
                return this;
            }
        }
    }

    public final void zza(zzip zzip) throws IOException {
        zzip.zzb(1, this.versionCode);
        zzip.zza(2, this.zze);
        zzip.zza(3, this.zzf);
        zzip.zza(4, this.zzg);
        super.zza(zzip);
    }

    /* access modifiers changed from: protected */
    public final int zzaq() {
        return super.zzaq() + zzip.zzc(1, this.versionCode) + zzip.zzb(2, this.zze) + zzip.zzb(3, this.zzf) + zzip.zzb(4, this.zzg);
    }
}
