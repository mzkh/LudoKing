package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzrb extends zzfm implements zzrc {
    public zzrb() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        onAppOpenAdClosed();
        parcel2.writeNoException();
        return true;
    }
}
