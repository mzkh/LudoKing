package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

final class zzaf implements LoadGamesResult {
    private final /* synthetic */ Status zzbd;

    zzaf(zzae zzae, Status status) {
        this.zzbd = status;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final GameBuffer getGames() {
        return new GameBuffer(DataHolder.empty(14));
    }
}
