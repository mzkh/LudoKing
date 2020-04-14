package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbx extends zzag<Void> {
    private final /* synthetic */ Snapshot zzeh;

    zzbx(SnapshotsClient snapshotsClient, Snapshot snapshot) {
        this.zzeh = snapshot;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zze.zza(this.zzeh);
        taskCompletionSource.setResult(null);
    }
}
