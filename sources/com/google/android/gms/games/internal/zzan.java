package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

final /* synthetic */ class zzan implements zzaz {
    static final zzaz zziw = new zzan();

    private zzan() {
    }

    public final void zza(Object obj, int i, Room room) {
        ((RoomUpdateListener) obj).onJoinedRoom(i, room);
    }
}
