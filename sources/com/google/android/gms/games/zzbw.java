package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbw extends zzag<Intent> {
    private final /* synthetic */ String zzed;
    private final /* synthetic */ boolean zzee;
    private final /* synthetic */ boolean zzef;
    private final /* synthetic */ int zzeg;

    zzbw(SnapshotsClient snapshotsClient, String str, boolean z, boolean z2, int i) {
        this.zzed = str;
        this.zzee = z;
        this.zzef = z2;
        this.zzeg = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zza(this.zzed, this.zzee, this.zzef, this.zzeg));
    }
}
