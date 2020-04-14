package com.google.android.gms.games.multiplayer;

import androidx.annotation.NonNull;

public abstract class InvitationCallback implements OnInvitationReceivedListener {
    public abstract void onInvitationReceived(@NonNull Invitation invitation);

    public abstract void onInvitationRemoved(@NonNull String str);
}
