package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzadj extends zzfm implements zzadg {
    public zzadj() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzadf zzadf;
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
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                break;
            case 8:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                break;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                break;
            case 10:
                String price = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(price);
                break;
            case 11:
                zzwr videoController = getVideoController();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) videoController);
                break;
            case 12:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 13:
                destroy();
                parcel2.writeNoException();
                break;
            case 14:
                zzaba zzqo = zzqo();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqo);
                break;
            case 15:
                performClick((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 16:
                boolean recordImpression = recordImpression((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, recordImpression);
                break;
            case 17:
                reportTouchEvent((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 18:
                IObjectWrapper zzqm = zzqm();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqm);
                break;
            case 19:
                IObjectWrapper zzqp = zzqp();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqp);
                break;
            case 20:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfp.zzb(parcel2, extras);
                break;
            case 21:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzadf = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    if (queryLocalInterface instanceof zzadf) {
                        zzadf = (zzadf) queryLocalInterface;
                    } else {
                        zzadf = new zzadh(readStrongBinder);
                    }
                }
                zza(zzadf);
                parcel2.writeNoException();
                break;
            case 22:
                cancelUnconfirmedClick();
                parcel2.writeNoException();
                break;
            case 23:
                List muteThisAdReasons = getMuteThisAdReasons();
                parcel2.writeNoException();
                parcel2.writeList(muteThisAdReasons);
                break;
            case 24:
                boolean isCustomMuteThisAdEnabled = isCustomMuteThisAdEnabled();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, isCustomMuteThisAdEnabled);
                break;
            case 25:
                zza(zzwl.zzg(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 26:
                zza(zzwh.zzf(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 27:
                zzqw();
                parcel2.writeNoException();
                break;
            case 28:
                recordCustomClickGesture();
                parcel2.writeNoException();
                break;
            case 29:
                zzabh zzqx = zzqx();
                parcel2.writeNoException();
                zzfp.zza(parcel2, (IInterface) zzqx);
                break;
            case 30:
                boolean isCustomClickGestureEnabled = isCustomClickGestureEnabled();
                parcel2.writeNoException();
                zzfp.writeBoolean(parcel2, isCustomClickGestureEnabled);
                break;
            default:
                return false;
        }
        return true;
    }
}
