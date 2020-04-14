package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzwa extends zzfm implements zzwb {
    public zzwa() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                initialize();
                parcel2.writeNoException();
                break;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                break;
            case 3:
                zzby(parcel.readString());
                parcel2.writeNoException();
                break;
            case 4:
                setAppMuted(zzfp.zza(parcel));
                parcel2.writeNoException();
                break;
            case 5:
                zzc(Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                zzb(parcel.readString(), Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 7:
                float zzos = zzos();
                parcel2.writeNoException();
                parcel2.writeFloat(zzos);
                break;
            case 8:
                boolean zzot = zzot();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, zzot);
                break;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                break;
            case 10:
                zzbz(parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                zza(zzajw.zzaa(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                zza(zzafx.zzy(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 13:
                List zzou = zzou();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzou);
                break;
            case 14:
                zza((zzyd) zzfp.zza(parcel, zzyd.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
