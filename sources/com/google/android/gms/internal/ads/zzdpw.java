package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
class zzdpw extends zzdpx {
    protected final byte[] zzhgi;

    zzdpw(byte[] bArr) {
        if (bArr != null) {
            this.zzhgi = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzaxr() {
        return 0;
    }

    public byte zzfm(int i) {
        return this.zzhgi[i];
    }

    /* access modifiers changed from: 0000 */
    public byte zzfn(int i) {
        return this.zzhgi[i];
    }

    public int size() {
        return this.zzhgi.length;
    }

    public final zzdpm zzy(int i, int i2) {
        int zzh = zzh(0, i2, size());
        if (zzh == 0) {
            return zzdpm.zzhgb;
        }
        return new zzdpt(this.zzhgi, zzaxr(), zzh);
    }

    /* access modifiers changed from: protected */
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzhgi, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzdpn zzdpn) throws IOException {
        zzdpn.zzi(this.zzhgi, zzaxr(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzhgi, zzaxr(), size(), charset);
    }

    public final boolean zzaxo() {
        int zzaxr = zzaxr();
        return zzdtw.zzl(this.zzhgi, zzaxr, size() + zzaxr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdpm) || size() != ((zzdpm) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzdpw)) {
            return obj.equals(this);
        }
        zzdpw zzdpw = (zzdpw) obj;
        int zzaxq = zzaxq();
        int zzaxq2 = zzdpw.zzaxq();
        if (zzaxq == 0 || zzaxq2 == 0 || zzaxq == zzaxq2) {
            return zza(zzdpw, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzdpm zzdpm, int i, int i2) {
        if (i2 > zzdpm.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdpm.size()) {
            int size2 = zzdpm.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdpm instanceof zzdpw)) {
            return zzdpm.zzy(0, i2).equals(zzy(0, i2));
        } else {
            zzdpw zzdpw = (zzdpw) zzdpm;
            byte[] bArr = this.zzhgi;
            byte[] bArr2 = zzdpw.zzhgi;
            int zzaxr = zzaxr() + i2;
            int zzaxr2 = zzaxr();
            int zzaxr3 = zzdpw.zzaxr();
            while (zzaxr2 < zzaxr) {
                if (bArr[zzaxr2] != bArr2[zzaxr3]) {
                    return false;
                }
                zzaxr2++;
                zzaxr3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        return zzdqx.zza(i, this.zzhgi, zzaxr(), i3);
    }

    public final zzdpy zzaxp() {
        return zzdpy.zzc(this.zzhgi, zzaxr(), size(), true);
    }
}
