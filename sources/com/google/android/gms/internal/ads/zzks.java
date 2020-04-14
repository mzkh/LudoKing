package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
interface zzks {
    int getCodecCount();

    MediaCodecInfo getCodecInfoAt(int i);

    boolean zza(String str, CodecCapabilities codecCapabilities);

    boolean zzgx();
}
