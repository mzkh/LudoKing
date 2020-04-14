package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbjs implements zzdwb<Boolean> {
    private final zzdwo<zzcwe> zzfef;

    public zzbjs(zzdwo<zzcwe> zzdwo) {
        this.zzfef = zzdwo;
    }

    public final /* synthetic */ Object get() {
        boolean z;
        if (((zzcwe) this.zzfef.get()).zzana() != null) {
            z = ((Boolean) zzuv.zzon().zzd(zzza.zzclc)).booleanValue();
        } else {
            z = ((Boolean) zzuv.zzon().zzd(zzza.zzcrt)).booleanValue();
        }
        return Boolean.valueOf(z);
    }
}
