package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbas implements zzbbf {
    public final zzbax zza(zzazj zzazj, int i, String str, zzazk zzazk) {
        if (VERSION.SDK_INT < 16 || i <= 0 || !Arrays.asList(zzazk.zzeam.split(",")).contains(ExifInterface.GPS_MEASUREMENT_3D)) {
            return new zzbbi(zzazj);
        }
        int zzyq = zzbag.zzyq();
        if (zzyq < zzazk.zzeap) {
            return new zzbbm(zzazj, zzazk);
        }
        if (zzyq < zzazk.zzeaj) {
            return new zzbbj(zzazj, zzazk);
        }
        return new zzbbh(zzazj);
    }
}
