package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzze extends zzfm implements zzzf {
    public zzze() {
        super("com.google.android.gms.ads.internal.consent.IConsentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            onSuccess(parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            onFailure(parcel.readInt());
        }
        return true;
    }
}
