package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
final class zzkv implements zzks {
    private zzkv() {
    }

    public final boolean zzgx() {
        return false;
    }

    public final int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo getCodecInfoAt(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public final boolean zza(String str, CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
