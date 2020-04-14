package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;

final class zzak implements LoadInvitationsResult {
    private final /* synthetic */ Status zzbd;

    zzak(zzaj zzaj, Status status) {
        this.zzbd = status;
    }

    public final void release() {
    }

    public final Status getStatus() {
        return this.zzbd;
    }

    public final InvitationBuffer getInvitations() {
        return new InvitationBuffer(DataHolder.empty(14));
    }
}
