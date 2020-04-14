package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdk implements zzdwb<ApplicationInfo> {
    private final zzdwo<Context> zzejy;

    private zzcdk(zzdwo<Context> zzdwo) {
        this.zzejy = zzdwo;
    }

    public static zzcdk zzaa(zzdwo<Context> zzdwo) {
        return new zzcdk(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (ApplicationInfo) zzdwh.zza(((Context) this.zzejy.get()).getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
