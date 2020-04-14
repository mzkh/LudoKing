package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzrl implements BaseOnConnectionFailedListener {
    private final /* synthetic */ zzrh zzbrg;

    zzrl(zzrh zzrh) {
        this.zzbrg = zzrh;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbrg.lock) {
            this.zzbrg.zzbrd = null;
            if (this.zzbrg.zzbrc != null) {
                this.zzbrg.zzbrc = null;
            }
            this.zzbrg.lock.notifyAll();
        }
    }
}
