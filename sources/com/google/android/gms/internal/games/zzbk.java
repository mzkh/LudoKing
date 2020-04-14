package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.zze;

final class zzbk extends zzbl {
    private final /* synthetic */ boolean zzjz;

    zzbk(zzbd zzbd, GoogleApiClient googleApiClient, boolean z) {
        this.zzjz = z;
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<LoadPlayersResult>) this, this.zzjz);
    }
}
