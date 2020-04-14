package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder;

public final class zzd extends RoomConfig {
    private final String zzoy;
    private final int zzpd;
    @Deprecated
    private final RoomUpdateListener zzpr;
    @Deprecated
    private final RoomStatusUpdateListener zzps;
    @Deprecated
    private final RealTimeMessageReceivedListener zzpt;
    private final RoomUpdateCallback zzpu;
    private final RoomStatusUpdateCallback zzpv;
    private final OnRealTimeMessageReceivedListener zzpw;
    private final Bundle zzpz;
    private final zzg zzqa;
    private final String[] zzqb;

    zzd(Builder builder) {
        this.zzpr = builder.zzpr;
        this.zzps = builder.zzps;
        this.zzpt = builder.zzpt;
        this.zzpu = builder.zzpu;
        this.zzpv = builder.zzpv;
        this.zzpw = builder.zzpw;
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpv;
        if (roomStatusUpdateCallback != null) {
            this.zzqa = new zzg(this.zzpu, roomStatusUpdateCallback, this.zzpw);
        } else {
            this.zzqa = null;
        }
        this.zzoy = builder.zzpx;
        this.zzpd = builder.zzpd;
        this.zzpz = builder.zzpz;
        this.zzqb = (String[]) builder.zzpy.toArray(new String[builder.zzpy.size()]);
        if (this.zzpw == null && this.zzpt == null) {
            throw new NullPointerException("Must specify a message listener");
        }
    }

    public final zzh zzdo() {
        return this.zzqa;
    }

    @Deprecated
    @Nullable
    public final RoomUpdateListener getRoomUpdateListener() {
        return this.zzpr;
    }

    @Nullable
    public final RoomUpdateCallback getRoomUpdateCallback() {
        return this.zzpu;
    }

    public final String getInvitationId() {
        return this.zzoy;
    }

    @Deprecated
    @Nullable
    public final RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzps;
    }

    @Nullable
    public final RoomStatusUpdateCallback getRoomStatusUpdateCallback() {
        return this.zzpv;
    }

    @Deprecated
    @Nullable
    public final RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzpt;
    }

    @Nullable
    public final OnRealTimeMessageReceivedListener getOnMessageReceivedListener() {
        return this.zzpw;
    }

    public final int getVariant() {
        return this.zzpd;
    }

    public final String[] getInvitedPlayerIds() {
        return this.zzqb;
    }

    public final Bundle getAutoMatchCriteria() {
        return this.zzpz;
    }
}
