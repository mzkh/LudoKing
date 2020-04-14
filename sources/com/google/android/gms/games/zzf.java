package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzf extends zzag<Void> {
    private final /* synthetic */ String zzk;
    private final /* synthetic */ int zzl;

    zzf(EventsClient eventsClient, String str, int i) {
        this.zzk = str;
        this.zzl = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zze.zza(this.zzk, this.zzl);
    }
}
