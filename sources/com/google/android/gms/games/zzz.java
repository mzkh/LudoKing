package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.games.internal.zzbp;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzz extends zzbp<OnInvitationReceivedListener> {
    zzz(InvitationsClient invitationsClient, ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public final void zzc(zze zze, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        zze.zzbf();
        taskCompletionSource.setResult(Boolean.valueOf(true));
    }
}
