package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbg implements StatusListener {
    private final PendingResult zzjg;
    private final TaskCompletionSource zzjm;
    private final ResultConverter zzjn;

    zzbg(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter) {
        this.zzjg = pendingResult;
        this.zzjm = taskCompletionSource;
        this.zzjn = resultConverter;
    }

    public final void onComplete(Status status) {
        zzbe.zza(this.zzjg, this.zzjm, this.zzjn, status);
    }
}
