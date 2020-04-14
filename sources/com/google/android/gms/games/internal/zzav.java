package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

final /* synthetic */ class zzav implements zzap {
    private final int zzhc;
    private final String zziz;

    zzav(int i, String str) {
        this.zzhc = i;
        this.zziz = str;
    }

    public final void accept(Object obj) {
        ((RoomUpdateListener) obj).onLeftRoom(this.zzhc, this.zziz);
    }
}
