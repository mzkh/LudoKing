package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzvc extends zzfm implements zzvd {
    public zzvc() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((zztx) zzfp.zza(parcel, zztx.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i == 3) {
            boolean isLoading = isLoading();
            parcel2.writeNoException();
            zzfp.writeBoolean(parcel2, isLoading);
        } else if (i == 4) {
            String zzju = zzju();
            parcel2.writeNoException();
            parcel2.writeString(zzju);
        } else if (i != 5) {
            return false;
        } else {
            zza((zztx) zzfp.zza(parcel, zztx.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
