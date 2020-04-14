package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.zzbm;

final class zzw implements zzbm<LoadGamesResult> {
    zzw() {
    }

    public final /* synthetic */ void release(@NonNull Object obj) {
        LoadGamesResult loadGamesResult = (LoadGamesResult) obj;
        if (loadGamesResult.getGames() != null) {
            loadGamesResult.getGames().release();
        }
    }
}
