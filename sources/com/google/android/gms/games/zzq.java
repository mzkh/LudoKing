package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzq extends zzag<String> {
    zzq(GamesClient gamesClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<String> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zzbr());
    }
}
