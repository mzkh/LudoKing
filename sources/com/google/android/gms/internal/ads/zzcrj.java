package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcrj implements zzdwb<zzcrh> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzasl> zzfaq;
    private final zzdwo<zzddl> zzfck;

    private zzcrj(zzdwo<zzasl> zzdwo, zzdwo<zzddl> zzdwo2, zzdwo<Context> zzdwo3) {
        this.zzfaq = zzdwo;
        this.zzfck = zzdwo2;
        this.zzejy = zzdwo3;
    }

    public static zzcrj zzq(zzdwo<zzasl> zzdwo, zzdwo<zzddl> zzdwo2, zzdwo<Context> zzdwo3) {
        return new zzcrj(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzcrh((zzasl) this.zzfaq.get(), (zzddl) this.zzfck.get(), (Context) this.zzejy.get());
    }
}
