package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdpc {
    private final byte[] zzhfn = new byte[256];
    private int zzhfo;
    private int zzhfp;

    public zzdpc(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzhfn[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr2 = this.zzhfn;
            b = (b + bArr2[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[b];
            bArr2[b] = b2;
        }
        this.zzhfo = 0;
        this.zzhfp = 0;
    }

    public final void zzx(byte[] bArr) {
        int i = this.zzhfo;
        int i2 = this.zzhfp;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.zzhfn;
            i2 = (i2 + bArr2[i]) & 255;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.zzhfo = i;
        this.zzhfp = i2;
    }
}
