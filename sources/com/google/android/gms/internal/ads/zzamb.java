package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzamb extends zzfm implements zzaly {
    public zzamb() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzsf();
        } else if (i != 3) {
            return false;
        } else {
            zzdg(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
