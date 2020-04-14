package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzalk implements Runnable {
    private final /* synthetic */ zzala zzden;
    private final /* synthetic */ ErrorCode zzdeo;

    zzalk(zzala zzala, ErrorCode errorCode) {
        this.zzden = zzala;
        this.zzdeo = errorCode;
    }

    public final void run() {
        try {
            this.zzden.zzdea.onAdFailedToLoad(zzalm.zza(this.zzdeo));
        } catch (RemoteException e) {
            zzaxi.zze("#007 Could not call remote method.", e);
        }
    }
}
