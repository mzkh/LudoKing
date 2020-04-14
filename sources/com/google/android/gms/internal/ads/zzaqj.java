package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaqj implements RewardItem {
    private final zzapy zzdnw;

    public zzaqj(zzapy zzapy) {
        this.zzdnw = zzapy;
    }

    public final String getType() {
        zzapy zzapy = this.zzdnw;
        if (zzapy == null) {
            return null;
        }
        try {
            return zzapy.getType();
        } catch (RemoteException e) {
            zzaxi.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int getAmount() {
        zzapy zzapy = this.zzdnw;
        if (zzapy == null) {
            return 0;
        }
        try {
            return zzapy.getAmount();
        } catch (RemoteException e) {
            zzaxi.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
