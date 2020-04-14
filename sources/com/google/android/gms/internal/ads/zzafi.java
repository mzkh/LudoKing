package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzafi extends zzfn implements zzafj {
    zzafi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zza(zzafd zzafd, zzafh zzafh) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzfp.zza(obtainAndWriteInterfaceToken, (Parcelable) zzafd);
        zzfp.zza(obtainAndWriteInterfaceToken, (IInterface) zzafh);
        zzb(2, obtainAndWriteInterfaceToken);
    }
}
