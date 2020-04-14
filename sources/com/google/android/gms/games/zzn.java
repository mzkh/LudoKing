package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzn extends zzag<Void> {
    private final /* synthetic */ int zzbe;

    zzn(GamesClient gamesClient, int i) {
        this.zzbe = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zze.zzk(this.zzbe);
        taskCompletionSource.setResult(null);
    }
}
