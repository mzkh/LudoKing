package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

final /* synthetic */ class zzax implements zzaw {
    static final zzaw zzja = new zzax();

    private zzax() {
    }

    public final void zza(Object obj, Room room) {
        ((RoomStatusUpdateListener) obj).onRoomConnecting(room);
    }
}