package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbph implements zzdwb<zzbpf> {
    private final zzdwo<Set<zzbqs<AppEventListener>>> zzfed;

    private zzbph(zzdwo<Set<zzbqs<AppEventListener>>> zzdwo) {
        this.zzfed = zzdwo;
    }

    public static zzbph zzp(zzdwo<Set<zzbqs<AppEventListener>>> zzdwo) {
        return new zzbph(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return new zzbpf((Set) this.zzfed.get());
    }
}
