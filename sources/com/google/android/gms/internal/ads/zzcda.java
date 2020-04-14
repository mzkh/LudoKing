package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcda {
    @Nullable
    public static PackageInfo zza(Context context, ApplicationInfo applicationInfo) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }
}
