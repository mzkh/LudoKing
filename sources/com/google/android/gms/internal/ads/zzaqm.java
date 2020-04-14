package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator.RemoteCreatorException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzaqm extends RemoteCreator<zzaqg> {
    public zzaqm() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public final zzaqb zza(Context context, zzajx zzajx) {
        try {
            IBinder zzb = ((zzaqg) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), zzajx, 15601000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzaqb) {
                return (zzaqb) queryLocalInterface;
            }
            return new zzaqd(zzb);
        } catch (RemoteException | RemoteCreatorException e) {
            zzaxi.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzaqg) {
            return (zzaqg) queryLocalInterface;
        }
        return new zzaqf(iBinder);
    }
}
