package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzzs {
    public static boolean zza(@Nullable zzaab zzaab, @Nullable zzzz zzzz, String... strArr) {
        if (zzaab == null || zzzz == null || !zzaab.zzcut || zzzz == null) {
            return false;
        }
        return zzaab.zza(zzzz, zzq.zzkq().elapsedRealtime(), strArr);
    }

    @Nullable
    public static zzzz zzb(@Nullable zzaab zzaab) {
        if (zzaab == null) {
            return null;
        }
        return zzaab.zzer(zzq.zzkq().elapsedRealtime());
    }
}
