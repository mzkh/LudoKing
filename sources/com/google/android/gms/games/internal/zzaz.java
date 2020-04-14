package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

final /* synthetic */ class zzaz implements zzaw {
    static final zzaw zzja = new zzaz();

    private zzaz() {
    }

    public final void zza(Object obj, Room room) {
        ((RoomStatusUpdateListener) obj).onConnectedToRoom(room);
    }
}
