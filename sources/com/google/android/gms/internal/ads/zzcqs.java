package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqs implements zzcrr<Bundle>, zzcru<zzcrr<Bundle>> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdiv;

    zzcqs(ApplicationInfo applicationInfo2, @Nullable PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo2;
        this.zzdiv = packageInfo;
    }

    public final zzddi<zzcrr<Bundle>> zzalv() {
        return zzdcy.zzah(this);
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdiv;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle.putString("pn", str);
        if (valueOf != null) {
            bundle.putInt("vc", valueOf.intValue());
        }
    }
}
