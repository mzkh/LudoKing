package com.google.android.gms.games;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzs extends zzag<Bundle> {
    zzs(GamesClient gamesClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Bundle> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zzat());
    }
}
