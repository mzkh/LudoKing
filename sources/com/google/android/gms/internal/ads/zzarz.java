package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzarz implements zzdcz<Void> {
    private final /* synthetic */ zzddi zzdou;

    zzarz(zzarv zzarv, zzddi zzddi) {
        this.zzdou = zzddi;
    }

    public final void zzb(Throwable th) {
        zzarv.zzdog.remove(this.zzdou);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzarv.zzdog.remove(this.zzdou);
    }
}
