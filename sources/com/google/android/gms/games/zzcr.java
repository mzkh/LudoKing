package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcr extends zzag<Void> {
    private final /* synthetic */ String zzdl;

    zzcr(TurnBasedMultiplayerClient turnBasedMultiplayerClient, String str) {
        this.zzdl = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zze.zzd(this.zzdl, 1);
        taskCompletionSource.setResult(null);
    }
}
