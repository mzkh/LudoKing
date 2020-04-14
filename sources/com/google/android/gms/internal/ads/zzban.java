package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzban implements zzne {
    private Uri uri;
    private final zzne zzecx;
    private final long zzecy;
    private final zzne zzecz;
    private long zzeda;

    zzban(zzne zzne, int i, zzne zzne2) {
        this.zzecx = zzne;
        this.zzecy = (long) i;
        this.zzecz = zzne2;
    }

    public final long zza(zznf zznf) throws IOException {
        zznf zznf2;
        zznf zznf3;
        long j;
        zznf zznf4 = zznf;
        this.uri = zznf4.uri;
        if (zznf4.zzamq >= this.zzecy) {
            zznf2 = null;
        } else {
            long j2 = zznf4.zzamq;
            if (zznf4.zzcb != -1) {
                j = Math.min(zznf4.zzcb, this.zzecy - j2);
            } else {
                j = this.zzecy - j2;
            }
            zznf2 = new zznf(zznf4.uri, j2, j, null);
        }
        if (zznf4.zzcb == -1 || zznf4.zzamq + zznf4.zzcb > this.zzecy) {
            zznf3 = new zznf(zznf4.uri, Math.max(this.zzecy, zznf4.zzamq), zznf4.zzcb != -1 ? Math.min(zznf4.zzcb, (zznf4.zzamq + zznf4.zzcb) - this.zzecy) : -1, null);
        } else {
            zznf3 = null;
        }
        long j3 = 0;
        long zza = zznf2 != null ? this.zzecx.zza(zznf2) : 0;
        if (zznf3 != null) {
            j3 = this.zzecz.zza(zznf3);
        }
        this.zzeda = zznf4.zzamq;
        if (zza == -1 || j3 == -1) {
            return -1;
        }
        return zza + j3;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzeda;
        long j2 = this.zzecy;
        if (j < j2) {
            i3 = this.zzecx.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.zzeda += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzeda < this.zzecy) {
            return i3;
        }
        int read = this.zzecz.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzeda += (long) read;
        return i4;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws IOException {
        this.zzecx.close();
        this.zzecz.close();
    }
}
