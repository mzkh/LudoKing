package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcx extends zzag<Boolean> {
    zzcx(VideosClient videosClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(Boolean.valueOf(zze.zzce()));
    }
}
