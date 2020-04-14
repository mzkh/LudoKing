package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;

final class zzaw implements LoadPlayerScoreResult {
    private final /* synthetic */ Status zzbd;

    zzaw(zzav zzav, Status status) {
        this.zzbd = status;
    }

    public final LeaderboardScore getScore() {
        return null;
    }

    public final Status getStatus() {
        return this.zzbd;
    }
}
