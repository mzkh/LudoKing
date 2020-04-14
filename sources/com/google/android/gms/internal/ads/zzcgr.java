package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcgr implements Runnable {
    private final zzbbw zzehv;

    private zzcgr(zzbbw zzbbw) {
        this.zzehv = zzbbw;
    }

    static Runnable zzh(zzbbw zzbbw) {
        return new zzcgr(zzbbw);
    }

    public final void run() {
        this.zzehv.zzaac();
    }
}
