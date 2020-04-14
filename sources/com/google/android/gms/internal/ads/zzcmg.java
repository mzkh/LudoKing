package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcmg implements zzbnb {
    @GuardedBy("this")
    private zzqx zzgcj;

    public final synchronized void zzb(zzqx zzqx) {
        this.zzgcj = zzqx;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzgcj != null) {
            try {
                this.zzgcj.onAppOpenAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }
}
