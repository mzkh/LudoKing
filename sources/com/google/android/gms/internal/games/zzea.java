package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;

abstract class zzea extends zza<CaptureAvailableResult> {
    private zzea(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzeb(this, status);
    }

    /* synthetic */ zzea(GoogleApiClient googleApiClient, zzdx zzdx) {
        this(googleApiClient);
    }
}
