package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzhz implements zzhe {
    private int zzafm = -1;
    private ByteBuffer zzajf = zzagy;
    private int zzaki = -1;
    private int[] zzakj;
    private boolean zzakk;
    private int[] zzakl;
    private ByteBuffer zzakm = zzagy;
    private boolean zzakn;

    public final int zzeu() {
        return 2;
    }

    public final void zzb(int[] iArr) {
        this.zzakj = iArr;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzhh {
        boolean z = !Arrays.equals(this.zzakj, this.zzakl);
        this.zzakl = this.zzakj;
        if (this.zzakl == null) {
            this.zzakk = false;
            return z;
        } else if (i3 != 2) {
            throw new zzhh(i, i2, i3);
        } else if (!z && this.zzaki == i && this.zzafm == i2) {
            return false;
        } else {
            this.zzaki = i;
            this.zzafm = i2;
            this.zzakk = i2 != this.zzakl.length;
            int i4 = 0;
            while (true) {
                int[] iArr = this.zzakl;
                if (i4 >= iArr.length) {
                    return true;
                }
                int i5 = iArr[i4];
                if (i5 < i2) {
                    this.zzakk = (i5 != i4) | this.zzakk;
                    i4++;
                } else {
                    throw new zzhh(i, i2, i3);
                }
            }
        }
    }

    public final boolean isActive() {
        return this.zzakk;
    }

    public final int zzet() {
        int[] iArr = this.zzakl;
        return iArr == null ? this.zzafm : iArr.length;
    }

    public final void zzi(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzafm * 2)) * this.zzakl.length) << 1;
        if (this.zzakm.capacity() < length) {
            this.zzakm = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzakm.clear();
        }
        while (position < limit) {
            for (int i : this.zzakl) {
                this.zzakm.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.zzafm << 1;
        }
        byteBuffer.position(limit);
        this.zzakm.flip();
        this.zzajf = this.zzakm;
    }

    public final void zzev() {
        this.zzakn = true;
    }

    public final ByteBuffer zzew() {
        ByteBuffer byteBuffer = this.zzajf;
        this.zzajf = zzagy;
        return byteBuffer;
    }

    public final boolean zzeo() {
        return this.zzakn && this.zzajf == zzagy;
    }

    public final void flush() {
        this.zzajf = zzagy;
        this.zzakn = false;
    }

    public final void reset() {
        flush();
        this.zzakm = zzagy;
        this.zzafm = -1;
        this.zzaki = -1;
        this.zzakl = null;
        this.zzakk = false;
    }
}
