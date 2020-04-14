package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzapc implements Runnable {
    private final OutputStream zzdly;
    private final byte[] zzdlz;

    zzapc(OutputStream outputStream, byte[] bArr) {
        this.zzdly = outputStream;
        this.zzdlz = bArr;
    }

    public final void run() {
        zzaoz.zza(this.zzdly, this.zzdlz);
    }
}
