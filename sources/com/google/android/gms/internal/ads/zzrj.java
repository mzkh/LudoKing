package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzrj implements zzqa {
    private final /* synthetic */ zzrh zzbrg;

    zzrj(zzrh zzrh) {
        this.zzbrg = zzrh;
    }

    public final void zzo(boolean z) {
        if (z) {
            this.zzbrg.connect();
        } else {
            this.zzbrg.disconnect();
        }
    }
}
