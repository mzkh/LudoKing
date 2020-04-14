package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos.CaptureStateResult;

final class zzq extends zzat<CaptureStateResult> {
    zzq(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zze(int i, Bundle bundle) {
        setResult(new zzf(new Status(i), CaptureState.zzb(bundle)));
    }
}
