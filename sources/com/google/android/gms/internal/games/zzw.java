package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.zze;

final class zzw extends zzy {
    private final /* synthetic */ boolean zzjz;

    zzw(zzu zzu, GoogleApiClient googleApiClient, boolean z) {
        this.zzjz = z;
        super(googleApiClient, null);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzd((ResultHolder<LoadEventsResult>) this, this.zzjz);
    }
}
