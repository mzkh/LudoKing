package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

abstract class zzcx extends zza<LoadPlayerStatsResult> {
    private zzcx(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzcy(this, status);
    }

    /* synthetic */ zzcx(GoogleApiClient googleApiClient, zzcw zzcw) {
        this(googleApiClient);
    }
}
