package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;

abstract class zzo extends zza<LoadAchievementsResult> {
    private zzo(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzp(this, status);
    }

    /* synthetic */ zzo(GoogleApiClient googleApiClient, zzf zzf) {
        this(googleApiClient);
    }
}
