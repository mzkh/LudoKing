package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzafp implements BaseConnectionCallbacks {
    private final /* synthetic */ zzaxv zzbrr;
    private final /* synthetic */ zzafl zzcym;

    zzafp(zzafl zzafl, zzaxv zzaxv) {
        this.zzcym = zzafl;
        this.zzbrr = zzaxv;
    }

    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.zzbrr.set(this.zzcym.zzcyl.zzqz());
        } catch (DeadObjectException e) {
            this.zzbrr.setException(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzaxv zzaxv = this.zzbrr;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzaxv.setException(new RuntimeException(sb.toString()));
    }
}
