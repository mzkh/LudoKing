package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzaw extends ByteArrayOutputStream {
    private final zzaj zzbw;

    public zzaw(zzaj zzaj, int i) {
        this.zzbw = zzaj;
        this.buf = this.zzbw.zzc(Math.max(i, 256));
    }

    public final void close() throws IOException {
        this.zzbw.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzbw.zza(this.buf);
    }

    private final void zzd(int i) {
        if (this.count + i > this.buf.length) {
            byte[] zzc = this.zzbw.zzc((this.count + i) << 1);
            System.arraycopy(this.buf, 0, zzc, 0, this.count);
            this.zzbw.zza(this.buf);
            this.buf = zzc;
        }
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzd(i2);
        super.write(bArr, i, i2);
    }

    public final synchronized void write(int i) {
        zzd(1);
        super.write(i);
    }
}
