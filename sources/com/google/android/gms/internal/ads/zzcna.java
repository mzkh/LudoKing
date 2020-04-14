package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcna implements zzdcz<zzcnl> {
    private final /* synthetic */ zzatd zzgdk;

    zzcna(zzcnb zzcnb, zzatd zzatd) {
        this.zzgdk = zzatd;
    }

    public final void zzb(Throwable th) {
        try {
            this.zzgdk.onError("Internal error.");
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        zzcnl zzcnl = (zzcnl) obj;
        try {
            this.zzgdk.zzm(zzcnl.zzgdr, zzcnl.zzgds);
        } catch (RemoteException e) {
            zzaxi.zzc("", e);
        }
    }
}
