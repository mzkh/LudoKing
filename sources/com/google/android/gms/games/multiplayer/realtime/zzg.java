package com.google.android.gms.games.multiplayer.realtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public final class zzg implements zzh {
    private final RoomUpdateCallback zzpu;
    private final RoomStatusUpdateCallback zzpv;
    private final OnRealTimeMessageReceivedListener zzqg;

    public zzg(@NonNull RoomUpdateCallback roomUpdateCallback, @Nullable RoomStatusUpdateCallback roomStatusUpdateCallback, @Nullable OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener) {
        this.zzpu = roomUpdateCallback;
        this.zzpv = roomStatusUpdateCallback;
        this.zzqg = onRealTimeMessageReceivedListener;
    }

    public final void onRealTimeMessageReceived(@NonNull RealTimeMessage realTimeMessage) {
        OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener = this.zzqg;
        if (onRealTimeMessageReceivedListener != null) {
            onRealTimeMessageReceivedListener.onRealTimeMessageReceived(realTimeMessage);
        }
    }

    public final void onRoomConnecting(@Nullable Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onRoomConnecting(room);
        }
    }

    public final void onRoomAutoMatching(@Nullable Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onRoomAutoMatching(room);
        }
    }

    public final void onPeerInvitedToRoom(@Nullable Room room, @NonNull List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerInvitedToRoom(room, list);
        }
    }

    public final void onPeerDeclined(@Nullable Room room, @NonNull List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerDeclined(room, list);
        }
    }

    public final void onPeerJoined(@Nullable Room room, @NonNull List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerJoined(room, list);
        }
    }

    public final void onPeerLeft(@Nullable Room room, @NonNull List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerLeft(room, list);
        }
    }

    public final void onConnectedToRoom(@Nullable Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onConnectedToRoom(room);
        }
    }

    public final void onDisconnectedFromRoom(@Nullable Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onDisconnectedFromRoom(room);
        }
    }

    public final void onPeersConnected(@Nullable Room room, @NonNull List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeersConnected(room, list);
        }
    }

    public final void onPeersDisconnected(@Nullable Room room, @NonNull List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeersDisconnected(room, list);
        }
    }

    public final void onP2PConnected(@NonNull String str) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onP2PConnected(str);
        }
    }

    public final void onP2PDisconnected(@NonNull String str) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onP2PDisconnected(str);
        }
    }

    public final void onRoomCreated(int i, @Nullable Room room) {
        RoomUpdateCallback roomUpdateCallback = this.zzpu;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onRoomCreated(i, room);
        }
    }

    public final void onJoinedRoom(int i, @Nullable Room room) {
        RoomUpdateCallback roomUpdateCallback = this.zzpu;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onJoinedRoom(i, room);
        }
    }

    public final void onLeftRoom(int i, @NonNull String str) {
        RoomUpdateCallback roomUpdateCallback = this.zzpu;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onLeftRoom(i, str);
        }
    }

    public final void onRoomConnected(int i, @Nullable Room room) {
        RoomUpdateCallback roomUpdateCallback = this.zzpu;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onRoomConnected(i, room);
        }
    }
}
