package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;

final class zzay implements LoadScoresResult {
    private final /* synthetic */ Status zzbd;

    zzay(zzax zzax, Status status) {
        this.zzbd = status;
    }

    public final Leaderboard getLeaderboard() {
        return null;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final LeaderboardScoreBuffer getScores() {
        return new LeaderboardScoreBuffer(DataHolder.empty(14));
    }
}
