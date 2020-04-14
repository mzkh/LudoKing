package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;

final class zzda extends zzdm {
    private final /* synthetic */ TurnBasedMatchConfig zzkz;

    zzda(zzcz zzcz, GoogleApiClient googleApiClient, TurnBasedMatchConfig turnBasedMatchConfig) {
        this.zzkz = turnBasedMatchConfig;
        super(googleApiClient, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zza((ResultHolder<InitiateMatchResult>) this, this.zzkz);
    }
}
