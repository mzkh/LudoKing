package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcwt implements zzdwb<zzcwu> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzatz> zzelw;

    private zzcwt(zzdwo<Context> zzdwo, zzdwo<zzatz> zzdwo2) {
        this.zzejy = zzdwo;
        this.zzelw = zzdwo2;
    }

    public static zzcwt zzav(zzdwo<Context> zzdwo, zzdwo<zzatz> zzdwo2) {
        return new zzcwt(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcwu((Context) this.zzejy.get(), (zzatz) this.zzelw.get());
    }
}
