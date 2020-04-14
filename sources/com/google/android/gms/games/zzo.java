package com.google.android.gms.games;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzo extends zzag<Void> {
    private final /* synthetic */ View zzbf;

    zzo(GamesClient gamesClient, View view) {
        this.zzbf = view;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zze.zza(this.zzbf);
        taskCompletionSource.setResult(null);
    }
}
