package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.video.Videos.CaptureStateResult;

abstract class zzee extends zza<CaptureStateResult> {
    private zzee(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzef(this, status);
    }

    /* synthetic */ zzee(GoogleApiClient googleApiClient, zzdx zzdx) {
        this(googleApiClient);
    }
}
