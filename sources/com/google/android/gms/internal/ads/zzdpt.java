package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-base@@18.2.0 */
final class zzdpt extends zzdpw {
    private final int zzhgf;
    private final int zzhgg;

    zzdpt(byte[] bArr, int i, int i2) {
        super(bArr);
        zzh(i, i + i2, bArr.length);
        this.zzhgf = i;
        this.zzhgg = i2;
    }

    public final byte zzfm(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzhgi[this.zzhgf + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    public final byte zzfn(int i) {
        return this.zzhgi[this.zzhgf + i];
    }

    public final int size() {
        return this.zzhgg;
    }

    /* access modifiers changed from: protected */
    public final int zzaxr() {
        return this.zzhgf;
    }

    /* access modifiers changed from: protected */
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzhgi, zzaxr(), bArr, 0, i3);
    }
}
