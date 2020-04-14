package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzctm implements zzdwb<zzctk> {
    private final zzdwo<zzajk> zzeqj;
    private final zzdwo<ScheduledExecutorService> zzfoz;
    private final zzdwo<ApplicationInfo> zzfuk;
    private final zzdwo<Boolean> zzghn;

    public zzctm(zzdwo<zzajk> zzdwo, zzdwo<ScheduledExecutorService> zzdwo2, zzdwo<Boolean> zzdwo3, zzdwo<ApplicationInfo> zzdwo4) {
        this.zzeqj = zzdwo;
        this.zzfoz = zzdwo2;
        this.zzghn = zzdwo3;
        this.zzfuk = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzctk((zzajk) this.zzeqj.get(), (ScheduledExecutorService) this.zzfoz.get(), ((Boolean) this.zzghn.get()).booleanValue(), (ApplicationInfo) this.zzfuk.get());
    }
}
