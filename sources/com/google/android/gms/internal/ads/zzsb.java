package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzsb implements BaseOnConnectionFailedListener {
    private final /* synthetic */ zzaxv zzbrr;
    private final /* synthetic */ zzrv zzbrs;

    zzsb(zzrv zzrv, zzaxv zzaxv) {
        this.zzbrs = zzrv;
        this.zzbrr = zzaxv;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbrs.lock) {
            this.zzbrr.setException(new RuntimeException("Connection failed."));
        }
    }
}
