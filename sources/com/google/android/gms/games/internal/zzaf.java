package com.google.android.gms.games.internal;

import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

final /* synthetic */ class zzaf implements zzap {
    private final String zzhv;

    zzaf(String str) {
        this.zzhv = str;
    }

    public final void accept(Object obj) {
        ((OnInvitationReceivedListener) obj).onInvitationRemoved(this.zzhv);
    }
}
