package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;

final class zzan implements zzbm<LeaderboardMetadataResult> {
    zzan() {
    }

    public final /* synthetic */ void release(@NonNull Object obj) {
        LeaderboardMetadataResult leaderboardMetadataResult = (LeaderboardMetadataResult) obj;
        if (leaderboardMetadataResult.getLeaderboards() != null) {
            leaderboardMetadataResult.getLeaderboards().release();
        }
    }
}
