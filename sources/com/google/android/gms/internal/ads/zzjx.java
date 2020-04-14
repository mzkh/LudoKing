package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzjx implements zzjv {
    private final zzoc zzaut;
    private final int zzavb = this.zzaut.zzir();
    private final int zzavc = this.zzaut.zzir();

    public zzjx(zzju zzju) {
        this.zzaut = zzju.zzaut;
        this.zzaut.zzbg(12);
    }

    public final int zzgj() {
        return this.zzavc;
    }

    public final int zzgk() {
        int i = this.zzavb;
        return i == 0 ? this.zzaut.zzir() : i;
    }

    public final boolean zzgl() {
        return this.zzavb != 0;
    }
}
