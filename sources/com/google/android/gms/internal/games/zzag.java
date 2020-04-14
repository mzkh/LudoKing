package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzag<TResult> extends TaskApiCall<zze, TResult> {
    /* access modifiers changed from: protected */
    public abstract void zza(zze zze, TaskCompletionSource<TResult> taskCompletionSource) throws RemoteException;

    /* access modifiers changed from: protected */
    public /* synthetic */ void doExecute(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zza((zze) anyClient, taskCompletionSource);
        } catch (RemoteException | SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
