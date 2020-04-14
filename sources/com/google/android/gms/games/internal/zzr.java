package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;

final class zzr extends zzat<CaptureAvailableResult> {
    zzr(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zza(int i, boolean z) {
        setResult(new zzd(new Status(i), z));
    }
}
