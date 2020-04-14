package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcu extends zzag<Void> {
    private final /* synthetic */ String zzey;

    zzcu(TurnBasedMultiplayerClient turnBasedMultiplayerClient, String str) {
        this.zzey = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zze.zzb(this.zzey);
        taskCompletionSource.setResult(null);
    }
}
