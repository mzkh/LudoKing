package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzku implements zzks {
    private final int zzazl;
    private MediaCodecInfo[] zzazm;

    public zzku(boolean z) {
        this.zzazl = z ? 1 : 0;
    }

    public final boolean zzgx() {
        return true;
    }

    public final int getCodecCount() {
        zzgy();
        return this.zzazm.length;
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzgy();
        return this.zzazm[i];
    }

    public final boolean zza(String str, CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void zzgy() {
        if (this.zzazm == null) {
            this.zzazm = new MediaCodecList(this.zzazl).getCodecInfos();
        }
    }
}
