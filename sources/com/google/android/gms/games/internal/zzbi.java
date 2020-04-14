package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbi implements StatusListener {
    private final TaskCompletionSource zzji;
    private final ResultConverter zzjp;
    private final PendingResult zzjq;

    zzbi(ResultConverter resultConverter, PendingResult pendingResult, TaskCompletionSource taskCompletionSource) {
        this.zzjp = resultConverter;
        this.zzjq = pendingResult;
        this.zzji = taskCompletionSource;
    }

    public final void onComplete(Status status) {
        zzbe.zza(this.zzjp, this.zzjq, this.zzji, status);
    }
}
