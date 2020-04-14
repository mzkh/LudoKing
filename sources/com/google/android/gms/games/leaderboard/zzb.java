package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

public final class zzb extends DataBufferRef implements LeaderboardVariant {
    zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final int getTimeSpan() {
        return getInteger("timespan");
    }

    public final int getCollection() {
        return getInteger("collection");
    }

    public final boolean hasPlayerInfo() {
        return !hasNull("player_raw_score");
    }

    public final long getRawPlayerScore() {
        String str = "player_raw_score";
        if (hasNull(str)) {
            return -1;
        }
        return getLong(str);
    }

    public final String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public final long getPlayerRank() {
        String str = "player_rank";
        if (hasNull(str)) {
            return -1;
        }
        return getLong(str);
    }

    public final String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public final String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public final long getNumScores() {
        String str = "total_scores";
        if (hasNull(str)) {
            return -1;
        }
        return getLong(str);
    }

    public final String zzdk() {
        return getString("top_page_token_next");
    }

    public final String zzdl() {
        return getString("window_page_token_prev");
    }

    public final String zzdm() {
        return getString("window_page_token_next");
    }

    public final int hashCode() {
        return LeaderboardVariantEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return LeaderboardVariantEntity.zza(this, obj);
    }

    public final String toString() {
        return LeaderboardVariantEntity.zzb(this);
    }

    public final /* synthetic */ Object freeze() {
        return new LeaderboardVariantEntity(this);
    }
}
