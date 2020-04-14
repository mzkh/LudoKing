package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzry extends zzaxv<InputStream> {
    private final /* synthetic */ zzrv zzbrs;

    zzry(zzrv zzrv) {
        this.zzbrs = zzrv;
    }

    public final boolean cancel(boolean z) {
        this.zzbrs.disconnect();
        return super.cancel(z);
    }
}
