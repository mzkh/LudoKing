package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzgu {
    public static final zzgu zzafz = new zzgu(1.0f, 1.0f);
    public final float zzaga;
    public final float zzagb;
    private final int zzagc;

    public zzgu(float f, float f2) {
        this.zzaga = f;
        this.zzagb = f2;
        this.zzagc = Math.round(f * 1000.0f);
    }

    public final long zzdo(long j) {
        return j * ((long) this.zzagc);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzgu zzgu = (zzgu) obj;
            return this.zzaga == zzgu.zzaga && this.zzagb == zzgu.zzagb;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzaga) + 527) * 31) + Float.floatToRawIntBits(this.zzagb);
    }
}
