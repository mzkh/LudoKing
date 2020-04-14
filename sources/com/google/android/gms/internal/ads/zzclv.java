package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzclv implements zzdwb<zzclr> {
    private final zzdwo<Executor> zzfck;

    public zzclv(zzdwo<Executor> zzdwo) {
        this.zzfck = zzdwo;
    }

    public final /* synthetic */ Object get() {
        return new zzclr((Executor) this.zzfck.get());
    }
}
