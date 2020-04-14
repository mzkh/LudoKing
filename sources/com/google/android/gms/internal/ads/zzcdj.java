package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcdj implements zzdwb<zzddi<String>> {
    private final zzdwo<Context> zzejy;
    private final zzdwo<zzdf> zzfui;
    private final zzdwo<zzddl> zzfuj;

    private zzcdj(zzdwo<zzdf> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzddl> zzdwo3) {
        this.zzfui = zzdwo;
        this.zzejy = zzdwo2;
        this.zzfuj = zzdwo3;
    }

    public static zzcdj zzn(zzdwo<zzdf> zzdwo, zzdwo<Context> zzdwo2, zzdwo<zzddl> zzdwo3) {
        return new zzcdj(zzdwo, zzdwo2, zzdwo3);
    }

    public final /* synthetic */ Object get() {
        return (zzddi) zzdwh.zza(((zzddl) this.zzfuj.get()).zzd(new zzcdf((zzdf) this.zzfui.get(), (Context) this.zzejy.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
