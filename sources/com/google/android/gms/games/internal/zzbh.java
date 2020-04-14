package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzbh implements StatusListener {
    private final PendingResult zzjg;
    private final TaskCompletionSource zzjm;
    private final ResultConverter zzjn;
    private final zzbm zzjo;

    zzbh(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter, zzbm zzbm) {
        this.zzjg = pendingResult;
        this.zzjm = taskCompletionSource;
        this.zzjn = resultConverter;
        this.zzjo = zzbm;
    }

    public final void onComplete(Status status) {
        zzbe.zza(this.zzjg, this.zzjm, this.zzjn, this.zzjo, status);
    }
}
