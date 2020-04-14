package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzaqs extends zzfm implements zzaqp {
    public zzaqs() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzaqp zzak(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (queryLocalInterface instanceof zzaqp) {
            return (zzaqp) queryLocalInterface;
        }
        return new zzaqr(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzai(Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 2:
                zzd(Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                zzaj(Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 4:
                zzak(Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 5:
                zzal(Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 6:
                zzam(Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 7:
                zza(Stub.asInterface(parcel.readStrongBinder()), (zzaqt) zzfp.zza(parcel, zzaqt.CREATOR));
                break;
            case 8:
                zzan(Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 9:
                zze(Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                zzao(Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 11:
                zzap(Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 12:
                zzb((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
