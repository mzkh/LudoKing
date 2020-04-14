package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzau extends zzag<Player> {
    zzau(PlayersClient playersClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Player> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zzaw());
    }
}
