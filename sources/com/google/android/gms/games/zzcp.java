package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.games.internal.zzbp;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcp extends zzbp<OnTurnBasedMatchUpdateReceivedListener> {
    zzcp(TurnBasedMultiplayerClient turnBasedMultiplayerClient, ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public final void zzc(zze zze, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        zze.zzbh();
        taskCompletionSource.setResult(Boolean.valueOf(true));
    }
}
