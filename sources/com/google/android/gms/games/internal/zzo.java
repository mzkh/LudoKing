package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;

final class zzo extends zzat<CaptureCapabilitiesResult> {
    zzo(ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zza(int i, VideoCapabilities videoCapabilities) {
        setResult(new C3498zze(new Status(i), videoCapabilities));
    }
}
