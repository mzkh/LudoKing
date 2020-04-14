package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

final /* synthetic */ class zzas implements zzap {
    private final String zzhv;

    zzas(String str) {
        this.zzhv = str;
    }

    public final void accept(Object obj) {
        ((RoomStatusUpdateListener) obj).onP2PConnected(this.zzhv);
    }
}
