package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzarw extends zzaqy {
    private final String type;
    private final int zzdnv;

    public zzarw(@Nullable zzaqt zzaqt) {
        this(zzaqt != null ? zzaqt.type : "", zzaqt != null ? zzaqt.zzdnv : 1);
    }

    public zzarw(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzarw(String str, int i) {
        this.type = str;
        this.zzdnv = i;
    }

    public final String getType() throws RemoteException {
        return this.type;
    }

    public final int getAmount() throws RemoteException {
        return this.zzdnv;
    }
}
