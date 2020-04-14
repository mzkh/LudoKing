package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzau extends FilterInputStream {
    private final HttpURLConnection zzcl;

    zzau(HttpURLConnection httpURLConnection) {
        super(zzar.zza(httpURLConnection));
        this.zzcl = httpURLConnection;
    }

    public final void close() throws IOException {
        super.close();
        this.zzcl.disconnect();
    }
}
