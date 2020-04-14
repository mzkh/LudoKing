package com.google.android.gms.games.internal;

import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.OnRequestReceivedListener;

final /* synthetic */ class zzak implements zzap {
    private final GameRequest zzir;

    zzak(GameRequest gameRequest) {
        this.zzir = gameRequest;
    }

    public final void accept(Object obj) {
        ((OnRequestReceivedListener) obj).onRequestReceived(this.zzir);
    }
}
