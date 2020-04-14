package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

final class zzba implements SubmitScoreResult {
    private final /* synthetic */ Status zzbd;

    zzba(zzaz zzaz, Status status) {
        this.zzbd = status;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final ScoreSubmissionData getScoreData() {
        return new ScoreSubmissionData(DataHolder.empty(14));
    }
}
