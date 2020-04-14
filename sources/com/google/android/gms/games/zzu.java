package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzu extends zzag<Game> {
    zzu(GamesMetadataClient gamesMetadataClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Game> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zzay());
    }
}
