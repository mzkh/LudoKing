package com.google.android.gms.games.multiplayer.turnbased;

import androidx.annotation.NonNull;

public abstract class TurnBasedMatchUpdateCallback implements OnTurnBasedMatchUpdateReceivedListener {
    public abstract void onTurnBasedMatchReceived(@NonNull TurnBasedMatch turnBasedMatch);

    public abstract void onTurnBasedMatchRemoved(@NonNull String str);
}
