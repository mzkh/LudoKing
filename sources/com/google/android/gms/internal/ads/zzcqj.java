package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcqj implements zzdwb<zzcqg> {
    private final zzdwo<zzaui> zzemh;
    private final zzdwo<zzddl> zzfck;
    private final zzdwo<zzcwe> zzfef;
    private final zzdwo<PackageInfo> zzfuf;

    public zzcqj(zzdwo<zzddl> zzdwo, zzdwo<zzcwe> zzdwo2, zzdwo<PackageInfo> zzdwo3, zzdwo<zzaui> zzdwo4) {
        this.zzfck = zzdwo;
        this.zzfef = zzdwo2;
        this.zzfuf = zzdwo3;
        this.zzemh = zzdwo4;
    }

    public final /* synthetic */ Object get() {
        return new zzcqg((zzddl) this.zzfck.get(), (zzcwe) this.zzfef.get(), (PackageInfo) this.zzfuf.get(), (zzaui) this.zzemh.get());
    }
}
