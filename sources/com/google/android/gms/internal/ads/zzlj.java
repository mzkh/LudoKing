package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzlj implements Runnable {
    private final /* synthetic */ zzli zzazs;
    private final /* synthetic */ zzlo zzbat;

    zzlj(zzli zzli, zzlo zzlo) {
        this.zzazs = zzli;
        this.zzbat = zzlo;
    }

    public final void run() {
        this.zzbat.release();
        int size = this.zzazs.zzbae.size();
        for (int i = 0; i < size; i++) {
            ((zzmc) this.zzazs.zzbae.valueAt(i)).disable();
        }
    }
}
