package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzakk extends zzfm implements zzakl {
    public zzakk() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
                zzabi zzqq = zzqq();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqq);
                break;
            case 6:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                break;
            case 7:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                break;
            case 8:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 9:
                zzy(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 10:
                zzz(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 11:
                boolean overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, overrideImpressionRecording);
                break;
            case 12:
                boolean overrideClickHandling = getOverrideClickHandling();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, overrideClickHandling);
                break;
            case 13:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfp.zzb(parcel2, extras);
                break;
            case 14:
                zzaa(Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                IObjectWrapper zzry = zzry();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzry);
                break;
            case 16:
                zzwr videoController = getVideoController();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) videoController);
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
