package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzdog {
    private final byte[] data;

    public static zzdog zzu(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzdog(bArr, 0, bArr.length);
    }

    public final byte[] getBytes() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private zzdog(byte[] bArr, int i, int i2) {
        this.data = new byte[i2];
        System.arraycopy(bArr, 0, this.data, 0, i2);
    }
}
