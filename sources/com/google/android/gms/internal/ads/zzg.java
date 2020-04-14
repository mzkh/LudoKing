package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzg implements zzad {
    private int zzr;
    private int zzs;
    private final int zzt;
    private final float zzu;

    public zzg() {
        this(2500, 1, 1.0f);
    }

    private zzg(int i, int i2, float f) {
        this.zzr = 2500;
        this.zzt = 1;
        this.zzu = 1.0f;
    }

    public final int zza() {
        return this.zzr;
    }

    public final int zzb() {
        return this.zzs;
    }

    public final void zza(zzae zzae) throws zzae {
        boolean z = true;
        this.zzs++;
        int i = this.zzr;
        this.zzr = i + ((int) (((float) i) * this.zzu));
        if (this.zzs > this.zzt) {
            z = false;
        }
        if (!z) {
            throw zzae;
        }
    }
}
