package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaro implements RewardItem {
    private final zzaqv zzdoe;

    public zzaro(zzaqv zzaqv) {
        this.zzdoe = zzaqv;
    }

    public final String getType() {
        zzaqv zzaqv = this.zzdoe;
        if (zzaqv == null) {
            return null;
        }
        try {
            return zzaqv.getType();
        } catch (RemoteException e) {
            zzaxi.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int getAmount() {
        zzaqv zzaqv = this.zzdoe;
        if (zzaqv == null) {
            return 0;
        }
        try {
            return zzaqv.getAmount();
        } catch (RemoteException e) {
            zzaxi.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
