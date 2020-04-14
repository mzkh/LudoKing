package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzka implements zzjv {
    private final zzoc zzaut;
    private final int zzavc = this.zzaut.zzir();
    private final int zzavf = (this.zzaut.zzir() & 255);
    private int zzavg;
    private int zzavh;

    public zzka(zzju zzju) {
        this.zzaut = zzju.zzaut;
        this.zzaut.zzbg(12);
    }

    public final boolean zzgl() {
        return false;
    }

    public final int zzgj() {
        return this.zzavc;
    }

    public final int zzgk() {
        int i = this.zzavf;
        if (i == 8) {
            return this.zzaut.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzaut.readUnsignedShort();
        }
        int i2 = this.zzavg;
        this.zzavg = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzavh & 15;
        }
        this.zzavh = this.zzaut.readUnsignedByte();
        return (this.zzavh & 240) >> 4;
    }
}
