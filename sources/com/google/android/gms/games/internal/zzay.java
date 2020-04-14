package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

final /* synthetic */ class zzay implements zzaw {
    static final zzaw zzja = new zzay();

    private zzay() {
    }

    public final void zza(Object obj, Room room) {
        ((RoomStatusUpdateListener) obj).onRoomAutoMatching(room);
    }
}
