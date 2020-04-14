package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class PlayerStatsClient extends zzt {
    private static final ResultConverter<LoadPlayerStatsResult, PlayerStats> zzda = new zzas();

    PlayerStatsClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    PlayerStatsClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<AnnotatedData<PlayerStats>> loadPlayerStats(boolean z) {
        return zzbe.zza(Games.Stats.loadPlayerStats(asGoogleApiClient(), z), zzda);
    }
}
