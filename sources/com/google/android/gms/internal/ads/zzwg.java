package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@18.2.0 */
public final class zzwg extends zzfn implements zzwe {
    zzwg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    public final void onAdMuted() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
