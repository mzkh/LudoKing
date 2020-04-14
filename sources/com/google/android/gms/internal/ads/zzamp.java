package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzamp implements SignalCallbacks {
    private final /* synthetic */ zzame zzdfc;

    zzamp(zzami zzami, zzame zzame) {
        this.zzdfc = zzame;
    }

    public final void onSuccess(String str) {
        try {
            this.zzdfc.zzdi(str);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdfc.onFailure(str);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
