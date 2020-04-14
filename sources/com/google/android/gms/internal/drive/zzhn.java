package com.google.android.gms.internal.drive;

import java.io.IOException;

public final class zzhn extends zzir<zzhn> {
    public int versionCode;
    public String zzab;
    public long zzac;
    public int zzad;
    public long zzf;

    public zzhn() {
        this.versionCode = 1;
        this.zzab = "";
        this.zzac = -1;
        this.zzf = -1;
        this.zzad = -1;
        this.zzmw = null;
        this.zznf = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhn)) {
            return false;
        }
        zzhn zzhn = (zzhn) obj;
        if (this.versionCode != zzhn.versionCode) {
            return false;
        }
        String str = this.zzab;
        if (str == null) {
            if (zzhn.zzab != null) {
                return false;
            }
        } else if (!str.equals(zzhn.zzab)) {
            return false;
        }
        if (this.zzac == zzhn.zzac && this.zzf == zzhn.zzf && this.zzad == zzhn.zzad) {
            return (this.zzmw == null || this.zzmw.isEmpty()) ? zzhn.zzmw == null || zzhn.zzmw.isEmpty() : this.zzmw.equals(zzhn.zzmw);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31;
        String str = this.zzab;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        long j = this.zzac;
        int i2 = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.zzf;
        int i3 = (((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.zzad) * 31;
        if (this.zzmw != null && !this.zzmw.isEmpty()) {
            i = this.zzmw.hashCode();
        }
        return i3 + i;
    }

    public final /* synthetic */ zzix zza(zzio zzio) throws IOException {
        while (true) {
            int zzbd = zzio.zzbd();
            if (zzbd == 0) {
                return this;
            }
            if (zzbd == 8) {
                this.versionCode = zzio.zzbe();
            } else if (zzbd == 18) {
                this.zzab = zzio.readString();
            } else if (zzbd == 24) {
                long zzbf = zzio.zzbf();
                this.zzac = (-(zzbf & 1)) ^ (zzbf >>> 1);
            } else if (zzbd == 32) {
                long zzbf2 = zzio.zzbf();
                this.zzf = (-(zzbf2 & 1)) ^ (zzbf2 >>> 1);
            } else if (zzbd == 40) {
                this.zzad = zzio.zzbe();
            } else if (!super.zza(zzio, zzbd)) {
                return this;
            }
        }
    }

    public final void zza(zzip zzip) throws IOException {
        zzip.zzb(1, this.versionCode);
        String str = this.zzab;
        zzip.zzd(2, 2);
        zzip.zzh(str);
        zzip.zza(3, this.zzac);
        zzip.zza(4, this.zzf);
        int i = this.zzad;
        if (i != -1) {
            zzip.zzb(5, i);
        }
        super.zza(zzip);
    }

    /* access modifiers changed from: protected */
    public final int zzaq() {
        int zzaq = super.zzaq() + zzip.zzc(1, this.versionCode) + zzip.zzo(2) + zzip.zzi(this.zzab) + zzip.zzb(3, this.zzac) + zzip.zzb(4, this.zzf);
        int i = this.zzad;
        return i != -1 ? zzaq + zzip.zzc(5, i) : zzaq;
    }
}
