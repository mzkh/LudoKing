package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class LeaderboardsClient extends zzt {
    private static final ResultConverter<LeaderboardMetadataResult, LeaderboardBuffer> zzbk = new zzal();
    private static final ResultConverter<LeaderboardMetadataResult, Leaderboard> zzbl = new zzam();
    private static final zzbm<LeaderboardMetadataResult> zzbm = new zzan();
    private static final ResultConverter<LoadPlayerScoreResult, LeaderboardScore> zzbn = new zzac();
    private static final zzbn zzbo = new zzad();
    private static final ResultConverter<SubmitScoreResult, ScoreSubmissionData> zzbp = new zzae();
    private static final ResultConverter<LoadScoresResult, LeaderboardScores> zzbq = new zzaf();

    public static class LeaderboardScores implements Releasable {
        private final Leaderboard zzbw;
        private final LeaderboardScoreBuffer zzbx;

        public LeaderboardScores(@Nullable Leaderboard leaderboard, @NonNull LeaderboardScoreBuffer leaderboardScoreBuffer) {
            this.zzbw = leaderboard;
            this.zzbx = leaderboardScoreBuffer;
        }

        @Nullable
        public Leaderboard getLeaderboard() {
            return this.zzbw;
        }

        @NonNull
        public LeaderboardScoreBuffer getScores() {
            return this.zzbx;
        }

        public void release() {
            LeaderboardScoreBuffer leaderboardScoreBuffer = this.zzbx;
            if (leaderboardScoreBuffer != null) {
                leaderboardScoreBuffer.release();
            }
        }
    }

    LeaderboardsClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    LeaderboardsClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Intent> getAllLeaderboardsIntent() {
        return doRead((TaskApiCall<A, TResult>) new zzab<A,TResult>(this));
    }

    public Task<Intent> getLeaderboardIntent(@NonNull String str) {
        return doRead((TaskApiCall<A, TResult>) new zzag<A,TResult>(this, str));
    }

    public Task<Intent> getLeaderboardIntent(@NonNull String str, int i) {
        return doRead((TaskApiCall<A, TResult>) new zzah<A,TResult>(this, str, i));
    }

    public Task<Intent> getLeaderboardIntent(@NonNull String str, int i, int i2) {
        return doRead((TaskApiCall<A, TResult>) new zzai<A,TResult>(this, str, i, i2));
    }

    public Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(boolean z) {
        return zzbe.zzb(Games.Leaderboards.loadLeaderboardMetadata(asGoogleApiClient(), z), zzbk);
    }

    public Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(@NonNull String str, boolean z) {
        return zzbe.zza(Games.Leaderboards.loadLeaderboardMetadata(asGoogleApiClient(), str, z), zzbl, zzbm);
    }

    public Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(@NonNull String str, int i, int i2) {
        return zzbe.zza(Games.Leaderboards.loadCurrentPlayerLeaderboardScore(asGoogleApiClient(), str, i, i2), zzbn);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadTopScores(@NonNull String str, int i, int i2, @IntRange(from = 1, mo668to = 25) int i3) {
        return zzbe.zzb(Games.Leaderboards.loadTopScores(asGoogleApiClient(), str, i, i2, i3), zzbq);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadTopScores(@NonNull String str, int i, int i2, @IntRange(from = 1, mo668to = 25) int i3, boolean z) {
        return zzbe.zzb(Games.Leaderboards.loadTopScores(asGoogleApiClient(), str, i, i2, i3, z), zzbq);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(@NonNull String str, int i, int i2, @IntRange(from = 1, mo668to = 25) int i3) {
        return zzbe.zzb(Games.Leaderboards.loadPlayerCenteredScores(asGoogleApiClient(), str, i, i2, i3), zzbq);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadPlayerCenteredScores(@NonNull String str, int i, int i2, @IntRange(from = 1, mo668to = 25) int i3, boolean z) {
        return zzbe.zzb(Games.Leaderboards.loadPlayerCenteredScores(asGoogleApiClient(), str, i, i2, i3, z), zzbq);
    }

    public Task<AnnotatedData<LeaderboardScores>> loadMoreScores(@NonNull LeaderboardScoreBuffer leaderboardScoreBuffer, @IntRange(from = 1, mo668to = 25) int i, int i2) {
        return zzbe.zzb(Games.Leaderboards.loadMoreScores(asGoogleApiClient(), leaderboardScoreBuffer, i, i2), zzbq);
    }

    public void submitScore(@NonNull String str, long j) {
        doWrite((TaskApiCall<A, TResult>) new zzaj<A,TResult>(this, str, j));
    }

    public void submitScore(@NonNull String str, long j, @NonNull String str2) {
        zzak zzak = new zzak(this, str, j, str2);
        doWrite((TaskApiCall<A, TResult>) zzak);
    }

    public Task<ScoreSubmissionData> submitScoreImmediate(@NonNull String str, long j) {
        return zzbe.zza(Games.Leaderboards.submitScoreImmediate(asGoogleApiClient(), str, j), zzbo, zzbp);
    }

    public Task<ScoreSubmissionData> submitScoreImmediate(@NonNull String str, long j, @NonNull String str2) {
        return zzbe.zza(Games.Leaderboards.submitScoreImmediate(asGoogleApiClient(), str, j, str2), zzbo, zzbp);
    }
}
