package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.os.Handler;
import androidx.annotation.NonNull;

@TargetApi(23)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzor implements OnFrameRenderedListener {
    private final /* synthetic */ zzoq zzbin;

    private zzor(zzoq zzoq, MediaCodec mediaCodec) {
        this.zzbin = zzoq;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
        if (this == this.zzbin.zzbik) {
            this.zzbin.zziv();
        }
    }
}
