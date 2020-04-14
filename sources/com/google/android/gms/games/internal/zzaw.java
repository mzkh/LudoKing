package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

final /* synthetic */ class zzaw implements zzaz {
    static final zzaz zziw = new zzaw();

    private zzaw() {
    }

    public final void zza(Object obj, int i, Room room) {
        ((RoomUpdateListener) obj).onRoomConnected(i, room);
    }
}
