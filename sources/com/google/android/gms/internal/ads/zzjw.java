package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzjw {
    public int index;
    public final int length;
    public int zzauu;
    public long zzauv;
    private final boolean zzauw;
    private final zzoc zzaux;
    private final zzoc zzauy;
    private int zzauz;
    private int zzava;

    public zzjw(zzoc zzoc, zzoc zzoc2, boolean z) {
        this.zzauy = zzoc;
        this.zzaux = zzoc2;
        this.zzauw = z;
        zzoc2.zzbg(12);
        this.length = zzoc2.zzir();
        zzoc.zzbg(12);
        this.zzava = zzoc.zzir();
        boolean z2 = true;
        if (zzoc.readInt() != 1) {
            z2 = false;
        }
        zznr.checkState(z2, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzgm() {
        long j;
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        if (this.zzauw) {
            j = this.zzaux.zzis();
        } else {
            j = this.zzaux.zzio();
        }
        this.zzauv = j;
        if (this.index == this.zzauz) {
            this.zzauu = this.zzauy.zzir();
            this.zzauy.zzbh(4);
            int i2 = this.zzava - 1;
            this.zzava = i2;
            this.zzauz = i2 > 0 ? this.zzauy.zzir() - 1 : -1;
        }
        return true;
    }
}
