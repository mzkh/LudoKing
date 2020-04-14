package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdi implements zzdwb<zzddi<String>> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzcyg> zzfek;

    private zzcdi(zzdwo<zzcyg> zzdwo, zzdwo<Context> zzdwo2) {
        this.zzfek = zzdwo;
        this.zzejy = zzdwo2;
    }

    public static zzcdi zzab(zzdwo<zzcyg> zzdwo, zzdwo<Context> zzdwo2) {
        return new zzcdi(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return (zzddi) zzdwh.zza(((zzcyg) this.zzfek.get()).zzu(zzcyd.WEBVIEW_COOKIE).zzc(new zzcdd((Context) this.zzejy.get())).zza(1, TimeUnit.SECONDS).zza(Exception.class, zzcdc.zzftu).zzant(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
