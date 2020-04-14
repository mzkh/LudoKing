package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.zze;

final class zzbj extends zzbl {
    private final /* synthetic */ int zzkk;

    zzbj(zzbd zzbd, GoogleApiClient googleApiClient, int i) {
        this.zzkk = i;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadPlayersResult>) this, "played_with", this.zzkk, true, false);
    }
}
