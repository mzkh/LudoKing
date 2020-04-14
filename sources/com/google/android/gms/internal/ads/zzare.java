package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzare extends zzfm implements zzarb {
    public zzare() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaqv zzaqv;
        if (i == 1) {
            onRewardedAdOpened();
        } else if (i == 2) {
            onRewardedAdClosed();
        } else if (i == 3) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaqv = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                if (queryLocalInterface instanceof zzaqv) {
                    zzaqv = (zzaqv) queryLocalInterface;
                } else {
                    zzaqv = new zzaqx(readStrongBinder);
                }
            }
            zza(zzaqv);
        } else if (i != 4) {
            return false;
        } else {
            onRewardedAdFailedToShow(parcel.readInt());
        }
        parcel2.writeNoException();
        return true;
    }
}
