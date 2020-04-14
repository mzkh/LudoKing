package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzii {
    private final CryptoInfo zzalx;
    private final Pattern zzalz;

    private zzii(CryptoInfo cryptoInfo) {
        this.zzalx = cryptoInfo;
        this.zzalz = new Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzalz.set(i, i2);
        this.zzalx.setPattern(this.zzalz);
    }
}
