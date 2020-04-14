package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzbzu implements zzbdf {
    private final zzaxv zzbrt;

    zzbzu(zzaxv zzaxv) {
        this.zzbrt = zzaxv;
    }

    public final void zzad(boolean z) {
        zzaxv zzaxv = this.zzbrt;
        if (z) {
            zzaxv.set(null);
        } else {
            zzaxv.setException(new Exception("Ad Web View failed to load."));
        }
    }
}
