package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzrm implements BaseConnectionCallbacks {
    private final /* synthetic */ zzrh zzbrg;

    zzrm(zzrh zzrh) {
        this.zzbrg = zzrh;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbrg.lock) {
            try {
                if (this.zzbrg.zzbrc != null) {
                    this.zzbrg.zzbrd = this.zzbrg.zzbrc.zzml();
                }
            } catch (DeadObjectException e) {
                zzaug.zzc("Unable to obtain a cache service instance.", e);
                this.zzbrg.disconnect();
            }
            this.zzbrg.lock.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbrg.lock) {
            this.zzbrg.zzbrd = null;
            this.zzbrg.lock.notifyAll();
        }
    }
}
