package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcq extends zzag<Intent> {
    private final /* synthetic */ int zzdn;
    private final /* synthetic */ int zzdo;
    private final /* synthetic */ boolean zzdp;

    zzcq(TurnBasedMultiplayerClient turnBasedMultiplayerClient, int i, int i2, boolean z) {
        this.zzdn = i;
        this.zzdo = i2;
        this.zzdp = z;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zza(this.zzdn, this.zzdo, this.zzdp));
    }
}
