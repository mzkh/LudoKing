package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final /* synthetic */ class zzcjz implements zzbnj {
    private final zzbbw zzehv;

    zzcjz(zzbbw zzbbw) {
        this.zzehv = zzbbw;
    }

    public final void onAdImpression() {
        zzbbw zzbbw = this.zzehv;
        if (zzbbw.zzzp() != null) {
            zzbbw.zzzp().zzzb();
        }
    }
}
