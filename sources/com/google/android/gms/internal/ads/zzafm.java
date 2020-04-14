package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzafm implements Runnable {
    private final /* synthetic */ zzafl zzcym;

    zzafm(zzafl zzafl) {
        this.zzcym = zzafl;
    }

    public final void run() {
        this.zzcym.disconnect();
    }
}
