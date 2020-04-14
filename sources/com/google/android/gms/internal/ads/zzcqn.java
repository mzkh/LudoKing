package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqn implements zzdwb<zzcql> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<Set<String>> zzgeh;

    private zzcqn(zzdwo<zzddl> zzdwo, zzdwo<Context> zzdwo2, zzdwo<Set<String>> zzdwo3) {
        this.zzfck = zzdwo;
        this.zzejy = zzdwo2;
        this.zzgeh = zzdwo3;
    }

    public static zzcqn zzp(zzdwo<zzddl> zzdwo, zzdwo<Context> zzdwo2, zzdwo<Set<String>> zzdwo3) {
        return new zzcqn(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return new zzcql((zzddl) this.zzfck.get(), (Context) this.zzejy.get(), (Set) this.zzgeh.get());
    }
}
