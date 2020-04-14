package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;

abstract class zzav extends zza<LoadPlayerScoreResult> {
    private zzav(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzaw(this, status);
    }

    /* synthetic */ zzav(GoogleApiClient googleApiClient, zzam zzam) {
        this(googleApiClient);
    }
}
