package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcvh extends AdMetadataListener {
    private final /* synthetic */ zzwm zzgiq;
    private final /* synthetic */ zzcvf zzgir;

    zzcvh(zzcvf zzcvf, zzwm zzwm) {
        this.zzgir = zzcvf;
        this.zzgiq = zzwm;
    }

    public final void onAdMetadataChanged() {
        if (this.zzgir.zzgil != null) {
            try {
                this.zzgiq.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzaug.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
