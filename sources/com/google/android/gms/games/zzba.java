package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzba extends zzag<Intent> {
    private final /* synthetic */ Room zzdf;
    private final /* synthetic */ int zzdg;

    zzba(RealTimeMultiplayerClient realTimeMultiplayerClient, Room room, int i) {
        this.zzdf = room;
        this.zzdg = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zza(this.zzdf, this.zzdg));
    }
}
