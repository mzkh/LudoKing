package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.zzbm;

final class zzay implements zzbm<LoadPlayersResult> {
    zzay() {
    }

    public final /* synthetic */ void release(@NonNull Object obj) {
        LoadPlayersResult loadPlayersResult = (LoadPlayersResult) obj;
        if (loadPlayersResult.getPlayers() != null) {
            loadPlayersResult.getPlayers().release();
        }
    }
}
