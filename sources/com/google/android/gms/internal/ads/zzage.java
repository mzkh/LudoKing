package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzage extends zzfm implements zzagf {
    public zzage() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzagh zzagh;
        if (i == 3) {
            zzwr videoController = getVideoController();
            parcel2.writeNoException();
            zzfp.zza(parcel2, (IInterface) videoController);
        } else if (i == 4) {
            destroy();
            parcel2.writeNoException();
        } else if (i != 5) {
            return false;
        } else {
            IObjectWrapper asInterface = Stub.asInterface(parcel.readStrongBinder());
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzagh = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                if (queryLocalInterface instanceof zzagh) {
                    zzagh = (zzagh) queryLocalInterface;
                } else {
                    zzagh = new zzagg(readStrongBinder);
                }
            }
            zza(asInterface, zzagh);
            parcel2.writeNoException();
        }
        return true;
    }
}
