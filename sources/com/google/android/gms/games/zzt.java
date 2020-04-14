package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzt extends zzag<Integer> {
    zzt(GamesClient gamesClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Integer> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(Integer.valueOf(zze.zzbp()));
    }
}
