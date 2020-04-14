package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzig {

    /* renamed from: iv */
    public byte[] f3919iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzalv;
    private int zzalw;
    private final CryptoInfo zzalx;
    private final zzii zzaly;

    public zzig() {
        this.zzalx = zzof.SDK_INT >= 16 ? new CryptoInfo() : null;
        this.zzaly = zzof.SDK_INT >= 24 ? new zzii(this.zzalx) : null;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f3919iv = bArr2;
        this.mode = i2;
        this.zzalv = 0;
        this.zzalw = 0;
        if (zzof.SDK_INT >= 16) {
            CryptoInfo cryptoInfo = this.zzalx;
            cryptoInfo.numSubSamples = this.numSubSamples;
            cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
            cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            cryptoInfo.key = this.key;
            cryptoInfo.iv = this.f3919iv;
            cryptoInfo.mode = this.mode;
            if (zzof.SDK_INT >= 24) {
                this.zzaly.set(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final CryptoInfo zzft() {
        return this.zzalx;
    }
}
