package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzafo implements BaseOnConnectionFailedListener {
    private final /* synthetic */ zzaxv zzbrr;

    zzafo(zzafl zzafl, zzaxv zzaxv) {
        this.zzbrr = zzaxv;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzbrr.setException(new RuntimeException("Connection failed."));
    }
}
