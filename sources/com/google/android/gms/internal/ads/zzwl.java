package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzwl extends zzfm implements zzwi {
    public zzwl() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzwi zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        if (queryLocalInterface instanceof zzwi) {
            return (zzwi) queryLocalInterface;
        }
        return new zzwk(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String description = getDescription();
            parcel2.writeNoException();
            parcel2.writeString(description);
        } else if (i != 2) {
            return false;
        } else {
            String zzov = zzov();
            parcel2.writeNoException();
            parcel2.writeString(zzov);
        }
        return true;
    }
}
