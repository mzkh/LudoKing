package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzabp extends zzfm implements zzabm {
    public zzabp() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzabm zzn(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        if (queryLocalInterface instanceof zzabm) {
            return (zzabm) queryLocalInterface;
        }
        return new zzabo(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzabh zzabh;
        switch (i) {
            case 1:
                zzc(parcel.readString(), Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 2:
                IObjectWrapper zzcj = zzcj(parcel.readString());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzcj);
                break;
            case 3:
                zze(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 4:
                destroy();
                parcel2.writeNoException();
                break;
            case 5:
                zzc(Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                break;
            case 6:
                zzi(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 7:
                zzj(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzabh = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
                    if (queryLocalInterface instanceof zzabh) {
                        zzabh = (zzabh) queryLocalInterface;
                    } else {
                        zzabh = new zzabj(readStrongBinder);
                    }
                }
                zza(zzabh);
                parcel2.writeNoException();
                break;
            case 9:
                zzk(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
