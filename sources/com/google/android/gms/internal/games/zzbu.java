package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;

abstract class zzbu extends zza<ClaimMilestoneResult> {
    private zzbu(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzbv(this, status);
    }

    /* synthetic */ zzbu(GoogleApiClient googleApiClient, zzbo zzbo) {
        this(googleApiClient);
    }
}
