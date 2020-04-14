package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzsc extends PushbackInputStream {
    private final /* synthetic */ zzrx zzbrz;

    zzsc(zzrx zzrx, InputStream inputStream, int i) {
        this.zzbrz = zzrx;
        super(inputStream, 1);
    }

    public final synchronized void close() throws IOException {
        this.zzbrz.zzbrs.disconnect();
        super.close();
    }
}
