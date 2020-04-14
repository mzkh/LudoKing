package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbo extends zzag<Void> {
    final /* synthetic */ zzbn zzdt;

    zzbo(zzbn zzbn) {
        this.zzdt = zzbn;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.zzdt.zzdr.notifyListener(new zzbp(this));
        taskCompletionSource.setResult(null);
    }
}
