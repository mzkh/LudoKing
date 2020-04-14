package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdm implements zzdwb<PackageInfo> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<ApplicationInfo> zzfuk;

    private zzcdm(zzdwo<Context> zzdwo, zzdwo<ApplicationInfo> zzdwo2) {
        this.zzejy = zzdwo;
        this.zzfuk = zzdwo2;
    }

    public static zzcdm zzad(zzdwo<Context> zzdwo, zzdwo<ApplicationInfo> zzdwo2) {
        return new zzcdm(zzdwo, zzdwo2);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        return zzcda.zza((Context) this.zzejy.get(), (ApplicationInfo) this.zzfuk.get());
    }
}
