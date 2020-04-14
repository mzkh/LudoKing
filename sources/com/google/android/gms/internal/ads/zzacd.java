package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzacd extends zzfm implements zzaca {
    public zzacd() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper zzqm = zzqm();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqm);
                break;
            case 3:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                break;
            case 5:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                break;
            case 6:
                zzabi zzqq = zzqq();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqq);
                break;
            case 7:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                break;
            case 8:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                break;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfp.zzb(parcel2, extras);
                break;
            case 10:
                destroy();
                parcel2.writeNoException();
                break;
            case 11:
                zzwr videoController = getVideoController();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) videoController);
                break;
            case 12:
                performClick((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                boolean recordImpression = recordImpression((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, recordImpression);
                break;
            case 14:
                reportTouchEvent((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 15:
                zzaba zzqo = zzqo();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqo);
                break;
            case 16:
                IObjectWrapper zzqp = zzqp();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqp);
                break;
            case 17:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            default:
                return false;
        }
        return true;
    }
}
