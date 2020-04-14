package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbf implements StatusListener {
    private final PendingResult zzjg;
    private final zzbn zzjh;
    private final TaskCompletionSource zzji;
    private final ResultConverter zzjj;
    private final ResultConverter zzjk;
    private final zzbl zzjl;

    zzbf(PendingResult pendingResult, zzbn zzbn, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter, ResultConverter resultConverter2, zzbl zzbl) {
        this.zzjg = pendingResult;
        this.zzjh = zzbn;
        this.zzji = taskCompletionSource;
        this.zzjj = resultConverter;
        this.zzjk = resultConverter2;
        this.zzjl = zzbl;
    }

    public final void onComplete(Status status) {
        zzbe.zza(this.zzjg, this.zzjh, this.zzji, this.zzjj, this.zzjk, this.zzjl, status);
    }
}
