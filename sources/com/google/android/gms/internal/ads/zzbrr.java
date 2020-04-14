package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbrr implements zzdwb<zzbrl> {
    private final zzdwo<Set<zzbqs<VideoLifecycleCallbacks>>> zzfed;

    private zzbrr(zzdwo<Set<zzbqs<VideoLifecycleCallbacks>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbrr zzt(zzdwo<Set<zzbqs<VideoLifecycleCallbacks>>> zzdwo) {
        return new zzbrr(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbrl((Set) this.zzfed.get());
    }
}
