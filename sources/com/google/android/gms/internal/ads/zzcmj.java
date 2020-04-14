package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcmj implements zztp {
    @GuardedBy("this")
    private zzux zzgcn;

    public final synchronized void zzb(zzux zzux) {
        this.zzgcn = zzux;
    }

    public final synchronized void onAdClicked() {
        if (this.zzgcn != null) {
            try {
                this.zzgcn.onAdClicked();
            } catch (RemoteException e) {
                zzaug.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }
}
