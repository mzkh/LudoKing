package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;

abstract class zzbs extends zza<AcceptQuestResult> {
    private zzbs(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzbt(this, status);
    }

    /* synthetic */ zzbs(GoogleApiClient googleApiClient, zzbo zzbo) {
        this(googleApiClient);
    }
}
