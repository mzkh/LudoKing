package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbj implements StatusListener {
    private final TaskCompletionSource zzji;
    private final ResultConverter zzjj;
    private final PendingResult zzjq;
    private final zzbn zzjr;

    zzbj(zzbn zzbn, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter) {
        this.zzjr = zzbn;
        this.zzjq = pendingResult;
        this.zzji = taskCompletionSource;
        this.zzjj = resultConverter;
    }

    public final void onComplete(Status status) {
        zzbe.zza(this.zzjr, this.zzjq, this.zzji, this.zzjj, status);
    }
}
