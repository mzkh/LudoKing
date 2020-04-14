package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.zze;

final class zzbi extends zzbl {
    private final /* synthetic */ boolean zzjz;
    private final /* synthetic */ int zzkk;

    zzbi(zzbd zzbd, GoogleApiClient googleApiClient, int i, boolean z) {
        this.zzkk = i;
        this.zzjz = z;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadPlayersResult>) this, "played_with", this.zzkk, false, this.zzjz);
    }
}
