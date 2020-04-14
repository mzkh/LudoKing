package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import java.util.ArrayList;

final /* synthetic */ class zzbc implements zzav {
    static final zzav zzix = new zzbc();

    private zzbc() {
    }

    public final void zza(Object obj, Room room, ArrayList arrayList) {
        ((RoomStatusUpdateListener) obj).onPeersDisconnected(room, arrayList);
    }
}
