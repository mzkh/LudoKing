package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzak extends zzag<Void> {
    private final /* synthetic */ String zzbr;
    private final /* synthetic */ long zzbu;
    private final /* synthetic */ String zzbv;

    zzak(LeaderboardsClient leaderboardsClient, String str, long j, String str2) {
        this.zzbr = str;
        this.zzbu = j;
        this.zzbv = str2;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zze.zza(null, this.zzbr, this.zzbu, this.zzbv);
    }
}
