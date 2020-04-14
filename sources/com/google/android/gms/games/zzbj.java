package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbo;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.zzh;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbj extends zzbo<zzh> {
    private final /* synthetic */ ListenerHolder zzbj;
    private final /* synthetic */ RoomConfig zzdq;

    zzbj(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2, RoomConfig roomConfig) {
        this.zzbj = listenerHolder2;
        this.zzdq = roomConfig;
        super(listenerHolder);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        ListenerHolder listenerHolder = this.zzbj;
        zze.zza(listenerHolder, listenerHolder, listenerHolder, this.zzdq);
        taskCompletionSource.setResult(null);
    }
}
