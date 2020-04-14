package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;

final class zzdd extends zzdm {
    private final /* synthetic */ String zzdl;

    zzdd(zzcz zzcz, GoogleApiClient googleApiClient, String str) {
        this.zzdl = str;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzd((ResultHolder<InitiateMatchResult>) this, this.zzdl);
    }
}
