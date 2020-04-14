package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzzh extends zzfn implements zzzf {
    zzzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.consent.IConsentCallback");
    }

    public final void onSuccess(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzb(2, obtainAndWriteInterfaceToken);
    }

    public final void onFailure(int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeInt(i);
        zzb(3, obtainAndWriteInterfaceToken);
    }
}
