package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

@UsedByReflection("GamesClientImpl.java")
public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long rawScore;
    private final String scoreTag;
    private final long zzoa;
    private final String zzob;
    private final String zzoc;
    private final long zzod;
    private final String zzoe;
    private final Uri zzof;
    private final Uri zzog;
    private final PlayerEntity zzoh;
    private final String zzoi;
    private final String zzoj;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        PlayerEntity playerEntity;
        this.zzoa = leaderboardScore.getRank();
        this.zzob = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayRank());
        this.zzoc = (String) Preconditions.checkNotNull(leaderboardScore.getDisplayScore());
        this.rawScore = leaderboardScore.getRawScore();
        this.zzod = leaderboardScore.getTimestampMillis();
        this.zzoe = leaderboardScore.getScoreHolderDisplayName();
        this.zzof = leaderboardScore.getScoreHolderIconImageUri();
        this.zzog = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        if (scoreHolder == null) {
            playerEntity = null;
        } else {
            playerEntity = (PlayerEntity) scoreHolder.freeze();
        }
        this.zzoh = playerEntity;
        this.scoreTag = leaderboardScore.getScoreTag();
        this.zzoi = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzoj = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final long getRank() {
        return this.zzoa;
    }

    public final String getDisplayRank() {
        return this.zzob;
    }

    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzob, charArrayBuffer);
    }

    public final String getDisplayScore() {
        return this.zzoc;
    }

    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzoc, charArrayBuffer);
    }

    public final long getRawScore() {
        return this.rawScore;
    }

    public final long getTimestampMillis() {
        return this.zzod;
    }

    public final String getScoreHolderDisplayName() {
        PlayerEntity playerEntity = this.zzoh;
        if (playerEntity == null) {
            return this.zzoe;
        }
        return playerEntity.getDisplayName();
    }

    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzoh;
        if (playerEntity == null) {
            DataUtils.copyStringToBuffer(this.zzoe, charArrayBuffer);
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }

    public final Uri getScoreHolderIconImageUri() {
        PlayerEntity playerEntity = this.zzoh;
        if (playerEntity == null) {
            return this.zzof;
        }
        return playerEntity.getIconImageUri();
    }

    public final String getScoreHolderIconImageUrl() {
        PlayerEntity playerEntity = this.zzoh;
        if (playerEntity == null) {
            return this.zzoi;
        }
        return playerEntity.getIconImageUrl();
    }

    public final Uri getScoreHolderHiResImageUri() {
        PlayerEntity playerEntity = this.zzoh;
        if (playerEntity == null) {
            return this.zzog;
        }
        return playerEntity.getHiResImageUri();
    }

    public final String getScoreHolderHiResImageUrl() {
        PlayerEntity playerEntity = this.zzoh;
        if (playerEntity == null) {
            return this.zzoj;
        }
        return playerEntity.getHiResImageUrl();
    }

    public final Player getScoreHolder() {
        return this.zzoh;
    }

    public final String getScoreTag() {
        return this.scoreTag;
    }

    public final int hashCode() {
        return zza(this);
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return Objects.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return Objects.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && Objects.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && Objects.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && Objects.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && Objects.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && Objects.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && Objects.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && Objects.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && Objects.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && Objects.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    public final String toString() {
        return zzb(this);
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return Objects.toStringHelper(leaderboardScore).add("Rank", Long.valueOf(leaderboardScore.getRank())).add("DisplayRank", leaderboardScore.getDisplayRank()).add("Score", Long.valueOf(leaderboardScore.getRawScore())).add("DisplayScore", leaderboardScore.getDisplayScore()).add("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).add("DisplayName", leaderboardScore.getScoreHolderDisplayName()).add("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).add("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).add("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).add("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).add("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).add("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }
}
