package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zznb implements zzne {
    private final byte[] data;
    private Uri uri;
    private int zzbei;
    private int zzbej;

    public zznb(byte[] bArr) {
        zznr.checkNotNull(bArr);
        zznr.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    public final long zza(zznf zznf) throws IOException {
        this.uri = zznf.uri;
        this.zzbei = (int) zznf.zzamq;
        this.zzbej = (int) (zznf.zzcb == -1 ? ((long) this.data.length) - zznf.zzamq : zznf.zzcb);
        int i = this.zzbej;
        if (i > 0 && this.zzbei + i <= this.data.length) {
            return (long) i;
        }
        int i2 = this.zzbei;
        long j = zznf.zzcb;
        int length = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbej;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbei, bArr, i, min);
        this.zzbei += min;
        this.zzbej -= min;
        return min;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws IOException {
        this.uri = null;
    }
}
