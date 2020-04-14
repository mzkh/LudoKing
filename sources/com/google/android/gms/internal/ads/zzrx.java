package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzrx implements BaseConnectionCallbacks {
    private final /* synthetic */ zzrp zzbrq;
    private final /* synthetic */ zzaxv zzbrr;
    final /* synthetic */ zzrv zzbrs;

    zzrx(zzrv zzrv, zzrp zzrp, zzaxv zzaxv) {
        this.zzbrs = zzrv;
        this.zzbrq = zzrp;
        this.zzbrr = zzaxv;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbrs.lock) {
            if (!this.zzbrs.zzbrp) {
                this.zzbrs.zzbrp = true;
                zzrq zzd = this.zzbrs.zzbrc;
                if (zzd != null) {
                    this.zzbrr.addListener(new zzrz(this.zzbrr, zzaxn.zzdwi.zzf(new zzsa(this, zzd, this.zzbrq, this.zzbrr))), zzaxn.zzdwn);
                }
            }
        }
    }
}
