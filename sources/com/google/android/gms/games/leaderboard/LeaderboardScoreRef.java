package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends DataBufferRef implements LeaderboardScore {
    private final PlayerRef zzok;

    LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzok = new PlayerRef(dataHolder, i);
    }

    public final long getRank() {
        return getLong("rank");
    }

    public final String getDisplayRank() {
        return getString("display_rank");
    }

    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_rank", charArrayBuffer);
    }

    public final String getDisplayScore() {
        return getString("display_score");
    }

    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("display_score", charArrayBuffer);
    }

    public final long getRawScore() {
        return getLong("raw_score");
    }

    public final long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public final String getScoreHolderDisplayName() {
        if (hasNull("external_player_id")) {
            return getString("default_display_name");
        }
        return this.zzok.getDisplayName();
    }

    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (hasNull("external_player_id")) {
            copyToBuffer("default_display_name", charArrayBuffer);
        } else {
            this.zzok.getDisplayName(charArrayBuffer);
        }
    }

    public final Uri getScoreHolderIconImageUri() {
        if (hasNull("external_player_id")) {
            return parseUri("default_display_image_uri");
        }
        return this.zzok.getIconImageUri();
    }

    public final String getScoreHolderIconImageUrl() {
        if (hasNull("external_player_id")) {
            return getString("default_display_image_url");
        }
        return this.zzok.getIconImageUrl();
    }

    public final Uri getScoreHolderHiResImageUri() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zzok.getHiResImageUri();
    }

    public final String getScoreHolderHiResImageUrl() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zzok.getHiResImageUrl();
    }

    public final Player getScoreHolder() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zzok;
    }

    public final String getScoreTag() {
        return getString("score_tag");
    }

    public final int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public final boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public final String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public final /* synthetic */ Object freeze() {
        return new LeaderboardScoreEntity(this);
    }
}
