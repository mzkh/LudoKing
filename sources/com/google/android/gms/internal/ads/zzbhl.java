package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbhl implements zzdwb<zzbhi> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzpe> zzfcc;

    private zzbhl(zzdwo<Context> zzdwo, zzdwo<zzpe> zzdwo2) {
        this.zzejy = zzdwo;
        this.zzfcc = zzdwo2;
    }

    public static zzbhl zza(zzdwo<Context> zzdwo, zzdwo<zzpe> zzdwo2) {
        return new zzbhl(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzbhi((Context) this.zzejy.get(), (zzpe) this.zzfcc.get());
    }
}
