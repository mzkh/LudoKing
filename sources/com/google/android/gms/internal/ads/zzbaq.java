package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzbaq implements zzdvn {
    private final ByteBuffer zzakm;

    zzbaq(ByteBuffer byteBuffer) {
        this.zzakm = byteBuffer.duplicate();
    }

    public final void close() throws IOException {
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.zzakm.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zzakm.remaining());
        byte[] bArr = new byte[min];
        this.zzakm.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    public final long size() throws IOException {
        return (long) this.zzakm.limit();
    }

    public final long position() throws IOException {
        return (long) this.zzakm.position();
    }

    public final void zzew(long j) throws IOException {
        this.zzakm.position((int) j);
    }

    public final ByteBuffer zzh(long j, long j2) throws IOException {
        int position = this.zzakm.position();
        this.zzakm.position((int) j);
        ByteBuffer slice = this.zzakm.slice();
        slice.limit((int) j2);
        this.zzakm.position(position);
        return slice;
    }
}
