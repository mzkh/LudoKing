package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.internal.games.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbr extends zzag<Integer> {
    private final /* synthetic */ byte[] zzdh;
    private final /* synthetic */ String zzdi;
    private final /* synthetic */ String zzdj;
    private final /* synthetic */ ListenerHolder zzdv;

    zzbr(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, byte[] bArr, String str, String str2) {
        this.zzdv = listenerHolder;
        this.zzdh = bArr;
        this.zzdi = str;
        this.zzdj = str2;
    }

    /* access modifiers changed from: protected */
    public final void zza(zze zze, TaskCompletionSource<Integer> taskCompletionSource) throws RemoteException {
        Integer valueOf = Integer.valueOf(zze.zza(this.zzdv, this.zzdh, this.zzdi, this.zzdj));
        if (valueOf.intValue() == -1) {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        } else {
            taskCompletionSource.setResult(valueOf);
        }
    }
}
