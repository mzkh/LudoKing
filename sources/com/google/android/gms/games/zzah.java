package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzah extends zzag<Intent> {
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ int zzbs;

    zzah(LeaderboardsClient leaderboardsClient, String str, int i) {
        this.zzbr = str;
        this.zzbs = i;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zza(this.zzbr, this.zzbs, -1));
    }
}
