package com.google.android.gms.internal.drive;

import java.io.IOException;

public final class zzho extends zzir<zzho> {
    public long zzac;
    public long zzf;

    public zzho() {
        this.zzac = -1;
        this.zzf = -1;
        this.zzmw = null;
        this.zznf = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzho)) {
            return false;
        }
        zzho zzho = (zzho) obj;
        if (this.zzac == zzho.zzac && this.zzf == zzho.zzf) {
            return (this.zzmw == null || this.zzmw.isEmpty()) ? zzho.zzmw == null || zzho.zzmw.isEmpty() : this.zzmw.equals(zzho.zzmw);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        long j = this.zzac;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.zzf;
        return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((this.zzmw == null || this.zzmw.isEmpty()) ? 0 : this.zzmw.hashCode());
    }

    public final /* synthetic */ zzix zza(zzio zzio) throws IOException {
        while (true) {
            int zzbd = zzio.zzbd();
            if (zzbd == 0) {
                return this;
            }
            if (zzbd == 8) {
                long zzbf = zzio.zzbf();
                this.zzac = (-(zzbf & 1)) ^ (zzbf >>> 1);
            } else if (zzbd == 16) {
                long zzbf2 = zzio.zzbf();
                this.zzf = (-(zzbf2 & 1)) ^ (zzbf2 >>> 1);
            } else if (!super.zza(zzio, zzbd)) {
                return this;
            }
        }
    }

    public final void zza(zzip zzip) throws IOException {
        zzip.zza(1, this.zzac);
        zzip.zza(2, this.zzf);
        super.zza(zzip);
    }

    /* access modifiers changed from: protected */
    public final int zzaq() {
        return super.zzaq() + zzip.zzb(1, this.zzac) + zzip.zzb(2, this.zzf);
    }
}
