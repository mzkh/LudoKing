package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

abstract class zzbw extends zza<LoadQuestsResult> {
    private zzbw(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzbx(this, status);
    }

    /* synthetic */ zzbw(GoogleApiClient googleApiClient, zzbo zzbo) {
        this(googleApiClient);
    }
}
