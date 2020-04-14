package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzan extends FilterInputStream {
    private final long zzcb;
    private long zzcc;

    zzan(InputStream inputStream, long j) {
        super(inputStream);
        this.zzcb = j;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.zzcc++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzcc += (long) read;
        }
        return read;
    }

    /* access modifiers changed from: 0000 */
    public final long zzn() {
        return this.zzcb - this.zzcc;
    }
}
