package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

final /* synthetic */ class zzat implements zzap {
    private final String zzhv;

    zzat(String str) {
        this.zzhv = str;
    }

    public final void accept(Object obj) {
        ((RoomStatusUpdateListener) obj).onP2PDisconnected(this.zzhv);
    }
}
