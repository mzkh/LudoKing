package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import java.util.ArrayList;

final /* synthetic */ class zzao implements zzav {
    static final zzav zzix = new zzao();

    private zzao() {
    }

    public final void zza(Object obj, Room room, ArrayList arrayList) {
        ((RoomStatusUpdateListener) obj).onPeerInvitedToRoom(room, arrayList);
    }
}
