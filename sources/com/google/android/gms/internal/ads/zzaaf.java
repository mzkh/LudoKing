package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public abstract class zzaaf extends zzfm implements zzaac {
    public zzaaf() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String zzqb = zzqb();
            parcel2.writeNoException();
            parcel2.writeString(zzqb);
        } else if (i == 2) {
            String content = getContent();
            parcel2.writeNoException();
            parcel2.writeString(content);
        } else if (i == 3) {
            zzs(Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i == 4) {
            recordClick();
            parcel2.writeNoException();
        } else if (i != 5) {
            return false;
        } else {
            recordImpression();
            parcel2.writeNoException();
        }
        return true;
    }
}
