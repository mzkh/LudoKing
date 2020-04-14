package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzik extends zzih {
    public final zzig zzama = new zzig();
    public long zzamb;
    private final int zzamc = 0;
    public ByteBuffer zzcq;

    public zzik(int i) {
    }

    public final void zzx(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzcq;
        if (byteBuffer == null) {
            this.zzcq = zzy(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzcq.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer zzy = zzy(i2);
            if (position > 0) {
                this.zzcq.position(0);
                this.zzcq.limit(position);
                zzy.put(this.zzcq);
            }
            this.zzcq = zzy;
        }
    }

    public final boolean zzfx() {
        return zzw(1073741824);
    }

    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzcq;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    private final ByteBuffer zzy(int i) {
        ByteBuffer byteBuffer = this.zzcq;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
}
