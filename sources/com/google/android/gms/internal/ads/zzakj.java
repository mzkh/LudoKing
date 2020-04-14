package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzakj extends zzfm implements zzakg {
    public zzakj() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 3:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                break;
            case 4:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                break;
            case 5:
                zzabi zzqn = zzqn();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqn);
                break;
            case 6:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                break;
            case 7:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                break;
            case 8:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                break;
            case 9:
                String price = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(price);
                break;
            case 10:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 11:
                zzy(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                zzz(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 13:
                boolean overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, overrideImpressionRecording);
                break;
            case 14:
                boolean overrideClickHandling = getOverrideClickHandling();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, overrideClickHandling);
                break;
            case 15:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfp.zzb(parcel2, extras);
                break;
            case 16:
                zzaa(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 17:
                zzwr videoController = getVideoController();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) videoController);
                break;
            case 18:
                IObjectWrapper zzry = zzry();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzry);
                break;
            case 19:
                zzaba zzqo = zzqo();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqo);
                break;
            case 20:
                IObjectWrapper zzrz = zzrz();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzrz);
                break;
            case 21:
                IObjectWrapper zzqp = zzqp();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqp);
                break;
            case 22:
                zzc(Stub.asInterface(parcel.readStrongBinder()), Stub.asInterface(parcel.readStrongBinder()), Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
