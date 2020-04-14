package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig {

    public static final class Builder {
        int zzpd;
        @Deprecated
        final RoomUpdateListener zzpr;
        @Deprecated
        RoomStatusUpdateListener zzps;
        @Deprecated
        RealTimeMessageReceivedListener zzpt;
        final RoomUpdateCallback zzpu;
        RoomStatusUpdateCallback zzpv;
        OnRealTimeMessageReceivedListener zzpw;
        String zzpx;
        ArrayList<String> zzpy;
        Bundle zzpz;

        @Deprecated
        private Builder(RoomUpdateListener roomUpdateListener) {
            this.zzpx = null;
            this.zzpd = -1;
            this.zzpy = new ArrayList<>();
            this.zzpr = (RoomUpdateListener) Preconditions.checkNotNull(roomUpdateListener, "Must provide a RoomUpdateListener");
            this.zzpu = null;
        }

        private Builder(@NonNull RoomUpdateCallback roomUpdateCallback) {
            this.zzpx = null;
            this.zzpd = -1;
            this.zzpy = new ArrayList<>();
            this.zzpu = (RoomUpdateCallback) Preconditions.checkNotNull(roomUpdateCallback, "Must provide a RoomUpdateCallback");
            this.zzpr = null;
        }

        public final Builder setInvitationIdToAccept(String str) {
            Preconditions.checkNotNull(str);
            this.zzpx = str;
            return this;
        }

        @Deprecated
        public final Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomStatusUpdateListener) {
            this.zzps = roomStatusUpdateListener;
            return this;
        }

        public final Builder setRoomStatusUpdateCallback(@Nullable RoomStatusUpdateCallback roomStatusUpdateCallback) {
            this.zzpv = roomStatusUpdateCallback;
            return this;
        }

        @Deprecated
        public final Builder setMessageReceivedListener(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.zzpt = realTimeMessageReceivedListener;
            return this;
        }

        public final Builder setOnMessageReceivedListener(@NonNull OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener) {
            this.zzpw = onRealTimeMessageReceivedListener;
            return this;
        }

        public final Builder addPlayersToInvite(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            this.zzpy.addAll(Arrays.asList(strArr));
            return this;
        }

        public final Builder addPlayersToInvite(@NonNull ArrayList<String> arrayList) {
            Preconditions.checkNotNull(arrayList);
            this.zzpy.addAll(arrayList);
            return this;
        }

        public final Builder setVariant(int i) {
            Preconditions.checkArgument(i == -1 || i > 0, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.zzpd = i;
            return this;
        }

        public final Builder setAutoMatchCriteria(Bundle bundle) {
            this.zzpz = bundle;
            return this;
        }

        public final RoomConfig build() {
            return new zzd(this);
        }
    }

    protected RoomConfig() {
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    @Deprecated
    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract OnRealTimeMessageReceivedListener getOnMessageReceivedListener();

    public abstract RoomStatusUpdateCallback getRoomStatusUpdateCallback();

    @Deprecated
    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateCallback getRoomUpdateCallback();

    @Deprecated
    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();

    public abstract zzh zzdo();

    @Deprecated
    public static Builder builder(RoomUpdateListener roomUpdateListener) {
        return new Builder(roomUpdateListener);
    }

    public static Builder builder(@NonNull RoomUpdateCallback roomUpdateCallback) {
        return new Builder(roomUpdateCallback);
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }
}
