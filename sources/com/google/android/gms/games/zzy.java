package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbo;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzy extends zzbo<OnInvitationReceivedListener> {
    private final /* synthetic */ ListenerHolder zzbj;

    zzy(InvitationsClient invitationsClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        this.zzbj = listenerHolder2;
        super(listenerHolder);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        zze.zza(this.zzbj);
        taskCompletionSource.setResult(null);
    }
}
