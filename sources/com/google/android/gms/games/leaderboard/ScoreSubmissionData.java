package com.google.android.gms.games.leaderboard;

import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.games.zzeg;

public final class ScoreSubmissionData {
    private static final String[] zznr = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int statusCode;
    private String zzbz;
    private String zznt;
    private SparseArray<Result> zzox = new SparseArray<>();

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long j, String str, String str2, boolean z) {
            this.rawScore = j;
            this.formattedScore = str;
            this.scoreTag = str2;
            this.newBest = z;
        }

        public final String toString() {
            return Objects.toStringHelper(this).add("RawScore", Long.valueOf(this.rawScore)).add("FormattedScore", this.formattedScore).add("ScoreTag", this.scoreTag).add("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.statusCode = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        Preconditions.checkArgument(count == 3);
        for (int i = 0; i < count; i++) {
            int windowIndex = dataHolder.getWindowIndex(i);
            if (i == 0) {
                this.zznt = dataHolder.getString("leaderboardId", i, windowIndex);
                this.zzbz = dataHolder.getString("playerId", i, windowIndex);
            }
            if (dataHolder.getBoolean("hasResult", i, windowIndex)) {
                Result result = new Result(dataHolder.getLong("rawScore", i, windowIndex), dataHolder.getString("formattedScore", i, windowIndex), dataHolder.getString("scoreTag", i, windowIndex), dataHolder.getBoolean("newBest", i, windowIndex));
                this.zzox.put(dataHolder.getInteger("timeSpan", i, windowIndex), result);
            }
        }
    }

    public final String getLeaderboardId() {
        return this.zznt;
    }

    public final String getPlayerId() {
        return this.zzbz;
    }

    public final Result getScoreResult(int i) {
        return (Result) this.zzox.get(i);
    }

    public final String toString() {
        String str;
        String str2 = "StatusCode";
        ToStringHelper add = Objects.toStringHelper(this).add("PlayerId", this.zzbz).add(str2, Integer.valueOf(this.statusCode));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zzox.get(i);
            add.add("TimesSpan", zzeg.zzn(i));
            if (result == null) {
                str = "null";
            } else {
                str = result.toString();
            }
            add.add("Result", str);
        }
        return add.toString();
    }
}
