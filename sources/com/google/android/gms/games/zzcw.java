package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcw extends zzag<Intent> {
    zzcw(VideosClient videosClient) {
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zzcc());
    }
}
