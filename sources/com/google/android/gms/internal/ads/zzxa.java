package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzxa extends zzuu {
    private final /* synthetic */ zzxb zzcel;

    zzxa(zzxb zzxb) {
        this.zzcel = zzxb;
    }

    public final void onAdLoaded() {
        this.zzcel.zzcen.zza(this.zzcel.zzde());
        super.onAdLoaded();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzcel.zzcen.zza(this.zzcel.zzde());
        super.onAdFailedToLoad(i);
    }
}
