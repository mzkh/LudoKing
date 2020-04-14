package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class PlayersClient extends zzt {
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";
    private static final ResultConverter<LoadPlayersResult, PlayerBuffer> zzdb = new zzax();
    private static final zzbm<LoadPlayersResult> zzdc = new zzay();
    private static final ResultConverter<LoadPlayersResult, Player> zzdd = new zzaz();

    PlayersClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    PlayersClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<String> getCurrentPlayerId() {
        return doRead((TaskApiCall<A, TResult>) new zzat<A,TResult>(this));
    }

    public Task<Player> getCurrentPlayer() {
        return doRead((TaskApiCall<A, TResult>) new zzau<A,TResult>(this));
    }

    public Task<AnnotatedData<Player>> loadPlayer(@NonNull String str) {
        return loadPlayer(str, false);
    }

    public Task<AnnotatedData<Player>> loadPlayer(@NonNull String str, boolean z) {
        return zzbe.zza(Games.Players.loadPlayer(asGoogleApiClient(), str, z), zzdd, zzdc);
    }

    public Task<AnnotatedData<PlayerBuffer>> loadRecentlyPlayedWithPlayers(@IntRange(from = 1, mo668to = 25) int i, boolean z) {
        return zzbe.zzb(Games.Players.loadRecentlyPlayedWithPlayers(asGoogleApiClient(), i, z), zzdb);
    }

    public Task<AnnotatedData<PlayerBuffer>> loadMoreRecentlyPlayedWithPlayers(@IntRange(from = 1, mo668to = 25) int i) {
        return zzbe.zzb(Games.Players.loadMoreRecentlyPlayedWithPlayers(asGoogleApiClient(), i), zzdb);
    }

    public Task<Intent> getCompareProfileIntent(@NonNull Player player) {
        return doRead((TaskApiCall<A, TResult>) new zzav<A,TResult>(this, player));
    }

    public Task<Intent> getPlayerSearchIntent() {
        return doRead((TaskApiCall<A, TResult>) new zzaw<A,TResult>(this));
    }
}
