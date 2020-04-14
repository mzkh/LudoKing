package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;

abstract class zzat extends zza<LeaderboardMetadataResult> {
    private zzat(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzau(this, status);
    }

    /* synthetic */ zzat(GoogleApiClient googleApiClient, zzam zzam) {
        this(googleApiClient);
    }
}
