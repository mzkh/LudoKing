package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;

abstract class zzax extends zza<LoadScoresResult> {
    private zzax(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzay(this, status);
    }

    /* synthetic */ zzax(GoogleApiClient googleApiClient, zzam zzam) {
        this(googleApiClient);
    }
}
