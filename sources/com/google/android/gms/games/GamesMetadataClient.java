package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.zzbe;
import com.google.android.gms.games.internal.zzbm;
import com.google.android.gms.internal.games.zzt;
import com.google.android.gms.tasks.Task;

public class GamesMetadataClient extends zzt {
    private static final ResultConverter<LoadGamesResult, Game> zzbg = new zzv();
    private static final zzbm<LoadGamesResult> zzbh = new zzw();

    GamesMetadataClient(@NonNull Context context, @NonNull GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    GamesMetadataClient(@NonNull Activity activity, @NonNull GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Game> getCurrentGame() {
        return doRead((TaskApiCall<A, TResult>) new zzu<A,TResult>(this));
    }

    public Task<AnnotatedData<Game>> loadGame() {
        return zzbe.zza(Games.GamesMetadata.loadGame(asGoogleApiClient()), zzbg, zzbh);
    }
}
