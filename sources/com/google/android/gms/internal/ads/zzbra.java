package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzbra implements zzbrb {
    private final List<String> zzdks;
    private final zzcyp zzfbe;
    private boolean zzfic;

    public zzbra(zzcvr zzcvr, zzcyp zzcyp) {
        this.zzdks = zzcvr.zzdks;
        this.zzfbe = zzcyp;
    }

    public final void zzagq() {
        if (!this.zzfic) {
            this.zzfbe.zzi(this.zzdks);
            this.zzfic = true;
        }
    }
}
