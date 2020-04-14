package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
final class zzakv implements InitializationCompleteCallback {
    private final /* synthetic */ zzaft zzdee;

    zzakv(zzakt zzakt, zzaft zzaft) {
        this.zzdee = zzaft;
    }

    public final void onInitializationSucceeded() {
        try {
            this.zzdee.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zzdee.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
