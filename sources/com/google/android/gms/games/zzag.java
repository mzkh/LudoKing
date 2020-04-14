package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzag extends com.google.android.gms.internal.games.zzag<Intent> {
    private final /* synthetic */ String zzbr;

    zzag(LeaderboardsClient leaderboardsClient, String str) {
        this.zzbr = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zza(this.zzbr, -1, -1));
    }
}
