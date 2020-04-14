package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.zza;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

abstract class zzq extends zza<UpdateAchievementResult> {
    /* access modifiers changed from: private */
    public final String zzfr;

    public zzq(String str, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzfr = str;
    }

    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzr(this, status);
    }
}
