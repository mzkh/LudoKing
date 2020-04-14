package com.google.android.gms.games;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzai extends zzag<Intent> {
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ int zzbs;
    private final /* synthetic */ int zzbt;

    zzai(LeaderboardsClient leaderboardsClient, String str, int i, int i2) {
        this.zzbr = str;
        this.zzbs = i;
        this.zzbt = i2;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Intent> taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(zze.zza(this.zzbr, this.zzbs, this.zzbt));
    }
}
