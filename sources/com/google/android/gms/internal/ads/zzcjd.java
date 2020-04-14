package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbmk.zza;

/* compiled from: com.google.android.gms:play-services-ads@@18.2.0 */
public final class zzcjd extends zzciw<zzbyz> {
    private final zzbpn zzerr;
    private final zzbei zzfza;
    private final zza zzfzb;

    public zzcjd(zzbei zzbei, zza zza, zzbpn zzbpn) {
        this.zzfza = zzbei;
        this.zzfzb = zza;
        this.zzerr = zzbpn;
    }

    /* access modifiers changed from: protected */
    public final zzddi<zzbyz> zza(zzcwe zzcwe, Bundle bundle) {
        return this.zzfza.zzabm().zze(this.zzfzb.zza(zzcwe).zze(bundle).zzafy()).zze(this.zzerr).zzadn().zzaca().zzafs();
    }
}
