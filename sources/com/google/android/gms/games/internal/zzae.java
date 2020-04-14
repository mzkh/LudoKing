package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

final /* synthetic */ class zzae implements zzap {
    private final Invitation zzhu;

    zzae(Invitation invitation) {
        this.zzhu = invitation;
    }

    public final void accept(Object obj) {
        ((OnInvitationReceivedListener) obj).onInvitationReceived(this.zzhu);
    }
}
