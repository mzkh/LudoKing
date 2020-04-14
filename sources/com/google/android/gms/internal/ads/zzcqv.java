package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqv implements zzdwb<zzcqt> {
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<Bundle> zzgfo;

    private zzcqv(zzdwo<zzddl> zzdwo, zzdwo<Bundle> zzdwo2) {
        this.zzfck = zzdwo;
        this.zzgfo = zzdwo2;
    }

    public static zzcqv zzar(zzdwo<zzddl> zzdwo, zzdwo<Bundle> zzdwo2) {
        return new zzcqv(zzdwo, zzdwo2);
    }

    public final /* synthetic */ Object get() {
        return new zzcqt((zzddl) this.zzfck.get(), (Bundle) this.zzgfo.get());
    }
}
