package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzqv extends zzfm implements zzqw {
    public zzqv() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzrc zzrc;
        if (i == 2) {
            zzvl zzdg = zzdg();
            parcel2.writeNoException();
            zzfp.zza(parcel2, (IInterface) zzdg);
        } else if (i != 3) {
            return false;
        } else {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzrc = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                if (queryLocalInterface instanceof zzrc) {
                    zzrc = (zzrc) queryLocalInterface;
                } else {
                    zzrc = new zzre(readStrongBinder);
                }
            }
            zza(zzrc);
            parcel2.writeNoException();
        }
        return true;
    }
}
