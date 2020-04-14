package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.games.internal.zza;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbh extends zza {
    private final /* synthetic */ TaskCompletionSource zzdm;

    zzbh(zzbg zzbg, TaskCompletionSource taskCompletionSource) {
        this.zzdm = taskCompletionSource;
    }

    public final void onLeftRoom(int i, String str) {
        TaskUtil.setResultOrApiException(GamesClientStatusCodes.zza(GamesClientStatusCodes.zzb(i)), str, this.zzdm);
    }
}
