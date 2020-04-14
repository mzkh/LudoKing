package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

final /* synthetic */ class zzam implements zzaz {
    static final zzaz zziw = new zzam();

    private zzam() {
    }

    public final void zza(Object obj, int i, Room room) {
        ((RoomUpdateListener) obj).onRoomCreated(i, room);
    }
}
