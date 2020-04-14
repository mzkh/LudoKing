package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzao extends zzag<Void> {
    private final /* synthetic */ int zzby;

    zzao(NotificationsClient notificationsClient, int i) {
        this.zzby = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zze.zzl(this.zzby);
        taskCompletionSource.setResult(null);
    }
}
