package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzabg extends zzfm implements zzabh {
    public zzabg() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            float aspectRatio = getAspectRatio();
            parcel2.writeNoException();
            parcel2.writeFloat(aspectRatio);
        } else if (i == 3) {
            zzt(Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i != 4) {
            return false;
        } else {
            IObjectWrapper zzql = zzql();
            parcel2.writeNoException();
            zzfp.zza(parcel2, (IInterface) zzql);
        }
        return true;
    }
}
