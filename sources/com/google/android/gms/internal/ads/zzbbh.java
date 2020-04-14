package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbbh extends zzbax {
    public zzbbh(zzazj zzazj) {
        super(zzazj);
    }

    public final void abort() {
    }

    public final boolean zzfd(String str) {
        zzazj zzazj = (zzazj) this.zzedf.get();
        if (zzazj != null) {
            zzazj.zza(zzfe(str), (zzbax) this);
        }
        zzaug.zzeu("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfe(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
