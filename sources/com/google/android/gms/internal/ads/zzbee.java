package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzbee extends zzfm implements zzbeb {
    public zzbee() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                performAction((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                Bundle performActionWithResponse = performActionWithResponse((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfp.zzb(parcel2, performActionWithResponse);
                break;
            case 3:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                zza(parcel.readString(), parcel.readString(), Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 5:
                Map userProperties = getUserProperties(parcel.readString(), parcel.readString(), zzfp.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeMap(userProperties);
                break;
            case 6:
                int maxUserProperties = getMaxUserProperties(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(maxUserProperties);
                break;
            case 7:
                setConditionalUserProperty((Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 8:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzfp.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 9:
                List conditionalUserProperties = getConditionalUserProperties(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeList(conditionalUserProperties);
                break;
            case 10:
                String appInstanceId = getAppInstanceId();
                parcel2.writeNoException();
                parcel2.writeString(appInstanceId);
                break;
            case 11:
                String gmpAppId = getGmpAppId();
                parcel2.writeNoException();
                parcel2.writeString(gmpAppId);
                break;
            case 12:
                long generateEventId = generateEventId();
                parcel2.writeNoException();
                parcel2.writeLong(generateEventId);
                break;
            case 13:
                beginAdUnitExposure(parcel.readString());
                parcel2.writeNoException();
                break;
            case 14:
                endAdUnitExposure(parcel.readString());
                parcel2.writeNoException();
                break;
            case 15:
                zzb(Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 16:
                String currentScreenName = getCurrentScreenName();
                parcel2.writeNoException();
                parcel2.writeString(currentScreenName);
                break;
            case 17:
                String currentScreenClass = getCurrentScreenClass();
                parcel2.writeNoException();
                parcel2.writeString(currentScreenClass);
                break;
            case 18:
                String appIdOrigin = getAppIdOrigin();
                parcel2.writeNoException();
                parcel2.writeString(appIdOrigin);
                break;
            default:
                return false;
        }
        return true;
    }
}
