package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqr implements zzdwb<zzcqs> {
    private final zzdwo<PackageInfo> zzfuf;
    private final zzdwo<ApplicationInfo> zzfuk;

    private zzcqr(zzdwo<ApplicationInfo> zzdwo, zzdwo<PackageInfo> zzdwo2) {
        this.zzfuk = zzdwo;
        this.zzfuf = zzdwo2;
    }

    public static zzcqr zzaq(zzdwo<ApplicationInfo> zzdwo, zzdwo<PackageInfo> zzdwo2) {
        return new zzcqr(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcqs((ApplicationInfo) this.zzfuk.get(), (PackageInfo) this.zzfuf.get());
    }
}
