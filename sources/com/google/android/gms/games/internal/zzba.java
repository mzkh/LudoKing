package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

final /* synthetic */ class zzba implements zzaw {
    static final zzaw zzja = new zzba();

    private zzba() {
    }

    public final void zza(Object obj, Room room) {
        ((RoomStatusUpdateListener) obj).onDisconnectedFromRoom(room);
    }
}
