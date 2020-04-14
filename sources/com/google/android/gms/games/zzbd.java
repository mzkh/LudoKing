package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbd extends zzag<Void> {
    private final /* synthetic */ byte[] zzdh;
    private final /* synthetic */ String zzdi;

    zzbd(RealTimeMultiplayerClient realTimeMultiplayerClient, byte[] bArr, String str) {
        this.zzdh = bArr;
        this.zzdi = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        if (zze.zza(this.zzdh, this.zzdi) == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        }
    }
}
