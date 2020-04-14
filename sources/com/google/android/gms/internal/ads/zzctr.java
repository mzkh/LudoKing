package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctr implements zzdwb<ApplicationInfo> {
    private final zzctp zzghp;

    public zzctr(zzctp zzctp) {
        this.zzghp = zzctp;
    }

    public static ApplicationInfo zzb(zzctp zzctp) {
        return (ApplicationInfo) zzdwh.zza(zzctp.zzamq(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzghp);
    }
}
