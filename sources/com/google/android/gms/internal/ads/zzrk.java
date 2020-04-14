package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzrk implements Runnable {
    private final /* synthetic */ zzrh zzbrg;

    zzrk(zzrh zzrh) {
        this.zzbrg = zzrh;
    }

    public final void run() {
        this.zzbrg.disconnect();
    }
}
