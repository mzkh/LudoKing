package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzcvn extends AdMetadataListener {
    private final /* synthetic */ zzvo zzgiv;
    private final /* synthetic */ zzcvl zzgiw;

    zzcvn(zzcvl zzcvl, zzvo zzvo) {
        this.zzgiw = zzcvl;
        this.zzgiv = zzvo;
    }

    public final void onAdMetadataChanged() {
        if (this.zzgiw.zzgil != null) {
            try {
                this.zzgiv.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzaug.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
