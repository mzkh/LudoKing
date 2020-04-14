package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdp implements zzdwb<String> {
    private final zzdwo<Context> zzejy;

    private zzcdp(zzdwo<Context> zzdwo) {
        this.zzejy = zzdwo;
    }

    public static zzcdp zzab(zzdwo<Context> zzdwo) {
        return new zzcdp(zzdwo);
    }

    public final /* synthetic */ Object get() {
        return (String) zzdwh.zza(((Context) this.zzejy.get()).getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
