package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.zze;

final class zzbe extends zzbl {
    private final /* synthetic */ String zzkj;

    zzbe(zzbd zzbd, GoogleApiClient googleApiClient, String str) {
        this.zzkj = str;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadPlayersResult>) this, this.zzkj, false);
    }
}
