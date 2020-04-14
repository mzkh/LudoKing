package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;

abstract class zzds extends zza<LoadMatchesResult> {
    private zzds(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzdt(this, status);
    }

    /* synthetic */ zzds(GoogleApiClient googleApiClient, zzda zzda) {
        this(googleApiClient);
    }
}
