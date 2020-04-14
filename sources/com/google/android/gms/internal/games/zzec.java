package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;

abstract class zzec extends zza<CaptureCapabilitiesResult> {
    private zzec(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzed(this, status);
    }

    /* synthetic */ zzec(GoogleApiClient googleApiClient, zzdx zzdx) {
        this(googleApiClient);
    }
}
