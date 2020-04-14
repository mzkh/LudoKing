package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzann extends zzfm implements zzano {
    public zzann() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzano zzae(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        if (queryLocalInterface instanceof zzano) {
            return (zzano) queryLocalInterface;
        }
        return new zzanq(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                onCreate((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                onRestart();
                parcel2.writeNoException();
                break;
            case 3:
                onStart();
                parcel2.writeNoException();
                break;
            case 4:
                onResume();
                parcel2.writeNoException();
                break;
            case 5:
                onPause();
                parcel2.writeNoException();
                break;
            case 6:
                Bundle bundle = (Bundle) zzfp.zza(parcel, Bundle.CREATOR);
                onSaveInstanceState(bundle);
                parcel2.writeNoException();
                zzfp.zzb(parcel2, bundle);
                break;
            case 7:
                onStop();
                parcel2.writeNoException();
                break;
            case 8:
                onDestroy();
                parcel2.writeNoException();
                break;
            case 9:
                zzda();
                parcel2.writeNoException();
                break;
            case 10:
                onBackPressed();
                parcel2.writeNoException();
                break;
            case 11:
                boolean zzsp = zzsp();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, zzsp);
                break;
            case 12:
                onActivityResult(parcel.readInt(), parcel.readInt(), (Intent) zzfp.zza(parcel, Intent.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzag(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
