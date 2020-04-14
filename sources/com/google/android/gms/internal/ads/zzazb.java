package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzazb extends zzayt {
    @Nullable
    public final zzayu zza(Context context, zzazj zzazj, int i, boolean z, zzaab zzaab, zzazk zzazk) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        boolean z2 = true;
        if (!(PlatformVersion.isAtLeastIceCreamSandwich() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11))) {
            return null;
        }
        zzazm zzazm = new zzazm(context, zzazj.zzxr(), zzazj.zzxp(), zzaab, zzazj.zzxm());
        if (VERSION.SDK_INT < 16 || i != 2) {
            z2 = false;
        }
        if (!z2) {
            zzazk zzazk2 = zzazk;
        } else if (Arrays.asList(zzazk.zzeam.split(",")).contains(ExifInterface.GPS_MEASUREMENT_3D)) {
            zzazq zzazq = new zzazq(context, zzazm, zzazj, z, zza(zzazj), zzazk);
            return zzazq;
        }
        boolean zza = zza(zzazj);
        zzazm zzazm2 = new zzazm(context, zzazj.zzxr(), zzazj.zzxp(), zzaab, zzazj.zzxm());
        zzayh zzayh = new zzayh(context, z, zza, zzazk, zzazm2);
        return zzayh;
    }
}
