package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbn;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class AchievementsClient extends zzt {
    private static final ResultConverter<LoadAchievementsResult, AchievementBuffer> zze = new zzb();
    private static final ResultConverter<UpdateAchievementResult, Void> zzf = new zzc();
    private static final ResultConverter<UpdateAchievementResult, Boolean> zzg = new zzd();
    private static final zzbn zzh = new zze();

    AchievementsClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    AchievementsClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Intent> getAchievementsIntent() {
        return doRead((TaskApiCall<A, TResult>) new zza<A,TResult>(this));
    }

    public Task<AnnotatedData<AchievementBuffer>> load(boolean z) {
        return zzbe.zzb(Games.Achievements.load(asGoogleApiClient(), z), zze);
    }

    public void reveal(@NonNull String str) {
        Games.Achievements.reveal(asGoogleApiClient(), str);
    }

    public Task<Void> revealImmediate(@NonNull String str) {
        return zza(Games.Achievements.revealImmediate(asGoogleApiClient(), str));
    }

    public void unlock(@NonNull String str) {
        Games.Achievements.unlock(asGoogleApiClient(), str);
    }

    public Task<Void> unlockImmediate(@NonNull String str) {
        return zza(Games.Achievements.unlockImmediate(asGoogleApiClient(), str));
    }

    public void increment(@NonNull String str, @IntRange(from = 0) int i) {
        Games.Achievements.increment(asGoogleApiClient(), str, i);
    }

    public Task<Boolean> incrementImmediate(@NonNull String str, @IntRange(from = 0) int i) {
        return zzb(Games.Achievements.incrementImmediate(asGoogleApiClient(), str, i));
    }

    public void setSteps(@NonNull String str, @IntRange(from = 0) int i) {
        Games.Achievements.setSteps(asGoogleApiClient(), str, i);
    }

    public Task<Boolean> setStepsImmediate(@NonNull String str, @IntRange(from = 0) int i) {
        return zzb(Games.Achievements.setStepsImmediate(asGoogleApiClient(), str, i));
    }

    private static Task<Void> zza(@NonNull PendingResult<UpdateAchievementResult> pendingResult) {
        return zzbe.zza(pendingResult, zzh, zzf);
    }

    private static Task<Boolean> zzb(@NonNull PendingResult<UpdateAchievementResult> pendingResult) {
        return zzbe.zza(pendingResult, zzh, zzg);
    }
}
