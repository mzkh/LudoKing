package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.games.internal.zzbp;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.zzh;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbm extends zzbp<zzh> {
    zzbm(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public final void zzc(zze zze, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        taskCompletionSource.setResult(Boolean.valueOf(true));
    }
}
