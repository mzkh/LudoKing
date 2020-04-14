package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzbd;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer zzqh;
    private final TurnBasedMatchBuffer zzqi;
    private final TurnBasedMatchBuffer zzqj;
    private final TurnBasedMatchBuffer zzqk;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder zza = zza(bundle, 0);
        if (zza != null) {
            this.zzqh = new InvitationBuffer(zza);
        } else {
            this.zzqh = null;
        }
        DataHolder zza2 = zza(bundle, 1);
        if (zza2 != null) {
            this.zzqi = new TurnBasedMatchBuffer(zza2);
        } else {
            this.zzqi = null;
        }
        DataHolder zza3 = zza(bundle, 2);
        if (zza3 != null) {
            this.zzqj = new TurnBasedMatchBuffer(zza3);
        } else {
            this.zzqj = null;
        }
        DataHolder zza4 = zza(bundle, 3);
        if (zza4 != null) {
            this.zzqk = new TurnBasedMatchBuffer(zza4);
        } else {
            this.zzqk = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String str;
        if (i == 0) {
            str = "TURN_STATUS_INVITED";
        } else if (i == 1) {
            str = "TURN_STATUS_MY_TURN";
        } else if (i == 2) {
            str = "TURN_STATUS_THEIR_TURN";
        } else if (i != 3) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unknown match turn status: ");
            sb.append(i);
            zzbd.m3401e("MatchTurnStatus", sb.toString());
            str = "TURN_STATUS_UNKNOWN";
        } else {
            str = "TURN_STATUS_COMPLETE";
        }
        if (!bundle.containsKey(str)) {
            return null;
        }
        return (DataHolder) bundle.getParcelable(str);
    }

    public final InvitationBuffer getInvitations() {
        return this.zzqh;
    }

    public final TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzqi;
    }

    public final TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzqj;
    }

    public final TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzqk;
    }

    @Deprecated
    public final void close() {
        release();
    }

    public final void release() {
        InvitationBuffer invitationBuffer = this.zzqh;
        if (invitationBuffer != null) {
            invitationBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer = this.zzqi;
        if (turnBasedMatchBuffer != null) {
            turnBasedMatchBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.zzqj;
        if (turnBasedMatchBuffer2 != null) {
            turnBasedMatchBuffer2.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.zzqk;
        if (turnBasedMatchBuffer3 != null) {
            turnBasedMatchBuffer3.release();
        }
    }

    public final boolean hasData() {
        InvitationBuffer invitationBuffer = this.zzqh;
        if (invitationBuffer != null && invitationBuffer.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer = this.zzqi;
        if (turnBasedMatchBuffer != null && turnBasedMatchBuffer.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.zzqj;
        if (turnBasedMatchBuffer2 != null && turnBasedMatchBuffer2.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.zzqk;
        if (turnBasedMatchBuffer3 == null || turnBasedMatchBuffer3.getCount() <= 0) {
            return false;
        }
        return true;
    }
}
