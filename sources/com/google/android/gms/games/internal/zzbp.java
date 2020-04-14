package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzbp<L> extends UnregisterListenerMethod<zze, L> {
    protected zzbp(ListenerKey<L> listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public abstract void zzc(zze zze, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;

    /* access modifiers changed from: protected */
    public /* synthetic */ void unregisterListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zzc((zze) anyClient, taskCompletionSource);
        } catch (SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
