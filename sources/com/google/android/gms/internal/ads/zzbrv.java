package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbrv implements Runnable {
    private final zzbbw zzehv;

    private zzbrv(zzbbw zzbbw) {
        this.zzehv = zzbbw;
    }

    static Runnable zzh(zzbbw zzbbw) {
        return new zzbrv(zzbbw);
    }

    public final void run() {
        this.zzehv.destroy();
    }
}
