package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zze;

final class zzh extends zzq {
    private final /* synthetic */ String val$id;

    zzh(zze zze, String str, GoogleApiClient googleApiClient, String str2) {
        this.val$id = str2;
        super(str, googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza(null, this.val$id);
    }
}
