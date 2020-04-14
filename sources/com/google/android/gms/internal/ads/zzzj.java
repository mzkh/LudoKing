package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzzj extends zzfm implements zzzg {
    public zzzj() {
        super("com.google.android.gms.ads.internal.consent.IConsentSdkUtil");
    }

    public static zzzg zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.consent.IConsentSdkUtil");
        if (queryLocalInterface instanceof zzzg) {
            return (zzzg) queryLocalInterface;
        }
        return new zzzi(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzzf zzzf;
        if (i == 2) {
            zzr(Stub.asInterface(parcel.readStrongBinder()));
        } else if (i != 3) {
            return false;
        } else {
            Bundle bundle = (Bundle) zzfp.zza(parcel, Bundle.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzzf = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.consent.IConsentCallback");
                if (queryLocalInterface instanceof zzzf) {
                    zzzf = (zzzf) queryLocalInterface;
                } else {
                    zzzf = new zzzh(readStrongBinder);
                }
            }
            zza(bundle, zzzf);
        }
        parcel2.writeNoException();
        return true;
    }
}
