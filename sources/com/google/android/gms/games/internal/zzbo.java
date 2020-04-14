package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzbo<L> extends RegisterListenerMethod<zze, L> {
    protected zzbo(ListenerHolder<L> listenerHolder) {
        super(listenerHolder);
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    /* access modifiers changed from: protected */
    public /* synthetic */ void registerListener(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            zzb((zze) anyClient, taskCompletionSource);
        } catch (SecurityException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
