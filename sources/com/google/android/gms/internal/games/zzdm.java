package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;

abstract class zzdm extends zza<InitiateMatchResult> {
    private zzdm(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzdn(this, status);
    }

    /* synthetic */ zzdm(GoogleApiClient googleApiClient, zzda zzda) {
        this(googleApiClient);
    }
}
