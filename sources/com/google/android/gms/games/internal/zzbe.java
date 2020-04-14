package com.google.android.gms.games.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

public final class zzbe {
    private static final zzbn zzjf = zzbk.zzjs;

    @NonNull
    public static <R, PendingR extends Result, ExceptionData> Task<R> zza(@NonNull PendingResult<PendingR> pendingResult, @NonNull zzbn zzbn, @NonNull ResultConverter<PendingR, R> resultConverter, @NonNull ResultConverter<PendingR, ExceptionData> resultConverter2, @NonNull zzbl<ExceptionData> zzbl) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzbf zzbf = new zzbf(pendingResult, zzbn, taskCompletionSource, resultConverter, resultConverter2, zzbl);
        pendingResult.addStatusListener(zzbf);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public static <R, PendingR extends Result> Task<R> toTask(@NonNull PendingResult<PendingR> pendingResult, @NonNull ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzbg(pendingResult, taskCompletionSource, resultConverter));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public static <R, PendingR extends Result> Task<AnnotatedData<R>> zza(@NonNull PendingResult<PendingR> pendingResult, @NonNull ResultConverter<PendingR, R> resultConverter, @Nullable zzbm<PendingR> zzbm) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzbh(pendingResult, taskCompletionSource, resultConverter, zzbm));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public static <R, PendingR extends Result> Task<AnnotatedData<R>> zza(@NonNull PendingResult<PendingR> pendingResult, @NonNull ResultConverter<PendingR, R> resultConverter) {
        return zza(pendingResult, resultConverter, null);
    }

    @NonNull
    public static <R extends Releasable, PendingR extends Result> Task<AnnotatedData<R>> zzb(@NonNull PendingResult<PendingR> pendingResult, @NonNull ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzbi(resultConverter, pendingResult, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public static <R, PendingR extends Result> Task<R> zza(@NonNull PendingResult<PendingR> pendingResult, @NonNull zzbn zzbn, @NonNull ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzbj(zzbn, pendingResult, taskCompletionSource, resultConverter));
        return taskCompletionSource.getTask();
    }

    static final /* synthetic */ void zza(zzbn zzbn, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter, Status status) {
        if (zzbn.zza(status)) {
            taskCompletionSource.setResult(resultConverter.convert(pendingResult.await(0, TimeUnit.MILLISECONDS)));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
        }
    }

    static final /* synthetic */ void zza(ResultConverter resultConverter, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, Status status) {
        boolean z = status.getStatusCode() == 3;
        Releasable releasable = (Releasable) resultConverter.convert(pendingResult.await(0, TimeUnit.MILLISECONDS));
        if (status.isSuccess() || z) {
            taskCompletionSource.setResult(new AnnotatedData(releasable, z));
            return;
        }
        if (releasable != null) {
            releasable.release();
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
    }

    static final /* synthetic */ void zza(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter, zzbm zzbm, Status status) {
        boolean z = status.getStatusCode() == 3;
        Result await = pendingResult.await(0, TimeUnit.MILLISECONDS);
        if (status.isSuccess() || z) {
            taskCompletionSource.setResult(new AnnotatedData(resultConverter.convert(await), z));
            return;
        }
        if (!(await == null || zzbm == null)) {
            zzbm.release(await);
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
    }

    static final /* synthetic */ void zza(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter, Status status) {
        Result await = pendingResult.await(0, TimeUnit.MILLISECONDS);
        if (status.isSuccess()) {
            taskCompletionSource.setResult(resultConverter.convert(await));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
        }
    }

    static final /* synthetic */ void zza(PendingResult pendingResult, zzbn zzbn, TaskCompletionSource taskCompletionSource, ResultConverter resultConverter, ResultConverter resultConverter2, zzbl zzbl, Status status) {
        Result await = pendingResult.await(0, TimeUnit.MILLISECONDS);
        if (zzbn.zza(status)) {
            taskCompletionSource.setResult(resultConverter.convert(await));
            return;
        }
        Object convert = resultConverter2.convert(await);
        if (convert != null) {
            taskCompletionSource.setException(zzbl.zza(GamesClientStatusCodes.zzb(status), convert));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zzb(status)));
        }
    }
}
