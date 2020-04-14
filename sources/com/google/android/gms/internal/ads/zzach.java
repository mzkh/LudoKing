package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzach extends zzfm implements zzace {
    public zzach() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzace zzp(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (queryLocalInterface instanceof zzace) {
            return (zzace) queryLocalInterface;
        }
        return new zzacg(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String zzco = zzco(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzco);
                break;
            case 2:
                zzabi zzcp = zzcp(parcel.readString());
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzcp);
                break;
            case 3:
                List availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                break;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                break;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 7:
                zzwr videoController = getVideoController();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) videoController);
                break;
            case 8:
                destroy();
                parcel2.writeNoException();
                break;
            case 9:
                IObjectWrapper zzqr = zzqr();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqr);
                break;
            case 10:
                boolean zzu = zzu(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, zzu);
                break;
            case 11:
                IObjectWrapper zzqm = zzqm();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqm);
                break;
            case 12:
                boolean zzqs = zzqs();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, zzqs);
                break;
            case 13:
                boolean zzqt = zzqt();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, zzqt);
                break;
            case 14:
                zzv(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                zzqu();
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
