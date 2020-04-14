package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzie implements zzhe {
    private int zzafm = -1;
    private float zzaga = 1.0f;
    private float zzagb = 1.0f;
    private ByteBuffer zzajf = zzagy;
    private int zzaki = -1;
    private ByteBuffer zzakm = zzagy;
    private boolean zzakn;
    private zzif zzakw;
    private ShortBuffer zzakx = this.zzakm.asShortBuffer();
    private long zzaky;
    private long zzakz;

    public final int zzeu() {
        return 2;
    }

    public final float zza(float f) {
        this.zzaga = zzof.zza(f, 0.1f, 8.0f);
        return this.zzaga;
    }

    public final float zzb(float f) {
        this.zzagb = zzof.zza(f, 0.1f, 8.0f);
        return f;
    }

    public final long zzfp() {
        return this.zzaky;
    }

    public final long zzfq() {
        return this.zzakz;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzhh {
        if (i3 != 2) {
            throw new zzhh(i, i2, i3);
        } else if (this.zzaki == i && this.zzafm == i2) {
            return false;
        } else {
            this.zzaki = i;
            this.zzafm = i2;
            return true;
        }
    }

    public final boolean isActive() {
        return Math.abs(this.zzaga - 1.0f) >= 0.01f || Math.abs(this.zzagb - 1.0f) >= 0.01f;
    }

    public final int zzet() {
        return this.zzafm;
    }

    public final void zzi(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzaky += (long) remaining;
            this.zzakw.zza(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zzfr = (this.zzakw.zzfr() * this.zzafm) << 1;
        if (zzfr > 0) {
            if (this.zzakm.capacity() < zzfr) {
                this.zzakm = ByteBuffer.allocateDirect(zzfr).order(ByteOrder.nativeOrder());
                this.zzakx = this.zzakm.asShortBuffer();
            } else {
                this.zzakm.clear();
                this.zzakx.clear();
            }
            this.zzakw.zzb(this.zzakx);
            this.zzakz += (long) zzfr;
            this.zzakm.limit(zzfr);
            this.zzajf = this.zzakm;
        }
    }

    public final void zzev() {
        this.zzakw.zzev();
        this.zzakn = true;
    }

    public final ByteBuffer zzew() {
        ByteBuffer byteBuffer = this.zzajf;
        this.zzajf = zzagy;
        return byteBuffer;
    }

    public final boolean zzeo() {
        if (this.zzakn) {
            zzif zzif = this.zzakw;
            if (zzif == null || zzif.zzfr() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void flush() {
        this.zzakw = new zzif(this.zzaki, this.zzafm);
        this.zzakw.setSpeed(this.zzaga);
        this.zzakw.zzc(this.zzagb);
        this.zzajf = zzagy;
        this.zzaky = 0;
        this.zzakz = 0;
        this.zzakn = false;
    }

    public final void reset() {
        this.zzakw = null;
        this.zzakm = zzagy;
        this.zzakx = this.zzakm.asShortBuffer();
        this.zzajf = zzagy;
        this.zzafm = -1;
        this.zzaki = -1;
        this.zzaky = 0;
        this.zzakz = 0;
        this.zzakn = false;
    }
}
